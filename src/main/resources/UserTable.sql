<<<<<<< HEAD
drop table if exists user;
drop table if exists purchases;
create table user (id int(10) not null auto_increment, first_name varchar(20),
  last_name varchar(20), birth_year int(4), constraint primary_key primary key (id) );

  CREATE TABLE IF NOT EXISTS `purchases` (
	`purchase_id` int(10) NOT NULL auto_increment,
	`user_id` int(10) NOT NULL,
	`product_id` int(4),
	`quantity` int(4),
	`total_price` int(10),
	`price` int(10),
	`date` date,
	`month_purchased` varchar(40),
	PRIMARY KEY( `purchase_id` ),
	FOREIGN KEY (user_id) REFERENCES user(id)
);
CREATE TABLE orders
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description VARCHAR(100),
    user_id INT NOT NULL,
    CONSTRAINT orders_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE UNIQUE INDEX orders_id_uindex ON orders (id);

INSERT INTO `user` VALUES (1, 'Dave', 'Mann', 95),(2, 'Michael', 'McCarthy', 92),(3, 'Brian', 'Micheals', 67),(4, 'Tim', 'Meyer' , 87);


insert into `purchases` values (1, 1, 2, 3, 60, 20, '2018-16-2', 'February'), (2, 1, 1, 3, 45, 15, '2018-29-1', 'December'), (3, 3, 2, 1, 20, 20, '2018-12-2', 'February');
=======
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
>>>>>>> RollbackBranch
