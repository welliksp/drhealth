create table if not exists specialty
(
    id         int         not null auto_increment,
    name       varchar(50) not null,
    created_at timestamp   not null,
    primary key (id)
);
