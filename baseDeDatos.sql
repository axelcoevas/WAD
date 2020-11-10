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

select * from Evento;