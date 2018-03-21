CREATE TABLE orders
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  description VARCHAR(100) NULL,
  user_id     INT          NOT NULL
)
  ENGINE = InnoDB;

CREATE INDEX orders_user_id_fk
  ON orders (user_id);

CREATE TABLE user
(
  id            INT(10) AUTO_INCREMENT
    PRIMARY KEY,
  first_name    VARCHAR(20) NULL,
  last_name     VARCHAR(20) NULL,
  date_of_birth INT(4)      NULL,
  user_name     VARCHAR(20) NULL,
  password      VARCHAR(20) NULL
)
  ENGINE = InnoDB;

ALTER TABLE orders
  ADD CONSTRAINT orders_user_id_fk
FOREIGN KEY (user_id) REFERENCES user (id)
  ON UPDATE CASCADE
  ON DELETE CASCADE;

CREATE TABLE user_roles
(
  user_name VARCHAR(40) NOT NULL,
  role_name VARCHAR(15) NOT NULL
)
  ENGINE = InnoDB;

