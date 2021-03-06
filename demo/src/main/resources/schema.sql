--Покупатель
CREATE TABLE `CUSTOMER`
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(255) NOT NULL,
    EMAIL_ADDRESS VARCHAR(255) NOT NULL
);

--Заказ
CREATE TABLE `ORDER`
(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CUSTOMER_ID INTEGER NOT NULL REFERENCES CUSTOMER(ID),
    NAME VARCHAR(255) NOT NULL,
    PRICE INTEGER NOT NULL
);

--Добавление покупателей
INSERT INTO CUSTOMER(ID, NAME, EMAIL_ADDRESS) VALUES(1, 'JOHN', 'JOHN@MAIL.RU');
INSERT INTO CUSTOMER(ID, NAME, EMAIL_ADDRESS) VALUES(2, 'MIKE', 'MIKE@MAIL.RU');