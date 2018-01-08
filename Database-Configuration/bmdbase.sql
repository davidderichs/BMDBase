-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 08. Jan 2018 um 16:13
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
-- Daten für Tabelle `bmdbase`
--

INSERT INTO `bmdbase` (`id`, `titel`, `title`, `regie`, `genre`, `schauspieler`, `produzent`, `studio`, `fsk`, `sprache`, `laenge`, `date`, `land`, `farbe`, `bewertung`) VALUES
(1, 'Gladiator', 'Gladiator', 'Ridley Scott', 'Drama, Action, Adventure', 'Russel Crowe', NULL, NULL, 18, 'englisch, deutsch', 155, 959212800, 'Amerika', NULL, 8);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bmdbase`
--
ALTER TABLE `bmdbase`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bmdbase`
--
ALTER TABLE `bmdbase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
