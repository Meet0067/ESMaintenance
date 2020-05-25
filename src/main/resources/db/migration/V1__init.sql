CREATE SEQUENCE users_seq;

CREATE TABLE users (
  userid int NOT NULL DEFAULT NEXTVAL ('users_seq'),
  fname varchar(20) DEFAULT NULL,
  mname varchar(20) DEFAULT NULL,
  lname varchar(20) DEFAULT NULL,
  phone_no varchar(12) DEFAULT NULL,
  flate_no varchar(20) DEFAULT NULL,
  user_type varchar(20) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  password varchar(20) DEFAULT NULL,
  isactive varchar(5) DEFAULT 'false',
  status varchar(20) DEFAULT 'pending',
  comment varchar(100) DEFAULT NULL,
  date timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (userid)
)   ;

ALTER SEQUENCE users_seq RESTART WITH 8;










