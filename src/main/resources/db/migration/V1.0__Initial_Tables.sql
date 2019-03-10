create table file
(
  id        int auto_increment
    primary key,
  path      text default        null,
  extension varchar(64) default null
);

create table permission
(
  id            int auto_increment
    primary key,
  read_allowed  tinyint(1) default 0 null,
  write_allowed tinyint(1) default 0 null,
  user          int default     null,
  file          int default     null
);

create table user_group
(
  id   int auto_increment
    primary key,
  name varchar(64) default null
);

create table user
(
  id         int auto_increment
    primary key,
  username   varchar(64) default null,
  password   varchar(64) default null,
  enabled    tinyint(1) default 1     not null,
  user_group int default         null,
  constraint user_user_group_id_fk
  foreign key (user_group) references user_group (id)
);