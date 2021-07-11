create schema `shopcart-auth`;
use `shopcart-auth`;

create table User (
	id bigint primary key,
    username varchar(100) unique not null,
    password varchar(100) not null,
    name varchar(200) not null,
    mobile bigint unique not null,
    email varchar(100) unique not null,
    address varchar(500)
);

insert into User values(1, 'axayjha', 'password', 'Akshay Anand', 7992383981, 'akshayjha@live.in', 'Saharsa');
insert into User values(2, 'cloudtail', 'password', 'Cloudtail Pvt Ltd', 9876543210, 'help@shopcart.com', 'Pune');

commit;