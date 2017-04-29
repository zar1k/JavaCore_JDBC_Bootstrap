-- -----------------------------------------------------
-- Schema test_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `test_db`
  DEFAULT CHARACTER SET utf8;
USE `test_db`;

-- -----------------------------------------------------
-- Table `test_db`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`address` (
  `id`       INT(11)     NOT NULL,
  `country`  VARCHAR(45) NOT NULL,
  `street`   VARCHAR(45) NOT NULL,
  `zip_code` INT(11)     NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `test_db`.`music_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`music_type` (
  `id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `test_db`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`role` (
  `id`   INT(11)     NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `test_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`users` (
  `id`         INT(11)     NOT NULL AUTO_INCREMENT,
  `login`      VARCHAR(45) NOT NULL,
  `password`   VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name`  VARCHAR(45) NOT NULL,
  `age`        INT(11)     NOT NULL,
  `role_id`    INT(11)     NOT NULL,
  `address_id` INT(11)     NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `fk_users_role_idx` (`role_id` ASC),
  INDEX `fk_users_address1_idx` (`address_id` ASC),
  CONSTRAINT `fk_users_role`
  FOREIGN KEY (`role_id`)
  REFERENCES `test_db`.`role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_address1`
  FOREIGN KEY (`address_id`)
  REFERENCES `test_db`.`address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

-- -----------------------------------------------------
-- Table `test_db`.`users_has_music_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `test_db`.`users_has_music_type` (
  `users_id`      INT(11) NOT NULL,
  `music_type_id` INT(11) NOT NULL,
  PRIMARY KEY (`users_id`, `music_type_id`),
  INDEX `fk_users_has_music_type_music_type1_idx` (`music_type_id` ASC),
  INDEX `fk_users_has_music_type_users1_idx` (`users_id` ASC),
  FOREIGN KEY (`music_type_id`)
  REFERENCES `test_db`.`music_type` (`id`),
  FOREIGN KEY (`users_id`)
  REFERENCES `test_db`.`users` (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;
