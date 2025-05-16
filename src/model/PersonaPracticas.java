package model;

import enums.*;

public class PersonaPracticas {
	private String nombre;
	private String apoyo;
	private Formacion formacion;
	private int curso;
	private CentrosFormativos centro;
	private String fechas;
	private String duracion;
	private String empresaPracticas;
	private boolean empresaNuestra;
	
	public PersonaPracticas() {
		this.nombre = "";
		this.apoyo = "";
		this.formacion = Formacion.UNSET;
		this.curso = 1;
		this.centro = CentrosFormativos.UNSET;
		this.fechas = "";
		this.duracion = "";
		this.empresaPracticas = "";
		this.empresaNuestra = false;
	}
	
	public PersonaPracticas(String nombre, String apoyo, Formacion formacion, int curso, CentrosFormativos centro,
			String fechas, String duracion, String empresaPracticas, boolean empresaNuestra) {
		this.nombre = nombre;
		this.apoyo = apoyo;
		this.formacion = formacion;
		this.curso = curso;
		this.centro = centro;
		this.fechas = fechas;
		this.duracion = duracion;
		this.empresaPracticas = empresaPracticas;
		this.empresaNuestra = empresaNuestra;
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

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public CentrosFormativos getCentro() {
		return centro;
	}

	public void setCentro(CentrosFormativos centro) {
		this.centro = centro;
	}

	public String getFechas() {
		return fechas;
	}

	public void setFechas(String fechas) {
		this.fechas = fechas;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getEmpresaPracticas() {
		return empresaPracticas;
	}

	public void setEmpresaPracticas(String empresaPracticas) {
		this.empresaPracticas = empresaPracticas;
	}

	public boolean isEmpresaNuestra() {
		return empresaNuestra;
	}

	public void setEmpresaNuestra(boolean empresaNuestra) {
		this.empresaNuestra = empresaNuestra;
	}
}
