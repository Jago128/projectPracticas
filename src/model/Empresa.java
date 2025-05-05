package model;

public class Empresa {
	private Sector sector;
	private String nom_empresa;
	private String puesto;
	private String datosContacto;
	private String contactoEmpresa;
	private String contactoApnabi;
	private Estado estado;
	
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
			String contactoApnabi, Estado estado) {
		this.sector = sector;
		this.nom_empresa = nom_empresa;
		this.puesto = puesto;
		this.datosContacto = datosContacto;
		this.contactoEmpresa = contactoEmpresa;
		this.contactoApnabi = contactoApnabi;
		this.estado = estado;
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

	@Override
	public String toString() {
		return "Sector: "+sector+", Empresa: "+nom_empresa+", Puesto en la empresa: "+puesto+", Datos de contacto: "+datosContacto+", Contacto en la empresa: "+contactoEmpresa+", Persona de Contacto: "+contactoApnabi+", Estado: "+estado;
	}
}
