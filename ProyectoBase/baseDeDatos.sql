drop database if exists 3CM9;

create database 3CM9;

use 3CM9;

create table Evento(
	idEvento int not null auto_increment primary key,
	nombreEvento varchar(50) not null, 
	sede varchar(50) not null,
	fechaInicio date,
	fechaTermino date
);

desc Evento;

create table Categoria(
	idCategoria int not null auto_increment primary key,
	nombreCategoria varchar(50) not null,
	descripcionCategoria varchar(150) not null
);

desc Categoria;

select * from Evento;

delimiter //
create procedure spInsertarCategoria(
	nombre varchar(50),
    descripcion varchar(150)
) begin
insert into Categoria (nombreCategoria, descripcionCategoria) values (nombre, descripcion);
end //
delimiter ;

call spinsertarCategoria('Computación', 'Equipos de cómputo de última generación');
call spinsertarCategoria('Electrónica', 'Equipos para el hogar de última generación');

delimiter //
create procedure spActualizarCategoria(
	id int,
	nombre varchar(50),
    descripcion varchar(150)
) begin
update Categoria set nombreCategoria = categoria, descripcionCategoria = descripcion where idCategoria = id;
end //
delimiter ;

delimiter //
create procedure spBorrarCategoria(
	id int
) begin
delete from Categoria where idCategoria = id;
end //
delimiter ;

delimiter //
create procedure spMostrarCategorias() 
begin
select * from Categoria;
end //
delimiter ;

delimiter //
create procedure spVerrCategoria(
	id int
) begin
select * from Categoria where idCategoria = id;
end //
delimiter ;

call spMostrarCategorias();