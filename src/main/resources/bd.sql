-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema apis
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema apis
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `apis` DEFAULT CHARACTER SET utf8 ;
USE `apis` ;

-- -----------------------------------------------------
-- Table `apis`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apis`.`tipo` (
                                             `id` INT NOT NULL AUTO_INCREMENT,
                                             `tipo` VARCHAR(45) NULL,
    `value` VARCHAR(45) NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `tipo_UNIQUE` (`tipo` ASC),
    UNIQUE INDEX `value_UNIQUE` (`value` ASC))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apis`.`autos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apis`.`autos` (
                                              `id` INT NOT NULL AUTO_INCREMENT,
                                              `marca` VARCHAR(45) NULL,
    `modelo` VARCHAR(45) NULL,
    `placa` VARCHAR(45) NOT NULL,
    `fk_id_tipo` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `placa_UNIQUE` (`placa` ASC),
    INDEX `fk_autos_tipo_idx` (`fk_id_tipo` ASC),
    CONSTRAINT `fk_autos_tipo`
    FOREIGN KEY (`fk_id_tipo`)
    REFERENCES `apis`.`tipo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apis`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apis`.`estado` (
                                               `id` INT NOT NULL,
                                               `estado` VARCHAR(45) NULL,
    PRIMARY KEY (`id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `apis`.`bitacora`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `apis`.`bitacora` (
                                                 `id` INT NOT NULL,
                                                 `entrada` DATETIME NULL,
                                                 `salida` DATETIME NULL,
                                                 `fk_id_estado` INT NOT NULL,
                                                 PRIMARY KEY (`id`),
    INDEX `fk_estancia_estados1_idx` (`fk_id_estado` ASC),
    CONSTRAINT `fk_estancia_estados1`
    FOREIGN KEY (`fk_id_estado`)
    REFERENCES `apis`.`estado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




######add id autoicrementables

ALTER TABLE `apis`.`bitacora`
    CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `apis`.`estado`
    CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

# Se agrego relacion entre bitacora y vehiculo

ALTER TABLE `apis`.`bitacora`
    ADD COLUMN `fk_id_auto` INT(11) NOT NULL AFTER `fk_id_estado`,
ADD INDEX `fk_bitacora_autos1_idx` (`fk_id_auto` ASC);
;

ALTER TABLE `apis`.`bitacora`
    ADD CONSTRAINT `fk_bitacora_autos1`
        FOREIGN KEY (`fk_id_auto`)
            REFERENCES `apis`.`autos` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;


