# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : usd


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `usd`
    CHARACTER SET 'utf8'
    COLLATE 'utf8_general_ci';

USE `usd`;

#
# Structure for the `user_profile` table : 
#

CREATE TABLE `user_profile` (
  `id` int(2) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `user_status` table : 
#

CREATE TABLE `user_status` (
  `id` int(2) unsigned NOT NULL,
  `title` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Structure for the `user` table : 
#

CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `status_id` int(2) unsigned NOT NULL,
  `profile_id` int(2) unsigned NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `status_id` (`status_id`),
  KEY `profile_id` (`profile_id`),
  CONSTRAINT `user_fk` FOREIGN KEY (`status_id`) REFERENCES `user_status` (`id`),
  CONSTRAINT `user_fk1` FOREIGN KEY (`profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for the `user_status` table  (LIMIT 0,500)
#

INSERT INTO `user_status` (`id`, `title`) VALUES 
  (1,'Email not confirmed'),
  (2,'Active'),
  (3,'Disabled'),
  (4,'Deleted');
COMMIT;

#
# Data for the `user_profile` table  (LIMIT 0,500)
#

INSERT INTO `user_profile` (`id`, `title`) VALUES 
  (1,'Administrator'),
  (2,'User');
COMMIT;

#
# Data for the `user` table  (LIMIT 0,500)
#

INSERT INTO `user` (`id`, `status_id`, `profile_id`, `first_name`, `last_name`, `email`, `password`) VALUES 
  (2,1,2,'Admin','Adminian','admin@mail.com','$2a$10$qLgdeSHG/cAyE1YScw0sM.WeG0cBQLgYDeTYOfT3h5V1kC9CAqsQ2');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;