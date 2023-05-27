create table if not exists doctor
(
    id                    int          not null auto_increment,
    name                  varchar(100) not null,
    crm                   varchar(20)  not null,
    crm_status            ENUM ('REGULAR', 'IRREGULAR'),
    specialty             varchar(50)  not null,
    registration          varchar(100) not null,
    registration_date     timestamp,
    first_registration_UF timestamp,
    created_at            timestamp not null,
    primary key (id)
);
