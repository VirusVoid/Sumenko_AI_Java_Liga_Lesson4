CREATE TABLE IF NOT EXISTS ORDERS
(
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    price INTEGER
);


CREATE TABLE IF NOT EXISTS CUSTOMERS
(
    CUSTOMER_ID SERIAL PRIMARY KEY,
    ORDER_ID INTEGER,
    NAME VARCHAR(255),
    EMAILADDRESS VARCHAR(255)
);

ALTER TABLE CUSTOMERS
ADD CONSTRAINT order_id_fk_constraint
FOREIGN KEY(ORDER_ID) REFERENCES ORDERS(ORDER_ID)
ON UPDATE CASCADE ON DELETE CASCADE;