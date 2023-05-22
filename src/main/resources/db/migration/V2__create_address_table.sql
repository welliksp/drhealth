create table address
(
    id  integer not null auto_increment,
    street     varchar(50) not null,
    number     long        not null,
    state      varchar(20) not null,
    city       varchar(50) not null,
    zipcode    varchar(8)  not null,
    complement varchar(100),
    created_at timestamp,
    primary key (id)
);
