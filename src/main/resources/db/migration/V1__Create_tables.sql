
--1

create table if not exists director
(
    id         serial       not null
        constraint film_pk
        primary key,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    birth_date date         not null
);

--2

create table if not exists film
(
    id           serial  not null
        constraint film_pk_2
            primary key,
    director_id  integer not null
        constraint film_director_id_fk
            references director,
    name         varchar(255),
    release_date date,
    genre        varchar(255)
);