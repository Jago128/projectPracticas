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
	final String SQLDELETE_EMPRESA = "DELETE FROM EMPRESA WHERE NOM_EMPRESA = ?";

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

	final String SQLPERSONAS = "SELECT * FROM PERSONA";
	final String SQLNOMPERSONAS = "SELECT NOM_P FROM PERSONA";
	final String SQLSELECTPERSONA = "SELECT * FROM PERSONA WHERE NOM_P=?";
	final String SQLINSERTPERSONA = "INSERT INTO PERSONA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATEAPOYO = "UPDATE PERSONA SET APOYO=? WHERE NOM_P=?";
	final String SQLUPDATEFORMACION = "UPDATE PERSONA SET FORMACION=? WHERE NOM_P=?";
	final String SQLUPDATE_ESPECIALIDAD = "UPDATE PERSONA SET ESPECIALIDAD=? WHERE NOM_P=?";
	final String SQLUPDATESECTORINTERES = "UPDATE PERSONA SET SECTORINTERES=? WHERE NOM_P=?";
	final String SQLUPDATECVLINK = "UPDATE PERSONA SET CV=? WHERE NOM_P=?";
	final String SQLUPDATEDISCAPACIDAD = "UPDATE PERSONA SET DISCAPACIDAD=? WHERE NOM_P=?";
	final String SQLUPDATE_EUSKERA = "UPDATE PERSONA SET EUSKERA=? WHERE NOM_P=?";
	final String SQLUPDATEINGLES = "UPDATE PERSONA SET INGLES=? WHERE NOM_P=?";
	final String SQLUPDATEOTROSIDIOMAS = "UPDATE PERSONA SET OTROSIDIOMAS=? WHERE NOM_P=?";
	final String SQLUPDATELOCALIDAD = "UPDATE PERSONA SET LOCALIDAD=? WHERE NOM_P=?";
	final String SQLUPDATEACCESIBILIDAD = "UPDATE PERSONA SET ACCESIBILIDAD=? WHERE NOM_P=?";
	final String SQLUPDATEPERSONAOBSERVACIONES = "UPDATE PERSONA SET OBSERVACIONES=? WHERE NOM_P=?";

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
	public Map<String, Persona> mostrarPersonas() {
		Persona persona;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persona = new Persona();
				persona.setNombre(rs.getString("NOM_P"));
				persona.setApoyo(rs.getString("APOYO"));
				persona.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				persona.setEspecialidad(rs.getString("ESPECIALIDAD"));
				persona.setSectorInteres(SectorInteres.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				persona.setCvLink(rs.getString("CV"));
				persona.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				persona.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				persona.setIngles(Ingles.valueOf(rs.getString("INGLES")));
				persona.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				persona.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				persona.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				persona.setObservaciones(rs.getString("OBSERVACIONES"));
				personas.put(persona.getNombre(), persona);
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
	public Map<String, Persona> mostrarNomPersonas() {
		Persona persona;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persona = new Persona();
				persona.setNombre(rs.getString("NOM_P"));
				personas.put(persona.getNombre(), persona);
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
		return personas;
	}

	@Override
	public Persona getPersona(String nom) {
		Persona persona = new Persona();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			stmt.setString(1, nom);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				persona.setNombre(rs.getString("NOM_P"));
				persona.setApoyo(rs.getString("APOYO"));
				persona.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				persona.setEspecialidad(rs.getString("ESPECIALIDAD"));
				persona.setSectorInteres(SectorInteres.valueOf(rs.getString("SECTORINTERES").toUpperCase()));
				persona.setCvLink(rs.getString("CV"));
				persona.setCerfificadoDiscapacidad(Discapacidad.valueOf(rs.getString("DISCAPACIDAD").toUpperCase()));
				persona.setEuskera(Euskera.valueOf(rs.getString("EUSKERA").toUpperCase()));
				persona.setIngles(Ingles.valueOf(rs.getString("INGLES")));
				persona.setOtrosIdiomas(rs.getString("OTROSIDIOMAS"));
				persona.setLocalidad(Localidad.valueOf(rs.getString("LOCALIDAD").toUpperCase()));
				persona.setAccesibilidad(Accesibilidad.valueOf(rs.getString("ACCESIBILIDAD").toUpperCase()));
				persona.setObservaciones(rs.getString("OBSERVACIONES"));
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
		return persona;
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
	public boolean añadirPersona(Persona persona) {
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLINSERTEMPRESA);
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApoyo());
			switch (persona.getFormacion()) {
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

			stmt.setString(4, persona.getEspecialidad());
			switch (persona.getSectorInteres()) {
			// TBD

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(6, persona.getCvLink());
			switch (persona.getCerfificadoDiscapacidad()) {
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

			switch (persona.getEuskera()) {
			case A1:
				stmt.setString(8, "A1");
				break;

			case A2:
				stmt.setString(8, "A2");
				break;

			case B1:
				stmt.setString(8, "B1");
				break;

			case B2:
				stmt.setString(8, "B2");
				break;

			case C1:
				stmt.setString(8, "C1");
				break;

			case C2:
				stmt.setString(8, "C1");
				break;

			case CONOCIMIENTO_NOACREDITADO:
				stmt.setString(8, "Conocimiento_NoAcreditado");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			switch (persona.getIngles()) {
			case A1:
				stmt.setString(9, "A1");
				break;

			case A2:
				stmt.setString(9, "A2");
				break;

			case B1:
				stmt.setString(9, "B1");
				break;

			case B2:
				stmt.setString(9, "B2");
				break;

			case C1:
				stmt.setString(9, "C1");
				break;

			case C2:
				stmt.setString(9, "C1");
				break;

			case CONOCIMIENTO_NOACREDITADO:
				stmt.setString(9, "Conocimiento_NoAcreditado");
				break;

			default:
				System.out.println("Tipo invalido.");
			}

			stmt.setString(10, persona.getOtrosIdiomas());
			switch (persona.getLocalidad()) {
			case ABADIÑO:
				stmt.setString(11, "Abadiño");
				break;

			case ABANTO_ZIERBENA:
				stmt.setString(11, "Abanto_Zierbena");
				break;

			case AJANGIZ:
				stmt.setString(11, "Ajangiz");
				break;

			case ALONSOTEGI:
				stmt.setString(11, "Alonsotegi");
				break;

			case AMOREBIETA:
				stmt.setString(11, "Amorebieta");
				break;

			case AMOROTO:
				stmt.setString(11, "Amoroto");
				break;

			case AMURRIO:
				stmt.setString(11, "Amurrio");
				break;

			case ARAKALDO:
				stmt.setString(11, "Arakaldo");
				break;

			case ARANTZAZU:
				stmt.setString(11, "Arantzazu");
				break;

			case AREATZA_BILARO:
				stmt.setString(11, "Areatza_Bilaro");
				break;

			case ARRANKUDIAGA:
				stmt.setString(11, "Arrankudiaga");
				break;

			case ARRATZU:
				stmt.setString(11, "Arratzu");
				break;

			case ARRIETA:
				stmt.setString(11, "Arrieta");
				break;

			case ARRIGORRIAGA:
				stmt.setString(11, "Arrigorriaga");
				break;

			case ARTZENTALES:
				stmt.setString(11, "Artzentales");
				break;

			case ARTZINIEGA:
				stmt.setString(11, "Artziniega");
				break;

			case AULESTI:
				stmt.setString(11, "Aulesti");
				break;

			case AXPEATXONDO:
				stmt.setString(11, "AxpeAtxondo");
				break;

			case AYALA_AIARA:
				stmt.setString(11, "Ayala_Aiara");
				break;

			case BAKIO:
				stmt.setString(11, "Bakio");
				break;

			case BALMASEDA:
				stmt.setString(11, "Balmaseda");
				break;

			case BARAKALDO:
				stmt.setString(11, "Barakaldo");
				break;

			case BARRIKA:
				stmt.setString(11, "Barrika");
				break;

			case BASAURI:
				stmt.setString(11, "Basauri");
				break;

			case BEDIA:
				stmt.setString(11, "Bedia");
				break;

			case BERANGO:
				stmt.setString(11, "Berango");
				break;

			case BERMEO:
				stmt.setString(11, "Bermeo");
				break;

			case BERRIATUA:
				stmt.setString(11, "Berriatua");
				break;

			case BERRIZ:
				stmt.setString(11, "Berriz");
				break;

			case BILBAO:
				stmt.setString(11, "Bilbao");
				break;

			case BUSTURIA:
				stmt.setString(11, "Busturia");
				break;

			case CASTROURDIALES:
				stmt.setString(11, "CastroUrdiales");
				break;

			case DERIO:
				stmt.setString(11, "Derio");
				break;

			case DIMA:
				stmt.setString(11, "Dima");
				break;

			case DURANGO:
				stmt.setString(11, "Durango");
				break;

			case EA:
				stmt.setString(11, "Ea");
				break;

			case ELANTXOBE:
				stmt.setString(11, "Elantxobe");
				break;

			case ELORRIO:
				stmt.setString(11, "Elorrio");
				break;

			case ERANDIO:
				stmt.setString(11, "Erandio");
				break;

			case EREÑO:
				stmt.setString(11, "Ereño");
				break;

			case ERMUA:
				stmt.setString(11, "Ermua");
				break;

			case ERRIGOITI:
				stmt.setString(11, "Errigoiti");
				break;

			case ETXEBARRI:
				stmt.setString(11, "Etxebarri");
				break;

			case ETXEBARRIA:
				stmt.setString(11, "Etxebarria");
				break;

			case FORUA:
				stmt.setString(11, "Forua");
				break;

			case FRUIZ:
				stmt.setString(11, "Fruiz");
				break;

			case GALDAKAO:
				stmt.setString(11, "Galdakao");
				break;

			case GALDAMES:
				stmt.setString(11, "Galdames");
				break;

			case GAMIZFIKA:
				stmt.setString(11, "GamizFika");
				break;

			case GARAI:
				stmt.setString(11, "Garai");
				break;

			case GATIKA:
				stmt.setString(11, "Gatika");
				break;

			case GAUTEGIZ:
				stmt.setString(11, "Gautegiz");
				break;

			case GAZTELUELEXABEITIA_ARTEAGA:
				stmt.setString(11, "GazteluElexabeitia_Arteaga");
				break;

			case GERNIKALUMO:
				stmt.setString(11, "GernikaLumo");
				break;

			case GETXO:
				stmt.setString(11, "Getxo");
				break;

			case GIZABURUAGA:
				stmt.setString(11, "Gizaburuaga");
				break;

			case GORDEXOLA:
				stmt.setString(11, "Gordexola");
				break;

			case GORLIZ:
				stmt.setString(11, "Gorliz");
				break;

			case GUEÑES:
				stmt.setString(11, "Gueñes");
				break;

			case IBARRANGELU:
				stmt.setString(11, "Ibarrangelu");
				break;

			case IGORRE:
				stmt.setString(11, "Igorre");
				break;

			case ISPASTER:
				stmt.setString(11, "Ispaster");
				break;

			case IURRETA:
				stmt.setString(11, "Iurreta");
				break;

			case IZURTZA:
				stmt.setString(11, "Izurtza");
				break;

			case KARRANTZAHARANA:
				stmt.setString(11, "KarrantzaHarana");
				break;

			case KORTEZUBI:
				stmt.setString(11, "Kortezubi");
				break;

			case LANESTOSA:
				stmt.setString(11, "Lanestosa");
				break;

			case LARRABETZU:
				stmt.setString(11, "Larrabetzu");
				break;

			case LAUDIO_LLODIO:
				stmt.setString(11, "Laudio_Llodio");
				break;

			case LAUKIZ:
				stmt.setString(11, "Laukiz");
				break;

			case LEIOA:
				stmt.setString(11, "Leioa");
				break;

			case LEKEITIO:
				stmt.setString(11, "Lekeitio");
				break;

			case LEMOA:
				stmt.setString(11, "Lemoa");
				break;

			case LEMOIZ:
				stmt.setString(11, "Lemoiz");
				break;

			case LEZAMA:
				stmt.setString(11, "Lezama");
				break;

			case LOIU:
				stmt.setString(11, "Loiu");
				break;

			case MALLABIA:
				stmt.setString(11, "Mallabia");
				break;

			case MARKINAXEMEIN:
				stmt.setString(11, "MarkinaXemein");
				break;

			case MARURI:
				stmt.setString(11, "Maruri");
				break;

			case MAÑARIA:
				stmt.setString(11, "Mañaria");
				break;

			case MENDATA:
				stmt.setString(11, "Mendata");
				break;

			case MENDEXA:
				stmt.setString(11, "Mendexa");
				break;

			case MEÑAKA:
				stmt.setString(11, "Meñaka");
				break;

			case MORGA:
				stmt.setString(11, "Morga");
				break;

			case MUNDAKA:
				stmt.setString(11, "Mundaka");
				break;

			case MUNGIA:
				stmt.setString(11, "Mungia");
				break;

			case MUNITIBARARBATZEGI_GERRIKAITZ:
				stmt.setString(11, "MunitibarArbatzegi_Gerrikaitz");
				break;

			case MURUETA:
				stmt.setString(11, "Murueta");
				break;

			case MUSKIZ:
				stmt.setString(11, "Muskiz");
				break;

			case MUXIKA:
				stmt.setString(11, "Muxika");
				break;

			case NABARNIZ:
				stmt.setString(11, "Nabarniz");
				break;

			case ONDARROA:
				stmt.setString(11, "Ondarroa");
				break;

			case ORDUÑA:
				stmt.setString(11, "Orduña");
				break;

			case OROZKO:
				stmt.setString(11, "Orozko");
				break;

			case ORTUELLA:
				stmt.setString(11, "Ortuella");
				break;

			case OTXANDIO:
				stmt.setString(11, "Otxandio");
				break;

			case PLENTZIA:
				stmt.setString(11, "Plentzia");
				break;

			case PORTUGALETE:
				stmt.setString(11, "Portugalete");
				break;

			case SANTURTZI:
				stmt.setString(11, "Santurtzi");
				break;

			case SESTAO:
				stmt.setString(11, "Sestao");
				break;

			case SONDIKA:
				stmt.setString(11, "Sondika");
				break;

			case SOPELA:
				stmt.setString(11, "Sopela");
				break;

			case SOPUERTA:
				stmt.setString(11, "Sopuerta");
				break;

			case SUKARRIETA:
				stmt.setString(11, "Sukarrieta");
				break;

			case TRAPAGARAN:
				stmt.setString(11, "Trapagaran");
				break;

			case TURTZIOZ:
				stmt.setString(11, "Turtzioz");
				break;

			case UBIDE:
				stmt.setString(11, "Ubide");
				break;

			case UGAOMIRABALLES:
				stmt.setString(11, "UgaoMiraballes");
				break;

			case URDULIZ:
				stmt.setString(11, "Urduliz");
				break;

			case URDUÑA:
				stmt.setString(11, "Urduña");
				break;

			case USANSOLO:
				stmt.setString(11, "Usansolo");
				break;

			case ZALDIBAR:
				stmt.setString(11, "Zaldibar");
				break;

			case ZALLA:
				stmt.setString(11, "Zalla");
				break;

			case ZAMUDIO:
				stmt.setString(11, "Zamudio");
				break;

			case ZARATAMO:
				stmt.setString(11, "Zaratamo");
				break;

			case ZEANURI:
				stmt.setString(11, "Zeanuri");
				break;

			case ZEBERIO:
				stmt.setString(11, "Zeberio");
				break;

			case ZIERBENA:
				stmt.setString(11, "Zierbena");
				break;

			case ZIORTZA_BOLIBAR:
				stmt.setString(11, "ZiortzaBolibar");
				break;

			case ZORNOTZA:
				stmt.setString(11, "Zornotza");
				break;
			
			default:
				System.out.println("Tipo invalido.");
			}

			switch (persona.getAccesibilidad()) {
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

			stmt.setString(13, persona.getObservaciones());
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
					// TBD
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
}
