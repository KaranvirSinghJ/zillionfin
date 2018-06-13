#!/usr/bin/env python
import zillionix
import pandas_datareader.data as pdr
import fix_yahoo_finance as yf
import time
from datetime import date
yf.pdr_override() # <== that's all it takes :-)
from datetime import datetime
from sqlalchemy import create_engine
import MySQLdb
import sys
engine = create_engine(zillionix.MYSQL_CON)
fname='ticker_list.txt'
def get_price(i, symbole):
    start = datetime.now()
    end = datetime.now()
    ticker = pdr.get_data_yahoo(symbole , start , end)
    ticker['tickt']=symbole
    ticker['updated_at']=time.strftime('%Y-%m-%d %H:%M:%S')
    ticker.to_sql(name='daily_stock',con=engine,if_exists='append')
    #file_path = 'stock/inc/stock_data.csv'
    #ticker.to_csv(file_path)

def all_data():
    i = 0
    with open(fname) as f:
        ticker_list = f.read().splitlines()   
        for ticker in ticker_list:
            # check daily run should not run more than one time 
            flag_start = getdate(ticker)
            #print flag_start
            if flag_start == "yes":      
                print "Running" 
                get_price(i, ticker)
            i = i +1
#update the process table
def update_process_table(status, id):
    conn = MySQLdb.connect(host=zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("UPDATE `process_log` SET `status` = '"+ status +"' WHERE `process_log`.`process_id` = '"+ str(id) +"'")
       conn.commit()
    except:
       conn.rollback()
    conn.close()
#insert data in process table
def insert_process_table(status):
    conn = MySQLdb.connect(host=zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("INSERT INTO `process_log` (`Name`, `status`, `updated_at`) VALUES ('INC', '"+ status +"', CURRENT_TIMESTAMP)")
       conn.commit()
       return x.lastrowid
    except:
       conn.rollback()
    conn.close()

def getdate(symbole):
    conn = MySQLdb.connect(host=zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("select date(date) from stock.daily_stock WHERE ID = (SELECT MAX(ID) FROM stock.daily_stock where tickt='"+ symbole +"')")
       row = x.fetchone()
       todate = date.today()
       if todate != row[0]:
           return "Yes"
       conn.commit()
    except:
       conn.rollback()
    conn.close()
def check_history_done():
    conn = MySQLdb.connect(host=zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("select status from stock.process_log WHERE process_id = (SELECT MAX(process_id) FROM stock.process_log)")
       row = x.fetchone()
       conn.commit()
       return row[0]
    except: 
       conn.rollback()
    conn.close()
#save to log
save_out = sys.stdout
# Define the log file
f = "/home/cloudera/zillionix-code/log/syslog.log"
# Change 'a' to 'w' to recreate the log file each time.
fsock = open(f, 'a+')
# Set stream to file
sys.stdout = fsock
#check that history.py has been completed 
start_flag= check_history_done()
print "Status ......."+start_flag
if start_flag=="load_completed":
    print 'Updating Process Table....'
    processId = insert_process_table('load_running')
    print 'Downloading data for process id ' + str(processId)
    all_data()
    print 'Finished downloading data'
    update_process_table('load_completed', processId)
    print 'Updated Process Table with process id ' + str(processId)
sys.stdout = save_out
fsock.close()
print "File excuted successfully ... for more logs check "+ f
