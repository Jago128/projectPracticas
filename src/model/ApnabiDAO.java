package model;

import java.util.Map;

public interface ApnabiDAO {
	//Usuarios
	public boolean verificarUsuario(Usuario user);
	
	public boolean verificarContraseñaUsuario(Usuario user);
	
	public boolean verificarTipoUsuario(Usuario user);
	
	public boolean registrarUsuario(Usuario user);
	
	//Empresas
	public Map<String, Empresa> mostrarEmpresas();
	
	public Empresa getEmpresa(String nom);

	public boolean añadirEmpresa(Empresa emp);
	
	public boolean modificarEmpresa(String datos, String contactoE, String personaC, String estado, String contacto1, String contacto2, String contacto3, String contacto4, String observaciones);
	
	public boolean eliminarEmpresa(String nom);
}
