use demo;
select * from user;
insert into user values(2, "test", "newpassword");
insert into user values(3, "anand", "$2y$10$Ag3WwwgUUO/qc2k7yqh0x.ii1uwpriMEGhLK.IkRv90GLVmYH2zh. ");
insert into user values(4, "test1", "$2a$10$GqXKbofs/5xKWbsGDAJFIONAL9eNzK15y4xGIJ56ysx6GVDK5SVRe");
commit;

insert into user values(6, "test3", "$2a$10$53bSezqznvF.usPs4F1eS.QcDTkOBT9SQsYO1.EoQ2zmZDZj.G1G6");
