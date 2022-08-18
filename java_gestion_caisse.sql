-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2021 at 07:21 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_gestion_caisse`
--

-- --------------------------------------------------------

--
-- Table structure for table `client`
--

CREATE TABLE `client` (
  `id_client` int(11) NOT NULL,
  `nom_client` varchar(50) NOT NULL,
  `ville_client` varchar(15) NOT NULL,
  `adresse_client` text NOT NULL,
  `telephone_client` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `client`
--

INSERT INTO `client` (`id_client`, `nom_client`, `ville_client`, `adresse_client`, `telephone_client`) VALUES
(1, 'SOLOFONDRAIBE Donné ', 'FIANARANTSOA', 'Cité FITIAVANA P.52 Andrainjato ', '+261344626128'),
(3, 'Donné Alphonse Solofondraibe', 'Fianarantsoa', 'Cité 31 Ankazobe Fianarantsoa', '+261324566677'),
(5, 'Danny', 'Antananarivo', 'Cité de officier Fort voyron Fiadanana', '+2613255963'),
(6, 'Natacha VOLOLOMBOAHIRANA', 'Fianarantsoa', 'TM P43', '+261324567834'),
(7, 'Ralphonse', 'Fianara', 'TM P52', '+261324567834'),
(8, 'Ginah', 'Fianarantsoa', 'TM P43 ANDRAINJATO', '0345645623');

-- --------------------------------------------------------

--
-- Table structure for table `commandes`
--

CREATE TABLE `commandes` (
  `id_commande` int(11) NOT NULL,
  `date_commande` varchar(10) NOT NULL,
  `id_client` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `marque` varchar(10) NOT NULL,
  `caracteristique` text NOT NULL,
  `prix` int(11) NOT NULL,
  `quantiter` int(11) NOT NULL,
  `montant` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `commandes`
--

INSERT INTO `commandes` (`id_commande`, `date_commande`, `id_client`, `code`, `nom`, `marque`, `caracteristique`, `prix`, `quantiter`, `montant`) VALUES
(18, '2021-02-25', 1, 1, 'Ordinateur Portable HP', 'HP', 'Core i3 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 2, 4000000),
(19, '2021-01-25', 1, 3, 'Ordinateur Portable', 'LENOVO', 'Core i5 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 1, 2000000),
(20, '2021-03-25', 8, 2, 'Ordinateur Portable HP', 'ASUS', 'Core i5 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 2, 4000000),
(21, '2021-01-25', 8, 1, 'Ordinateur Portable HP', 'HP', 'Core i3 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 1, 2000000),
(22, '2021-01-25', 7, 2, 'Ordinateur Portable HP', 'ASUS', 'Core i5 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 1, 2000000),
(23, '2021-01-25', 7, 3, 'Ordinateur Portable', 'LENOVO', 'Core i5 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 2, 4000000),
(24, '2021-05-25', 7, 2, 'Ordinateur Portable HP', 'ASUS', 'Core i5 8th Gen\r dure: 250 GB SSD\r 8 GB de RAM', 2000000, 2, 4000000);

-- --------------------------------------------------------

--
-- Table structure for table `facture`
--

CREATE TABLE `facture` (
  `num` int(11) NOT NULL,
  `client` varchar(50) NOT NULL,
  `date` varchar(10) NOT NULL,
  `total` int(11) NOT NULL,
  `remise` double NOT NULL,
  `rendu` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `facture`
--

INSERT INTO `facture` (`num`, `client`, `date`, `total`, `remise`, `rendu`) VALUES
(1, 'SOLOFONDRAIBE Donné Alphonse', '2021-01-21', 102500, 103000, 500),
(2, 'SOLOGONDRAIBE Danni', '2023-02-12', 500000, 500000, 0),
(3, 'SOLOFONDRAIBE  Alphonse', '2021-03-21', 105000, 11000, 500),
(4, 'SOLOFONDRAIBE ', '2021-04-25', 103000, 103000, 0),
(5, 'SOLOFONDRAIBE ', '2021-04-20', 103000, 103000, 0),
(6, 'SOLOFONDRAIBE Rolland ', '2021-05-20', 103000, 103000, 0),
(7, 'RAKOTO Albert', '2020-01-21', 10250, 103000, 500),
(8, 'Andriamaholison Albert', '2022-11-21', 102500, 103000, 500);

-- --------------------------------------------------------

--
-- Table structure for table `marque`
--

CREATE TABLE `marque` (
  `marque` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `marque`
--

INSERT INTO `marque` (`marque`) VALUES
('APPLE'),
('ASUS'),
('HP'),
('LENOVO'),
('TOSHIBA');

-- --------------------------------------------------------

--
-- Table structure for table `produits`
--

CREATE TABLE `produits` (
  `code` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `marque` varchar(11) NOT NULL,
  `Caracteristique` text NOT NULL,
  `Prix` int(11) NOT NULL,
  `Stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `produits`
--

INSERT INTO `produits` (`code`, `Nom`, `marque`, `Caracteristique`, `Prix`, `Stock`) VALUES
(1, 'Ordinateur Portable HP', 'HP', 'Core i3 8th Gen\r\ndure: 250 GB SSD\r\n8 GB de RAM', 2000000, 10),
(2, 'Ordinateur Portable HP', 'ASUS', 'Core i5 8th Gen\r\ndure: 250 GB SSD\r\n8 GB de RAM', 2000000, 10),
(3, 'Ordinateur Portable', 'LENOVO', 'Core i5 8th Gen\r\ndure: 250 GB SSD\r\n8 GB de RAM', 2000000, 10),
(4, 'Ordinateur Portable', 'APPLE', 'Core i5 8th Gen\r\ndure: 250 GB SSD\r\n8 GB de RAM', 2500000, 10);

-- --------------------------------------------------------

--
-- Table structure for table `responsable`
--

CREATE TABLE `responsable` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `role` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `tel` varchar(13) NOT NULL,
  `CIN` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `responsable`
--

INSERT INTO `responsable` (`id`, `nom`, `password`, `role`, `email`, `tel`, `CIN`) VALUES
(3, 'Danni', '4a4bd93d6d3bc13074b3d07086c3c558', 'Caissier', 'admi@gmail.com', '+261324626128', '201011023000'),
(4, 'Alphonse', '9b4b5f28aef916bd011af918060ce34', 'Caissier', 'alphonse@gmail.com', '+261344626128', '201011023045'),
(5, 'Natacha', '81dc9bdb52d04dc2036dbd8313ed055', 'Caissier', 'vololomboahirana@gmail.com', '+26102346673', '121331234567'),
(7, 'Natacha', 'a6702776e96babb8f1326fd271644ce', 'Admin', 'natachavololomboahirana@gmail.com', '+261342895534', '201022354678');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`id_client`);

--
-- Indexes for table `commandes`
--
ALTER TABLE `commandes`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `id_client` (`id_client`);

--
-- Indexes for table `facture`
--
ALTER TABLE `facture`
  ADD PRIMARY KEY (`num`);

--
-- Indexes for table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`marque`);

--
-- Indexes for table `produits`
--
ALTER TABLE `produits`
  ADD PRIMARY KEY (`code`),
  ADD KEY `marque` (`marque`);

--
-- Indexes for table `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `client`
--
ALTER TABLE `client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `commandes`
--
ALTER TABLE `commandes`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `produits`
--
ALTER TABLE `produits`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `responsable`
--
ALTER TABLE `responsable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `commandes_ibfk_1` FOREIGN KEY (`id_client`) REFERENCES `client` (`id_client`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `produits_ibfk_1` FOREIGN KEY (`marque`) REFERENCES `marque` (`marque`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
