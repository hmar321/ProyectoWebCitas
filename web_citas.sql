DROP DATABASE if EXISTS web_citas;
CREATE DATABASE web_citas;
USE web_citas;

CREATE TABLE paises (
	pais VARCHAR(50) NOT NULL,
	n_usuarios INT NOT NULL,
	ultima_actualizacion TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	
	PRIMARY KEY (pais)
);

CREATE TABLE usuarios (
	usuario_id INT AUTO_INCREMENT NOT NULL,
	nombre VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	ciudad VARCHAR(50) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	sexo ENUM('Masculino','Femenino') NOT NULL,
	pareja ENUM('Hombre','Mujer','Sin preferencia') NOT NULL DEFAULT 'Sin preferencia',
	email VARCHAR(50) NOT NULL,
	contrasena VARCHAR(50) NOT NULL,
	PRIMARY KEY (usuario_id,pais),
	FOREIGN KEY (pais) REFERENCES paises(pais)
);

CREATE TABLE categorias (
	categoria_id INT AUTO_INCREMENT NOT NULL,
	categoria VARCHAR(50) NOT NULL,
	descripcion VARCHAR(500),
	n_usuarios INT NOT NULL,
	PRIMARY KEY (categoria_id)
);

CREATE TABLE preferencias(
	id_usuario INT AUTO_INCREMENT NOT NULL,
	categoria_id INT NOT NULL,
	actividad TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	sincronizar_preferencias ENUM('Si','No') NOT NULL,
	PRIMARY KEY (id_usuario,categoria_id),
	FOREIGN KEY (categoria_id) REFERENCES categorias(categoria_id),
	FOREIGN KEY (id_usuario) REFERENCES usuarios(usuario_id)
);

CREATE TABLE centros (
	centro_id INT AUTO_INCREMENT NOT NULL,
	cp INT(5) NOT NULL,
	centro VARCHAR(50) NOT NULL,
	direccion VARCHAR(30) NOT NULL,
	ciudad VARCHAR(15) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	web VARCHAR(25),
	PRIMARY KEY (centro_id),
	FOREIGN KEY (pais) REFERENCES paises(pais)
);

CREATE TABLE citas(
	cita_id INT NOT NULL AUTO_INCREMENT,
	fech_hora DATETIME NOT NULL,
	centro_id INT NOT NULL,
	fracaso ENUM('Si','No','Pendiente') NOT NULL DEFAULT 'Pendiente',
	id_persona1 INT NOT NULL,
	id_persona2 INT NOT NULL,
	PRIMARY KEY (cita_id,centro_id,id_persona1,id_persona2),
	FOREIGN KEY (centro_id) REFERENCES centros(centro_id),
	FOREIGN KEY (id_persona1) REFERENCES usuarios(usuario_id),
	FOREIGN KEY (id_persona2) REFERENCES usuarios(usuario_id)
);