CREATE SCHEMA PROJECT;

CREATE TABLE PROJECT.securities (
                                    id int NOT NULL AUTO_INCREMENT,
                                    full_name varchar(150) NOT NULL ,
                                    gender varchar(5),
                                    birth_date DATE,
                                    department_id int,
                                    PRIMARY KEY (id)
);
CREATE TABLE PROJECT.departments(
                                    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR (10) NOT NULL
);
CREATE TABLE PROJECT.documents(
                                  security_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                                  health_permit DATE,
                                  knowledge_permit DATE,
                                  weapon_permit DATE
);
drop table PROJECT.securities;

drop table PROJECT.departments;

drop table PROJECT.documents;