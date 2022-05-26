DROP DATABASE if EXISTS web_citas;
CREATE DATABASE web_citas;
USE web_citas;

CREATE TABLE paises (
	pais VARCHAR(50) NOT NULL,
	n_usuarios INT NOT NULL DEFAULT 0,
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
	email VARCHAR(50) NOT NULL UNIQUE,
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
	direccion VARCHAR(100) NOT NULL,
	ciudad VARCHAR(50) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	web VARCHAR(50),
	PRIMARY KEY (centro_id),
	FOREIGN KEY (pais) REFERENCES paises(pais)
);

CREATE TABLE citas(
	cita_id INT NOT NULL AUTO_INCREMENT,
	fech_hora DATETIME NOT NULL,
	centro_id INT NOT NULL,
	fracaso ENUM('Si','No','Pendiente') NOT NULL DEFAULT 'Pendiente',
	email1 VARCHAR(50) NOT NULL,
	email2 VARCHAR(50) NOT NULL,
	PRIMARY KEY (cita_id,centro_id),
	FOREIGN KEY (centro_id) REFERENCES centros(centro_id)
);

INSERT INTO web_citas.paises (pais) VALUES
	('España'),
	('Francia'),
	('Reino Unido'),
	('Alemania'),
	('Países Bajos'),
	('Bélgica'),
	('Polonia'),
	('Rumania'),
	('Italia')
;
INSERT INTO web_citas.usuarios (nombre,direccion,ciudad,pais,sexo,email,contrasena) VALUES
('admin','x','x','España','Masculino','admin@gmail.com','admin')
;

DELIMITER $$
CREATE TRIGGER web_citas.UsuarioPais 
AFTER INSERT ON web_citas.usuarios
	FOR EACH ROW
	BEGIN
	UPDATE paises SET n_usuarios=n_usuarios+1 WHERE paises.pais=NEW.pais;
END;

INSERT INTO web_citas.centros (cp,centro,direccion,ciudad,pais,web) VALUES
	(28012,'Restaurante DCorazon','Pl. Mayor, 30','Madrid','España','thefork.es'),
	(28004,'Restaurante Ático','C. del Marqués de Valdeiglesias, 1','Madrid','España','theprincipalmadridhotel.com'),
	(28001,'Restaurante La Bien Aparecida','C. de Jorge Juan, 8','Madrid','España','restaurantelabienaparecida.com'),
	(28013,'Restaurante Gloria Bendita','Calle de Santiago, 3','Madrid','España','thefork.es'),
	(28012,'Restaurante Arrabal','Pl. Mayor, 23','Madrid','España','opentable.es/thefork.es')
;

INSERT INTO web_citas.usuarios (nombre,direccion,ciudad,pais,sexo,email,contrasena) VALUES
('usuario','C/Tolosa,2,12345','Madrid','España','Masculino','usuario@gmail.com','usuario')
;

INSERT INTO web_citas.usuarios (nombre,direccion,ciudad,pais,sexo,email,contrasena) VALUES
('usuario asd','C/Tolosa,2,12345','Madrid','España','Masculino','usuario2@gmail.com','usuario')
;

INSERT INTO web_citas.citas (fech_hora,centro_id,email1,email2) VALUES
	('21-05-2022 17:00',1,'usuario@gmail.com','usuario2@gmail.com')
;
