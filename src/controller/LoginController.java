package controller;

import java.util.Map;

import model.*;
import windows.VentanaLogin;

public class LoginController {
	ApnabiDAO dao = new BDImplementacion();
	
	public void showWindow() {
		VentanaLogin dialog = new VentanaLogin();
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
	
	public boolean modificarDatosContacto(String datos) {
		return dao.modificarDatosContacto(datos);
	}
	
	public boolean modificarContactoEmpresa(String contactoE) {
		return dao.modificarContactoEmpresa(contactoE);
	}
	
	public boolean modificarPersonaContacto(String personaC) {
		return dao.modificarPersonaContacto(personaC);
	}
	
	public boolean modificarEstado(Estado estado) {
		return dao.modificarEstado(estado);
	}
	
	public boolean modificarContacto1(String contacto1) {
		return dao.modificarContacto1(contacto1);
	}
	
	public boolean modificarContacto2(String contacto2) {
		return dao.modificarContacto2(contacto2);
	}
	
	public boolean modificarContacto3(String contacto3) {
		return dao.modificarContacto3(contacto3);
	}
	
	public boolean modificarContacto4(String contacto4) {
		return dao.modificarContacto4(contacto4);
	}
	
	public boolean modificarObservaciones(String observaciones) {
		return dao.modificarObservaciones(observaciones);
	}
	
	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}
}
