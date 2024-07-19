create or replace table product (
  id int(11) not null auto_increment,
  name varchar(100)  not null,
  price decimal(15,2)  not null,
  description varchar(500),
  primary key(id)
);

insert into product values(
null, "펜", 2000, "검은 핑크"
);
