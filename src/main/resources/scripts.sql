CREATE type country_type AS ENUM ('IN', 'UK', 'US', 'KR', 'DE', 'FR', 'RU');
CREATE type language_type AS ENUM ('BN', 'HI', 'EN', 'FR', 'DE', 'KR', 'RU')
CREATE type rating_type AS ENUM ('G', 'PG', 'PG_13', 'R', 'NC_17')
CREATE type gender_type AS ENUM ('MALE', 'FEMALE', 'NON_BINARY')

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