DROP DATABASE IF EXISTS spring_security_demo_bcrypt;

CREATE DATABASE IF NOT EXISTS spring_security_demo_bcrypt;
USE spring_security_demo_bcrypt;

--
-- Table structure for table users
--

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id       bigint      NOT NULL,
    name     varchar(50) NOT NULL,
    password char(68)    NOT NULL,
    enabled  tinyint(1)  NOT NULL,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Dumping data for table users
--
-- NOTE: The passwords are encrypted using BCrypt
--

INSERT INTO users
VALUES (1, 'john', '{bcrypt}$2y$12$fQC4O3QoEdaAXuSzRdlP9.ZcFXjzyceRryQQQHmGZif4McWQAXrnu', 1),
       (2, 'mary', '{bcrypt}$2y$12$fQC4O3QoEdaAXuSzRdlP9.ZcFXjzyceRryQQQHmGZif4McWQAXrnu', 1),
       (3, 'susan', '{bcrypt}$2y$12$fQC4O3QoEdaAXuSzRdlP9.ZcFXjzyceRryQQQHmGZif4McWQAXrnu', 1);


--
-- Table structure for table authorities
--

DROP TABLE IF EXISTS authorities;
CREATE TABLE authorities
(
    id        bigint      NOT NULL,
    user_id   bigint NOT NULL,
    authority varchar(50) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id)
        REFERENCES users (id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

--
-- Dumping data for table authorities
--

INSERT INTO authorities
VALUES (0, 1, 'ROLE_EMPLOYEE'),
       (1, 2, 'ROLE_EMPLOYEE'),
       (2, 2, 'ROLE_MANAGER'),
       (3, 3, 'ROLE_EMPLOYEE'),
       (4, 3, 'ROLE_ADMIN');


