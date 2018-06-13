#!/bin/bash
set -x
#upload the password file to hdfs
hadoop fs -put -f sqoop/database_cred
#create database and table in mysql
mysql -u root -pcloudera < daily_stock.sql
# create hive table
hive -f hive_daily_stock.ddl
hive -f hive_daily_derived.ddl
cd sqoop
#Create sqoop job
sh daily_inc.sh
sh history.sh 
