--liquibase formatted sql
--changeset admin:CREATE_TABLE_hibernate_sequence

create table hibernate_sequence (
    next_val bigint) engine=InnoDB;

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

insert into hibernate_sequence values ( 1 );

create table ord (
     id integer not null auto_increment unique,
     address varchar(255),
     general_price integer,
     user_id integer not null,
     primary key (id)) engine=InnoDB;


create table product (
    id integer not null auto_increment unique,
    description varchar(255),
    name varchar(50),
    price integer,
    primary key (id)) engine=InnoDB;


create table product_list (
    id integer not null auto_increment unique,
    product_id integer not null,
    ord_id integer not null,
    primary key (id)) engine=InnoDB;

create table user (
    id integer not null auto_increment unique,
    active bit not null,
    email varchar(255),
    password varchar(255),
    username varchar(50),
    primary key (id)) engine=InnoDB;

create table roles (
    id integer not null auto_increment unique,
    name varchar(50)) engine=InnoDB;

create table user_roles (
    user_id integer not null,
    role_id integer not null) engine=InnoDB;

alter table ord
    add constraint
#         fk_ord_user
        FKr98rtrnc84wlfq3i8y8mf1nm5
        foreign key (user_id) references ord (id);

alter table product_list
    add constraint
#         fk_product_list_ord
        FK3ct1xv7dyfkprd95xb7cjgfpr
        foreign key (ord_id) references ord(id);

alter table product_list
    add constraint
#         fk_product_list_product
        FKk41cgp8g0ytss65j4wg75spl7
        foreign key (product_id) references product(id);

alter table user_roles
    add constraint
#         fk_user_roles_roles
        Kh8ciramu9cc9q3qcqiv4ue8a6
        foreign key (role_id) references roles(id);

alter table user_roles
    add constraint
#         fk_user_roles_roles
        FK55itppkw3i07do3h7qoclqd4k
        foreign key (user_id) references user(id);


