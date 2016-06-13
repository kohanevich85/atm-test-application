INSERT INTO card (card_number, pin_code, balance, attempt, blocked) VALUES
  (1234567890123456, 1234, 500.00, 0, 0),
  (6543210987654321, 4321, 300.00, 0, 0),
  (2222222222222222, 1122, 100.00, 0, 0);

INSERT INTO operation_type (type) VALUES
  ('WITHDRAW'), ('INFO');

INSERT INTO operation (card_id, operation_type_id, operation_time, amount) VALUES
  (1, 1, CURTIME(), 100.00),
  (2, 2, CURDATE(), NULL),
  (3, 2, curdate(), NULL);