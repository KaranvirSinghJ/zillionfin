# Load the necessary packages and modules
from pandas_datareader import data as pdr
import fix_yahoo_finance
import pandas as pd
from pyspark import SparkConf
from pyspark import SparkContext
from pyspark import SQLContext
from pyspark.sql import HiveContext
from pyspark.sql import Row
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, DateType , DoubleType
from pyspark.sql import Window
from pyspark.sql.functions import mean
from pyspark import sql
import sys
HDFS_MASTER = 'quickstart.cloudera'

conf = SparkConf()
#conf.setMaster('yarn-client')
conf.setAppName('Zillionix')
conf.set('spark.executor.instances', 10)
sc = SparkContext(conf=conf)
APP_NAME='Zillionix'
fname='ticker_list.txt'
# Simple Moving Average 
def derived_table(data, ndays):
    df = data.toPandas()
    df['SMA'] = df['close'].rolling(window=ndays,center=False).mean()
    df['EWMA'] = pd.ewma(df['close'],span= ndays, halflife=None, min_periods=ndays -1)
    return df
# Exponentially-weighted Moving Average 
def EWMA(data, ndays):
    data = data.toPandas() 
    data['EMA'] = pd.ewma(data['close'],span= ndays, halflife=None, min_periods=ndays -1)
    print data.head()
    return data
def HiveDF(ticker):
    "This creates a new DF from the hive table"
    hc = HiveContext(sc)
    hc.sql("show databases").show()
    query = "select * from stock.daily_stock where tickt ='"+ ticker+"'"
    df = hc.sql(query)    
    df.printSchema()
    df.show(5)
    return df

def dfSave(df2, table_name):
    "This is a function to save the DF"  
    print type(df2)
    hc = HiveContext(sc)
    df2 = hc.createDataFrame(df2)
    print df2
    #df2.write.saveAsTable(table_name);
    df2.write.saveAsTable(table_name, format='parquet', mode='overwrite')
def createDataFrame():
    with open(fname) as f:
        ticker_list = f.read().splitlines()
        i=0
        n=50
        ew=200
        DataFrame_SMA=pd.DataFrame();
        DataFrame_EWMA=pd.DataFrame();
        for ticker in ticker_list:
            data=HiveDF(ticker) 
            if i==0:     
                SMA_EWMA_DF = derived_table(data,n)
                DataFrame_FINAL= SMA_EWMA_DF
            else:
                SMA_EWMA_DF = derived_table(data, n)
                DataFrame_FINAL=pd.concat([DataFrame_FINAL, SMA_EWMA_DF])
            i=i+1
    dfSave(DataFrame_FINAL, "stock.`daily_derived`")                
save_out = sys.stdout
# Define the log file
f = "/home/cloudera/zillionix-code/log/syslog.log"
# Change 'a' to 'w' to recreate the log file each time.
fsock = open(f, 'a+')
# Set stream to file
sys.stdout = fsock
createDataFrame() 
sys.stdout = save_out
fsock.close()               
