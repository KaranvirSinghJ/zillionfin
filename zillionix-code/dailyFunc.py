from pyspark import SparkConf
from pyspark import SparkContext
from pyspark import SQLContext
from pyspark.sql import HiveContext
from pyspark.sql import Row
from pyspark.sql.types import StructType, StructField, IntegerType, StringType, DateType
from pyspark.sql import Window
from pyspark.sql.functions import mean

HDFS_MASTER = 'quickstart.cloudera'

conf = SparkConf()
conf.setMaster('yarn-client')
conf.setAppName('spark-wordcount')
conf.set('spark.executor.instances', 10)
sc = SparkContext(conf=conf)
#sc2 = new SQLContext(sc); 

def dfSave(df2):
  "This is a function to save the DF"
  df2.show()
  df2.repartition(1).write.format("csv").save("/user/cloudera/stocksData/daily_derived");

def createDF(hdfsFile, schema):
  "This creates a new DF from the input hdfs files"
  sqlContext = SQLContext(sc)
  hsc = HiveContext(sc)
  df = hsc.read.format("com.databricks.spark.csv").option("delimeter",",").option("header","false").option("inferSchema","true").load(hdfsFile, schema=schema)
  df.printSchema()
  df.show(5)
  return df

def calcMAvg(df, low, high):
  "Function to calculate x day moving average"
  window = Window.partitionBy('ticker').orderBy('date').rowsBetween(low, high)
  #window
  moving_avg = mean(df['close']).over(window)
  return moving_avg

#Main execution starts here  
print "Starting..."
schema = StructType([ \
           StructField("ID", IntegerType(), True), \
           StructField("date", StringType(), True), \
           StructField("time", StringType(), True), \
           StructField("open", StringType(), True), \
           StructField("high", StringType(), True), \
           StructField("low", StringType(), True), \
           StructField("close", StringType(), True), \
           StructField("volume", StringType(), True), \
           StructField("ticker", StringType(), True), \
            StructField("updated_at", StringType(), True) ])

hdfsFile = "hdfs://quickstart.cloudera:8020/user/cloudera/stocksData/daily_stock/part*"
df = createDF(hdfsFile, schema)
mavg_30 = calcMAvg(df, -30, 0)
df2 = df.withColumn('mavg_30', mavg_30)
mavg_60 = calcMAvg(df2, -60, 0)
df2 = df2.withColumn('mavg_60', mavg_60)
dfSave(df2)

print "Done"
