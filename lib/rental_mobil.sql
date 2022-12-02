-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2022 at 03:27 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rental_mobil`
--
CREATE DATABASE IF NOT EXISTS `rental_mobil` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `rental_mobil`;

-- --------------------------------------------------------

--
-- Table structure for table `mobil`
--

CREATE TABLE `mobil` (
  `id` int(11) NOT NULL,
  `plat` varchar(9) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `cat` varchar(45) NOT NULL,
  `biaya` varchar(100) NOT NULL,
  `status` enum('Tersedia','Tidak Tersedia') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobil`
--

INSERT INTO `mobil` (`id`, `plat`, `nama`, `cat`, `biaya`, `status`) VALUES
(1, 'BG1273MR', 'Avanza Veloz', 'Silver', '1500000', 'Tidak Tersedia'),
(2, 'BG1274MR', 'Calya Facelift', 'Merah', '2500000', 'Tersedia'),
(6, 'BG1273MS', 'Blue', 'Xpander', '3500000', 'Tersedia'),
(7, 'B1273BB', 'Hitams', 'Lexuss', '3000000', 'Tidak Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id` int(11) NOT NULL,
  `kode_transaksi` varchar(8) NOT NULL,
  `plat` varchar(9) NOT NULL,
  `username_pelanggan` varchar(45) NOT NULL,
  `lama_rental` varchar(100) NOT NULL,
  `biaya` varchar(100) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `jenis_transaksi` enum('Perentalan','Pengembalian') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id`, `kode_transaksi`, `plat`, `username_pelanggan`, `lama_rental`, `biaya`, `tgl_transaksi`, `jenis_transaksi`) VALUES
(3, 'cpzkvkgw', 'BG1273MR', 'budi123', '2', '1500000', '2022-12-02', 'Perentalan'),
(4, 'mgmrhcwe', 'B1273BB', 'wahyu', '2', '3000000', '2022-12-02', 'Perentalan'),
(5, 'kpesqqoz', 'B1273BB', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian'),
(6, 'vwhsulci', 'BG1273MS', 'wahyu', '2', '3500000', '2022-12-02', 'Perentalan'),
(7, 'rpsoajos', 'BG1273MS', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian'),
(8, 'ocjadvdg', 'BG1273MS', 'wahyu', '2', '3500000', '2022-12-02', 'Perentalan'),
(9, 'bjkdbdqf', 'BG1273MS', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian'),
(10, 'xkxpwefp', 'BG1273MS', 'wahyu', '3', '3500000', '2022-12-02', 'Perentalan'),
(11, 'vlcqfesc', 'BG1273MS', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian'),
(12, 'vbldomeh', 'BG1273MS', 'wahyu', '1', '3500000', '2022-12-02', 'Perentalan'),
(13, 'disqhijh', 'BG1273MS', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian'),
(14, 'gaqrtfmd', 'BG1273MS', 'wahyu', '2', '3500000', '2022-12-02', 'Perentalan'),
(15, 'sbqeguln', 'BG1273MS', 'wahyu', '0', '0', '2022-12-02', 'Pengembalian');

--
-- Triggers `transaksi`
--
DELIMITER $$
CREATE TRIGGER `delete_transaksi` AFTER DELETE ON `transaksi` FOR EACH ROW begin
	UPDATE 
		mobil 
	SET status = "Tersedia"
	WHERE plat = old.plat;
end
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `perentalan` AFTER INSERT ON `transaksi` FOR EACH ROW begin
	UPDATE 
		mobil 
	SET status = "Tidak Tersedia"
	WHERE plat = new.plat;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `role` enum('Admin','Pelanggan') DEFAULT 'Pelanggan'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`, `nama`, `role`) VALUES
(1, 'andika123', 'andika123', 'Andika Pangestu', 'Admin'),
(2, 'budi123', 'budi123', 'Budi Wahyudi', 'Pelanggan'),
(4, 'luffy', 'luffy', 'luffy d monkey', 'Pelanggan'),
(5, 'wahyu', '32c9e71e866ecdbc93e497482aa6779f', 'Wahyu Sandika', 'Pelanggan'),
(6, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Admin Magang', 'Admin'),
(7, 'admin2', 'c84258e9c39059a89ab77d846ddab909', 'Admin Magang 2', 'Admin'),
(8, 'bayu', 'a430e06de5ce438d499c2e4063d60fd6', 'Bayu Daru', 'Pelanggan'),
(9, 'ahmad', '61243c7b9a4022cb3f8dc3106767ed12', 'Ahmad Hanif', 'Pelanggan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mobil`
--
ALTER TABLE `mobil`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `plat_UNIQUE` (`plat`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `kode_transaksi_UNIQUE` (`kode_transaksi`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mobil`
--
ALTER TABLE `mobil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
