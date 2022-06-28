# CREATE DATABASE  IF NOT EXISTS `user_order` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `user_order`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `first_name` varchar(45) NOT NULL,
                        `last_name` varchar(45) NOT NULL,
                        `email` varchar(45) NOT NULL,
                        `city` varchar(45) NOT NULL,
                        PRIMARY KEY (`id`),
                        UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- Dumping data for table `user`
LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Anna','Smith','annasmith@mail.com','New-York'),(4,'Alise','Sims','alisesims@mail.com','New-York'),(5,'Sara','Sims','sarasims@mail.com','California'),(8,'sara','Smith','annabelsmithmail.com','New-Castle'),(14,'null','Smith','a@mail.com','New-Castle');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `price` decimal(10,2) NOT NULL,
                         `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
                         `user_id` bigint NOT NULL,
                         PRIMARY KEY (`id`,`user_id`),
                         KEY `fk_order_user_idx` (`user_id`),
                         CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Dumping data for table `order`
LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,150.00,'2022-02-16 06:20:18',1),(6,222.00,'2022-02-16 14:20:52',1),(7,222.00,'2022-03-03 11:15:09',1),(8,234.00,'2022-03-11 15:13:34',1),(9,235.00,'2022-03-11 15:15:46',1),(10,242.00,'2022-03-11 15:37:31',1);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;
