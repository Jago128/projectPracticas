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
	final String SQLCODEMPRESA = "SELECT COD_EMPRESA FROM EMPRESA WHERE NOM_EMPRESA=?";
	final String SQLSELECTEMPRESA = "SELECT * FROM EMPRESA WHERE NOM_EMPRESA=?";
	final String SQLINSERTEMPRESA = "INSERT INTO EMPRESA (NOM_EMPRESA, SECTOR, PUESTO, DATOSCONTACTO, CONTACTOEMPRESA, CONTACTOAPNABI, ESTADO) VALUES (?,?,?,?,?,?,?)";
	final String SQLUPDATEDATOS = "UPDATE EMPRESA SET DATOSCONTACTO=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOEMPRESA = "UPDATE EMPRESA SET CONTACTOEMPRESA=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOAPNABI = "UPDATE EMPRESA SET CONTACTOAPNABI=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATEESTADO = "UPDATE EMPRESA SET ESTADO=? WHERE NOM_EMPRESA=?";
	final String SQLDELETE_EMPRESA = "DELETE FROM EMPRESA WHERE NOM_EMPRESA=?";

	final String SQLSELECTCONTACTOS = "SELECT * FROM CONTACTO WHERE COD_EMPRESA=?";
	final String SQLINSERTCONTACTO = "INSERT INTO CONTACTO (CONTACTO1, CONTACTO2, CONTACTO3, CONTACTO4, OBSERVACIONES, RESULTADOULTIMO, INFOULTIMO, RESULTADOFINAL, FECHARESOLUCION, COD_EMPRESA) VALUES (?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATECONTACTO1 = "UPDATE CONTACTO SET CONTACTO1=? WHERE COD_CONTACTO=?";
	final String SQLUPDATECONTACTO2 = "UPDATE CONTACTO SET CONTACTO2=? WHERE COD_CONTACTO=?";
	final String SQLUPDATECONTACTO3 = "UPDATE CONTACTO SET CONTACTO3=? WHERE COD_CONTACTO=?";
	final String SQLUPDATECONTACTO4 = "UPDATE CONTACTO SET CONTACTO4=? WHERE COD_CONTACTO=?";
	final String SQLUPDATE_EMPRESAOBSERVACIONES = "UPDATE CONTACTO SET OBSERVACIONES=? WHERE COD_CONTACTO=?";
	final String SQLUPDATERESULTADOULTIMO = "UPDATE CONTACTO SET RESULTADOULTIMO=? WHERE COD_CONTACTO=?";
	final String SQLUPDATEINFOULTIMO = "UPDATE CONTACTO SET INFOULTIMO=? WHERE COD_CONTACTO=?";
	final String SQLUPDATERESULTADOFINAL = "UPDATE CONTACTO SET RESULTADOFINAL=? WHERE COD_CONTACTO=?";
	final String SQLUPDATEFECHARESOLUCION = "UPDATE CONTACTO SET FECHARESOLUCION=? WHERE COD_CONTACTO=?";
	final String SQLDELETECONTACTO = "DELETE FROM CONTACTO WHERE COD_EMPRESA=?";

	final String SQLPERSONAS = "SELECT * FROM PERSONA";
	final String SQLNOMPERSONAS = "SELECT NOM_P FROM PERSONA";
	final String SQLSELECTPERSONA = "SELECT * FROM PERSONA WHERE NOM_P=?";
	final String SQLINSERTPERSONA = "INSERT INTO PERSONA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATEAPOYO = "UPDATE PERSONA SET APOYO=? WHERE NOM_P=?";
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

	final String SQLPERSONASINCLUSION = "SELECT * FROM PERSONASINCLUSION";
	final String SQLNOMPERSONASINCLUSION = "SELECT NOMBRE FROM PERSONASINCLUSION";
	final String SQLSELECTPERSONAINCLUSION = "SELECT * FROM PERSONASINCLUSION WHERE NOMBRE=?";
	final String SQLINSERTPERSONAINCLUSION = "INSERT INTO PERSONASINCLUSION VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATE_EDAD = "UPDATE PERSONASINCLUSION SET EDAD=? WHERE NOMBRE=?";
	final String SQLUPDATEMUNICIPIO = "UPDATE PERSONASINCLUSION SET MUNICIPIO=? WHERE NOMBRE=?";
	final String SQLUPDATEFORMACIONPI = "UPDATE PERSONASINCLUSION SET FORMACION=? WHERE NOMBRE=?";
	final String SQLUPDATE_ESPECIALIDADPI = "UPDATE PERSONASINCLUSION SET ESPECIALIDAD=? WHERE NOMBRE=?";
	final String SQLUPDATEOTROS = "UPDATE PERSONASINCLUSION SET OTROS=? WHERE NOMBRE=?";
	final String SQLUPDATEIDIOMA = "UPDATE PERSONASINCLUSION SET IDIOMA=? WHERE NOMBRE=?";
	final String SQLUPDATEULTIMOAÑOTRABAJADOPI = "UPDATE PERSONASINCLUSION SET ULTIMOAÑOTRABAJADO=? WHERE NOMBRE=?";
	final String SQLUPDATESECTORINTERESPI = "UPDATE PERSONASINCLUSION SET SECTORINTERES=? WHERE NOMBRE=?";
	final String SQLUPDATEINTERESESPERSONALESPI = "UPDATE PERSONASINCLUSION SET INTERESESPERSONALES=? WHERE NOMBRE=?";
	final String SQLUPDATESITUACIONACTUALPI = "UPDATE PERSONASINCLUSION SET SITUACIONACTUAL=? WHERE NOMBRE=?";
	final String SQLUPDATEACCESIBILIDADPI = "UPDATE PERSONASINCLUSION SET ACCESIBILIDAD=? WHERE NOMBRE=?";
	final String SQLUPDATECV = "UPDATE PERSONASINCLUSION SET CV=? WHERE NOMBRE=?";
	final String SQLUPDATEPERSONAFACILITADORA = "UPDATE PERSONASINCLUSION SET PERSONAFACILITADORA=? WHERE NOMBRE=?";
	final String SQLDELETEPERSONAINCLUSION = "DELETE FROM PERSONASINCLUSION WHERE NOMBRE=?";

	final String SQLANALISISPERSONAS = "SELECT * FROM ANALISISPUESTO";
	final String SQLAP_EMPRESA = "SELECT EMPRESA FROM ANALISISPUESTO";
	final String SQLSELECTANALISISPUESTO = "SELECT * FROM ANALISISPUESTO WHERE EMPRESA=?";
	final String SQLINSERTANALISISPUESTO = "INSERT INTO ANALISISPUESTO VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATEPUESTO = "UPDATE ANALISISPUESTO SET PUESTO=? WHERE EMPRESA=?";
	final String SQLUPDATEHORARIO = "UPDATE ANALISISPUESTO SET HORARIO=? WHERE EMPRESA=?";
	final String SQLUPDATEMINFORMACION = "UPDATE ANALISISPUESTO SET MIN_FORMACION=? WHERE EMPRESA=?";
	final String SQLUPDATEUBICACION = "UPDATE ANALISISPUESTO SET UBICACION=? WHERE EMPRESA=?";
	final String SQLUPDATEREQ_IDIOMA = "UPDATE ANALISISPUESTO SET REQ_IDIOMAS=? WHERE EMPRESA=?";
	final String SQLUPDATEAPCONTACTOEMPRESA = "UPDATE ANALISISPUESTO SET CONTACTOEMPRESA=? WHERE EMPRESA=?";
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
				empresa.setCodEmpresa(rs.getInt("COD_EMPRESA"));
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
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
				empresa.setCodEmpresa(rs.getInt("COD_EMPRESA"));
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
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
	public int getCodEmpresa(String nom) {
		int cod = 0;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLCODEMPRESA);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cod = rs.getInt("COD_EMPRESA");
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger el codigo de la empresa.");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cod;
	}

	@Override
	public boolean añadirEmpresa(Empresa emp) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTEMPRESA);
			stmt.setString(1, emp.getNom_empresa());
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

			stmt.setString(3, emp.getPuesto());
			stmt.setString(4, emp.getDatosContacto());
			stmt.setString(5, emp.getContactoEmpresa());
			stmt.setString(6, emp.getContactoApnabi());
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
				stmt = con.prepareStatement(SQLUPDATEDATOS);
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

			stmt = con.prepareStatement(SQLUPDATEESTADO);
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
	public Contacto getContacto(int empId) {
		Contacto cont = new Contacto();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTCONTACTOS);
			stmt.setInt(1, empId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				cont.setCodContacto(rs.getInt("COD_CONTACTO"));
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
				cont.setCodEmpresa(rs.getInt("COD_EMPRESA"));
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
	public boolean añadirContacto(Contacto cont, int id) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTCONTACTO);
			stmt.setString(1, cont.getContacto1());
			stmt.setString(2, cont.getContacto2());
			stmt.setString(3, cont.getContacto3());
			stmt.setString(4, cont.getContacto4());
			stmt.setString(5, cont.getObservaciones());
			switch (cont.getResultadoUltimoContacto()) {
			case COMUNICACION_SINRESPUESTA:
				stmt.setString(6, "Comunicacion_SinRespuesta");
				break;

			case INICIO_VALORACIONOFERTA:
				stmt.setString(6, "Inicio_ValoracionOferta");
				break;

			case RESPUESTA_NOCONCLUYENTE:
				stmt.setString(6, "Respuesta_NoConcluyente");
				break;

			case RESPUESTA_POSPUESTA:
				stmt.setString(6, "Respuesta_Pospuesta");
				break;

			case REUNION_PROGRAMADA:
				stmt.setString(6, "Reunion_Programada");
				break;

			default:
				System.out.println("Tipo incorrecto.");
				break;
			}

			stmt.setString(7, cont.getInfoUltimo());
			switch (cont.getResultadoFinal()) {
			case CONVENIO_COLABORACION:
				stmt.setString(8, "Convenio_Colaboracion");
				break;

			case MEDIDAS_ALTERNATIVAS:
				stmt.setString(8, "Medidas_Alternativas");
				break;

			case OFERTA_EMPLEO:
				stmt.setString(8, "Oferta_Empleo");
				break;

			case RELACION_CONCLUIDA:
				stmt.setString(8, "Relacion_Concluida");
				break;

			case RELACION_POSPUESTA:
				stmt.setString(8, "Relacion_Pospuesta");
				break;

			default:
				System.out.println("Tipo incorrecto.");
			}

			stmt.setDate(9, Date.valueOf(cont.getFechaResolucion()));
			stmt.setInt(10, id);
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
	public boolean modificarContacto1(String contacto1, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto1.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO1);
				stmt.setDate(1, Date.valueOf(contacto1));
				stmt.setInt(2, id);
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
	public boolean modificarContacto2(String contacto2, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto2.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO2);
				stmt.setDate(1, Date.valueOf(contacto2));
				stmt.setInt(2, id);
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
	public boolean modificarContacto3(String contacto3, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto3.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO3);
				stmt.setDate(1, Date.valueOf(contacto3));
				stmt.setInt(2, id);
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
	public boolean modificarContacto4(String contacto4, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!contacto4.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATECONTACTO4);
				stmt.setDate(1, Date.valueOf(contacto4));
				stmt.setInt(2, id);
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
	public boolean modificarObservaciones(String observaciones, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!observaciones.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATE_EMPRESAOBSERVACIONES);
				stmt.setString(1, observaciones);
				stmt.setInt(2, id);
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
	public boolean modificarResultadoUltimoContacto(String resultadoU, int id) {
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

				stmt = con.prepareStatement(SQLUPDATERESULTADOULTIMO);
				stmt.setString(1, resultadoU);
				stmt.setInt(2, id);
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
	public boolean modificarInformacionUltimoContacto(String infoU, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!infoU.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEINFOULTIMO);
				stmt.setString(1, infoU);
				stmt.setInt(2, id);
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
	public boolean modificarResultadoFinal(String resultadoF, int id) {
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
				stmt.setInt(2, id);
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
	public boolean modificarFechaResolucion(String fecResolucion, int id) {
		boolean check = false;

		this.openConnection();
		try {
			if (!fecResolucion.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEFECHARESOLUCION);
				stmt.setDate(1, Date.valueOf(fecResolucion));
				stmt.setInt(2, id);
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
	public boolean eliminarContacto(int id) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETECONTACTO);
			stmt.setInt(1, id);
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
		PersonaOrientacion personaOrientacion;
		Map<String, PersonaOrientacion> personaOrientacions = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				personaOrientacion = new PersonaOrientacion();
				personaOrientacion.setNombre(rs.getString("NOM_P"));
				personaOrientacion.setApoyo(rs.getString("APOYO"));
				personaOrientacion.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				personaOrientacion.setEspecialidad(rs.getString("ESPECIALIDAD"));
				personaOrientacion.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				personaOrientacion.setCvLink(rs.getString("CV"));
				personaOrientacion
						.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				personaOrientacion.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				personaOrientacion.setInteresesPersonales(rs.getString("INTERESESPERSONALES"));
				personaOrientacion.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				personaOrientacion.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				personaOrientacion.setIngles(Ingles.valueOf(rs.getString("INGLES")));
				personaOrientacion.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				personaOrientacion.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				personaOrientacion.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				personaOrientacion.setObservaciones(rs.getString("OBSERVACIONES"));
				personaOrientacions.put(personaOrientacion.getNombre(), personaOrientacion);
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
		return personaOrientacions;
	}

	@Override
	public Map<String, PersonaOrientacion> mostrarNomPersonas() {
		PersonaOrientacion personaOrientacion;
		Map<String, PersonaOrientacion> personaOrientacions = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				personaOrientacion = new PersonaOrientacion();
				personaOrientacion.setNombre(rs.getString("NOM_P"));
				personaOrientacions.put(personaOrientacion.getNombre(), personaOrientacion);
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
		return personaOrientacions;
	}

	@Override
	public PersonaOrientacion getPersona(String nom) {
		PersonaOrientacion personaOrientacion = new PersonaOrientacion();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				personaOrientacion.setNombre(rs.getString("NOM_P"));
				personaOrientacion.setApoyo(rs.getString("APOYO"));
				personaOrientacion.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				personaOrientacion.setEspecialidad(rs.getString("ESPECIALIDAD"));
				personaOrientacion.setSectorInteres(Sector.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				personaOrientacion.setCvLink(rs.getString("CV"));
				personaOrientacion
						.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				personaOrientacion.setUltimoAñoTrabajado(rs.getInt("ULTIMOAÑOTRABAJADO"));
				personaOrientacion.setInteresesPersonales(rs.getString("INTERESESPERSONALES"));
				personaOrientacion.setSituacionActual(rs.getString("SITUACIONACTUAL"));
				personaOrientacion.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				personaOrientacion.setIngles(Ingles.valueOf(rs.getString("INGLES")));
				personaOrientacion.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				personaOrientacion.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				personaOrientacion.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				personaOrientacion.setObservaciones(rs.getString("OBSERVACIONES"));
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
		return personaOrientacion;
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
	public boolean añadirPersona(PersonaOrientacion personaOrientacion) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTPERSONA);
			stmt.setString(1, personaOrientacion.getNombre());
			stmt.setString(2, personaOrientacion.getApoyo());
			switch (personaOrientacion.getFormacion()) {
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

			stmt.setString(4, personaOrientacion.getEspecialidad());
			switch (personaOrientacion.getSectorInteres()) {
			case AGRICULTURA_GANADERIA:
				stmt.setString(5, "Agricultura y ganadería");
				break;

			case BIENESCONSUMO:
				stmt.setString(5, "Bienes de consumo");
				break;

			case COMERCIOELECTRONICO:
				stmt.setString(5, "Comercio electrónico");
				break;

			case COMERCIO_ESTABLECIMIENTOS:
				stmt.setString(5, "Comercio y establecimientos");
				break;

			case CONSTRUCCION:
				stmt.setString(5, "Construcción");
				break;

			case DEPORTE_OCIO:
				stmt.setString(5, "Deporte y ocio");
				break;

			case ENERGIA_MEDIOAMBIENTE:
				stmt.setString(5, "Energía y medio ambiente");
				break;

			case FINANZAS_SEGUROS_BIENESINMUEBLES:
				stmt.setString(5, "Finanzas, seguros y bienes inmuebles");
				break;

			case INTERNET:
				stmt.setString(5, "Internet");
				break;

			case LOGISTICA_TRANSPORTE:
				stmt.setString(5, "Logística y transporte");
				break;

			case MEDIOSCOMUNICACION_MARKETING:
				stmt.setString(5, "Medios de comunicación y marketing");
				break;

			case METALURGIA_ELECTRONICA:
				stmt.setString(5, "Metalurgia y electrónica");
				break;

			case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
				stmt.setString(5, "Productos químicos y materias primas");
				break;

			case SALUD_INDUSTRIAFARMACEUTICA:
				stmt.setString(5, "Salud e industria farmacéutica");
				break;

			case SERVICIOS:
				stmt.setString(5, "Servicios");
				break;

			case SOCIEDAD:
				stmt.setString(5, "Sociedad");
				break;

			case TECNOLOGIA_TELECOMUNICACIONES:
				stmt.setString(5, "Tecnología y telecomunicaciones");
				break;

			case TURISMO_HOSTELERIA:
				stmt.setString(5, "Turismo y hostelería");
				break;

			case VIDA:
				stmt.setString(5, "Vida");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(6, personaOrientacion.getCvLink());
			switch (personaOrientacion.getCerfificadoDiscapacidad()) {
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

			stmt.setInt(8, personaOrientacion.getUltimoAñoTrabajado());
			stmt.setString(9, personaOrientacion.getInteresesPersonales());
			stmt.setString(10, personaOrientacion.getSituacionActual());

			switch (personaOrientacion.getEuskera()) {
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

			switch (personaOrientacion.getIngles()) {
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

			stmt.setString(13, personaOrientacion.getOtrosIdiomas());
			switch (personaOrientacion.getLocalidad()) {
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

			switch (personaOrientacion.getAccesibilidad()) {
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

			stmt.setString(16, personaOrientacion.getObservaciones());
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
				stmt = con.prepareStatement(SQLUPDATEAPOYO);
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

			stmt.setString(6, pI.getOtros());
			stmt.setString(7, pI.getIdioma());
			stmt.setInt(8, pI.getUltimoAñoTrabajado());
			switch (pI.getSectorInteres()) {
			case AGRICULTURA_GANADERIA:
				stmt.setString(9, "Agricultura_Ganaderia");
				break;

			case BIENESCONSUMO:
				stmt.setString(9, "BienesConsumo");
				break;

			case COMERCIO_ESTABLECIMIENTOS:
				stmt.setString(9, "Comercio_Establecimientos");
				break;

			case COMERCIOELECTRONICO:
				stmt.setString(9, "ComercioElectronico");
				break;

			case CONSTRUCCION:
				stmt.setString(9, "Construccion");
				break;

			case DEPORTE_OCIO:
				stmt.setString(9, "Deporte_Ocio");
				break;

			case ENERGIA_MEDIOAMBIENTE:
				stmt.setString(9, "Energia_MedioAmbiente");
				break;

			case FINANZAS_SEGUROS_BIENESINMUEBLES:
				stmt.setString(9, "Finanzas_Seguros_BienesInmuebles");
				break;

			case INTERNET:
				stmt.setString(9, "Internet");
				break;

			case LOGISTICA_TRANSPORTE:
				stmt.setString(9, "Logistica_Transporte");
				break;

			case MEDIOSCOMUNICACION_MARKETING:
				stmt.setString(9, "MediosComunicacion_Marketing");
				break;

			case METALURGIA_ELECTRONICA:
				stmt.setString(9, "Metalurgia_Electronica");
				break;

			case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
				stmt.setString(9, "ProductosQuimicos_MateriasPrimas");
				break;

			case SALUD_INDUSTRIAFARMACEUTICA:
				stmt.setString(9, "Salud_IndustriaFarmaceutica");
				break;

			case SERVICIOS:
				stmt.setString(9, "Servicios");
				break;

			case SOCIEDAD:
				stmt.setString(9, "Sociedad");
				break;

			case TECNOLOGIA_TELECOMUNICACIONES:
				stmt.setString(9, "Tecnologia_Telecomunicaciones");
				break;

			case TURISMO_HOSTELERIA:
				stmt.setString(9, "Turismo_Hosteleria");
				break;

			case VIDA:
				stmt.setString(9, "Vida");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(10, pI.getInteresesPersonales());
			stmt.setString(11, pI.getSituacionActual());
			switch (pI.getAccesibilidad()) {
			case CARNET:
				stmt.setString(12, "Carnet");
				break;

			case CARNET_COCHE:
				stmt.setString(12, "Carnet_Coche");
				break;

			case TRANSPORTE_PUBLICO:
				stmt.setString(12, "Transporte_Publico");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(13, pI.getCv());
			stmt.setString(14, pI.getPersonaFacilitadora());
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
	public Map<String, AnalisisPuesto> mostrarAnalisisPuestos() {
		AnalisisPuesto aP;
		Map<String, AnalisisPuesto> aPs = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLEMPRESAS);
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
			ResultSet rs = stmt.executeQuery();
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
			stmt.setString(17, aP.getResponsableApnabi());
			switch (aP.getComunicacion()) {
			case COMUNICACIONCONPERSONALEMPESA:
				stmt.setString(18, "ComunicacionConPersonalEmpesa");
				break;

			case COMUNICACIONCONPERSONALEMPRESA_FUERAEMPRESA:
				stmt.setString(18, "ComunicacionConPersonalEmpresa_FueraEmpresa");
				break;

			case COMUNICACIONCONPERSONASEXTERNASEMPRESA:
				stmt.setString(18, "ComunicacionConPersonasExternasEmpresa");
				break;

			case SINNECESIDADCOMUNICACION:
				stmt.setString(18, "SinNecesidadComunicacion");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			switch (aP.getCaractersiticasSensoriales()) {
			case LIMPIEZA:
				stmt.setString(19, "Limpieza");
				break;

			case LUZ:
				stmt.setString(19, "Luz");
				break;

			case ORDEN:
				stmt.setString(19, "Orden");
				break;

			case RUIDO:
				stmt.setString(19, "Ruido");
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
			stmt = con.prepareStatement(SQLUPDATEAPCONTACTOEMPRESA);
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
