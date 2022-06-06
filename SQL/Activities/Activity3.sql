	
CREATE TABLE salesman (
    salesman_id int,
    salesman_name varchar2(32),
    salesman_city varchar2(32),
    commission int
);

Desc salesman;

-- Insert one row
INSERT INTO salesman VALUES(500, 'Bhushan Dhorey', 'Pune', 10);

-- Insert multiple rows at once
INSERT ALL
    INTO salesman VALUES(5005, 'Ram Ram', 'Hindustan', 99)
    INTO salesman VALUES(5006, 'McLyon', 'Paris', 14)
    INTO salesman VALUES(5007, 'Paul Adam', 'Rome', 13)
    INTO salesman VALUES(5003, 'Lauson Hen', 'San Jose', 12)
SELECT 1 FROM DUAL;

-- View data from all columns
SELECT * FROM salesman;

-- Show data from the salesman_id and city columns
SELECT salesman_id, salesman_city FROM salesman;

-- Show data of salesman from Pune
SELECT * FROM salesman WHERE salesman_city='Pune';

-- Show salesman_id and commission of Bhushan Dhorey
SELECT salesman_id, commission FROM salesman WHERE salesman_name='Bhushan Dhorey';