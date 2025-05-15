CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(50) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL
);

INSERT INTO USUARIO VALUES
("w","1");

CREATE TABLE EMPRESA (
    COD_EMPRESA INT PRIMARY KEY AUTO_INCREMENT,
    NOM_EMPRESA VARCHAR(100) UNIQUE NOT NULL,
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    PUESTO VARCHAR(100),
    DATOSCONTACTO VARCHAR(200),
    CONTACTOEMPRESA VARCHAR(100),
    CONTACTOAPNABI VARCHAR(30) NOT NULL,
    ESTADO ENUM('Informado', 'Valorando_Interesado', 'PlanificandoInserciones', 'ProximoAño', 'NoInteresado')
);

INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES
("Deportes Urbanos de Exterior S.L", "Deporte_Ocio", "Almacen", "info@deportesurbanos.com", null, "Selene", "Informado"),
("Sualdi", "Metalurgia_Electronica", "Mozo/a Almacen", "sualdi@sualdi.com", null, "Selene", "Informado"),
("TSB", "Internet", "Mozo/a Almacen", "marc.pascual008@tsbtrans.com", "Marc Pascual", "Selene", "Informado"),
("Between Technology", "Internet", null, "LinkedIn", "Noemi Cotoré", "Selene", "Informado"),
("Versia", "Internet", null, "LinkedIn", "Garazi Mosteiro", "Selene", "Informado"),
("SEIDOR", "Internet", null, "LinkedIn", "Aida Morales Sedano", "Selene", "Informado"),
("Hotel Hesperia", "Turismo_Hosteleria", "Recepcion/Botones", "rheras@hesperia.com", "Raul Heras", "Alba", "Valorando_Interesado"),
("Ormazabal", "ProductosQuimicos_MateriasPrimas", "Almacen","mgi@ormazabal.com", "Miren Gutierrez", "Alba", "Valorando_Interesado"),
("Goaxen", "Deporte_Ocio", "Puesto multitarea (recepcion, monitor)", "info@goaxen.com", "Adrian Lopez", "Alba", "Valorando_Interesado"),
("Grupo Cofares", "Logistica_Transporte", "Almacen","vcuesta@cofares.es", "Virginia", "Alba", "Valorando_Interesado"),
("Cie Automotive", "Servicios", null, "jalvarez@cieautomotive.com", "Javier Alvarez", "Alba", "Informado"),
("Hotel Oriol", "Turismo_Hosteleria", null, "jeferecepcion.urhoriol@urh-hoteliers.com", "Jesus Garcia", "Gorka", "ProximoAño"),
("Druni Artea", "Comercio_Establecimientos", "Dependiente", "raquel.peiro@druni.es", "Raquel Peiro", "Gorka", "Informado"),
("Destination Consultant", "Turismo_Hosteleria", "Auxiliar administrativo", "gorka@basquecountry-spain-dmc.com", "Gorka Marques", "Alba", "Valorando_Interesado"),
("Estudios Durero", "Sociedad", null, "durero@estudiosdurero.com", "Ander Soriano Melgar", "Selene", "Informado"),
("Ibermatica", "Internet", null, "jarroyo@ayesa.com", "Jone Arroyo Aguado", "Selene", "ProximoAño"),
("Aplimedia", "Internet", null, "laura@aplimedia.com", "Laura Ferrer", "Selene", "NoInteresado"),
("I3", "Internet", null, null, null, "Selene", "NoInteresado"),
("GURENET", "Internet", null, "info@gurenet.com", "Iker Revuelta", "Selene", "Informado"),
("ZabalIT", "Internet", null, "administracion@zabalit.com", "Yolanda Chaves", "Selene", "Informado"),
("Serinfor", "Internet", null, "yulia@serinfor.net", null, "Selene", "Informado"),
("Abaco Creacion", "Internet", null, null, null, "Selene", "NoInteresado"),
("Linube", "Internet", null, "info@linube.com", null, "Selene", "Informado"),
("byvapps", "Internet", null, "astorga@byvapps.com", "Iban Astorga", "Selene", "Informado"),
("Ingeteam", "Metalurgia_Electronica", null, "People.Bizkaia@ingeteam.com", null, "Selene", "Informado"),
("Grupo Oesia", "Metalurgia_Electronica", null, "LinkedIn", "Monica Cuñado", "Selene", "Informado"),
("Grupo Oesia", "Metalurgia_Electronica", null, "scagigal@oesia.com", "Silvia Cagigal", "Selene", "Informado"),
("Grupo Oesia", "Metalurgia_Electronica", null, "mlconcepcion@oesia.com", "Marisa Concepcion", "Selene", "Informado"),
("Supermercado sqrups", "Comercio_Establecimientos", null, "bilbao@sqrups.es", "Mikel", "Alba", "Informado"),
("Sercotel Arenal Bilbao", "Turismo_Hosteleria", null, "direccion@sercotelarenalbilbao.com/629346347", "Beatriz Rodriguez", "Gorka", "Informado"),
("Herbolario Navarro", "Comercio_Establecimientos", null, "bidebarrieta@herbolarionavarro.es", "Marta", "Alba", "Informado"),
("Bestseller", "Servicios", "Recepcionista", "lucia.whitby@bestseller.com", "Lucia", "Alba", "ProximoAño"),
("Carrefour Atxuri", "Comercio_Establecimientos", "Gerente", "jose_robles_novas@carrefour.com", "Jose Robles", "Alba", "Informado"),
("Inycom", "Internet", "Directora de personas y talento", "marta.abad@inycom.es", "Marta", "Gorka", "Informado"),
("Veritas", "Comercio_Establecimientos", "Jefe area norte", "649984564", "Gontzal", "Alba", "Informado"),
("TEDI", "Comercio_Establecimientos", null, "722295620", "Fernanda", "Alba", "Informado"),
("Altafit Deusto", "Deporte_Ocio", "Gerente", "676053136", null, "Alba", null);

CREATE TABLE CONTACTO (
    COD_CONTACTO INT PRIMARY KEY AUTO_INCREMENT,
    CONTACTO1 DATE,
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

INSERT INTO CONTACTO (CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMPRESA) VALUES
("2024-10-23", null, null, null, null, "Comunicacion_SinRespuesta", "Reunión el 08/05/2025", null, null, 1),
("2024-10-23", null, null, null, null, null, null, null, null, 2),
("2024-10-23", null, null, null, null, null, null, null, null, 3),
("2024-10-23", "2024-10-12", null, null, "2º contacto propuesta prácticas", "Inicio_ValoracionOferta",
"Pendiente de que nos den fecha para entrevistar a las dos personas que hemos enviado el CV", "Oferta_Empleo", "2023-10-4", 4),
("2024-10-23", "2024-10-23", null, null, "2º contacto propuesta prácticas", null, "Va a pasar la información a RRHH", null, "2023-10-5", 5),
("2024-9-20", "2024-10-9", null, null, "Propuesta de prácticas", "Reunion_Programada", "5 de mayo firma de convenio en oficinas de apnabi.","Convenio_Colaboracion", "2023-10-6", 6),
("2024-9-20", "2024-10-9", null, null, null, null, null, null, "2023-10-7", 7),
("2024-10-21", null, null, null, null, "Inicio_ValoracionOferta",
"Kathia propone sacar ofertas ideadas para nosotros, antes que empezar a participar en procesos de selección que ya están en marcha. Va a realizar la propuesta a sus superiores",
"Relacion_Concluida", "2023-10-8", 8),
("2024-9-23", "2024-11-25", null, null, null, null, null, null, "2023-10-9", 9),
("2024-9-16", "2024-9-24", "2024-10-18", null, null, "Respuesta_Pospuesta",
"Tras reunión y presentación se les envía correo y responden que están valorando próximo contacto en mayo.", null, "2023-10-11", 10),
("2024-10-21", null, null, null, null, null, null, null, "2023-10-11", 11),
("2024-10-21", "2025-04-15", null, null, null, null, null, null, null, 12),
("2024-9-4", "2024-10-21", null, null, null, null, null, null, null, 13),
("2024-10-24", null, null, null, null, null, null, null, null, 14),
("2023-10-26", "2024-10-24", null, null, "2º contacto propuesta prácticas", null, null, null, null, 15),
("2024-10-23", null, null, null, "Propuesta Practicas / CEE", null, null, null, null, 16),
("2024-10-24", null, null, null, "Actualmente no es posible acoger prácticas", null, null, null, null, 17),
(null, null, null, null, null, null, null, null, null, 18),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 19),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 20),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 21),
("2024-10-24", null, null, null, null, null, null, null, null, 21),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 23),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 24),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 25),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 26),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 27),
("2024-10-24", null, null, null, "Propuesta de prácticas", null, null, null, null, 28),
("2024-10-24", "2024-11-6", null, null, null, null, null, null, null, 29),
("2024-10-24", null, null, null, null, null, null, null, null, 30),
("2024-10-24", null, null, null, null, null, null, null, null, 31),
("2024-10-30", "2024-11-6", null, null, null, null, null, null, null, 32),
("2024-11-6",  null, null, null, null, null, null, null, null, 33),
("2024-10-29", "2024-12-3", null, null, null, null, null, null, null, 34),
("2024-10-30", "2024-11-18", null, null, null, null, null, null, null, 35),
("2024-10-31", null, null, null, null, null, null, null, null, 36);

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

INSERT INTO PERSONA VALUES
();

CREATE TABLE ANALISISPUESTO(
	EMPRESA VARCHAR(100) PRIMARY KEY,
    PUESTO VARCHAR(50) NOT NULL,
    HORARIO VARCHAR(150) NOT NULL,
    FINDE ENUM("Si", "SoloSabados", "SoloDomingos", "No") NOT NULL,
    TURNOS BOOLEAN NOT NULL,
    MIN_FORMACION ENUM('AT', 'Primaria', 'ESO', 'EPA', 'FP_Basica', 'GM', 'Bachillerato', 'GS', 'Universidad', 'Master', 'Doctorado') NOT NULL,
    UBICACION VARCHAR(150) NOT NULL,
	SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio', 'Energia_MedioAmbiente',
    'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing', 'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas',
    'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones', 'Turismo_Hosteleria', 'Vida') NOT NULL,
    REQ_IDIOMAS VARCHAR(50) NOT NULL,
	CONTACTOEMPRESA VARCHAR(50) NOT NULL,
    CARGO VARCHAR(50) NOT NULL,
    TELEFONO VARCHAR(20) NOT NULL,
    EMAIL VARCHAR(50) NOT NULL,
    RESPONSABLEAPNABI VARCHAR(50) NOT NULL,
    ESFUERZOFISICO BOOLEAN NOT NULL,
    RESISTENCIA BOOLEAN NOT NULL,
    COMUNICACION ENUM("SinNecesidadComunicacion", "ComunicacionConPersonalEmpesa", "ComunicacionConPersonasExternasEmpresa",
    "ComunicacionConPersonalEmpresa_FueraEmpresa") NOT NULL,
    SENSORIALES ENUM("Ruido", "Luz", "Orden", "Limpieza") NOT NULL
);

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
