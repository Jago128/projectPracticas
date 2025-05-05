package model;

import java.sql.Date;

public class Empresa {
	private Sector sector;
	private String nom_empresa;
	private String puesto;
	private String datosContacto;
	private String contactoEmpresa;
	private String contactoApnabi;
	private Estado estado;
	private Date contacto1;
	private Date contacto2;
	private Date contacto3;
	private Date contacto4;
	private String observaciones;
	
	public Empresa() {
		this.sector = Sector.UNSET;
		this.nom_empresa = "";
		this.puesto = "";
		this.datosContacto = "";
		this.contactoEmpresa = "";
		this.contactoApnabi = "";
		this.estado = Estado.UNSET;
	}

	public Empresa(Sector sector, String nom_empresa, String puesto, String datosContacto, String contactoEmpresa,
			String contactoApnabi, Estado estado, Date contacto1, String observaciones) {
		this.sector = sector;
		this.nom_empresa = nom_empresa;
		this.puesto = puesto;
		this.datosContacto = datosContacto;
		this.contactoEmpresa = contactoEmpresa;
		this.contactoApnabi = contactoApnabi;
		this.estado = estado;
		this.contacto1 = contacto1;
	}
	
	public Sector getSector() {
		return sector;
	}

	public void setSector(Sector sector) {
		this.sector = sector;
	}

	public String getNom_empresa() {
		return nom_empresa;
	}

	public void setNom_empresa(String nom_empresa) {
		this.nom_empresa = nom_empresa;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(String datosContacto) {
		this.datosContacto = datosContacto;
	}

	public String getContactoEmpresa() {
		return contactoEmpresa;
	}

	public void setContactoEmpresa(String contactoEmpresa) {
		this.contactoEmpresa = contactoEmpresa;
	}

	public String getContactoApnabi() {
		return contactoApnabi;
	}

	public void setContactoApnabi(String contactoApnabi) {
		this.contactoApnabi = contactoApnabi;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Date getContacto1() {
		return contacto1;
	}

	public void setContacto1(Date contacto1) {
		this.contacto1 = contacto1;
	}

	public Date getContacto2() {
		return contacto2;
	}

	public void setContacto2(Date contacto2) {
		this.contacto2 = contacto2;
	}

	public Date getContacto3() {
		return contacto3;
	}

	public void setContacto3(Date contacto3) {
		this.contacto3 = contacto3;
	}

	public Date getContacto4() {
		return contacto4;
	}

	public void setContacto4(Date contacto4) {
		this.contacto4 = contacto4;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	@Override
	public String toString() {
		return "Sector: "+sector+", Empresa: "+nom_empresa+", Puesto en la empresa: "+puesto+", Datos de contacto: "+datosContacto+", Contacto en la empresa: "+contactoEmpresa+", Persona de Contacto: "+contactoApnabi+", Estado: "+estado;
	}
}
