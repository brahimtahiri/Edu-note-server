-- --------------------------------------------------------
-- Hôte:                         127.0.0.1
-- Version du serveur:           11.4.2-MariaDB - mariadb.org binary distribution
-- SE du serveur:                Win64
-- HeidiSQL Version:             12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Listage de la structure de la base pour edu_note
CREATE DATABASE IF NOT EXISTS `edu_note` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `edu_note`;

-- Listage de la structure de la table edu_note. classes
CREATE TABLE IF NOT EXISTS `classes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `denomination` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Listage des données de la table edu_note.classes : ~7 rows (environ)
DELETE FROM `classes`;
INSERT INTO `classes` (`id`, `denomination`) VALUES
	(1, 'Classe 1'),
	(2, 'Classe 2'),
	(3, 'Classe 3'),
	(4, 'Classe 4'),
	(5, 'Classe 5');

-- Listage de la structure de la table edu_note. etudiants
CREATE TABLE IF NOT EXISTS `etudiants` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `url_photo` varchar(255) DEFAULT NULL,
  `classe_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xijn99ki2y94j6qyw07uoyr2` (`classe_id`),
  CONSTRAINT `FK9xijn99ki2y94j6qyw07uoyr2` FOREIGN KEY (`classe_id`) REFERENCES `classes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Listage des données de la table edu_note.etudiants : ~20 rows (environ)
DELETE FROM `etudiants`;
INSERT INTO `etudiants` (`id`, `nom`, `prenom`, `url_photo`, `classe_id`) VALUES
	(1, 'Martin', 'Lucas', 'http://example.com/photos/lucas_martin.jpg', 1),
	(2, 'Bernard', 'Marie', 'http://example.com/photos/marie_bernard.jpg', 2),
	(3, 'Thomas', 'Julien', 'http://example.com/photos/julien_thomas.jpg', 3),
	(4, 'Petit', 'Sophie', 'http://example.com/photos/sophie_petit.jpg', 4),
	(5, 'Robert', 'Antoine', 'http://example.com/photos/antoine_robert.jpg', 5),
	(6, 'Richard', 'Julie', 'http://example.com/photos/julie_richard.jpg', 1),
	(7, 'Durand', 'Paul', 'http://example.com/photos/paul_durand.jpg', 2),
	(8, 'Dubois', 'Emma', 'http://example.com/photos/emma_dubois.jpg', 3),
	(9, 'Moreau', 'Nicolas', 'http://example.com/photos/nicolas_moreau.jpg', 4),
	(10, 'Laurent', 'Camille', 'http://example.com/photos/camille_laurent.jpg', 5),
	(11, 'Lefevre', 'Chloé', 'http://example.com/photos/chloe_lefevre.jpg', 3),
	(12, 'Roux', 'Hugo', 'http://example.com/photos/hugo_roux.jpg', 1),
	(13, 'Morel', 'Manon', 'http://example.com/photos/manon_morel.jpg', 2),
	(14, 'Fournier', 'Lucas', 'http://example.com/photos/lucas_fournier.jpg', 4),
	(15, 'Girard', 'Léa', 'http://example.com/photos/lea_girard.jpg', 5),
	(16, 'Andre', 'Arthur', 'http://example.com/photos/arthur_andre.jpg', 3),
	(17, 'Mercier', 'Clara', 'http://example.com/photos/clara_mercier.jpg', 1),
	(18, 'Dupuis', 'Louis', 'http://example.com/photos/louis_dupuis.jpg', 2),
	(19, 'Muller', 'Zoé', 'http://example.com/photos/zoe_muller.jpg', 4),
	(20, 'Leroy', 'Alexandre', 'http://example.com/photos/alexandre_leroy.jpg', 5);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
