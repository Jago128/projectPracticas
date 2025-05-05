package controller;

import java.sql.Date;
import java.util.Map;

import model.*;
import windows.LoginWindow;

public class LoginController {
	ApnabiDAO dao = new BDImplementacion();
	
	public void showWindow() {
		LoginWindow dialog = new LoginWindow();
		dialog.setVisible(true);
	}
	
	public boolean verificarUsuario(Usuario user) {
		return dao.verificarUsuario(user);
	}
	
	public boolean verificarContraseñaUsuario(Usuario user) {
		return dao.verificarContraseñaUsuario(user);
	}
	
	public boolean verificarTipoUsuario(Usuario user) {
		return dao.verificarTipoUsuario(user);
	}
	
	public boolean registrarUsuario(Usuario user) {
		return dao.registrarUsuario(user);
	}
	
	public Usuario getUsuario(Usuario user) {
		return dao.getUsuario(user);
	}
	
	public Map<String, Empresa> mostrarEmpresas() {
		return dao.mostrarEmpresas();
	}
	
	public Empresa getEmpresa(String nom) {
		return dao.getEmpresa(nom);
	}

	public boolean añadirEmpresa(Empresa emp) {
		return dao.añadirEmpresa(emp);
	}
	
	//Parametros por poner en este
	public boolean modificarEmpresa(String datos, String contactoE, String personaC, Estado estado, Date contacto1, Date contacto2, Date contacto3, Date contacto4, String observaciones) {
		return dao.modificarEmpresa(datos, contactoE, personaC, estado, contacto1, contacto2, contacto3, contacto4, observaciones);
	}
	
	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}
}
