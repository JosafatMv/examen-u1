
--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `curp` varchar(18) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `apellido_paterno` varchar(40) NOT NULL,
  `apellido_materno` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`curp`),
  UNIQUE KEY `curp_UNIQUE` (`curp`),
  UNIQUE KEY `rfc_UNIQUE` (`rfc`)
);

