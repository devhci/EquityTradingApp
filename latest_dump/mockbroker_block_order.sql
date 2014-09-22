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
-- Table structure for table `block_order`
--

DROP TABLE IF EXISTS `block_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `block_order` (
  `block_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `executed_quantity` int(11) DEFAULT NULL,
  `limit_price` double DEFAULT NULL,
  `open_quantity` int(11) DEFAULT NULL,
  `side` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `stop_price` double DEFAULT NULL,
  `symbol` varchar(255) DEFAULT NULL,
  `total_quantity` int(11) DEFAULT NULL,
  `trader` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`block_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `block_order`
--

LOCK TABLES `block_order` WRITE;
/*!40000 ALTER TABLE `block_order` DISABLE KEYS */;
INSERT INTO `block_order` VALUES (2,0,0,1000,'sell','sent for execution',0,'ongc',1000,'mohit'),(3,0,0,1000,'sell','sent for execution',0,'tcs',1000,'mohit');
/*!40000 ALTER TABLE `block_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-11-23 15:56:11
