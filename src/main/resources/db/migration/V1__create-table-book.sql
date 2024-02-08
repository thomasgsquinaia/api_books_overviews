CREATE TABLE book (
    id INTEGER PRIMARY KEY UNIQUE NOT NULL,
    name TEXT,
    description TEXT,
    image TEXT,
    active BOOL
);