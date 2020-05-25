CREATE TABLE payment_m (
  fundid int DEFAULT NULL,
  userid int DEFAULT NULL,
  paymentid varchar(20) DEFAULT NULL,
  name varchar(30) DEFAULT NULL,
  phone_no varchar(15) DEFAULT NULL,
  flate_no varchar(10) DEFAULT NULL,
  email varchar(30) DEFAULT NULL,
  status varchar(8) DEFAULT 'due',
  amount int DEFAULT NULL,
  due_amount int DEFAULT '0',
  isfine int DEFAULT '0',
  paymentdate varchar(20) DEFAULT NULL,
  auth_code varchar(20) DEFAULT NULL
)  ;



