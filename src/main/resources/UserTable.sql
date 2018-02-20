drop table if exists 'user';
create table user (id smallint unsigned not null auto_increment, first_name varchar(20), last_name varchar(20), birth_year int(4), constraint primary_key primary key (id) );
INSERT INTO `user` VALUES (1, 'Dave', 'Mann', 95),(2, 'Michael', 'McCarthy', 92),(3, 'Brian', 'Micheals', 67),(4, 'Tim', 'Meyer' , 87);