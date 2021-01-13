create table Categoria(
	idCategoria serial primary key,
	nombreCategoria varchar(50) not null,
	descripcionCategoria varchar(150) not null
);

INSERT INTO Categoria values(1,'Video Juegos','X BOX S');
INSERT INTO Categoria values(2,'Electrónica','Televisor');
INSERT INTO Categoria values(3,'Linea Blanca','Refrigerador');

CREATE TABLE Producto (
  idProducto serial primary key,
  nombreProducto varchar(50) NOT NULL,
  descripcionProducto varchar(150) NOT NULL,
  precio float NOT NULL,
  existencia int NOT null,
  idCategoria int not null,
  foreign key (idcategoria) references Categoria(idcategoria) on update cascade on delete cascade
);

insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('FIFA 21 - Edición e',
		'Incluye la UEFA Champions League, la UEFA Europa League',1349.00,100,1);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Super Mario Nintendo Switch 3D All Stars',
'Incluye los titulos Super Mario Sunshine, Super Mario Galaxy y Super Mario 64.', 1399.00, 100, 1);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Luigis Mansion 3 Nintendo Switch',
'Incluye los titulos Super Mario Sunshine, Super Mario Galaxy y Super Mario 64.', 1399.00, 100, 1);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Nintendo Switch',
'Incluye los titulos Super Mario Sunshine, Super Mario Galaxy y Super Mario 64.', 1399.00, 100, 1);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('FIFA 21 ',
'Incluye la UEFA Champions League, la UEFA Europa League, CONMEBOL Libertadores', 1349.00,100, 1);

insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Televisor LG',
'UHD 4K Resolución 3840x2160 LG 8806091995643', 9925.00,100, 2);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Control Remoto',
'Vinabty Akb73756542 Para Televisor Smart Lg Vinabty AKB73756542', 628.00, 100, 2);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Soporte StarTech',
'Pared para Televisor o Monitor de 32 a 55 StarTech.com FPWARTB1M', 2099.00, 100, 2);

insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Lavadora Daewoo',
'Sistema de Lavado por Aeroburbujas AIR Bubble 4D', 9999, 100, 3);
insert into Producto (nombreProducto, descripcionProducto, precio, existencia, idCategoria) values ('Estufa Acros AF-5001D',
'3 parrillas de alambrón con diseño tipo dedos', 4999.00, 100, 3);

CREATE TABLE Usuario (
  idUsuario serial primary key,
  nombre varchar(50) NOT NULL,
  paterno varchar(50) NOT NULL,
  materno varchar(50) NOT NULL,
  email varchar(50) NOT NULL,
  nombreUsuario varchar(20) NOT NULL,
  claveUsuario varchar(20) NOT null,
  tipoUsuario varchar(1)
);