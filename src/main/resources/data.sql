	drop table if exists asignado;
	drop table if exists cientificos;
	drop table if exists proyecto;
	drop table if exists usuario;
	
	create table proyectos (
	id varchar(4) primary key, 
	nombre varchar(255),
	horas int
	);
	
	create table cientificos (
	id varchar(8) primary key,
	nombre varchar(255)
	);
	
	create table asignado (
	id int primary key auto_increment,
	cientifico varchar(8),
	proyecto varchar(4),
	foreign key(cientifico) references cientificos(id)
	on delete cascade
	on update cascade,
	foreign key(proyecto) references proyectos(id)
	on delete cascade
	on update cascade
	);
	
	create table usuario (
	id int primary key auto_increment,
	username varchar (300),
	password varchar (300),
	role varchar (300)
	);
	
	insert into proyectos values
	('1234', "Proyecto1", 10),
	('2234', "Proyecto2", 10),
	('3234', "Proyecto3", 10),
	('4234', "Proyecto4", 10),
	('5234', "Proyecto5", 10);
	
	insert into cientificos values
	("12345678", "Veronika"),
	("22345678", "Isidre"),
	("32345678", "Adria"),
	("42345678", "Marc"),
	("52345678", "Joan");
	
	insert into asignado (cientifico, proyecto) values
	("12345678", "1234"),
	("22345678", "2234"),
	("32345678", "3234"),
	("42345678", "4234"),
	("52345678", "5234");