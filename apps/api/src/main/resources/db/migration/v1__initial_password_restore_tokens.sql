create table password_restore_tokens
(
    id         bigint auto_increment
        primary key,
    user_id    bigint                              null,
    token      text                                null,
    used       tinyint   default 0                 null,
    expires_at datetime                            null,
    used_at    datetime                            null,
    created_at timestamp default CURRENT_TIMESTAMP null
);

alter table password_restore_tokens
    add constraint password_restore_tokens_users_id_fk
        foreign key (user_id) references users (id);

