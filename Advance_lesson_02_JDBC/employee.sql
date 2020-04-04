DROP DATABASE IF EXISTS employee;
CREATE DATABASE employee CHAR SET utf8;
USE employee;

CREATE TABLE employee(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(70),
last_name VARCHAR(70),
position VARCHAR(70),
salary INT(11) 
);

CREATE TABLE user(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(255) NOT NULL,
first_name VARCHAR(70) NOT NULL,
last_name VARCHAR(70) NOT NULL,
role VARCHAR(255) 
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
('Dima','Nevskiy', 'boss', 15000),
('Andrey','Duda', 'designer', 12000),
('Masha','Nuw', 'accountant', 9000),
('Viktoria','Nuw', 'secretary', 6000);