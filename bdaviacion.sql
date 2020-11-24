-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: localhost    Database: bdaviacion
-- ------------------------------------------------------
-- Server version	8.0.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `horarios`
--

DROP TABLE IF EXISTS `horarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horarios` (
  `id_horario` int NOT NULL AUTO_INCREMENT,
  `hora` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_horario`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horarios`
--

LOCK TABLES `horarios` WRITE;
/*!40000 ALTER TABLE `horarios` DISABLE KEYS */;
INSERT INTO `horarios` VALUES (1,'00:00'),(2,'00:15'),(3,'00:30'),(4,'00:45'),(5,'01:00'),(6,'01:15'),(7,'01:30'),(8,'01:45'),(9,'02:00'),(10,'02:15'),(11,'02:30'),(12,'02:45'),(13,'03:00'),(14,'03:15'),(15,'03:30'),(16,'03:45'),(17,'04:00'),(18,'04:15'),(19,'04:30'),(20,'04:45'),(21,'05:00'),(22,'05:15'),(23,'05:30'),(24,'05:45'),(25,'06:00'),(26,'06:15'),(27,'06:30'),(28,'06:45'),(29,'07:00'),(30,'07:15'),(31,'07:30'),(32,'07:45'),(33,'08:00'),(34,'08:15'),(35,'08:30'),(36,'08:45'),(37,'09:00'),(38,'09:15'),(39,'09:30'),(40,'09:45'),(41,'10:00'),(42,'10:15'),(43,'10:30'),(44,'10:45'),(45,'11:00'),(46,'11:15'),(47,'11:30'),(48,'11:45'),(49,'12:00'),(50,'12:15'),(51,'12:30'),(52,'12:45'),(53,'13:00'),(54,'13:15'),(55,'13:30'),(56,'13:45'),(57,'14:00'),(58,'14:15'),(59,'14:30'),(60,'14:45'),(61,'15:00'),(62,'15:15'),(63,'15:30'),(64,'15:45'),(65,'16:00'),(66,'16:15'),(67,'16:30'),(68,'16:45'),(69,'17:00'),(70,'17:15'),(71,'17:30'),(72,'17:45'),(73,'18:00'),(74,'18:15'),(75,'18:30'),(76,'18:45'),(77,'19:00'),(78,'19:15'),(79,'19:30'),(80,'19:45'),(81,'20:00'),(82,'20:15'),(83,'20:30'),(84,'20:45'),(85,'21:00'),(86,'21:15'),(87,'21:30'),(88,'21:45'),(89,'22:00'),(90,'22:15'),(91,'22:30'),(92,'22:45'),(93,'23:00'),(94,'23:15'),(95,'23:30'),(96,'23:45');
/*!40000 ALTER TABLE `horarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operadores`
--

DROP TABLE IF EXISTS `operadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `operadores` (
  `id_operador` int NOT NULL AUTO_INCREMENT,
  `codigo` varchar(10) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id_operador`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operadores`
--

LOCK TABLES `operadores` WRITE;
/*!40000 ALTER TABLE `operadores` DISABLE KEYS */;
INSERT INTO `operadores` VALUES (3,'AA','AMERICAN AIRLINES'),(4,'CP','CANADIAN AIRLINES INTERNATIONAL'),(5,'AMX','AEROMEXICO');
/*!40000 ALTER TABLE `operadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vuelos`
--

DROP TABLE IF EXISTS `vuelos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vuelos` (
  `id_vuelo` int NOT NULL AUTO_INCREMENT,
  `fecha_ingreso` date NOT NULL,
  `numero` varchar(5) COLLATE utf8_spanish_ci NOT NULL,
  `horario_entrada` int NOT NULL,
  `horario_salida` int NOT NULL,
  `id_operador` int NOT NULL,
  PRIMARY KEY (`id_vuelo`),
  KEY `fkVueloHorarioEntrada` (`horario_entrada`),
  KEY `fkVueloHorarioSalida` (`horario_salida`),
  KEY `fkVueloOperador` (`id_operador`),
  CONSTRAINT `fkVueloHorarioEntrada` FOREIGN KEY (`horario_entrada`) REFERENCES `horarios` (`id_horario`),
  CONSTRAINT `fkVueloHorarioSalida` FOREIGN KEY (`horario_salida`) REFERENCES `horarios` (`id_horario`),
  CONSTRAINT `fkVueloOperador` FOREIGN KEY (`id_operador`) REFERENCES `operadores` (`id_operador`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vuelos`
--

LOCK TABLES `vuelos` WRITE;
/*!40000 ALTER TABLE `vuelos` DISABLE KEYS */;
INSERT INTO `vuelos` VALUES (2,'2020-11-23','12345',2,1,3),(3,'2020-11-23','12345',2,1,3),(4,'2020-11-26','12345',12,2,5),(5,'2020-11-30','12345',12,2,5),(6,'2020-11-28','12345',12,2,5),(7,'2020-11-25','69856',28,19,5),(8,'2020-11-27','69856',28,19,5),(9,'2020-11-28','69856',28,19,5),(10,'2020-11-23','45612',74,49,4),(11,'2020-11-24','45612',74,49,4),(12,'2020-11-25','45612',74,49,4),(13,'2020-11-28','45612',74,49,4),(14,'2020-11-29','45612',74,49,4),(15,'2020-12-01','95678',71,51,3),(16,'2020-11-30','95678',71,51,3),(17,'2020-11-26','95678',71,51,3),(18,'2020-11-29','95678',71,51,3);
/*!40000 ALTER TABLE `vuelos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-24  2:25:31
