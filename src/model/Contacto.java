package model;

import enums.ResultadoFinal;
import enums.ResultadoUltimoContacto;

public class Contacto {
	private String emp_Nom;
	private String contacto1;
	private String contacto2;
	private String contacto3;
	private String contacto4;
	private String observaciones;
	private ResultadoUltimoContacto resultadoUltimoContacto;
	private String infoUltimo;
	private ResultadoFinal resultadoFinal;
	private String fechaResolucion;

	public Contacto() {
		this.emp_Nom = "";
		this.contacto1 = "";
		this.contacto2 = "";
		this.contacto3 = "";
		this.contacto4 = "";
		this.observaciones = "";
		this.resultadoUltimoContacto = ResultadoUltimoContacto.UNSET;
		this.infoUltimo = "";
		this.resultadoFinal = ResultadoFinal.UNSET;
		this.fechaResolucion = "";
	}

	public Contacto(String emp_Nom, String contacto1, String contacto2, String contacto3, String contacto4, String observaciones,
			ResultadoUltimoContacto resultadoUltimoContacto, String infoUltimo, ResultadoFinal resultadoFinal,
			String fechaResolucion) {
		this.emp_Nom = emp_Nom;
		this.contacto1 = contacto1;
		this.contacto2 = contacto2;
		this.contacto3 = contacto3;
		this.contacto4 = contacto4;
		this.observaciones = observaciones;
		this.resultadoUltimoContacto = resultadoUltimoContacto;
		this.infoUltimo = infoUltimo;
		this.resultadoFinal = resultadoFinal;
		this.fechaResolucion = fechaResolucion;
	}

	public String getEmp_Nom() {
		return emp_Nom;
	}

	public void setEmp_Nom(String emp_Nom) {
		this.emp_Nom = emp_Nom;
	}

	public String getContacto1() {
		return contacto1;
	}

	public void setContacto1(String contacto1) {
		this.contacto1 = contacto1;
	}

	public String getContacto2() {
		return contacto2;
	}

	public void setContacto2(String contacto2) {
		this.contacto2 = contacto2;
	}

	public String getContacto3() {
		return contacto3;
	}

	public void setContacto3(String contacto3) {
		this.contacto3 = contacto3;
	}

	public String getContacto4() {
		return contacto4;
	}

	public void setContacto4(String contacto4) {
		this.contacto4 = contacto4;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public ResultadoUltimoContacto getResultadoUltimoContacto() {
		return resultadoUltimoContacto;
	}

	public void setResultadoUltimoContacto(ResultadoUltimoContacto resultadoUltimoContacto) {
		this.resultadoUltimoContacto = resultadoUltimoContacto;
	}

	public String getInfoUltimo() {
		return infoUltimo;
	}

	public void setInfoUltimo(String infoUltimo) {
		this.infoUltimo = infoUltimo;
	}

	public ResultadoFinal getResultadoFinal() {
		return resultadoFinal;
	}

	public void setResultadoFinal(ResultadoFinal resultadoFinal) {
		this.resultadoFinal = resultadoFinal;
	}

	public String getFechaResolucion() {
		return fechaResolucion;
	}

	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}
}
