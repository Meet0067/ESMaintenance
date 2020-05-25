CREATE SEQUENCE committee_seq;

CREATE TABLE committee (
  memberId int NOT NULL DEFAULT NEXTVAL ('committee_seq'),
  name varchar(70) DEFAULT NULL,
  post varchar(20) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  mobileNo varchar(15) DEFAULT NULL,
  houseNo varchar(10) DEFAULT NULL,
  PRIMARY KEY (memberId)
)   ;

ALTER SEQUENCE committee_seq RESTART WITH 2;

