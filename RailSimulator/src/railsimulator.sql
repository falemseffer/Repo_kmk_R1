-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 31 Janvier 2013 à 22:48
-- Version du serveur: 5.5.24-log
-- Version de PHP: 5.3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `railsimulator`
--

-- --------------------------------------------------------

--
-- Structure de la table `canton`
--

CREATE TABLE IF NOT EXISTS `canton` (
  `idcanton` int(11) NOT NULL AUTO_INCREMENT,
  `nomcanton` varchar(45) DEFAULT NULL,
  `commentaire` varchar(45) DEFAULT NULL,
  `station_idstation` int(11) NOT NULL,
  `ligne_idligne` int(11) NOT NULL,
  PRIMARY KEY (`idcanton`),
  KEY `fk_canton_station_idx` (`station_idstation`),
  KEY `fk_canton_ligne1_idx` (`ligne_idligne`),
  KEY `FKAE7A6F838614B357` (`station_idstation`),
  KEY `FKAE7A6F835CFCE3BE` (`ligne_idligne`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `canton`
--

INSERT INTO `canton` (`idcanton`, `nomcanton`, `commentaire`, `station_idstation`, `ligne_idligne`) VALUES
(1, 'teeeeeeeeeeeeeeest', 'test', 1, 1),
(2, 'test2', 'test2', 2, 1),
(3, 'test3', 'test 3', 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `ligne`
--

CREATE TABLE IF NOT EXISTS `ligne` (
  `idligne` int(11) NOT NULL AUTO_INCREMENT,
  `nomligne` varchar(45) DEFAULT NULL,
  `commentaire` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idligne`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `ligne`
--

INSERT INTO `ligne` (`idligne`, `nomligne`, `commentaire`) VALUES
(1, 'Ligne 1', 'Ligne 1'),
(2, 'Ligne 2', 'Ligne 2');

-- --------------------------------------------------------

--
-- Structure de la table `station`
--

CREATE TABLE IF NOT EXISTS `station` (
  `idstation` int(11) NOT NULL AUTO_INCREMENT,
  `nomstation` varchar(45) DEFAULT NULL,
  `commentaire` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idstation`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Contenu de la table `station`
--

INSERT INTO `station` (`idstation`, `nomstation`, `commentaire`) VALUES
(1, 'Nation', 'nation'),
(2, 'vincenne', 'vincenne');

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `canton`
--
ALTER TABLE `canton`
  ADD CONSTRAINT `FKAE7A6F835CFCE3BE` FOREIGN KEY (`ligne_idligne`) REFERENCES `ligne` (`idligne`),
  ADD CONSTRAINT `canton_ibfk_1` FOREIGN KEY (`station_idstation`) REFERENCES `station` (`idstation`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `canton_ibfk_2` FOREIGN KEY (`ligne_idligne`) REFERENCES `ligne` (`idligne`) ON DELETE CASCADE ON UPDATE NO ACTION,
  ADD CONSTRAINT `FKAE7A6F838614B357` FOREIGN KEY (`station_idstation`) REFERENCES `station` (`idstation`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
