create table if not exists phone
(
    id         int not null auto_increment,
    ddi        int not null,
    ddd        int not null,
    prefix     int not null,
    suffix     int not null,
    country    varchar(100),
    created_at timestamp not null,
    primary key (id)
);
