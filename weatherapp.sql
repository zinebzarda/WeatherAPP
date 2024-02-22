-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : jeu. 22 fév. 2024 à 17:20
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `weatherapp`
--

-- --------------------------------------------------------

--
-- Structure de la table `city`
--

CREATE TABLE `city` (
  `cityId` int(11) NOT NULL,
  `cityName` varchar(30) DEFAULT NULL,
  `currentTemperature` double DEFAULT NULL,
  `currentHumidity` double DEFAULT NULL,
  `currentWindSpeed` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `city`
--

INSERT INTO `city` (`cityId`, `cityName`, `currentTemperature`, `currentHumidity`, `currentWindSpeed`) VALUES
(1, 'CASA', 12, 12.22, 13),
(2, 'tanger', 12, 13, 11),
(4, 'CASA', 11, 11, 22);

-- --------------------------------------------------------

--
-- Structure de la table `cityhistory`
--

CREATE TABLE `cityhistory` (
  `historicalDataId` int(11) NOT NULL,
  `cityId` int(11) DEFAULT NULL,
  `eventDate` date DEFAULT NULL,
  `temperature` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `cityhistory`
--

INSERT INTO `cityhistory` (`historicalDataId`, `cityId`, `eventDate`, `temperature`) VALUES
(1, 2, '2024-02-21', 44),
(2, 2, '2024-02-23', 11),
(4, 4, '2020-12-12', 11),
(8, 2, '2024-10-12', 11);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`cityId`);

--
-- Index pour la table `cityhistory`
--
ALTER TABLE `cityhistory`
  ADD PRIMARY KEY (`historicalDataId`),
  ADD KEY `cityId` (`cityId`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `cityhistory`
--
ALTER TABLE `cityhistory`
  ADD CONSTRAINT `cityhistory_ibfk_1` FOREIGN KEY (`cityId`) REFERENCES `city` (`cityId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
