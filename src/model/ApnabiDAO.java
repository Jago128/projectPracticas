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
	
	//Parametros por poner en este
	public boolean modificarEmpresa(String nom);
	
	public boolean eliminarEmpresa(String nom);
}
