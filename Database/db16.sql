USE db16;
SELECT*FROM emp;
SELECT DISTINCT(empcity) FROM emp;
SELECT empid,empname,empcity FROM emp;
CREATE TABLE empcopy AS(SELECT empid ,empname ,empcity FROM emp);
SELECT*FROM empcopy;
CREATE VIEW empview AS(SELECT empid,empname,empcity FROM emp);
SELECT * FROM empview;
UPDATE empcopy SET empcity ='pthampur'WHERE empid=103;
SELECT*FROM empcopy;
SELECT*FROM emp;
UPDATE empview SET empcity ='devas'WHERE empid=103;
SELECT*FROM empview;
SELECT*FROM emp;
DROP TABLE empcopy;
SHOW TABLES;
DROP VIEW empview;
SHOW TABLES;

ALTER TABLE emp ADD COLUMN mailid INT AFTER empname;
ALTER TABLE emp ADD COLUMN contat VARCHAR(13) FIRST;
SELECT*FROM emp;
ALTER TABLE emp CHANGE mailid empmailid VARCHAR (35);
ALTER TABLE emp CHANGE contat empcontact VARCHAR(13);
SELECT*FROM emp;
ALTER TABLE emp DROP COLUMN empmailid,DROP COLUMN empcontact;
SELECT*FROM emp;

