CREATE DATABASE  IF NOT EXISTS `vedantu`;
USE `vedantu`;
DROP TABLE IF EXISTS `orders`;
DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `phone_no` varchar(100),
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

INSERT INTO account(id,name, email,phone_no, password) VALUES
(1,'shivansh', 'xyz@gmail.com','8989022220', 'xyz@123'),
(2,'shivam', 'abc@gmail.com','8989022220', 'abc@123');


CREATE TABLE `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `quantity` int(11),
  `available` int(1),
  PRIMARY KEY (`id`)
);

INSERT INTO inventory(id,product, description,quantity, available) VALUES
(1,'product 1', 'product 1 .........description',10, 1),
(2,'product 2', 'product 2 .........description',10, 1);


CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11),
  `account_id` int(11),
  PRIMARY KEY (`id`),
  foreign key (`product_id`) references `inventory` (`id`),
  foreign key (`account_id`) references `account` (`id`)
);



select * from account;
insert into orders (account_id, product_id) values (1, 1);
select * from orders;