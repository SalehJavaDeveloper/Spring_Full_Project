create table STUDENT
(
    id      NUMERIC(15) primary key ,
    name    VARCHAR(50),
    surname VARCHAR(50),
    age numeric
);

create table ADDRESS
(
    id      NUMERIC(15) primary key,
    city VARCHAR(50),
    street VARCHAR(50),
    POST_NUMBER int,
    student_id numeric(15)
)