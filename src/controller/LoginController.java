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

	public boolean eliminarContacto(int id) {
		return dao.eliminarContacto(id);
	}

	// Personas en orientacion y seguimiento
	public Map<String, PersonaOrientacion> mostrarPersonas() {
		return dao.mostrarPersonas();
	}

	public Map<String, PersonaOrientacion> mostrarNomPersonas() {
		return dao.mostrarNomPersonas();
	}

	public PersonaOrientacion getPersona(String nom) {
		return dao.getPersona(nom);
	}

	public boolean verificarPersona(String nom) {
		return dao.verificarPersona(nom);
	}

	public boolean añadirPersona(PersonaOrientacion personaOrientacion) {
		return dao.añadirPersona(personaOrientacion);
	}

	public boolean modificarApoyo(String apoyo, String nom) {
		return dao.modificarApoyo(apoyo, nom);
	}

	public boolean modificarFormacion(String formacion, String nom) {
		return dao.modificarFormacion(formacion, nom);
	}

	public boolean modificarEspecialidad(String especialidad, String nom) {
		return dao.modificarEspecialidad(especialidad, nom);
	}

	public boolean modificarSectorInteres(String sectorI, String nom) {
		return dao.modificarSectorInteres(sectorI, nom);
	}

	public boolean modificarCVLink(String link, String nom) {
		return dao.modificarCVLink(link, nom);
	}

	public boolean modificarDiscapacidad(String discap, String nom) {
		return dao.modificarDiscapacidad(discap, nom);
	}
	
	public boolean modificarUltimoAñoTrabajador(int año, String nom) {
		return dao.modificarUltimoAñoTrabajador(año, nom);
	}
	
	public boolean modificarInteresesPersonales(String intereses, String nom) {
		return dao.modificarInteresesPersonales(intereses, nom);
	}
	
	public boolean modificarSituacionActual(String situacion, String nom) {
		return dao.modificarSituacionActual(situacion, nom);
	}

	public boolean modificarEuskera(String nivel, String nom) {
		return dao.modificarEuskera(nivel, nom);
	}

	public boolean modificarIngles(String nivel, String nom) {
		return dao.modificarIngles(nivel, nom);
	}

	public boolean modificarOtrosIdiomas(String idioma, String nom) {
		return dao.modificarOtrosIdiomas(idioma, nom);
	}

	public boolean modificarLocalidad(String localidad, String nom) {
		return dao.modificarLocalidad(localidad, nom);
	}

	public boolean modificarAccesibilidad(String accesibilidad, String nom) {
		return dao.modificarAccesibilidad(accesibilidad, nom);
	}

	public boolean modificarPersonaObservaciones(String observaciones, String nom) {
		return dao.modificarPersonaObservaciones(observaciones, nom);
	}

	public boolean eliminarPersona(String nom) {
		return dao.eliminarPersona(nom);
	}
	
	// Personas en inclusion
	public Map<String, PersonaInclusion> mostrarPersonasInclusion() {
		return dao.mostrarPersonasInclusion();
	}

	public Map<String, PersonaInclusion> mostrarNomPersonasInclusion() {
		return dao.mostrarNomPersonasInclusion();
	}

	public PersonaInclusion getPersonaInclusion(String nom) {
		return dao.getPersonaInclusion(nom);
	}

	public boolean verificarPersonaInclusion(String nom) {
		return dao.verificarPersonaInclusion(nom);
	}

	public boolean añadirPersonaInclusion(PersonaInclusion pI) {
		return dao.añadirPersonaInclusion(pI);
	}
	
	public boolean modificarEdad(int edad, String nom) {
		return dao.modificarEdad(edad, nom);
	}

	public boolean modificarMunicipio(String municipio, String nom) {
		return dao.modificarMunicipio(municipio, nom);
	}
	
	public boolean modificarFormacionPI(String formacion, String nom) {
		return dao.modificarFormacionPI(formacion, nom);
	}

	public boolean modificarEspecialidadPI(String especialidad, String nom) {
		return dao.modificarEspecialidadPI(especialidad, nom);
	}
	
	public boolean modificarOtros(String otros, String nom) {
		return dao.modificarOtros(otros, nom);
	}
	
	public boolean modificarIdioma(String idioma, String nom) {
		return dao.modificarIdioma(idioma, nom);
	}
	
	public boolean modificarUltimoAñoTrabajadorPI(int año, String nom) {
		return dao.modificarUltimoAñoTrabajadorPI(año, nom);
	}

	public boolean modificarSectorInteresPI(String sectorI, String nom) {
		return dao.modificarSectorInteresPI(sectorI, nom);
	}
	
	public boolean modificarInteresesPersonalesPI(String intereses, String nom) {
		return dao.modificarInteresesPersonalesPI(intereses, nom);
	}
	
	public boolean modificarSituacionActualPI(String situacion, String nom) {
		return dao.modificarSituacionActualPI(situacion, nom);
	}

	public boolean modificarAccesibilidadPI(String accesibilidad, String nom) {
		return dao.modificarAccesibilidadPI(accesibilidad, nom);
	}

	public boolean modificarCV(String link, String nom) {
		return dao.modificarCV(link, nom);
	}
	
	public boolean modificarPersonaFacilitadora(String persona, String nom) {
		return dao.modificarPersonaFacilitadora(persona, nom);
	}
	
	public boolean eliminarPersonaInclusion(String nom) {
		return dao.eliminarPersonaInclusion(nom);
	}

	// Analisis de puestos
	public Map<String, AnalisisPuesto> mostrarAnalisisPuestos() {
		return dao.mostrarAnalisisPuestos();
	}

	public Map<String, AnalisisPuesto> mostrarAPEmpresas() {
		return dao.mostrarAPEmpresas();
	}

	public boolean verificarAP(String nom) {
		return dao.verificarAP(nom);
	}

	public AnalisisPuesto getAnalisisPuesto(String nom) {
		return dao.getAnalisisPuesto(nom);
	}

	public boolean añadirAnalisisPuesto(AnalisisPuesto aP) {
		return dao.añadirAnalisisPuesto(aP);
	}

	public boolean modificarPuesto(String puesto, String emp) {
		return dao.modificarPuesto(puesto, emp);
	}

	public boolean modificarHorario(String horario, String emp) {
		return dao.modificarHorario(horario, emp);
	}

	public boolean modificarFormacionMinima(String formacion, String emp) {
		return dao.modificarFormacionMinima(formacion, emp);
	}

	public boolean modificarUbicacion(String ubicacion, String emp) {
		return dao.modificarUbicacion(ubicacion, emp);
	}

	public boolean modificarIdiomaReq(String idioma, String emp) {
		return dao.modificarIdiomaReq(idioma, emp);
	}

	public boolean modificarAPContactoEmpresa(String cE, String emp) {
		return dao.modificarAPContactoEmpresa(cE, emp);
	}

	public boolean modificarNumTelefono(String telefono, String emp) {
		return dao.modificarNumTelefono(telefono, emp);
	}

	public boolean modificarEmail(String email, String emp) {
		return dao.modificarEmail(email, emp);
	}

	public boolean modificarResponsableApnabi(String persona, String emp) {
		return dao.modificarResponsableApnabi(persona, emp);
	}

	public boolean modificarComunicacion(String com, String emp) {
		return dao.modificarComunicacion(com, emp);
	}

	public boolean eliminarAnalisisPuesto(String emp) {
		return dao.eliminarAnalisisPuesto(emp);
	}
}
