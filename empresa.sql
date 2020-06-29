-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-06-2020 a las 03:38:38
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empresa`
--
CREATE DATABASE IF NOT EXISTS `empresa` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `empresa`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `cod_pedido` int(11) NOT NULL,
  `cod_cliente` varchar(20) NOT NULL,
  `cod_producto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`cod_pedido`, `cod_cliente`, `cod_producto`, `cantidad`, `fecha`) VALUES
(26, 'c1', 2, 23, '0000-00-00'),
(30, 'c1', 2, 32, '0000-00-00'),
(33, 'c1', 2, 43, '2020-06-26'),
(34, 'c12', 2, 12, '2020-06-28'),
(35, 'c12', 2, 12, '2020-06-28'),
(36, 'c12', 12, 2, '2020-06-28'),
(37, 'c12', 32, 23, '2020-06-28'),
(38, 'c5', 3, 4, '0000-00-00'),
(39, 'c5', 3, 4, '0000-00-00'),
(40, 'c5', 3, 4, '0000-00-00'),
(41, 'c1', 4, 4, '0000-00-00'),
(42, 'c1', 4, 4, '0000-00-00'),
(43, 'c1', 4, 4, '0000-00-00'),
(44, 'c1', 54, 3, '2020-06-28'),
(45, 'c1', 2, 23, '2020-06-28'),
(46, 'c1', 2, 3, '2020-06-28'),
(47, 'c1', 3, 34444, '2020-06-29'),
(48, 'c1', 3, 23, '2020-06-29'),
(49, 'c1', 2, 45, '2020-06-29'),
(50, 'c1', 3, 44, '2020-06-29'),
(51, 'c1', 5, 123, '2020-06-29'),
(52, 'c1', 4, 23, '2020-06-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `cod_producto` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`cod_producto`, `nombre`, `descripcion`, `precio`) VALUES
(2, 'Bolígrafo', 'Utensilio para escribir que consiste en un tubo hueco de plástico o de metal con un depósito cilíndrico de una tinta viscosa en su interior y una bolita metálica en la punta que gira libremente y hace salir la tinta de forma uniforme.\r\n', 3.45),
(3, 'Cuaderno', 'Conjunto de hojas de papel, impresas o en blanco, unidas con una espiral o dobladas, encajadas o cosidas, que forman un libro delgado y que sirve para anotar cosas.', 7),
(4, 'Portátil', 'Máquina electrónica capaz de almacenar información y tratarla automáticamente mediante operaciones matemáticas y lógicas controladas por programas informáticos.\r\n', 765),
(5, 'Gafas', '(gafas) Objeto usado por algunas personas para corregir defectos de visión, o protegerse los ojos de reflejos dañinos, que consiste en dos cristales, con graduación óptica o sin ella, montados en un armazón o montura que se apoya en la nariz y que se suje', 270);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`cod_pedido`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`cod_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `cod_pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `cod_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
