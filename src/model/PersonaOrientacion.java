package model;

import enums.*;

public class PersonaOrientacion {
	private String nombre;
	private String apoyo;
	private Formacion formacion;
	private String especialidad;
	private Sector sectorInteres;
	private String cvLink;
	private Discapacidad cerfificadoDiscapacidad;
	private int ultimoAñoTrabajado;
	private String interesesPersonales;
	private String situacionActual;
	private Euskera euskera;
	private Ingles ingles;
	private String otrosIdiomas;
	private Localidad localidad;
	private Accesibilidad accesibilidad;
	private String observaciones;

	public PersonaOrientacion() {
		this.nombre = "";
		this.apoyo = "";
		this.formacion = Formacion.UNSET;
		this.especialidad = "";
		this.sectorInteres = Sector.UNSET;
		this.cvLink = "";
		this.cerfificadoDiscapacidad = Discapacidad.UNSET;
		this.ultimoAñoTrabajado = 0;
		this.interesesPersonales = "";
		this.situacionActual = "";
		this.euskera = Euskera.UNSET;
		this.ingles = Ingles.UNSET;
		this.otrosIdiomas = "";
		this.localidad = Localidad.UNSET;
		this.accesibilidad = Accesibilidad.UNSET;
		this.observaciones = "";
	}

	public PersonaOrientacion(String nombre, String apoyo, Formacion formacion, String especialidad,
			Sector sectorInteres, String cvLink, Discapacidad cerfificadoDiscapacidad, int ultimoAñoTrabajado,
			String interesesPersonales, String situacionActual, Euskera euskera, Ingles ingles, String otrosIdiomas,
			Localidad localidad, Accesibilidad accesibilidad, String observaciones) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.especialidad = especialidad;
		this.sectorInteres = sectorInteres;
		this.cvLink = cvLink;
		this.cerfificadoDiscapacidad = cerfificadoDiscapacidad;
		this.ultimoAñoTrabajado = ultimoAñoTrabajado;
		this.interesesPersonales = interesesPersonales;
		this.situacionActual = situacionActual;
		this.euskera = euskera;
		this.ingles = ingles;
		this.otrosIdiomas = otrosIdiomas;
		this.localidad = localidad;
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

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Sector getSectorInteres() {
		return sectorInteres;
	}

	public void setSectorInteres(Sector sectorInteres) {
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

	public int getUltimoAñoTrabajado() {
		return ultimoAñoTrabajado;
	}

	public void setUltimoAñoTrabajado(int ultimoAñoTrabajado) {
		this.ultimoAñoTrabajado = ultimoAñoTrabajado;
	}

	public String getInteresesPersonales() {
		return interesesPersonales;
	}

	public void setInteresesPersonales(String interesesPersonales) {
		this.interesesPersonales = interesesPersonales;
	}

	public String getSituacionActual() {
		return situacionActual;
	}

	public void setSituacionActual(String situacionActual) {
		this.situacionActual = situacionActual;
	}

	public Euskera getEuskera() {
		return euskera;
	}

	public void setEuskera(Euskera euskera) {
		this.euskera = euskera;
	}

	public Ingles getIngles() {
		return ingles;
	}

	public void setIngles(Ingles ingles) {
		this.ingles = ingles;
	}

	public String getOtrosIdiomas() {
		return otrosIdiomas;
	}

	public void setOtrosIdiomas(String otrosIdiomas) {
		this.otrosIdiomas = otrosIdiomas;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
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
