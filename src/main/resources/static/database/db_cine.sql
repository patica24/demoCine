-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.7.22-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema db_cine
--

CREATE DATABASE IF NOT EXISTS db_cine;
USE db_cine;

--
-- Definition of table `tc_pelicula`
--

DROP TABLE IF EXISTS `tc_pelicula`;
CREATE TABLE `tc_pelicula` (
  `nid_pelicula` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cdes_pelicula` varchar(45) DEFAULT NULL,
  `dfec_publicacion` datetime DEFAULT NULL,
  `cdes_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nid_pelicula`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tc_pelicula`
--

/*!40000 ALTER TABLE `tc_pelicula` DISABLE KEYS */;
INSERT INTO `tc_pelicula` (`nid_pelicula`,`cdes_pelicula`,`dfec_publicacion`,`cdes_estado`) VALUES 
 (1,'Jurasic Park','1912-12-02 00:00:00','ACTIVO'),
 (30,'Terminator','1923-11-01 00:00:00','ACTIVO'),
 (31,'Toy Story zz','2019-08-06 00:00:00','ACTIVO'),
 (32,'Toy Story','2019-08-06 00:00:00','ACTIVO'),
 (33,'Toy Story zz','2020-03-06 00:00:00','INACTIVO');
/*!40000 ALTER TABLE `tc_pelicula` ENABLE KEYS */;


--
-- Definition of table `tc_turno`
--

DROP TABLE IF EXISTS `tc_turno`;
CREATE TABLE `tc_turno` (
  `nid_turno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cdes_turno` varchar(45) DEFAULT NULL,
  `cdes_estado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`nid_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tc_turno`
--

/*!40000 ALTER TABLE `tc_turno` DISABLE KEYS */;
INSERT INTO `tc_turno` (`nid_turno`,`cdes_turno`,`cdes_estado`) VALUES 
 (1,'9:00','ACTIVO'),
 (6,'12:10','ACTIVO'),
 (7,'12:30','INACTIVO'),
 (8,'13:30','ACTIVO'),
 (9,'14:00','ACTIVO');
/*!40000 ALTER TABLE `tc_turno` ENABLE KEYS */;


--
-- Definition of table `td_peliculaxturno`
--

DROP TABLE IF EXISTS `td_peliculaxturno`;
CREATE TABLE `td_peliculaxturno` (
  `nid_pelicula` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nid_turno` int(10) unsigned NOT NULL,
  PRIMARY KEY (`nid_pelicula`,`nid_turno`),
  KEY `FK_td_peliculaxturno_2` (`nid_turno`),
  CONSTRAINT `FK_td_peliculaxturno_1` FOREIGN KEY (`nid_pelicula`) REFERENCES `tc_pelicula` (`nid_pelicula`),
  CONSTRAINT `FK_td_peliculaxturno_2` FOREIGN KEY (`nid_turno`) REFERENCES `tc_turno` (`nid_turno`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `td_peliculaxturno`
--

/*!40000 ALTER TABLE `td_peliculaxturno` DISABLE KEYS */;
INSERT INTO `td_peliculaxturno` (`nid_pelicula`,`nid_turno`) VALUES 
 (1,1),
 (30,6),
 (30,7),
 (1,8),
 (30,8),
 (30,9);
/*!40000 ALTER TABLE `td_peliculaxturno` ENABLE KEYS */;


CREATE USER 'developer'@'localhost' IDENTIFIED BY 'desarrollo';

GRANT ALL PRIVILEGES ON db_cine.* TO 'developer'@'localhost';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
