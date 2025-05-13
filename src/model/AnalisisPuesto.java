package model;

import enums.*;

public class AnalisisPuesto {
	private String empresa;
	private String puesto;
	private String horario;
	private Formacion min_Formacion;
	private String ubicacion;
	private Sector sector;
	private String req_idiomas;
	private String contactoEmpresa;
	private String responsableApnabi;
	
	public AnalisisPuesto() {
		this.empresa = "";
		this.puesto = "";
		this.horario = "";
		this.min_Formacion = Formacion.UNSET;
		this.ubicacion = "";
		this.sector = Sector.UNSET;
		this.req_idiomas = "";
		this.contactoEmpresa = "";
		this.responsableApnabi = "";
	}

	public AnalisisPuesto(String empresa, String puesto, String horario, Formacion min_Formacion, String ubicacion,
			Sector sector, String req_idiomas, String contactoEmpresa, String responsableApnabi) {
		this.empresa = empresa;
		this.puesto = puesto;
		this.horario = horario;
		this.min_Formacion = min_Formacion;
		this.ubicacion = ubicacion;
		this.sector = sector;
		this.req_idiomas = req_idiomas;
		this.contactoEmpresa = contactoEmpresa;
		this.responsableApnabi = responsableApnabi;
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

	public String getResponsableApnabi() {
		return responsableApnabi;
	}

	public void setResponsableApnabi(String responsableApnabi) {
		this.responsableApnabi = responsableApnabi;
	}
}
