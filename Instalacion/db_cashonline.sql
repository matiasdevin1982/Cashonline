-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-10-2020 a las 10:00:05
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_cashonline`
--
CREATE DATABASE IF NOT EXISTS `db_cashonline` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_cashonline`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_clientes`
--

CREATE TABLE `db_clientes` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `db_clientes`
--

INSERT INTO `db_clientes` (`id`, `email`, `first_name`, `last_name`) VALUES
(1, 'user@test.com', 'Guillermo 8', 'Francella'),
(2, 'user@test.com', 'Guillermo 7', 'Francella'),
(3, 'user@test.com', 'Guillermo 6', 'Francella'),
(4, 'user@test.com', 'Guillermo 5', 'Francella'),
(5, 'user@test.com', 'Guillermo 4', 'Francella'),
(6, 'user@test.com', 'Guillermo 3', 'Francella'),
(7, 'user@test.com', 'Guillermo 2', 'Francella'),
(8, 'user@test.com', 'Guillermo 1', 'Francella'),
(9, 'user@test.com', 'Guillermo 9', 'Francella'),
(10, 'user@test.com', 'Guillermo 10', 'Francella');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `db_loans`
--

CREATE TABLE `db_loans` (
  `id` int(11) NOT NULL,
  `total` float(10,2) DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `db_loans`
--

INSERT INTO `db_loans` (`id`, `total`, `user_id`) VALUES
(1, 2500.00, 1),
(2, 2500.00, 1),
(3, 65120.75, 2),
(4, 2500.00, 1),
(5, 65120.75, 2),
(6, 2500.00, 1),
(7, 65120.75, 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `db_clientes`
--
ALTER TABLE `db_clientes`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `db_loans`
--
ALTER TABLE `db_loans`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKg530um53cntkxiewwn3vtf0rn` (`user_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `db_clientes`
--
ALTER TABLE `db_clientes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=340;

--
-- AUTO_INCREMENT de la tabla `db_loans`
--
ALTER TABLE `db_loans`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
