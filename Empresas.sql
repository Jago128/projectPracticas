CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(30) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL,
    TIPO ENUM('Trabajador', 'Admin') NOT NULL
);

CREATE TABLE EMPRESA (
    NOM_EMPRESA VARCHAR(50) PRIMARY KEY,
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    PUESTO VARCHAR(30) NOT NULL,
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

