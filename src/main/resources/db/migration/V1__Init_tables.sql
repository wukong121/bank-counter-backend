create table account
(
    id         bigint auto_increment
        primary key,
    balance    DECIMAL   default 0     not null,
    currency   varchar(8)              null,
    state      int                     not null default 0,
    created_at  timestamp    not null default current_timestamp,
    modified_at timestamp    not null default current_timestamp on update current_timestamp
);

create table transaction
(
    id         bigint auto_increment
        primary key,
    sender_account_id    bigint        not null,
    recipient_account_id bigint        not null,
    amount               DECIMAL       not null,
    currency   varchar(8)              null,
    created_at  timestamp    not null default current_timestamp,
    modified_at timestamp    not null default current_timestamp on update current_timestamp
);