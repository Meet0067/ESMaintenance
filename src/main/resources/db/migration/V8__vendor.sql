




CREATE SEQUENCE vendor_seq;

CREATE TABLE vendor (
  vendorId int NOT NULL DEFAULT NEXTVAL ('vendor_seq'),
  name varchar(70) DEFAULT NULL,
  profession varchar(20) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  mobileNo varchar(15) DEFAULT NULL,
  houseNo varchar(10) DEFAULT NULL,
  PRIMARY KEY (vendorId)
)   ;

ALTER SEQUENCE vendor_seq RESTART WITH 2;

