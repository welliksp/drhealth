create table person
(
    id         int         not null auto_increment,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    email      varchar(50) not null,
    gender     varchar(2),
    birthdate  varchar(10),
    created_at timestamp,
    primary key (id)
);
