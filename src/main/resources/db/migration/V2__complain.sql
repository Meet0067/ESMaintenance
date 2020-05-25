

CREATE SEQUENCE complain_seq;

CREATE TABLE complain (
  time timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  complain_no int NOT NULL DEFAULT NEXTVAL ('complain_seq'),
  userid varchar(20) DEFAULT NULL,
  name varchar(40) DEFAULT NULL,
  flate_no varchar(20) DEFAULT NULL,
  email varchar(20) DEFAULT NULL,
  phone_no varchar(20) DEFAULT NULL,
  regarding varchar(200) DEFAULT NULL,
  complain varchar(300) DEFAULT NULL,
  status varchar(20) DEFAULT 'pending',
  comment varchar(300) DEFAULT NULL,
  PRIMARY KEY (complain_no)
)   ;

ALTER SEQUENCE complain_seq RESTART WITH 12;
