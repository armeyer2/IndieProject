drop table if exists 'user';
create table user (id smallint unsigned not null auto_increment, first_name varchar(20), last_name varchar(20), birth_year int(4), user_name varchar(30), password varchar(30), constraint primary_key primary key (id) );
INSERT INTO `user` VALUES (1, 'Dave', 'Mann', 95, 'DMann', 'password'),(2, 'Michael', 'McCarthy', 92, 'RedFox', 'password'),(3, 'Brian', 'Micheals', 67, 'BlueDragonBrian', 'password'),(4, 'Tim', 'Meyer' , 87, 'CoolGuy', 'password');

drop table if exists 'orders';
CREATE TABLE orders
(
  id          INT AUTO_INCREMENT
    PRIMARY KEY,
  description VARCHAR(100) NULL,
  user_id     INT          NOT NULL,
  CONSTRAINT orders_user_id_fk
  FOREIGN KEY (user_id) REFERENCES user (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
)
  ENGINE = InnoDB;

CREATE INDEX orders_user_id_fk
  ON orders (user_id);

Insert into `orders` (id, description, user_id) values (1, 'February Small Crewneck', 2), (2, 'February Large Long-Sleeve', 1), (3, 'February Small Long-Sleeve', 3);