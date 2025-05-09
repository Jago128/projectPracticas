package model;

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
		this.especialidadTecnicoSuperior = Especialidad_TecnicoSuperior.UNSET;
		this.especialidadTecnicoSuperiorMantenimientoAeromecanico = Especialidad_TecnicoSuperior_MantenimietoAeromecanico.UNSET;
		// this.especialidadGrado = especialidadGrado;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApoyo() {
		return apoyo;
	}

	public void setApoyo(String apoyo) {
		this.apoyo = apoyo;
	}

	public Formacion getFormacion() {
		return formacion;
	}

	public void setFormacion(Formacion formacion) {
		this.formacion = formacion;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public Especialidad_TecnicoSuperior getEspecialidadTecnicoSuperior() {
		return especialidadTecnicoSuperior;
	}

	public void setEspecialidadTecnicoSuperior(Especialidad_TecnicoSuperior especialidadTecnicoSuperior) {
		this.especialidadTecnicoSuperior = especialidadTecnicoSuperior;
	}

	public Especialidad_TecnicoSuperior_MantenimietoAeromecanico getEspecialidadTecnicoSuperiorMantenimientoAeromecanico() {
		return especialidadTecnicoSuperiorMantenimientoAeromecanico;
	}

	public void setEspecialidadTecnicoSuperiorMantenimientoAeromecanico(
			Especialidad_TecnicoSuperior_MantenimietoAeromecanico especialidadTecnicoSuperiorMantenimientoAeromecanico) {
		this.especialidadTecnicoSuperiorMantenimientoAeromecanico = especialidadTecnicoSuperiorMantenimientoAeromecanico;
	}

	public Especialidad_Grado getEspecialidadGrado() {
		return especialidadGrado;
	}

	public void setEspecialidadGrado(Especialidad_Grado especialidadGrado) {
		this.especialidadGrado = especialidadGrado;
	}

	public Especialidad_Grado_Abierto getEspecialidadGradoAbierto() {
		return especialidadGradoAbierto;
	}

	public void setEspecialidadGradoAbierto(Especialidad_Grado_Abierto especialidadGradoAbierto) {
		this.especialidadGradoAbierto = especialidadGradoAbierto;
	}

	public SectorInteres getSectorInteres() {
		return sectorInteres;
	}

	public void setSectorInteres(SectorInteres sectorInteres) {
		this.sectorInteres = sectorInteres;
	}

	public String getCvLink() {
		return cvLink;
	}

	public void setCvLink(String cvLink) {
		this.cvLink = cvLink;
	}

	public Discapacidad getCerfificadoDiscapacidad() {
		return cerfificadoDiscapacidad;
	}

	public void setCerfificadoDiscapacidad(Discapacidad cerfificadoDiscapacidad) {
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
	}

	public String getOtrosIdiomas() {
		return otrosIdiomas;
	}

	public void setOtrosIdiomas(String otrosIdiomas) {
		this.otrosIdiomas = otrosIdiomas;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Accesibilidad getAccesibilidad() {
		return accesibilidad;
	}

	public void setAccesibilidad(Accesibilidad accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
}
