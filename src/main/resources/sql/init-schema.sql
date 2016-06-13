DROP TABLE IF EXISTS operation;
DROP TABLE IF EXISTS card;
DROP TABLE IF EXISTS operation_type;

CREATE TABLE card (
  id          INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  card_number BIGINT(16)                     UNIQUE NOT NULL,
  pin_code    SMALLINT(4)                    NOT NULL,
  balance     DECIMAL(15, 2)  UNSIGNED,
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
