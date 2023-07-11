CREATE TABLE users(
    id UUID,
    name VARCHAR(50),
    token VARCHAR(500),
    token_expire TIMESTAMP,
    password VARCHAR(50),
    CONSTRAINT user_id PRIMARY KEY(id)
);

INSERT INTO users VALUES
('b404c3a3-219f-4b06-a9fe-002845136ac7', 'USER1', null, 'admin123');