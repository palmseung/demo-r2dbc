drop table if exists accounts;

create table accounts (
   id bigint generated by default as identity,
   name varchar(300),
   created_at timestamp,
   active boolean,
   modified_at timestamp,
   primary key (id)
);