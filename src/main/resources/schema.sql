-- -----------------------------------------------------
-- Table `quicksilver`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quicksilver`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `quicksilver`.`delivery_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quicksilver`.`delivery_order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `order_number` VARCHAR(45) NOT NULL UNIQUE,
  `customer_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `customer_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `customer_id`
    FOREIGN KEY (`customer_id`)
    REFERENCES `quicksilver`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `quicksilver`.`outgoing_call_task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `quicksilver`.`outgoing_call_task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `delivery_order_id` INT NOT NULL,
  `create_at` TIMESTAMP NOT NULL,
  `active` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `delivery_order_idx` (`delivery_order_id` ASC) VISIBLE,
  CONSTRAINT `delivery_order_id`
    FOREIGN KEY (`delivery_order_id`)
    REFERENCES `quicksilver`.`delivery_order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
