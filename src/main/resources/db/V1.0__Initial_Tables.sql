create table file
(
  id        int auto_increment
    primary key,
  path      text        null,
  extension varchar(64) null
);

create table permission
(
  id            int auto_increment
    primary key,
  read_allowed  tinyint(1) default 0 null,
  write_allowed tinyint(1) default 0 null,
  user          int                  null,
  file          int                  null
);

create table user
(
  id       int auto_increment
    primary key,
  username varchar(64)          null,
  password varchar(64)          null,
  enabled  tinyint(1) default 1 not null
);

create table user_group
(
  id   int auto_increment
    primary key,
  name varchar(64) null
);



