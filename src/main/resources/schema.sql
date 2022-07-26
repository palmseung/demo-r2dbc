DROP TABLE accounts;

CREATE TABLE accounts (
  id integer generated always as IDENTITY PRIMARY KEY,
  name VARCHAR(255),
  created_at timestamp,
  active integer,
  modified_at timestamp
);