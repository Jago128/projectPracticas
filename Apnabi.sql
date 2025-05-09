CREATE DATABASE APNABI;
USE APNABI;

CREATE TABLE USUARIO (
	NOMBRE VARCHAR(30) PRIMARY KEY,
    CONTRASEÑA VARCHAR(50) NOT NULL
);

CREATE TABLE EMPRESA (
    COD_EMPRESA INT PRIMARY KEY AUTO_INCREMENT,
    NOM_EMPRESA VARCHAR(100) UNIQUE NOT NULL,
    SECTOR ENUM('Agricultura_Ganaderia', 'BienesConsumo', 'ComercioElectronico', 'Comercio_Establecimientos', 'Construccion', 'Deporte_Ocio',
	'Energia_MedioAmbiente', 'Finanzas_Seguros_BienesInmuebles', 'Internet', 'Logistica_Transporte', 'MediosComunicacion_Marketing',
    'Metalurgia_Electronica', 'ProductosQuimicos_MateriasPrimas', 'Salud_IndustriaFarmaceutica', 'Servicios', 'Sociedad', 'Tecnologia_Telecomunicaciones',
    'Turismo_Hosteleria', 'Vida') NOT NULL,
    PUESTO VARCHAR(30),
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
    APOYO VARCHAR(30) NOT NULL,
    FORMACION ENUM('AT', 'Primaria', 'ESO', 'EPA', 'FP_Basica', 'GM', 'Bachillerato', 'GS', 'Universidad', 'Master', 'Doctorado') NOT NULL,
    ESPECIALIDAD ENUM("GradoAbierto", "CienciasSociales_Juridicas", "Ingenieria_Industrial", "Ingenierias",
    "TécnicoSuperiorEnMantenimientoAeromecánicoAvionesConMotor_Pistón", "TecnicoSuperiorMantenimientoAeromecanicoDeAvionesConMotor_Turbina",
    "TecnicoSuperiorMantenimientoAeromecanicoDeHelicópterosConMotor_Pistón", "TecnicoSuperiorMantenimientoAeromecanicoDeHelicópterosConMotor_Turbina",
    "Acceso_ConservacionEnInstalacionesDeportivas", "InformaticaOficina", "ServiciosAdministrativos",
	"ActividadesAgropecuarias", "AgroJardineria_ComposicionesFlorales", "AprovechamientosForestales", "ArtesGraficas",
	"ServiciosComerciales", "Reforma_MantenimientoDeEdificios", "Electricidad_Electronica", "FabricacionElementosMetalicos",
	"InstalacionesElectrotecnicas_Mecanica", "Fabricacion_Montaje", "ActividadesPanaderia_Pasteleria", "Alojamiento_Lavanderia",
	"Cocina_Restauracion, Peluqueria_Estetica", "IndustriasAlimentarias, Informatica_Comunicaciones",
	"MantenimientoViviendas", "Carpinteria_Mueble", "ActividadesMaritimoPesqueras",
	"MantenimientoEmbarcacionesDeportivas_Recreo", "ActividadesDomesticas_LimpiezaEdificios",
	"Arreglo_ReparacionArticulosTextiles_Piel", "Tapiceria_Cortinaje", "MantenimientoVehiculos", "Vidrieria_Alfareria",
	"ActividadesEcuestres", "GuiaEnElMedioNatural_TiempoLibre, GestionAdministrativa",
	"Aprovechamiento_ConservacionMedio_Natural", "Jardineria_Floristeria", "ProduccionAgroecologica", "ProduccionAgropecuaria",
	"ImpresionGrafica", "Postimpresion_AcabadosGraficos", "PreimpresionDigital", "ActividadesComerciales",
	"ComercializacionProductosAlimentarios", "Construccion", "ObrasInterior_Decoracion_Rehabilitacion",
	"InstalacionesElectricas_Automaticas", "InstalacionesTelecomunicaciones", "Redes_EstacionesTratamientoAguas",
	"ConformadoPorMoldeoMetales_Polimeros","Mecanizado", "MontajeEstructuras_InstalacionSistemasAeronauticos",
	"Soldadura_Caldereria", "Cocina_Gastronomia", "ServiciosRestauracion, Estetica_Belleza", "Peluqueria_CosmeticaCapilar",
	"VideoDiscJockey_Sonido", "Hosteleria_Turismo", "ElaboracionProductosAlimenticios", "Panaderia_Reposteria_Confiteria",
	"Excavaciones_Sondeos", "PiedraNatural", "SistemasMicroinformaticos_Redes", "InstalacionesFrigorificas_Climatizacion",
	"InstalacionesProduccionCalor", "MantenimientoElectromecanico", "Instalacion_Amueblamiento",
	"Procesado_TransformacionMadera", "CultivosAcuicolas", "Mantenimiento_ControlMaquinariaBuques_Embarcaciones",
	"Navegacion_PescaLitoral", "OperacionesSubacuaticas_Hiperbaricas", "OperacionesLaboratorio, PlantaQuimica",
	"EmergenciasSanitarias", "Farmacia_Parafarmacia", "Emergencias_ProteccionCivil, Seguridad",
	"AtencionPersonasSituacionDependencia", "Calzado_ComplementosModa", "Confeccion_Moda",
	"Fabricacion_EnnoblecimientoProductosTextiles", "Carroceria", "ConduccionVehiculosTransportePorCarretera",
	"ElectromecanicaMaquinaria", "ElectromecanicaVehiculosAutomoviles", "MantenimientoEmbarcacionesRecreo",
	"MantenimientoEstructurasMadera_MobiliarioEmbarcacionesRecreo", "MantenimientoMaterialRodanteFerroviario",
	"MontajeEstructurasInstalacionSistemasAeronauticos", "FabricacionProductosCeramicos", "IngenieriaElectronica",
    "AcondicionamientoFisico", "Enseñanza_AnimacionSociodeportiva", "Administracion_Finanzas", "AsistenciaA_LaDireccion",
	"Ganaderia_AsistenciaSanidadAnimal", "GestionForestal_MedioNatural", "Paisajismo_MedioRural",
	"Diseño_EdicionPublicacionesImpresas_Multimedia", "Diseño_Gestion_ProduccionGrafica",
	"ArtistaFallero_ConstruccionEscenografias", "ComercioInternacional", "GestionVentas_EspaciosComerciales",
	"Marketing_Publicidad", "Transporte_Logistica", "Organizacion_ControlObrasConstruccion", "ProyectosEdificacion",
	"ProyectosObraCivil", "Automatizacion_RoboticaIndustrial", "ElectromedicinaClinica", "MantenimientoElectronico",
	"SistemasElectrotecnicos_Automatizados", "SistemasTelecomunicaciones_Informaticos", "CentralesElectricas",
	"EficienciaEnergetica_EnergiaSolarTermica", "EnergiasRenovables", "GestionAgua", "ConstruccionesMetalicas",
	"DiseñoFabricacionMecanica", "ProgramacionProduccionFabricacionMecanica", "ProgramacionProduccionMoldeoMetales_Polimeros",
	"AgenciasViajes_GestionEventos", "DireccionCocina", "DireccionServiciosRestauracion", "GestionAlojamientosTuristicos",
	"Guia_Informacion_AsistenciasTuristicas", "AsesoriaImagenPersonal_Corporativa", "Caracterizacion_MaquillajeProfesional",
	"Estilismo_DireccionPeluqueria", "EsteticaIntegral_Bienestar", "Termalismo_Bienestar",
	"Animaciones3D_Juegos_Entornos_Interactivos", "Iluminacion_Captacion_TratamientoImagen",
	"ProduccionAudiovisuales_Espectaculos", "RealizacionProyectosAudiovisuales_Espectaculos",
	"SonidoParaAudiovisuales_Espectaculos", "Procesos_CalidadIndustriaAlimentaria", "Vitivinicultura",
	"AdministracionSistemasInformaticosRed", "DesarrolloAplicacionesMultiplataforma", "DesarrolloAplicacionesWeb",
	"DesarrolloProyectosInstalacionesTermicas_Fluidos", "MantenimientoInstalacionesTermicas_Fluidos", "MecatronicaIndustrial",
	"Diseño_Amueblamiento", "Acuicultura2", "OrganizacionMantenimientoMaquinariaBuques_Embarcaciones",
	"TransporteMaritimo_PescaAltura", "FabricacionProductosFarmaceuticos_Biotecnologicos_Afines",
	"LaboratorioAnalisis_ControlCalidad", "QuimicaIndustrial", "AnatomiaPatologicaCitodiagnostico", "AudiologiaProtesica",
	"Documentacion_AdministracionSanitarias", "HigieneBucodental", "ImagenParaDiagnostico_MedicinaNuclear",
	"LaboratorioClinico_Biomedico", "Ortoprotesis_ProductosApoyo", "ProtesisDentales", "Radioterapia_Dosimetria",
	"CoordinacionEmergencias_ProteccionCivil", "Educacion_ControlAmbiental", "Quimica_SaludAmbiental",
	"AnimacionSociocultural_Turistica", "EducacionInfantil", "FormacionParaMovilidadSegura_Sostenible", "IntegracionSocial",
	"MediacionComunicativa", "PromocionIgualdadGenero", "DiseñoTecnicoTextil_Piel", "Diseño_ProduccionCalzado_Complementos",
	"Patronaje_Moda, VestuarioMedida_de_Espectaculos", "Automocion", "Desarrollo_FabricacionProductosCeramicos",
	"MantenimientoSistemasElectronicos_AvionicosAeronaves", "TecnicoCuidadosAuxiliaresEnfermeria"),
    SECTORINTERES ENUM(""),
    CV VARCHAR(999),
    DISCAPACIDAD ENUM('Si', 'No', 'No_Sabe', 'Tramitando'),
    EUSKERA ENUM('A1', 'A2', 'B1', 'B2', 'C1', 'C2', 'Conocimiento_NoAcreditado'),
    INGLES ENUM('A1', 'A2', 'B1', 'B2', 'C1', 'C2', 'Conocimiento_NoAcreditado'),
    OTROSIDIOMAS VARCHAR(50),
    LOCALIDAD ENUM('Abadiño', 'Abanto_Zierbena', 'Ajangiz', 'Alonsotegi', 'Amorebieta', 'Amoroto', 'Amurrio', 'Arakaldo', 'Arantzazu', 'Areatza_Bilaro', 'Arrankudiaga',
    'Arratzu', 'Arrieta', 'Arrigorriaga', 'Artzentales', 'Artziniega', 'Aulesti', 'Axpeatxondo', 'Ayala_Aiara', 'Bakio', 'Balmaseda', 'Barakaldo', 'Barrika', 'Basauri',
    'Bedia', 'Berango', 'Bermeo', 'Berriatua', 'Berriz', 'Bilbao', 'Busturia', 'CastroUrdiales', 'Galdakao', 'Galdames', 'GamizFika', 'Garai', 'Gatika', 'Gautegiz',
    'GazteluElexabeitia_Arteaga', 'GernikaLumo', 'Getxo', 'Gizaburuaga', 'Gordexola', 'Gorliz', 'Gueñes', 'Ibarrangelu', 'Igorre', 'Ispaster', 'Iurreta', 'Izurtza',
    'KarrantzaHarana', 'Kortezubi', 'Lanestosa', 'Larrabetzu', 'Laudio_Llodio', 'Laukiz', 'Leioa', 'Lekeitio', 'Lemoa', 'Lemoiz', 'Lezama', 'Loiu', 'Lallabia', 'Mañaria',
    'MarkinaXemein', 'Maruri', 'Mendata', 'Mendexa', 'Meñaka', 'Morga', 'Mundaka', 'Mungia', 'MunitibArarbatzegi_Gerrikaitz', 'Murueta', 'Muskiz', 'Muxika', 'Nabarniz',
    'Ondarroa', 'Orduña', 'Orozko', 'Ortuella', 'Otxandio', 'Plentzia', 'Portugalete', 'Santurtzi', 'Sestao', 'Sondika', 'Sopela', 'Sopuerta', 'Sukarrieta', 'Trapagaran',
    'Turtzioz', 'Ubide', 'UgaoMiraballes', 'Urduliz', 'Urduña', 'Usansolo', 'Zaldibar', 'Zalla', 'Zamudio', 'Zaratamo', 'Zeanuri', 'Zeberio', 'Zierbena', 'Ziortza_Bolibar',
    'Zornotza'),
    ACCESIBILIDAD ENUM('Carnet_Coche', 'Carnet', 'Transporte_Publico'),
    OBSERVACIONES VARCHAR(500)
);

INSERT INTO USUARIO VALUES
("Test", "e"),
("w","1");

INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES
("Deportes Urbanos de Exterior S.L", "Deporte_Ocio", "Almacen", "info@deportesurbanos.com", "???", "Selene", "Informado"),
("Grupo Cofares", "Logistica_Transporte", "Almacen","vcuesta@cofares.es", "Virginia", "Alba", "Valorando_Interesado"),
("SEIDOR", "Internet", null, "LinkedIn", "Aida Morales Sedano", "Selene", "Informado");

INSERT INTO CONTACTO (CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMPRESA) VALUES
("2024-10-23", null, null, null, null, "Comunicacion_SinRespuesta", "Reunión el 08/05/2025", null, null, 1),
("2024-09-16", "2024-09-24", "2024-10-18", null, null, "Respuesta_Pospuesta", "Tras reunión y presentación se les envía correo y responden que están valorando próximo contacto en mayo.", null, "2023-10-11", 2),
("2024-10-23", null, null, null, "Propuesta de prácticas","Reunion_Programada","5 de mayo firma de convenio en oficinas de apnabi.","Convenio_Colaboracion", "2023-10-6", 3);