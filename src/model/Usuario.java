package model;

public class Usuario {
	private String nombre;
	private String contraseña;
	private Tipo tipo;

	public Usuario() {
		this.nombre = "";
		this.contraseña = "";
		this.tipo = Tipo.TRABAJADOR;
	}
	
	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.tipo = Tipo.TRABAJADOR;
	}

	public Usuario(String nombre, String contraseña, Tipo tipo) {
		this.nombre = nombre;
		this.contraseña = contraseña;
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [Nombre: "+nombre+", Contraseña: "+contraseña+", Tipo: "+tipo+"]";
	}
}
