-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sistemasube
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sistemasube` ;

-- -----------------------------------------------------
-- Schema sistemasube
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sistemasube` DEFAULT CHARACTER SET utf8 ;
USE `sistemasube` ;

-- -----------------------------------------------------
-- Table `sistemasube`.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`cliente` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`cliente` (
  `idCliente` INT(11) NOT NULL COMMENT '',
  `nombre` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `apellido` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `dni` INT(11) NULL DEFAULT NULL COMMENT '',
  `lstTarjetas` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `lstDesc` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idCliente`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`tarjeta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`tarjeta` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`tarjeta` (
  `idTarjeta` INT(11) NOT NULL COMMENT '',
  `nroTarjeta` INT(16) NULL DEFAULT NULL COMMENT '',
  `saldo` FLOAT NULL DEFAULT NULL COMMENT '',
  `tarjetaActiva` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `lstViajes` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `cliente_idCliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idTarjeta`, `cliente_idCliente`)  COMMENT '',
  INDEX `fk_tarjeta_cliente_idx` (`cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_tarjeta_cliente`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `sistemasube`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`viaje`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`viaje` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`viaje` (
  `idViaje` INT(11) NOT NULL COMMENT '',
  `lstBoletos` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `tarjeta_idTarjeta` INT(11) NOT NULL COMMENT '',
  `tarjeta_cliente_idCliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idViaje`, `tarjeta_idTarjeta`, `tarjeta_cliente_idCliente`)  COMMENT '',
  INDEX `fk_viaje_tarjeta1_idx` (`tarjeta_idTarjeta` ASC, `tarjeta_cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_viaje_tarjeta1`
    FOREIGN KEY (`tarjeta_idTarjeta` , `tarjeta_cliente_idCliente`)
    REFERENCES `sistemasube`.`tarjeta` (`idTarjeta` , `cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`boleto`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`boleto` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`boleto` (
  `idBoleto` INT(11) NOT NULL COMMENT '',
  `fechaHora` DATETIME NULL DEFAULT NULL COMMENT '',
  `linea` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `monto` FLOAT NULL DEFAULT NULL COMMENT '',
  `transporte` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `cerrarViaje` BIT NULL COMMENT '',
  `viaje_idViaje` INT(11) NOT NULL COMMENT '',
  `viaje_tarjeta_idTarjeta` INT(11) NOT NULL COMMENT '',
  `viaje_tarjeta_cliente_idCliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idBoleto`, `viaje_idViaje`, `viaje_tarjeta_idTarjeta`, `viaje_tarjeta_cliente_idCliente`)  COMMENT '',
  INDEX `fk_boleto_viaje1_idx` (`viaje_idViaje` ASC, `viaje_tarjeta_idTarjeta` ASC, `viaje_tarjeta_cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_boleto_viaje1`
    FOREIGN KEY (`viaje_idViaje` , `viaje_tarjeta_idTarjeta` , `viaje_tarjeta_cliente_idCliente`)
    REFERENCES `sistemasube`.`viaje` (`idViaje` , `tarjeta_idTarjeta` , `tarjeta_cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`transporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`transporte` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`transporte` (
  `idTransporte` INT(11) NOT NULL COMMENT '',
  `boleto_idBoleto` INT(11) NOT NULL COMMENT '',
  `boleto_viaje_idViaje` INT(11) NOT NULL COMMENT '',
  `boleto_viaje_tarjeta_idTarjeta` INT(11) NOT NULL COMMENT '',
  `boleto_viaje_tarjeta_cliente_idCliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idTransporte`, `boleto_idBoleto`, `boleto_viaje_idViaje`, `boleto_viaje_tarjeta_idTarjeta`, `boleto_viaje_tarjeta_cliente_idCliente`)  COMMENT '',
  INDEX `fk_transporte_boleto1_idx` (`boleto_idBoleto` ASC, `boleto_viaje_idViaje` ASC, `boleto_viaje_tarjeta_idTarjeta` ASC, `boleto_viaje_tarjeta_cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_transporte_boleto1`
    FOREIGN KEY (`boleto_idBoleto` , `boleto_viaje_idViaje` , `boleto_viaje_tarjeta_idTarjeta` , `boleto_viaje_tarjeta_cliente_idCliente`)
    REFERENCES `sistemasube`.`boleto` (`idBoleto` , `viaje_idViaje` , `viaje_tarjeta_idTarjeta` , `viaje_tarjeta_cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`colectivo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`colectivo` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`colectivo` (
  `idColectivo` INT(11) NOT NULL COMMENT '',
  `linea` INT(10) UNSIGNED NULL DEFAULT NULL COMMENT '',
  `interno` INT(11) NULL DEFAULT NULL COMMENT '\n',
  `tramo` INT(11) NULL DEFAULT NULL COMMENT '',
  `transporte_idTransporte` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idColectivo`, `transporte_idTransporte`)  COMMENT '',
  INDEX `fk_colectivo_transporte1_idx` (`transporte_idTransporte` ASC)  COMMENT '',
  CONSTRAINT `fk_colectivo_transporte1`
    FOREIGN KEY (`transporte_idTransporte`)
    REFERENCES `sistemasube`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`descuento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`descuento` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`descuento` (
  `idDescuento` INT(11) NOT NULL COMMENT '',
  `nombreDesc` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  `montoDesc` FLOAT NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idDescuento`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`linea`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`linea` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`linea` (
  `idTren` INT(11) NOT NULL COMMENT '',
  `linea` VARCHAR(45) NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idTren`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`tren`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`tren` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`tren` (
  `idEstacion` INT(11) NOT NULL COMMENT '',
  `nombreEstacion` VARCHAR(20) NULL DEFAULT NULL COMMENT '',
  `transporte_idTransporte` INT(11) NOT NULL COMMENT '',
  `linea_idTren` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idEstacion`, `transporte_idTransporte`, `linea_idTren`)  COMMENT '',
  INDEX `fk_tren_transporte1_idx` (`transporte_idTransporte` ASC)  COMMENT '',
  INDEX `fk_tren_linea1_idx` (`linea_idTren` ASC)  COMMENT '',
  CONSTRAINT `fk_tren_transporte1`
    FOREIGN KEY (`transporte_idTransporte`)
    REFERENCES `sistemasube`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tren_linea1`
    FOREIGN KEY (`linea_idTren`)
    REFERENCES `sistemasube`.`linea` (`idTren`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`redsube`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`redsube` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`redsube` (
  `idRedSube` INT(11) NOT NULL COMMENT '',
  `procentajeDescuento` DOUBLE NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idRedSube`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`seccion`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`seccion` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`seccion` (
  `idSeccion` INT(11) NOT NULL COMMENT '',
  `codEstacion1` INT NULL DEFAULT NULL COMMENT '',
  `codEstacion2` INT NULL DEFAULT NULL COMMENT '',
  `tramo` INT(11) NULL DEFAULT NULL COMMENT '',
  `linea_idTren` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idSeccion`, `linea_idTren`)  COMMENT '',
  INDEX `fk_seccion_linea1_idx` (`linea_idTren` ASC)  COMMENT '',
  CONSTRAINT `fk_seccion_linea1`
    FOREIGN KEY (`linea_idTren`)
    REFERENCES `sistemasube`.`linea` (`idTren`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`subte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`subte` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`subte` (
  `idSubte` INT(11) NOT NULL COMMENT '',
  `linea` VARCHAR(1) NULL DEFAULT NULL COMMENT '',
  `cantViajes` INT(11) NULL DEFAULT NULL COMMENT '',
  `transporte_idTransporte` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`idSubte`, `transporte_idTransporte`)  COMMENT '',
  INDEX `fk_subte_transporte1_idx` (`transporte_idTransporte` ASC)  COMMENT '',
  CONSTRAINT `fk_subte_transporte1`
    FOREIGN KEY (`transporte_idTransporte`)
    REFERENCES `sistemasube`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`tarifa`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`tarifa` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`tarifa` (
  `idTarifa` INT(11) NOT NULL AUTO_INCREMENT COMMENT '',
  `tramo` INT(11) NULL DEFAULT NULL COMMENT '',
  `monto` FLOAT NULL DEFAULT NULL COMMENT '',
  PRIMARY KEY (`idTarifa`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`descuento_has_cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`descuento_has_cliente` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`descuento_has_cliente` (
  `descuento_idDescuento` INT(11) NOT NULL COMMENT '',
  `cliente_idCliente` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`descuento_idDescuento`, `cliente_idCliente`)  COMMENT '',
  INDEX `fk_descuento_has_cliente_cliente1_idx` (`cliente_idCliente` ASC)  COMMENT '',
  INDEX `fk_descuento_has_cliente_descuento1_idx` (`descuento_idDescuento` ASC)  COMMENT '',
  CONSTRAINT `fk_descuento_has_cliente_descuento1`
    FOREIGN KEY (`descuento_idDescuento`)
    REFERENCES `sistemasube`.`descuento` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_descuento_has_cliente_cliente1`
    FOREIGN KEY (`cliente_idCliente`)
    REFERENCES `sistemasube`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`tarjeta_has_descuento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`tarjeta_has_descuento` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`tarjeta_has_descuento` (
  `tarjeta_idTarjeta` INT(11) NOT NULL COMMENT '',
  `tarjeta_cliente_idCliente` INT(11) NOT NULL COMMENT '',
  `descuento_idDescuento` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`tarjeta_idTarjeta`, `tarjeta_cliente_idCliente`, `descuento_idDescuento`)  COMMENT '',
  INDEX `fk_tarjeta_has_descuento_descuento1_idx` (`descuento_idDescuento` ASC)  COMMENT '',
  INDEX `fk_tarjeta_has_descuento_tarjeta1_idx` (`tarjeta_idTarjeta` ASC, `tarjeta_cliente_idCliente` ASC)  COMMENT '',
  CONSTRAINT `fk_tarjeta_has_descuento_tarjeta1`
    FOREIGN KEY (`tarjeta_idTarjeta` , `tarjeta_cliente_idCliente`)
    REFERENCES `sistemasube`.`tarjeta` (`idTarjeta` , `cliente_idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarjeta_has_descuento_descuento1`
    FOREIGN KEY (`descuento_idDescuento`)
    REFERENCES `sistemasube`.`descuento` (`idDescuento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`tarifa_has_transporte`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`tarifa_has_transporte` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`tarifa_has_transporte` (
  `tarifa_idTarifa` INT(11) NOT NULL COMMENT '',
  `transporte_idTransporte` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`tarifa_idTarifa`, `transporte_idTransporte`)  COMMENT '',
  INDEX `fk_tarifa_has_transporte_transporte1_idx` (`transporte_idTransporte` ASC)  COMMENT '',
  INDEX `fk_tarifa_has_transporte_tarifa1_idx` (`tarifa_idTarifa` ASC)  COMMENT '',
  CONSTRAINT `fk_tarifa_has_transporte_tarifa1`
    FOREIGN KEY (`tarifa_idTarifa`)
    REFERENCES `sistemasube`.`tarifa` (`idTarifa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_tarifa_has_transporte_transporte1`
    FOREIGN KEY (`transporte_idTransporte`)
    REFERENCES `sistemasube`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`transporte_has_redsube`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`transporte_has_redsube` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`transporte_has_redsube` (
  `transporte_idTransporte` INT(11) NOT NULL COMMENT '',
  `redsube_idRedSube` INT(11) NOT NULL COMMENT '',
  PRIMARY KEY (`transporte_idTransporte`, `redsube_idRedSube`)  COMMENT '',
  INDEX `fk_transporte_has_redsube_redsube1_idx` (`redsube_idRedSube` ASC)  COMMENT '',
  INDEX `fk_transporte_has_redsube_transporte1_idx` (`transporte_idTransporte` ASC)  COMMENT '',
  CONSTRAINT `fk_transporte_has_redsube_transporte1`
    FOREIGN KEY (`transporte_idTransporte`)
    REFERENCES `sistemasube`.`transporte` (`idTransporte`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transporte_has_redsube_redsube1`
    FOREIGN KEY (`redsube_idRedSube`)
    REFERENCES `sistemasube`.`redsube` (`idRedSube`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sistemasube`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`usuario` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`usuario` (
  `idusuario` INT NOT NULL COMMENT '',
  `nombreUsuario` INT(11) NULL COMMENT '',
  `clave` VARCHAR(45) NULL COMMENT '',
  `tipoUsuario` VARCHAR(15) NULL COMMENT '',
  PRIMARY KEY (`idusuario`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemasube`.`administrador`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`administrador` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`administrador` (
  `idAdminisitrador` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idAdminisitrador`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sistemasube`.`carga`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `sistemasube`.`carga` ;

CREATE TABLE IF NOT EXISTS `sistemasube`.`carga` (
  `idCarga` INT NOT NULL COMMENT '',
  `saldo` FLOAT NULL COMMENT '',
  PRIMARY KEY (`idCarga`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
