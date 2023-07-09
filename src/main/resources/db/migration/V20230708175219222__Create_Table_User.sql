create table users (
    id bigint PRIMARY KEY NOT NULL,
    person_id bigint UNIQUE NOT NULL,
    email varchar(255) UNIQUE,
    password varchar(255),
    token varchar(255),
    role varchar(50) check (role in ('USER','ADMIN','LEADER'))
    );

create sequence users_seq start with 1 increment by 50;

alter table if exists users
       add constraint fk_user_person
       foreign key (person_id)
       references person;