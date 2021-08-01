create database book;
use book;

create table book(
	id int(10) not null auto_increment primary key,
    title varchar(255) not null,
    author varchar(255) not null,
    category varchar(255) not null
);

insert into book (title,author,category) values ("S1","A","Action and Adventure");
insert into book (title,author,category) values ("S2","B","Classic");
insert into book (title,author,category) values ("S3","C","Comic book or graphic novel");
insert into book (title,author,category) values ("S4","D","Detective and mystery");
insert into book (title,author,category) values ("S5","E","Fantasy");
insert into book (title,author,category) values ("S6","F","Horror");

create table user(
	id int(10) not null auto_increment primary key,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    email varchar(255) not null,
    dob date not null,
    age int(10) not null
);

create table ref(
	book_id int(10) not null,
    user_id int(10) not null,
	foreign key (user_id) references user(id),
    foreign key (book_id) references book(id)
);
insert into user (firstname,lastname,email,dob,age) values("Le","Lam","letunglam001@gmail.com","1999-11-04",22);
insert into user (firstname,lastname,email,dob,age) values("Lam","Le","letunglam002@gmail.com","1999-11-05",22);
select *from user;
select *from book;
select *from ref;
select *from book b ,user u where b.user_id = u.id group by b.id;

insert into ref values (1,1);
insert into ref values (2,1);
insert into ref values (3,1);
insert into ref values (4,1);

Select * from book as b
Join ref as r on r.book_id = b.id
Where r.user_id = 1



