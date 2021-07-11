create schema `shopcart-cart`;

use `shopcart-cart`;

create table Cart (
	id int primary key,
	customer_id int not null,
	product_id int not null
);


insert into Cart values(1, 1, 1);
insert into Cart values(2, 1, 3);
commit;
drop table Cart;
select * from Cart;