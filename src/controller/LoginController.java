package controller;

import java.util.Map;

import javax.swing.JDialog;

import model.*;
import windows.VentanaLogin;

public class LoginController {
	ApnabiDAO dao = new BDImplementacion();

	public void showWindow() {
		VentanaLogin dialog = new VentanaLogin(new LoginController());
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}

	public boolean verificarUsuario(Usuario user) {
		return dao.verificarUsuario(user);
	}

	public boolean verificarContraseñaUsuario(Usuario user) {
		return dao.verificarContraseñaUsuario(user);
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

	public Map<String, Empresa> mostrarNomEmpresas() {
		return dao.mostrarNomEmpresas();
	}

	public Empresa getEmpresa(String nom) {
		return dao.getEmpresa(nom);
	}

	public boolean añadirEmpresa(Empresa emp) {
		return dao.añadirEmpresa(emp);
	}

	public boolean modificarDatosContacto(String datos, String nom) {
		return dao.modificarDatosContacto(datos, nom);
	}

	public boolean modificarContactoEmpresa(String contactoE, String nom) {
		return dao.modificarContactoEmpresa(contactoE, nom);
	}

	public boolean modificarPersonaContacto(String personaC, String nom) {
		return dao.modificarPersonaContacto(personaC, nom);
	}

	public boolean modificarEstado(Estado estado, String nom) {
		return dao.modificarEstado(estado, nom);
	}

	public boolean modificarContacto1(String contacto1, String nom) {
		return dao.modificarContacto1(contacto1, nom);
	}

	public boolean modificarContacto2(String contacto2, String nom) {
		return dao.modificarContacto2(contacto2, nom);
	}

	public boolean modificarContacto3(String contacto3, String nom) {
		return dao.modificarContacto3(contacto3, nom);
	}

	public boolean modificarContacto4(String contacto4, String nom) {
		return dao.modificarContacto4(contacto4, nom);
	}

	public boolean modificarObservaciones(String observaciones, String nom) {
		return dao.modificarObservaciones(observaciones, nom);
	}

	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}
}
