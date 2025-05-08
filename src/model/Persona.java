package model;

import java.net.URL;

import enums.*;

public class Persona {
	private String nombre;
	private String apoyo;
	private Formacion formacion;
	private Especialidad especialidad;
	private Especialidad_TecnicoSuperior especialidadTecnicoSuperior;
	private Especialidad_TecnicoSuperior_MantenimietoAeromecanico especialidadTecnicoSuperiorMantenimientoAeromecanico;
	private Especialidad_Grado especialidadGrado;
	private Especialidad_Grado_Abierto especialidadGradoAbierto;
	private SectorInteres sectorInteres; // TBD
	private String cvLink;
	private Discapacidad cerfificadoDiscapacidad;
	private String otrosIdiomas;
	private Municipio municipio;
	private Accesibilidad accesibilidad;
	private String observaciones;
	
	public Persona() {
		this.nombre = "";
		this.apoyo = "";
		this.formacion = Formacion.UNSET;
		this.especialidad = Especialidad.UNSET;
		this.especialidadTecnicoSuperior = especialidadTecnicoSuperior;
		this.especialidadTecnicoSuperiorMantenimientoAeromecanico = Especialidad_TecnicoSuperior_MantenimietoAeromecanico.UNSET;
		this.especialidadGrado = especialidadGrado;
		this.especialidadGradoAbierto = Especialidad_Grado_Abierto.UNSET;
		this.sectorInteres = SectorInteres.UNSET;
		this.cvLink = "";
		this.cerfificadoDiscapacidad = Discapacidad.UNSET;
		this.otrosIdiomas = "";
		this.municipio = Municipio.UNSET;
		this.accesibilidad = Accesibilidad.UNSET;
		this.observaciones = "";
	}

	public Persona(String nombre, String apoyo, Formacion formacion, Especialidad especialidad,
			SectorInteres sectorInteres, String cvLink, Discapacidad cerfificadoDiscapacidad, String otrosIdiomas,
			Municipio municipio, Accesibilidad accesibilidad, String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidad = especialidad;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.otrosIdiomas = otrosIdiomas;
		this.municipio = municipio;
		this.accesibilidad = accesibilidad;
		this.observaciones = observaciones;
	}

	public Persona(String nombre, String apoyo, Formacion formacion,
			Especialidad_TecnicoSuperior especialidadTecnicoSuperior, SectorInteres sectorInteres, String cvLink,
			Discapacidad cerfificadoDiscapacidad, String otrosIdiomas, Municipio municipio, Accesibilidad accesibilidad,
			String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidadTecnicoSuperior = especialidadTecnicoSuperior;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.otrosIdiomas = otrosIdiomas;
		this.municipio = municipio;
		this.accesibilidad = accesibilidad;
		this.observaciones = observaciones;
	}

	public Persona(String nombre, String apoyo, Formacion formacion,
			Especialidad_TecnicoSuperior_MantenimietoAeromecanico especialidadTecnicoSuperiorMantenimientoAeromecanico,
			SectorInteres sectorInteres, String cvLink, Discapacidad cerfificadoDiscapacidad, String otrosIdiomas,
			Municipio municipio, Accesibilidad accesibilidad, String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidadTecnicoSuperiorMantenimientoAeromecanico = especialidadTecnicoSuperiorMantenimientoAeromecanico;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.otrosIdiomas = otrosIdiomas;
		this.municipio = municipio;
		this.accesibilidad = accesibilidad;
		this.observaciones = observaciones;
	}

	public Persona(String nombre, String apoyo, Formacion formacion, Especialidad_Grado especialidadGrado,
			SectorInteres sectorInteres, String cvLink, Discapacidad cerfificadoDiscapacidad, String otrosIdiomas,
			Municipio municipio, Accesibilidad accesibilidad, String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidadGrado = especialidadGrado;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.otrosIdiomas = otrosIdiomas;
		this.municipio = municipio;
		this.accesibilidad = accesibilidad;
		this.observaciones = observaciones;
	}

	public Persona(String nombre, String apoyo, Formacion formacion,
			Especialidad_Grado_Abierto especialidadGradoAbierto, SectorInteres sectorInteres, String cvLink,
			Discapacidad cerfificadoDiscapacidad, String otrosIdiomas, Municipio municipio, Accesibilidad accesibilidad,
			String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidadGradoAbierto = especialidadGradoAbierto;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.otrosIdiomas = otrosIdiomas;
		this.municipio = municipio;
		this.accesibilidad = accesibilidad;
		this.observaciones = observaciones;
	}
	
}
