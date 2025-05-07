package model;

import java.util.Map;

public interface ApnabiDAO {
	//Usuarios
	public boolean verificarUsuario(Usuario user);
	
	public boolean verificarContraseñaUsuario(Usuario user);
		
	public Usuario getUsuario(Usuario user);
	
	public boolean registrarUsuario(Usuario user);
	
	//Empresas
	public Map<String, Empresa> mostrarEmpresas();
	
	public Empresa getEmpresa(String nom);

	public boolean añadirEmpresa(Empresa emp);
	
	public boolean modificarDatosContacto(String datos, String nom);
	
	public boolean modificarContactoEmpresa(String contactoE, String nom);
	
	public boolean modificarPersonaContacto(String personaC, String nom);
	
	public boolean modificarEstado(Estado estado, String nom);
	
	public boolean modificarContacto1(String contacto1, String nom);
	
	public boolean modificarContacto2(String contacto2, String nom);
	
	public boolean modificarContacto3(String contacto3, String nom);
	
	public boolean modificarContacto4(String contacto4, String nom);
	
	public boolean modificarObservaciones(String observaciones, String nom);
	
	public boolean eliminarEmpresa(String nom);
}
