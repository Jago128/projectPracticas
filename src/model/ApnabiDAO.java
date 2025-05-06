package model;

import java.util.Map;

public interface ApnabiDAO {
	//Usuarios
	public boolean verificarUsuario(Usuario user);
	
	public boolean verificarContraseñaUsuario(Usuario user);
	
	public boolean verificarTipoUsuario(Usuario user);
	
	public Usuario getUsuario(Usuario user);
	
	public boolean registrarUsuario(Usuario user);
	
	//Empresas
	public Map<String, Empresa> mostrarEmpresas();
	
	public Empresa getEmpresa(String nom);

	public boolean añadirEmpresa(Empresa emp);
	
	public boolean modificarDatosContacto(String datos);
	
	public boolean modificarContactoEmpresa(String contactoE);
	
	public boolean modificarPersonaContacto(String personaC);
	
	public boolean modificarEstado(Estado estado);
	
	public boolean modificarContacto1(String contacto1);
	
	public boolean modificarContacto2(String contacto2);
	
	public boolean modificarContacto3(String contacto3);
	
	public boolean modificarContacto4(String contacto4);
	
	public boolean modificarObservaciones(String observaciones);
	
	public boolean eliminarEmpresa(String nom);
}
