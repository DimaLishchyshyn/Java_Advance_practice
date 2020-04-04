SET GLOBAL time_zone = '+2:00';
DROP DATABASE IF EXISTS employee;
CREATE DATABASE employee CHAR SET utf8;
USE employee;

CREATE TABLE employee(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(70),
last_name VARCHAR(70),
position VARCHAR(70),
salary VARCHAR(70) 
);

CREATE TABLE user(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(255) NOT NULL,
first_name VARCHAR(70) NOT NULL,
last_name VARCHAR(70) NOT NULL,
role VARCHAR(255) NOT NULL,
password VARCHAR(255) NOT NULL
);

CREATE TABLE bucket(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
user_id INT(70),
employee_id INT(70),
purchase_date TIMESTAMP
);

ALTER TABLE bucket ADD FOREIGN KEY (user_id) REFERENCES user(id);
ALTER TABLE bucket ADD FOREIGN KEY (employee_id) REFERENCES employee(id);
 
INSERT INTO employee(first_name, last_name, position, salary) value 
('Dima','Nevskiy', 'boss', '15000'),
('Andrey','Duda', 'designer', '12000'),
('Masha','Rasputina', 'accountant', '9000'),
('Viktoria','Alexandrova', 'secretary', '6000');