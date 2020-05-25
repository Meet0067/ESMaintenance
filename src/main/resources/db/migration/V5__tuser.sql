CREATE TABLE tuser (
  fname varchar(20) DEFAULT NULL,
  mname varchar(20) DEFAULT NULL,
  lname varchar(20) DEFAULT NULL,
  phone_no varchar(12) DEFAULT NULL,
  flate_no varchar(20) NOT NULL,
  user_type varchar(20) DEFAULT NULL,
  email varchar(20) DEFAULT NULL,
  password varchar(20) DEFAULT NULL,
  PRIMARY KEY (flate_no)
)  ;
