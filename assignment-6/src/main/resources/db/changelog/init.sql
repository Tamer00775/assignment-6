create table book(
    id bigint generated by default as identity primary key,
    author varchar(255)  not null,
    name varchar(255) not null,
    price int
);

insert into book(author, name, price) VALUES ('Author 1', 'Book 1', 1000);
insert into book(author, name, price) VALUES ('Author 2', 'Book 2', 2000);
insert into book(author, name, price) VALUES ('Author 3', 'Book 3', 3000);
insert into book(author, name, price) VALUES ('Author 4', 'Book 4', 4000);