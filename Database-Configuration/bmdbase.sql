-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 08, 2018 at 07:00 PM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

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
-- Database: `bmdbase`
--

-- --------------------------------------------------------

--
-- Table structure for table `bmdbase`
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
  `date` date DEFAULT NULL,
  `land` varchar(200) DEFAULT NULL,
  `farbe` tinyint(1) DEFAULT NULL,
  `bewertung` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bmdbase`
--

INSERT INTO `bmdbase` (`id`, `titel`, `title`, `regie`, `genre`, `schauspieler`, `produzent`, `studio`, `fsk`, `sprache`, `laenge`, `date`, `land`, `farbe`, `bewertung`) VALUES
(1, 'Gladiator', 'Gladiator', 'Ridley Scott', 'Drama, Action, Adventure', 'Russel Crowe', NULL, NULL, 18, 'englisch, deutsch', 155, NULL, 'Amerika', NULL, 8);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bmdbase`
--
ALTER TABLE `bmdbase`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bmdbase`
--
ALTER TABLE `bmdbase`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
