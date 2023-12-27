-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: shoes_web
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fullName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phoneNumber` int DEFAULT NULL,
  `province` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `district` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `commune` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `hamlet` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `orderDetailsId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Cart_fk0` (`userId`),
  KEY `Cart_fk1` (`orderDetailsId`),
  CONSTRAINT `Cart_fk0` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `Cart_fk1` FOREIGN KEY (`orderDetailsId`) REFERENCES `orderdetails` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Football','football-shoes'),(2,'Football','football-shoes'),(3,'Football','football-shoes'),(4,'Football','football-shoes');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT '0',
  `productSizeId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Inventory_productsize_id_fk` (`productSizeId`),
  CONSTRAINT `Inventory_productsize_id_fk` FOREIGN KEY (`productSizeId`) REFERENCES `productsize` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `status` int DEFAULT '0',
  `note` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `totalAmount` decimal(10,1) DEFAULT NULL,
  `addressId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Order_fk0` (`addressId`),
  CONSTRAINT `Order_fk0` FOREIGN KEY (`addressId`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orderdetails` (
  `id` int NOT NULL AUTO_INCREMENT,
  `quantity` int DEFAULT NULL,
  `subTotal` decimal(10,1) DEFAULT NULL,
  `orderId` int DEFAULT NULL,
  `productSizeId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `OrderDetails_fk0` (`orderId`),
  KEY `OrderDetails_fk1` (`productSizeId`),
  CONSTRAINT `OrderDetails_fk0` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`),
  CONSTRAINT `OrderDetails_fk1` FOREIGN KEY (`productSizeId`) REFERENCES `productsize` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `content` varchar(3000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `shortDescription` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `price` decimal(10,1) DEFAULT NULL,
  `rating` decimal(10,1) DEFAULT NULL,
  `modelUrl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `slug` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `categoryId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_category_id_fk` (`categoryId`),
  CONSTRAINT `product_category_id_fk` FOREIGN KEY (`categoryId`) REFERENCES `category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productimage`
--

DROP TABLE IF EXISTS `productimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productimage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `imageUrl` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ProductImage_fk0` (`productId`),
  CONSTRAINT `ProductImage_fk0` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productimage`
--

LOCK TABLES `productimage` WRITE;
/*!40000 ALTER TABLE `productimage` DISABLE KEYS */;
/*!40000 ALTER TABLE `productimage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsize`
--

DROP TABLE IF EXISTS `productsize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productsize` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sizeId` int DEFAULT NULL,
  `productId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `ProductSize_fk0` (`sizeId`),
  KEY `ProductSize_fk1` (`productId`),
  CONSTRAINT `ProductSize_fk0` FOREIGN KEY (`sizeId`) REFERENCES `size` (`id`),
  CONSTRAINT `ProductSize_fk1` FOREIGN KEY (`productId`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsize`
--

LOCK TABLES `productsize` WRITE;
/*!40000 ALTER TABLE `productsize` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsize` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `size`
--

DROP TABLE IF EXISTS `size`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `size` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sizeName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `size`
--

LOCK TABLES `size` WRITE;
/*!40000 ALTER TABLE `size` DISABLE KEYS */;
/*!40000 ALTER TABLE `size` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `fullName` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `birthDay` date DEFAULT NULL,
  `admin` tinyint(1) DEFAULT '0',
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (6,'hoanghuydev','tranvohoanghuy12ab@gmail.com','$2a$12$n1ZRw5rmlRGU0uqK6USVR.p8i66degNqeanwUZK9j0hdgDF8gfvVm','Tran Vo Hoang Huy',NULL,0,'2023-12-27 08:23:38',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `useraddress`
--

DROP TABLE IF EXISTS `useraddress`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `useraddress` (
  `id` int NOT NULL AUTO_INCREMENT,
  `addressId` int DEFAULT NULL,
  `userId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `UserAddress_fk0` (`addressId`),
  KEY `UserAddress_fk1` (`userId`),
  CONSTRAINT `UserAddress_fk0` FOREIGN KEY (`addressId`) REFERENCES `address` (`id`),
  CONSTRAINT `UserAddress_fk1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `useraddress`
--

LOCK TABLES `useraddress` WRITE;
/*!40000 ALTER TABLE `useraddress` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraddress` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userorder`
--

DROP TABLE IF EXISTS `userorder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userorder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `orderId` int DEFAULT NULL,
  `createAt` timestamp NULL DEFAULT NULL,
  `updateAt` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `UserOrder_fk0` (`userId`),
  KEY `UserOrder_fk1` (`orderId`),
  CONSTRAINT `UserOrder_fk0` FOREIGN KEY (`userId`) REFERENCES `user` (`id`),
  CONSTRAINT `UserOrder_fk1` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userorder`
--

LOCK TABLES `userorder` WRITE;
/*!40000 ALTER TABLE `userorder` DISABLE KEYS */;
/*!40000 ALTER TABLE `userorder` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-27 16:02:06
