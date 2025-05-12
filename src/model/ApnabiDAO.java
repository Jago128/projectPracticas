package model;

import java.util.Map;

public interface ApnabiDAO {
	// Usuarios
	public boolean verificarUsuario(Usuario user);

	public boolean verificarContraseñaUsuario(Usuario user);

	public Usuario getUsuario(Usuario user);

	public boolean registrarUsuario(Usuario user);

	// Empresas
	public Map<String, Empresa> mostrarEmpresas();

	public Map<String, Empresa> mostrarNomEmpresas();

	public Empresa getEmpresa(String nom);

	public boolean verificarEmpresa(String nom);

	public int getCodEmpresa(String nom);

	public boolean añadirEmpresa(Empresa emp);

	public boolean modificarDatosContacto(String datos, String nom);

	public boolean modificarContactoEmpresa(String contactoE, String nom);

	public boolean modificarPersonaContacto(String personaC, String nom);

	public boolean modificarEstado(String estado, String nom);

	public boolean eliminarEmpresa(String nom);

	// Contactos	
	public Contacto getContacto(int empId);

	public boolean añadirContacto(Contacto cont, int id);

	public boolean modificarContacto1(String contacto1, int id);

	public boolean modificarContacto2(String contacto2, int id);

	public boolean modificarContacto3(String contacto3, int id);

	public boolean modificarContacto4(String contacto4, int id);

	public boolean modificarObservaciones(String observaciones, int id);

	public boolean modificarResultadoUltimoContacto(String resultadoU, int id);

	public boolean modificarInformacionUltimoContacto(String infoU, int id);

	public boolean modificarResultadoFinal(String resultadoF, int id);

	public boolean modificarFechaResolucion(String fecResolucion, int id);

	// Personas
	public Map<String, Persona> mostrarPersonas();
	
	public Map<String, Persona> mostrarNomPersonas();
	
	public Persona getPersona(String nom);
	
	public boolean verificarPersona(String nom);

	public boolean añadirPersona(Persona persona);

	public boolean modificarApoyo(String apoyo, String nom);

	public boolean modificarFormacion(String formacion, String nom);

	public boolean modificarEspecialidad(String especialidad, String nom);
	
	public boolean modificarSectorInteres(String sectorI, String nom);

	public boolean modificarCVLink(String link, String nom);

	public boolean modificarDiscapacidad(String discap, String nom);

	public boolean modificarEuskera(String nivel, String nom);

	public boolean modificarIngles(String nivel, String nom);

	public boolean modificarOtrosIdiomas(String idioma, String nom);

	public boolean modificarLocalidad(String localidad, String nom);

	public boolean modificarAccesibilidad(String accesibilidad, String nom);

	public boolean modificarPersonaObservaciones(String observaciones, String nom);
}
