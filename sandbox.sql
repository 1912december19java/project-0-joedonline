create table customers (
	customer_id SERIAL PRIMARY KEY,
	firstname VARCHAR(50),
	lastname VARCHAR(50),
	city VARCHAR(50),
	state VARCHAR(50),
	balance NUMERIC (12, 2)
);

DROP TABLE customers

SELECT * FROM customers;

SELECT count(*) FROM customers;

INSERT INTO customers (customer_id, firstname, lastname, city, state, balance)
	VALUES (21, 'Mickey', 'Mouse', 'Orlando', 'Florida', 111.11);

INSERT INTO customers (customer_id, firstname, lastname, city, state, balance)
	VALUES (22, 'Minnie', 'Mouse', 'Orlando', 'Florida', 222.22);

INSERT INTO customers (customer_id, firstname, lastname, city, state, balance)
	VALUES (23, 'Donald', 'Duck', 'Orlando', 'Florida', 333.33);

DELETE FROM customers WHERE customer_id = 23;

UPDATE customers SET firstname = 'Minnie' WHERE customer_id = 21;

SELECT * FROM customers;

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
