/*
SQLyog Community v12.2.6 (64 bit)
MySQL - 5.6.23 : Database - demo_test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`demo_test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `demo_test`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `emp_id` varchar(100) COLLATE utf8_bin NOT NULL,
  `fname` varchar(30) COLLATE utf8_bin NOT NULL,
  `lname` varchar(30) COLLATE utf8_bin NOT NULL,
  `job_id` int(30) NOT NULL,
  `job_lvl` int(3) NOT NULL,
  `hire_date` date NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employee` */

insert  into `employee`(`emp_id`,`fname`,`lname`,`job_id`,`job_lvl`,`hire_date`,`status`) values 
('asdlkasdlkjasdlk','张','三',23456,2,'2016-12-14',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
