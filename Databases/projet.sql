-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Ven 03 Mars 2017 à 15:07
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `assurance`
--

CREATE TABLE `assurance` (
  `id_assurance` int(11) NOT NULL,
  `etatAssr` varchar(4) NOT NULL,
  `DateDebut` varchar(20) NOT NULL,
  `datefin` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `assurance`
--

INSERT INTO `assurance` (`id_assurance`, `etatAssr`, `DateDebut`, `datefin`) VALUES
(1, 'ouii', '2017-03-03', '2016-06-06'),
(8, 'oui', '2017-03-01', '2017-03-01'),
(11, 'oui', '999.0', '55.9'),
(12, 'oui', '2016-01-01', '2016-8-26'),
(17, 'oui', '2016-02-02', '2017-1-26'),
(36, 'oui', '2017-02-28', '2017-02-28'),
(37, 'oui', '2016-03-03', '2018-1-26'),
(38, 'oui', '2016-04-04', '2019-1-26'),
(39, 'oui', '2016-05-05', '2020-1-26'),
(40, 'oui', '2016-06-04', '2021-1-26'),
(41, 'oui', '2016-07-05', '2022-1-26');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type` varchar(255) NOT NULL DEFAULT 'user',
  `email` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `type`, `email`, `nom`, `prenom`) VALUES
(1, 'test', 'test', 'user', '', '', ''),
(2, 'jaafar', 'jaafar', 'admin', 'jaafar@jaafar', 'jaafar', 'jaafar'),
(3, 'mehdi', 'mehdi', 'Utilisateur', 'mehdi', 'mehdi', 'mehdi'),
(4, 'omar', 'omar', 'Utilisateur', 'omar', 'omar ', 'omar');

-- --------------------------------------------------------

--
-- Structure de la table `vehicule`
--

CREATE TABLE `vehicule` (
  `immatriculation` varchar(40) NOT NULL,
  `dateEntree` date NOT NULL,
  `dateSortie` date NOT NULL,
  `marque` varchar(40) NOT NULL,
  `modele` varchar(40) NOT NULL,
  `etat` varchar(40) NOT NULL,
  `id_assurance` int(11) NOT NULL,
  `emission` double NOT NULL,
  `kilometrage` int(11) NOT NULL,
  `consommation` double NOT NULL,
  `age` int(11) NOT NULL,
  `carburant` varchar(40) NOT NULL,
  `pfiscal` int(11) NOT NULL,
  `poidsmax` int(11) NOT NULL,
  `type` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vehicule`
--

INSERT INTO `vehicule` (`immatriculation`, `dateEntree`, `dateSortie`, `marque`, `modele`, `etat`, `id_assurance`, `emission`, `kilometrage`, `consommation`, `age`, `carburant`, `pfiscal`, `poidsmax`, `type`) VALUES
('980336zz', '2016-06-26', '2017-06-26', 'Renault', 'Megane', 'Disponible', 1, 6.7, 1000, 15.9, 1, 'essence', 4, 3200, 'Camion'),
('Camion1', '2016-01-01', '2016-08-26', 'volvo', 'volvo 40', 'En panne', 12, 7.8, 11123, 15.9, 20, 'diesel', 15, 3000, 'Camion'),
('Camion2', '2016-02-02', '2017-01-26', 'volvo', 'volvo 40', 'Disponible', 17, 12.2, 12004, 15.9, 20, 'diesel', 15, 2900, 'Camion'),
('CamionTest', '2017-03-03', '2018-03-24', 'MAN', 'MAN', 'Disponible', 36, 15.5, 12456, 12.4, 12, 'Diesel', 15, 2650, 'Voiture'),
('moto', '2017-03-02', '2017-03-24', 'MBK', 'MBK modéle', 'En panne', 8, 0, 0, 0, 11, '0', 0, 0, 'Moto'),
('Voiture1', '2016-01-01', '2016-08-26', 'Renault', '1997.0', 'En panne', 12, 55.9, 11123, 6.7, 20, 'diesel', 8, 2870, 'Voiture'),
('Voiture2', '2016-02-02', '2017-01-26', 'Renault', '1997.0', 'Disponible', 17, 55.9, 12004, 6.7, 20, 'diesel', 8, 3000, 'Voiture'),
('Voiture3', '2016-03-03', '2018-01-26', 'Renault', '2002', 'Disponible', 37, 10.5, 1111, 42902, 15, 'diesel', 8, 2500, 'Voiture'),
('Voiture4', '2016-04-04', '2019-01-26', 'Renault', '2010', 'Disponible', 38, 20.5, 700, 42903, 7, 'diesel', 8, 4100, 'Voiture'),
('Voiture5', '2016-05-05', '2020-01-26', 'Opel', '2010', 'Disponible', 39, 20.5, 760, 42904, 7, 'diesel', 8, 4000, 'Voiture'),
('Voiture6', '2016-06-04', '2021-01-26', 'Opel', '2010', 'Disponible', 40, 20.5, 820, 42905, 7, 'Essence', 8, 4000, 'Voiture'),
('Voiture7', '2016-07-05', '2022-01-26', 'Opel', '2016', 'Disponible', 41, 15.5, 880, 42906, 1, 'diesel', 8, 1200, 'Voiture');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `assurance`
--
ALTER TABLE `assurance`
  ADD PRIMARY KEY (`id_assurance`);

--
-- Index pour la table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vehicule`
--
ALTER TABLE `vehicule`
  ADD PRIMARY KEY (`immatriculation`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `assurance`
--
ALTER TABLE `assurance`
  MODIFY `id_assurance` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- AUTO_INCREMENT pour la table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
