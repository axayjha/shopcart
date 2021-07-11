create schema `shopcart-order`;

use `shopcart-order`;

create table Purchase (
	id int primary key,
    customer_id int not null,
    product_id int not null,
    order_date Date not null,
    price double not null,
    discount double,
    seller_id int
);

insert into Purchase values (1, 1, 3, DATE(sysdate()), 90000, 0, 1); 
delete from Purchase where id=1;

select * from Purchase;
