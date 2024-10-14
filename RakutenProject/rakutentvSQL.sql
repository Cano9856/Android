-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-03-2020 a las 19:23:04
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `rakutentv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actor`
--

CREATE TABLE `actor` (
  `ID_Actor` int(11) NOT NULL,
  `Nombre` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `Apellido` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `F_Nacimiento` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `Pais` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `Biografia` text CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actor`
--

INSERT INTO `actor` (`ID_Actor`, `Nombre`, `Apellido`, `F_Nacimiento`, `Pais`, `Biografia`) VALUES
(1, 'Tom', 'Cruise', '03/07/1962', 'Estados Unidos', 'Thomas Cruise Mapother IV, m?s conocido como Tom Cruise, es un actor estadounidense. Ha protagonizado pel?culas como Risky Business, Top Gun, El color del dinero, La guerra de los mundos, Days of Thunder, Rain Man, Eyes Wide Shut, Minority Report, El ?ltimo samur?i, Jack Reacher, Al filo del ma?ana y la saga de Misi?n imposible entre otras. '),
(2, 'Leonardo', 'DiCaprio', '11/11/1974', 'Estados Unidos', 'Leonardo Wilhelm DiCaprio es un actor y productor de cine estadounidense. Ha recibido numerosos premios por su actuaci?n, entre los que se destacan un ?scar al mejor actor y un premio BAFTA como Mejor Actor por su actuaci?n en El renacido de 2016, dos Globos de Oro al mejor actor en drama por su actuaci?n en El aviador en el a?o 2005, en El renacido (2016) y un Globo de Oro al mejor actor en comedia o musical por El lobo de Wall Street, en 2014. Adicionalmente, ha ganado el premio Oso de Plata y un Chlotrudis.'),
(3, 'Matthew', 'McConaughey', '04/11/1969', 'Estados Unidos', 'Matthew David McConaughey es un actor y productor de cine y televisi?n estadounidense. Es ganador de un premio ?scar, un Globo de Oro y un SAG.'),
(4, 'Sophia', 'Lillis', '13/02/2002', 'Estados Unidos', 'Sophia Lillis es una actriz estadounidense, conocida por interpretar a Beverly Marsh en la pel?cula de terror de 2017 It.'),
(5, 'Bill ', 'Skarsgard', '09/08/1990', 'Suecia', 'Bill Istvan G?nther Skarsg?rd es un sueco. Es hijo del actor Stellan Skarsg?rd. Es conocido por interpretar a Pennywise, el payaso en la pel?cula de terror It.'),
(6, 'Sally', 'Hawkins', '27/04/1976', 'Reino Unido', 'Sally Cecilia Hawkins es una actriz brit?nica. En 2002 hizo su debut cinematogr?fico en All or Nothing de Mike Leigh.'),
(7, 'Al ', 'Pacino', '25/04/2940', 'Estados Unidos', 'Alfredo James Pacino, conocido como Al Pacino es un actor, guionista y director estadounidense de cine y teatro. Es uno de los actores de teatro y cine de fines del siglo XX que m?s reconocimientos recibi?.? Su carrera ha abarcado cincuenta a?os durante los cuales ha obtenido numerosos premios y honores, incluyendo los premios ?scar, Emmy, Globo de Oro, SAG, BAFTA, Tony, un reconocimiento a su carrera por parte del American Film Institute, el Premio Cecil B. DeMille y la Medalla Nacional de las Artes. Es adem?s uno de los pocos actores que ha obtenido los premios ?scar, Emmy y Tony como actor, conjunto conocido como la ?triple corona de la actuaci?n?. '),
(8, 'Marlon', 'Brando', '03/04/1924', 'Estados Unidos', 'Marlon Brando, Jr. fue un actor estadounidense de cine y teatro. Su formaci?n e instrucci?n teatral fue llevada a cabo por Stella Adler, una de las m?s prestigiosas profesoras que desarroll? el trabajo de Stanislavski en Nueva York.'),
(9, 'Peter', 'Dinklage', '11/06/1969', 'Estados Unidos', 'Peter Hayden Dinklage? es un actor de cine, televisi?n y teatro estadounidense, su papel m?s conocido es el de Tyrion Lannister en la serie Juego de tronos, el cual le ha valido tres Emmy y un Globo de Oro.'),
(10, 'Frances', 'McDormand', '23/06/1957', 'Estados Unidos', 'Frances Louise McDormand es una actriz estadounidense. McDormand se encuentra entre el grupo de actores que ha conseguido la Triple Corona de la Actuaci?n: ?scar a la mejor actriz por Fargo y por Three Billboards Outside Ebbing, Missouri; Premio Tony a la mejor actriz principal en una obra de teatro por la producci?n original de Broadway Good People (2011) y Primetime Emmy a la mejor actriz en una Miniserie o telefilme por Olive Kitteridge (2014).'),
(11, 'Felicity', 'Jones', '17/10/1983', 'Reino Unido', 'Felicity Rose Hadley Jones? es una actriz brit?nica nominada a los Premios Globo de Oro, los Premios de Cine de la Academia Brit?nica BAFTA, los Premios del Sindicato de Actores y los Premios ?scar.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actuar`
--

CREATE TABLE `actuar` (
  `ID_Actuacion` int(11) NOT NULL,
  `ID_Actor` int(11) NOT NULL,
  `ID_Pelicula` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `actuar`
--

INSERT INTO `actuar` (`ID_Actuacion`, `ID_Actor`, `ID_Pelicula`) VALUES
(2, 1, 2),
(1, 2, 1),
(3, 3, 3),
(9, 4, 7),
(10, 5, 7),
(6, 6, 5),
(4, 7, 4),
(5, 8, 4),
(7, 9, 6),
(8, 10, 6),
(11, 11, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clasificar`
--

CREATE TABLE `clasificar` (
  `ID_Clasificacion` int(11) NOT NULL,
  `ID_Pelicula` int(11) NOT NULL,
  `ID_Genero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `clasificar`
--

INSERT INTO `clasificar` (`ID_Clasificacion`, `ID_Pelicula`, `ID_Genero`) VALUES
(5, 1, 4),
(6, 1, 10),
(8, 2, 1),
(7, 2, 2),
(9, 3, 7),
(10, 3, 9),
(11, 4, 4),
(12, 4, 9),
(14, 5, 4),
(13, 5, 10),
(16, 6, 4),
(15, 6, 9),
(18, 7, 2),
(17, 7, 5),
(19, 8, 2),
(20, 8, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desear`
--

CREATE TABLE `desear` (
  `ID_Deseado` int(11) NOT NULL,
  `ID_Pelicula` int(11) NOT NULL,
  `ID_Usuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `desear`
--

INSERT INTO `desear` (`ID_Deseado`, `ID_Pelicula`, `ID_Usuario`) VALUES
(23, 1, 2),
(34, 1, 3),
(29, 1, 4),
(10, 1, 5),
(11, 1, 6),
(4, 2, 2),
(57, 2, 10),
(40, 3, 2),
(5, 3, 3),
(26, 3, 4),
(44, 3, 6),
(56, 3, 10),
(6, 4, 3),
(30, 4, 4),
(20, 5, 2),
(35, 5, 3),
(8, 5, 4),
(69, 5, 10),
(21, 6, 2),
(41, 6, 3),
(7, 6, 4),
(72, 6, 11),
(15, 7, 1),
(25, 7, 2),
(28, 7, 4),
(46, 7, 6),
(70, 7, 10),
(73, 7, 11),
(48, 8, 1),
(3, 8, 2),
(38, 8, 3),
(32, 8, 4),
(9, 8, 5),
(13, 8, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `genero`
--

CREATE TABLE `genero` (
  `ID_Genero` int(11) NOT NULL,
  `Genero` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `genero`
--

INSERT INTO `genero` (`ID_Genero`, `Genero`) VALUES
(1, 'Accion'),
(2, 'Aventuras'),
(8, 'Belica'),
(3, 'Comedia'),
(4, 'Drama'),
(7, 'Ficcion'),
(6, 'Musical'),
(10, 'Romantica'),
(9, 'Suspense'),
(5, 'Terror');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `ID_Pelicula` int(11) NOT NULL,
  `Titulo` varchar(50) NOT NULL,
  `Precio` double(4,2) NOT NULL,
  `Duracion` int(3) NOT NULL,
  `Trailer` varchar(100) DEFAULT NULL,
  `Sinopsis` text CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `N_Votos` int(9) NOT NULL,
  `S_Puntuacion` int(11) NOT NULL,
  `Fecha_Estreno` varchar(10) NOT NULL,
  `URL` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`ID_Pelicula`, `Titulo`, `Precio`, `Duracion`, `Trailer`, `Sinopsis`, `N_Votos`, `S_Puntuacion`, `Fecha_Estreno`, `URL`) VALUES
(1, 'Titanic', 5.99, 295, 'https://www.youtube.com/watch?v=jnFxtSuZRpU', 'Una joven (Kate Winslet) de sociedad abandona a su arrogante pretendiente (Billy Zane) por un artista (Leonardo DiCaprio) humilde en el transatlántico que se hundió durante su viaje inaugural.', 200, 900, '1997', 'titanic'),
(2, 'Mision imposible: Fallout', 0.99, 148, 'https://www.youtube.com/embed/vDX_r9MH5Z0', 'Un traficante de armas y un grupo de terroristas pretenden realizar un triple ataque nuclear con tres artefactos de plutonio, los cuales se pierden. Ethan Hunt y su equipo tendrán que recuperarlos antes de que caigan en las manos equivocadas.', 100, 300, '2018', 'mision_imposible'),
(3, 'Interstellar', 9.99, 169, 'https://www.youtube.com/watch?v=NqniWGlg5kU', 'Un grupo de exploradores hacen uso de un orificio recién descubierto para superar las limitaciones de los viajes espaciales humanos y conquistar las vastas distancias relacionadas con los viajes interestelares.', 500, 2200, '2014', 'interstellar'),
(4, 'El Padrino', 7.99, 178, 'https://www.youtube.com/watch?v=gCVj1LeYnsc', 'Una adaptación ganadora del Premio de la Academia, de la novela de Mario Puzo acerca de la familia Corleone.', 500, 2400, '1972', 'padrino'),
(5, 'La forma del agua', 3.99, 183, 'https://www.youtube.com/watch?v=FMNTFFhR__g', 'Elisa es una joven muda que se enamora de un hombre anfibio que está recluido en un acuario en un laboratorio secreto, propiedad del Gobierno, en el que ella trabaja limpiando. Llevada por el amor, Elisa trama un plan para liberar al mutante.', 100, 400, '2017', 'agua'),
(6, 'Tres anuncios en las afueras', 4.99, 175, 'https://www.youtube.com/watch?v=uLr4jog9EX8', 'Una mujer cuya hija fue asesinada se enfrenta a la policía usando los carteles publicitarios para denunciar que han pasado meses desde que se cometió el crimen y no solo no han resuelto nada, sino que parecen no tener interés en hacerlo.', 50, 165, '2017', 'anuncios'),
(7, 'It', 7.99, 195, 'https://www.youtube.com/watch?v=xKJmEC5ieOk', 'Varios niños de una pequeña ciudad del estado de Maine se alían para combatir a una entidad diabólica que adopta la forma de un payaso y desde hace mucho tiempo emerge cada 27 años para saciarse de sangre infantil.', 250, 1100, '2017', 'it'),
(8, 'Un monstruo viene a verme', 4.99, 108, 'https://www.youtube.com/watch?v=1-fubC9JN50', 'Un niño de 12 anos evoca un monstruo en su imaginación y este ayuda al niño a lidiar con su miserable vida y le enseña a tener coraje.', 100, 360, '2016', 'monstruo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `ID_Usuario` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Fecha_registro` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`ID_Usuario`, `Nombre`, `Apellido`, `Email`, `Password`, `Fecha_registro`) VALUES
(1, 'Diego', 'Abad', 'diego@gmail.com', '12345', '2018-11-21'),
(2, 'Samuel', 'Til', 'samuel@gmail.com', '1234', '2018-11-21'),
(3, 'Pablo', 'Cuesta', 'pablo@gmail.com', '123', '2018-11-21'),
(4, 'Nacho', 'Arbues', 'nacho@gmail.com', '12345', '2018-11-21'),
(5, 'Daniel', 'Nieto', 'daniel@gmail.com', '1234', '2018-11-21'),
(6, 'Alberto', 'Borraz', 'alberto@gmail.com', '12345', '2018-11-21'),
(9, 'PIPO', 'POPO', 'prueba@gmail.com', '12345', '2018-11-29'),
(10, 'Victor', 'Carnicer', 'victor@gmail.com', '123', '2019-06-14'),
(11, 'pavlo', 'checa', 'pavlo@gmail.com', '123', '2019-06-17'),
(12, 'a', 'a', 'a', 'a', 'a');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actor`
--
ALTER TABLE `actor`
  ADD PRIMARY KEY (`ID_Actor`),
  ADD KEY `ID_Actor` (`ID_Actor`);

--
-- Indices de la tabla `actuar`
--
ALTER TABLE `actuar`
  ADD PRIMARY KEY (`ID_Actuacion`),
  ADD UNIQUE KEY `ID_Actor` (`ID_Actor`,`ID_Pelicula`) USING BTREE,
  ADD KEY `FK_PELICULA` (`ID_Pelicula`);

--
-- Indices de la tabla `clasificar`
--
ALTER TABLE `clasificar`
  ADD PRIMARY KEY (`ID_Clasificacion`),
  ADD UNIQUE KEY `ID_Pelicula` (`ID_Pelicula`,`ID_Genero`) USING BTREE,
  ADD KEY `FK_GENERO` (`ID_Genero`);

--
-- Indices de la tabla `desear`
--
ALTER TABLE `desear`
  ADD PRIMARY KEY (`ID_Deseado`),
  ADD UNIQUE KEY `ID_Pelicula` (`ID_Pelicula`,`ID_Usuario`) USING BTREE,
  ADD KEY `FK_USUARIO` (`ID_Usuario`);

--
-- Indices de la tabla `genero`
--
ALTER TABLE `genero`
  ADD PRIMARY KEY (`ID_Genero`),
  ADD UNIQUE KEY `Genero` (`Genero`),
  ADD KEY `ID_Genero` (`ID_Genero`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`ID_Pelicula`),
  ADD KEY `ID_Pelicula` (`ID_Pelicula`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`ID_Usuario`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actor`
--
ALTER TABLE `actor`
  MODIFY `ID_Actor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `actuar`
--
ALTER TABLE `actuar`
  MODIFY `ID_Actuacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `clasificar`
--
ALTER TABLE `clasificar`
  MODIFY `ID_Clasificacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `desear`
--
ALTER TABLE `desear`
  MODIFY `ID_Deseado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=74;
--
-- AUTO_INCREMENT de la tabla `genero`
--
ALTER TABLE `genero`
  MODIFY `ID_Genero` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `ID_Pelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `ID_Usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actuar`
--
ALTER TABLE `actuar`
  ADD CONSTRAINT `FK_ACTOR` FOREIGN KEY (`ID_Actor`) REFERENCES `actor` (`ID_Actor`),
  ADD CONSTRAINT `FK_PELICULA` FOREIGN KEY (`ID_Pelicula`) REFERENCES `pelicula` (`ID_Pelicula`);

--
-- Filtros para la tabla `clasificar`
--
ALTER TABLE `clasificar`
  ADD CONSTRAINT `FK_GENERO` FOREIGN KEY (`ID_Genero`) REFERENCES `genero` (`ID_Genero`),
  ADD CONSTRAINT `FK_PELICULA_CLA` FOREIGN KEY (`ID_Pelicula`) REFERENCES `pelicula` (`ID_Pelicula`);

--
-- Filtros para la tabla `desear`
--
ALTER TABLE `desear`
  ADD CONSTRAINT `FK_PELICULA_DESEAR` FOREIGN KEY (`ID_Pelicula`) REFERENCES `pelicula` (`ID_Pelicula`),
  ADD CONSTRAINT `FK_USUARIO` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuario` (`ID_Usuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
