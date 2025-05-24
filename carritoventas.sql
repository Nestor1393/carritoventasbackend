-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: carrito_ventas
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id_address` bigint NOT NULL AUTO_INCREMENT,
  `locality` varchar(255) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `id_city` bigint NOT NULL,
  PRIMARY KEY (`id_address`),
  KEY `FKxpbahketqa6aw9r9ico11xu9` (`id_city`),
  CONSTRAINT `FKxpbahketqa6aw9r9ico11xu9` FOREIGN KEY (`id_city`) REFERENCES `city` (`id_city`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (3,'xjj',5,1,'x',2),(4,'j',6,6,'j',2),(5,'n',8,8,'n',5),(6,'n',8,8,'n',7),(7,'p',1,1,'p',5),(8,'p',1,1,'p',17),(9,'c',1,1,'c',5),(10,'u',1,1,'u',5),(11,'u',1,1,'u',5),(12,'u',1,1,'u',27),(13,'u',1,1,'u',5),(14,'y',1,1,'y',5),(16,'j',1,1,'j',5),(17,'Campo Zotelo',12,123,'De las Flores',2),(26,'pp',88,88,'pp',29),(32,'w',1,1,'w',36),(33,'w',1,1,'w',5),(34,'w',1,1,'w',27),(35,'w',1,1,'w',5),(36,'ww',1,1,'ww',5),(37,'w',7,4,'w',5),(40,'11',1,1,'w',5),(42,'x',1,1,'x',27),(43,'s',2,2,'s',5),(44,'s',1,2,'s',2),(45,'b',1,1,'b',5),(46,'wz',1,1,'wm',2),(47,'k',1,1,'k',5),(48,'m',1,1,'m',2),(49,'m',1,1,'m',5),(50,'x',2,2,'x',5),(51,'g',1,1,'g',36),(52,'1',1,1,'j',36),(53,'j',3,2,'j',36),(54,'o',1,1,'o',36),(55,'n',2,4,'n',29);
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id_category` bigint NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (14,'Chocolates2223'),(16,'Gelatinas'),(17,'Golosinas'),(46,'Refacciones'),(52,'Plomeria2'),(66,'Jugos134'),(76,'Dulces 3'),(79,'aaa 123'),(80,'Gasolinas'),(81,'Limpieza'),(82,'Dulces 3'),(83,'Dulces 5');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `city` (
  `id_city` bigint NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) DEFAULT NULL,
  `id_state` bigint NOT NULL,
  PRIMARY KEY (`id_city`),
  KEY `FKd0p47lqu885cst48arraojuqs` (`id_state`),
  CONSTRAINT `FKd0p47lqu885cst48arraojuqs` FOREIGN KEY (`id_state`) REFERENCES `state` (`id_state`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (2,'CuernavacaX',5),(5,'Chilpapa33',4),(7,'Nezaa',10),(16,'Morelia',17),(17,'Chilpapa',10),(27,'cuernavaca243',5),(29,'zapata',5),(30,'cuautla',5),(36,'cuernavaca2',10),(37,'Morelia',10),(38,'Morelia2',10),(39,'Temixco',5),(40,'Temixco',26),(41,'Cuautla',10),(42,'Acapulco',37),(43,'cuernavaca2',28),(44,'Jojutla',10),(45,'Jojutla',10);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_customer` bigint NOT NULL AUTO_INCREMENT,
  `id_person` bigint DEFAULT NULL,
  PRIMARY KEY (`id_customer`),
  KEY `FKeu1h389po5xyx30dp359ss6pd` (`id_person`),
  CONSTRAINT `FKeu1h389po5xyx30dp359ss6pd` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,12),(26,12),(27,12),(28,12),(4,26),(25,26),(13,40),(14,40),(15,45),(16,47),(17,48),(18,49),(19,50),(20,51),(21,52),(22,53),(23,54),(24,55);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orden`
--

DROP TABLE IF EXISTS `orden`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orden` (
  `id_order` bigint NOT NULL AUTO_INCREMENT,
  `folio` varchar(10) DEFAULT NULL,
  `order_date` datetime(6) DEFAULT NULL,
  `subtotal` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `id_customer` bigint NOT NULL,
  `id_user` bigint NOT NULL,
  `codigo_barras` bigint DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FKie2f4e0dlyccvktv341v3jy93` (`id_customer`),
  KEY `FKs0k86vb73f2iagptvhb2mvkuv` (`id_user`),
  CONSTRAINT `FKie2f4e0dlyccvktv341v3jy93` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  CONSTRAINT `FKs0k86vb73f2iagptvhb2mvkuv` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=155 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orden`
--

LOCK TABLES `orden` WRITE;
/*!40000 ALTER TABLE `orden` DISABLE KEYS */;
INSERT INTO `orden` VALUES (1,'100','2024-01-18 13:34:05.000000',650.5,720,1,3,NULL),(2,'100','2024-01-08 12:34:56.000000',650.5,720,1,3,NULL),(3,'100','2025-02-11 10:30:32.000000',750.5,820,1,3,NULL),(4,'100','2025-02-11 10:30:32.000000',750.5,820,1,3,NULL),(5,'00000','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(6,'00000','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(7,'000007','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(8,'000008','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(9,'000009','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(10,'000010','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(11,'000011','2024-06-10 09:00:00.000000',850.3,900,1,3,NULL),(12,'000012','2024-06-12 19:26:04.233786',514,596.24,16,6,NULL),(13,'000013','2024-06-13 13:59:40.978344',524,607.84,16,6,NULL),(14,'000014','2024-06-13 14:29:46.798954',524,607.84,16,6,NULL),(15,'000015','2024-06-13 15:11:22.826266',13,15.08,16,6,NULL),(16,'000016','2024-06-13 17:46:19.374444',10,11.6,16,6,NULL),(17,'000017','2024-06-13 17:47:49.311078',15,17.4,16,6,NULL),(20,'000018','2024-06-13 18:18:14.913324',6,6.96,26,6,NULL),(21,'000021','2024-06-13 19:28:21.642551',100,116,1,6,NULL),(22,'000022','2024-06-14 19:46:17.917220',1,1.16,1,6,NULL),(23,'000023','2024-06-14 19:51:16.469317',1,1.16,1,6,NULL),(24,'000024','2024-06-14 20:05:15.729032',6,6.96,26,6,NULL),(25,'000025','2024-06-14 20:06:55.921776',500,580,1,6,NULL),(26,'000026','2024-06-14 20:07:49.669078',500,580,1,6,NULL),(27,'000027','2024-06-14 20:09:43.324719',500,580,1,6,NULL),(28,'000028','2024-06-14 20:13:44.166389',500,580,26,6,NULL),(29,'000029','2024-06-14 20:16:22.781210',406,470.96,1,6,NULL),(30,'000030','2024-06-15 17:11:57.420557',2004.5,2325.22,20,6,NULL),(31,'000031','2024-06-15 17:41:03.910822',320.5,371.78,1,6,NULL),(32,'000032','2024-06-15 18:26:18.603701',504,584.64,1,6,NULL),(33,'000033','2024-06-15 18:28:08.521145',266,308.56,1,6,NULL),(34,'000034','2024-06-15 18:29:32.800041',319,370.04,1,6,NULL),(35,'000035','2024-06-15 18:44:36.888827',5500,6380,1,6,NULL),(36,'000036','2024-06-15 19:02:37.530820',-100,-116,1,6,NULL),(37,'000037','2024-06-17 19:14:06.401302',13011.5,15093.34,1,6,NULL),(38,'000038','2024-06-18 15:12:25.385445',1,1.16,1,6,NULL),(39,'000039','2024-06-18 15:12:51.583457',120.5,139.78,1,6,NULL),(40,'000040','2024-06-18 17:17:52.419425',3,3.48,1,6,NULL),(41,'000041','2024-06-18 17:19:28.732886',10,11.6,1,6,NULL),(42,'000042','2024-06-18 17:55:27.337568',2,2.32,1,6,NULL),(43,'000043','2024-06-18 18:01:25.637146',3,3.48,1,6,NULL),(44,'000044','2024-06-18 18:29:24.139857',3,3.48,1,6,NULL),(45,'000045','2024-06-18 18:34:56.812468',3,3.48,1,6,NULL),(46,'000046','2024-06-18 18:37:21.771257',1,1.16,1,6,NULL),(47,'000047','2024-06-18 19:46:56.377937',1,1.16,1,6,NULL),(48,'000048','2024-06-18 19:48:31.174039',1,1.16,1,6,NULL),(49,'000049','2024-06-19 14:01:49.495028',6,6.96,1,6,NULL),(50,'000050','2024-06-19 14:05:26.138925',2,2.32,1,6,NULL),(51,'000051','2024-06-19 14:53:18.805111',2,2.32,1,6,NULL),(52,'000052','2024-06-19 14:54:12.128394',3,3.48,1,6,NULL),(53,'000053','2024-06-19 15:05:46.528210',5,5.8,1,6,NULL),(54,'000054','2024-06-19 15:14:45.882604',3,3.48,1,6,NULL),(55,'000055','2024-06-19 17:04:36.291576',3,3.48,1,6,NULL),(56,'000056','2024-06-19 18:59:35.353589',1,1.16,1,6,NULL),(57,'000057','2024-06-19 19:06:53.202503',1,1.16,1,6,NULL),(58,'000058','2024-06-19 19:45:31.737317',1,1.16,1,6,NULL),(59,'000059','2024-06-19 19:59:01.500703',1,1.16,1,6,NULL),(60,'000060','2024-06-19 20:06:10.327615',1,1.16,1,6,NULL),(61,'000061','2024-06-20 16:59:39.400918',1,1.16,1,6,NULL),(62,'000062','2024-06-20 17:00:13.439821',1,1.16,1,6,NULL),(63,'000063','2024-06-20 17:20:18.801504',1,1.16,1,6,NULL),(64,'000064','2024-06-20 17:25:17.426011',4,4.64,1,6,NULL),(65,'000065','2024-06-20 17:32:06.613918',2,2.32,1,6,NULL),(66,'000066','2024-06-20 17:56:13.172048',1,1.16,1,6,NULL),(67,'000067','2024-06-20 17:58:04.066244',2,2.32,1,6,NULL),(68,'000068','2024-06-20 18:23:13.246107',2,2.32,1,6,NULL),(69,'000069','2024-06-20 19:30:14.055734',1,1.16,1,6,NULL),(70,'000070','2024-06-20 19:31:11.891318',3,3.48,1,6,NULL),(71,'000071','2024-06-21 13:32:53.654276',175,203,1,6,NULL),(72,'000072','2024-06-27 18:21:07.359634',120.5,139.78,1,6,NULL),(73,'000073','2024-06-27 18:21:44.082017',2,2.32,28,6,NULL),(74,'000074','2024-06-30 13:26:13.523765',1753,2033.48,1,6,NULL),(75,'000075','2024-06-30 13:26:35.963093',1753,2033.48,1,6,NULL),(76,'000076','2024-06-30 13:32:19.801876',1753,2033.48,1,6,NULL),(77,'000077','2024-06-30 13:32:40.604462',1753,2033.48,1,6,NULL),(78,'000078','2024-06-30 13:34:02.233426',1753,2033.48,1,6,NULL),(79,'000079','2024-06-30 13:34:47.162152',1753,2033.48,1,6,NULL),(80,'000080','2024-06-30 13:34:49.555212',1753,2033.48,1,6,NULL),(81,'000081','2024-06-30 13:35:42.179229',1753,2033.48,1,6,NULL),(82,'000082','2024-06-30 13:35:46.834376',1753,2033.48,1,6,NULL),(83,'000083','2024-06-30 13:36:25.726397',1753,2033.48,1,6,NULL),(84,'000084','2024-06-30 13:40:12.387663',1753,2033.48,1,6,NULL),(85,'000085','2024-06-30 13:40:50.788617',1753,2033.48,1,6,NULL),(86,'000086','2024-06-30 14:24:10.070010',1753,2033.48,1,6,NULL),(87,'000087','2024-07-01 16:54:48.997397',1753,2033.48,1,6,NULL),(88,'000088','2024-07-01 17:05:26.990867',1753,2033.48,1,6,NULL),(89,'000089','2024-07-01 17:06:24.685537',1753,2033.48,1,6,NULL),(90,'000090','2024-07-01 17:11:03.423413',1753,2033.48,1,6,NULL),(91,'000091','2024-07-01 17:12:51.699202',1753,2033.48,1,6,NULL),(92,'000092','2024-07-01 17:13:55.243245',1753,2033.48,1,6,NULL),(93,'000093','2024-07-01 17:16:28.402794',1753,2033.48,1,6,NULL),(94,'000094','2024-07-01 17:22:54.945714',1753,2033.48,1,6,NULL),(95,'000095','2024-07-01 17:24:48.743626',1753,2033.48,1,6,NULL),(96,'000096','2024-07-01 17:27:05.439917',1753,2033.48,1,6,NULL),(97,'000097','2024-07-01 17:28:48.508899',1753,2033.48,1,6,NULL),(98,'000098','2024-07-01 17:30:13.691151',1753,2033.48,1,6,NULL),(99,'000099','2024-07-01 17:30:40.004570',1753,2033.48,1,6,NULL),(100,'000100','2024-07-01 17:32:02.942665',1753,2033.48,1,6,NULL),(101,'000101','2024-07-01 17:32:54.348189',1753,2033.48,1,6,NULL),(102,'000102','2024-07-01 17:34:42.805247',1753,2033.48,1,6,NULL),(103,'000103','2024-07-01 17:38:18.042524',1753,2033.48,1,6,NULL),(104,'000104','2024-07-01 17:45:08.158694',1753,2033.48,1,6,NULL),(105,'000105','2024-07-01 17:46:36.431925',1753,2033.48,1,6,NULL),(106,'000106','2024-07-01 17:47:21.519242',1753,2033.48,1,6,NULL),(107,'000107','2024-07-01 17:48:11.152025',1753,2033.48,1,6,NULL),(108,'000108','2024-07-01 20:06:23.744927',1957,2270.12,1,6,NULL),(109,'000109','2024-07-01 20:26:39.742907',1957,2270.12,1,6,NULL),(110,'000110','2024-07-01 20:28:28.845303',1957,2270.12,1,6,NULL),(111,'000111','2024-07-01 20:58:54.643533',1957,2270.12,1,6,NULL),(112,'000112','2024-07-01 21:01:09.403031',2307,2676.12,1,6,NULL),(113,'000113','2024-07-01 21:10:21.484761',2307,2676.12,1,6,NULL),(114,'000114','2024-07-02 12:19:42.621550',2307,2676.12,1,6,NULL),(115,'000115','2024-07-02 12:19:46.116474',2307,2676.12,1,6,NULL),(116,'000116','2024-07-02 12:20:20.596194',2307,2676.12,1,6,NULL),(117,'000117','2024-07-02 12:31:13.814573',2307,2676.12,28,6,NULL),(118,'000118','2024-07-02 12:49:39.976535',2307,2676.12,1,6,159968308435),(119,'000119','2024-07-02 13:06:38.144235',2307,2676.12,1,6,151196941044),(120,'000120','2024-07-02 13:10:31.805194',2307,2676.12,1,6,235262194342),(121,'000121','2024-07-02 13:28:32.797024',2307,2676.12,1,6,110359541930),(122,'000122','2024-07-02 14:00:51.025581',2307,2676.12,1,6,795328537276),(123,'000123','2024-07-02 14:05:34.437424',2307,2676.12,1,6,966636594323),(124,'000124','2024-07-02 14:09:07.970225',2307,2676.12,1,6,814944376372),(125,'000125','2024-07-02 14:16:27.210020',2307,2676.12,1,6,686885880645),(126,'000126','2024-07-02 14:19:17.453978',180,208.8,27,6,955309591441),(127,'000127','2024-07-02 14:20:33.886182',270,313.2,1,6,154708395211),(128,'000128','2024-07-02 16:37:02.079960',70,81.2,1,6,377408419723),(129,'000129','2024-07-18 20:43:38.226891',2,2.32,1,6,899744756861),(130,'000130','2024-07-23 18:57:56.503911',2,2.32,26,6,478728586166),(131,'000131','2024-07-24 16:30:46.893066',2,2.32,1,6,218885480350),(132,'000132','2024-07-24 18:23:09.564663',1619,1878.04,1,6,414487246537),(133,'000133','2024-08-07 17:48:02.628184',2025,2349,1,6,246017896430),(134,'000134','2024-08-08 20:24:17.657020',1339,1553.24,1,6,403330490046),(135,'000135','2024-08-08 20:28:21.969975',519,602.04,1,6,194283837312),(136,'000136','2024-10-12 16:03:57.068132',100,116,27,6,693465854213),(137,'000137','2024-10-12 16:05:13.852926',1,1.16,26,6,610079445146),(138,'000138','2024-10-12 18:50:40.214336',100,116,27,6,865670723963),(139,'000139','2024-10-12 18:51:25.341758',120.5,139.78,28,6,319550369323),(141,'000140','2024-10-01 17:56:41.331318',153.5,178.06,4,6,950236797936),(145,'000142','2024-10-01 20:23:07.568615',120.5,139.78,1,5,522410174581),(146,'000146','2024-10-01 20:29:03.582700',35,40.6,1,5,651558387378),(147,'000147','2024-10-01 20:45:43.489685',35,40.6,1,5,931679304243),(148,'000148','2024-10-02 20:33:39.918115',35,40.6,1,5,298119395516),(149,'000149','2024-10-02 20:40:44.759694',120.5,139.78,1,7,979214430904),(150,'000150','2024-10-02 21:03:50.254798',120.5,139.78,1,27,733661171892),(151,'000151','2024-10-04 20:00:27.129011',200,232,1,29,513590492347),(152,'000152','2024-10-06 19:03:27.022964',400,464,26,5,752242079638),(153,'000153','2024-10-06 19:04:39.777776',200,232,1,5,255693221551),(154,'000154','2024-10-06 19:05:16.695761',80,92.8,1,5,179807196959);
/*!40000 ALTER TABLE `orden` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `before_insert_orden` BEFORE INSERT ON `orden` FOR EACH ROW BEGIN
    DECLARE new_folio INT;
    -- Obtener el último valor de id
    SET new_folio = (SELECT IFNULL(MAX(id_order), 0) + 1 FROM orden);
    -- Asignar el nuevo valor de folio con formato
    SET NEW.folio = LPAD(new_folio, 6, '0');
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_detail` (
  `id_order_detail` bigint NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `id_order` bigint DEFAULT NULL,
  `id_product` bigint DEFAULT NULL,
  PRIMARY KEY (`id_order_detail`),
  KEY `FKmphtpxr3l04q04i3tb5lmkj0` (`id_order`),
  KEY `FKicrtfcntxfkyrnoaqh1croidl` (`id_product`),
  CONSTRAINT `FKicrtfcntxfkyrnoaqh1croidl` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`),
  CONSTRAINT `FKmphtpxr3l04q04i3tb5lmkj0` FOREIGN KEY (`id_order`) REFERENCES `orden` (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=205 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
INSERT INTO `order_detail` VALUES (6,6,6,14,51),(7,3,3,14,49),(8,5,5,14,53),(9,5,500,14,52),(10,10,10,14,48),(11,3,3,15,49),(12,10,10,15,48),(13,10,10,16,48),(14,10,10,17,48),(15,5,5,17,51),(16,6,6,20,53),(17,1,100,21,52),(18,1,1,22,49),(19,1,1,23,49),(20,1,1,24,49),(21,5,5,24,51),(22,5,500,25,52),(23,5,500,26,52),(24,5,500,27,52),(25,5,500,28,52),(26,6,6,29,51),(27,4,400,29,52),(28,4,220,30,58),(29,4,82,30,57),(30,3,255,30,56),(31,4,140,30,55),(32,5,602.5,30,54),(33,5,5,30,53),(34,7,700,30,52),(35,2,200,31,52),(36,1,120.5,31,54),(37,3,361.5,32,54),(38,1,35,32,55),(39,1,85,32,56),(40,1,20.5,32,57),(41,2,2,32,48),(42,3,3,33,48),(43,2,2,33,49),(44,1,120.5,33,54),(45,1,35,33,55),(46,1,85,33,56),(47,1,20.5,33,57),(48,2,2,34,48),(49,1,1,34,49),(50,1,120.5,34,54),(51,1,35,34,55),(52,1,85,34,56),(53,1,20.5,34,57),(54,1,55,34,58),(55,100,5500,35,58),(56,-100,-100,36,48),(57,103,12411.5,37,54),(58,6,600,37,52),(59,1,120.5,39,54),(60,3,3,40,48),(61,10,10,41,48),(62,2,2,42,48),(63,3,3,43,48),(64,3,3,44,48),(65,3,3,45,48),(66,1,1,46,48),(67,1,1,47,48),(68,1,1,48,48),(69,2,2,50,48),(70,2,2,51,48),(71,3,3,52,48),(72,5,5,53,48),(73,3,3,54,48),(74,3,3,55,48),(75,1,1,56,48),(76,1,1,57,48),(77,1,1,58,48),(78,1,1,59,48),(79,1,1,60,48),(80,1,1,61,48),(81,1,1,62,48),(82,1,1,63,48),(83,4,4,64,48),(84,2,2,65,48),(85,1,1,66,49),(86,2,2,67,48),(87,2,2,68,48),(88,1,1,69,48),(89,3,3,70,48),(90,5,175,71,55),(91,1,120.5,72,54),(92,2,2,73,48),(93,5,175,123,55),(94,4,482,123,54),(95,5,175,124,55),(96,4,482,124,54),(97,3,3,124,48),(98,1,1,124,49),(99,1,1,124,51),(100,3,300,124,52),(101,4,4,124,53),(102,1,85,124,56),(103,2,41,124,57),(104,1,55,124,58),(105,1,100,124,59),(106,1,200,124,60),(107,1,80,124,61),(108,6,420,124,62),(109,2,340,124,63),(110,2,20,124,64),(111,5,175,125,55),(112,4,482,125,54),(113,3,3,125,48),(114,1,1,125,49),(115,1,1,125,51),(116,3,300,125,52),(117,4,4,125,53),(118,1,85,125,56),(119,2,41,125,57),(120,1,55,125,58),(121,1,100,125,59),(122,1,200,125,60),(123,1,80,125,61),(124,6,420,125,62),(125,2,340,125,63),(126,2,20,125,64),(127,18,180,126,64),(128,27,270,127,64),(129,2,70,128,55),(130,2,2,129,48),(131,2,2,130,49),(132,2,2,131,51),(133,2,2,132,49),(134,2,2,132,51),(135,4,400,132,52),(136,3,165,132,58),(137,3,300,132,59),(138,3,240,132,61),(139,3,510,132,63),(140,1,1,133,49),(141,1,1,133,51),(142,1,100,133,52),(143,1,1,133,53),(144,1,120.5,133,54),(145,1,35,133,55),(146,1,85,133,56),(147,1,20.5,133,57),(148,1,55,133,58),(149,1,100,133,59),(150,1,200,133,60),(151,1,80,133,61),(152,1,70,133,62),(153,1,170,133,63),(154,1,10,133,64),(155,1,120,133,65),(156,1,100,133,66),(157,1,50.5,133,67),(158,1,120.5,133,68),(159,1,200,133,69),(160,1,205,133,70),(161,1,90,133,71),(162,1,90,133,72),(163,1,1,134,49),(164,1,1,134,51),(165,1,100,134,52),(166,1,1,134,53),(167,1,120.5,134,54),(168,1,35,134,55),(169,1,85,134,56),(170,1,20.5,134,57),(171,1,55,134,58),(172,1,100,134,59),(173,1,200,134,60),(174,1,80,134,61),(175,1,70,134,62),(176,2,340,134,63),(177,1,10,134,64),(178,1,120,134,65),(179,1,1,135,49),(180,1,1,135,51),(181,1,100,135,52),(182,1,1,135,53),(183,1,120.5,135,54),(184,1,35,135,55),(185,1,85,135,56),(186,1,20.5,135,57),(187,1,55,135,58),(188,1,100,135,59),(189,4,100,136,52),(190,3,1,137,52),(191,2,100,138,52),(192,1,120.5,139,54),(193,2,2,141,51),(194,3,151.5,141,67),(195,1,120.5,145,54),(196,1,35,146,55),(197,1,35,147,55),(198,1,35,148,55),(199,1,120.5,149,54),(200,1,120.5,150,54),(201,1,200,151,69),(202,2,400,152,60),(203,1,200,153,60),(204,1,80,154,61);
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_person` bigint NOT NULL AUTO_INCREMENT,
  `birthdate` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `id_address` bigint DEFAULT NULL,
  `id_facebook` varchar(100) DEFAULT NULL,
  `id_google` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id_person`),
  KEY `FKop6hisrmbajav9hsfotg2g2ex` (`id_address`),
  CONSTRAINT `FKop6hisrmbajav9hsfotg2g2ex` FOREIGN KEY (`id_address`) REFERENCES `address` (`id_address`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (3,'2023-01-01','x@x.com','x','x',3,NULL,NULL),(4,'2023-01-01','j@j','j','j',4,NULL,NULL),(5,'2023-01-01','n@n','n','n',5,NULL,NULL),(6,'2023-01-01','n@n','n','n',6,NULL,NULL),(7,'2023-01-01','p@p','p','p',7,NULL,NULL),(8,'2023-01-01','p@p','p','pggg',8,NULL,NULL),(9,'2023-01-01','c@c','c','c',9,NULL,NULL),(10,'2023-01-01','u@u','u','u',10,NULL,NULL),(11,'2023-01-01','u@u','u','u',11,NULL,NULL),(12,'2023-01-01','u@u','ux','ux',12,NULL,NULL),(13,'2023-01-01','u@u','u','u',13,NULL,NULL),(14,'2023-01-01','y@y','y','y',14,NULL,NULL),(16,'2024-02-02','j@j','j','j',16,NULL,NULL),(17,'1993-12-13','nestor@gmail.com','Nestor','Muñoz',17,NULL,NULL),(26,'2025-02-02','pp@pp','pp','pp',26,NULL,NULL),(32,'2024-01-01','w@w','w','w',32,NULL,NULL),(33,'2024-01-01','w@w','w','w',33,NULL,NULL),(34,'2024-01-01','w@w','w','w',34,NULL,NULL),(35,'2024-01-01','w@w','w','w',35,NULL,NULL),(36,'2024-01-01','ww@ww','ww','ww',36,NULL,NULL),(37,'2024-01-01','w@w','w','w',37,NULL,NULL),(40,'2024-01-01','j@j','j','j',40,NULL,NULL),(42,'2024-01-02','x@x','x','x',42,NULL,NULL),(43,'2024-01-01','s@s','s','s',43,NULL,NULL),(44,'2024-01-01','s@s','s','s',44,NULL,NULL),(45,'2024-01-01','n@n','b','b',45,NULL,NULL),(46,'2024-01-02','w@w','w','w',46,NULL,NULL),(47,'2024-01-01','k@k','k','k',47,NULL,NULL),(48,'2024-01-01','m@m','m','m',48,NULL,NULL),(49,'2024-01-01','m@m','m','m',49,NULL,NULL),(50,'2024-01-01','x@x','x','x',50,NULL,NULL),(51,'2024-12-31','g@g','g','g',51,NULL,NULL),(52,'2024-12-31','j@j','j','j',52,NULL,NULL),(53,'2024-01-01','j@j','j','j',53,NULL,NULL),(54,'2024-01-01','o@o','o','o',54,NULL,NULL),(55,'2024-01-01','n@n','n','n',55,NULL,NULL),(56,NULL,NULL,'Nes','mj',3,'1020',NULL),(57,NULL,NULL,'Nes2','mj2',3,'1022',NULL),(58,'2024-10-01','facebook@gmail.com','Nes5','mj5',3,'1025',NULL),(60,'2024-10-02','facebook@gmail.com','Nestor','MJ',3,'8563252960364823',NULL),(61,'2024-10-04','n@n.gmai.com','Nes7','mj7',3,NULL,'3000'),(62,'2024-10-04','munozjimeneznestor@gmail.com','N','M J',3,NULL,'1728093189');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_code` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `id_category` bigint DEFAULT NULL,
  `id_supplier` bigint DEFAULT NULL,
  PRIMARY KEY (`id_product`),
  KEY `FK5cxv31vuhc7v32omftlxa8k3c` (`id_category`),
  KEY `FK7vecnfptx4ologqg55y3v7mbm` (`id_supplier`),
  CONSTRAINT `FK5cxv31vuhc7v32omftlxa8k3c` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`),
  CONSTRAINT `FK7vecnfptx4ologqg55y3v7mbm` FOREIGN KEY (`id_supplier`) REFERENCES `supplier` (`id_supplier`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (48,'1234',1,'u','negrito',0,NULL,20),(49,'1234',1,'u','gansito',91,NULL,20),(51,'o',1,'o','submarinos',88,NULL,21),(52,'x',100,'125','totis',85,NULL,20),(53,'c',1,'123','chettos',89,NULL,20),(54,'producto001',120.5,'pr001','Producto001',81,NULL,20),(55,'producto 002',35,'prod002','producto002',77,NULL,22),(56,'producto 003',85,'prod003','producto003',95,NULL,20),(57,'producto004',20.5,'prod004','producto004',93,NULL,20),(58,'005',55,'prod005','producto005',2,NULL,20),(59,'descripcion',100,'1020101','Producto de la lista numero 7697696',12,NULL,20),(60,'descripcion',200,'68769','Producto de la lista numero 596755',3,NULL,20),(61,'descripcion',80,'67557','Producto de la lista numero 5676565',7,NULL,20),(62,'descripcion',70,'088989','Producto de la lista numero 46464',2,NULL,20),(63,'descripcion',170,'85875785','Producto de la lista numero  768766',0,NULL,20),(64,'descripcion',10,'858655','Producto de la lista numero 565858',18,NULL,20),(65,'prod',120,'pr200','prod200',28,NULL,20),(66,'prod',100,'pr201','prod201',39,NULL,20),(67,'prod',50.5,'pr202','prod202',96,NULL,20),(68,'prod',120.5,'pr203','prod203',49,NULL,20),(69,'prod',200,'pr204','prod204',58,NULL,20),(70,'prod',205,'pr205','prod205',49,NULL,22),(71,'prod',90,'pr206','prod206',79,NULL,20),(72,'prod',90,'pr207','prod207',89,NULL,20);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id_role` bigint NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Administrador34'),(2,'Gerente'),(3,'Super Administrador2'),(4,'Estandar'),(6,'Administrador3'),(7,'Administrador44'),(11,'Administrador');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `state`
--

DROP TABLE IF EXISTS `state`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `state` (
  `id_state` bigint NOT NULL AUTO_INCREMENT,
  `state_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_state`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state`
--

LOCK TABLES `state` WRITE;
/*!40000 ALTER TABLE `state` DISABLE KEYS */;
INSERT INTO `state` VALUES (4,'Puebla24'),(5,'Morelosx'),(10,'CDMX'),(16,'Zacatecas 3'),(17,'Zacatecas23'),(26,'Michoacan2'),(27,'Galletas'),(28,'Veracruz'),(29,'Colima'),(30,'Tamaulipas'),(31,'Guerrero 2'),(32,'Guerrero'),(33,'Tlaxcala'),(34,'Durango'),(35,'Coahuila'),(36,'Morelos3'),(37,'GUERRERO6'),(38,'Morelos3'),(39,'Morelos4'),(40,'Guerrero'),(41,'Guerrero135');
/*!40000 ALTER TABLE `state` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id_supplier` bigint NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(255) DEFAULT NULL,
  `id_category` bigint DEFAULT NULL,
  PRIMARY KEY (`id_supplier`),
  KEY `FKk9ai9trt7gf7sxjc9tq8dj2q6` (`id_category`),
  CONSTRAINT `FKk9ai9trt7gf7sxjc9tq8dj2q6` FOREIGN KEY (`id_category`) REFERENCES `category` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (20,'Gansito',14),(21,'Trupper',52),(22,'Gamesa',14),(24,'Golosinas 123',17);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id_user` bigint NOT NULL,
  `id_role` bigint NOT NULL,
  PRIMARY KEY (`id_user`,`id_role`),
  KEY `FK2aam9nt2tv8vcfymi3jo9c314` (`id_role`),
  CONSTRAINT `FK2aam9nt2tv8vcfymi3jo9c314` FOREIGN KEY (`id_role`) REFERENCES `role` (`id_role`),
  CONSTRAINT `FKedkciuxmeed3qpg8c5qxs7hd8` FOREIGN KEY (`id_user`) REFERENCES `usuario` (`id_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (3,1),(5,1),(6,1),(7,1),(9,1),(10,1),(20,1),(24,1),(25,1),(5,2),(9,2),(3,3),(9,3),(10,3),(24,3),(6,4),(8,4),(3,6),(8,6),(9,6),(24,6),(26,7),(3,11),(4,11);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_user` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `id_person` bigint DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  KEY `FKjda6j47ry8kelhav7d3asj7bu` (`id_person`),
  CONSTRAINT `FKjda6j47ry8kelhav7d3asj7bu` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (3,'x','x',3),(4,'j','j',4),(5,'n','n',6),(6,'1','1',8),(7,'c','c',9),(8,'u','u',10),(9,'j','j',16),(10,'nes123','nes123',17),(20,'w','w',37),(24,'1','1',42),(25,'s','s',44),(26,'w','wx',46),(27,'password8563252960364823','usuario8563252960364823',60),(28,'password3000','n@n.gmai.com',61),(29,'password1728093189','munozjimeneznestor@gmail.com',62);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-03-22 20:13:17
