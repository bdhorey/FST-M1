
-- Update the grade score of salesmen from Pune to 200.
UPDATE salesman SET grade=200 WHERE salesman_city='Pune';

-- Update the grade score of Ram Ram to 300.
UPDATE salesman SET grade=300 WHERE salesman_name='Ram Ram';

-- Update the name Paul Adam to Krishna.
UPDATE salesman SET salesman_name='Krishna' WHERE salesman_name='Paul Adam';

-- Display modified data
SELECT * FROM salesman;