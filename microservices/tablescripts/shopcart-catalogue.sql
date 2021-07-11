create schema `shopcart-catalogue`;

use `shopcart-catalogue`;

create table Product (
	id int primary key,
	name varchar(100) not null,
	category varchar(100),
	discount double,
	price double not null
);


insert into Product values(1, 'iPhone', 'Electronics', 0, 70000);
insert into Product values(2, 'Pixel 6', 'Electronics', 0, 60000);
insert into Product values(3, 'MacBook Air M2', 'Electronics', 0, 90000);
commit;
