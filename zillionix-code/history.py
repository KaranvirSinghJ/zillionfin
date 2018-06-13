#!/usr/bin/env python

import zillionix
import pandas_datareader.data as pdr
from datetime import datetime
import time
from dateutil import relativedelta
from sqlalchemy import create_engine
import MySQLdb
import sys
import fix_yahoo_finance as yf
yf.pdr_override()
engine = create_engine(zillionix.MYSQL_CON)
fname='ticker_list.txt'
def get_price(i, symbole):
    start = datetime.now() + relativedelta.relativedelta(months=-6)
    end = datetime.now()
    ticker = pdr.get_data_yahoo(symbole , start , end)
    ticker['tickt']=symbole
    ticker['updated_at']=time.strftime('%Y-%m-%d %H:%M:%S')
    ticker.to_sql(name='daily_stock',con=engine,if_exists='append')
    #file_path = 'stock/stock_data.csv'
    #ticker.to_csv(file_path)

def all_data():
    i = 0
    with open(fname) as f:
        ticker_list = f.read().splitlines()   
        for ticker in ticker_list:         
            get_price(i, ticker)
            i = i +1
#update the process table
def update_process_table(status, id):
    conn = MySQLdb.connect(host= zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("UPDATE `process_log` SET `status` = '"+ status +"' WHERE `process_log`.`process_id` = '"+ str(id) +"'")
       conn.commit()
    except:
       conn.rollback()
    conn.close()
#insert data in process table
def insert_process_table(status):
    conn = MySQLdb.connect(host = zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       print zillionix.HOST_NAME
       x.execute("INSERT INTO `process_log` (`Name`, `status`, `updated_at`) VALUES ('Full', '"+ status +"', CURRENT_TIMESTAMP)")
       conn.commit()
       return x.lastrowid
    except:
       conn.rollback()
    conn.close()
save_out = sys.stdout
# Define the log file
f = "log/syslog.log"
# Change 'a' to 'w' to recreate the log file each time.
fsock = open(f, 'a+')
# Set stream to file
sys.stdout = fsock
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
