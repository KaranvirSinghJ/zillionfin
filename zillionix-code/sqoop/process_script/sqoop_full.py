#!/usr/bin/env python
import zillionix
import time
from datetime import date
from datetime import datetime
from sqlalchemy import create_engine
import MySQLdb
import sys
import os
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
def check_process_log():
    conn = MySQLdb.connect(host=zillionix.HOST_NAME, user=zillionix.DATABASE_USER,  passwd=zillionix.DATABASE_PASSWORD, db="stock")
    x = conn.cursor()
    try:
       x.execute("select status, process_id from stock.process_log WHERE process_id = (SELECT MAX(process_id) FROM stock.process_log)")
       row = x.fetchone()
       print row[1]
       conn.commit()
       return row[0], row[1]
    except: 
       conn.rollback()
    conn.close()


save_out = sys.stdout
# Define the log file
f = "../../log/syslog.log"
# Change 'a' to 'w' to recreate the log file each time.
fsock = open(f, 'a+')
# Set stream to file
sys.stdout = fsock
#check that history.py has been completed 
start_flag, processId = check_process_log()
print "Status ......."+start_flag+ "for process  -- " + str(processId)
if start_flag=="load_completed":
    print 'Updating Process Table....'
    update_process_table('sqoop_running', str(processId))
    print 'Ingestion data for process id ' + str(processId)
    os.system("hadoop fs -rm -r hdfs://quickstart.cloudera:8020/user/cloudera/stocksData/daily_stock")
    os.system('sqoop job --exec history_job')
    print 'Finished ingestion...'
    update_process_table('sqoop_completed', processId)
    print 'Updated Process Table with process id ' + str(processId)

sys.stdout = save_out
fsock.close()
print "File excuted successfully ... for more logs check "+ f
