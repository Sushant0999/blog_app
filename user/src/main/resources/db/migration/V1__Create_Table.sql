CREATE TABLE user (
    user_id BINARY(16) NOT NULL,
    user_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    PRIMARY KEY (user_id)
);
