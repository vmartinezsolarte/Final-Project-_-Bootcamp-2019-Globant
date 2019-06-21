DROP TABLE IF EXISTS loginData;

CREATE TABLE loginData{
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    user_name VARCHAR(250) NOT NULL,
    user_password VARCHAR(250) NOT NULL
};

INSERT INTO loginData (first_name, last_name, user_name, user_password)VALUES
  ('Aliko', 'Dangote', 'AliDan', '1234'),
  ('Bill', 'Gates', 'entrepreneur','1234'),
  ('Folrunsho', 'Alakija', 'mate', '1234');


