package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class BDImplementacion implements ApnabiDAO {
	private Connection con;
	private PreparedStatement stmt;

	private ResourceBundle configFile;
	@SuppressWarnings("unused")
	private String driverBD;
	private String urlBD;
	private String userBD;
	private String passwordBD;

	final String SQLUSUARIO = "SELECT * FROM USUARIO WHERE NOMBRE = ?";
	final String SQLUSUARIOCONTRASEÑA = "SELECT * FROM USUARIO WHERE NOMBRE=? AND CONTRASEÑA = ?";
	final String SQLTIPO = "SELECT TIPO FROM USUARIO WHERE NOMBRE = ?";
	final String SQLINSERTUSUARIO = "INSERT INTO USUARIO VALUES (?,?)";

	final String SQLEMPRESAS = "SELECT * FROM EMPRESA";
	final String SQLNOMEMPRESAS = "SELECT NOM_EMPRESA FROM EMPRESA";
	final String SQLSELECTEMPRESA = "SELECT * FROM EMPRESA WHERE NOM_EMPRESA = ?";
	final String SQLINSERTEMPRESA = "INSERT INTO EMPRESA VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	final String SQLUPDATEDATOS = "UPDATE EMPRESA SET DATOSCONTACTO=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOEMPRESA = "UPDATE EMPRESA SET CONTACTOEMPRESA=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTOAPNABI = "UPDATE EMPRESA SET CONTACTOAPNABI=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATEESTADO = "UPDATE EMPRESA SET ESTADO=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTO1 = "UPDATE EMPRESA SET CONTACTO1=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTO2 = "UPDATE EMPRESA SET CONTACTO2=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTO3 = "UPDATE EMPRESA SET CONTACTO3=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATECONTACTO4 = "UPDATE EMPRESA SET CONTACTO4=? WHERE NOM_EMPRESA=?";
	final String SQLUPDATEOBSERVACIONES = "UPDATE EMPRESA SET OBSERVACIONES=? WHERE NOM_EMPRESA=?";
	final String SQLDELETE_EMPRESA = "DELETE FROM EMPRESA WHERE NOM_EMPRESA = ?";

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
		}
		return existe;
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
			}
		}
		return registro;
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
			}
		}
		return user;
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
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
				empresa.setContacto1(rs.getDate("CONTACTO1").toString());
				if (rs.getDate("CONTACTO2")!=null) {
					empresa.setContacto2(rs.getDate("CONTACTO2").toString());
				}
				
				if (rs.getDate("CONTACTO3")!=null) {
					empresa.setContacto3(rs.getDate("CONTACTO3").toString());
				}
				
				if (rs.getDate("CONTACTO4")!=null) {
					empresa.setContacto4(rs.getDate("CONTACTO4").toString());
				}
				empresa.setObservaciones(rs.getString("OBSERVACIONES"));
				empresas.put(empresa.getNom_empresa(), empresa);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las empresas.");
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
			stmt = con.prepareStatement(SQLEMPRESAS);
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
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setSector(Sector.valueOf(rs.getString("SECTOR").toUpperCase()));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				empresa.setEstado(Estado.valueOf(rs.getString("ESTADO").toUpperCase()));
				empresa.setContacto1(rs.getDate("CONTACTO1").toString());

				if (rs.getDate("CONTACTO2")!=null) {
					empresa.setContacto2(rs.getDate("CONTACTO2").toString());
				}
				
				if (rs.getDate("CONTACTO3")!=null) {
					empresa.setContacto3(rs.getDate("CONTACTO3").toString());
				}
				
				if (rs.getDate("CONTACTO4")!=null) {
					empresa.setContacto4(rs.getDate("CONTACTO4").toString());
				}
				empresa.setObservaciones(rs.getString("OBSERVACIONES"));
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger la empresa.");
			e.printStackTrace();
		}
		return empresa;
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
			
			stmt.setString(8, emp.getContacto1());
			
			if (emp.getContacto2()==null) {
				stmt.setString(9, null);
			} else {
				stmt.setString(9, emp.getContacto2());
			}

			if (emp.getContacto3()==null) {
				stmt.setString(10, null);
			} else {
				stmt.setString(10, emp.getContacto3());
			}

			if (emp.getContacto4()==null) {
				stmt.setString(11, null);
			} else {
				stmt.setString(11, emp.getContacto4());
			}

			if (emp.getObservaciones()==null) {
				stmt.setString(12, null);
			} else {
				stmt.setString(12, emp.getObservaciones());
			}

			if (stmt.executeUpdate() > 0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Ha habido un error al intentar añadir la empresa.");
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
				if (stmt.executeUpdate()>0) {
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
				if (stmt.executeUpdate()>0) {
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
				if (stmt.executeUpdate()>0) {
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
		}
		return check;
	}

	@Override
	public boolean modificarEstado(Estado estado, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (estado!=null) {
				stmt = con.prepareStatement(SQLUPDATEESTADO);
				switch (estado) {
				case INFORMADO:
					stmt.setString(1, "Informado");
					break;

				case NOINTERESADO:
					stmt.setString(1, "NoInteresado");
					break;

				case PLANIFICANDOINSERCIONES:
					stmt.setString(1, "PlanificandoInserciones");
					break;

				case PROXIMOAÑO:
					stmt.setString(1, "ProximoAño");
					break;

				case VALORANDO_INTERESADO:
					stmt.setString(1, "Valorando_Interesado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
				stmt.setString(2, nom);
				if (stmt.executeUpdate()>0) {
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
				if (stmt.executeUpdate()>0) {
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
				if (stmt.executeUpdate()>0) {	
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
				if (stmt.executeUpdate()>0) {
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
				if (stmt.executeUpdate()>0) {
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
		}
		return check;
	}

	@Override
	public boolean modificarObservaciones(String observaciones, String nom) {
		boolean check = false;

		this.openConnection();
		try {
			if (!observaciones.isBlank()) {
				stmt = con.prepareStatement(SQLUPDATEOBSERVACIONES);
				stmt.setString(1, observaciones);
				stmt.setString(2, nom);
				if (stmt.executeUpdate()>0) {
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
		}
		return check;
	}
}
