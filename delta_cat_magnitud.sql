-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: delta
-- ------------------------------------------------------
-- Server version	5.6.25-log

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
-- Table structure for table `cat_magnitud`
--

DROP TABLE IF EXISTS `cat_magnitud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cat_magnitud` (
  `ID_MAGNITUD` bigint(20) NOT NULL DEFAULT '0',
  `NOMBRE_MAGNITUD` varchar(20) NOT NULL,
  `DESC_MAGNITUD` varchar(50) DEFAULT NULL,
  `UNIDAD_MEDIDA` varchar(30) NOT NULL,
  PRIMARY KEY (`ID_MAGNITUD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Catalogo de magnitudes sensadas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cat_magnitud`
--

LOCK TABLES `cat_magnitud` WRITE;
/*!40000 ALTER TABLE `cat_magnitud` DISABLE KEYS */;
INSERT INTO `cat_magnitud` VALUES (1,'Temperatura interna','Temperatura interna de un refrigerador','Grados Centigrados'),(2,'Temperatura externa','Temperatura externa de un refrigerador','Grados Centigrados'),(3,'Corriente electrica','Corriente electrica que consume el equipo','Amperes'),(4,'Voltaje','Voltaje que consume el equipo','Volts');
/*!40000 ALTER TABLE `cat_magnitud` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-02 12:41:35
