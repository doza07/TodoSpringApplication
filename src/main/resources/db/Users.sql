CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(128) NOT NULL,
    email VARCHAR(128) NOT NULL,
    password VARCHAR NOT NULL,
    birthday DATE
);