package model;

import java.sql.Connection;
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
	final String SQLINSERTUSUARIO = "INSERT INTO USUARIO VALUES (?,?,'Trabajador')";

	final String SQLEMPRESAS = "SELECT * FROM EMPRESA";
	final String SQLSELECTEMPRESA = "SELECT * FROM EMPRESA WHERE NOM_EMPRESA = ?";
	final String SQLINSERTEMPRESA = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?)";
	final String SQLUPDATEEMPRESA = "UPDATE EMPRESA SET [TBD]=? WHERE NOM_EMPRESA=?";
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
	public boolean verificarTipoUsuario(Usuario user) {
		boolean admin = false;
		this.openConnection();

		try {
			stmt = con.prepareStatement(SQLTIPO);
			stmt.setString(1, user.getNombre());
			ResultSet rs = stmt.executeQuery();
			if (rs.next() && rs.getString(1).equals("Admin")) {
				admin = true;
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("El usuario no se pudo verificar correctamente.");
			e.printStackTrace();
		}
		return admin;
	}

	@Override
	public boolean registrarUsuario(Usuario user) {
		boolean register = false;

		if (!verificarUsuario(user)) {
			this.openConnection();
			try {
				stmt = con.prepareStatement(SQLINSERTUSUARIO);
				stmt.setString(1, user.getNombre());
				stmt.setString(2, user.getContraseña());
				if (stmt.executeUpdate()>0) {
					register = true;
				}
				stmt.close();
				con.close();
			} catch (SQLException e) {
				System.out.println("Un error ha ocurrido al intentar registrar el usuario.");
				e.printStackTrace();
			}
		}
		return register;
	}

	@Override
	public Map<String, Empresa> mostrarEmpresas() {
		ResultSet rs = null;
		Empresa empresa;
		Map<String, Empresa> empresas = new TreeMap<>();

		// Opens the connection
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLEMPRESAS);
			rs = stmt.executeQuery();
			while (rs.next()) {
				empresa = new Empresa();
				switch (rs.getString("SECTOR")) {
				case "Actividades deportivas":
					empresa.setSector(Sector.ACTIVIDADES_DEPORTIVAS);
					break;

				case "Administracion":
					empresa.setSector(Sector.ADMINISTRACION);
					break;

				case "Almacen logistica":
					empresa.setSector(Sector.ALMACEN_LOGISTICA);
					break;

				case "Artes graficas":
					empresa.setSector(Sector.ARTES_GRAFICAS);
					break;

				case "Comercio":
					empresa.setSector(Sector.COMERCIO);
					break;

				case "Docencia":
					empresa.setSector(Sector.DOCENCIA);
					break;

				case "Industrial":
					empresa.setSector(Sector.INDUSTRIAL);
					break;

				case "Informatica":
					empresa.setSector(Sector.INFORMATICA);
					break;

				case "Limpieza":
					empresa.setSector(Sector.LIMPIEZA);
					break;

				case "Restauracion":
					empresa.setSector(Sector.RESTAURACION);
					break;

				case "Sanidad":
					empresa.setSector(Sector.SANIDAD);
					break;

				case "Turismo":
					empresa.setSector(Sector.TURISMO);
					break;

				case "Transporte":
					empresa.setSector(Sector.TRANSPORTE);
					break;

				case "IT":
					empresa.setSector(Sector.IT);
					break;

				case "Automovilistico":
					empresa.setSector(Sector.AUTOMOVILISTICO);
					break;

				case "Mantenimiento":
					empresa.setSector(Sector.MANTENIMIENTO);
					break;

				case "Marketing":
					empresa.setSector(Sector.MARKETING);
					break;
				}
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				switch (rs.getString("ESTADO")) {
				case "Informado":
					empresa.setEstado(Estado.INFORMADO);
					break;

				case "Valorando/interesado":
					empresa.setEstado(Estado.VALORANDO_INTERESADO);
					break;

				case "Planificando inserciones":
					empresa.setEstado(Estado.PLANIFICANDO_INSERCIONES);
					break;

				case "Proximo año":
					empresa.setEstado(Estado.PROXIMO_AÑO);
					break;

				case "No interesado":
					empresa.setEstado(Estado.NO_INTERESADO);
					break;
				}
				empresas.put(empresa.getNom_empresa(), empresa);
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar ver las empresas.");
			e.printStackTrace();
		}
		return empresas;
	}

	@Override
	public Empresa getEmpresa(String nom) {
		ResultSet rs = null;
		Empresa empresa = new Empresa();

		// Opens the connection
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLSELECTEMPRESA);
			stmt.setString(1, nom);
			rs = stmt.executeQuery();
			if (rs.next()) {
				switch (rs.getString("SECTOR")) {
				case "Actividades deportivas":
					empresa.setSector(Sector.ACTIVIDADES_DEPORTIVAS);
					break;

				case "Administracion":
					empresa.setSector(Sector.ADMINISTRACION);
					break;

				case "Almacen logistica":
					empresa.setSector(Sector.ALMACEN_LOGISTICA);
					break;

				case "Artes graficas":
					empresa.setSector(Sector.ARTES_GRAFICAS);
					break;

				case "Automovilistico":
					empresa.setSector(Sector.AUTOMOVILISTICO);
					break;

				case "Comercio":
					empresa.setSector(Sector.COMERCIO);
					break;

				case "Docencia":
					empresa.setSector(Sector.DOCENCIA);
					break;

				case "Industrial":
					empresa.setSector(Sector.INDUSTRIAL);
					break;

				case "Informatica":
					empresa.setSector(Sector.INFORMATICA);
					break;

				case "IT":
					empresa.setSector(Sector.IT);
					break;

				case "Limpieza":
					empresa.setSector(Sector.LIMPIEZA);
					break;

				case "Mantenimiento":
					empresa.setSector(Sector.MANTENIMIENTO);
					break;

				case "Marketing":
					empresa.setSector(Sector.MARKETING);
					break;

				case "Restauracion":
					empresa.setSector(Sector.RESTAURACION);
					break;

				case "Sanidad":
					empresa.setSector(Sector.SANIDAD);
					break;

				case "Transporte":
					empresa.setSector(Sector.TRANSPORTE);
					break;

				case "Turismo":
					empresa.setSector(Sector.TURISMO);
					break;
				}
				empresa.setNom_empresa(rs.getString("NOM_EMPRESA"));
				empresa.setPuesto(rs.getString("PUESTO"));
				empresa.setDatosContacto(rs.getString("DATOSCONTACTO"));
				empresa.setContactoEmpresa(rs.getString("CONTACTOEMPRESA"));
				empresa.setContactoApnabi(rs.getString("CONTACTOAPNABI"));
				switch (rs.getString("ESTADO")) {
				case "Informado":
					empresa.setEstado(Estado.INFORMADO);
					break;

				case "No interesado":
					empresa.setEstado(Estado.NO_INTERESADO);
					break;

				case "Planificando inserciones":
					empresa.setEstado(Estado.PLANIFICANDO_INSERCIONES);
					break;

				case "Proximo año":
					empresa.setEstado(Estado.PROXIMO_AÑO);
					break;

				case "Valorando/interesado":
					empresa.setEstado(Estado.VALORANDO_INTERESADO);
					break;
				}
			}
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Un error ha occurrido al intentar recoger las empresa.");
			e.printStackTrace();
		}
		return empresa;
	}

	@Override
	public boolean añadirEmpresa(Empresa emp) {
		// Open connection and declare a boolean to check if the update is properly executed
		boolean check = false;
		this.openConnection();

		try {
			// Prepares the SQL query
			stmt = con.prepareStatement(SQLINSERTEMPRESA);
			switch (emp.getSector()) {
			case ACTIVIDADES_DEPORTIVAS:
				stmt.setString(1, "Actividades deportivas");
				break;

			case ADMINISTRACION:
				stmt.setString(1, "Administracion");
				break;

			case ALMACEN_LOGISTICA:
				stmt.setString(1, "Almacen logistica");
				break;

			case ARTES_GRAFICAS:
				stmt.setString(1, "Artes graficas");
				break;

			case AUTOMOVILISTICO:
				stmt.setString(1, "Automovilistico");
				break;

			case COMERCIO:
				stmt.setString(1, "Comercio");
				break;

			case DOCENCIA:
				stmt.setString(1, "Docencia");
				break;

			case INDUSTRIAL:
				stmt.setString(1, "Industrial");
				break;

			case INFORMATICA:
				stmt.setString(1, "Informatica");
				break;

			case IT:
				stmt.setString(1, "IT");
				break;

			case LIMPIEZA:
				stmt.setString(1, "Limpieza");
				break;

			case MANTENIMIENTO:
				stmt.setString(1, "Mantenimiento");
				break;

			case MARKETING:
				stmt.setString(1, "Marketing");
				break;


			case RESTAURACION:
				stmt.setString(1, "Restauracion");
				break;

			case SANIDAD:
				stmt.setString(1, "Sanidad");
				break;

			case TRANSPORTE:
				stmt.setString(1, "Transporte");
				break;

			case TURISMO:
				stmt.setString(1, "Turismo");
				break;

			default:
				System.out.println("Tipo invalido.");
			}
			stmt.setString(2, emp.getNom_empresa());
			stmt.setString(3, emp.getPuesto());
			stmt.setString(4, emp.getDatosContacto());
			stmt.setString(5, emp.getContactoEmpresa());
			stmt.setString(6, emp.getContactoApnabi());
			switch (emp.getEstado()) {
			case INFORMADO:
				stmt.setString(7, "Informado");
				break;

			case NO_INTERESADO:
				stmt.setString(7, "Valorando/interesado");
				break;

			case PLANIFICANDO_INSERCIONES:
				stmt.setString(7, "Planificando inserciones");
				break;

			case PROXIMO_AÑO:
				stmt.setString(7, "Proximo año");
				break;

			case VALORANDO_INTERESADO:
				stmt.setString(7, "No interesado");
				break;

			default:
				System.out.println("Tipo invalido.");
			}
			if (stmt.executeUpdate()>0) {
				check = true;
			}
			stmt.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("There was a problem trying to add the new product.");
			e.printStackTrace();
		}
		return check;
	}

	@Override
	public boolean modificarEmpresa(String nom) {
		//Parametros por poner
		boolean check = false;
		
		this.openConnection();
		try {
			stmt = con.prepareStatement(SQLDELETE_EMPRESA);
			//stmt.setString(1, [TBD]);
			stmt.setString(2, nom);
			if (stmt.executeUpdate()>0) {
				check = true;
			}
			stmt.close();
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
			if (stmt.executeUpdate()>0) {
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
