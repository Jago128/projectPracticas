package model;

import java.sql.*;
import java.sql.Date;
import java.util.*;

import enums.Accesibilidad;
import enums.Discapacidad;
import enums.Estado;
import enums.Euskera;
import enums.Formacion;
import enums.Ingles;
import enums.Localidad;
import enums.ResultadoFinal;
import enums.ResultadoUltimoContacto;
import enums.Sector;
import enums.SectorInteres;

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
		ResultSet rs = null;
		Empresa empresa;
		Map<String, Empresa> empresas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLEMPRESAS);
			rs = stmt.executeQuery();
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
		ResultSet rs = null;
		Empresa empresa;
		Map<String, Empresa> empresas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMEMPRESAS);
			rs = stmt.executeQuery();
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
		ResultSet rs = null;
		Empresa empresa = new Empresa();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTEMPRESA);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
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
		ResultSet rs = null;
		boolean check = false;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTEMPRESA);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
			if (rs.next()) {
				check = true;
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
		return check;
	}

	@Override
	public int getCodEmpresa(String nom) {
		ResultSet rs = null;
		int cod = 0;

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLCODEMPRESA);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
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
			if (estado != null) {
				stmt = con.prepareStatement(SQLUPDATEESTADO);
				stmt.setString(1, estado);
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
		ResultSet rs = null;
		Contacto cont = new Contacto();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTCONTACTOS);
			stmt.setInt(1, empId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				cont.setCodContacto(rs.getInt("COD_CONTACTO"));
				cont.setContacto1(rs.getDate("CONTACTO1").toString());
				if (rs.getDate("CONTACTO2")==null) {
					cont.setContacto2(null);
				} else {
					cont.setContacto2(rs.getDate("CONTACTO2").toString());
				}

				if (rs.getDate("CONTACTO3")==null) {
					cont.setContacto3(null);
				} else {
					cont.setContacto3(rs.getDate("CONTACTO3").toString());
				}

				if (rs.getDate("CONTACTO4")==null) {
					cont.setContacto4(null);
				} else {
					cont.setContacto4(rs.getDate("CONTACTO4").toString());
				}
				cont.setObservaciones(rs.getString("OBSERVACIONES"));
				if (rs.getString("RESULTADOULTIMO")!=null) {
					cont.setResultadoUltimoContacto(ResultadoUltimoContacto.valueOf(rs.getString("RESULTADOULTIMO").toUpperCase()));
				} else {
					cont.setResultadoUltimoContacto(null);
				}
				cont.setInfoUltimo(rs.getString("INFOULTIMO"));
				
				if (rs.getString("RESULTADOFINAL")!=null) {
					cont.setResultadoFinal(ResultadoFinal.valueOf(rs.getString("RESULTADOFINAL").toUpperCase()));
				} else {
					cont.setResultadoFinal(null);
				}
				if (rs.getDate("FECHARESOLUCION")==null) {
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

			case UNSET:
				stmt.setString(6, null);
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

			case UNSET:
				stmt.setString(8, null);
				break;
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
		ResultSet rs = null;
		Persona persona;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLPERSONAS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				persona = new Persona();
				persona.setNombre(rs.getString("NOM_P"));
				persona.setApoyo(rs.getString("APOYO"));
				persona.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				// Especialidad
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
		ResultSet rs = null;
		Persona persona;
		Map<String, Persona> personas = new TreeMap<>();

		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			rs = stmt.executeQuery();
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
		ResultSet rs = null;
		Persona persona = new Persona();
		
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLNOMPERSONAS);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
			while (rs.next()) {
				persona.setNombre(rs.getString("NOM_P"));
				persona.setApoyo(rs.getString("APOYO"));
				persona.setFormacion(Formacion.valueOf(rs.getString("FORMACION").toUpperCase()));
				// Especialidad
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
			
			// 4: Especialidad
			switch (persona.getSectorInteres()) { // 5
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
			switch (persona.getLocalidad()) { // 11
			// TBD
			default:
				break;
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
	public boolean modificarObservaciones(String observaciones, String nom) {
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
