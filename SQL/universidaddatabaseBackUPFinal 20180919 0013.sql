﻿--
-- Script was generated by Devart dbForge Studio for MySQL, Version 8.0.40.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 9/19/2018 12:13:03 AM
-- Server version: 5.5.5-10.1.34-MariaDB
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 
-- Set character set the client will use to send SQL statements to the server
--
SET NAMES 'utf8';

--
-- Set default database
--
USE universidaddatabase;

--
-- Drop table `materia`
--
DROP TABLE IF EXISTS materia;

--
-- Drop table `carrera`
--
DROP TABLE IF EXISTS carrera;

--
-- Drop table `notasyfaltas`
--
DROP TABLE IF EXISTS notasyfaltas;

--
-- Drop table `clase`
--
DROP TABLE IF EXISTS clase;

--
-- Drop table `aula`
--
DROP TABLE IF EXISTS aula;

--
-- Drop table `docente`
--
DROP TABLE IF EXISTS docente;

--
-- Drop table `cuenta`
--
DROP TABLE IF EXISTS cuenta;

--
-- Drop table `transporte`
--
DROP TABLE IF EXISTS transporte;

--
-- Drop table `estudiante`
--
DROP TABLE IF EXISTS estudiante;

--
-- Drop table `horarios`
--
DROP TABLE IF EXISTS horarios;

--
-- Drop table `semestre`
--
DROP TABLE IF EXISTS semestre;

--
-- Set default database
--
USE universidaddatabase;

--
-- Create table `semestre`
--
CREATE TABLE semestre (
  IdSemestre int(11) NOT NULL,
  Modulo int(11) NOT NULL,
  Año year(4) NOT NULL,
  PRIMARY KEY (IdSemestre)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `horarios`
--
CREATE TABLE horarios (
  CodigoHorario int(11) NOT NULL,
  Paralelo varchar(5) NOT NULL,
  IdClase int(11) NOT NULL,
  Modalidad varchar(255) NOT NULL,
  FechaInicio date NOT NULL,
  FechaFinal date NOT NULL,
  PRIMARY KEY (CodigoHorario)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create index `FK_horarios_clase_IdClase` on table `horarios`
--
ALTER TABLE horarios
ADD INDEX FK_horarios_clase_IdClase (IdClase);

--
-- Create table `estudiante`
--
CREATE TABLE estudiante (
  CodigoEstudiante int(11) NOT NULL DEFAULT 1,
  Nombres varchar(255) NOT NULL,
  Apellidos varchar(255) NOT NULL,
  Telefono int(8) NOT NULL,
  Direccion varchar(255) NOT NULL,
  PAA tinyint(1) NOT NULL,
  CI varchar(255) NOT NULL,
  FechaNacimiento date NOT NULL,
  PRIMARY KEY (CodigoEstudiante)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 1365,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `transporte`
--
CREATE TABLE transporte (
  CodigoVehiculo int(11) NOT NULL,
  CodigoEstudiante int(11) NOT NULL,
  Placa varchar(255) NOT NULL,
  Marca varchar(255) NOT NULL,
  Color varchar(255) NOT NULL,
  Soat varchar(255) NOT NULL,
  PRIMARY KEY (CodigoVehiculo)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 8192,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE transporte
ADD CONSTRAINT FK_transporte_estudiante_CodigoEstudiante FOREIGN KEY (CodigoEstudiante)
REFERENCES estudiante (CodigoEstudiante) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `cuenta`
--
CREATE TABLE cuenta (
  CodigoCuenta int(11) NOT NULL,
  SaldoPagar decimal(10, 2) NOT NULL,
  ImportePagado decimal(10, 2) NOT NULL,
  DescuentoBeca decimal(10, 2) NOT NULL,
  PlanDePagos varchar(255) NOT NULL,
  CodigoEstudiante int(11) NOT NULL,
  PRIMARY KEY (CodigoCuenta)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 5461,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE cuenta
ADD CONSTRAINT FK_cuenta_estudiante_CodigoEstudiante FOREIGN KEY (CodigoEstudiante)
REFERENCES estudiante (CodigoEstudiante) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `docente`
--
CREATE TABLE docente (
  CodigoDocente int(11) NOT NULL,
  Nombres varchar(255) NOT NULL,
  Apellidos varchar(255) NOT NULL,
  Titulacion varchar(255) NOT NULL,
  SeguroMedico varchar(255) NOT NULL,
  Celular int(11) NOT NULL,
  FechaNacimiento date NOT NULL,
  PRIMARY KEY (CodigoDocente)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 16384,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `aula`
--
CREATE TABLE aula (
  IdAula int(11) NOT NULL,
  NumeroAula int(11) NOT NULL,
  PRIMARY KEY (IdAula)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 16384,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `clase`
--
CREATE TABLE clase (
  IdClase int(11) NOT NULL,
  CodigoDocente int(11) NOT NULL,
  IdSemestre int(11) NOT NULL,
  CodigoEstudiante int(11) NOT NULL,
  CodigoHorario int(11) NOT NULL,
  IdAula int(11) NOT NULL,
  PRIMARY KEY (IdClase)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE clase
ADD CONSTRAINT FK_clase_aula_IdAula FOREIGN KEY (IdAula)
REFERENCES aula (IdAula) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE clase
ADD CONSTRAINT FK_clase_docente_CodigoDocente FOREIGN KEY (CodigoDocente)
REFERENCES docente (CodigoDocente) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE clase
ADD CONSTRAINT FK_clase_estudiante_CodigoEstudiante FOREIGN KEY (CodigoEstudiante)
REFERENCES estudiante (CodigoEstudiante) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE clase
ADD CONSTRAINT FK_clase_horarios_CodigoHorario FOREIGN KEY (CodigoHorario)
REFERENCES horarios (CodigoHorario) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE clase
ADD CONSTRAINT FK_clase_semestre_IdSemestre FOREIGN KEY (IdSemestre)
REFERENCES semestre (IdSemestre) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `notasyfaltas`
--
CREATE TABLE notasyfaltas (
  IdClase int(11) NOT NULL,
  Creditos int(11) NOT NULL,
  Faltas int(11) NOT NULL,
  Parcial int(11) NOT NULL,
  NotaFinal int(11) NOT NULL,
  PRIMARY KEY (IdClase)
)
ENGINE = INNODB,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE notasyfaltas
ADD CONSTRAINT FK_notasyfaltas_clase_IdClase FOREIGN KEY (IdClase)
REFERENCES clase (IdClase) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create table `carrera`
--
CREATE TABLE carrera (
  IdCarrera int(11) NOT NULL,
  JefeDeCarrera varchar(255) NOT NULL,
  Nombre varchar(255) NOT NULL,
  PRIMARY KEY (IdCarrera)
)
ENGINE = INNODB,
AVG_ROW_LENGTH = 5461,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create table `materia`
--
CREATE TABLE materia (
  CodigoMateria int(11) NOT NULL AUTO_INCREMENT,
  Creditos int(11) NOT NULL,
  Estado varchar(255) NOT NULL,
  IdCarrera int(11) NOT NULL,
  IdClase int(11) NOT NULL,
  PRIMARY KEY (CodigoMateria)
)
ENGINE = INNODB,
AUTO_INCREMENT = 7,
CHARACTER SET latin1,
COLLATE latin1_swedish_ci;

--
-- Create foreign key
--
ALTER TABLE materia
ADD CONSTRAINT FK_materia_carrera_IdCarrera FOREIGN KEY (IdCarrera)
REFERENCES carrera (IdCarrera) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Create foreign key
--
ALTER TABLE materia
ADD CONSTRAINT FK_materia_clase_IdClase FOREIGN KEY (IdClase)
REFERENCES clase (IdClase) ON DELETE NO ACTION ON UPDATE NO ACTION;

-- 
-- Dumping data for table semestre
--
-- Table universidaddatabase.semestre does not contain any data (it is empty)

-- 
-- Dumping data for table horarios
--
-- Table universidaddatabase.horarios does not contain any data (it is empty)

-- 
-- Dumping data for table estudiante
--
INSERT INTO estudiante VALUES
(1, '1', '1', 1, '1', 1, '1', '0111-11-11'),
(2, '1', '1', 2, '2', 1, '1', '0020-07-11'),
(3, '1', '1', 1, '1', 1, '1', '1111-11-11'),
(5, '3', '32', 1, '32', 1, '32', '0001-01-01'),
(6, 'rdfghjkl', '1', 2, '2', 1, '1', '0011-11-11'),
(9, '9', '9', 9, '9', 1, '9', '1999-10-09'),
(11, '1', '1', 1, '1', 1, '1', '1999-11-11'),
(13, '1', '1', 1, '1', 1, '1', '1222-11-11'),
(14, 'zda', 'asd', 23, '12', 1, '133', '1222-11-11'),
(15, '1', '1', 1, '1', 1, '1', '1111-11-11'),
(16, '1', '1', 1, '1', 1, '1', '0111-11-11'),
(231, '153212', '123', 123, '123', 1, '123', '0025-08-01');

-- 
-- Dumping data for table docente
--
INSERT INTO docente VALUES
(5, '3', '2', '2', '23', 23, '1555-02-02');

-- 
-- Dumping data for table aula
--
INSERT INTO aula VALUES
(6, 2);

-- 
-- Dumping data for table clase
--
-- Table universidaddatabase.clase does not contain any data (it is empty)

-- 
-- Dumping data for table carrera
--
INSERT INTO carrera VALUES
(1, '1', '1'),
(5, '1', '1'),
(8, 'asdfg', 'as');

-- 
-- Dumping data for table transporte
--
INSERT INTO transporte VALUES
(2, 11, '1223', '123', '12', '1'),
(4, 11, '13', '2', '1', '1');

-- 
-- Dumping data for table notasyfaltas
--
-- Table universidaddatabase.notasyfaltas does not contain any data (it is empty)

-- 
-- Dumping data for table materia
--
-- Table universidaddatabase.materia does not contain any data (it is empty)

-- 
-- Dumping data for table cuenta
--
INSERT INTO cuenta VALUES
(1, 32.00, 132.00, 123.00, '123', 1),
(2, 1.00, 1.00, 1.00, '1', 11),
(5, 23.00, 15.00, 156.00, '156', 3);

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;