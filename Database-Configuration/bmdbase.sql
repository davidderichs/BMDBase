-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 07. Jan 2018 um 21:26
-- Server-Version: 10.1.28-MariaDB
-- PHP-Version: 7.1.11

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bmdbase`
--
CREATE DATABASE IF NOT EXISTS `bmdbase` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bmdbase`;

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bmdbase`
--

CREATE TABLE `bmdbase` (
  `id` int(11) NOT NULL,
  `titel` varchar(300) NOT NULL,
  `title` varchar(300) NOT NULL,
  `regie` varchar(300) DEFAULT NULL,
  `genre` varchar(300) DEFAULT NULL,
  `schauspieler` varchar(300) DEFAULT NULL,
  `produzent` varchar(300) DEFAULT NULL,
  `studio` varchar(300) DEFAULT NULL,
  `fsk` int(11) DEFAULT NULL,
  `sprache` varchar(500) DEFAULT NULL,
  `laenge` int(11) DEFAULT NULL,
  `date` int(11) DEFAULT NULL,
  `land` varchar(200) DEFAULT NULL,
  `farbe` tinyint(1) DEFAULT NULL,
  `bewertung` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Metadaten
--
USE `phpmyadmin`;

--
-- Metadaten für Tabelle bmdbase
--

--
-- Metadaten für Datenbank bmdbase
--
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
