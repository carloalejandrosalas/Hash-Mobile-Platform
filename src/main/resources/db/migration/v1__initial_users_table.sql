create table users
(
    id            bigint not null auto_increment
        primary key,
    first_name    varchar(100)              null,
    last_name     varchar(100)              null,
    address       text                      null,
    email         varchar(200)              null,
    password_hash text                      null,
    role          varchar(50)               null,
    is_active     tinyint   default 1       null,
    created_at    timestamp default (now()) null,
    updated_at    datetime                  null,
    deleted_at    datetime                  null
);

alter table users
    add constraint users_pk_2
        unique (email);
