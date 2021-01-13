drop database if exists 3CM9;

create database 3CM9;

use 3CM9;

/*EVENTO*/

create table Evento(
	idEvento int not null auto_increment primary key,
	nombreEvento varchar(50) not null, 
	sede varchar(50) not null,
	fechaInicio date,
	fechaTermino date
);

/*CATEGORÍA*/

create table Categoria(
	idCategoria int not null auto_increment primary key,
	nombreCategoria varchar(50) not null,
	descripcionCategoria varchar(150) not null
);

delimiter //
create procedure spInsertarCategoria(
	nombre varchar(50),
    descripcion varchar(150)
) begin
insert into Categoria (nombreCategoria, descripcionCategoria) values (nombre, descripcion);
end //
delimiter ;

delimiter //
create procedure spActualizarCategoria(
	nombre varchar(50),
    descripcion varchar(150),
	id int
) begin
update Categoria set nombreCategoria = nombre, descripcionCategoria = descripcion where idCategoria = id;
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
create procedure spVerCategoria(
	id int
) begin
select * from Categoria where idCategoria = id;
end //
delimiter ;

call spinsertarCategoria('Computacion', 'Equipos de computo de ultima generacion');
call spinsertarCategoria('Electronica', 'Equipos para el hogar de ultima generacion');

/*USUARIO*/

create table Usuario(
	idUsuario int not null auto_increment primary key,
    nombre varchar(50) not null,
    paterno varchar(50) not null,
    materno varchar(50) not null,
    email varchar(50) not null,
    nombreUsuario varchar(20) not null,
    claveUsuario varchar(20) not null,
    tipoUsuario varchar(20) not null
);

delimiter //
create procedure spInsertarUsuario(
	nombreU varchar(50),
    paternoU varchar(50),
    maternoU varchar(50),
    emailU varchar(50),
    nombreUsuarioU varchar(20),
    claveUsuarioU varchar(20),
    tipoUsuarioU varchar(20)
) begin
insert into Usuario (nombre, paterno, materno, email, nombreUsuario, claveUsuario, tipoUsuario) 
			 values (nombreU, paternoU, maternoU, emailU, nombreUsuarioU, claveUsuarioU, tipoUsuarioU);
end //
delimiter ;

delimiter //
create procedure spActualizarUsuario(
	nombreU varchar(50),
    paternoU varchar(50),
    maternoU varchar(50),
    emailU varchar(50),
    nombreUsuarioU varchar(20),
    claveUsuarioU varchar(20),
    tipoUsuarioU varchar(20),
    id int
) begin
update Usuario set nombre = nombreU, paterno = paternoU, materno = maternoU, email = emailU, nombreUsuario = nombreUsuarioU, 
			       claveUsuario = claveUsuarioU, tipoUsuario = tipoUsuarioU where idUsuario = id;
end //
delimiter ;

delimiter //
create procedure spBorrarUsuario(
	id int
) begin
delete from Usuario where idUsuario = id;
end //
delimiter ;

delimiter //
create procedure spMostrarUsuarios() 
begin
select * from Usuario;
end //
delimiter ;

delimiter //
create procedure spVerUsuario(
	id int
) begin
select * from Usuario where idUsuario = id;
end //
delimiter ;

delimiter //
create procedure spLogin(
	nombreUsuarioU varchar(20),
    claveUsuarioU varchar(20)
) 
begin
select * from Usuario where nombreUsuario = nombreUsuarioU and claveUsuario = claveUsuarioU;
end //
delimiter ;

/*ENTIDAD FEDERATIVA*/

create table EntidadFederativa(
	idEntidadFederativa int not null primary key,
    nombre varchar(50) not null,
    abreviatura char(5) not null
);

delimiter //
create procedure spInsertarEntidadFederativa(
	id int,
    nombreE varchar(50),
	abreviaturaE char(5)
) begin
insert into EntidadFederativa values (id, nombreE, abreviaturaE);
end //
delimiter ;

delimiter //
create procedure spActualizarEntidadFederativa(
    nombreE varchar(50),
	abreviaturaE char(5),
	id int
) begin
update EntidadFederativa set nombre = nombreE, abreviatura = abreviaturaE where idEntidadFederativa = id;
end //
delimiter ;

delimiter //
create procedure spBorrarEntidadFederativa(
	id int
) begin
delete from EntidadFederativa where idEntidadFederativa = id;
end //
delimiter ;

delimiter //
create procedure spMostrarEntidadesFederativas() 
begin
select * from EntidadFederativa;
end //
delimiter ;

delimiter //
create procedure spVerEntidadFederativa(
	id int
) begin
select * from EntidadFederativa where idEntidadFederativa = id;
end //
delimiter ;

create table Municipio(
	idMunicipio varchar(5) not null primary key,
    idEntidadFederativa int not null,
    nombre varchar(100) not null,
    foreign key (idEntidadFederativa) references EntidadFederativa(idEntidadFederativa) on delete cascade
);

delimiter //
create procedure spInsertarMunicipio(
	id varchar(5),
    idE int,
    nombreM varchar(50)
) begin
insert into Municipio values (id, idE, nombreM);
end //
delimiter ;

delimiter //
create procedure spActualizarMunicipio(
    idE int,
    nombreM varchar(50),
	id varchar(5)
) begin
update Municipio set idEntidadFederativa = idE, nombre = nombreM where idMunicipio = id;
end //
delimiter ;

delimiter //
create procedure spBorrarMunicipio(
	id varchar(5)
) begin
delete from Municipio where idMunicipio = id;
end //
delimiter ;

delimiter //
create procedure spMostrarMunicipios() 
begin
select * from Municipio;
end //
delimiter ;

delimiter //
create procedure spVerMunicipio(
	id varchar(5)
) begin
select * from Municipio where idMunicipio = id;
end //
delimiter ;

create table Producto(
	idProducto int not null auto_increment primary key,
    nombreProducto varchar(50) not null,
    descripcionProdcuto varchar(150) not null,
    precio double not null,
    existencia int not null
);

delimiter //
create procedure spInsertarProducto(
    nombreProductoP varchar(50),
    descripcionProdcutoP varchar(150),
    precioP double,
    existenciaP int
) begin
insert into Producto(nombreProducto, descripcionProducto, precio, existencia) values (nombreProductoP, descripcionProductoP, precioP, existenciaP);
end //
delimiter ;

delimiter //
create procedure spActualizarProducto(
    nombreProductoP varchar(50),
    descripcionProdcutoP varchar(150),
    precioP double,
    existenciaP int,
    id int
) begin
update Producto set nombreProducto = nombreProductoP, descripcion = descripcionP, precio = precioP, existencia = existenciaP where idProducto = id;
end //
delimiter ;

delimiter //
create procedure spBorrarProducto(
	id int
) begin
delete from Producto where idProducto = id;
end //
delimiter ;

delimiter //
create procedure spMostrarProductos() 
begin
select * from Producto;
end //
delimiter ;

delimiter //
create procedure spVerProducto(
	id int
) begin
select * from Producto where idProducto = id;
end //
delimiter ;