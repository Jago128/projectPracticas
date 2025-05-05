package model;

import java.sql.Date;
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
	
	public boolean modificarEmpresa(String datos, String contactoE, String personaC, Estado estado, Date contacto1, Date contacto2, Date contacto3, Date contacto4, String observaciones);
	
	public boolean eliminarEmpresa(String nom);
}
