CREATE DATABASE atm;
USE atm;

CREATE TABLE card (
  id          INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  card_number BIGINT(16)                     UNIQUE NOT NULL,
  pin_code    SMALLINT(4)                    NOT NULL,
  balance     DECIMAL(15, 2),
  attempt     TINYINT,
  blocked     BOOLEAN
);

CREATE TABLE operation_type (
  id   INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(30)                    NOT NULL
);

CREATE TABLE operation (
  id                INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  card_id           INT(6) UNSIGNED                NOT NULL,
  operation_type_id INT(6) UNSIGNED                NOT NULL,
  operation_time    TIMESTAMP(4)                   NOT NULL,
  amount            DECIMAL(15, 2),
  FOREIGN KEY (card_id)           REFERENCES card(id),
  FOREIGN KEY (operation_type_id) REFERENCES operation_type(id)
);

INSERT INTO card (card_number, pin_code, balance, attempt, blocked) VALUES
  (1234567890123456, 1234, 500.00, 1, 0),
  (6543210987654321, 4321, 300.00, 2, 0),
  (1234567891123456, 1122, 100.00, 3, 0);

INSERT INTO operation_type (type) VALUES
  ('WITHDRAW'), ('INFO');

INSERT INTO operation (card_id, operation_type_id, operation_time, amount) VALUES
  (1, 1, CURTIME(), 100.00),
  (2, 2, CURDATE(), NULL),
  (3, 2, curdate(), NULL);