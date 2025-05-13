CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(50) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL
);

CREATE TABLE EMPRESA (
    COD_EMPRESA INT PRIMARY KEY AUTO_INCREMENT,
    NOM_EMPRESA VARCHAR(100) UNIQUE NOT NULL,
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    PUESTO VARCHAR(50),
    DATOSCONTACTO VARCHAR(50) NOT NULL,
    CONTACTOEMPRESA VARCHAR(50) NOT NULL,
    CONTACTOAPNABI VARCHAR(30) NOT NULL,
    ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado') NOT NULL
);

CREATE TABLE CONTACTO (
    COD_CONTACTO INT PRIMARY KEY AUTO_INCREMENT,
    CONTACTO1 DATE NOT NULL,
    CONTACTO2 DATE,
    CONTACTO3 DATE,
    CONTACTO4 DATE,
    OBSERVACIONES VARCHAR(500),
    RESULTADOULTIMO ENUM('Comunicacion_SinRespuesta', 'Respuesta_Pospuesta', 'Reunion_Programada', 'Respuesta_NoConcluyente', 'Inicio_ValoracionOferta'),
    INFOULTIMO VARCHAR(500),
    RESULTADOFINAL ENUM('Oferta_Empleo', 'Convenio_Colaboracion', 'Medidas_Alternativas', 'Relacion_Concluida', 'Relacion_Pospuesta'),
    FECHARESOLUCION DATE,
    COD_EMPRESA INT,
    FOREIGN KEY (COD_EMPRESA)
        REFERENCES EMPRESA (COD_EMPRESA)
);

CREATE TABLE PERSONA (
    NOM_P VARCHAR(100) PRIMARY KEY,
    APOYO VARCHAR(50) NOT NULL,
    FORMACION ENUM('AT', 'Primaria', 'ESO', 'EPA', 'FP_Basica', 'GM', 'Bachillerato', 'GS', 'Universidad', 'Master', 'Doctorado') NOT NULL,
    ESPECIALIDAD VARCHAR(500) NOT NULL,
    SECTORINTERES ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    CV VARCHAR(999),
    DISCAPACIDAD ENUM('Si', 'No', 'No_Sabe', 'Tramitando') NOT NULL,
    EUSKERA ENUM('A1', 'A2', 'B1', 'B2', 'C1', 'C2', 'Conocimiento_NoAcreditado'),
    INGLES ENUM('A1', 'A2', 'B1', 'B2', 'C1', 'C2', 'Conocimiento_NoAcreditado'),
    OTROSIDIOMAS VARCHAR(50),
    LOCALIDAD ENUM('Abadiño', 'Abanto_Zierbena', 'Ajangiz', 'Alonsotegi', 'Amorebieta', 'Amoroto', 'Amurrio', 'Arakaldo', 'Arantzazu', 'Areatza_Bilaro', 'Arrankudiaga',
    'Arratzu', 'Arrieta', 'Arrigorriaga', 'Artzentales', 'Artziniega', 'Aulesti', 'AxpeAtxondo', 'Ayala_Aiara', 'Bakio', 'Balmaseda', 'Barakaldo', 'Barrika', 'Basauri',
    'Bedia', 'Berango', 'Bermeo', 'Berriatua', 'Berriz', 'Bilbao', 'Busturia', 'CastroUrdiales', 'Galdakao', 'Galdames', 'GamizFika', 'Garai', 'Gatika', 'Gautegiz',
    'GazteluElexabeitia_Arteaga', 'GernikaLumo', 'Getxo', 'Gizaburuaga', 'Gordexola', 'Gorliz', 'Gueñes', 'Ibarrangelu', 'Igorre', 'Ispaster', 'Iurreta', 'Izurtza',
    'KarrantzaHarana', 'Kortezubi', 'Lanestosa', 'Larrabetzu', 'Laudio_Llodio', 'Laukiz', 'Leioa', 'Lekeitio', 'Lemoa', 'Lemoiz', 'Lezama', 'Loiu', 'Lallabia', 'Mañaria',
    'MarkinaXemein', 'Maruri', 'Mendata', 'Mendexa', 'Meñaka', 'Morga', 'Mundaka', 'Mungia', 'MunitibarArbatzegi_Gerrikaitz', 'Murueta', 'Muskiz', 'Muxika', 'Nabarniz',
    'Ondarroa', 'Orduña', 'Orozko', 'Ortuella', 'Otxandio', 'Plentzia', 'Portugalete', 'Santurtzi', 'Sestao', 'Sondika', 'Sopela', 'Sopuerta', 'Sukarrieta', 'Trapagaran',
    'Turtzioz', 'Ubide', 'UgaoMiraballes', 'Urduliz', 'Urduña', 'Usansolo', 'Zaldibar', 'Zalla', 'Zamudio', 'Zaratamo', 'Zeanuri', 'Zeberio', 'Zierbena', 'ZiortzaBolibar',
    'Zornotza') NOT NULL,
    ACCESIBILIDAD ENUM('Carnet_Coche', 'Carnet', 'Transporte_Publico') NOT NULL,
    OBSERVACIONES VARCHAR(500)
);

CREATE TABLE ANALISISPUESTO(
	EMPRESA VARCHAR(100) PRIMARY KEY,
    PUESTO VARCHAR(50) NOT NULL,
    HORARIO VARCHAR(100) NOT NULL,
    MIN_FORMACION ENUM('AT', 'Primaria', 'ESO', 'EPA', 'FP_Basica', 'GM', 'Bachillerato', 'GS', 'Universidad', 'Master', 'Doctorado') NOT NULL,
    UBICACION VARCHAR(150),
	SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    REQ_IDIOMAS VARCHAR(50),
	CONTACTOEMPRESA VARCHAR(50) NOT NULL,
    RESPONSABLEAPNABI VARCHAR(50) NOT NULL # Apoyo
);

INSERT INTO USUARIO VALUES
("w","1");

INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES
("Deportes Urbanos de Exterior S.L", "Deporte_Ocio", "Almacen", "info@deportesurbanos.com", "???", "Selene", "Informado"),
("Grupo Cofares", "Logistica_Transporte", "Almacen","vcuesta@cofares.es", "Virginia", "Alba", "Valorando_Interesado"),
("SEIDOR", "Internet", null, "LinkedIn", "Aida Morales Sedano", "Selene", "Informado");

INSERT INTO CONTACTO (CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMPRESA) VALUES
("2024-10-23", null, null, null, null, "Comunicacion_SinRespuesta", "Reunión el 08/05/2025", null, null, 1),
("2024-09-16", "2024-09-24", "2024-10-18", null, null, "Respuesta_Pospuesta", "Tras reunión y presentación se les envía correo y responden que están valorando próximo contacto en mayo.", null, "2023-10-11", 2),
("2024-10-23", null, null, null, "Propuesta de prácticas","Reunion_Programada","5 de mayo firma de convenio en oficinas de apnabi.","Convenio_Colaboracion", "2023-10-6", 3);

INSERT INTO PERSONA VALUES
();

DELIMITER //
CREATE PROCEDURE insertUser(NOMBRE VARCHAR(30), CONTRASEÑA VARCHAR(50))
BEGIN
	INSERT INTO USUARIO VALUES
	(NOMBRE,CONTRASEÑA);
END; //

DELIMITER //
CREATE PROCEDURE insertEmpresa(NOM_EMPRESA VARCHAR(100),
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida'),
    PUESTO VARCHAR(30), DATOSCONTACTO VARCHAR(50), CONTACTOEMPRESA VARCHAR(50), CONTACTOAPNABI VARCHAR(30),
    ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado'))
BEGIN
	INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES
	(NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO);
END; //

CREATE PROCEDURE insertContacto(NOM_EMP VARCHAR(100), CONTACTO1 DATE, CONTACTO2 DATE, CONTACTO3 DATE, CONTACTO4 DATE, OBSERVACIONES VARCHAR(500),
    RESULTADOULTIMO ENUM('Comunicacion_SinRespuesta', 'Respuesta_Pospuesta', 'Reunion_Programada', 'Respuesta_NoConcluyente', 'Inicio_ValoracionOferta'),
    INFOULTIMO VARCHAR(500),
    RESULTADOFINAL ENUM('Oferta_Empleo', 'Convenio_Colaboracion', 'Medidas_Alternativas', 'Relacion_Concluida', 'Relacion_Pospuesta'),
    FECHARESOLUCION DATE, COD_EMPRESA INT)
BEGIN
	DECLARE COD_EMP INT;
    SET COD_EMP:=(SELECT COD_EMPRESA FROM EMPRESA WHERE NOM_EMPRESA=NOM_EMP);
	
    INSERT INTO CONTACTO (CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMPRESA) VALUES
	(CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMP);
END; //
