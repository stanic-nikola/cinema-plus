-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2020 at 10:47 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinemaplus`
--

-- --------------------------------------------------------

--
-- Table structure for table `bioskop`
--

CREATE TABLE `bioskop` (
  `IdBioskopa` int(20) NOT NULL,
  `NazivBioskopa` varchar(100) NOT NULL,
  `Adresa` varchar(400) NOT NULL,
  `Slika` varchar(200) DEFAULT NULL,
  `Opis` varchar(500) DEFAULT NULL,
  `IdGrada` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `bioskop`
--

INSERT INTO `bioskop` (`IdBioskopa`, `NazivBioskopa`, `Adresa`, `Slika`, `Opis`, `IdGrada`) VALUES
(2, 'Big CinemaPlus', 'Patrijarha Dimitrija 14, Beograd 11090', 'https://i.ibb.co/44QXg9S/people-walking-in-chicago-building-during-nighttime-1769413.jpg', 'Big šoping Centar Rakovica', 1),
(4, 'Lucky Luke Cinema', 'Krunska 56, Beograd 11500', 'https://i.ibb.co/fxtF9R7/people-on-street-during-night-time-3644048.jpg', 'Talični Tom, doživite western iskustvo', 1),
(5, 'Modern Cinema', 'Patrijarha Pavla 93, Beograd 11500', 'https://i.ibb.co/xYrqLNh/882197-260423464094245-472846155-o.jpg', 'Bioskop koji ćete obožavati.', 1);

-- --------------------------------------------------------

--
-- Table structure for table `clanstvo`
--

CREATE TABLE `clanstvo` (
  `IdClanstva` int(20) NOT NULL,
  `IdKluba` int(20) NOT NULL,
  `IdKorisnika` int(20) NOT NULL,
  `TipClanstva` varchar(100) NOT NULL,
  `Sediste` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `clanstvo`
--

INSERT INTO `clanstvo` (`IdClanstva`, `IdKluba`, `IdKorisnika`, `TipClanstva`, `Sediste`) VALUES
(17, 2, 5, 'Premium', 32);

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `IdFilma` int(20) NOT NULL,
  `NazivFilma` varchar(200) NOT NULL,
  `OpisFilma` varchar(3000) DEFAULT NULL,
  `Slika` varchar(200) NOT NULL,
  `Zanr` varchar(80) NOT NULL,
  `Trajanje` varchar(50) NOT NULL,
  `Trejler` varchar(200) DEFAULT NULL,
  `PocetakPrikazivanja` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`IdFilma`, `NazivFilma`, `OpisFilma`, `Slika`, `Zanr`, `Trajanje`, `Trejler`, `PocetakPrikazivanja`) VALUES
(10, 'Citizenfour', 'Probudite svest o zaštiti podataka.', 'https://img.yts.mx/assets/images/movies/citizenfour_2014/medium-cover.jpg', 'Akcija, Drama, Triler', '120 min', 'XiGwAvd5mvM', '2020-08-21'),
(11, 'The Good, the Bad and the Ugly', 'Film govori o trojici revolveraša koji tragaju za zakopanim zlatom vojske Konfederacije u haosu obračuna, vješanja, Građanskog rata i zatvoreničkog logora. U Italiji je premijerno prikazan 23. decembra 1966, a u SAD 29. decembra 1967. Film je u SAD zaradio oko 25 miliona dolara [3]. Dobar, loš, zao je u evropskim bioskopima najavljivan ka najbolji predstavnik vestern žanra, a Kventin Tarantino je za film rekao da je „najbolje režirani film svih vremena“.', 'https://img.yts.mx/assets/images/movies/The_Good_The_Bad_and_the_Ugly_1966/medium-cover.jpg', 'Western', '148 min', 'WCN5JJY_wiA', '2020-07-22'),
(12, 'Lucky Luke', 'Fearless gunslinger Lucky Luke is ordered by the President to bring peace to Daisy Town.', 'https://img.yts.mx/assets/images/movies/lucky_luke_1991/medium-cover.jpg', 'Avantura, Komedija, Western', '103 min', 'dfdolxtzdO4', '2020-07-23'),
(13, 'High Noon', 'A town Marshal, despite the disagreements of his newlywed bride and the townspeople around him, must face a gang of deadly killers alone at high noon when the gang leader, an outlaw he sent up years ago, arrives on the noon train.', 'https://img.yts.mx/assets/images/movies/high_noon_1952/medium-cover.jpg', 'Drama, Triler, Western', '85 min', 'g9CR_tib0CA', '2020-07-23'),
(14, 'The Hobbit: An Unexpected Journey', 'Avanture mladog hobita.', 'https://img.yts.mx/assets/images/movies/The_Hobbit_An_Unexpected_Journey_2012/medium-cover.jpg', 'Fantazija', '105 min', 'SDnYMbYB-nU', '2020-07-28'),
(15, 'Harry Potter and the Goblet of Fire', 'Mladi čarobnjak.', 'https://img.yts.mx/assets/images/movies/Harry_Potter_and_the_Goblet_of_Fire_2005/medium-cover.jpg', 'Fantazija', '105 min', '3EGojp4Hh6I', '2020-07-21'),
(17, 'A nice girl like you', 'Zanimljiva romansa', 'https://img.yts.mx/assets/images/movies/a_nice_girl_like_you_2020/medium-cover.jpg', 'Komedija, Romansa', '100min', 'xdECXo4l30I', '2020-07-16'),
(18, 'Greyhound', 'Tom Henks, ratni film.', 'https://img.yts.mx/assets/images/movies/greyhound_2020/medium-cover.jpg', 'Akcija, Drama, Istorija, Rat', '140min', 'eyzxu26-Wqk', '2020-07-24'),
(19, 'Vantage point', 'Akcioni film.', 'https://img.yts.mx/assets/images/movies/Vantage_Point_2008/medium-cover.jpg', 'Akcija, Krimi, Drama', '120min', 'https://www.youtube.com/embed/ObslcA3FhwU?rel=0&wmode=transparent&border=0&autoplay=1&iv_load_policy=3', '2020-08-20'),
(20, 'Grudge match', 'Robert De Niro i Silvester Stalone.', 'https://img.yts.mx/assets/images/movies/Grudge_Match_2013/medium-cover.jpg', 'Akcija, Komedija, Drama', '130min', 'https://www.youtube.com/embed/1bQSOBJCPQE?rel=0&wmode=transparent&border=0&autoplay=1&iv_load_policy=3', '2020-07-30'),
(21, 'There will be blood', 'Dramatičan film.', 'https://img.yts.mx/assets/images/movies/There_Will_Be_Blood_2007/medium-cover.jpg', 'Akcija, Drama, Istorija', '120min', 'https://www.youtube.com/embed/0FIm5ATyAY0?rel=0&wmode=transparent&border=0&autoplay=1&iv_load_policy=3', '2020-08-06'),
(22, 'Rear window', 'Stari filmovi imaju dušu.', 'https://img.yts.mx/assets/images/movies/rear_window_1954/medium-cover.jpg', 'Akcija, Misterija, Triler', '100min', 'https://www.youtube.com/embed/6gpY4r_MG1A?rel=0&wmode=transparent&border=0&autoplay=1&iv_load_policy=3', '2020-07-30'),
(25, 'Amanda Seales: I Be Knowin\'', 'Test.', 'https://yts.mx/assets/images/movies/amanda_seales_i_be_knowin_2019/medium-cover.jpg', 'Zabava', '100 min', 'RWkwbbcYwHs', '2020-07-24'),
(33, 'Harry Potter and the Deathly Hallows Part 2', 'Magic.', 'https://img.yts.mx/assets/images/movies/Harry_Potter_and_the_Deathly_Hallows_Part_2_2011/medium-cover.jpg', 'Fantazija', '148 min', 'mObK5XD8udk', '2020-07-24');

-- --------------------------------------------------------

--
-- Table structure for table `grad`
--

CREATE TABLE `grad` (
  `IdGrada` int(20) NOT NULL,
  `ImeGrada` varchar(100) NOT NULL,
  `Drzava` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grad`
--

INSERT INTO `grad` (`IdGrada`, `ImeGrada`, `Drzava`) VALUES
(1, 'Beograd', 'Srbija'),
(2, 'Novi Sad', 'Srbija'),
(3, 'Niš', 'Srbija');

-- --------------------------------------------------------

--
-- Table structure for table `klub`
--

CREATE TABLE `klub` (
  `IdKluba` int(20) NOT NULL,
  `Naziv` varchar(200) NOT NULL,
  `Opis` varchar(500) NOT NULL,
  `Slika` varchar(200) NOT NULL,
  `Popust` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `klub`
--

INSERT INTO `klub` (`IdKluba`, `Naziv`, `Opis`, `Slika`, `Popust`) VALUES
(1, 'Matrix', 'Ovo je klub fanova binarnih svetova.', 'https://i.ibb.co/PTmqkHF/the-matrix-logo-png-transparent.png', NULL),
(2, 'Wild West', 'Klub za fanove kaubojaca i starih dobrih \"špageti\" Western-a.', 'https://i.ibb.co/R76GR3q/Bluebonnet-cedar-Logo-Orange.png', 10),
(3, 'Filmofil', 'Klub za obožavatelje domaće kinematografije.', 'https://i.ibb.co/cLmt3cS/New-Project-2.png\" alt=\"New-Project-2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `IdKorisnika` int(20) NOT NULL,
  `Ime` varchar(50) NOT NULL,
  `Prezime` varchar(60) NOT NULL,
  `Nadimak` varchar(80) NOT NULL,
  `Email` varchar(60) NOT NULL,
  `Lozinka` varchar(30) NOT NULL,
  `Rola` char(1) NOT NULL,
  `BrojMobilnog` varchar(30) NOT NULL,
  `BrojPoena` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`IdKorisnika`, `Ime`, `Prezime`, `Nadimak`, `Email`, `Lozinka`, `Rola`, `BrojMobilnog`, `BrojPoena`) VALUES
(1, 'Dusan', 'Jovicic', 'Duka', 'duka@live.com', '123456', 'A', '0695254979', NULL),
(4, 'Marko', 'Ivanović', 'Mare', 'mare@gmail.com', '123', 'M', '+381234123', NULL),
(5, 'Nikola', 'Stanić', 'Džoni', 'dzoni@gmail.com', '1', 'K', '+32141243', 400),
(22, 'Petar', 'Petrović', 'Pera832', 'perapetrovic@gmail.com', '1234567', 'A', '+381695213231', NULL),
(23, 'Igor', 'Pavlović', 'Igor22', 'giga@gmail.com', '1234567', 'K', '+13123124141', NULL),
(24, 'Cristiano', 'Ronaldo', 'CR21', 'cr@g.com', '1111111', 'K', '+412411242141', NULL),
(25, 'Dušan', 'Petrović', 'Dpr', 'dp@f.com', '2222222', 'K', '+321414214111', NULL),
(28, 'Ilija', 'Petrović', 'Ilke', 'ilke@gmail.com', 'ilike234', 'K', '+38169542424', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `projekcija`
--

CREATE TABLE `projekcija` (
  `IdProjekcije` int(20) NOT NULL,
  `IdSale` int(20) NOT NULL,
  `IdFilma` int(20) NOT NULL,
  `DatumVreme` datetime NOT NULL,
  `CenaKarte` decimal(19,2) NOT NULL,
  `IdKorisnika` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `projekcija`
--

INSERT INTO `projekcija` (`IdProjekcije`, `IdSale`, `IdFilma`, `DatumVreme`, `CenaKarte`, `IdKorisnika`) VALUES
(19, 20, 11, '2020-07-18 03:15:00', '300.00', 1),
(20, 25, 10, '2020-07-30 18:30:00', '600.00', 1),
(21, 22, 10, '2020-07-27 18:00:00', '400.00', 1),
(22, 25, 10, '2020-07-23 14:00:00', '280.00', 1),
(25, 25, 17, '2020-07-23 19:00:00', '450.00', 1),
(26, 22, 11, '2020-07-30 17:30:00', '450.00', 1),
(27, 18, 12, '2020-07-13 17:30:00', '280.00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `rezervacija`
--

CREATE TABLE `rezervacija` (
  `IdRezervacije` int(20) NOT NULL,
  `IdProjekcije` int(20) NOT NULL,
  `BrojSedista` int(10) NOT NULL,
  `CenaKarte` decimal(19,2) NOT NULL,
  `DatumRezervacije` datetime NOT NULL,
  `IdKorisnika` int(20) NOT NULL,
  `Status` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rezervacija`
--

INSERT INTO `rezervacija` (`IdRezervacije`, `IdProjekcije`, `BrojSedista`, `CenaKarte`, `DatumRezervacije`, `IdKorisnika`, `Status`) VALUES
(74, 25, 3, '405.00', '2020-07-21 00:30:29', 5, 'Aktivna'),
(75, 25, 4, '405.00', '2020-07-21 00:30:29', 5, 'Aktivna'),
(76, 25, 84, '405.00', '2020-07-21 00:37:08', 5, 'Aktivna'),
(77, 25, 85, '405.00', '2020-07-21 00:37:08', 5, 'Aktivna'),
(78, 22, 1, '252.00', '2020-07-21 01:09:33', 5, 'Aktivna'),
(79, 22, 2, '252.00', '2020-07-21 01:09:33', 5, 'Aktivna'),
(80, 25, 57, '405.00', '2020-07-21 20:05:01', 5, 'Aktivna'),
(81, 25, 58, '405.00', '2020-07-21 20:05:01', 5, 'Aktivna'),
(82, 25, 59, '405.00', '2020-07-21 20:05:01', 5, 'Aktivna'),
(83, 25, 60, '405.00', '2020-07-21 20:05:01', 5, 'Aktivna');

-- --------------------------------------------------------

--
-- Table structure for table `sala`
--

CREATE TABLE `sala` (
  `IdSale` int(20) NOT NULL,
  `NazivSale` varchar(200) NOT NULL,
  `Opis` varchar(500) DEFAULT NULL,
  `BrojMesta` int(10) NOT NULL,
  `Tehnologija` varchar(50) NOT NULL,
  `IdBioskopa` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sala`
--

INSERT INTO `sala` (`IdSale`, `NazivSale`, `Opis`, `BrojMesta`, `Tehnologija`, `IdBioskopa`) VALUES
(18, 'Dalton', 'Sala specijalno dizajnirana u Western stilu za prave ljubitelje kaubojaca.', 200, 'Cinemascope', 4),
(19, 'Elton John', 'Glavna sala sa posebnim VIP mestima za dodatan doživaljaj.', 400, '3D - 4K', 2),
(20, 'Ian McKellen', 'Sala sa sedištima za parove i naslonima za glavu, prima ogroman broj posetilaca.', 380, '3D - 4K', 2),
(22, 'High Noon', 'Mala sala u kojoj se prikazuju isključivo filmovi nastali 60ih i 70ih.', 80, 'B/W', 4),
(23, 'Dragan Nikolić', 'Sala u kojoj se emituju ostvarenja domaće kinematografije sa akcentom na filmove Dragana Gage Nikolića.', 220, 'Digital', 5),
(25, 'Nebojša Glogovac', 'Nova sala za prikaz domaćih filmova u HD.', 150, 'Digital', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bioskop`
--
ALTER TABLE `bioskop`
  ADD PRIMARY KEY (`IdBioskopa`),
  ADD KEY `IdGrada` (`IdGrada`);

--
-- Indexes for table `clanstvo`
--
ALTER TABLE `clanstvo`
  ADD PRIMARY KEY (`IdClanstva`),
  ADD KEY `IdKorisnika` (`IdKorisnika`),
  ADD KEY `IdKluba` (`IdKluba`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`IdFilma`);

--
-- Indexes for table `grad`
--
ALTER TABLE `grad`
  ADD PRIMARY KEY (`IdGrada`);

--
-- Indexes for table `klub`
--
ALTER TABLE `klub`
  ADD PRIMARY KEY (`IdKluba`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`IdKorisnika`);

--
-- Indexes for table `projekcija`
--
ALTER TABLE `projekcija`
  ADD PRIMARY KEY (`IdProjekcije`),
  ADD KEY `IdSale` (`IdSale`,`IdFilma`,`IdKorisnika`),
  ADD KEY `IdFilma` (`IdFilma`),
  ADD KEY `IdKorisnika` (`IdKorisnika`);

--
-- Indexes for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD PRIMARY KEY (`IdRezervacije`),
  ADD KEY `IdProjekcije` (`IdProjekcije`,`IdKorisnika`),
  ADD KEY `IdKorisnika` (`IdKorisnika`);

--
-- Indexes for table `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`IdSale`),
  ADD KEY `IdBioskopa` (`IdBioskopa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bioskop`
--
ALTER TABLE `bioskop`
  MODIFY `IdBioskopa` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `clanstvo`
--
ALTER TABLE `clanstvo`
  MODIFY `IdClanstva` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `IdFilma` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `grad`
--
ALTER TABLE `grad`
  MODIFY `IdGrada` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `klub`
--
ALTER TABLE `klub`
  MODIFY `IdKluba` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `IdKorisnika` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `projekcija`
--
ALTER TABLE `projekcija`
  MODIFY `IdProjekcije` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `rezervacija`
--
ALTER TABLE `rezervacija`
  MODIFY `IdRezervacije` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT for table `sala`
--
ALTER TABLE `sala`
  MODIFY `IdSale` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bioskop`
--
ALTER TABLE `bioskop`
  ADD CONSTRAINT `bioskop_ibfk_1` FOREIGN KEY (`IdGrada`) REFERENCES `grad` (`IdGrada`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `clanstvo`
--
ALTER TABLE `clanstvo`
  ADD CONSTRAINT `clanstvo_ibfk_1` FOREIGN KEY (`IdKluba`) REFERENCES `klub` (`IdKluba`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `clanstvo_ibfk_2` FOREIGN KEY (`IdKorisnika`) REFERENCES `korisnik` (`IdKorisnika`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `projekcija`
--
ALTER TABLE `projekcija`
  ADD CONSTRAINT `projekcija_ibfk_2` FOREIGN KEY (`IdFilma`) REFERENCES `film` (`IdFilma`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projekcija_ibfk_3` FOREIGN KEY (`IdKorisnika`) REFERENCES `korisnik` (`IdKorisnika`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `projekcija_ibfk_4` FOREIGN KEY (`IdSale`) REFERENCES `sala` (`IdSale`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `rezervacija`
--
ALTER TABLE `rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`IdProjekcije`) REFERENCES `projekcija` (`IdProjekcije`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`IdKorisnika`) REFERENCES `korisnik` (`IdKorisnika`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `sala`
--
ALTER TABLE `sala`
  ADD CONSTRAINT `sala_ibfk_1` FOREIGN KEY (`IdBioskopa`) REFERENCES `bioskop` (`IdBioskopa`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
