-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: dealregister
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `customer` (
  `customernumber` int(11) NOT NULL AUTO_INCREMENT,
  `customername` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`customernumber`)
) ENGINE=InnoDB AUTO_INCREMENT=232443 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (100099,'Lorem Ipsum Dolor Corp.'),(232322,'ROC'),(232342,'HBO-ict'),(232343,'Dignissim Pharetra Nam Associates'),(232344,'Integer Id Magna Associates'),(232345,'Sed Id Risus PC'),(232346,'Quisque Industries'),(232347,'Sed Company'),(232348,'Donec Nibh Industries'),(232349,'Luctus Ipsum Corporation'),(232350,'Quis Diam Luctus Incorporated'),(232351,'Ipsum Donec Consulting'),(232352,'Condimentum LLP'),(232353,'Nonummy Corp.'),(232354,'Eleifend Vitae Institute'),(232355,'Est Vitae Ltd'),(232356,'Feugiat Inc.'),(232357,'Augue Consulting'),(232358,'Mi Pede Industries'),(232359,'Auctor LLP'),(232360,'Amet Consectetuer PC'),(232361,'Ac Corporation'),(232362,'Maecenas Libero Est Consulting'),(232363,'Ipsum Phasellus Vitae Company'),(232364,'Sodales LLP'),(232365,'Interdum Company'),(232366,'Felis Inc.'),(232367,'Accumsan Convallis Ante Associates'),(232368,'Proin Eget LLP'),(232369,'Non Corp.'),(232370,'In Corporation'),(232371,'Mauris Id Foundation'),(232372,'Sollicitudin A Incorporated'),(232373,'Integer Mollis Inc.'),(232374,'Adipiscing Ligula Aenean Corporation'),(232375,'Dis Corporation'),(232376,'Proin Institute'),(232377,'Magna A LLP'),(232378,'Amet Consulting'),(232379,'Sit Amet Consulting'),(232380,'Nec LLC'),(232381,'Ligula Nullam Feugiat Consulting'),(232382,'Nec Tempus PC'),(232383,'Eleifend Egestas Sed LLP'),(232384,'Morbi Tristique Senectus PC'),(232385,'Nunc Ut Erat Corporation'),(232386,'Vivamus Corp.'),(232387,'Elit Curabitur LLC'),(232388,'Purus Maecenas Libero Inc.'),(232389,'Pellentesque Sed Dictum Inc.'),(232390,'Tellus Limited'),(232391,'Natoque Penatibus Foundation'),(232392,'Lorem Eget Mollis Limited'),(232393,'Mauris Erat Limited'),(232394,'Sem Egestas Blandit LLC'),(232395,'Egestas Foundation'),(232396,'Natoque Penatibus Et Company'),(232397,'Quisque Associates'),(232398,'Nec Cursus A LLP'),(232399,'Cursus Non Egestas Consulting'),(232400,'Egestas Duis Ac Corp.'),(232401,'Suspendisse Limited'),(232402,'Neque Nullam Nisl Associates'),(232403,'Facilisis Vitae Orci Company'),(232404,'Dui Limited'),(232405,'Etiam Bibendum Company'),(232406,'Suspendisse Sed Corporation'),(232407,'Nunc Ut Consulting'),(232408,'Molestie Sed Id Limited'),(232409,'Ligula Eu Enim Corporation'),(232410,'Nisi LLP'),(232411,'Libero Lacus Varius Company'),(232412,'Aliquam Iaculis Limited'),(232413,'Donec Egestas PC'),(232414,'Venenatis Associates'),(232415,'Curabitur Corp.'),(232416,'Nisl Nulla Eu LLP'),(232417,'Eget Magna Suspendisse LLC'),(232418,'Semper Nam Corp.'),(232419,'Cras Vehicula Foundation'),(232420,'Auctor Velit LLP'),(232421,'Egestas Inc.'),(232422,'Suspendisse Dui Consulting'),(232423,'Netus Et Consulting'),(232424,'Et Pede PC'),(232425,'Sed Leo Cras Inc.'),(232426,'Quis Pede Suspendisse Foundation'),(232427,'Lectus Company'),(232428,'Et Ltd'),(232429,'Eu PC'),(232430,'Ut Corp.'),(232431,'Mus Donec Ltd'),(232432,'Dictum Mi Ac Institute'),(232433,'Metus Aenean Inc.'),(232434,'Feugiat Institute'),(232435,'Augue Sed Molestie Consulting'),(232436,'Cum Sociis Natoque PC'),(232437,'Quisque Imperdiet Erat Company'),(232438,'Ultrices Corp.'),(232439,'Purus Company'),(232440,'Neque Morbi PC'),(232441,'Consectetuer Adipiscing Elit Inc.'),(232442,'Ut Foundation');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deal` (
  `idDeal` int(11) NOT NULL AUTO_INCREMENT,
  `dealname` varchar(45) DEFAULT NULL,
  `one_time_benefit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idDeal`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal`
--

LOCK TABLES `deal` WRITE;
/*!40000 ALTER TABLE `deal` DISABLE KEYS */;
INSERT INTO `deal` VALUES (1,'hi','1'),(2,'hi2','2');
/*!40000 ALTER TABLE `deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal_materials`
--

DROP TABLE IF EXISTS `deal_materials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `deal_materials` (
  `iddeal_materials` int(11) NOT NULL AUTO_INCREMENT,
  `VPN` varchar(20) DEFAULT NULL,
  `purchasing_price` varchar(45) DEFAULT NULL,
  `deal` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddeal_materials`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal_materials`
--

LOCK TABLES `deal_materials` WRITE;
/*!40000 ALTER TABLE `deal_materials` DISABLE KEYS */;
INSERT INTO `deal_materials` VALUES (1,'test1','2','1'),(2,'test2','3','1');
/*!40000 ALTER TABLE `deal_materials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material_line_detail`
--

DROP TABLE IF EXISTS `material_line_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `material_line_detail` (
  `Material_detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `receive_date` varchar(45) DEFAULT NULL,
  `ship_date` varchar(45) DEFAULT NULL,
  `customer` varchar(45) DEFAULT NULL,
  `reseller_discount` varchar(45) DEFAULT NULL,
  `foreing_key_material` int(11) DEFAULT NULL,
  PRIMARY KEY (`Material_detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material_line_detail`
--

LOCK TABLES `material_line_detail` WRITE;
/*!40000 ALTER TABLE `material_line_detail` DISABLE KEYS */;
INSERT INTO `material_line_detail` VALUES (2,'2','receive','20-02-2019',NULL,NULL,NULL,1),(3,NULL,'send',NULL,'21-02-2019','123456','0',1);
/*!40000 ALTER TABLE `material_line_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rollen`
--

DROP TABLE IF EXISTS `rollen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rollen` (
  `Rolid` int(11) NOT NULL AUTO_INCREMENT,
  `Rolnaam` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Rolid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rollen`
--

LOCK TABLES `rollen` WRITE;
/*!40000 ALTER TABLE `rollen` DISABLE KEYS */;
INSERT INTO `rollen` VALUES (1,'Admin'),(2,'Sales'),(3,'Gebruiker');
/*!40000 ALTER TABLE `rollen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(45) DEFAULT NULL,
  `Rol` int(11) DEFAULT NULL,
  `Wachtwoord` longtext,
  `vendor` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'zyadosseyran@gmail.com',2,'$2a$10$ZZbanqgbPfuVI1aUQX8o1eIWqIxwkZ2WwpsDsVdxAHdZMF7dn6m7e',''),(14,'test@test.nl',1,NULL,'test');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-02 22:06:20
