SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE reservation;
TRUNCATE TABLE reservation_time;
TRUNCATE TABLE theme;
TRUNCATE TABLE member;
TRUNCATE TABLE reservation_detail;

ALTER TABLE reservation ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE reservation_time ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE theme ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE member ALTER COLUMN ID RESTART WITH 1;
ALTER TABLE reservation_detail ALTER COLUMN ID RESTART WITH 1;

SET REFERENTIAL_INTEGRITY TRUE;

INSERT INTO member(name, email, password, role) VALUES('admin', 'admin@email.com', 'admin123', 'ADMIN');
INSERT INTO member(name, email, password, role) VALUES('guest', 'guest@email.com', 'guest123', 'GUEST');