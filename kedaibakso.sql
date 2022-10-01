-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2022 at 05:58 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `kedaibakso`
--

-- --------------------------------------------------------

--
-- Table structure for table `aruskas`
--

CREATE TABLE `aruskas` (
  `idkas` varchar(12) NOT NULL,
  `tanggal` date NOT NULL,
  `Keterangan` varchar(50) NOT NULL,
  `pemasukan` int(12) NOT NULL,
  `pengeluaran` int(12) NOT NULL,
  `saldo` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `aruskas`
--

INSERT INTO `aruskas` (`idkas`, `tanggal`, `Keterangan`, `pemasukan`, `pengeluaran`, `saldo`) VALUES
('1', '2022-07-12', 'Omset', 292000, 0, 292000),
('2', '2022-07-12', 'Minuman Botol', 0, 20000, 272000),
('3', '2022-07-12', 'Kecap dan Saus', 0, 10000, 262000),
('4', '2022-07-12', 'cabai', 0, 20000, 242000),
('5', '2022-07-12', 'omset', 1000000, 0, 1242000);

-- --------------------------------------------------------

--
-- Table structure for table `biaya`
--

CREATE TABLE `biaya` (
  `id` varchar(20) NOT NULL,
  `tanggal` date NOT NULL,
  `keterangan` varchar(50) NOT NULL,
  `biaya` int(12) NOT NULL,
  `saldo` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `biaya`
--

INSERT INTO `biaya` (`id`, `tanggal`, `keterangan`, `biaya`, `saldo`) VALUES
('1', '2022-07-12', 'Kebersihan', 5000, 5000),
('2', '2022-07-12', 'Air', 10000, 15000),
('3', '2022-07-12', 'Listrik', 10000, 25000),
('4', '2022-08-16', 'iuran rw', 50000, 75000);

-- --------------------------------------------------------

--
-- Table structure for table `detail_order`
--

CREATE TABLE `detail_order` (
  `id_detail_order` int(10) NOT NULL,
  `id_order` varchar(10) NOT NULL,
  `id_menu` varchar(10) NOT NULL,
  `qty` int(20) NOT NULL,
  `status_detail_order` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detail_order`
--

INSERT INTO `detail_order` (`id_detail_order`, `id_order`, `id_menu`, `qty`, `status_detail_order`) VALUES
(53, 'ORD-5534', '2', 1, 'Delivery'),
(54, 'ORD-5534', '6', 1, 'Delivery'),
(55, 'ORD-2924', '5', 1, 'Delivery'),
(56, 'ORD-2924', '8', 1, 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `level`
--

CREATE TABLE `level` (
  `id_level` varchar(10) NOT NULL,
  `nama_level` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `level`
--

INSERT INTO `level` (`id_level`, `nama_level`) VALUES
('1', 'Admin'),
('2', 'Waiter'),
('3', 'Kasir'),
('4', 'Owner'),
('5', 'Pelanggan');

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_menu` varchar(10) NOT NULL,
  `nama_menu` varchar(30) NOT NULL,
  `harga` int(12) NOT NULL,
  `status_menu` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_menu`, `nama_menu`, `harga`, `status_menu`) VALUES
('1', 'Bakso Kecil', 15000, 'Tersedia'),
('10', 'Mie Ayam Bakso Piramid', 33000, 'Tersedia'),
('2', 'Bakso Urat', 20000, 'Tersedia'),
('3', 'Bakso Telur', 20000, 'Tersedia'),
('4', 'Bakso Urat Jeletot', 23000, 'Tersedia'),
('5', 'Bakso Piramid', 23000, 'Tersedia'),
('6', 'Mie Ayam', 13000, 'Tersedia'),
('7', 'Mie Ayam Bakso Kecil', 15000, 'Tersedia'),
('8', 'Mie Ayam Bakso Urat', 33000, 'Tersedia'),
('9', 'Mie Ayam Bakso Urat Jeletot', 25000, 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id_order` varchar(10) NOT NULL,
  `no_meja` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `id_user` varchar(10) NOT NULL,
  `qty` int(12) NOT NULL,
  `status_order` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id_order`, `no_meja`, `tanggal`, `id_user`, `qty`, `status_order`) VALUES
('ORD-2924', 'null', '2022-08-29', 'USR001', 1, 'Delivery'),
('ORD-4434', 'null', '2022-08-10', 'USR001', 9, 'Cancel'),
('ORD-5340', 'null', '2022-08-16', 'USR001', 1, 'Delivery'),
('ORD-5534', 'null', '2022-08-16', 'USR001', 1, 'Delivery');

-- --------------------------------------------------------

--
-- Table structure for table `pendapatan`
--

CREATE TABLE `pendapatan` (
  `id` varchar(12) NOT NULL,
  `tanggal` date NOT NULL,
  `pendapatan` int(12) NOT NULL,
  `jumlah` int(12) NOT NULL,
  `keluar` int(12) NOT NULL,
  `saldo` int(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pendapatan`
--

INSERT INTO `pendapatan` (`id`, `tanggal`, `pendapatan`, `jumlah`, `keluar`, `saldo`) VALUES
('1', '2022-07-12', 262000, 262000, 0, 262000),
('2', '2022-07-12', 200000, 462000, 25000, 437000),
('3', '2022-08-16', 1242000, 1704000, 0, 1704000);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(10) NOT NULL,
  `id_user` varchar(10) NOT NULL,
  `id_order` varchar(10) NOT NULL,
  `tanggal` date NOT NULL,
  `total_bayar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `id_user`, `id_order`, `tanggal`, `total_bayar`) VALUES
(18, 'USR001', 'ORD-5534', '2022-08-16', 33000),
(19, 'USR001', 'ORD-2924', '2022-08-29', 56000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` varchar(10) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `nama_user` varchar(25) NOT NULL,
  `id_level` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `nama_user`, `id_level`) VALUES
('USR001', 'admin', 'admin', 'Eka', '1'),
('USR002', 'waiter', 'waiter', 'Septian', '2'),
('USR003', 'kasir', 'kasir', 'Nugraha', '3'),
('USR004', 'owner', 'owner', 'Savera', '4'),
('USR005', 'pelanggan', 'pelanggan', 'Diana savera', '5'),
('USR006', 'user', 'useradmin', 'user', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `aruskas`
--
ALTER TABLE `aruskas`
  ADD PRIMARY KEY (`idkas`);

--
-- Indexes for table `biaya`
--
ALTER TABLE `biaya`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `detail_order`
--
ALTER TABLE `detail_order`
  ADD PRIMARY KEY (`id_detail_order`),
  ADD KEY `fk` (`id_menu`),
  ADD KEY `fsfvsdd` (`id_order`);

--
-- Indexes for table `level`
--
ALTER TABLE `level`
  ADD PRIMARY KEY (`id_level`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id_order`),
  ADD KEY `fdrw` (`id_user`);

--
-- Indexes for table `pendapatan`
--
ALTER TABLE `pendapatan`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `dfd` (`id_order`),
  ADD KEY `er` (`id_user`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_level` (`id_level`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `detail_order`
--
ALTER TABLE `detail_order`
  MODIFY `id_detail_order` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fdrw` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `dfd` FOREIGN KEY (`id_order`) REFERENCES `order` (`id_order`),
  ADD CONSTRAINT `er` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`id_level`) REFERENCES `level` (`id_level`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
