-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 12. Jan 2018 um 16:53
-- Server-Version: 10.1.25-MariaDB
-- PHP-Version: 5.6.31

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

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bmdbase`
--

CREATE TABLE `bmdbase` (
  `id` int(11) NOT NULL,
  `titel` varchar(20) NOT NULL,
  `title` varchar(20) NOT NULL,
  `regie` varchar(300) DEFAULT NULL,
  `genre` varchar(300) DEFAULT NULL,
  `schauspieler` varchar(300) DEFAULT NULL,
  `produzent` varchar(300) DEFAULT NULL,
  `studio` varchar(300) DEFAULT NULL,
  `fsk` int(11) DEFAULT NULL,
  `sprache` varchar(500) DEFAULT NULL,
  `laenge` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `land` varchar(200) DEFAULT NULL,
  `farbe` tinyint(1) DEFAULT NULL,
  `bewertung` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Daten für Tabelle `bmdbase`
--

INSERT INTO `bmdbase` (`id`, `titel`, `title`, `regie`, `genre`, `schauspieler`, `produzent`, `studio`, `fsk`, `sprache`, `laenge`, `date`, `land`, `farbe`, `bewertung`) VALUES
(1, 'Gladiator', 'Gladiator', 'Ridley Scott', 'Drama, Action, Adventure', 'Russel Crowe', NULL, NULL, 18, 'englisch, deutsch', 155, '2005-05-25', 'Amerika', NULL, 8),
(2, 'TESTFilm', 'TESTMovie', NULL, NULL, 'Russel Crowe', NULL, NULL, 18, 'deutsch', 140, '2018-01-01', NULL, NULL, NULL);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bmdbase`
--
ALTER TABLE `bmdbase`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `titel` (`titel`),
  ADD UNIQUE KEY `title` (`title`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `bmdbase`
--
ALTER TABLE `bmdbase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
