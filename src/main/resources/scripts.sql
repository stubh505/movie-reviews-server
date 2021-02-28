CREATE type country_type AS ENUM ('IN', 'UK', 'US', 'KR', 'DE', 'FR', 'RU');
CREATE type language_type AS ENUM ('BN', 'HI', 'EN', 'FR', 'DE', 'KR', 'RU');
CREATE type rating_type AS ENUM ('G', 'PG', 'PG_13', 'R', 'NC_17');
CREATE type gender_type AS ENUM ('MALE', 'FEMALE', 'NON_BINARY');
CREATE type review_rating_type AS ENUM ('ONE', 'TWO', 'THREE', 'FOUR', 'FIVE');
CREATE type user_type AS ENUM ('ADMIN', 'CREATOR', 'REVIEWER');

create table actor (
    actor_id varchar(255) not null,
    country country_type,
    date_of_birth date,
    image varchar(255),
    name varchar(70),
    primary key (actor_id)
)

create table movie (
    movie_id varchar(255) not null,
    cast_actor varchar(1000),
    country country_type,
    director varchar(70),
    genre varchar(100),
    language language_type,
    length int4 not null,
    name varchar(100),
    poster varchar(255),
    rating rating_type,
    release_date date,
    synopsys varchar(2000),
    trailer varchar(255),
    primary key (movie_id)
)

create table user_entity (
    user_id varchar(255) not null,
    date_of_birth date,
    date_of_joining date,
    email varchar(100),
    name varchar(70),
    password varchar(150),
    review_count int4 not null,
    user_name varchar(30),
    user_type user_type,
    primary key (user_id)
)

create table review (
    review_id varchar(255) not null,
    review_body varchar(2000),
    review_rating review_rating_type,
    review_title varchar(100),
    movie_movie_id varchar(255),
    user_user_id varchar(255),
    primary key (review_id)
)

alter table if exists review add constraint FKniahh54ob7eqvii88b71d0rp7 foreign key (movie_movie_id) references movie
alter table if exists review add constraint FKmtg4xuxl6lmmrh4bue5iwj5hd foreign key (user_user_id) references user_entity