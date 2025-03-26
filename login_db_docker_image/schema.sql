CREATE TABLE `user` (
                        `email` varchar(50) NOT NULL,
                        `password` char(68) NOT NULL,
                        PRIMARY KEY (`email`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE authorities (
                             id INT AUTO_INCREMENT,
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             PRIMARY KEY (id),
                             CONSTRAINT fk_authorities_username FOREIGN KEY (username) REFERENCES user (email) ON DELETE CASCADE

) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE UNIQUE INDEX uk_users_username ON user (email);

CREATE INDEX idx_authorities_username ON authorities (username);

CREATE INDEX idx_authorities_authority ON authorities (authority);