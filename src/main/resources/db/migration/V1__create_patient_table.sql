create table if not exists  patient
(
    id         int         not null auto_increment,
    first_name varchar(50) not null,
    last_name  varchar(50) not null,
    email      varchar(50) not null,
    gender     ENUM ('M','F'),
    birthdate  varchar(10),
    created_at timestamp not null,
    primary key (id)
);
