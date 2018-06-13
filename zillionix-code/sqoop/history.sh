
. ../zillionix.properties
sqoop job --delete history_job
sqoop job \
--create history_job \
-- import \
--connect $DATABASE_URL \
--username $DATBASE_USER \
--password-file $DATABSE_USER_PASS_FILE \
--table daily_stock \
--warehouse-dir /user/cloudera/stocksData \
-m 1
