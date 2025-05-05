package controller;

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
	public boolean modificarEmpresa(String nom) {
		return dao.modificarEmpresa(nom);
	}
	
	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}
}
