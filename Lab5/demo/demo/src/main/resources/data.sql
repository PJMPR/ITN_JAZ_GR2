create table account_settings
(
    id                 number       not null,
    model              varchar(255) not null,
    registrationNumber varchar(255) not null,
    milleage           number,
    hasAccidents       number       not null,
    price              number,
    primary key (id)
);