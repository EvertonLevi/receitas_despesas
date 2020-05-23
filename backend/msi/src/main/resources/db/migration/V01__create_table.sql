

-- MySQL Script generated by MySQL Workbench
-- Sat Apr 11 23:54:01 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
-- SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
-- SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema msi
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema msi
-- -----------------------------------------------------
-- CREATE SCHEMA IF NOT EXISTS `msi` DEFAULT CHARACTER SET utf8 ;
-- USE `msi` ;


-- -----------------------------------------------------
-- Table `msi`.`usuario`
-- -----------------------------------------------------
CREATE TABLE usuario
(
  id BIGINT NOT NULL
  AUTO_INCREMENT,
  nome VARCHAR
  (30) NOT NULL,
  email VARCHAR
  (50) NOT NULL,
  senha VARCHAR
  (255) NOT NULL,
  conta_id BIGINT,
  PRIMARY KEY
  (id) 
    )ENGINE=InnoDB DEFAULT CHARSET=utf8;


  -- -----------------------------------------------------
  -- Table `msi`.`lancamento`
  -- -----------------------------------------------------
  CREATE TABLE lancamento  (
    id BIGINT NOT NULL
    AUTO_INCREMENT,
  descricao VARCHAR
    (255) NOT NULL,
  valor FLOAT NOT NULL,
  data_de_lancamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  usuario_id BIGINT DEFAULT NULL,
  PRIMARY KEY
    (id)  )ENGINE    =InnoDB DEFAULT CHARSET=utf8;

    -- -----------------------------------------------------
    -- Table `msi`.`conta`
    -- -----------------------------------------------------
    CREATE TABLE conta
    (
      id BIGINT NOT NULL
      AUTO_INCREMENT,
  descricao VARCHAR
      (255) NOT NULL,
  PRIMARY KEY
      (id))
ENGINE=InnoDB DEFAULT CHARSET=utf8;
