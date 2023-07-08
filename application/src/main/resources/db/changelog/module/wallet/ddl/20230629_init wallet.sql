create schema if not exists wallet;

create table wallet.wallet_adjust
(
    id          char(36)    not null,
    user_id     char(36)    not null,
    adjust      numeric     not null,
    status      varchar(20) not null,

    created_by  varchar(50),
    modified_by varchar(50),
    created_at  numeric,
    updated_at  numeric,
    is_deleted  boolean     not null default false,
    primary key (id),
    version numeric
);

create table wallet.credit
(
    user_id     char(36) not null,
    credit      numeric  not null,

    created_by  varchar(50),
    modified_by varchar(50),
    created_at  numeric not null ,
    updated_at  numeric,
    is_deleted  boolean  not null default false,
    primary key (user_id),
    unique (user_id),
    version numeric
);