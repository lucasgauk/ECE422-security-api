create table file
(
  id        int auto_increment
    primary key,
  path      text        null,
  extension varchar(64) null,
  file_name text        null
);

create table user
(
  id       int auto_increment
    primary key,
  username varchar(64)          null,
  password varchar(64)          null,
  enabled  tinyint(1) default 1 not null
);

create table permission
(
  id      int auto_increment
    primary key,
  `read`  tinyint(1) default 0 null,
  `write` tinyint(1) default 0 null,
  user    int                  null,
  file    int                  null,
  constraint permission_file_id_fk
    foreign key (file) references file (id),
  constraint permission_user_id_fk
    foreign key (user) references user (id)
);

create table user_group
(
  id   int auto_increment
    primary key,
  name varchar(64) null
);

