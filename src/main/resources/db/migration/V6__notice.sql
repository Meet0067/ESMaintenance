

CREATE SEQUENCE notice_seq;

CREATE TABLE notice (
  date timestamp(0) DEFAULT CURRENT_TIMESTAMP,
  notice_id int NOT NULL DEFAULT NEXTVAL ('notice_seq'),
  heading varchar(200) DEFAULT NULL,
  notice varchar(500) DEFAULT NULL,
  PRIMARY KEY (notice_id)
)   ;

ALTER SEQUENCE notice_seq RESTART WITH 17;

