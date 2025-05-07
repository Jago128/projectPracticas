CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(30) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL
);

CREATE TABLE CONTACTO (
	IDCONTACTO INT PRIMARY KEY AUTO_INCREMENT,
    CONTACTO1 DATE NOT NULL,
    CONTACTO2 DATE,
    CONTACTO3 DATE,
    CONTACTO4 DATE,
    OBSERVACIONES VARCHAR(100),
    RESULTADOULTIMO ENUM("Comunicacion_SinRespuesta", "Respuesta_Pospuesta", "Reunion_Programada", "Respuesta_NoConcluyente", "Inicio_ValoracionOferta"),
    INFOULTIMO VARCHAR(200),
    RESULTADOFINAL ENUM("Oferta_Empleo", "Convenio_Colaboracion", "Medidas_Alternativas", "Relacion_Concluida", "Relacion_Pospuesta"),
    FECHARESOLUCION DATE
);

CREATE TABLE EMPRESA (
	NOM_EMPRESA VARCHAR(100) PRIMARY KEY,
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    PUESTO VARCHAR(30),
    DATOSCONTACTO VARCHAR(50) NOT NULL,
    CONTACTOEMPRESA VARCHAR(50) NOT NULL,
    CONTACTOAPNABI VARCHAR(30) NOT NULL,
    ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado') NOT NULL,
	IDCONTACTO INT,
    FOREIGN KEY (IDCONTACTO) REFERENCES CONTACTO (IDCONTACTO) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO USUARIO VALUES
("Test", "e"),
("w","1");

INSERT INTO EMPRESA VALUES
("Deportes Urbanos de Exterior S.L", "Deporte_Ocio", "Almacen", "info@deportesurbanos.com", "???", "Selene", "Informado", "2024-10-23", null, null, null, null),
("Grupo Cofares", "Logistica_Transporte", "Almacen","vcuesta@cofares.es", "Virginia", "Alba", "Valorando_Interesado", "2024-09-16", "2024-09-24", "2024-10-18", null, null),
("SEIDOR", "Internet", null, "LinkedIn", "Aida Morales Sedano", "Selene", "Informado", "2024-10-23", null, null, null, "Propuesta de prácticas");

DELIMITER // # Para insertar valores vacios, hay que escribir null en la variable respectiva al llamar la procedura.
CREATE PROCEDURE addEmpresa(NOM_EMPRESA VARCHAR(100), SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos',
	'Construccion', 'Deporte_Ocio', 'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida'), PUESTO VARCHAR(30), DATOSCONTACTO VARCHAR(50), CONTACTOEMPRESA VARCHAR(50), CONTACTOAPNABI VARCHAR(30),
    ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado'),
	CONTACTO1 DATE, CONTACTO2 DATE, CONTACTO3 DATE, CONTACTO4 DATE, OBSERVACIONES VARCHAR(100))
BEGIN
	INSERT INTO EMPRESA VALUES
	(NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO, CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES);
    SELECT "La empresa ha sido añadida correctamente." AS MENSAJE;
END; //

DELIMITER //
CREATE PROCEDURE signUp(NOMBRE VARCHAR(30), CONTRASEÑA VARCHAR(50))
BEGIN
	INSERT INTO USUARIO VALUES
    (NOMBRE, CONTRASEÑA);
END; //

DELIMITER //
CREATE PROCEDURE showEmpresas()
BEGIN
	DECLARE NOM_EMPRESA VARCHAR(100);
    DECLARE SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida');
    DECLARE PUESTO VARCHAR(30);
    DECLARE DATOSCONTACTO VARCHAR(50);
    DECLARE CONTACTOEMPRESA VARCHAR(50);
    DECLARE CONTACTOAPNABI VARCHAR(30);
    DECLARE ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado');
	DECLARE CONTACTO1 DATE;
    DECLARE CONTACTO2 DATE;
    DECLARE CONTACTO3 DATE;
    DECLARE CONTACTO4 DATE;
    DECLARE OBSERVACIONES VARCHAR(100);
	DECLARE C CURSOR FOR SELECT * FROM EMPRESA;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET END = TRUE;
    
    OPEN C;
    FETCH C INTO NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO;
    WHILE NOT END DO
		SELECT CONCAT ("Nombre:", NOM_EMPRESA, "Sector:", SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) AS "Datos empresa"; 
		FETCH C INTO NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO;
    END WHILE;
    CLOSE C;
END; //