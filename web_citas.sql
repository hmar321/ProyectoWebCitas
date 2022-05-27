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
	nombre VARCHAR(50) NOT NULL,
	direccion VARCHAR(50) NOT NULL,
	ciudad VARCHAR(50) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	sexo ENUM('Masculino','Femenino') NOT NULL,
	pareja ENUM('Hombre','Mujer','Sin preferencia') NOT NULL DEFAULT 'Sin preferencia',
	email VARCHAR(50) NOT NULL,
	contrasena VARCHAR(50) NOT NULL,
	PRIMARY KEY (email,pais),
	FOREIGN KEY (pais) REFERENCES paises(pais)
);

CREATE TABLE categorias (
	categoria VARCHAR(50) NOT NULL,
	descripcion VARCHAR(500),
	n_usuarios INT NOT NULL,
	PRIMARY KEY (categoria)
);

CREATE TABLE preferencias(
	email VARCHAR(50) NOT NULL,
	categoria VARCHAR(50) NOT NULL,
	actividad TIMESTAMP NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
	sincronizar_preferencias ENUM('Si','No') NOT NULL,
	PRIMARY KEY (email,categoria),
	FOREIGN KEY (categoria) REFERENCES categorias(categoria),
	FOREIGN KEY (email) REFERENCES usuarios(email)
);

CREATE TABLE centros (
	cp INT(5) NOT NULL,
	centro VARCHAR(50) NOT NULL,
	direccion VARCHAR(100) NOT NULL,
	ciudad VARCHAR(50) NOT NULL,
	pais VARCHAR(50) NOT NULL,
	web VARCHAR(50),
	PRIMARY KEY (centro),
	FOREIGN KEY (pais) REFERENCES paises(pais)
);

CREATE TABLE citas(
	cita_id INT NOT NULL AUTO_INCREMENT,
	fech_hora DATETIME NOT NULL,
	centro VARCHAR(50) NOT NULL,
	fracaso ENUM('Si','No','Pendiente') NOT NULL DEFAULT 'Pendiente',
<<<<<<< HEAD
	email1 VARCHAR(50) NOT NULL,
	email2 VARCHAR(50) NOT NULL,
	PRIMARY KEY (cita_id,centro,email1,email2),
	FOREIGN KEY (centro) REFERENCES centros(centro),
	FOREIGN KEY (email1) REFERENCES usuarios(email),
	FOREIGN KEY (email2) REFERENCES usuarios(email)
=======
	id_persona1 INT NOT NULL,
	id_persona2 INT NOT NULL,
	PRIMARY KEY (cita_id,centro_id,id_persona1,id_persona2),
	FOREIGN KEY (centro_id) REFERENCES centros(centro_id),
	FOREIGN KEY (id_persona1) REFERENCES usuarios(usuario_id),
	FOREIGN KEY (id_persona2) REFERENCES usuarios(usuario_id)
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
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

<<<<<<< HEAD
INSERT INTO web_citas.citas (fech_hora,centro,email1,email2) VALUES
	('2022-05-21 17:00','Restaurante DCorazon','usuario@gmail.com','usuario2@gmail.com')
=======
INSERT INTO web_citas.citas (fech_hora,centro_id,id_persona1,id_persona2) VALUES
	('2022-05-21 17:00',1,1,2)
>>>>>>> 826a86f3775e9a8ef91645f4c85d345a1f094dbb
;
