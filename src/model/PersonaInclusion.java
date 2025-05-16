package model;

import enums.*;

public class PersonaInclusion {
	private String nombre;
	private String apellido;
	private int edad;
	private Localidad municipio;
	private Formacion formacion;
	private String especialidad;
	private String otros;
	private String idioma;
	private int ultimoAñoTrabajado;
	private Sector sectorInteres;
	private String interesesPersonales;
	private String situacionActual;
	private Accesibilidad accesibilidad;
	private String cv;
	private String personaFacilitadora;

	public PersonaInclusion() {
		this.nombre = "";
		this.apellido = "";
		this.edad = 0;
		this.municipio = Localidad.UNSET;
		this.formacion = Formacion.UNSET;
		this.especialidad = "";
		this.otros = "";
		this.idioma = "";
		this.ultimoAñoTrabajado = 0;
		this.sectorInteres = Sector.UNSET;
		this.interesesPersonales = "";
		this.situacionActual = "";
		this.accesibilidad = Accesibilidad.UNSET;
		this.cv = "";
		this.personaFacilitadora = "";
	}

	public PersonaInclusion(String nombre, String apellido, int edad, Localidad municipio, Formacion formacion,
			String especialidad, String otros, String idioma, int ultimoAñoTrabajado, Sector sectorInteres,
			String interesesPersonales, String situacionActual, Accesibilidad accesibilidad, String cv,
			String personaFacilitadora) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.municipio = municipio;
		this.formacion = formacion;
		this.especialidad = especialidad;
		this.otros = otros;
		this.idioma = idioma;
		this.ultimoAñoTrabajado = ultimoAñoTrabajado;
		this.sectorInteres = sectorInteres;
		this.interesesPersonales = interesesPersonales;
		this.situacionActual = situacionActual;
		this.accesibilidad = accesibilidad;
		this.cv = cv;
		this.personaFacilitadora = personaFacilitadora;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Localidad getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Localidad municipio) {
		this.municipio = municipio;
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

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public int getUltimoAñoTrabajado() {
		return ultimoAñoTrabajado;
	}

	public void setUltimoAñoTrabajado(int ultimoAñoTrabajado) {
		this.ultimoAñoTrabajado = ultimoAñoTrabajado;
	}

	public Sector getSectorInteres() {
		return sectorInteres;
	}

	public void setSectorInteres(Sector sectorInteres) {
		this.sectorInteres = sectorInteres;
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

	public Accesibilidad getAccesibilidad() {
		return accesibilidad;
	}

	public void setAccesibilidad(Accesibilidad accesibilidad) {
		this.accesibilidad = accesibilidad;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPersonaFacilitadora() {
		return personaFacilitadora;
	}

	public void setPersonaFacilitadora(String personaFacilitadora) {
		this.personaFacilitadora = personaFacilitadora;
	}
}
