Drop DATABASE IF EXISTS stock;
CREATE DATABASE stock;
Use stock;
DROP TABLE IF EXISTS `daily_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `daily_stock` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Date` datetime DEFAULT NULL,
  `Open` double DEFAULT NULL,
  `High` double DEFAULT NULL,
  `Low` double DEFAULT NULL,
  `Close` double DEFAULT NULL,
  `Adj Close` double DEFAULT NULL,
  `Volume` bigint(20) DEFAULT NULL,
  `tickt` text COLLATE utf8_unicode_ci,
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`ID`),
  KEY `ix_daily_stock_Date` (`Date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE IF NOT EXISTS`process_log` (
  `process_id` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(200),
  `status` varchar(100),
  `updated_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
   PRIMARY KEY (`process_id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1;
