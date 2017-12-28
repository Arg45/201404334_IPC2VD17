create table usuario(
	id_usuario int auto_increment not null,
	nombre varchar(100) not null,
	correo varchar(50) not null,
	fecha_nac date,
	nick varchar(20) not null,
	contrasena varchar(20) not null,
	karma varchar(10),
	primary key(id_usuario)
)
create table asociacion(
	id_asociacion int AUTO_INCREMENT not null,
	nombre varchar(50) not null,
	resumen varchar(500) null,
	logo varchar(1) null,
	primary key(id_asociacion)
)
create table proyecto(
	id_proyecto int AUTO_INCREMENT not null,
	nombre varchar(15) not null,
	f_inicio date not null,
	f_fin date,
	tareas int,
	costo int,
	primary key(id_proyecto)
)
create table tarea(
	id_tarea int AUTO_INCREMENT not null,
	nombre varchar(50) not null,
	descripcion varchar(200) null,
	f_inicio date not null,
	costo int null,
	contrasena varchar(20) not null,
	karma varchar(10),
	primary key(id_tarea) on delete cascade
)
create table habilidad(
	id_habilidad int AUTO_INCREMENT not null,
	nombre varchar(20) not null,
	descripcion varchar(30) null,
	primary key(id_habilidad)
)
create table conocimiento(
	id_conocimiento int AUTO_INCREMENT not null,
	nombre varchar(20) not null,
	descripcion varchar(30) null,
	fk_habilidad int,
	primary key(id_conocimiento),
	CONSTRAINT foreign key(fk_habilidad) references habilidad(id_habilidad) on update cascade on delete cascade
)
create table contacto(
	id_contacto int AUTO_INCREMENT not null,
	fk_usuario int,
	primary key(id_contacto),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade
)
create table mensaje(
	id_mensaje int AUTO_INCREMENT not null,
	contentido varchar(500),
	fk_contacto int,
	primary key(id_mensaje),
	CONSTRAINT foreign key(fk_contacto) references contacto(id_contacto) on update cascade on delete cascade
)
create table registro(
	id_registro int AUTO_INCREMENT not null,
	fk_usuario int,
	fk_asociacion int,
	primary key(id_registro),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_asociacion) references asociacion(id_asociacion) on update cascade on delete cascade
)
create table usuario_habilidad(
	id_usuario_habilidad int AUTO_INCREMENT not null,`ipc2-proyecto`
	fk_usuario int,
	fk_habilidad int,
	primary key(id_usuario_habilidad),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_habilidad) references habilidad(id_habilidad) on update cascade on delete cascade
)
create table usuario_conocimiento(
	id_usuario_conocimiento int AUTO_INCREMENT not null,
	fk_usuario int,
	fk_conocimiento int,
	primary key(id_usuario_conocimiento),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_conocimiento) references conocimiento(id_conocimiento) on update cascade on delete cascade
)
create table conocimiento_tarea(
	id_conocimiento_tarea int AUTO_INCREMENT not null,
	fk_conocimiento int,
	fk_tarea int,
	primary key(id_conocimiento_tarea),
	CONSTRAINT foreign key(fk_conocimiento) references conocimiento(id_conocimiento) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_tarea) references tarea(id_tarea )on update cascade on delete cascade
)
create table usuario_tarea(
	id_usuario_tarea int AUTO_INCREMENT not null,
	fk_usuario int,
	fk_tarea int,
	primary key(id_usuario_tarea),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_tarea) references tarea(id_tarea) on update cascade on delete cascade
)
create table usuario_proyecto(
	id_usuario_proyecto int AUTO_INCREMENT not null,
	fk_usuario int,
	fk_proyecto int,
	primary key(id_usuario_proyecto),
	CONSTRAINT foreign key(fk_usuario) references usuario(id_usuario) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_proyecto) references proyecto(id_proyecto) on update cascade on delete cascade
)
create table proyecto_tarea(
	id_proyecto_tarea int AUTO_INCREMENT not null,
	fk_proyecto int,
	fk_tarea int,
	primary key(id_proyecto_tarea),
	CONSTRAINT foreign key(fk_proyecto) references proyecto(id_proyecto) on update cascade on delete cascade,
	CONSTRAINT foreign key(fk_tarea) references tarea(id_tarea) on update cascade on delete cascade
)