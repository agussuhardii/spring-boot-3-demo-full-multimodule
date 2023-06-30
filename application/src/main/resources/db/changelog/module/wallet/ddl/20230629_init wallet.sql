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
    primary key (id)
);

create table wallet.credit
(
    id          char(36) not null,
    user_id     char(36) not null,
    credit      numeric  not null,

    created_by  varchar(50),
    modified_by varchar(50),
    created_at  numeric,
    updated_at  numeric,
    is_deleted  boolean  not null default false,
    primary key (id)
);