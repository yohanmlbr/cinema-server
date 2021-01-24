-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 24 jan. 2021 à 18:36
-- Version du serveur :  10.1.37-MariaDB
-- Version de PHP :  7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `cinema`
--
DROP DATABASE IF EXISTS `cinema`;
CREATE DATABASE IF NOT EXISTS `cinema` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `cinema`;

-- --------------------------------------------------------

--
-- Structure de la table `acteur`
--

CREATE TABLE `acteur` (
  `id` int(4) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) DEFAULT NULL,
  `date_naissance` date DEFAULT NULL,
  `date_deces` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `acteur`
--

INSERT INTO `acteur` (`id`, `nom`, `prenom`, `date_naissance`, `date_deces`) VALUES
(1, 'Reno', 'Jean', '1948-07-30', NULL),
(2, 'Portman', 'Natalie', '1981-06-09', NULL),
(3, 'Dujardin', 'Jean', '1972-06-19', NULL),
(4, 'Bourvil', 'André', '1917-07-27', '1970-09-23'),
(5, 'De Funes', 'Louis', '1914-08-31', '1983-01-27'),
(6, 'Anglade', 'Jean-Hugues', '1955-07-29', NULL),
(7, 'Lambert', 'Christophe', '1957-03-29', NULL),
(8, 'Craig', 'Daniel', '1968-03-02', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` varchar(2) NOT NULL,
  `libelle` varchar(20) NOT NULL,
  `image` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id`, `libelle`, `image`) VALUES
('AC', 'Action', 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/M9-pistolet.jpg/220px-M9-pistolet.jpg'),
('CO', 'Comédie', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/e4/Eduard_von_Gr%C3%BCtzner_Falstaff.jpg/220px-Eduard_von_Gr%C3%BCtzner_Falstaff.jpg'),
('PO', 'Policier', 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Police-IMG_4105.jpg/300px-Police-IMG_4105.jpg'),
('WE', 'Western', 'https://upload.wikimedia.org/wikipedia/commons/5/53/Buffalo_Bills_Wild_West_Show%2C_1890.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

CREATE TABLE `film` (
  `id` int(4) NOT NULL,
  `titre` varchar(30) NOT NULL,
  `duree` int(3) NOT NULL,
  `date_sortie` date NOT NULL,
  `budget` int(8) NOT NULL,
  `montant_recette` int(8) NOT NULL,
  `realisateur_id` int(2) NOT NULL,
  `categorie_id` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `film`
--

INSERT INTO `film` (`id`, `titre`, `duree`, `date_sortie`, `budget`, `montant_recette`, `realisateur_id`, `categorie_id`) VALUES
(1, 'Léon', 110, '1994-04-14', 17531000, 69250000, 3, 'PO'),
(2, 'Cash', 100, '2008-04-23', 18340000, 60340000, 4, 'PO'),
(3, 'La grande vadrouille', 132, '1966-12-01', 7227000, 51258000, 2, 'AC'),
(4, 'Subway', 104, '1985-04-10', 10567000, 70500000, 3, 'PO'),
(6, 'James Bond', 110, '2020-04-14', 17531000, 69250000, 3, 'AC');

-- --------------------------------------------------------

--
-- Structure de la table `personnage`
--

CREATE TABLE `personnage` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `acteur_id` int(4) NOT NULL,
  `film_id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `personnage`
--

INSERT INTO `personnage` (`id`, `nom`, `acteur_id`, `film_id`) VALUES
(1, 'Léon', 2, 2),
(2, 'Mathilda', 2, 1),
(3, 'Maxime Dubreuil', 1, 2),
(4, 'Cash', 3, 2),
(5, 'Augustin Bouvet', 4, 3),
(6, 'Stanislas Lefort', 5, 3),
(7, 'Le Batteur', 1, 4),
(8, 'Le Roller', 6, 4),
(9, 'Fred', 7, 4),
(10, 'Léonne2', 2, 1),
(11, '007', 8, 6);

-- --------------------------------------------------------

--
-- Structure de la table `realisateur`
--

CREATE TABLE `realisateur` (
  `id` int(2) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `realisateur`
--

INSERT INTO `realisateur` (`id`, `nom`, `prenom`) VALUES
(1, 'Oury', 'Gérard'),
(2, 'Chabrol', 'Claude'),
(3, 'Besson', 'Luc'),
(4, 'Besnard', 'Eric');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `acteur`
--
ALTER TABLE `acteur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`),
  ADD KEY `realisateur_id` (`realisateur_id`) USING BTREE,
  ADD KEY `categorie_id` (`categorie_id`) USING BTREE;

--
-- Index pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD PRIMARY KEY (`id`),
  ADD KEY `film_id` (`film_id`),
  ADD KEY `acteur_id` (`acteur_id`);

--
-- Index pour la table `realisateur`
--
ALTER TABLE `realisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `acteur`
--
ALTER TABLE `acteur`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `personnage`
--
ALTER TABLE `personnage`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `realisateur`
--
ALTER TABLE `realisateur`
  MODIFY `id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `film_ibfk_1` FOREIGN KEY (`realisateur_id`) REFERENCES `realisateur` (`id`),
  ADD CONSTRAINT `film_ibfk_2` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`id`);

--
-- Contraintes pour la table `personnage`
--
ALTER TABLE `personnage`
  ADD CONSTRAINT `personnage_ibfk_1` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
  ADD CONSTRAINT `personnage_ibfk_2` FOREIGN KEY (`acteur_id`) REFERENCES `acteur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
