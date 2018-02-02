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
-- Table structure for table `registro_medida`
--

DROP TABLE IF EXISTS `registro_medida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `registro_medida` (
  `ID_REGISTRO` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_MAGNITUD` bigint(20) NOT NULL,
  `FH_REGISTRO` datetime NOT NULL,
  `FH_SENSADA` datetime DEFAULT NULL,
  `VALOR_MAGNITUD` varchar(50) NOT NULL,
  `ID_DISPOSITIVO` varchar(20) NOT NULL,
  PRIMARY KEY (`ID_REGISTRO`),
  KEY `registro_medida_cat_magnitud_FK` (`ID_MAGNITUD`),
  KEY `registro_medida_cat_dispositivos_FK` (`ID_DISPOSITIVO`),
  CONSTRAINT `registro_medida_cat_dispositivos_FK` FOREIGN KEY (`ID_DISPOSITIVO`) REFERENCES `cat_dispositivos` (`ID_DISPOSITIVO`),
  CONSTRAINT `registro_medida_cat_magnitud_FK` FOREIGN KEY (`ID_MAGNITUD`) REFERENCES `cat_magnitud` (`ID_MAGNITUD`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='Registro de las magnitudes sensadas';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registro_medida`
--

LOCK TABLES `registro_medida` WRITE;
/*!40000 ALTER TABLE `registro_medida` DISABLE KEYS */;
INSERT INTO `registro_medida` VALUES (8,4,'2018-01-26 17:53:04','2018-01-17 19:03:19','110.10','A0001'),(9,3,'2018-01-26 17:53:04','2018-01-17 19:03:19','1.124','A0001'),(10,2,'2018-01-26 17:53:04','2018-01-17 19:03:19','19.38','A0001'),(11,1,'2018-01-26 17:53:04','2018-01-17 19:03:19','3.00','A0001');
/*!40000 ALTER TABLE `registro_medida` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-02 12:41:36
