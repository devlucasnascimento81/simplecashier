CREATE TABLE transactions
(
    id          INTEGER PRIMARY KEY AUTOINCREMENT,
    description TEXT NOT NULL,
    amount      TEXT NOT NULL,
    type        TEXT NOT NULL,
    category    TEXT,
    date        TEXT
);

CREATE TABLE accounts_payable
(
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    description  TEXT NOT NULL,
    amount       TEXT NOT NULL,
    status       TEXT NOT NULL ,
    due_date     TEXT NOT NULL ,
    payment_date TEXT
);

CREATE TABLE accounts_receivable
(
    id            INTEGER PRIMARY KEY AUTOINCREMENT,
    description   TEXT NOT NULL,
    amount        TEXT NOT NULL,
    status        TEXT NOT NULL ,
    due_date      TEXT NOT NULL ,
    received_date TEXT
);