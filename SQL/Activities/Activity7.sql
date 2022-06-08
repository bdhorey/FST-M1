
-- Total amount of orders
Select sum(purchase_amount) from orders;

--Avg Amount of order
Select avg(purchase_amount) from orders;

--Max
Select max(purchase_amount) from orders;

--Min
Select min(purchase_amount) from orders;

-- find the number of salesmen listed in the table
select COUNT(distinct salesman_id) AS "Total count" from orders;