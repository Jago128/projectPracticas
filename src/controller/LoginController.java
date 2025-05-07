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

	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}

	public boolean modificarContacto1(String contacto1, int id) {
		return dao.modificarContacto1(contacto1, id);
	}

	public boolean modificarContacto2(String contacto2, int id) {
		return dao.modificarContacto2(contacto2, id);
	}

	public boolean modificarContacto3(String contacto3, int id) {
		return dao.modificarContacto3(contacto3, id);
	}

	public boolean modificarContacto4(String contacto4, int id) {
		return dao.modificarContacto4(contacto4, id);
	}

	public boolean modificarObservaciones(String observaciones, int id) {
		return dao.modificarObservaciones(observaciones, id);
	}

	public boolean modificarResultadoUltimoContacto(String resultadoU, int id) {
		return dao.modificarResultadoUltimoContacto(resultadoU, id);
	}

	public boolean modificarInformacionUltimoContacto(String infoU, int id) {
		return dao.modificarInformacionUltimoContacto(infoU, id);
	}

	public boolean modificarResultadoFinal(String resultadoF, int id) {
		return dao.modificarResultadoFinal(resultadoF, id);
	}

	public boolean modificarFechaResolucion(String fecResolucion, int id) {
		return dao.modificarFechaResolucion(fecResolucion, id);
	}
}
