CREATE SCHEMA PROJECT;

CREATE TABLE IF NOT EXISTS PROJECT.securities (
                                    id int NOT NULL AUTO_INCREMENT,
                                    full_name varchar(150) NOT NULL ,
                                    gender varchar(5),
                                    birth_date DATE,
                                    department_id int,
                                    PRIMARY KEY (id)
);
CREATE TABLE IF NOT EXISTS PROJECT.departments(
                                    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR (10) NOT NULL
);
CREATE TABLE IF NOT EXISTS PROJECT.documents(
                                  security_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
                                  health_permit DATE,
                                  knowledge_permit DATE,
                                  weapon_permit DATE
);

CREATE TABLE IF NOT EXISTS PROJECT.users(
    id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    username VARCHAR(50)NOT NULL UNIQUE ,
    password VARCHAR(128) DEFAULT '{noop}123',
    role VARCHAR(10)
);
drop table PROJECT.users;

drop table PROJECT.securities;

drop table PROJECT.departments;

drop table PROJECT.documents;