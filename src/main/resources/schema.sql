DROP TABLE IF EXISTS USERPATIENT;
DROP TABLE IF EXISTS ADMINUSER;
CREATE TABLE USERPATIENT(ID INT PRIMARY KEY, NAME VARCHAR(50), PHONENO VARCHAR(20), PINCODE VARCHAR(7), RESULT VARCHAR(10));
CREATE TABLE ADMINUSER(ADMINID INT PRIMARY KEY, NAME VARCHAR(50), PHONENO VARCHAR(20), PINCODE VARCHAR(7));