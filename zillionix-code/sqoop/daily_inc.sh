
. ../zillionix.properties
sqoop job --delete daily_inc_job
sqoop job \
--create daily_inc_job \
-- import \
--connect $DATABASE_URL \
--username $DATBASE_USER \
--password-file $DATABSE_USER_PASS_FILE \
--table daily_stock \
--incremental "lastmodified" \
--target-dir /user/cloudera/stocksData/daily_stock/ \
--check-column "updated_at" \
--merge-key ID \
--m 1
