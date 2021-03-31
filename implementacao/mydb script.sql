-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Cliente` (
  `idCliente` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `Senha` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `FKCliente` INT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `FKCliente_idx` (`FKCliente` ASC) VISIBLE,
  CONSTRAINT `FKCliente`
    FOREIGN KEY (`FKCliente`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Filial`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Filial` (
  `idFilial` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `FKUsuario` INT NULL,
  PRIMARY KEY (`idFilial`),
  INDEX `Fkusuario_idx` (`FKUsuario` ASC) VISIBLE,
  CONSTRAINT `Fkusuario`
    FOREIGN KEY (`FKUsuario`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`FormaPagamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`FormaPagamento` (
  `idFormaPagamento` INT NOT NULL,
  `TipoFormaPagamento` VARCHAR(45) NULL,
  `Cartão` VARCHAR(45) NULL,
  `Boleto` VARCHAR(45) NULL,
  `Pix` VARCHAR(45) NULL,
  `Dinheiro` VARCHAR(45) NULL,
  `Transferencia` VARCHAR(45) NULL,
  PRIMARY KEY (`idFormaPagamento`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoEstoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoEstoque` (
  `idPedidoEstoque` INT NOT NULL,
  `Quantidade` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  `FKfilial` INT NULL,
  `FKusuarioPedido` INT NULL,
  `FKclientePedido` INT NULL,
  `observacao` VARCHAR(45) NULL,
  `FKFormaPgamento` INT NULL,
  PRIMARY KEY (`idPedidoEstoque`),
  INDEX `FKFilial_idx` (`FKfilial` ASC) VISIBLE,
  INDEX `FkUsuario_idx` (`FKusuarioPedido` ASC) VISIBLE,
  INDEX `Fkcliente_idx` (`FKclientePedido` ASC) VISIBLE,
  INDEX `FkFormaPagamento_idx` (`FKFormaPgamento` ASC) VISIBLE,
  CONSTRAINT `FKFilial`
    FOREIGN KEY (`FKfilial`)
    REFERENCES `mydb`.`Filial` (`idFilial`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FkusuarioPedido`
    FOREIGN KEY (`FKusuarioPedido`)
    REFERENCES `mydb`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FkclientePedido`
    FOREIGN KEY (`FKclientePedido`)
    REFERENCES `mydb`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FkFormaPagamento`
    FOREIGN KEY (`FKFormaPgamento`)
    REFERENCES `mydb`.`FormaPagamento` (`idFormaPagamento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`estoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`estoque` (
  `idestoque` INT NOT NULL,
  `quantidade` VARCHAR(45) NULL,
  `FKPedidoEstok` INT NULL,
  PRIMARY KEY (`idestoque`),
  INDEX `FkPedidoEstoque_idx` (`FKPedidoEstok` ASC) VISIBLE,
  CONSTRAINT `FkPedidoEstok`
    FOREIGN KEY (`FKPedidoEstok`)
    REFERENCES `mydb`.`PedidoEstoque` (`idPedidoEstoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Produto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Produto` (
  `idProduto` INT NOT NULL,
  `nome` VARCHAR(200) NULL,
  `status` VARCHAR(45) NULL,
  `Sequencial` VARCHAR(45) NULL,
  `CodBarras` VARCHAR(45) NULL,
  `TipoProduto` VARCHAR(45) NULL,
  `Caracteristicas` VARCHAR(45) NULL,
  `Quantidade` VARCHAR(45) NULL,
  PRIMARY KEY (`idProduto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ItensPedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`ItensPedido` (
  `idItensPedido` INT NOT NULL,
  `Status` VARCHAR(45) NOT NULL,
  `Quantidade` VARCHAR(45) NOT NULL,
  `ValorUnitario` VARCHAR(45) NULL,
  `ValorTotal` VARCHAR(45) NULL,
  `FKprodutoItens` INT NULL,
  PRIMARY KEY (`idItensPedido`),
  INDEX `Fkproduto_idx` (`FKprodutoItens` ASC) VISIBLE,
  CONSTRAINT `FkprodutoItens`
    FOREIGN KEY (`FKprodutoItens`)
    REFERENCES `mydb`.`Produto` (`idProduto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PedidoEstoque_has_PedidoEstoque`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`PedidoEstoque_has_PedidoEstoque` (
  `PedidoEstoque_idPedidoEstoque` INT NOT NULL,
  `PedidoEstoque_idPedidoEstoque1` INT NOT NULL,
  PRIMARY KEY (`PedidoEstoque_idPedidoEstoque`, `PedidoEstoque_idPedidoEstoque1`),
  INDEX `fk_PedidoEstoque_has_PedidoEstoque_PedidoEstoque2_idx` (`PedidoEstoque_idPedidoEstoque1` ASC) VISIBLE,
  INDEX `fk_PedidoEstoque_has_PedidoEstoque_PedidoEstoque1_idx` (`PedidoEstoque_idPedidoEstoque` ASC) VISIBLE,
  CONSTRAINT `fk_PedidoEstoque_has_PedidoEstoque_PedidoEstoque1`
    FOREIGN KEY (`PedidoEstoque_idPedidoEstoque`)
    REFERENCES `mydb`.`PedidoEstoque` (`idPedidoEstoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PedidoEstoque_has_PedidoEstoque_PedidoEstoque2`
    FOREIGN KEY (`PedidoEstoque_idPedidoEstoque1`)
    REFERENCES `mydb`.`PedidoEstoque` (`idPedidoEstoque`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
