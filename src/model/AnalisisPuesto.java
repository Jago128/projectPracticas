package model;

import enums.*;

public class AnalisisPuesto {
	private String empresa;
	private String puesto;
	private String horario;
	private Finde finde;
	private boolean turnos;
	private Formacion min_Formacion;
	private String ubicacion;
	private Sector sector;
	private String req_idiomas;
	private String contactoEmpresa;
	private String cargo;
	private String telefono;
	private String email;
	private String responsableApnabi;
	private boolean esfuerzoFisico;
	private boolean resistencia;
	private Comunicacion comunicacion;
	private Sensoriales CaractersiticasSensoriales;
	
	public AnalisisPuesto() {
		this.empresa = "";
		this.puesto = "";
		this.horario = "";
		this.finde = Finde.UNSET;
		this.turnos = false;
		this.min_Formacion = Formacion.UNSET;
		this.ubicacion = "";
		this.sector = Sector.UNSET;
		this.req_idiomas = "";
		this.contactoEmpresa = "";
		this.cargo = "";
		this.telefono = "";
		this.email = "";
		this.responsableApnabi = "";
		this.esfuerzoFisico = false;
		this.resistencia = false;
		this.comunicacion = Comunicacion.UNSET;
		this.CaractersiticasSensoriales = Sensoriales.UNSET;
	}

	public AnalisisPuesto(String empresa, String puesto, String horario, Finde finde, boolean turnos,
			Formacion min_Formacion, String ubicacion, Sector sector, String req_idiomas, String contactoEmpresa,
			String cargo, String telefono, String email, String responsableApnabi, boolean esfuerzoFisico,
			boolean resistencia, Comunicacion comunicacion, Sensoriales caractersiticasSensoriales) {
		this.empresa = empresa;
		this.puesto = puesto;
		this.horario = horario;
		this.finde = finde;
		this.turnos = turnos;
		this.min_Formacion = min_Formacion;
		this.ubicacion = ubicacion;
		this.sector = sector;
		this.req_idiomas = req_idiomas;
		this.contactoEmpresa = contactoEmpresa;
		this.cargo = cargo;
		this.telefono = telefono;
		this.email = email;
		this.responsableApnabi = responsableApnabi;
		this.esfuerzoFisico = esfuerzoFisico;
		this.resistencia = resistencia;
		this.comunicacion = comunicacion;
		this.CaractersiticasSensoriales = caractersiticasSensoriales;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public Finde getFinde() {
		return finde;
	}

	public void setFinde(Finde finde) {
		this.finde = finde;
	}

	public boolean isTurnos() {
		return turnos;
	}

	public void setTurnos(boolean turnos) {
		this.turnos = turnos;
	}

	public Formacion getMin_Formacion() {
		return min_Formacion;
	}

	public void setMin_Formacion(Formacion min_Formacion) {
		this.min_Formacion = min_Formacion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getReq_idiomas() {
		return req_idiomas;
	}

	public void setReq_idiomas(String req_idiomas) {
		this.req_idiomas = req_idiomas;
	}

	public String getContactoEmpresa() {
		return contactoEmpresa;
	}

	public void setContactoEmpresa(String contactoEmpresa) {
		this.contactoEmpresa = contactoEmpresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResponsableApnabi() {
		return responsableApnabi;
	}

	public void setResponsableApnabi(String responsableApnabi) {
		this.responsableApnabi = responsableApnabi;
	}

	public boolean isEsfuerzoFisico() {
		return esfuerzoFisico;
	}

	public void setEsfuerzoFisico(boolean esfuerzoFisico) {
		this.esfuerzoFisico = esfuerzoFisico;
	}

	public boolean isResistencia() {
		return resistencia;
	}

	public void setResistencia(boolean resistencia) {
		this.resistencia = resistencia;
	}

	public Comunicacion getComunicacion() {
		return comunicacion;
	}

	public void setComunicacion(Comunicacion comunicacion) {
		this.comunicacion = comunicacion;
	}

	public Sensoriales getCaractersiticasSensoriales() {
		return CaractersiticasSensoriales;
	}

	public void setCaractersiticasSensoriales(Sensoriales caractersiticasSensoriales) {
		CaractersiticasSensoriales = caractersiticasSensoriales;
	}
}