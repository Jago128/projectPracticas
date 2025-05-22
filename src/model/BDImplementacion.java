package model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import enums.*;

public class BDImplementacion implements ApnabiDAO {
	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String SQLUSUARIO = "SELECT * FROM USUARIO WHERE NOMBRE=?";
	final String SQLUSUARIOCONTRASEÑA = "SELECT * FROM USUARIO WHERE NOMBRE=? AND CONTRASEÑA=?";
	final String SQLINSERTUSUARIO = "INSERT INTO USUARIO VALUES (?,?)";

	final String SQLEMPRESAS = "SELECT * FROM EMPRESA";
	final String SQLNOMEMPRESAS = "SELECT NOM_EMPRESA FROM EMPRESA";
	final String SQLCOD_EMPRESA = "SELECT COD_EMPRESA FROM EMPRESA WHERE NOM_EMPRESA=?";
	final String SQLSELECTEMPRESA = "SELECT * FROM EMPRESA WHERE NOM_EMPRESA=?";
	final String SQLINSERTEMPRESA = "INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES (?,?,?,?,?,?,?)";
	final String SQLUPDATEDATOSCONTACTO = "UPDATE EMPRESA SET DATOSCONTACTO=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOEMPRESA = "UPDATE EMPRESA SET CONTACTOEMPRESA=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOAPNABI = "UPDATE EMPRESA SET CONTACTOAPNABI=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATE_ESTADO = "UPDATE EMPRESA SET ESTADO=? WHERE NOM_EMPRESA=?";
	final String SQLDELETE_EMPRESA = "DELETE FROM EMPRESA WHERE NOM_EMPRESA=?";

	final String SQLCONTACTOS = "SELECT * FROM CONTACTO";
	final String SQLSELECTCONTACTOS = "SELECT * FROM CONTACTO WHERE EMPRESA=?";
	final String SQLINSERTCONTACTO = "INSERT INTO CONTACTO (EMPRESA, CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION) VALUES (?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATECONTACTO1 = "UPDATE CONTACTO SET CONTACTO1=? WHERE EMPRESA=?";
	final String SQLUPDATECONTACTO2 = "UPDATE CONTACTO SET CONTACTO2=? WHERE EMPRESA=?";
	final String SQLUPDATECONTACTO3 = "UPDATE CONTACTO SET CONTACTO3=? WHERE EMPRESA=?";
	final String SQLUPDATECONTACTO4 = "UPDATE CONTACTO SET CONTACTO4=? WHERE EMPRESA=?";
	final String SQLUPDATE_EMPRESAOBSERVACIONES = "UPDATE CONTACTO SET OBSERVACIONES=? WHERE EMPRESA=?";
	final String SQLUPDATE_RESULTADOULTIMO = "UPDATE CONTACTO SET RESULTADOULTIMO=? WHERE EMPRESA=?";
	final String SQLUPDATEINFOULTIMO = "UPDATE CONTACTO SET INFOULTIMO=? WHERE EMPRESA=?";
	final String SQLUPDATERESULTADOFINAL = "UPDATE CONTACTO SET RESULTADOFINAL=? WHERE EMPRESA=?";
	final String SQLUPDATEFECHARESOLUCION = "UPDATE CONTACTO SET FECHARESOLUCION=? WHERE EMPRESA=?";
	final String SQLDELETECONTACTO = "DELETE FROM CONTACTO WHERE EMPRESA=?";

	final String SQLPERSONAS = "SELECT * FROM PERSONA";
	final String SQLNOMPERSONAS = "SELECT NOM_P FROM PERSONA";
	final String SQLSELECTPERSONA = "SELECT * FROM PERSONA WHERE NOM_P=?";
	final String SQLINSERTPERSONA = "INSERT INTO PERSONA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATE_APOYO = "UPDATE PERSONA SET APOYO=? WHERE NOM_P=?";
	final String SQLUPDATEFORMACION = "UPDATE PERSONA SET FORMACION=? WHERE NOM_P=?";
	final String SQLUPDATE_ESPECIALIDAD = "UPDATE PERSONA SET ESPECIALIDAD=? WHERE NOM_P=?";
	final String SQLUPDATESECTORINTERES = "UPDATE PERSONA SET SECTORINTERES=? WHERE NOM_P=?";
	final String SQLUPDATECVLINK = "UPDATE PERSONA SET CV=? WHERE NOM_P=?";
	final String SQLUPDATEDISCAPACIDAD = "UPDATE PERSONA SET DISCAPACIDAD=? WHERE NOM_P=?";
	final String SQLUPDATEULTIMOAÑOTRABAJADO = "UPDATE PERSONA SET ULTIMOAÑOTRABAJADO=? WHERE NOM_P=?";
	final String SQLUPDATEINTERESESPERSONALES = "UPDATE PERSONA SET INTERESESPERSONALES=? WHERE NOM_P=?";
	final String SQLUPDATESITUACIONACTUAL = "UPDATE PERSONA SET SITUACIONACTUAL=? WHERE NOM_P=?";
	final String SQLUPDATE_EUSKERA = "UPDATE PERSONA SET EUSKERA=? WHERE NOM_P=?";
	final String SQLUPDATEINGLES = "UPDATE PERSONA SET INGLES=? WHERE NOM_P=?";
	final String SQLUPDATEOTROSIDIOMAS = "UPDATE PERSONA SET OTROSIDIOMAS=? WHERE NOM_P=?";
	final String SQLUPDATELOCALIDAD = "UPDATE PERSONA SET LOCALIDAD=? WHERE NOM_P=?";
	final String SQLUPDATEACCESIBILIDAD = "UPDATE PERSONA SET ACCESIBILIDAD=? WHERE NOM_P=?";
	final String SQLUPDATEPERSONAOBSERVACIONES = "UPDATE PERSONA SET OBSERVACIONES=? WHERE NOM_P=?";
	final String SQLDELETEPERSONA = "DELETE FROM PERSONA WHERE NOM_P=?";

	final String SQLPERSONASINCLUSION = "SELECT * FROM PERSONAINCLUSION";
	final String SQLNOMPERSONASINCLUSION = "SELECT NOMBRE FROM PERSONAINCLUSION";
	final String SQLSELECTPERSONAINCLUSION = "SELECT * FROM PERSONAINCLUSION WHERE NOMBRE=?";
	final String SQLINSERTPERSONAINCLUSION = "INSERT INTO PERSONAINCLUSION VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATE_EDAD = "UPDATE PERSONAINCLUSION SET EDAD=? WHERE NOMBRE=?";
	final String SQLUPDATEMUNICIPIO = "UPDATE PERSONAINCLUSION SET MUNICIPIO=? WHERE NOMBRE=?";
	final String SQLUPDATEFORMACIONPI = "UPDATE PERSONAINCLUSION SET FORMACION=? WHERE NOMBRE=?";
	final String SQLUPDATE_ESPECIALIDADPI = "UPDATE PERSONAINCLUSION SET ESPECIALIDAD=? WHERE NOMBRE=?";
	final String SQLUPDATEOTROS = "UPDATE PERSONAINCLUSION SET OTROS=? WHERE NOMBRE=?";
	final String SQLUPDATEIDIOMA = "UPDATE PERSONAINCLUSION SET IDIOMA=? WHERE NOMBRE=?";
	final String SQLUPDATEULTIMOAÑOTRABAJADOPI = "UPDATE PERSONAINCLUSION SET ULTIMOAÑOTRABAJADO=? WHERE NOMBRE=?";
	final String SQLUPDATESECTORINTERESPI = "UPDATE PERSONAINCLUSION SET SECTORINTERES=? WHERE NOMBRE=?";
	final String SQLUPDATEINTERESESPERSONALESPI = "UPDATE PERSONAINCLUSION SET INTERESESPERSONALES=? WHERE NOMBRE=?";
	final String SQLUPDATESITUACIONACTUALPI = "UPDATE PERSONAINCLUSION SET SITUACIONACTUAL=? WHERE NOMBRE=?";
	final String SQLUPDATEACCESIBILIDADPI = "UPDATE PERSONAINCLUSION SET ACCESIBILIDAD=? WHERE NOMBRE=?";
	final String SQLUPDATECV = "UPDATE PERSONAINCLUSION SET CV=? WHERE NOMBRE=?";
	final String SQLUPDATEPERSONAFACILITADORA = "UPDATE PERSONAINCLUSION SET PERSONAFACILITADORA=? WHERE NOMBRE=?";
	final String SQLDELETEPERSONAINCLUSION = "DELETE FROM PERSONAINCLUSION	 WHERE NOMBRE=?";

	final String SQLPERSONASPRACTICAS = "SELECT * FROM PERSONAPRACTICAS";
	final String SQLNOMPERSONASPRACTICAS = "SELECT NOM FROM PERSONAPRACTICAS";
	final String SQLSELECTPERSONAPRACTICAS = "SELECT * FROM PERSONAPRACTICAS WHERE NOM=?";
	final String SQLINSERTPERSONAPRACTICAS = "INSERT INTO PERSONAPRACTICAS VALUES (?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATE_APOYOPRACTICAS = "UPDATE PERSONAPRACTICAS SET APOYO=? WHERE NOM=?";
	final String SQLUPDATEFORMACIONPRACTICAS = "UPDATE PERSONAPRACTICAS SET FORMACION=? WHERE NOM=?";
	final String SQLUPDATECURSO = "UPDATE PERSONAPRACTICAS SET CURSO=? WHERE NOM=?";
	final String SQLUPDATECENTRO = "UPDATE PERSONAPRACTICAS SET CENTRO=? WHERE NOM=?";
	final String SQLUPDATEFECHAS = "UPDATE PERSONAPRACTICAS SET FECHAS=? WHERE NOM=?";
	final String SQLUPDATEDURACION = "UPDATE PERSONAPRACTICAS SET DURACION=? WHERE NOM=?";
	final String SQLUPDATE_EMPRESAPRACTICAS = "UPDATE PERSONAPRACTICAS SET EMPRESAPRACTICAS=? WHERE NOM=?";
	final String SQLUPDATE_EMPRESANUESTRA = "UPDATE PERSONAPRACTICAS SET EMPRESANUESTRA=? WHERE NOM=?";
	final String SQLDELETEPERSONAPRACTICAS = "DELETE FROM PERSONAPRACTICAS WHERE NOM=?";

	final String SQLANALISISPERSONAS = "SELECT * FROM ANALISISPUESTO";
	final String SQLAP_EMPRESA = "SELECT EMPRESA FROM ANALISISPUESTO";
	final String SQLSELECTANALISISPUESTO = "SELECT * FROM ANALISISPUESTO WHERE EMPRESA=?";
	final String SQLINSERTANALISISPUESTO = "INSERT INTO ANALISISPUESTO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATEPUESTO = "UPDATE ANALISISPUESTO SET PUESTO=? WHERE EMPRESA=?";
	final String SQLUPDATEHORARIO = "UPDATE ANALISISPUESTO SET HORARIO=? WHERE EMPRESA=?";
	final String SQLUPDATEMINFORMACION = "UPDATE ANALISISPUESTO SET MIN_FORMACION=? WHERE EMPRESA=?";
	final String SQLUPDATEUBICACION = "UPDATE ANALISISPUESTO SET UBICACION=? WHERE EMPRESA=?";
	final String SQLUPDATEREQ_IDIOMA = "UPDATE ANALISISPUESTO SET REQ_IDIOMAS=? WHERE EMPRESA=?";
	final String SQLUPDATECONTACTOEMPRESA_AP = "UPDATE ANALISISPUESTO SET CONTACTOEMPRESA=? WHERE EMPRESA=?";
	final String SQLUPDATE_TELEFONO = "UPDATE ANALISISPUESTO SET TELEFONO=? WHERE EMPRESA=?";
	final String SQLUPDATE_EMAIL = "UPDATE ANALISISPUESTO SET EMAIL=? WHERE EMPRESA=?";
	final String SQLUPDATERESPONSABLEAPNABI = "UPDATE ANALISISPUESTO SET RESPONSABLEAPNABI=? WHERE EMPRESA=?";
	final String SQLUPDATECOMUNICACION = "UPDATE ANALISISPUESTO SET COMUNICACION=? WHERE EMPRESA=?";
	final String SQLDELETEANALISISPUESTO = "DELETE FROM ANALISISPUESTO WHERE EMPRESA=?";

	public BDImplementacion() {
		this.configFile = ResourceBundle.getBundle("model.classConfig");
		this.driverBD = this.configFile.getString("Driver");
		this.urlBD = this.configFile.getString("Conn");
		this.userBD = this.configFile.getString("DBUser");
		this.passwordBD = this.configFile.getString("DBPass");
	}

	private void openConnection() {
		try {
			con = DriverManager.getConnection(urlBD, this.userBD, this.passwordBD);
		} catch (SQLException e) {
			System.out.println("Error al intentar abrir la base de datos.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verificarUsuario(Usuario user) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUSUARIO);
			stmt.setString(1, user.getNombre());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("El usuario no se pudo verificar correctamente.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean verificarContraseñaUsuario(Usuario user) {
		boolean existe = false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLUSUARIOCONTRASEÑA);
			stmt.setString(1, user.getNombre());
			stmt.setString(2, user.getContraseña());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("El usuario no se pudo verificar correctamente.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public Usuario getUsuario(Usuario user) {
		this.openConnection();

		if (!verificarUsuario(user)) {
			this.openConnection();
			try {
				stmt = con.prepareStatement(SQLUSUARIO);
				stmt.setString(1, user.getNombre());
				ResultSet rs = stmt.executeQuery();
				if (rs.next()) {
					user.setNombre(rs.getString("NOMBRE"));
					user.setContraseña(rs.getString("CONTRASEÑA"));
				}
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Un error ha ocurrido al intentar registrar el usuario.");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public boolean registrarUsuario(Usuario user) {
		boolean registro = false;
		this.openConnection();

		if (!verificarUsuario(user)) {
			this.openConnection();
			try {
				stmt = con.prepareStatement(SQLINSERTUSUARIO);
				stmt.setString(1, user.getNombre());
				stmt.setString(2, user.getContraseña());
				if (stmt.executeUpdate() > 0) {
					registro = true;
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Un error ha ocurrido al intentar registrar el usuario.");
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return registro;
	}

	@Override
	public Map<String, Empresa> mostrarEmpresas() {
		Empresa empresa;
		Map<String, Empresa> empresas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLEMPRESAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				empresa = new Empresa();
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				if (rs.getString("SECTOR") == null) {
					empresa.setSector(null);
				} else {
					empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				}
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				if (rs.getString("ESTADO") == null) {
					empresa.setEstado(null);
				} else {
					empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
				}
				empresas.put(empresa.getNom_empresa(), empresa);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las empresas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresas;
	}

	@Override
	public Map<String, Empresa> mostrarNomEmpresas() {
		Empresa empresa;
		Map<String, Empresa> empresas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMEMPRESAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				empresa = new Empresa();
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresas.put(empresa.getNom_empresa(), empresa);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger los nombres de las empresas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresas;
	}

	@Override
	public Empresa getEmpresa(String nom) {
		Empresa empresa = new Empresa();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTEMPRESA);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				empresa = new Empresa();
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				if (rs.getString("SECTOR") == null) {
					empresa.setSector(null);
				} else {
					empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				}
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				if (rs.getString("ESTADO") == null) {
					empresa.setEstado(null);
				} else {
					empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
				}
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empresa;
	}

	@Override
	public boolean verificarEmpresa(String nom) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTEMPRESA);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean añadirEmpresa(Empresa emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTEMPRESA);
			stmt.setString(1, emp.getNom_empresa());
			if (emp.getSector() != null) {
				switch (emp.getSector()) {
				case AGRICULTURA_GANADERIA:
					stmt.setString(2, "Agricultura_Ganaderia");
					break;

				case BIENESCONSUMO:
					stmt.setString(2, "BienesConsumo");
					break;

				case COMERCIO_ESTABLECIMIENTOS:
					stmt.setString(2, "Comercio_Establecimientos");
					break;

				case COMERCIOELECTRONICO:
					stmt.setString(2, "ComercioElectronico");
					break;

				case CONSTRUCCION:
					stmt.setString(2, "Construccion");
					break;

				case DEPORTE_OCIO:
					stmt.setString(2, "Deporte_Ocio");
					break;

				case ENERGIA_MEDIOAMBIENTE:
					stmt.setString(2, "Energia_MedioAmbiente");
					break;

				case FINANZAS_SEGUROS_BIENESINMUEBLES:
					stmt.setString(2, "Finanzas_Seguros_BienesInmuebles");
					break;

				case INTERNET:
					stmt.setString(2, "Internet");
					break;

				case LOGISTICA_TRANSPORTE:
					stmt.setString(2, "Logistica_Transporte");
					break;

				case MEDIOSCOMUNICACION_MARKETING:
					stmt.setString(2, "MediosComunicacion_Marketing");
					break;

				case METALURGIA_ELECTRONICA:
					stmt.setString(2, "Metalurgia_Electronica");
					break;

				case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
					stmt.setString(2, "ProductosQuimicos_MateriasPrimas");
					break;

				case SALUD_INDUSTRIAFARMACEUTICA:
					stmt.setString(2, "Salud_IndustriaFarmaceutica");
					break;

				case SERVICIOS:
					stmt.setString(2, "Servicios");
					break;

				case SOCIEDAD:
					stmt.setString(2, "Sociedad");
					break;

				case TECNOLOGIA_TELECOMUNICACIONES:
					stmt.setString(2, "Tecnologia_Telecomunicaciones");
					break;

				case TURISMO_HOSTELERIA:
					stmt.setString(2, "Turismo_Hosteleria");
					break;

				case VIDA:
					stmt.setString(2, "Vida");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
			} else {
				stmt.setString(2, null);
			}

			stmt.setString(3, emp.getPuesto());
			stmt.setString(4, emp.getDatosContacto());
			stmt.setString(5, emp.getContactoEmpresa());
			stmt.setString(6, emp.getContactoApnabi());
			if (emp.getEstado() != null) {
				switch (emp.getEstado()) {
				case INFORMADO:
					stmt.setString(7, "Informado");
					break;

				case NOINTERESADO:
					stmt.setString(7, "NoInteresado");
					break;

				case PLANIFICANDOINSERCIONES:
					stmt.setString(7, "PlanificandoInserciones");
					break;

				case PROXIMOAÑO:
					stmt.setString(7, "ProximoAño");
					break;

				case VALORANDO_INTERESADO:
					stmt.setString(7, "Valorando_Interesado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
			} else {
				stmt.setString(7, null);
			}

			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarDatosContacto(String datos, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!datos.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEDATOSCONTACTO);
				stmt.setString(1, datos);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarContactoEmpresa(String contactoE, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contactoE.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTOEMPRESA);
				stmt.setString(1, contactoE);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarPersonaContacto(String personaC, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!personaC.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTOAPNABI);
				stmt.setString(1, personaC);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEstado(String estado, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			switch (estado) {
			case "Valorando/interesado":
				estado = "Valorando_Interesado";
				break;

			case "Planificando inserciones":
				estado = "PlanificandoInserciones";
				break;

			case "Proximo año":
				estado = "ProximoAño";
				break;

			case "No interesado":
				estado = "NoInteresado";
				break;
			}

			stmt = con.prepareStatement(SQLUPDATE_ESTADO);
			stmt.setString(1, estado);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarEmpresa(String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETE_EMPRESA);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("La empresa no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Map<String, Contacto> mostrarContactos() {
		Map<String, Contacto> conts = new TreeMap<>();
		Contacto cont;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLCONTACTOS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cont = new Contacto();
				cont.setEmp_Nom(rs.getString("EMPRESA"));
				if (rs.getDate("CONTACTO1") == null) {
					cont.setContacto1(null);
				} else {
					cont.setContacto1(rs.getDate("CONTACTO1").toString());
				}

				if (rs.getDate("CONTACTO2") == null) {
					cont.setContacto2(null);
				} else {
					cont.setContacto2(rs.getDate("CONTACTO2").toString());
				}

				if (rs.getDate("CONTACTO3") == null) {
					cont.setContacto3(null);
				} else {
					cont.setContacto3(rs.getDate("CONTACTO3").toString());
				}

				if (rs.getDate("CONTACTO4") == null) {
					cont.setContacto4(null);
				} else {
					cont.setContacto4(rs.getDate("CONTACTO4").toString());
				}

				cont.setObservaciones(rs.getString("OBSERVACIONES"));
				if (rs.getString("RESULTADOULTIMO") != null) {
					cont.setResultadoUltimoContacto(
							ResultadoUltimoContacto.valueOf(rs.getString("RESULTADOULTIMO").toUpperCase()));
				} else {
					cont.setResultadoUltimoContacto(null);
				}

				cont.setInfoUltimo(rs.getString("INFOULTIMO"));
				if (rs.getString("RESULTADOFINAL") != null) {
					cont.setResultadoFinal(ResultadoFinal.valueOf(rs.getString("RESULTADOFINAL").toUpperCase()));
				} else {
					cont.setResultadoFinal(null);
				}

				if (rs.getDate("FECHARESOLUCION") == null) {
					cont.setFechaResolucion(null);
				} else {
					cont.setFechaResolucion(rs.getDate("FECHARESOLUCION").toString());
				}
				conts.put(cont.getEmp_Nom(), cont);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger los contactos.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conts;
	}

	public Contacto getContacto(String nom) {
		Contacto cont = new Contacto();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTCONTACTOS);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cont.setContacto1(rs.getDate("CONTACTO1").toString());
				if (rs.getDate("CONTACTO2") == null) {
					cont.setContacto2(null);
				} else {
					cont.setContacto2(rs.getDate("CONTACTO2").toString());
				}

				if (rs.getDate("CONTACTO3") == null) {
					cont.setContacto3(null);
				} else {
					cont.setContacto3(rs.getDate("CONTACTO3").toString());
				}

				if (rs.getDate("CONTACTO4") == null) {
					cont.setContacto4(null);
				} else {
					cont.setContacto4(rs.getDate("CONTACTO4").toString());
				}

				cont.setObservaciones(rs.getString("OBSERVACIONES"));
				if (rs.getString("RESULTADOULTIMO") != null) {
					cont.setResultadoUltimoContacto(
							ResultadoUltimoContacto.valueOf(rs.getString("RESULTADOULTIMO").toUpperCase()));
				} else {
					cont.setResultadoUltimoContacto(null);
				}

				cont.setInfoUltimo(rs.getString("INFOULTIMO"));
				if (rs.getString("RESULTADOFINAL") != null) {
					cont.setResultadoFinal(ResultadoFinal.valueOf(rs.getString("RESULTADOFINAL").toUpperCase()));
				} else {
					cont.setResultadoFinal(null);
				}

				if (rs.getDate("FECHARESOLUCION") == null) {
					cont.setFechaResolucion(null);
				} else {
					cont.setFechaResolucion(rs.getDate("FECHARESOLUCION").toString());
				}
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cont;
	}

	@Override
	public boolean añadirContacto(Contacto cont, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTCONTACTO);
			stmt.setString(1, nom);
			if (cont.getContacto1().isBlank()) {
				stmt.setDate(2, null);
			} else {
				stmt.setDate(2, Date.valueOf(cont.getContacto1()));
			}
			
			if (cont.getContacto2().isBlank()) {
				stmt.setDate(3, null);
			} else {
				stmt.setDate(3, Date.valueOf(cont.getContacto2()));
			}

			if (cont.getContacto3().isBlank()) {
				stmt.setDate(4, null);
			} else {
				stmt.setDate(4, Date.valueOf(cont.getContacto3()));
			}

			if (cont.getContacto4().isBlank()) {
				stmt.setDate(5, null);
			} else {
				stmt.setDate(5, Date.valueOf(cont.getContacto4()));
			}
			stmt.setString(6, cont.getObservaciones());

			if (cont.getResultadoUltimoContacto() != null) {
				switch (cont.getResultadoUltimoContacto()) {
				case COMUNICACION_SINRESPUESTA:
					stmt.setString(7, "Comunicacion_SinRespuesta");
					break;

				case INICIO_VALORACIONOFERTA:
					stmt.setString(7, "Inicio_ValoracionOferta");
					break;

				case RESPUESTA_NOCONCLUYENTE:
					stmt.setString(7, "Respuesta_NoConcluyente");
					break;

				case RESPUESTA_POSPUESTA:
					stmt.setString(7, "Respuesta_Pospuesta");
					break;

				case REUNION_PROGRAMADA:
					stmt.setString(7, "Reunion_Programada");
					break;

				default:
					System.out.println("Tipo incorrecto.");
					break;
				}
			} else {
				stmt.setString(7, null);
			}

			stmt.setString(8, cont.getInfoUltimo());
			if (cont.getResultadoFinal() != null) {
				switch (cont.getResultadoFinal()) {
				case CONVENIO_COLABORACION:
					stmt.setString(9, "Convenio_Colaboracion");
					break;

				case MEDIDAS_ALTERNATIVAS:
					stmt.setString(9, "Medidas_Alternativas");
					break;

				case OFERTA_EMPLEO:
					stmt.setString(9, "Oferta_Empleo");
					break;

				case RELACION_CONCLUIDA:
					stmt.setString(9, "Relacion_Concluida");
					break;

				case RELACION_POSPUESTA:
					stmt.setString(9, "Relacion_Pospuesta");
					break;

				default:
					System.out.println("Tipo incorrecto.");
				}
			} else {
				stmt.setString(9, null);
			}

			if (!cont.getFechaResolucion().isBlank()) {
				stmt.setDate(10, Date.valueOf(cont.getFechaResolucion()));
			} else {
				stmt.setDate(10, null);
			}
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarContacto1(String contacto1, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto1.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO1);
				stmt.setDate(1, Date.valueOf(contacto1));
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarContacto2(String contacto2, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto2.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO2);
				stmt.setDate(1, Date.valueOf(contacto2));
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarContacto3(String contacto3, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto3.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO3);
				stmt.setDate(1, Date.valueOf(contacto3));
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarContacto4(String contacto4, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto4.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO4);
				stmt.setDate(1, Date.valueOf(contacto4));
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarObservaciones(String observaciones, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!observaciones.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_EMPRESAOBSERVACIONES);
				stmt.setString(1, observaciones);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarResultadoUltimoContacto(String resultadoU, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!resultadoU.isBlank()) {
				switch (resultadoU) {
				case "Comunicacion sin respuesta":
					resultadoU = "Comunicacion_SinRespuesta";
					break;

				case "Nos pospone la respuesta":
					resultadoU = "Respuesta_Pospuesta";
					break;

				case "Programada reunion":
					resultadoU = "Reunion_Programada";
					break;

				case "Respuesta no concluyente":
					resultadoU = "Respuesta_NoConcluyente";
					break;

				case "Inicio valoracion oferta":
					resultadoU = "Inicio_ValoracionOferta";
					break;
				}

				stmt = con.prepareStatement(SQLUPDATE_RESULTADOULTIMO);
				stmt.setString(1, resultadoU);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarInformacionUltimoContacto(String infoU, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!infoU.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEINFOULTIMO);
				stmt.setString(1, infoU);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarResultadoFinal(String resultadoF, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!resultadoF.isBlank()) {
				switch (resultadoF) {
				case "Oferta de empleo":
					resultadoF = "Oferta_Empleo";
					break;

				case "Convenio de colaboracion":
					resultadoF = "Convenio_Colaboracion";
					break;

				case "Medidas alternativas":
					resultadoF = "Medidas_Alternativas";
					break;

				case "Relacion concluida":
					resultadoF = "Relacion_Concluida";
					break;

				case "Relacion pospuesta":
					resultadoF = "Relacion_Pospuesta";
					break;
				}

				stmt = con.prepareStatement(SQLUPDATERESULTADOFINAL);
				stmt.setString(1, resultadoF);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFechaResolucion(String fecResolucion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!fecResolucion.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEFECHARESOLUCION);
				stmt.setDate(1, Date.valueOf(fecResolucion));
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el contacto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarContacto(String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETECONTACTO);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("El contacto no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Map<String, PersonaOrientacion> mostrarPersonas() {
		PersonaOrientacion pO;
		Map<String, PersonaOrientacion> pOs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pO = new PersonaOrientacion();
				pO.setNombre(rs.getString("NOM_P"));
				pO.setApoyo(rs.getString("APOYO"));
				pO.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				pO.setEspecialidad(rs.getString("ESPECIALIDAD"));
				pO.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				pO.setCvLink(rs.getString("CV"));
				pO.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				pO.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				pO.setInteresesPersonales(rs.getString("INTERESESPERSONALES"));
				pO.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				if (rs.getString("EUSKERA") == null) {
					pO.setEuskera(null);
				} else {
					pO.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				}

				if (rs.getString("INGLES") == null) {
					pO.setIngles(null);
				} else {
					pO.setIngles(Ingles.valueOf(rs.getString("INGLES").toUpperCase()));
				}
				pO.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				pO.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				pO.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				pO.setObservaciones(rs.getString("OBSERVACIONES"));
				pOs.put(pO.getNombre(), pO);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pOs;
	}

	@Override
	public Map<String, PersonaOrientacion> mostrarNomPersonas() {
		PersonaOrientacion pO;
		Map<String, PersonaOrientacion> pOs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pO = new PersonaOrientacion();
				pO.setNombre(rs.getString("NOM_P"));
				pOs.put(pO.getNombre(), pO);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger los nombres de las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pOs;
	}

	@Override
	public PersonaOrientacion getPersona(String nom) {
		PersonaOrientacion pO = new PersonaOrientacion();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONA);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pO.setNombre(rs.getString("NOM_P"));
				pO.setApoyo(rs.getString("APOYO"));
				pO.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				pO.setEspecialidad(rs.getString("ESPECIALIDAD"));
				pO.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				pO.setCvLink(rs.getString("CV"));
				pO.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				pO.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				pO.setInteresesPersonales(rs.getString("INTERESESPERSONALES"));
				pO.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				if (rs.getString("EUSKERA") == null) {
					pO.setEuskera(null);
				} else {
					pO.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				}

				if (rs.getString("INGLES") == null) {
					pO.setIngles(null);
				} else {
					pO.setIngles(Ingles.valueOf(rs.getString("INGLES").toUpperCase()));
				}
				pO.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				pO.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				pO.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				pO.setObservaciones(rs.getString("OBSERVACIONES"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pO;
	}

	@Override
	public boolean verificarPersona(String nom) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONA);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("La persona no se pudo verificar correctamente.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean añadirPersona(PersonaOrientacion pO) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTPERSONA);
			stmt.setString(1, pO.getNombre());
			stmt.setString(2, pO.getApoyo());
			switch (pO.getFormacion()) {
			case AT:
				stmt.setString(3, "AT");
				break;

			case BACHILLERATO:
				stmt.setString(3, "Bachillerato");
				break;

			case DOCTORADO:
				stmt.setString(3, "Doctorado");
				break;

			case EPA:
				stmt.setString(3, "EPA");
				break;

			case ESO:
				stmt.setString(3, "ESO");
				break;

			case FP_BASICA:
				stmt.setString(3, "FP_Basica");
				break;

			case GM:
				stmt.setString(3, "GM");
				break;

			case GS:
				stmt.setString(3, "GS");
				break;

			case MASTER:
				stmt.setString(3, "Master");
				break;

			case PRIMARIA:
				stmt.setString(3, "Primaria");
				break;

			case UNIVERSIDAD:
				stmt.setString(3, "Universidad");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(4, pO.getEspecialidad());
			switch (pO.getSectorInteres()) {
			case AGRICULTURA_GANADERIA:
				stmt.setString(5, "Agricultura_Ganaderia");
				break;

			case BIENESCONSUMO:
				stmt.setString(5, "BienesConsumo");
				break;

			case COMERCIOELECTRONICO:
				stmt.setString(5, "ComercioElectronico");
				break;

			case COMERCIO_ESTABLECIMIENTOS:
				stmt.setString(5, "Comercio_Establecimientos");
				break;

			case CONSTRUCCION:
				stmt.setString(5, "Construccion");
				break;

			case DEPORTE_OCIO:
				stmt.setString(5, "Deporte_Ocio");
				break;

			case ENERGIA_MEDIOAMBIENTE:
				stmt.setString(5, "Energia_MedioAmbiente");
				break;

			case FINANZAS_SEGUROS_BIENESINMUEBLES:
				stmt.setString(5, "Finanzas_Seguros_BienesInmuebles");
				break;

			case INTERNET:
				stmt.setString(5, "Internet");
				break;

			case LOGISTICA_TRANSPORTE:
				stmt.setString(5, "Logistica_Transporte");
				break;

			case MEDIOSCOMUNICACION_MARKETING:
				stmt.setString(5, "MediosComunicacion_Marketing");
				break;

			case METALURGIA_ELECTRONICA:
				stmt.setString(5, "Metalurgia_Electronica");
				break;

			case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
				stmt.setString(5, "ProductosQuimicos_MateriasPrimas");
				break;

			case SALUD_INDUSTRIAFARMACEUTICA:
				stmt.setString(5, "Salud_IndustriaFarmaceutica");
				break;

			case SERVICIOS:
				stmt.setString(5, "Servicios");
				break;

			case SOCIEDAD:
				stmt.setString(5, "Sociedad");
				break;

			case TECNOLOGIA_TELECOMUNICACIONES:
				stmt.setString(5, "Tecnologia_Telecomunicaciones");
				break;

			case TURISMO_HOSTELERIA:
				stmt.setString(5, "Turismo_Hosteleria");
				break;

			case VIDA:
				stmt.setString(5, "Vida");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(6, pO.getCvLink());
			switch (pO.getCerfificadoDiscapacidad()) {
			case NO:
				stmt.setString(7, "No");
				break;

			case NO_SABE:
				stmt.setString(7, "No_Sabe");
				break;

			case SI:
				stmt.setString(7, "Si");
				break;

			case TRAMITANDO:
				stmt.setString(7, "Tramitando");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setInt(8, pO.getUltimoAñoTrabajado());
			stmt.setString(9, pO.getInteresesPersonales());
			stmt.setString(10, pO.getSituacionActual());

			if (pO.getEuskera() != null) {
				switch (pO.getEuskera()) {
				case A1:
					stmt.setString(11, "A1");
					break;

				case A2:
					stmt.setString(11, "A2");
					break;

				case B1:
					stmt.setString(11, "B1");
					break;

				case B2:
					stmt.setString(11, "B2");
					break;

				case C1:
					stmt.setString(11, "C1");
					break;

				case C2:
					stmt.setString(11, "C1");
					break;

				case CONOCIMIENTO_NOACREDITADO:
					stmt.setString(11, "Conocimiento_NoAcreditado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
			} else {
				stmt.setString(11, null);
			}

			if (pO.getIngles() != null) {
				switch (pO.getIngles()) {
				case A1:
					stmt.setString(12, "A1");
					break;

				case A2:
					stmt.setString(12, "A2");
					break;

				case B1:
					stmt.setString(12, "B1");
					break;

				case B2:
					stmt.setString(12, "B2");
					break;

				case C1:
					stmt.setString(12, "C1");
					break;

				case C2:
					stmt.setString(12, "C1");
					break;

				case CONOCIMIENTO_NOACREDITADO:
					stmt.setString(12, "Conocimiento_NoAcreditado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
			} else {
				stmt.setString(12, null);
			}

			stmt.setString(13, pO.getOtrosIdiomas());
			switch (pO.getLocalidad()) {
			case ABADIÑO:
				stmt.setString(14, "Abadiño");
				break;

			case ABANTO_ZIERBENA:
				stmt.setString(14, "Abanto_Zierbena");
				break;

			case AJANGIZ:
				stmt.setString(14, "Ajangiz");
				break;

			case ALONSOTEGI:
				stmt.setString(14, "Alonsotegi");
				break;

			case AMOREBIETA:
				stmt.setString(14, "Amorebieta");
				break;

			case AMOROTO:
				stmt.setString(14, "Amoroto");
				break;

			case AMURRIO:
				stmt.setString(14, "Amurrio");
				break;

			case ARAKALDO:
				stmt.setString(14, "Arakaldo");
				break;

			case ARANTZAZU:
				stmt.setString(14, "Arantzazu");
				break;

			case AREATZA_BILARO:
				stmt.setString(14, "Areatza_Bilaro");
				break;

			case ARRANKUDIAGA:
				stmt.setString(14, "Arrankudiaga");
				break;

			case ARRATZU:
				stmt.setString(14, "Arratzu");
				break;

			case ARRIETA:
				stmt.setString(14, "Arrieta");
				break;

			case ARRIGORRIAGA:
				stmt.setString(14, "Arrigorriaga");
				break;

			case ARTZENTALES:
				stmt.setString(14, "Artzentales");
				break;

			case ARTZINIEGA:
				stmt.setString(14, "Artziniega");
				break;

			case AULESTI:
				stmt.setString(14, "Aulesti");
				break;

			case AXPEATXONDO:
				stmt.setString(14, "AxpeAtxondo");
				break;

			case AYALA_AIARA:
				stmt.setString(14, "Ayala_Aiara");
				break;

			case BAKIO:
				stmt.setString(14, "Bakio");
				break;

			case BALMASEDA:
				stmt.setString(14, "Balmaseda");
				break;

			case BARAKALDO:
				stmt.setString(14, "Barakaldo");
				break;

			case BARRIKA:
				stmt.setString(14, "Barrika");
				break;

			case BASAURI:
				stmt.setString(14, "Basauri");
				break;

			case BEDIA:
				stmt.setString(14, "Bedia");
				break;

			case BERANGO:
				stmt.setString(14, "Berango");
				break;

			case BERMEO:
				stmt.setString(14, "Bermeo");
				break;

			case BERRIATUA:
				stmt.setString(14, "Berriatua");
				break;

			case BERRIZ:
				stmt.setString(14, "Berriz");
				break;

			case BILBAO:
				stmt.setString(14, "Bilbao");
				break;

			case BUSTURIA:
				stmt.setString(14, "Busturia");
				break;

			case CASTROURDIALES:
				stmt.setString(14, "CastroUrdiales");
				break;

			case DERIO:
				stmt.setString(14, "Derio");
				break;

			case DIMA:
				stmt.setString(14, "Dima");
				break;

			case DURANGO:
				stmt.setString(14, "Durango");
				break;

			case EA:
				stmt.setString(14, "Ea");
				break;

			case ELANTXOBE:
				stmt.setString(14, "Elantxobe");
				break;

			case ELORRIO:
				stmt.setString(14, "Elorrio");
				break;

			case ERANDIO:
				stmt.setString(14, "Erandio");
				break;

			case EREÑO:
				stmt.setString(14, "Ereño");
				break;

			case ERMUA:
				stmt.setString(14, "Ermua");
				break;

			case ERRIGOITI:
				stmt.setString(14, "Errigoiti");
				break;

			case ETXEBARRI:
				stmt.setString(14, "Etxebarri");
				break;

			case ETXEBARRIA:
				stmt.setString(14, "Etxebarria");
				break;

			case FORUA:
				stmt.setString(14, "Forua");
				break;

			case FRUIZ:
				stmt.setString(14, "Fruiz");
				break;

			case GALDAKAO:
				stmt.setString(14, "Galdakao");
				break;

			case GALDAMES:
				stmt.setString(14, "Galdames");
				break;

			case GAMIZFIKA:
				stmt.setString(14, "GamizFika");
				break;

			case GARAI:
				stmt.setString(14, "Garai");
				break;

			case GATIKA:
				stmt.setString(14, "Gatika");
				break;

			case GAUTEGIZ:
				stmt.setString(14, "Gautegiz");
				break;

			case GAZTELUELEXABEITIA_ARTEAGA:
				stmt.setString(14, "GazteluElexabeitia_Arteaga");
				break;

			case GERNIKALUMO:
				stmt.setString(14, "GernikaLumo");
				break;

			case GETXO:
				stmt.setString(14, "Getxo");
				break;

			case GIZABURUAGA:
				stmt.setString(14, "Gizaburuaga");
				break;

			case GORDEXOLA:
				stmt.setString(14, "Gordexola");
				break;

			case GORLIZ:
				stmt.setString(14, "Gorliz");
				break;

			case GUEÑES:
				stmt.setString(14, "Gueñes");
				break;

			case IBARRANGELU:
				stmt.setString(14, "Ibarrangelu");
				break;

			case IGORRE:
				stmt.setString(14, "Igorre");
				break;

			case ISPASTER:
				stmt.setString(14, "Ispaster");
				break;

			case IURRETA:
				stmt.setString(14, "Iurreta");
				break;

			case IZURTZA:
				stmt.setString(14, "Izurtza");
				break;

			case KARRANTZAHARANA:
				stmt.setString(14, "KarrantzaHarana");
				break;

			case KORTEZUBI:
				stmt.setString(14, "Kortezubi");
				break;

			case LANESTOSA:
				stmt.setString(14, "Lanestosa");
				break;

			case LARRABETZU:
				stmt.setString(14, "Larrabetzu");
				break;

			case LAUDIO_LLODIO:
				stmt.setString(14, "Laudio_Llodio");
				break;

			case LAUKIZ:
				stmt.setString(14, "Laukiz");
				break;

			case LEIOA:
				stmt.setString(14, "Leioa");
				break;

			case LEKEITIO:
				stmt.setString(14, "Lekeitio");
				break;

			case LEMOA:
				stmt.setString(14, "Lemoa");
				break;

			case LEMOIZ:
				stmt.setString(14, "Lemoiz");
				break;

			case LEZAMA:
				stmt.setString(14, "Lezama");
				break;

			case LOIU:
				stmt.setString(14, "Loiu");
				break;

			case MALLABIA:
				stmt.setString(14, "Mallabia");
				break;

			case MARKINAXEMEIN:
				stmt.setString(14, "MarkinaXemein");
				break;

			case MARURI:
				stmt.setString(14, "Maruri");
				break;

			case MAÑARIA:
				stmt.setString(14, "Mañaria");
				break;

			case MENDATA:
				stmt.setString(14, "Mendata");
				break;

			case MENDEXA:
				stmt.setString(14, "Mendexa");
				break;

			case MEÑAKA:
				stmt.setString(14, "Meñaka");
				break;

			case MORGA:
				stmt.setString(14, "Morga");
				break;

			case MUNDAKA:
				stmt.setString(14, "Mundaka");
				break;

			case MUNGIA:
				stmt.setString(14, "Mungia");
				break;

			case MUNITIBARARBATZEGI_GERRIKAITZ:
				stmt.setString(14, "MunitibarArbatzegi_Gerrikaitz");
				break;

			case MURUETA:
				stmt.setString(14, "Murueta");
				break;

			case MUSKIZ:
				stmt.setString(14, "Muskiz");
				break;

			case MUXIKA:
				stmt.setString(14, "Muxika");
				break;

			case NABARNIZ:
				stmt.setString(14, "Nabarniz");
				break;

			case ONDARROA:
				stmt.setString(14, "Ondarroa");
				break;

			case ORDUÑA:
				stmt.setString(14, "Orduña");
				break;

			case OROZKO:
				stmt.setString(14, "Orozko");
				break;

			case ORTUELLA:
				stmt.setString(14, "Ortuella");
				break;

			case OTXANDIO:
				stmt.setString(14, "Otxandio");
				break;

			case PLENTZIA:
				stmt.setString(14, "Plentzia");
				break;

			case PORTUGALETE:
				stmt.setString(14, "Portugalete");
				break;

			case SANTURTZI:
				stmt.setString(14, "Santurtzi");
				break;

			case SESTAO:
				stmt.setString(14, "Sestao");
				break;

			case SONDIKA:
				stmt.setString(14, "Sondika");
				break;

			case SOPELA:
				stmt.setString(14, "Sopela");
				break;

			case SOPUERTA:
				stmt.setString(14, "Sopuerta");
				break;

			case SUKARRIETA:
				stmt.setString(14, "Sukarrieta");
				break;

			case TRAPAGARAN:
				stmt.setString(14, "Trapagaran");
				break;

			case TURTZIOZ:
				stmt.setString(14, "Turtzioz");
				break;

			case UBIDE:
				stmt.setString(14, "Ubide");
				break;

			case UGAOMIRABALLES:
				stmt.setString(14, "UgaoMiraballes");
				break;

			case URDULIZ:
				stmt.setString(14, "Urduliz");
				break;

			case URDUÑA:
				stmt.setString(14, "Urduña");
				break;

			case USANSOLO:
				stmt.setString(14, "Usansolo");
				break;

			case ZALDIBAR:
				stmt.setString(14, "Zaldibar");
				break;

			case ZALLA:
				stmt.setString(14, "Zalla");
				break;

			case ZAMUDIO:
				stmt.setString(14, "Zamudio");
				break;

			case ZARATAMO:
				stmt.setString(14, "Zaratamo");
				break;

			case ZEANURI:
				stmt.setString(14, "Zeanuri");
				break;

			case ZEBERIO:
				stmt.setString(14, "Zeberio");
				break;

			case ZIERBENA:
				stmt.setString(14, "Zierbena");
				break;

			case ZIORTZA_BOLIBAR:
				stmt.setString(14, "ZiortzaBolibar");
				break;

			case ZORNOTZA:
				stmt.setString(14, "Zornotza");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			switch (pO.getAccesibilidad()) {
			case CARNET:
				stmt.setString(15, "Carnet");
				break;

			case CARNET_COCHE:
				stmt.setString(15, "Carnet_Coche");
				break;

			case TRANSPORTE_PUBLICO:
				stmt.setString(15, "Transporte_Publico");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(16, pO.getObservaciones());
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarApoyo(String apoyo, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!apoyo.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_APOYO);
				stmt.setString(1, apoyo);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFormacion(String formacion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!formacion.isBlank()) {
				if (formacion.equals("FP Basica")) {
					formacion = "FP_Basica";
				}
				stmt = con.prepareStatement(SQLUPDATEFORMACION);
				stmt.setString(1, formacion);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEspecialidad(String especialidad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!especialidad.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_ESPECIALIDAD);
				stmt.setString(1, especialidad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarSectorInteres(String sectorI, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!sectorI.isBlank()) {
				switch (sectorI) {
				case "Agricultura y Ganaderia":
					sectorI = "Agricultura_Ganaderia";
					break;

				case "Bienes de Consumo":
					sectorI = "BienesConsumo";
					break;

				case "Comercio electronico":
					sectorI = "ComercioElectronico";
					break;

				case "Comercio y establecimientos":
					sectorI = "Comercio_Establecimientos";
					break;

				case "Deporte y ocio":
					sectorI = "Deporte_Ocio";
					break;

				case "Energia y medio ambiente":
					sectorI = "Energia_MedioAmbiente";
					break;

				case "Finanzas, Seguros y bienes inmuebles":
					sectorI = "Finanzas_Seguros_BienesInmuebles";
					break;

				case "Logistica y Transporte":
					sectorI = "Logistica_Transporte";
					break;

				case "Medios de comunicacion y marketing":
					sectorI = "MediosComunicacion_Marketing";
					break;

				case "Metalurgia y electronica":
					sectorI = "Metalurgia_Electronica";
					break;

				case "Productos quimicos y materias primas":
					sectorI = "ProductosQuimicos_MateriasPrimas";
					break;

				case "Salud e industria farmaceutica":
					sectorI = "Salud_IndustriaFarmaceutica";
					break;

				case "Tecnologia y telecomunicaciones":
					sectorI = "Tecnologia_Telecomunicaciones";
					break;

				case "Turismo y hosteleria":
					sectorI = "Turismo_Hosteleria";
					break;
				}
				stmt = con.prepareStatement(SQLUPDATESECTORINTERES);
				stmt.setString(1, sectorI);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarCVLink(String link, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!link.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECVLINK);
				stmt.setString(1, link);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarDiscapacidad(String discap, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!discap.isBlank()) {
				if (discap.equals("No sabe")) {
					discap = "No_Sabe";
				}
				stmt = con.prepareStatement(SQLUPDATEDISCAPACIDAD);
				stmt.setString(1, discap);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarUltimoAñoTrabajador(int año, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEULTIMOAÑOTRABAJADO);
			stmt.setInt(1, año);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarInteresesPersonales(String intereses, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!intereses.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEINTERESESPERSONALES);
				stmt.setString(1, intereses);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarSituacionActual(String situacion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!situacion.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATESITUACIONACTUAL);
				stmt.setString(1, situacion);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEuskera(String nivel, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!nivel.isBlank()) {
				if (nivel.equals("Conocimiento, pero sin acreditar")) {
					nivel = "Conocimiento_NoAcreditado";
				}
				stmt = con.prepareStatement(SQLUPDATE_EUSKERA);
				stmt.setString(1, nivel);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarIngles(String nivel, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!nivel.isBlank()) {
				if (nivel.equals("Conocimiento, pero sin acreditar")) {
					nivel = "Conocimiento_NoAcreditado";
				}
				stmt = con.prepareStatement(SQLUPDATEINGLES);
				stmt.setString(1, nivel);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarOtrosIdiomas(String idioma, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!idioma.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEOTROSIDIOMAS);
				stmt.setString(1, idioma);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarLocalidad(String localidad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!localidad.isBlank()) {
				switch (localidad) {
				case "Abanto-Zierbena":
					localidad = "Abanto_Zierbena";
					break;

				case "Areatza o Bilaro":
					localidad = "Areatza_Bilaro";
					break;

				case "Axpe Atxondo":
					localidad = "AxpeAtxondo";
					break;

				case "Ayala/Aiara":
					localidad = "Ayala_Aiara";
					break;

				case "Castro Urdiales":
					localidad = "CastroUrdiales";
					break;

				case "Gamiz-Fika":
					localidad = "GamizFika";
					break;

				case "Gaztelu-Elexabeitia o Arteaga":
					localidad = "GazteluElexabeitia_Arteaga";
					break;

				case "Gernika-Lumo":
					localidad = "GernikaLumo";
					break;

				case "Karrantza Harana":
					localidad = "KarrantzaHarana";
					break;

				case "Laudio/Llodio":
					localidad = "Laudio_Llodio";
					break;

				case "Markina-Xemein":
					localidad = "MarkinaXemein";
					break;

				case "Munitibar-Arbatzegi Gerrikaitz":
					localidad = "MunitibarArbatzegi_Gerrikaitz";
					break;

				case "Ugao-Miraballes":
					localidad = "UgaoMiraballes";
					break;

				case "Ziortza-Bolibar":
					localidad = "ZiortzaBolibar";
					break;
				}

				stmt = con.prepareStatement(SQLUPDATELOCALIDAD);
				stmt.setString(1, localidad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarAccesibilidad(String accesibilidad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			switch (accesibilidad) {
			case "Carnet + coche":
				accesibilidad = "Carnet_Coche";
				break;

			case "Transporte publico":
				accesibilidad = "Transporte_Publico";
				break;
			}

			if (!accesibilidad.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEACCESIBILIDAD);
				stmt.setString(1, accesibilidad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarPersonaObservaciones(String observaciones, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!observaciones.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEPERSONAOBSERVACIONES);
				stmt.setString(1, observaciones);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarPersona(String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETEPERSONA);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("La persona no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Map<String, PersonaInclusion> mostrarPersonasInclusion() {
		PersonaInclusion pI;
		Map<String, PersonaInclusion> pIs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONASINCLUSION);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pI = new PersonaInclusion();
				pI.setNombre(rs.getString("NOMBRE"));
				pI.setApellido(rs.getString("APELLIDO"));
				pI.setEdad(rs.getInt("EDAD"));
				pI.setMunicipio(Localidad.valueOf(rs.getString("MUNICIPIO").toUpperCase()));
				pI.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				pI.setEspecialidad(rs.getString("ESPECIALIDAD"));
				pI.setOtros(rs.getString("OTROS"));
				pI.setIdioma(rs.getString("IDIOMA"));
				pI.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				pI.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				pI.setInteresesPersonales(rs.getString("INTERESPERSONALES"));
				pI.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				pI.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				pI.setCv(rs.getString("CV"));
				pI.setPersonaFacilitadora(rs.getString("PERSONAFACILITADORA"));
				pIs.put(pI.getNombre(), pI);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pIs;
	}

	@Override
	public Map<String, PersonaInclusion> mostrarNomPersonasInclusion() {
		PersonaInclusion pI;
		Map<String, PersonaInclusion> pIs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONASINCLUSION);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pI = new PersonaInclusion();
				pI.setNombre(rs.getString("NOMBRE"));
				pIs.put(pI.getNombre(), pI);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger los nombres de las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pIs;
	}

	@Override
	public PersonaInclusion getPersonaInclusion(String nom) {
		PersonaInclusion pI = new PersonaInclusion();
		;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONAINCLUSION);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				pI.setNombre(rs.getString("NOMBRE"));
				pI.setApellido(rs.getString("APELLIDO"));
				pI.setEdad(rs.getInt("EDAD"));
				pI.setMunicipio(Localidad.valueOf(rs.getString("MUNICIPIO").toUpperCase()));
				pI.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				pI.setEspecialidad(rs.getString("ESPECIALIDAD"));
				pI.setOtros(rs.getString("OTROS"));
				pI.setIdioma(rs.getString("IDIOMA"));
				pI.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				pI.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				pI.setInteresesPersonales(rs.getString("INTERESPERSONALES"));
				pI.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				pI.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				pI.setCv(rs.getString("CV"));
				pI.setPersonaFacilitadora(rs.getString("PERSONAFACILITADORA"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pI;
	}

	@Override
	public boolean verificarPersonaInclusion(String nom) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONAINCLUSION);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean añadirPersonaInclusion(PersonaInclusion pI) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTPERSONAINCLUSION);
			stmt.setString(1, pI.getNombre());
			stmt.setString(2, pI.getApellido());
			stmt.setInt(3, pI.getEdad());
			switch (pI.getMunicipio()) {
			case ABADIÑO:
				stmt.setString(4, "Abadiño");
				break;

			case ABANTO_ZIERBENA:
				stmt.setString(4, "Abanto_Zierbena");
				break;

			case AJANGIZ:
				stmt.setString(4, "Ajangiz");
				break;

			case ALONSOTEGI:
				stmt.setString(4, "Alonsotegi");
				break;

			case AMOREBIETA:
				stmt.setString(4, "Amorebieta");
				break;

			case AMOROTO:
				stmt.setString(4, "Amoroto");
				break;

			case AMURRIO:
				stmt.setString(4, "Amurrio");
				break;

			case ARAKALDO:
				stmt.setString(4, "Arakaldo");
				break;

			case ARANTZAZU:
				stmt.setString(4, "Arantzazu");
				break;

			case AREATZA_BILARO:
				stmt.setString(4, "Areatza_Bilaro");
				break;

			case ARRANKUDIAGA:
				stmt.setString(4, "Arrankudiaga");
				break;

			case ARRATZU:
				stmt.setString(4, "Arratzu");
				break;

			case ARRIETA:
				stmt.setString(4, "Arrieta");
				break;

			case ARRIGORRIAGA:
				stmt.setString(4, "Arrigorriaga");
				break;

			case ARTZENTALES:
				stmt.setString(4, "Artzentales");
				break;

			case ARTZINIEGA:
				stmt.setString(4, "Artziniega");
				break;

			case AULESTI:
				stmt.setString(4, "Aulesti");
				break;

			case AXPEATXONDO:
				stmt.setString(4, "AxpeAtxondo");
				break;

			case AYALA_AIARA:
				stmt.setString(4, "Ayala_Aiara");
				break;

			case BAKIO:
				stmt.setString(4, "Bakio");
				break;

			case BALMASEDA:
				stmt.setString(4, "Balmaseda");
				break;

			case BARAKALDO:
				stmt.setString(4, "Barakaldo");
				break;

			case BARRIKA:
				stmt.setString(4, "Barrika");
				break;

			case BASAURI:
				stmt.setString(4, "Basauri");
				break;

			case BEDIA:
				stmt.setString(4, "Bedia");
				break;

			case BERANGO:
				stmt.setString(4, "Berango");
				break;

			case BERMEO:
				stmt.setString(4, "Bermeo");
				break;

			case BERRIATUA:
				stmt.setString(4, "Berriatua");
				break;

			case BERRIZ:
				stmt.setString(4, "Berriz");
				break;

			case BILBAO:
				stmt.setString(4, "Bilbao");
				break;

			case BUSTURIA:
				stmt.setString(4, "Busturia");
				break;

			case CASTROURDIALES:
				stmt.setString(4, "CastroUrdiales");
				break;

			case DERIO:
				stmt.setString(4, "Derio");
				break;

			case DIMA:
				stmt.setString(4, "Dima");
				break;

			case DURANGO:
				stmt.setString(4, "Durango");
				break;

			case EA:
				stmt.setString(4, "Ea");
				break;

			case ELANTXOBE:
				stmt.setString(4, "Elantxobe");
				break;

			case ELORRIO:
				stmt.setString(4, "Elorrio");
				break;

			case ERANDIO:
				stmt.setString(4, "Erandio");
				break;

			case EREÑO:
				stmt.setString(4, "Ereño");
				break;

			case ERMUA:
				stmt.setString(4, "Ermua");
				break;

			case ERRIGOITI:
				stmt.setString(4, "Errigoiti");
				break;

			case ETXEBARRI:
				stmt.setString(4, "Etxebarri");
				break;

			case ETXEBARRIA:
				stmt.setString(4, "Etxebarria");
				break;

			case FORUA:
				stmt.setString(4, "Forua");
				break;

			case FRUIZ:
				stmt.setString(4, "Fruiz");
				break;

			case GALDAKAO:
				stmt.setString(4, "Galdakao");
				break;

			case GALDAMES:
				stmt.setString(4, "Galdames");
				break;

			case GAMIZFIKA:
				stmt.setString(4, "GamizFika");
				break;

			case GARAI:
				stmt.setString(4, "Garai");
				break;

			case GATIKA:
				stmt.setString(4, "Gatika");
				break;

			case GAUTEGIZ:
				stmt.setString(4, "Gautegiz");
				break;

			case GAZTELUELEXABEITIA_ARTEAGA:
				stmt.setString(4, "GazteluElexabeitia_Arteaga");
				break;

			case GERNIKALUMO:
				stmt.setString(4, "GernikaLumo");
				break;

			case GETXO:
				stmt.setString(4, "Getxo");
				break;

			case GIZABURUAGA:
				stmt.setString(4, "Gizaburuaga");
				break;

			case GORDEXOLA:
				stmt.setString(4, "Gordexola");
				break;

			case GORLIZ:
				stmt.setString(4, "Gorliz");
				break;

			case GUEÑES:
				stmt.setString(4, "Gueñes");
				break;

			case IBARRANGELU:
				stmt.setString(4, "Ibarrangelu");
				break;

			case IGORRE:
				stmt.setString(4, "Igorre");
				break;

			case ISPASTER:
				stmt.setString(4, "Ispaster");
				break;

			case IURRETA:
				stmt.setString(4, "Iurreta");
				break;

			case IZURTZA:
				stmt.setString(4, "Izurtza");
				break;

			case KARRANTZAHARANA:
				stmt.setString(4, "KarrantzaHarana");
				break;

			case KORTEZUBI:
				stmt.setString(4, "Kortezubi");
				break;

			case LANESTOSA:
				stmt.setString(4, "Lanestosa");
				break;

			case LARRABETZU:
				stmt.setString(4, "Larrabetzu");
				break;

			case LAUDIO_LLODIO:
				stmt.setString(4, "Laudio_Llodio");
				break;

			case LAUKIZ:
				stmt.setString(4, "Laukiz");
				break;

			case LEIOA:
				stmt.setString(4, "Leioa");
				break;

			case LEKEITIO:
				stmt.setString(4, "Lekeitio");
				break;

			case LEMOA:
				stmt.setString(4, "Lemoa");
				break;

			case LEMOIZ:
				stmt.setString(4, "Lemoiz");
				break;

			case LEZAMA:
				stmt.setString(4, "Lezama");
				break;

			case LOIU:
				stmt.setString(4, "Loiu");
				break;

			case MALLABIA:
				stmt.setString(4, "Mallabia");
				break;

			case MARKINAXEMEIN:
				stmt.setString(4, "MarkinaXemein");
				break;

			case MARURI:
				stmt.setString(4, "Maruri");
				break;

			case MAÑARIA:
				stmt.setString(4, "Mañaria");
				break;

			case MENDATA:
				stmt.setString(4, "Mendata");
				break;

			case MENDEXA:
				stmt.setString(4, "Mendexa");
				break;

			case MEÑAKA:
				stmt.setString(4, "Meñaka");
				break;

			case MORGA:
				stmt.setString(4, "Morga");
				break;

			case MUNDAKA:
				stmt.setString(4, "Mundaka");
				break;

			case MUNGIA:
				stmt.setString(4, "Mungia");
				break;

			case MUNITIBARARBATZEGI_GERRIKAITZ:
				stmt.setString(4, "MunitibarArbatzegi_Gerrikaitz");
				break;

			case MURUETA:
				stmt.setString(4, "Murueta");
				break;

			case MUSKIZ:
				stmt.setString(4, "Muskiz");
				break;

			case MUXIKA:
				stmt.setString(4, "Muxika");
				break;

			case NABARNIZ:
				stmt.setString(4, "Nabarniz");
				break;

			case ONDARROA:
				stmt.setString(4, "Ondarroa");
				break;

			case ORDUÑA:
				stmt.setString(4, "Orduña");
				break;

			case OROZKO:
				stmt.setString(4, "Orozko");
				break;

			case ORTUELLA:
				stmt.setString(4, "Ortuella");
				break;

			case OTXANDIO:
				stmt.setString(4, "Otxandio");
				break;

			case PLENTZIA:
				stmt.setString(4, "Plentzia");
				break;

			case PORTUGALETE:
				stmt.setString(4, "Portugalete");
				break;

			case SANTURTZI:
				stmt.setString(4, "Santurtzi");
				break;

			case SESTAO:
				stmt.setString(4, "Sestao");
				break;

			case SONDIKA:
				stmt.setString(4, "Sondika");
				break;

			case SOPELA:
				stmt.setString(4, "Sopela");
				break;

			case SOPUERTA:
				stmt.setString(4, "Sopuerta");
				break;

			case SUKARRIETA:
				stmt.setString(4, "Sukarrieta");
				break;

			case TRAPAGARAN:
				stmt.setString(4, "Trapagaran");
				break;

			case TURTZIOZ:
				stmt.setString(4, "Turtzioz");
				break;

			case UBIDE:
				stmt.setString(4, "Ubide");
				break;

			case UGAOMIRABALLES:
				stmt.setString(4, "UgaoMiraballes");
				break;

			case URDULIZ:
				stmt.setString(4, "Urduliz");
				break;

			case URDUÑA:
				stmt.setString(4, "Urduña");
				break;

			case USANSOLO:
				stmt.setString(4, "Usansolo");
				break;

			case ZALDIBAR:
				stmt.setString(4, "Zaldibar");
				break;

			case ZALLA:
				stmt.setString(4, "Zalla");
				break;

			case ZAMUDIO:
				stmt.setString(4, "Zamudio");
				break;

			case ZARATAMO:
				stmt.setString(4, "Zaratamo");
				break;

			case ZEANURI:
				stmt.setString(4, "Zeanuri");
				break;

			case ZEBERIO:
				stmt.setString(4, "Zeberio");
				break;

			case ZIERBENA:
				stmt.setString(4, "Zierbena");
				break;

			case ZIORTZA_BOLIBAR:
				stmt.setString(4, "ZiortzaBolibar");
				break;

			case ZORNOTZA:
				stmt.setString(4, "Zornotza");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			switch (pI.getFormacion()) {
			case AT:
				stmt.setString(5, "AT");
				break;

			case BACHILLERATO:
				stmt.setString(5, "Bachillerato");
				break;

			case DOCTORADO:
				stmt.setString(5, "Doctorado");
				break;

			case EPA:
				stmt.setString(5, "EPA");
				break;

			case ESO:
				stmt.setString(5, "ESO");
				break;

			case FP_BASICA:
				stmt.setString(5, "FP_Basica");
				break;

			case GM:
				stmt.setString(5, "GM");
				break;

			case GS:
				stmt.setString(5, "GS");
				break;

			case MASTER:
				stmt.setString(5, "Master");
				break;

			case PRIMARIA:
				stmt.setString(5, "Primaria");
				break;

			case UNIVERSIDAD:
				stmt.setString(5, "Universidad");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(6, pI.getEspecialidad());
			stmt.setString(7, pI.getOtros());
			stmt.setString(8, pI.getIdioma());
			stmt.setInt(9, pI.getUltimoAñoTrabajado());
			switch (pI.getSectorInteres()) {
			case AGRICULTURA_GANADERIA:
				stmt.setString(10, "Agricultura_Ganaderia");
				break;

			case BIENESCONSUMO:
				stmt.setString(10, "BienesConsumo");
				break;

			case COMERCIO_ESTABLECIMIENTOS:
				stmt.setString(10, "Comercio_Establecimientos");
				break;

			case COMERCIOELECTRONICO:
				stmt.setString(10, "ComercioElectronico");
				break;

			case CONSTRUCCION:
				stmt.setString(10, "Construccion");
				break;

			case DEPORTE_OCIO:
				stmt.setString(10, "Deporte_Ocio");
				break;

			case ENERGIA_MEDIOAMBIENTE:
				stmt.setString(10, "Energia_MedioAmbiente");
				break;

			case FINANZAS_SEGUROS_BIENESINMUEBLES:
				stmt.setString(10, "Finanzas_Seguros_BienesInmuebles");
				break;

			case INTERNET:
				stmt.setString(10, "Internet");
				break;

			case LOGISTICA_TRANSPORTE:
				stmt.setString(10, "Logistica_Transporte");
				break;

			case MEDIOSCOMUNICACION_MARKETING:
				stmt.setString(10, "MediosComunicacion_Marketing");
				break;

			case METALURGIA_ELECTRONICA:
				stmt.setString(10, "Metalurgia_Electronica");
				break;

			case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
				stmt.setString(10, "ProductosQuimicos_MateriasPrimas");
				break;

			case SALUD_INDUSTRIAFARMACEUTICA:
				stmt.setString(10, "Salud_IndustriaFarmaceutica");
				break;

			case SERVICIOS:
				stmt.setString(10, "Servicios");
				break;

			case SOCIEDAD:
				stmt.setString(10, "Sociedad");
				break;

			case TECNOLOGIA_TELECOMUNICACIONES:
				stmt.setString(10, "Tecnologia_Telecomunicaciones");
				break;

			case TURISMO_HOSTELERIA:
				stmt.setString(10, "Turismo_Hosteleria");
				break;

			case VIDA:
				stmt.setString(10, "Vida");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(11, pI.getInteresesPersonales());
			stmt.setString(12, pI.getSituacionActual());
			switch (pI.getAccesibilidad()) {
			case CARNET:
				stmt.setString(13, "Carnet");
				break;

			case CARNET_COCHE:
				stmt.setString(13, "Carnet_Coche");
				break;

			case TRANSPORTE_PUBLICO:
				stmt.setString(13, "Transporte_Publico");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(14, pI.getCv());
			stmt.setString(15, pI.getPersonaFacilitadora());
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEdad(int edad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (edad != 0) {
				stmt = con.prepareStatement(SQLUPDATE_EDAD);
				stmt.setInt(1, edad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarMunicipio(String municipio, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!municipio.isBlank()) {
				switch (municipio) {
				case "Abanto-Zierbena":
					municipio = "Abanto_Zierbena";
					break;

				case "Areatza o Bilaro":
					municipio = "Areatza_Bilaro";
					break;

				case "Axpe Atxondo":
					municipio = "AxpeAtxondo";
					break;

				case "Ayala/Aiara":
					municipio = "Ayala_Aiara";
					break;

				case "Castro Urdiales":
					municipio = "CastroUrdiales";
					break;

				case "Gamiz-Fika":
					municipio = "GamizFika";
					break;

				case "Gaztelu-Elexabeitia o Arteaga":
					municipio = "GazteluElexabeitia_Arteaga";
					break;

				case "Gernika-Lumo":
					municipio = "GernikaLumo";
					break;

				case "Karrantza Harana":
					municipio = "KarrantzaHarana";
					break;

				case "Laudio/Llodio":
					municipio = "Laudio_Llodio";
					break;

				case "Markina-Xemein":
					municipio = "MarkinaXemein";
					break;

				case "Munitibar-Arbatzegi Gerrikaitz":
					municipio = "MunitibarArbatzegi_Gerrikaitz";
					break;

				case "Ugao-Miraballes":
					municipio = "UgaoMiraballes";
					break;

				case "Ziortza-Bolibar":
					municipio = "ZiortzaBolibar";
					break;
				}

				stmt = con.prepareStatement(SQLUPDATEMUNICIPIO);
				stmt.setString(1, municipio);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFormacionPI(String formacion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (formacion.equals("FP Basica")) {
				formacion = "FP_Basica";
			}
			stmt = con.prepareStatement(SQLUPDATEFORMACION);
			stmt.setString(1, formacion);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEspecialidadPI(String especialidad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!especialidad.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_ESPECIALIDADPI);
				stmt.setString(1, especialidad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarOtros(String otros, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!otros.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEOTROS);
				stmt.setString(1, otros);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarIdioma(String idioma, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!idioma.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEIDIOMA);
				stmt.setString(1, idioma);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarUltimoAñoTrabajadorPI(int año, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEULTIMOAÑOTRABAJADOPI);
			stmt.setInt(1, año);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarSectorInteresPI(String sectorI, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!sectorI.isBlank()) {
				switch (sectorI) {
				case "Agricultura y Ganaderia":
					sectorI = "Agricultura_Ganaderia";
					break;

				case "Bienes de Consumo":
					sectorI = "BienesConsumo";
					break;

				case "Comercio electronico":
					sectorI = "ComercioElectronico";
					break;

				case "Comercio y establecimientos":
					sectorI = "Comercio_Establecimientos";
					break;

				case "Deporte y ocio":
					sectorI = "Deporte_Ocio";
					break;

				case "Energia y medio ambiente":
					sectorI = "Energia_MedioAmbiente";
					break;

				case "Finanzas, Seguros y bienes inmuebles":
					sectorI = "Finanzas_Seguros_BienesInmuebles";
					break;

				case "Logistica y Transporte":
					sectorI = "Logistica_Transporte";
					break;

				case "Medios de comunicacion y marketing":
					sectorI = "MediosComunicacion_Marketing";
					break;

				case "Metalurgia y electronica":
					sectorI = "Metalurgia_Electronica";
					break;

				case "Productos quimicos y materias primas":
					sectorI = "ProductosQuimicos_MateriasPrimas";
					break;

				case "Salud e industria farmaceutica":
					sectorI = "Salud_IndustriaFarmaceutica";
					break;

				case "Tecnologia y telecomunicaciones":
					sectorI = "Tecnologia_Telecomunicaciones";
					break;

				case "Turismo y hosteleria":
					sectorI = "Turismo_Hosteleria";
					break;
				}
				stmt = con.prepareStatement(SQLUPDATESECTORINTERESPI);
				stmt.setString(1, sectorI);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarInteresesPersonalesPI(String intereses, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!intereses.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEINTERESESPERSONALESPI);
				stmt.setString(1, intereses);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarSituacionActualPI(String situacion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!situacion.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATESITUACIONACTUALPI);
				stmt.setString(1, situacion);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarAccesibilidadPI(String accesibilidad, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			switch (accesibilidad) {
			case "Carnet + coche":
				accesibilidad = "Carnet_Coche";
				break;

			case "Transporte publico":
				accesibilidad = "Transporte_Publico";
				break;
			}

			if (!accesibilidad.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEACCESIBILIDADPI);
				stmt.setString(1, accesibilidad);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarCV(String link, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!link.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECV);
				stmt.setString(1, link);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarPersonaFacilitadora(String persona, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!persona.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEPERSONAFACILITADORA);
				stmt.setString(1, persona);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarPersonaInclusion(String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETEPERSONAINCLUSION);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("La persona no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Map<String, PersonaPracticas> mostrarPersonasPracticas() {
		PersonaPracticas p;
		Map<String, PersonaPracticas> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONASPRACTICAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new PersonaPracticas();
				p.setNombre(rs.getString("NOM"));
				p.setApoyo(rs.getString("APOYO"));
				p.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				p.setCurso(rs.getInt("CURSO"));
				p.setCentro(CentrosFormativos.valueOf(rs.getString("CENTRO").toUpperCase()));
				p.setFechas(rs.getString("FECHAS"));
				p.setDuracion(rs.getString("DURACION"));
				p.setEmpresaPracticas(rs.getString("EMPRESAPRACTICAS"));
				p.setEmpresaNuestra(rs.getBoolean("EMPRESANUESTRA"));
				personas.put(p.getNombre(), p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public Map<String, PersonaPracticas> mostrarNomPersonasPracticas() {
		PersonaPracticas p;
		Map<String, PersonaPracticas> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONASPRACTICAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				p = new PersonaPracticas();
				p.setNombre(rs.getString("NOM"));
				personas.put(p.getNombre(), p);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las personas.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personas;
	}

	@Override
	public PersonaPracticas getPersonaPracticas(String nom) {
		PersonaPracticas p = new PersonaPracticas();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONAPRACTICAS);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				p.setNombre(rs.getString("NOM"));
				p.setApoyo(rs.getString("APOYO"));
				p.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				p.setCurso(rs.getInt("CURSO"));
				p.setCentro(CentrosFormativos.valueOf(rs.getString("CENTRO").toUpperCase()));
				p.setFechas(rs.getString("FECHAS"));
				p.setDuracion(rs.getString("DURACION"));
				p.setEmpresaPracticas(rs.getString("EMPRESAPRACTICAS"));
				p.setEmpresaNuestra(rs.getBoolean("EMPRESANUESTRA"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public boolean verificarPersonaPracticas(String nom) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTPERSONAPRACTICAS);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean añadirPersonaPracticas(PersonaPracticas p) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTPERSONAPRACTICAS);
			stmt.setString(1, p.getNombre());
			stmt.setString(2, p.getApoyo());
			switch (p.getFormacion()) {
			case AT:
				stmt.setString(3, "AT");
				break;

			case BACHILLERATO:
				stmt.setString(3, "Bachillerato");
				break;

			case DOCTORADO:
				stmt.setString(3, "Doctorado");
				break;

			case EPA:
				stmt.setString(3, "EPA");
				break;

			case ESO:
				stmt.setString(3, "ESO");
				break;

			case FP_BASICA:
				stmt.setString(3, "FP_Basica");
				break;

			case GM:
				stmt.setString(3, "GM");
				break;

			case GS:
				stmt.setString(3, "GS");
				break;

			case MASTER:
				stmt.setString(3, "Master");
				break;

			case PRIMARIA:
				stmt.setString(3, "Primaria");
				break;

			case UNIVERSIDAD:
				stmt.setString(3, "Universidad");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setInt(4, p.getCurso());
			switch (p.getCentro()) {
			case ADSIS_BILBAO_OLHIP:
				stmt.setString(5, "ADSIS BILBAO OLHIP");
				break;

			case CEINMARK:
				stmt.setString(5, "CEINMARK");
				break;

			case CENTROMIKELDI:
				stmt.setString(5, "Centro Mikeldi");
				break;

			case CENTROSANLUIS:
				stmt.setString(5, "Centro San Luis");
				break;

			case CIFP_AGRARIODERIO_DERIONEKAZARITZA_LHII:
				stmt.setString(5, "CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII");
				break;

			case CIFP_ANDRA_MARI_BHI:
				stmt.setString(5, "CIFP Andra Mari BHI");
				break;

			case CIFP_ARRATIAKOZULAIBAR_LANBIDEIKASTEGIA:
				stmt.setString(5, "CIFP Arratiako Zulaibar Lanbide Ikastegia");
				break;

			case CIFP_BIDEBIETA:
				stmt.setString(5, "CIFP Bidebieta");
				break;

			case CIFP_CALASANZ_LANBIDEIKASTEGIA:
				stmt.setString(5, "CIFP Calasanz Lanbide Ikastegia");
				break;

			case CIFP_CONSTRUCCIONBIZKAIA_LHII:
				stmt.setString(5, "CIFP CONSTRUCCIÓN BIZKAIA LHII");
				break;

			case CIFP_ELORRIETAERREKA_MARI_GBLHI:
				stmt.setString(5, "CIFP Elorrieta Erreka Mari GBLHI");
				break;

			case CIFP_EMILIOCAMPUZANO:
				stmt.setString(5, "CIFP Emilio Campuzano");
				break;

			case CIFP_ESCUELAHOSTELERIA_LHII:
				stmt.setString(5, "CIFP Escuela de Hostelería LHII");
				break;

			case CIFP_FADURA_GBLHI:
				stmt.setString(5, "CIFP Fadura GBLHI");
				break;

			case CIFP_HOSTELERIA_OSTALARITZA_LHII:
				stmt.setString(5, "CIFP HOSTELERÍA/OSTALARITZA LHII");
				break;

			case CIFP_HOSTELERIA_HOSTALARITZA_LHII:
				stmt.setString(5, "CIFP Hostelería/Hostalaritza LHII");
				break;

			case CIFP_IBAIONDO:
				stmt.setString(5, "CIFP Ibaiondo");
				break;

			case CIFP_IURRETA_GBLHI:
				stmt.setString(5, "CIFP Iurreta GBLHI");
				break;

			case CIFP_LEA_ARTIBAI:
				stmt.setString(5, "CIFP Lea-Artibai");
				break;

			case CIFP_NAUTICOBERMEO_BERMEOKONAUTIKA_LHII:
				stmt.setString(5, "CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII");
				break;

			case CIFP_REPELEGA_GBLHI:
				stmt.setString(5, "CIFP Repelega GBLHI");
				break;

			case CIFP_SANJORGE_GBLHI:
				stmt.setString(5, "CIFP San Jorge GBLHI");
				break;

			case CIFP_TARTANGA_GBLHI:
				stmt.setString(5, "CIFP Tartanga GBLHI");
				break;

			case CIFP_TXURDINAGA_LHII:
				stmt.setString(5, "CIFP TXURDINAGA LHII");
				break;

			case CIFP_UNI_EIBARERMUA:
				stmt.setString(5, "CIFP Uni Eibar Ermua");
				break;

			case CIFP_ZORNOTZA_LHII:
				stmt.setString(5, "CIFP ZORNOTZA LHII");
				break;

			case CPEIPS_ANGELESCUSTODIOS_HLBHIP:
				stmt.setString(5, "CPEIPS ANGELES CUSTODIOS HLBHIP");
				break;

			case CPEIPS_MARISTAS_SANMIGUEL_HLBHIP:
				stmt.setString(5, "CPEIPS MARISTAS-SAN MIGUEL HLBHIP");
				break;

			case CPEIPS_NTRA_SRA_DE_LA_ANTIGUA_HLBHIP:
				stmt.setString(5, "CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP");
				break;

			case CPES_ALMI_BHIP:
				stmt.setString(5, "CPES ALMI BHIP");
				break;

			case CPES_ARANGOYA_BHIP:
				stmt.setString(5, "CPES ARANGOYA BHIP");
				break;

			case CPES_ARCE_BHIP:
				stmt.setString(5, "CPES ARCE BHIP");
				break;

			case CPES_ARMENGOL_BHIP:
				stmt.setString(5, "CPES ARMENGOL BHIP");
				break;

			case CPES_BAGABILTZA_BHIP:
				stmt.setString(5, "CPES BAGABILTZA BHIP");
				break;

			case CPES_EIDE_BHIP:
				stmt.setString(5, "CPES EIDE BHIP");
				break;

			case CPES_ESPERANZA_ALHAMA_BHIP:
				stmt.setString(5, "CPES ESPERANZA ALHAMA BHIP");
				break;

			case CPES_IBAIZABAL_IKASTOLA_BHIP:
				stmt.setString(5, "CPES IBAIZABAL IKASTOLA BHIP");
				break;

			case CPES_IKASAUTO_BHIP:
				stmt.setString(5, "CPES IKASAUTO BHIP");
				break;

			case CPES_NTRA_SRA_DE_LA_ANTIGUA_BHIP:
				stmt.setString(5, "CPES NTRA. SRA. DE LA ANTIGUA BHIP");
				break;

			case CPES_ORUE_ESKOLA_BHIP:
				stmt.setString(5, "CPES ORUE ESKOLA BHIP");
				break;

			case CPES_XABIER_BHIP:
				stmt.setString(5, "CPES XABIER BHIP");
				break;

			case CPFPB_ADSISLEIOA_OLHIP:
				stmt.setString(5, "CPFPB ADSIS LEIOA OLHIP");
				break;

			case CPFPB_ADSIS_GETXO_OLHIP:
				stmt.setString(5, "CPFPB ADSIS GETXO OLHIP");
				break;

			case CPFPB_MEATZALDEA_OLHIP:
				stmt.setString(5, "CPFPB MEATZALDEA OLHIP");
				break;

			case CPFPB_PEÑASCALMARKINA_OLHIP:
				stmt.setString(5, "CPFPB PEÑASCAL MARKINA OLHIP");
				break;

			case CPIFP_BARAKALDO:
				stmt.setString(5, "CPIFP Barakaldo");
				break;

			case CPIFP_HARROBIA:
				stmt.setString(5, "CPIFP Harrobia");
				break;

			case CPIFP_HARROBIA_LHIPI:
				stmt.setString(5, "CPIFP HARROBIA LHIPI");
				break;

			case CPIFP_INNOVACIONSOCIALDIEGO_BERGUICES_OTXARKOAGA:
				stmt.setString(5, "CPIFP Innovación Social Diego Berguices-Otxarkoaga");
				break;

			case CPIFP_JESUITAKPOLITEKNIKOA:
				stmt.setString(5, "CPIFP Jesuitak Politeknikoa");
				break;

			case CPIFP_MARISTAKDURANGO:
				stmt.setString(5, "CPIFP Maristak Durango");
				break;

			case CPIFP_PEÑASCAL:
				stmt.setString(5, "CPIFP Peñascal");
				break;

			case CPIFP_SALESIANOSDEUSTO:
				stmt.setString(5, "CPIFP Salesianos Deusto");
				break;

			case CPIFP_SANVIATOR:
				stmt.setString(5, "CPIFP San Viator");
				break;

			case CPIFP_SOMORROSTRO_LHIPI:
				stmt.setString(5, "CPIFP SOMORROSTRO LHIPI");
				break;

			case CRUZROJA:
				stmt.setString(5, "CRUZ ROJA");
				break;

			case ESCUELASUPERIORHOSTELERIABILBAO:
				stmt.setString(5, "ESCUELA SUPERIOR DE HOSTELERÍA BILBAO");
				break;

			case ESCUELAUNIVERSITARIAMAGISTERIO_BAM_BEGOÑAKO_ANDRA_MARI:
				stmt.setString(5, "Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari");
				break;

			case FERNANDO_BHIP:
				stmt.setString(5, "FERNANDO BHIP");
				break;

			case HERMANOSLARRINAGA_SL_BHIP:
				stmt.setString(5, "HERMANOS LARRINAGA S.L. BHIP");
				break;

			case IES_BALMASEDA_BHI:
				stmt.setString(5, "IES BALMASEDA BHI");
				break;

			case IES_BARRUTIALDE_BHI:
				stmt.setString(5, "IES BARRUTIALDE BHI");
				break;

			case IES_DOLORESIBARRURI_BHI:
				stmt.setString(5, "IES DOLORES IBARRURI BHI");
				break;

			case IES_ESKURTZE_BHI:
				stmt.setString(5, "IES ESKURTZE BHI");
				break;

			case IES_FRAYJUAN_DE_ZUMARRAGA_DURANGO_BHI:
				stmt.setString(5, "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI");
				break;

			case IES_GERNIKA_BHI:
				stmt.setString(5, "IES GERNIKA BHI");
				break;

			case IES_IBARREKOLANDA_BHI:
				stmt.setString(5, "IES IBARREKOLANDA BHI");
				break;

			case IES_JOSEMIGUELBARANDIARAN_BHI:
				stmt.setString(5, "IES JOSE MIGUEL BARANDIARAN BHI");
				break;

			case IES_JUAN_ANTONIO_ZUNZUNEGUI_BHI:
				stmt.setString(5, "IES JUAN ANTONIO ZUNZUNEGUI BHI");
				break;

			case IES_LEKEITIO_BHI:
				stmt.setString(5, "IES LEKEITIO BHI");
				break;

			case IES_MARTIN_DE_BERTENDONA_BHI:
				stmt.setString(5, "IES Martín de Bertendona BHI");
				break;

			case IES_MUNGIA_BHI:
				stmt.setString(5, "IES MUNGIA BHI");
				break;

			case IES_ONDARROA_BHI:
				stmt.setString(5, "IES ONDARROA BHI");
				break;

			case IES_SATURNINO_DE_LA_PEÑA_BHI:
				stmt.setString(5, "IES SATURNINO DE LA PEÑA BHI");
				break;

			case IMFPB_GERNIKA_LUMO_OLHUI:
				stmt.setString(5, "IMFPB GERNIKA-LUMO OLHUI");
				break;

			case IMFPB_BASAURI_OLHUI:
				stmt.setString(5, "IMFPB BASAURI OLHUI");
				break;

			case IMFPB_BERMEO_OLHUI:
				stmt.setString(5, "IMFPB BERMEO OLHUI");
				break;

			case IMFPB_BITURITXA_BARAKALDO_OLHUI:
				stmt.setString(5, "IMFPB BITURITXA-BARAKALDO OLHUI");
				break;

			case IMFPB_DURANGO_OLHUI:
				stmt.setString(5, "IMFPB DURANGO OLHUI");
				break;

			case IMFPB_ERANDIO_OLHUI:
				stmt.setString(5, "IMFPB ERANDIO OLHUI");
				break;

			case IMFPB_ERMUA_MALLABIA_OLHUI:
				stmt.setString(5, "IMFPB ERMUA-MALLABIA OLHUI");
				break;

			case IMFPB_MUNGIA_OLHUI:
				stmt.setString(5, "IMFPB MUNGIA OLHUI");
				break;

			case IMFPB_PORTUGALETE_OLHUI:
				stmt.setString(5, "IMFPB PORTUGALETE OLHUI");
				break;

			case IMFPB_SANTURTZI_OLHUI:
				stmt.setString(5, "IMFPB SANTURTZI OLHUI");
				break;

			case IMFPB_SESTAO_OLHUI:
				stmt.setString(5, "IMFPB SESTAO OLHUI");
				break;

			case MARGOTU_OLHIP:
				stmt.setString(5, "MARGOTU OLHIP");
				break;

			case MARIA_INMACULADA_BHIP:
				stmt.setString(5, "MARIA INMACULADA BHIP");
				break;

			case PASTELERIA_COMERCIOBIZKAIA_OLHIP:
				stmt.setString(5, "PASTELERÍA Y COMERCIO BIZKAIA OLHIP");
				break;

			case SOPEÑABILBAO:
				stmt.setString(5, "Sopeña Bilbao");
				break;

			case STA_MARIA_DE_ARTAGAN_BHIP:
				stmt.setString(5, "STA. MARIA DE ARTAGAN BHIP");
				break;

			case TXORIERRIPOLITEKNIKOA:
				stmt.setString(5, "Txorierri Politeknikoa");
				break;

			case UNED_UNIVERSIDADNACIONALESPAÑOLA_A_DISTANCIA:
				stmt.setString(5, "UNED (Universidad Nacional Española a Distancia)");
				break;

			case UNIVERSIDAD_DEUSTO:
				stmt.setString(5, "Universidad de Deusto");
				break;

			case UPV_EHU:
				stmt.setString(5, "UPV/EHU");
				break;

			case ZABALBURUIKASTETXEA_S_COOP:
				stmt.setString(5, "Zabalburu Ikastetxea S. Coop");
				break;

			default:
				System.out.println("Tipo invalido");
			}
			stmt.setString(6, p.getFechas());
			stmt.setString(7, p.getDuracion());
			stmt.setString(8, p.getEmpresaPracticas());
			stmt.setBoolean(9, p.isEmpresaNuestra());

			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarApoyoPracticas(String apoyo, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!apoyo.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_APOYOPRACTICAS);
				stmt.setString(1, apoyo);
				stmt.setString(2, nom);
				if (stmt.executeUpdate() > 0) {
					check = true;
				}
				stmt.close();
			} else {
				check = true;
			}
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFormacionPracticas(String formacion, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (formacion.equals("FP Basica")) {
				formacion = "FP_Basica";
			}
			stmt = con.prepareStatement(SQLUPDATEFORMACIONPRACTICAS);
			stmt.setString(1, formacion);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarCurso(int curso, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATECURSO);
			stmt.setInt(1, curso);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarCentro(String centro, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			switch (centro) {
			case "CPIFP Jesuitak Politeknikoa":
				centro = "CPIFP_JesuitakPoliteknikoa";
				break;

			case "CPIFP Salesianos Deusto":
				centro = "CPIFP_SalesianosDeusto";
				break;

			case "CPIFP Peñascal":
				centro = "CPIFP_Peñascal";
				break;

			case "CIFP Lea-Artibai":
				centro = "CIFP_Lea_Artibai";
				break;

			case "CIFP Arratiako Zulaibar Lanbide Ikastegia":
				centro = "CIFP_ArratiakoZulaibar_LanbideIkastegia";
				break;

			case "CIFP Uni Eibar Ermua":
				centro = "CIFP_Uni_EibarErmua";
				break;

			case "CIFP Elorrieta Erreka Mari GBLHI":
				centro = "CIFP_ElorrietaErreka_Mari_GBLHI";
				break;

			case "CPIFP Harrobia":
				centro = "CPIFP_Harrobia";
				break;

			case "CPIFP Maristak Durango":
				centro = "CPIFP_MaristakDurango";
				break;

			case "Zabalburu Ikastetxea S. Coop":
				centro = "ZabalburuIkastetxea_S_Coop";
				break;

			case "CIFP Construcción Bizkaia LHII":
				centro = "CIFP_ConstruccionBizkaia_LHII";
				break;

			case "CPIFP Barakaldo":
				centro = "CPIFP_Barakaldo";
				break;

			case "CIFP Tartanga GBLHI":
				centro = "CIFP_Tartanga_GBLHI";
				break;

			case "CIFP Hostelería/Hostalaritza LHII":
				centro = "CIFP_Hosteleria_Hostalaritza_LHII";
				break;

			case "CIFP Andra Mari BHI":
				centro = "CIFP_Andra_Mari_BHI";
				break;

			case "CIFP Fadura GBLHI":
				centro = "CIFP_Fadura_GBLHI";
				break;

			case "CIFP Iurreta GBLHI":
				centro = "CIFP_Iurreta_GBLHI";
				break;

			case "CIFP Escuela de Hostelería LHII":
				centro = "CIFP_EscuelaHosteleria_LHII";
				break;

			case "CIFP Repelega GBLHI":
				centro = "CIFP_Repelega_GBLHI";
				break;

			case "CIFP San Jorge GBLHI":
				centro = "CIFP_SanJorge_GBLHI";
				break;

			case "CIFP Calasanz Lanbide Ikastegia":
				centro = "CIFP_Calasanz_LanbideIkastegia";
				break;

			case "CPIFP Innovación Social Diego Berguices-Otxarkoaga":
				centro = "CPIFP_InnovacionSocialDiego_Berguices_Otxarkoaga";
				break;

			case "CPIFP San Viator":
				centro = "CPIFP_SanViator";
				break;

			case "UPV/EHU":
				centro = "UPV_EHU";
				break;

			case "Universidad de Deusto":
				centro = "Universidad_Deusto";
				break;

			case "Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari":
				centro = "EscuelaUniversitariaMagisterio_BAM_Begoñako_Andra_Mari";
				break;

			case "UNED (Universidad Nacional Española a Distancia)":
				centro = "UNED_UniversidadNacionalEspañola_A_Distancia";
				break;

			case "CIFP Emilio Campuzano":
				centro = "CIFP_EmilioCampuzano";
				break;

			case "Centro San Luis":
				centro = "CentroSanLuis";
				break;

			case "Centro Mikeldi":
				centro = "CentroMikeldi";
				break;

			case "Txorierri Politeknikoa":
				centro = "TxorierriPoliteknikoa";
				break;

			case "Sopeña Bilbao":
				centro = "SopeñaBilbao";
				break;

			case "CIFP Bidebieta":
				centro = "CIFP_Bidebieta";
				break;

			case "CIFP Ibaiondo":
				centro = "CIFP_Ibaiondo";
				break;

			case "IES DOLORES IBARRURI BHI":
				centro = "IES_DOLORESIBARRURI_BHI";
				break;

			case "CIFP ZORNOTZA LHII":
				centro = "CIFP_ZORNOTZA_LHII";
				break;

			case "CPES ORUE ESKOLA BHIP":
				centro = "CPES_ORUE_ESKOLA_BHIP";
				break;

			case "IES BARRUTIALDE BHI":
				centro = "IES_BARRUTIALDE_BHI";
				break;

			case "IES BALMASEDA BHI":
				centro = "IES_BALMASEDA_BHI";
				break;

			case "CPES BAGABILTZA BHIP":
				centro = "CPES_BAGABILTZA_BHIP";
				break;

			case "IMFPB BITURITXA-BARAKALDO OLHUI":
				centro = "IMFPB_BITURITXA_BARAKALDO_OLHUI";
				break;

			case "CPES IKASAUTO BHIP":
				centro = "CPES_IKASAUTO_BHIP";
				break;

			case "IMFPB BASAURI OLHUI":
				centro = "IMFPB_BASAURI_OLHUI";
				break;

			case "CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII":
				centro = "CIFP_NAUTICOBERMEO_BERMEOKONAUTIKA_LHII";
				break;

			case "IMFPB BERMEO OLHUI":
				centro = "IMFPB_BERMEO_OLHUI";
				break;

			case "CIFP TXURDINAGA LHII":
				centro = "CIFP_TXURDINAGA_LHII";
				break;

			case "IES ESKURTZE BHI":
				centro = "IES_ESKURTZE_BHI";
				break;

			case "IES IBARREKOLANDA BHI":
				centro = "IES_IBARREKOLANDA_BHI";
				break;

			case "CPEIPS ANGELES CUSTODIOS HLBHIP":
				centro = "CPEIPS_ANGELESCUSTODIOS_HLBHIP";
				break;

			case "CPES ALMI BHIP":
				centro = "CPES_ALMI_BHIP";
				break;

			case "CPES ARANGOYA BHIP":
				centro = "CPES_ARANGOYA_BHIP";
				break;

			case "CPES ARCE BHIP":
				centro = "CPES_ARCE_BHIP";
				break;

			case "CPES ARMENGOL BHIP":
				centro = "CPES_ARMENGOL_BHIP";
				break;

			case "CRUZ ROJA":
				centro = "CRUZROJA";
				break;

			case "ESCUELA SUPERIOR DE HOSTELERÍA BILBAO":
				centro = "ESCUELASUPERIORHOSTELERIABILBAO";
				break;

			case "FERNANDO BHIP":
				centro = "FERNANDO_BHIP";
				break;

			case "HERMANOS LARRINAGA SL BHIP":
				centro = "HERMANOSLARRINAGA_SL_BHIP";
				break;

			case "MARIA INMACULADA BHIP":
				centro = "MARIA_INMACULADA_BHIP";
				break;

			case "STA MARIA DE ARTAGAN BHIP":
				centro = "STA_MARIA_DE_ARTAGAN_BHIP";
				break;

			case "ADSIS BILBAO OLHIP":
				centro = "ADSIS_BILBAO_OLHIP";
				break;

			case "PASTELERÍA Y COMERCIO BIZKAIA OLHIP":
				centro = "PASTELERIA_COMERCIOBIZKAIA_OLHIP";
				break;

			case "MARGOTU OLHIP":
				centro = "MARGOTU_OLHIP";
				break;

			case "CPIFP HARROBIA LHIPI":
				centro = "CPIFP_HARROBIA_LHIPI";
				break;

			case "CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII":
				centro = "CIFP_AGRARIODERIO_DERIONEKAZARITZA_LHII";
				break;

			case "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI":
				centro = "IES_FRAYJUAN_DE_ZUMARRAGA_DURANGO_BHI";
				break;

			case "IMFPB DURANGO OLHUI":
				centro = "IMFPB_DURANGO_OLHUI";
				break;

			case "CPES IBAIZABAL IKASTOLA BHIP":
				centro = "CPES_IBAIZABAL_IKASTOLA_BHIP";
				break;

			case "IMFPB ERANDIO OLHUI":
				centro = "IMFPB_ERANDIO_OLHUI";
				break;

			case "CIFP HOSTELERÍA/OSTALARITZA LHII":
				centro = "CIFP_HOSTELERIA_OSTALARITZA_LHII";
				break;

			case "IES GERNIKA BHI":
				centro = "IES_GERNIKA_BHI";
				break;

			case "IMFPB GERNIKA-LUMO OLHUI":
				centro = "IMFPB_GERNIKA_LUMO_OLHUI";
				break;

			case "CPFPB ADSIS GETXO OLHIP":
				centro = "CPFPB_ADSIS_GETXO_OLHIP";
				break;

			case "IES JOSE MIGUEL BARANDIARAN BHI":
				centro = "IES_JOSEMIGUELBARANDIARAN_BHI";
				break;

			case "CPFPB ADSIS LEIOA OLHIP":
				centro = "CPFPB_ADSISLEIOA_OLHIP";
				break;

			case "IES LEKEITIO BHI":
				centro = "IES_LEKEITIO_BHI";
				break;

			case "CPES ESPERANZA ALHAMA BHIP":
				centro = "CPES_ESPERANZA_ALHAMA_BHIP";
				break;

			case "IMFPB ERMUA-MALLABIA OLHUI":
				centro = "IMFPB_ERMUA_MALLABIA_OLHUI";
				break;

			case "CPFPB PEÑASCAL MARKINA OLHIP":
				centro = "CPFPB_PEÑASCALMARKINA_OLHIP";
				break;

			case "IES MUNGIA BHI":
				centro = "IES_MUNGIA_BHI";
				break;

			case "IMFPB MUNGIA OLHUI":
				centro = "IMFPB_MUNGIA_OLHUI";
				break;

			case "CPIFP SOMORROSTRO LHIPI":
				centro = "CPIFP_SOMORROSTRO_LHIPI";
				break;

			case "IES ONDARROA BHI":
				centro = "IES_ONDARROA_BHI";
				break;

			case "CPES NTRA SRA DE LA ANTIGUA BHIP":
				centro = "CPES_NTRA_SRA_DE_LA_ANTIGUA_BHIP";
				break;

			case "CPFPB MEATZALDEA OLHIP":
				centro = "CPFPB_MEATZALDEA_OLHIP";
				break;

			case "IES JUAN ANTONIO ZUNZUNEGUI BHI":
				centro = "IES_JUAN_ANTONIO_ZUNZUNEGUI_BHI";
				break;

			case "IMFPB PORTUGALETE OLHUI":
				centro = "IMFPB_PORTUGALETE_OLHUI";
				break;

			case "CPES XABIER BHIP":
				centro = "CPES_XABIER_BHIP";
				break;

			case "IMFPB SANTURTZI OLHUI":
				centro = "IMFPB_SANTURTZI_OLHUI";
				break;

			case "CPES EIDE BHIP":
				centro = "CPES_EIDE_BHIP";
				break;

			case "IES SATURNINO DE LA PEÑA BHI":
				centro = "IES_SATURNINO_DE_LA_PEÑA_BHI";
				break;

			case "IMFPB SESTAO OLHUI":
				centro = "IMFPB_SESTAO_OLHUI";
				break;

			case "CPEIPS NTRA SRA DE LA ANTIGUA HLBHIP":
				centro = "CPEIPS_NTRA_SRA_DE_LA_ANTIGUA_HLBHIP";
				break;

			case "CPEIPS MARISTAS-SAN MIGUEL HLBHIP":
				centro = "CPEIPS_MARISTAS_SANMIGUEL_HLBHIP";
				break;

			case "IES Martín de Bertendona BHI":
				centro = "IES_MARTIN_DE_BERTENDONA_BHI";
				break;
			}

			stmt = con.prepareStatement(SQLUPDATECENTRO);
			stmt.setString(1, centro);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFechas(String fechas, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEFECHAS);
			stmt.setString(1, fechas);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarDuracion(String dur, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEDURACION);
			stmt.setString(1, dur);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEmpPracticas(String practicas, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATE_EMPRESAPRACTICAS);
			stmt.setString(1, practicas);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEmpApnabi(boolean empNuestro, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATE_EMPRESANUESTRA);
			stmt.setBoolean(1, empNuestro);
			stmt.setString(2, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar la persona.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarPersonaPracticas(String nom) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETEPERSONAPRACTICAS);
			stmt.setString(1, nom);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("La persona no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public Map<String, AnalisisPuesto> mostrarAnalisisPuestos() {
		AnalisisPuesto aP;
		Map<String, AnalisisPuesto> aPs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLANALISISPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aP = new AnalisisPuesto();
				aP.setEmpresa(rs.getString("EMPRESA"));
				aP.setPuesto(rs.getString("PUESTO"));
				aP.setHorario(rs.getString("HORARIO"));
				aP.setFinde(Finde.valueOf(rs.getString("FINDE").toUpperCase()));
				aP.setTurnos(rs.getBoolean("TURNOS"));
				aP.setMin_Formacion(Formacion.valueOf(rs.getString("MIN_FORMACION").toUpperCase()));
				aP.setUbicacion(rs.getString("UBICACION"));
				aP.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				aP.setReq_idiomas(rs.getString("REQ_IDIOMAS"));
				aP.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				aP.setCargo(rs.getString("CARGO"));
				aP.setTelefono(rs.getString("TELEFONO"));
				aP.setEmail(rs.getString("EMAIL"));
				aP.setResponsableApnabi(rs.getString("RESPONSABLEAPNABI"));
				aP.setEsfuerzoFisico(rs.getBoolean("ESFUERZOFISICO"));
				aP.setResistencia(rs.getBoolean("RESISTENCIA"));
				aP.setComunicacion(Comunicacion.valueOf(rs.getString("COMUNICACION").toUpperCase()));
				aP.setCaractersiticasSensoriales(Sensoriales.valueOf(rs.getString("SENSORIALES").toUpperCase()));
				aPs.put(aP.getEmpresa(), aP);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger los analisis de puestos.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aPs;
	}

	@Override
	public Map<String, AnalisisPuesto> mostrarAPEmpresas() {
		AnalisisPuesto aP;
		Map<String, AnalisisPuesto> aPs = new TreeMap<>();
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLAP_EMPRESA);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				aP = new AnalisisPuesto();
				aP.setEmpresa(rs.getString("EMPRESA"));
				aPs.put(aP.getEmpresa(), aP);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println(
					"Un error ha occurrido al intentar recoger los nombres de las empresas de los analisis de puestos.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aPs;
	}

	@Override
	public AnalisisPuesto getAnalisisPuesto(String nom) {
		AnalisisPuesto aP = new AnalisisPuesto();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTANALISISPUESTO);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				aP.setEmpresa(rs.getString("EMPRESA"));
				aP.setPuesto(rs.getString("PUESTO"));
				aP.setHorario(rs.getString("HORARIO"));
				aP.setFinde(Finde.valueOf(rs.getString("FINDE").toUpperCase()));
				aP.setTurnos(rs.getBoolean("TURNOS"));
				aP.setMin_Formacion(Formacion.valueOf(rs.getString("MIN_FORMACION").toUpperCase()));
				aP.setUbicacion(rs.getString("UBICACION"));
				aP.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				aP.setReq_idiomas(rs.getString("REQ_IDIOMAS"));
				aP.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				aP.setCargo(rs.getString("CARGO"));
				aP.setTelefono(rs.getString("TELEFONO"));
				aP.setEmail(rs.getString("EMAIL"));
				aP.setResponsableApnabi(rs.getString("RESPONSABLEAPNABI"));
				aP.setEsfuerzoFisico(rs.getBoolean("ESFUERZOFISICO"));
				aP.setResistencia(rs.getBoolean("RESISTENCIA"));
				aP.setComunicacion(Comunicacion.valueOf(rs.getString("COMUNICACION").toUpperCase()));
				aP.setCaractersiticasSensoriales(Sensoriales.valueOf(rs.getString("SENSORIALES").toUpperCase()));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aP;
	}

	@Override
	public boolean verificarAP(String nom) {
		boolean existe = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTANALISISPUESTO);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				existe = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
	}

	@Override
	public boolean añadirAnalisisPuesto(AnalisisPuesto aP) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTANALISISPUESTO);
			stmt.setString(1, aP.getEmpresa());
			stmt.setString(2, aP.getPuesto());
			stmt.setString(3, aP.getHorario());
			switch (aP.getFinde()) {
			case SOLODOMINGOS:
				stmt.setString(4, "SoloDomingos");
				break;

			case NO:
				stmt.setString(4, "No");
				break;

			case SOLOSABADOS:
				stmt.setString(4, "SoloSabados");
				break;

			case SI:
				stmt.setString(4, "Si");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setBoolean(5, aP.isTurnos());
			switch (aP.getMin_Formacion()) {
			case AT:
				stmt.setString(6, "AT");
				break;

			case BACHILLERATO:
				stmt.setString(6, "Bachillerato");
				break;

			case DOCTORADO:
				stmt.setString(6, "Doctorado");
				break;

			case EPA:
				stmt.setString(6, "EPA");
				break;

			case ESO:
				stmt.setString(6, "ESO");
				break;

			case FP_BASICA:
				stmt.setString(6, "FP_Basica");
				break;

			case GM:
				stmt.setString(6, "GM");
				break;

			case GS:
				stmt.setString(6, "GS");
				break;

			case MASTER:
				stmt.setString(6, "Master");
				break;

			case PRIMARIA:
				stmt.setString(6, "Primaria");
				break;

			case UNIVERSIDAD:
				stmt.setString(6, "Universidad");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(7, aP.getUbicacion());
			switch (aP.getSector()) {
			case AGRICULTURA_GANADERIA:
				stmt.setString(8, "Agricultura_Ganaderia");
				break;

			case BIENESCONSUMO:
				stmt.setString(8, "BienesConsumo");
				break;

			case COMERCIO_ESTABLECIMIENTOS:
				stmt.setString(8, "Comercio_Establecimientos");
				break;

			case COMERCIOELECTRONICO:
				stmt.setString(8, "ComercioElectronico");
				break;

			case CONSTRUCCION:
				stmt.setString(8, "Construccion");
				break;

			case DEPORTE_OCIO:
				stmt.setString(8, "Deporte_Ocio");
				break;

			case ENERGIA_MEDIOAMBIENTE:
				stmt.setString(8, "Energia_MedioAmbiente");
				break;

			case FINANZAS_SEGUROS_BIENESINMUEBLES:
				stmt.setString(8, "Finanzas_Seguros_BienesInmuebles");
				break;

			case INTERNET:
				stmt.setString(8, "Internet");
				break;

			case LOGISTICA_TRANSPORTE:
				stmt.setString(8, "Logistica_Transporte");
				break;

			case MEDIOSCOMUNICACION_MARKETING:
				stmt.setString(8, "MediosComunicacion_Marketing");
				break;

			case METALURGIA_ELECTRONICA:
				stmt.setString(8, "Metalurgia_Electronica");
				break;

			case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
				stmt.setString(8, "ProductosQuimicos_MateriasPrimas");
				break;

			case SALUD_INDUSTRIAFARMACEUTICA:
				stmt.setString(8, "Salud_IndustriaFarmaceutica");
				break;

			case SERVICIOS:
				stmt.setString(8, "Servicios");
				break;

			case SOCIEDAD:
				stmt.setString(8, "Sociedad");
				break;

			case TECNOLOGIA_TELECOMUNICACIONES:
				stmt.setString(8, "Tecnologia_Telecomunicaciones");
				break;

			case TURISMO_HOSTELERIA:
				stmt.setString(8, "Turismo_Hosteleria");
				break;

			case VIDA:
				stmt.setString(8, "Vida");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(9, aP.getReq_idiomas());
			stmt.setString(10, aP.getContactoEmpresa());
			stmt.setString(11, aP.getCargo());
			stmt.setString(12, aP.getTelefono());
			stmt.setString(13, aP.getEmail());
			stmt.setString(14, aP.getResponsableApnabi());
			stmt.setBoolean(15, aP.isEsfuerzoFisico());
			stmt.setBoolean(16, aP.isResistencia());
			switch (aP.getComunicacion()) {
			case COMUNICACIONCONPERSONALEMPESA:
				stmt.setString(17, "ComunicacionConPersonalEmpesa");
				break;

			case COMUNICACIONCONPERSONALEMPRESA_FUERAEMPRESA:
				stmt.setString(17, "ComunicacionConPersonalEmpresa_FueraEmpresa");
				break;

			case COMUNICACIONCONPERSONASEXTERNASEMPRESA:
				stmt.setString(17, "ComunicacionConPersonasExternasEmpresa");
				break;

			case SIN_NECESIDADCOMUNICACION:
				stmt.setString(17, "Sin_NecesidadComunicacion");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			switch (aP.getCaractersiticasSensoriales()) {
			case LIMPIEZA:
				stmt.setString(18, "Limpieza");
				break;

			case LUZ:
				stmt.setString(18, "Luz");
				break;

			case ORDEN:
				stmt.setString(18, "Orden");
				break;

			case RUIDO:
				stmt.setString(18, "Ruido");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarHorario(String horario, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEHORARIO);
			stmt.setString(1, horario);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarPuesto(String puesto, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEPUESTO);
			stmt.setString(1, puesto);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarFormacionMinima(String formacion, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			if (formacion.equals("FP Basica")) {
				formacion = "FP_Basica";
			}
			stmt = con.prepareStatement(SQLUPDATEMINFORMACION);
			stmt.setString(1, formacion);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarUbicacion(String ubicacion, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEUBICACION);
			stmt.setString(1, ubicacion);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarIdiomaReq(String idioma, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATEREQ_IDIOMA);
			stmt.setString(1, idioma);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarAPContactoEmpresa(String cE, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATECONTACTOEMPRESA_AP);
			stmt.setString(1, cE);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarNumTelefono(String telefono, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATE_TELEFONO);
			stmt.setString(1, telefono);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEmail(String email, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATE_EMAIL);
			stmt.setString(1, email);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarResponsableApnabi(String persona, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATERESPONSABLEAPNABI);
			stmt.setString(1, persona);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarComunicacion(String com, String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLUPDATECOMUNICACION);
			stmt.setString(1, com);
			stmt.setString(2, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha ocurrido un error al intentar modificar el analisis de puesto.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean eliminarAnalisisPuesto(String emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETEANALISISPUESTO);
			stmt.setString(1, emp);
			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("El analisis de puesto no se pudo borrar.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
