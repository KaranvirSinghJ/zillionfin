CREATE DATABASE IF NOT EXISTS stock;
DROP TABLE stock.daily_derived;
CREATE EXTERNAL TABLE IF NOT EXISTS stock.daily_derived(
ID int
,Date string
,Open double
,High double
,Low double
,Close double
,Adj_Close double
,Volume bigint
,tickt string
,updated_at timestamp
,mavg_30 bigint
,mavg_60 bigint
) 
COMMENT 'Data about cars from a public database'
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
STORED AS TEXTFILE
location '/user/cloudera/stocksData/daily_derived';
