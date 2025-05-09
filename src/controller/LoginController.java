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

	// Usuarios
	public boolean verificarUsuario(Usuario user) {
		return dao.verificarUsuario(user);
	}

	public boolean verificarContraseñaUsuario(Usuario user) {
		return dao.verificarContraseñaUsuario(user);
	}

	public Usuario getUsuario(Usuario user) {
		return dao.getUsuario(user);
	}

	public boolean registrarUsuario(Usuario user) {
		return dao.registrarUsuario(user);
	}
	
	// Empresas
	public Map<String, Empresa> mostrarEmpresas() {
		return dao.mostrarEmpresas();
	}

	public Map<String, Empresa> mostrarNomEmpresas() {
		return dao.mostrarNomEmpresas();
	}

	public Empresa getEmpresa(String nom) {
		return dao.getEmpresa(nom);
	}
	
	public int getCodEmpresa(String nom) {
		return dao.getCodEmpresa(nom);
	}
	
	public boolean verificarEmpresa(String nom) {
		return dao.verificarEmpresa(nom);
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

	public boolean modificarEstado(String estado, String nom) {
		return dao.modificarEstado(estado, nom);
	}

	public boolean eliminarEmpresa(String nom) {
		return dao.eliminarEmpresa(nom);
	}
	
	// Contactos
	public Contacto getContacto(int empId) {
		return dao.getContacto(empId);
	}
	
	public boolean añadirContacto(Contacto cont, int id) {
		return dao.añadirContacto(cont, id);
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
	
	// Personas
	public Map<String, Persona> mostrarPersonas() {
		return dao.mostrarPersonas();
	}

	public boolean añadirPersona(Persona persona) {
		return dao.añadirPersona(persona);
	}

	public boolean modificarApoyo(String apoyo) {
		return dao.modificarApoyo(apoyo);
	}

	public boolean modificarFormacion(String formacion) {
		return dao.modificarFormacion(formacion);
	}

	public boolean modificarEspecialidad(String especialidad) {
		return dao.modificarEspecialidad(especialidad);
	}

	public boolean modificarCVLink(String link) {
		return dao.modificarCVLink(link);
	}

	public boolean modificarDiscapacidad(String discap) {
		return dao.modificarDiscapacidad(discap);
	}

	public boolean modificarEuskera(String nivel) {
		return dao.modificarEuskera(nivel);
	}

	public boolean modificarIngles(String nivel) {
		return dao.modificarIngles(nivel);
	}

	public boolean modificarOtrosIdiomas(String idioma) {
		return dao.modificarOtrosIdiomas(idioma);
	}

	public boolean modificarLocalidad(String localidad) {
		return dao.modificarLocalidad(localidad);
	}

	public boolean modificarAccesibiliad(String accesibilidad) {
		return dao.modificarAccesibiliad(accesibilidad);
	}

	public boolean modificarObservaciones(String observaciones) {
		return dao.modificarObservaciones(observaciones);
	}
}
