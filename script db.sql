/* database JSF*/

create table usuario(
    username varchar(50),
    password varchar(50),
    email varchar(100)
);

create table articulo(
    item varchar(50),
    precio int,
    cantidad int
);

insert into usuario values('login','login','login@login.cl');
select * from usuario;
delete from usuario where username = 'login';

insert into articulo values('Tablet x3',2500,22);
select * from articulo;