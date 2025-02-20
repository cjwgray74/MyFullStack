CREATE TABLE employee (
                          id int NOT NULL AUTO_INCREMENT,
                          user_id VARCHAR(225) DEFAULT NULL,
                          first_name VARCHAR(50) DEFAULT NULL,
                          last_name VARCHAR(50) DEFAULT NULL,
                          address VARCHAR(50) DEFAULT NULL,
                          state VARCHAR(50) DEFAULT NULL,
                          zip VARCHAR(50) DEFAULT NULL,
                          cell_phone VARCHAR(50) DEFAULT NULL,
                          home_phone VARCHAR(50) DEFAULT NULL,
                          email VARCHAR(50) DEFAULT NULL,
                          created_at date NOT NULL,
                          created_by VARCHAR(50) NOT NULL,
                          updated_at DATE DEFAULT NULL,
                          updated_by VARCHAR(50) DEFAULT NULL,
                          UNIQUE(user_id, email),
                          PRIMARY KEY (id)

)ENGINE=InnoDB DEFAULT CHARACTER SET latin1;