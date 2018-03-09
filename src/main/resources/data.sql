INSERT INTO CATEGORIES (ID, NAME, DESCRIPTION, DISABLED, DISP_ORDER) VALUES
  (1, 'Cat1', 'Cat1', FALSE, 1);

INSERT INTO PRODUCTS (ID, CAT_ID, COD, NAME, DESCRIPTION, PRICE) VALUES
  (1,1,'P1001','Product1','Product1','100.00'),
  (2,1,'P1002','Product2','Product2','200.00'),
  (3,1,'P1003','Product3','Product3','300.00');

INSERT INTO CUSTOMERS (ID, EMAIL, FIRSTNAME, LASTNAME, PASSWORD) VALUES
  (1, 'leo@gmail.com', 'leonardo', 'emanuel', '$2a$10$hKDVYxLefVHV/vtuPhWD3OigtRyOykRLDdUAp80Z1crSoS1lFqaFS');

INSERT INTO ADDRESSES (ID, ADDRESS_LINE1, ADDRESS_LINE2, CITY, COUNTRY, STATE, ZIP_CODE) VALUES
  (1, 'Cordoba', 'Cordoba', 'Cordoba', 'Cordoba', 'Argentina', '5001');

INSERT INTO PAYMENTS (ID, AMOUNT) VALUES
  (1, 200.00);

INSERT INTO ORDERS (ID, ORDER_NUMBER, STATUS, BILLING_ADDR_ID, CUST_ID, DELIVERY_ADDR_ID, PAYMENT_ID) VALUES
  (1, '123456789', 'NEW', 1, 1, 1, 1);

INSERT INTO ORDER_ITEMS (ID, PRICE, QUANTITY, ORDER_ID, PRODUCT_ID) VALUES
  (1, 200.0, 2, 1, 1);
