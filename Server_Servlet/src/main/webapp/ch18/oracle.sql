create table member(
memberid varchar2(20) not null primary key,
passwordvarchar2(10) not null,
name varchar2(20) not null,
email varchar2(80)

);

insert into member values('google','1234','hong','hong@hong.com');
