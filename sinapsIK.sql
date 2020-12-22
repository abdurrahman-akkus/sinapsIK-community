-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                8.0.21 - MySQL Community Server - GPL
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- sinaps_yazilim için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `sinapsCV` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `sinapsCV`;

-- tablo yapısı dökülüyor sinaps_yazilim.general
CREATE TABLE IF NOT EXISTS `general` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `last_name` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `identity` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `date_of_birth` date NOT NULL,
  `nation` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL,
  `gender` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci NOT NULL COMMENT 'M:Male,F:Female',
  `phone` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `gsm` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `military` json DEFAULT NULL COMMENT 'D:Done,S:Suspended,E:Exempt(F:Finite,I:Infinite)',
  `driver_licences` text CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci,
  `father_name` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `father_job` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `mother_name` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `mother_job` varchar(20) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `siblings_count` int DEFAULT NULL,
  `marital` json DEFAULT NULL COMMENT 'S:Single,M:Married',
  `education_level` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL COMMENT '0:None,1:Primary,2:Secondary,3:High,4:College,5:Graduate,6:Post Graduate',
  `schools` json DEFAULT NULL,
  `courses` json DEFAULT NULL,
  `experiences` json DEFAULT NULL COMMENT 'Reason-->0:İstifa,1:Sağlık,2:Kovulma,3:Diğer',
  `foreign_languages` json DEFAULT NULL,
  `programs` json DEFAULT NULL,
  `office_equipments` json DEFAULT NULL,
  `lives_with` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL COMMENT 'P:Parents,F:Family,S:Single,O:Others',
  `home_ownership` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL COMMENT 'O:Owner,R:Renter',
  `illnesses` json DEFAULT NULL,
  `jobs` json DEFAULT NULL,
  `any_salary` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `salary` int DEFAULT NULL,
  `asap` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `last_statement` text CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci,
  `credentials` json DEFAULT NULL,
  `request_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `law_conformation` char(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `is_active` int DEFAULT NULL,
  `is_seen` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `general_un` (`identity`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci ROW_FORMAT=DYNAMIC;

-- Veri çıktısı seçilmemişti

-- tablo yapısı dökülüyor sinaps_yazilim.languages
CREATE TABLE IF NOT EXISTS `languages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `code` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=615 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Veri çıktısı seçilmemişti

-- tablo yapısı dökülüyor sinaps_yazilim.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(25) NOT NULL,
  `password` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `yetki` int DEFAULT NULL,
  `aktif_mi` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Veri çıktısı seçilmemişti

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
