CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(30) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL
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
	CONTACTO1 DATE NOT NULL,
    CONTACTO2 DATE,
    CONTACTO3 DATE,
    CONTACTO4 DATE,
    OBSERVACIONES VARCHAR(100)
);

INSERT INTO USUARIO VALUES
("Test", "e");

INSERT INTO EMPRESA VALUES
("Deportes Urbanos de Exterior S.L", "Deporte_Ocio", "Almacen", "info@deportesurbanos.com", "???", "Selene", "Informado", "2024/10/23", null, null, null, null),
("Grupo Cofares", "Logistica_Transporte", "Almacen","vcuesta@cofares.es", "Virginia", "Alba", "Valorando_Interesado", "16/09/2024", "24/09/2024", "18/10/2024", null, null),
("SEIDOR", "Internet", null, "LinkedIn", "Aida Morales Sedano", "Selene", "Informado", "23/10/2024", null, null, null, "Propuesta de prácticas");

