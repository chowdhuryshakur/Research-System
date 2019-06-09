-- MySQL dump 10.16  Distrib 10.1.28-MariaDB, for Win32 (AMD64)
--
-- Host: localhost    Database: managingresearch
-- ------------------------------------------------------
-- Server version	10.1.28-MariaDB

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
-- Table structure for table `regstudent`
--

DROP TABLE IF EXISTS `regstudent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `regstudent` (
  `id` int(11) NOT NULL,
  `semester` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `regstudent`
--

LOCK TABLES `regstudent` WRITE;
/*!40000 ALTER TABLE `regstudent` DISABLE KEYS */;
INSERT INTO `regstudent` VALUES (135,'sum19'),(147,'sum19'),(149,'sum19'),(150,'sum19'),(151,'sum19'),(152,'sum19'),(153,'sum19'),(154,'sum19'),(155,'sum19'),(156,'sum19'),(162,'sum19');
/*!40000 ALTER TABLE `regstudent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spass`
--

DROP TABLE IF EXISTS `spass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spass` (
  `sid` int(11) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spass`
--

LOCK TABLES `spass` WRITE;
/*!40000 ALTER TABLE `spass` DISABLE KEYS */;
INSERT INTO `spass` VALUES (147,'sss');
/*!40000 ALTER TABLE `spass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `batch` int(11) DEFAULT NULL,
  `dept` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentapply`
--

DROP TABLE IF EXISTS `studentapply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentapply` (
  `id` int(11) NOT NULL,
  `topic` varchar(50) DEFAULT NULL,
  `groupmembers` varchar(50) DEFAULT NULL,
  `supervisor` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `chairmanstatus` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentapply`
--

LOCK TABLES `studentapply` WRITE;
/*!40000 ALTER TABLE `studentapply` DISABLE KEYS */;
INSERT INTO `studentapply` VALUES (135,'Spring, Java','144,137','KMH','ok','null'),(149,'Spring, AI','145,131','KMH','null','null'),(150,'Spring, AI','145,131','KMH','null','null'),(151,'Spring, AI','145,131','KMH','null','null'),(152,'Spring, AI','145,131','KMH','null','null'),(155,'Spring, AI','145,131','KMH','null','null'),(162,'Spring, AI','145,131','KMH','null','null');
/*!40000 ALTER TABLE `studentapply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supervisor`
--

DROP TABLE IF EXISTS `supervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `supervisor` (
  `initial` varchar(50) NOT NULL,
  `superviseCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`initial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supervisor`
--

LOCK TABLES `supervisor` WRITE;
/*!40000 ALTER TABLE `supervisor` DISABLE KEYS */;
/*!40000 ALTER TABLE `supervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `initial` varchar(50) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`initial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tempspass`
--

DROP TABLE IF EXISTS `tempspass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tempspass` (
  `sid` int(11) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tempspass`
--

LOCK TABLES `tempspass` WRITE;
/*!40000 ALTER TABLE `tempspass` DISABLE KEYS */;
INSERT INTO `tempspass` VALUES (147,'sss');
/*!40000 ALTER TABLE `tempspass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temptpass`
--

DROP TABLE IF EXISTS `temptpass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temptpass` (
  `tin` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temptpass`
--

LOCK TABLES `temptpass` WRITE;
/*!40000 ALTER TABLE `temptpass` DISABLE KEYS */;
/*!40000 ALTER TABLE `temptpass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temspass`
--

DROP TABLE IF EXISTS `temspass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temspass` (
  `sid` int(11) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temspass`
--

LOCK TABLES `temspass` WRITE;
/*!40000 ALTER TABLE `temspass` DISABLE KEYS */;
/*!40000 ALTER TABLE `temspass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tpass`
--

DROP TABLE IF EXISTS `tpass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tpass` (
  `teacherinitial` varchar(50) NOT NULL,
  `pass` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`teacherinitial`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tpass`
--

LOCK TABLES `tpass` WRITE;
/*!40000 ALTER TABLE `tpass` DISABLE KEYS */;
INSERT INTO `tpass` VALUES ('KMH','kmh'),('SM','sm');
/*!40000 ALTER TABLE `tpass` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-08 19:20:08
