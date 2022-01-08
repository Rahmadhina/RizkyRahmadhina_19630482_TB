-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Jan 2022 pada 09.28
-- Versi server: 10.4.21-MariaDB
-- Versi PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_ppdb`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `daftar`
--

CREATE TABLE `daftar` (
  `id_daftar` varchar(30) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(40) NOT NULL,
  `asal_sekolah` varchar(40) NOT NULL,
  `nilai_akhir` int(10) NOT NULL,
  `id_sekolah` varchar(30) NOT NULL,
  `nama_sekolah` varchar(20) NOT NULL,
  `akreditasi` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `daftar`
--

INSERT INTO `daftar` (`id_daftar`, `nis`, `nama`, `alamat`, `asal_sekolah`, `nilai_akhir`, `id_sekolah`, `nama_sekolah`, `akreditasi`) VALUES
('D0001', 'N0211', 'Rizky Amelia', 'Pelaihari', 'SMPN 1 Pelaihari', 99, 'S0001', 'SMAN 1 Martapura', 'A'),
('D0002', 'N0212', 'Azaria Maulana', 'Pelaihari', 'SMPN 2 Pelaihari', 77, 'S0002', 'SMAN 2 Martapura', 'B'),
('D0003', 'N0213', 'I Made Indrayana', 'Pelaihari', 'SMPN 4 Martapura', 87, 'S0003', 'SMAN 1 Banjarbaru', 'A');

-- --------------------------------------------------------

--
-- Struktur dari tabel `sekolah`
--

CREATE TABLE `sekolah` (
  `id_sekolah` varchar(11) NOT NULL,
  `nama_sekolah` varchar(30) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `akreditasi` varchar(25) NOT NULL,
  `telepon` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `sekolah`
--

INSERT INTO `sekolah` (`id_sekolah`, `nama_sekolah`, `alamat`, `akreditasi`, `telepon`) VALUES
('S0001', 'SMAN 1 Martapura', 'Martapura', 'A', '089666544432'),
('S0002', 'SMAN 2 Martapura', 'Martapura', 'B', '089666543234'),
('S0003', 'SMAN 1 Banjarbaru', 'Banjarbaru', 'A', '089655432332'),
('S0004', 'SMAN 2 Banjarbaru', 'Banjarbaru', 'A', '078555755542'),
('S0005', 'SMA DH Putra', 'Trikora', 'Belum Terakreditasi', '086535564886');

-- --------------------------------------------------------

--
-- Struktur dari tabel `siswa`
--

CREATE TABLE `siswa` (
  `nis` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `agama` varchar(20) NOT NULL,
  `tanggal_lahir` varchar(25) NOT NULL,
  `telepon` varchar(15) NOT NULL,
  `asal_sekolah` varchar(40) NOT NULL,
  `nilai_akhir` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `siswa`
--

INSERT INTO `siswa` (`nis`, `nama`, `alamat`, `jenis_kelamin`, `agama`, `tanggal_lahir`, `telepon`, `asal_sekolah`, `nilai_akhir`) VALUES
('N0211', 'Rizky Amelia', 'Pelaihari', 'Perempuan', 'Islam', '27 Juni 1991', '087655433421', 'SMPN 1 Pelaihari', 99),
('N0212', 'Azaria Maulana', 'Pelaihari', 'Laki-Laki', 'Islam', '12 Februari 2002', '087654567765', 'SMPN 2 Pelaihari', 77),
('N0213', 'I Made Indrayana', 'Pelaihari', 'Laki-Laki', 'Hindu', '13 Mei 2000', '089766884233', 'SMPN 4 Martapura', 87);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `daftar`
--
ALTER TABLE `daftar`
  ADD PRIMARY KEY (`id_daftar`);

--
-- Indeks untuk tabel `sekolah`
--
ALTER TABLE `sekolah`
  ADD PRIMARY KEY (`id_sekolah`);

--
-- Indeks untuk tabel `siswa`
--
ALTER TABLE `siswa`
  ADD PRIMARY KEY (`nis`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
