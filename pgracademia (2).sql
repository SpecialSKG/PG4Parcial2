-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-11-2021 a las 01:34:31
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pgracademia`
--
CREATE DATABASE IF NOT EXISTS `pgracademia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `pgracademia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aingreso`
--

CREATE TABLE `aingreso` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `horaIngreso` time NOT NULL,
  `cursofk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `id` int(11) NOT NULL,
  `dui` varchar(10) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `edad` int(11) NOT NULL,
  `cif` varchar(10) DEFAULT NULL,
  `telefono_empresa` varchar(10) DEFAULT NULL,
  `direccion_empresa` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `dui`, `direccion`, `nombre`, `telefono`, `edad`, `cif`, `telefono_empresa`, `direccion_empresa`) VALUES
(1, 'ABC', 'PLAZA SESAMO 123', 'AVELARDO', '1234-5678', 10, 'ABC', '4321-8765', 'PLAZA SESAMO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asalida`
--

CREATE TABLE `asalida` (
  `id` int(11) NOT NULL,
  `hora_salida` time NOT NULL,
  `aingreso` int(11) NOT NULL,
  `curso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `curso`
--

CREATE TABLE `curso` (
  `id` int(11) NOT NULL,
  `codigo` varchar(10) NOT NULL,
  `titulo` varchar(100) NOT NULL,
  `hora_duracion` time NOT NULL,
  `fecha_inicio` datetime NOT NULL,
  `fecha_fin` datetime NOT NULL,
  `profe_dui` varchar(10) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `apellido` varchar(20) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `curso`
--

INSERT INTO `curso` (`id`, `codigo`, `titulo`, `hora_duracion`, `fecha_inicio`, `fecha_fin`, `profe_dui`, `nombre`, `apellido`, `direccion`, `telefono`) VALUES
(1, 'C1', 'PROGRAMACION 4', '00:00:09', '2021-10-20 00:00:00', '2021-10-29 07:45:00', '1234', 'CARLOS', 'HERNANDEZ', 'PLAZA SESAMO', '1234-5679'),
(2, 'codigo', 'titulo', '09:30:00', '2021-04-20 12:00:00', '2023-04-20 12:00:00', 'profe_dui', ' nombre', 'apellido', 'direccion', 'telefono'),
(4, 'DAM', 'safe', '02:00:00', '2021-08-01 00:00:00', '2021-08-11 00:00:00', '000000-0', 'Abelardo', 'Gallegos', 'Santa Tecla', '4588-454');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nota`
--

CREATE TABLE `nota` (
  `id` int(11) NOT NULL,
  `alumno` int(11) NOT NULL,
  `curso` int(11) NOT NULL,
  `notas` double(12,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `nota`
--

INSERT INTO `nota` (`id`, `alumno`, `curso`, `notas`) VALUES
(1, 1, 1, 10.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `permisod`
--

CREATE TABLE `permisod` (
  `id` int(11) NOT NULL,
  `fecha_tiempo` datetime NOT NULL,
  `tipo_permiso` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `idcurso` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_usuario`
--

CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `clave` varchar(50) NOT NULL,
  `tipo_usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aingreso`
--
ALTER TABLE `aingreso`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cursofk` (`cursofk`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `asalida`
--
ALTER TABLE `asalida`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aingreso` (`aingreso`),
  ADD KEY `curso` (`curso`);

--
-- Indices de la tabla `curso`
--
ALTER TABLE `curso`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `nota`
--
ALTER TABLE `nota`
  ADD PRIMARY KEY (`id`),
  ADD KEY `alumno` (`alumno`),
  ADD KEY `curso` (`curso`);

--
-- Indices de la tabla `permisod`
--
ALTER TABLE `permisod`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idcurso` (`idcurso`);

--
-- Indices de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_usuario` (`tipo_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `aingreso`
--
ALTER TABLE `aingreso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `asalida`
--
ALTER TABLE `asalida`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `curso`
--
ALTER TABLE `curso`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `nota`
--
ALTER TABLE `nota`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `permisod`
--
ALTER TABLE `permisod`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipo_usuario`
--
ALTER TABLE `tipo_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aingreso`
--
ALTER TABLE `aingreso`
  ADD CONSTRAINT `aingreso_ibfk_1` FOREIGN KEY (`cursofk`) REFERENCES `curso` (`id`);

--
-- Filtros para la tabla `asalida`
--
ALTER TABLE `asalida`
  ADD CONSTRAINT `asalida_ibfk_1` FOREIGN KEY (`aingreso`) REFERENCES `aingreso` (`id`),
  ADD CONSTRAINT `asalida_ibfk_2` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`);

--
-- Filtros para la tabla `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `alumno` FOREIGN KEY (`alumno`) REFERENCES `alumno` (`id`),
  ADD CONSTRAINT `curso` FOREIGN KEY (`curso`) REFERENCES `curso` (`id`);

--
-- Filtros para la tabla `permisod`
--
ALTER TABLE `permisod`
  ADD CONSTRAINT `permisod_ibfk_1` FOREIGN KEY (`idcurso`) REFERENCES `curso` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`tipo_usuario`) REFERENCES `tipo_usuario` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
