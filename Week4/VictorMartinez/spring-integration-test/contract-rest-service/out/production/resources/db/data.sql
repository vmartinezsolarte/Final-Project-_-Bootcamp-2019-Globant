SET MODE MYSQL
DROP TABLE IF EXISTS CustomerEntity;

CREATE TABLE CustomerEntity(
    id INT,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    user_name VARCHAR(250) NOT NULL,
    user_password VARCHAR(250) NOT NULL
);

INSERT INTO CustomerEntity (first_name, last_name, user_name, user_password) VALUES ('Aliko', 'Dangote', 'AliDan', '1234')
INSERT INTO CustomerEntity (first_name, last_name, user_name, user_password) VALUES ('Bill', 'Gates', 'entrepreneur','1234')
INSERT INTO CustomerEntity (first_name, last_name, user_name, user_password) VALUES ('Folrunsho', 'Alakija', 'mate', '1234')


