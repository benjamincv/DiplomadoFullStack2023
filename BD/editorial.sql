-- MySQL Script generated by MySQL Workbench
-- Thu Oct 26 17:50:17 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Editorial
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Editorial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Editorial` DEFAULT CHARACTER SET utf8 ;
USE `Editorial` ;

-- -----------------------------------------------------
-- Table `Editorial`.`Editorial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Editorial` (
  `idEditorial` VARCHAR(10) NOT NULL,
  `nombre` VARCHAR(100) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idEditorial`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Coleccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Coleccion` (
  `idColeccion` VARCHAR(10) NOT NULL,
  `nombreCol` VARCHAR(100) NOT NULL,
  `ancho` VARCHAR(10) NOT NULL,
  `alto` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idColeccion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Libro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Libro` (
  `idregistro` VARCHAR(10) NOT NULL,
  `titulo` VARCHAR(100) NOT NULL,
  `subtitulo` VARCHAR(100) NULL,
  `isbn` VARCHAR(15) NULL,
  `Editorial_idEditorial` VARCHAR(10) NOT NULL,
  `Coleccion_idColeccion` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idregistro`, `Editorial_idEditorial`, `Coleccion_idColeccion`),
  INDEX `fk_Libro_Editorial1_idx` (`Editorial_idEditorial` ASC) VISIBLE,
  INDEX `fk_Libro_Coleccion1_idx` (`Coleccion_idColeccion` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_Editorial1`
    FOREIGN KEY (`Editorial_idEditorial`)
    REFERENCES `Editorial`.`Editorial` (`idEditorial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_Coleccion1`
    FOREIGN KEY (`Coleccion_idColeccion`)
    REFERENCES `Editorial`.`Coleccion` (`idColeccion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Autores` (
  `idAutores` VARCHAR(10) NOT NULL,
  `nombreAutor` VARCHAR(100) NOT NULL,
  `gradoAcademico` VARCHAR(50) NULL,
  `institucion` VARCHAR(100) NULL,
  PRIMARY KEY (`idAutores`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Coediciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Coediciones` (
  `idInstitucion` VARCHAR(10) NOT NULL,
  `nombreInst` VARCHAR(100) NOT NULL,
  `siglasInst` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`idInstitucion`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Libro_has_Autores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Libro_has_Autores` (
  `Libro_idregistro` VARCHAR(10) NOT NULL,
  `Autores_idAutores` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Libro_idregistro`, `Autores_idAutores`),
  INDEX `fk_Libro_has_Autores_Autores1_idx` (`Autores_idAutores` ASC) VISIBLE,
  INDEX `fk_Libro_has_Autores_Libro_idx` (`Libro_idregistro` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Autores_Libro`
    FOREIGN KEY (`Libro_idregistro`)
    REFERENCES `Editorial`.`Libro` (`idregistro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Autores_Autores1`
    FOREIGN KEY (`Autores_idAutores`)
    REFERENCES `Editorial`.`Autores` (`idAutores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Editorial`.`Libro_has_Coediciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Editorial`.`Libro_has_Coediciones` (
  `Libro_idregistro` VARCHAR(10) NOT NULL,
  `Coediciones_idInstitucion` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`Libro_idregistro`, `Coediciones_idInstitucion`),
  INDEX `fk_Libro_has_Coediciones_Coediciones1_idx` (`Coediciones_idInstitucion` ASC) VISIBLE,
  INDEX `fk_Libro_has_Coediciones_Libro1_idx` (`Libro_idregistro` ASC) VISIBLE,
  CONSTRAINT `fk_Libro_has_Coediciones_Libro1`
    FOREIGN KEY (`Libro_idregistro`)
    REFERENCES `Editorial`.`Libro` (`idregistro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_has_Coediciones_Coediciones1`
    FOREIGN KEY (`Coediciones_idInstitucion`)
    REFERENCES `Editorial`.`Coediciones` (`idInstitucion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
