CREATE DATABASE  IF NOT EXISTS `mockbroker` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `mockbroker`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: mockbroker
-- ------------------------------------------------------
-- Server version	5.5.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `securities`
--

DROP TABLE IF EXISTS `securities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `securities` (
  `securityName` varchar(100) NOT NULL,
  `securitySymbol` varchar(45) NOT NULL,
  `lastTradePrice` double DEFAULT NULL,
  `maxPriceSpreadPercent` double DEFAULT NULL,
  `maxNoOfExecutionsPerOrdr` bigint(20) DEFAULT NULL,
  `maxIntervalBetweenExecInMs` double DEFAULT NULL,
  `probabilityPercentOfFullyExecutedOrder` double DEFAULT NULL,
  `Cusip` varchar(45) DEFAULT NULL,
  `SecurityId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`SecurityId`),
  UNIQUE KEY `securityName_UNIQUE` (`securityName`),
  UNIQUE KEY `securitySymbol_UNIQUE` (`securitySymbol`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `securities`
--

LOCK TABLES `securities` WRITE;
/*!40000 ALTER TABLE `securities` DISABLE KEYS */;
INSERT INTO `securities` VALUES ('Infosys','INFY',121.87009613526604,3,5,8,100,'456788108',1),('Sapient','SAPE',97,4,7,5,100,'803062108',2),('Microsoft','MSFT',142,3,4,4,100,'594918104',3),('Google','GOOG',74.45048826219869,3,4,4,100,'38259P508',4),('Apple','APPL',156,3,4,3,100,'037833100',5),('Tata Consultancy Services','TCS',100,2,2,5,100,'437852106',6),('State Bank of India','SBIN',213,3,3,5,100,'856552104',26),('HDFC Bank','HDFC',100,4,4,4,100,'40415F101',27),('Oil and Natural Gas Corporation','ONGC',132,2,6,6,100,'943901108',28);
/*!40000 ALTER TABLE `securities` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-23 15:56:10
