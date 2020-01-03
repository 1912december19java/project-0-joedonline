-- CUSTOMERS
create table customers (
	customer_id VARCHAR (9) UNIQUE PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50)
);

-- create table customers (
	--customer_id INTEGER NOT NULL PRIMARY KEY,
	--firstname VARCHAR(50) NOT NULL,
	--lastname VARCHAR(50) NOT NULL,
	--city VARCHAR(50) NOT NULL,
	--state VARCHAR(50) NOT NULL,
	--balance NUMERIC (12, 2) NOT NULL
--);

DROP TABLE customers;

SELECT * FROM customers;

SELECT count(*) FROM customers;

INSERT INTO customers (customer_id, firstname, lastname, city, state)
	VALUES ('CID-10001', 'Mickey', 'Mouse', 'Orlando', 'Florida');

INSERT INTO customers (customer_id, firstname, lastname, city, state)
	VALUES ('CID-10002', 'Minnie', 'Mouse', 'Orlando', 'Florida');

INSERT INTO customers (customer_id, firstname, lastname, city, state)
	VALUES ('CID-10003', 'Donald', 'Duck', 'Orlando', 'Florida');

DELETE FROM customers WHERE customer_id = 23;

UPDATE customers SET firstname = 'Minnie' WHERE customer_id = 21;

UPDATE customers SET balance = 999.33 WHERE customer_id = 21;

SELECT customer_id FROM customers WHERE firstname = 'Mickey' AND lastname = 'Mouse' AND city = 'Orlando' AND state = 'Florida';

SELECT * FROM customers;


-- ACCOUNTS
create table accounts (
	account_id VARCHAR (10),
	account_type VARCHAR(50),
	balance NUMERIC (12, 2),
	customer_id VARCHAR (9)
);

INSERT INTO accounts (account_id, account_type, balance, customer_id)  VALUES ('ACCT-10001', 'checking', 200.02, 'CID-10001');
INSERT INTO accounts (account_id, account_type, balance, customer_id)  VALUES ('ACCT-10002', 'savings', 2255.26, 'CID-10001');
INSERT INTO accounts (account_id, account_type, balance, customer_id)  VALUES ('ACCT-90111', 'moneymarket', 951065.22, 'CID-10001');
DELETE FROM accounts WHERE customer_id = 'CID-10000';

UPDATE accounts SET balance = 500.33 WHERE account_id = 'ACCT-10001';
UPDATE accounts SET balance = 970765.22 WHERE account_id = 'ACCT-90111';

UPDATE accounts SET balance = 500.33 WHERE customer_id = 'CID-10001';
UPDATE accounts SET balance = 888.88 WHERE customer_id = 'CID-10002';

SELECT * FROM accounts WHERE account_id = 'ACCT-88888';

DROP TABLE accounts;

SELECT * FROM accounts;


-- USERS
create table users (
	username VARCHAR(50),
	pw VARCHAR(128),
	emailaddress VARCHAR(256),
	customer_id VARCHAR (9)
);

DROP TABLE users;

INSERT INTO users (username, pw, emailaddress, customer_id) VALUES ('mickeymouse', 'password', 'mickey.mouse@disneyemail.fake', 'CID-10001');

SELECT * FROM users WHERE customer_id = 'CID-10002';

DELETE FROM users WHERE customer_id = 'CID-10001';

SELECT * FROM users;


-- TRANSACTIONS
create table transactions (
	transaction_id VARCHAR (8) NOT NULL PRIMARY KEY,
	account_type VARCHAR (32) NOT NULL,
	transaction_date DATE NOT NULL,
	transaction_time TIME NOT NULL,
	transaction_amount NUMERIC (9, 2),
	customer_id VARCHAR (9) NOT NULL
);

INSERT INTO transactions (transaction_id, account_type, transaction_date, transaction_time, transaction_amount, customer_id)
	VALUES ('TR-52111', 'checking', '2019-12-24', '15:31:22', 200.00, 'CID-10001');
INSERT INTO transactions (transaction_id, account_type, transaction_date, transaction_time, transaction_amount, customer_id)
	VALUES ('TR-52112', 'checking', '2019-12-25', '19:12:36', 200.00, 'CID-10001');
INSERT INTO transactions (transaction_id, account_type, transaction_date, transaction_time, transaction_amount, customer_id)
	VALUES ('TR-52113', 'checking', '2019-12-26', '19:38:48', 200.00, 'CID-10002');

SELECT * FROM transactions WHERE customer_id = 'CID-10001';

DELETE FROM transactions WHERE transaction_id = 'TR-52113';

DROP TABLE transactions;

SELECT * FROM transactions;


-- GENERATED DATA
insert into customers (customer_id, firstname, lastname, city, state, balance) values (1, 'Alvy', 'Normand', 'San Antonio', 'Texas', 500.99);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (2, 'Ronni', 'Swatten', 'Arlington', 'Texas', 120.50);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (3, 'Nannette', 'Inchley', 'Vero Beach', 'Florida', 55.00);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (4, 'Buiron', 'Driscoll', 'Philadelphia', 'Pennsylvania', 884.23);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (5, 'Lance', 'Gerhartz', 'Everett', 'Washington', 404.33);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (6, 'Margie', 'Pendered', 'Santa Barbara', 'California', 980.80);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (7, 'Davis', 'Hughson', 'Topeka', 'Kansas', 998.01);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (8, 'Arlette', 'Duffield', 'Fairbanks', 'Alaska', 100.53);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (9, 'Uta', 'Volkes', 'Hot Springs National Park', 'Arkansas', 104.36);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (10, 'Woodman', 'Duce', 'Reno', 'Nevada', 804.44);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (11, 'Rikki', 'O''Dunneen', 'Madison', 'Wisconsin', 408.51);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (12, 'Port', 'Digman', 'Morgantown', 'West Virginia', 502.18);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (13, 'Hazlett', 'Oene', 'San Diego', 'California', 869.12);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (14, 'Sherlocke', 'Blazi', 'Mountain View', 'California', 150.16);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (15, 'Glynnis', 'Thurstance', 'Modesto', 'California', 521.80);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (16, 'Gale', 'Weerdenburg', 'Springfield', 'Massachusetts', 50.28);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (17, 'Lucien', 'Pomphrett', 'San Bernardino', 'California', 10.19);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (18, 'Beck', 'McGaraghan', 'Albany', 'New York', 17.76);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (19, 'Alysia', 'Treadgall', 'Sacramento', 'California', 121.12);
insert into customers (customer_id, firstname, lastname, city, state, balance) values (20, 'Oren', 'Walton', 'Pittsburgh', 'Pennsylvania', 648.47);
