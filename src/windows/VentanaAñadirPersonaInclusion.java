package windows;

import java.awt.*;
import java.awt.event.*;
import java.time.Year;
import java.time.format.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import model.PersonaInclusion;

public class VentanaAñadirPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldCV, textFieldIdioma, textFieldNom, textFieldUltimoAñoTrabajado, textFieldApellidos;
	private JComboBox<String> comboBoxFormacion, comboBoxSectorInteres, comboBoxMunicipio, comboBoxAccesibilidad,
			comboBoxPersonaFacilitadora;
	private JTextArea textAreaOtros, textAreaInteresesPersonales, textAreaSituacionActual, textAreaEspecialidad;
	private JButton btnAñadir;
	private JSpinner spinnerEdad;

	public VentanaAñadirPersonaInclusion(JDialog parent, LoginController cont) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir personas en inclusion");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 960, 670);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(188, 24, 241, 24);
		getContentPane().add(lblObligatorio);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAñadirPersonaInclusion.class.getResource("/img/apnabilan.png")));
		logo.setBounds(464, 8, 325, 78);
		getContentPane().add(logo);

		JLabel lblNom = new JLabel("Nombre: *");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(20, 90, 103, 28);
		getContentPane().add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(139, 96, 183, 19);
		getContentPane().add(textFieldNom);

		JLabel lblApellidos = new JLabel("Apellidos: *");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellidos.setBounds(326, 90, 103, 28);
		getContentPane().add(lblApellidos);

		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(445, 96, 163, 19);
		getContentPane().add(textFieldApellidos);

		JLabel lblEdad = new JLabel("Edad: *");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(645, 90, 103, 28);
		getContentPane().add(lblEdad);

		SpinnerModel sm = new SpinnerNumberModel(16, 0, null, 1);
		spinnerEdad = new JSpinner(sm);
		spinnerEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerEdad.setBounds(741, 89, 179, 31);
		getContentPane().add(spinnerEdad);
		JLabel lblMunicipio = new JLabel("Municipio: *");
		lblMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMunicipio.setBounds(30, 128, 103, 31);
		getContentPane().add(lblMunicipio);

		comboBoxMunicipio = new JComboBox<>();
		comboBoxMunicipio.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Abadiño", "Abanto-Zierbena",
				"Ajangiz", "Alonsotegi", "Amorebieta", "Amoroto", "Amurrio", "Arakaldo", "Arantzazu",
				"Areatza o Bilaro", "Arrankudiaga", "Arratzu", "Arrieta", "Arrigorriaga", "Artzentales", "Artziniega",
				"Aulesti", "Axpe Atxondo", "Ayala/Aiara", "Bakio", "Balmaseda", "Barakaldo", "Barrika", "Basauri",
				"Bedia", "Berango", "Bermeo", "Berriatua", "Berriz", "Bilbao", "Busturia", "Castro Urdiales", "Derio",
				"Dima", "Durango", "Ea", "Elantxobe", "Elorrio", "Erandio", "Ereño", "Ermua", "Errigoiti", "Etxebarri",
				"Etxebarria", "Forua", "Fruiz", "Galdakao", "Galdames", "Gamiz-Fika", "Garai", "Gatika", "Gautegiz",
				"Gaztelu-Elexabeitia o Arteaga", "Gernika-Lumo", "Getxo", "Gizaburuaga", "Gordexola", "Gorliz",
				"Gueñes", "Ibarrangelu", "Igorre", "Ispaster", "Iurreta", "Izurtza", "Karrantza Harana", "Kortezubi",
				"Lanestosa", "Larrabetzu", "Laudio/Llodio", "Laukiz", "Leioa", "Lekeitio", "Lemoa", "Lemoiz", "Lezama",
				"Loiu", "Mallabia", "Mañaria", "Markina-Xemein", "Maruri", "Mendata", "Mendexa", "Meñaka", "Morga",
				"Mundaka", "Mungia", "Munitibar-Arbatzegi Gerrikaitz", "Murueta", "Muskiz", "Muxika", "Nabarniz",
				"Ondarroa", "Orduña", "Orozko", "Ortuella", "Otxandio", "Plentzia", "Portugalete", "Santurtzi",
				"Sestao", "Sondika", "Sopela", "Sopuerta", "Sukarrieta", "Trapagaran", "Turtzioz", "Ubide",
				"Ugao-Miraballes", "Urduliz", "Urduña", "Usansolo", "Zaldibar", "Zalla", "Zamudio", "Zaratamo",
				"Zeanuri", "Zeberio", "Zierbena", "Ziortza-Bolibar", "Zornotza" }));
		comboBoxMunicipio.setSelectedIndex(0);
		comboBoxMunicipio.setBounds(141, 134, 181, 21);
		getContentPane().add(comboBoxMunicipio);

		JLabel lblFormacion = new JLabel("Formacion: *");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(326, 128, 108, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(444, 133, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad: * (Describa la especialidad)");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(610, 441, 244, 28);
		getContentPane().add(lblEspecialidad);

		textAreaEspecialidad = new JTextArea();
		textAreaEspecialidad.setLineWrap(true);
		textAreaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaEspecialidad.setBounds(476, 479, 460, 107);
		getContentPane().add(textAreaEspecialidad);

		JLabel lblOtros = new JLabel("Otros titulos, certificados, carnets:");
		lblOtros.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtros.setBounds(27, 440, 352, 31);
		getContentPane().add(lblOtros);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres para los cuatro)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(383, 424, 217, 31);
		getContentPane().add(lblMaxChars);

		textAreaOtros = new JTextArea();
		textAreaOtros.setLineWrap(true);
		textAreaOtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaOtros.setBounds(20, 477, 446, 110);
		getContentPane().add(textAreaOtros);

		JLabel lblIdioma = new JLabel("Idiomas: *");
		lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdioma.setBounds(645, 128, 108, 31);
		getContentPane().add(lblIdioma);

		textFieldIdioma = new JTextField();
		textFieldIdioma.setColumns(10);
		textFieldIdioma.setBounds(767, 135, 163, 19);
		getContentPane().add(textFieldIdioma);

		JLabel lblUltimoAñoTrabajado = new JLabel("Ultimo año trabajado:");
		lblUltimoAñoTrabajado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUltimoAñoTrabajado.setBounds(20, 166, 143, 31);
		getContentPane().add(lblUltimoAñoTrabajado);

		textFieldUltimoAñoTrabajado = new JTextField();
		textFieldUltimoAñoTrabajado.setColumns(10);
		textFieldUltimoAñoTrabajado.setBounds(159, 173, 163, 19);
		getContentPane().add(textFieldUltimoAñoTrabajado);

		JLabel lblSectorInteres = new JLabel("Sector de interes: *");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(336, 166, 129, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(475, 171, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		textAreaInteresesPersonales = new JTextArea();
		textAreaInteresesPersonales.setLineWrap(true);
		textAreaInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInteresesPersonales.setBounds(20, 304, 446, 110);
		getContentPane().add(textAreaInteresesPersonales);

		JLabel lbl_InteresesPersonales = new JLabel("Intereses personales:");
		lbl_InteresesPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_InteresesPersonales.setBounds(149, 263, 163, 31);
		getContentPane().add(lbl_InteresesPersonales);

		textAreaSituacionActual = new JTextArea();
		textAreaSituacionActual.setLineWrap(true);
		textAreaSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaSituacionActual.setBounds(476, 304, 465, 110);
		getContentPane().add(textAreaSituacionActual);

		JLabel lblSituacionActual = new JLabel("Situacion actual:");
		lblSituacionActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituacionActual.setBounds(649, 267, 152, 31);
		getContentPane().add(lblSituacionActual);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad: *");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(655, 166, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(788, 172, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblCV = new JLabel("CV:");
		lblCV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCV.setBounds(30, 211, 51, 28);
		getContentPane().add(lblCV);

		textFieldCV = new JTextField();
		textFieldCV.setColumns(10);
		textFieldCV.setBounds(92, 217, 524, 19);
		getContentPane().add(textFieldCV);

		JLabel lblPersonaFacilitadora = new JLabel("Persona facilitadora: *");
		lblPersonaFacilitadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaFacilitadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaFacilitadora.setBounds(620, 211, 137, 28);
		getContentPane().add(lblPersonaFacilitadora);

		comboBoxPersonaFacilitadora = new JComboBox<>();
		comboBoxPersonaFacilitadora.setEditable(true);
		comboBoxPersonaFacilitadora.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxPersonaFacilitadora.setSelectedIndex(0);
		comboBoxPersonaFacilitadora.setBounds(767, 216, 179, 21);
		getContentPane().add(comboBoxPersonaFacilitadora);

		JScrollPane scrollPane = new JScrollPane(textAreaEspecialidad);
		scrollPane.setBounds(476, 479, 460, 107);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaOtros);
		scrollPane_1.setBounds(20, 477, 446, 110);
		getContentPane().add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane(textAreaInteresesPersonales);
		scrollPane_2.setBounds(20, 304, 446, 110);
		getContentPane().add(scrollPane_2);

		JScrollPane scrollPane_3 = new JScrollPane(textAreaSituacionActual);
		scrollPane_3.setBounds(476, 304, 465, 110);
		getContentPane().add(scrollPane_3);

		btnAñadir = new JButton("Añadir persona en inclusion");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(305, 596, 339, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	public boolean errorChecks(int errorID) {
		boolean error = false;

		switch (errorID) {
		case 1:
			addError();
			break;

		case 2:
			error = lengthCheck();
			break;

		case 3:
			error = yearFormatErrorCheck();
			break;
		}
		return error;
	}

	public void addError() { // ErrorID: 1
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la persona en inclusion.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaOtros.getText().length() > 500) {
			return true;
		}

		if (textAreaEspecialidad.getText().length() > 500) {
			return true;
		}

		if (textAreaInteresesPersonales.getText().length() > 500) {
			return true;
		}

		if (textAreaSituacionActual.getText().length() > 500) {
			return true;
		}
		return false;
	}

	public boolean yearFormatErrorCheck() { // ErrorID: 3
		try {
			if (!textFieldUltimoAñoTrabajado.getText().isBlank()) {
				Year.parse(textFieldUltimoAñoTrabajado.getText());
			}
		} catch (DateTimeParseException e) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldNom.getText().isBlank() || textFieldApellidos.getText().isBlank()
					|| comboBoxMunicipio.getSelectedItem().equals("---")
					|| comboBoxFormacion.getSelectedItem().equals("---") || textAreaEspecialidad.getText().isBlank()
					|| textFieldIdioma.getText().isBlank() || comboBoxSectorInteres.getSelectedItem().equals("---")
					|| comboBoxAccesibilidad.getSelectedItem().equals("---")
					|| comboBoxPersonaFacilitadora.getEditor().getItem().equals("---")) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if ((Integer) spinnerEdad.getValue() < 0) {
				JOptionPane.showMessageDialog(null, "El valor de edad no puede ser menor que 0.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else if (cont.verificarPersonaInclusion(textFieldNom.getText())) {
				JOptionPane.showMessageDialog(null,
						"Ya existe una persona en inclusion con el mismo nombre en la base de datos.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (errorChecks(2)) {
					JOptionPane.showMessageDialog(null,
							"Hay mas caracteres que el limite de caracteres en uno de los campos de texto con limite especificado.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else if (errorChecks(3)) {
					JOptionPane.showMessageDialog(null,
							"El formato de ultimo año trabajado es incorrecto. Introduce un año numerico y valido.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					String cv = null, otros = null, intereses = null, situacion = null;
					int result = 0, year = 0;
					Accesibilidad accesibilidad = null;
					Formacion formacion = null;
					Localidad municipio = null;
					Sector sectorInteres = null;

					switch ((String) comboBoxFormacion.getSelectedItem()) {
					case "AT":
						formacion = Formacion.AT;
						break;

					case "Primaria":
						formacion = Formacion.PRIMARIA;
						break;

					case "ESO":
						formacion = Formacion.ESO;
						break;

					case "EPA":
						formacion = Formacion.EPA;
						break;

					case "FP Basica":
						formacion = Formacion.FP_BASICA;
						break;

					case "GM":
						formacion = Formacion.GM;
						break;

					case "Bachillerato":
						formacion = Formacion.BACHILLERATO;
						break;

					case "GS":
						formacion = Formacion.GS;
						break;

					case "Universidad":
						formacion = Formacion.UNIVERSIDAD;
						break;

					case "Master":
						formacion = Formacion.MASTER;
						break;

					case "Doctorado":
						formacion = Formacion.DOCTORADO;
						break;
					}

					switch ((String) comboBoxSectorInteres.getSelectedItem()) {
					case "Agricultura y Ganaderia":
						sectorInteres = Sector.AGRICULTURA_GANADERIA;
						break;

					case "Bienes de Consumo":
						sectorInteres = Sector.BIENESCONSUMO;
						break;

					case "Comercio electronico":
						sectorInteres = Sector.COMERCIOELECTRONICO;
						break;

					case "Comercio y establecimientos":
						sectorInteres = Sector.COMERCIO_ESTABLECIMIENTOS;
						break;

					case "Construccion":
						sectorInteres = Sector.CONSTRUCCION;
						break;

					case "Deporte y ocio":
						sectorInteres = Sector.DEPORTE_OCIO;
						break;

					case "Energia y medio ambiente":
						sectorInteres = Sector.ENERGIA_MEDIOAMBIENTE;
						break;

					case "Finanzas, Seguros y bienes inmuebles":
						sectorInteres = Sector.FINANZAS_SEGUROS_BIENESINMUEBLES;
						break;

					case "Internet":
						sectorInteres = Sector.INTERNET;
						break;

					case "Logistica y Transporte":
						sectorInteres = Sector.LOGISTICA_TRANSPORTE;
						break;

					case "Medios de comunicacion y marketing":
						sectorInteres = Sector.MEDIOSCOMUNICACION_MARKETING;
						break;

					case "Metalurgia y electronica":
						sectorInteres = Sector.METALURGIA_ELECTRONICA;
						break;

					case "Productos quimicos y materias primas":
						sectorInteres = Sector.PRODUCTOSQUIMICOS_MATERIASPRIMAS;
						break;

					case "Salud e industria farmaceutica":
						sectorInteres = Sector.SALUD_INDUSTRIAFARMACEUTICA;
						break;

					case "Servicios":
						sectorInteres = Sector.SERVICIOS;
						break;

					case "Sociedad":
						sectorInteres = Sector.SOCIEDAD;
						break;

					case "Tecnologia y telecomunicaciones":
						sectorInteres = Sector.TECNOLOGIA_TELECOMUNICACIONES;
						break;

					case "Turismo y hosteleria":
						sectorInteres = Sector.TURISMO_HOSTELERIA;
						break;

					case "Vida":
						sectorInteres = Sector.VIDA;
						break;
					}

					switch ((String) comboBoxMunicipio.getSelectedItem()) {
					case "Abadiño":
						municipio = Localidad.ABADIÑO;
						break;

					case "Abanto-Zierbena":
						municipio = Localidad.ABANTO_ZIERBENA;
						break;

					case "Ajangiz":
						municipio = Localidad.AJANGIZ;
						break;

					case "Alonsotegi":
						municipio = Localidad.ALONSOTEGI;
						break;

					case "Amorebieta":
						municipio = Localidad.AMOREBIETA;
						break;

					case "Amoroto":
						municipio = Localidad.AMOROTO;
						break;

					case "Amurrio":
						municipio = Localidad.AMURRIO;
						break;

					case "Arakaldo":
						municipio = Localidad.ARAKALDO;
						break;

					case "Arantzazu":
						municipio = Localidad.ARANTZAZU;
						break;

					case "Areatza o Bilaro":
						municipio = Localidad.AREATZA_BILARO;
						break;

					case "Arrankudiaga":
						municipio = Localidad.ARRANKUDIAGA;
						break;

					case "Arratzu":
						municipio = Localidad.ARRATZU;
						break;

					case "Arrieta":
						municipio = Localidad.ARRIETA;
						break;

					case "Arrigorriaga":
						municipio = Localidad.ARRIGORRIAGA;
						break;

					case "Artzentales":
						municipio = Localidad.ARTZENTALES;
						break;

					case "Artziniega":
						municipio = Localidad.ARTZINIEGA;
						break;

					case "Aulesti":
						municipio = Localidad.AULESTI;
						break;

					case "Axpe Atxondo":
						municipio = Localidad.AXPEATXONDO;
						break;

					case "Ayala/Aiara":
						municipio = Localidad.AYALA_AIARA;
						break;

					case "Bakio":
						municipio = Localidad.BAKIO;
						break;

					case "Balmaseda":
						municipio = Localidad.BALMASEDA;
						break;

					case "Barakaldo":
						municipio = Localidad.BARAKALDO;
						break;

					case "Barrika":
						municipio = Localidad.BARRIKA;
						break;

					case "Basauri":
						municipio = Localidad.BASAURI;
						break;

					case "Bedia":
						municipio = Localidad.BEDIA;
						break;

					case "Berango":
						municipio = Localidad.BERANGO;
						break;

					case "Bermeo":
						municipio = Localidad.BERMEO;
						break;

					case "Berriatua":
						municipio = Localidad.BERRIATUA;
						break;

					case "Berriz":
						municipio = Localidad.BERRIZ;
						break;

					case "Bilbao":
						municipio = Localidad.BILBAO;
						break;

					case "Busturia":
						municipio = Localidad.BUSTURIA;
						break;

					case "Castro Urdiales":
						municipio = Localidad.CASTROURDIALES;
						break;

					case "Derio":
						municipio = Localidad.DERIO;
						break;

					case "Dima":
						municipio = Localidad.DIMA;
						break;

					case "Durango":
						municipio = Localidad.DURANGO;
						break;

					case "Ea":
						municipio = Localidad.EA;
						break;

					case "Elantxobe":
						municipio = Localidad.ELANTXOBE;
						break;

					case "Elorrio":
						municipio = Localidad.ELORRIO;
						break;

					case "Erandio":
						municipio = Localidad.ERANDIO;
						break;

					case "Ereño":
						municipio = Localidad.EREÑO;
						break;

					case "Ermua":
						municipio = Localidad.ERMUA;
						break;

					case "Errigoiti":
						municipio = Localidad.ERRIGOITI;
						break;

					case "Etxebarri":
						municipio = Localidad.ETXEBARRI;
						break;

					case "Etxebarria":
						municipio = Localidad.ETXEBARRIA;
						break;

					case "Forua":
						municipio = Localidad.FORUA;
						break;

					case "Fruiz":
						municipio = Localidad.FRUIZ;
						break;

					case "Galdakao":
						municipio = Localidad.GALDAKAO;
						break;

					case "Galdames":
						municipio = Localidad.GALDAMES;
						break;

					case "Gamiz-Fika":
						municipio = Localidad.GAMIZFIKA;
						break;

					case "Garai":
						municipio = Localidad.GARAI;
						break;

					case "Gatika":
						municipio = Localidad.GATIKA;
						break;

					case "Gautegiz":
						municipio = Localidad.GAUTEGIZ;
						break;

					case "Gaztelu-Elexabeitia o Arteaga":
						municipio = Localidad.GAZTELUELEXABEITIA_ARTEAGA;
						break;

					case "Gernika-Lumo":
						municipio = Localidad.GERNIKALUMO;
						break;

					case "Getxo":
						municipio = Localidad.GETXO;
						break;

					case "Gizaburuaga":
						municipio = Localidad.GIZABURUAGA;
						break;

					case "Gordexola":
						municipio = Localidad.GORDEXOLA;
						break;

					case "Gorliz":
						municipio = Localidad.GORLIZ;
						break;

					case "Gueñes":
						municipio = Localidad.GUEÑES;
						break;

					case "Ibarrangelu":
						municipio = Localidad.IBARRANGELU;
						break;

					case "Igorre":
						municipio = Localidad.IGORRE;
						break;

					case "Ispaster":
						municipio = Localidad.ISPASTER;
						break;

					case "Iurreta":
						municipio = Localidad.IURRETA;
						break;

					case "Izurtza":
						municipio = Localidad.IZURTZA;
						break;

					case "Karrantza Harana":
						municipio = Localidad.KARRANTZAHARANA;
						break;

					case "Kortezubi":
						municipio = Localidad.KORTEZUBI;
						break;

					case "Lanestosa":
						municipio = Localidad.LANESTOSA;
						break;

					case "Larrabetzu":
						municipio = Localidad.LARRABETZU;
						break;

					case "Laudio/Llodio":
						municipio = Localidad.LAUDIO_LLODIO;
						break;

					case "Laukiz":
						municipio = Localidad.LAUKIZ;
						break;

					case "Leioa":
						municipio = Localidad.LEIOA;
						break;

					case "Lekeitio":
						municipio = Localidad.LEKEITIO;
						break;

					case "Lemoa":
						municipio = Localidad.LEMOA;
						break;

					case "Lemoiz":
						municipio = Localidad.LEMOIZ;
						break;

					case "Lezama":
						municipio = Localidad.LEZAMA;
						break;

					case "Loiu":
						municipio = Localidad.LOIU;
						break;

					case "Mallabia":
						municipio = Localidad.MALLABIA;
						break;

					case "Mañaria":
						municipio = Localidad.MAÑARIA;
						break;

					case "Markina-Xemein":
						municipio = Localidad.MARKINAXEMEIN;
						break;

					case "Maruri":
						municipio = Localidad.MARURI;
						break;

					case "Mendata":
						municipio = Localidad.MENDATA;
						break;

					case "Mendexa":
						municipio = Localidad.MENDEXA;
						break;

					case "Meñaka":
						municipio = Localidad.MEÑAKA;
						break;

					case "Morga":
						municipio = Localidad.MORGA;
						break;

					case "Mundaka":
						municipio = Localidad.MUNDAKA;
						break;

					case "Mungia":
						municipio = Localidad.MUNGIA;
						break;

					case "Munitibar-Arbatzegi Gerrikaitz":
						municipio = Localidad.MUNITIBARARBATZEGI_GERRIKAITZ;
						break;

					case "Murueta":
						municipio = Localidad.MURUETA;
						break;

					case "Muskiz":
						municipio = Localidad.MUSKIZ;
						break;

					case "Muxika":
						municipio = Localidad.MUXIKA;
						break;

					case "Nabarniz":
						municipio = Localidad.NABARNIZ;
						break;

					case "Ondarroa":
						municipio = Localidad.ONDARROA;
						break;

					case "Orduña":
						municipio = Localidad.ORDUÑA;
						break;

					case "Orozko":
						municipio = Localidad.OROZKO;
						break;

					case "Ortuella":
						municipio = Localidad.ORTUELLA;
						break;

					case "Otxandio":
						municipio = Localidad.OTXANDIO;
						break;

					case "Plentzia":
						municipio = Localidad.PLENTZIA;
						break;

					case "Portugalete":
						municipio = Localidad.PORTUGALETE;
						break;

					case "Santurtzi":
						municipio = Localidad.SANTURTZI;
						break;

					case "Sestao":
						municipio = Localidad.SESTAO;
						break;

					case "Sondika":
						municipio = Localidad.SONDIKA;
						break;

					case "Sopela":
						municipio = Localidad.SOPELA;
						break;

					case "Sopuerta":
						municipio = Localidad.SOPUERTA;
						break;

					case "Sukarrieta":
						municipio = Localidad.SUKARRIETA;
						break;

					case "Trapagaran":
						municipio = Localidad.TRAPAGARAN;
						break;

					case "Turtzioz":
						municipio = Localidad.TURTZIOZ;
						break;

					case "Ubide":
						municipio = Localidad.UBIDE;
						break;

					case "Ugao-Miraballes":
						municipio = Localidad.UGAOMIRABALLES;
						break;

					case "Urduliz":
						municipio = Localidad.URDULIZ;
						break;

					case "Urduña":
						municipio = Localidad.URDUÑA;
						break;

					case "Usansolo":
						municipio = Localidad.USANSOLO;
						break;

					case "Zaldibar":
						municipio = Localidad.ZALDIBAR;
						break;

					case "Zalla":
						municipio = Localidad.ZALLA;
						break;

					case "Zamudio":
						municipio = Localidad.ZAMUDIO;
						break;

					case "Zaratamo":
						municipio = Localidad.ZARATAMO;
						break;

					case "Zeanuri":
						municipio = Localidad.ZEANURI;
						break;

					case "Zeberio":
						municipio = Localidad.ZEBERIO;
						break;

					case "Zierbena":
						municipio = Localidad.ZIERBENA;
						break;

					case "Ziortza-Bolibar":
						municipio = Localidad.ZIORTZA_BOLIBAR;
						break;

					case "Zornotza":
						municipio = Localidad.ZORNOTZA;
						break;
					}

					switch ((String) comboBoxAccesibilidad.getSelectedItem()) {
					case "Carnet + coche":
						accesibilidad = Accesibilidad.CARNET_COCHE;
						break;

					case "Carnet":
						accesibilidad = Accesibilidad.CARNET;
						break;

					case "Transporte publico":
						accesibilidad = Accesibilidad.TRANSPORTE_PUBLICO;
						break;
					}

					if (!textFieldCV.getText().isBlank()) {
						cv = textFieldCV.getText();
					}

					if (!textAreaOtros.getText().isBlank()) {
						otros = textAreaOtros.getText();
					}

					if (!textFieldUltimoAñoTrabajado.getText().isBlank()) {
						year = Integer.parseInt(textFieldUltimoAñoTrabajado.getText());
					}

					if (!textAreaInteresesPersonales.getText().isBlank()) {
						intereses = textAreaInteresesPersonales.getText();
					}

					if (!textAreaSituacionActual.getText().isBlank()) {
						situacion = textAreaSituacionActual.getText();
					}

					if (cont.añadirPersonaInclusion(new PersonaInclusion(textFieldNom.getText(),
							textFieldApellidos.getText(), (Integer) spinnerEdad.getValue(), municipio, formacion,
							textAreaEspecialidad.getText(), otros, textFieldIdioma.getText(), year, sectorInteres,
							intereses, situacion, accesibilidad, cv,
							(String) comboBoxPersonaFacilitadora.getEditor().getItem()))) {
						result = JOptionPane.showConfirmDialog(null,
								"La persona en inclusion ha sido añadida correctamente. Quiere añadir mas personas en inclusion?",
								"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							textAreaEspecialidad.setText("");
							textAreaInteresesPersonales.setText("");
							textAreaOtros.setText("");
							textAreaSituacionActual.setText("");
							textFieldApellidos.setText("");
							textFieldCV.setText("");
							textFieldIdioma.setText("");
							textFieldNom.setText("");
							textFieldUltimoAñoTrabajado.setText("");
							comboBoxAccesibilidad.setSelectedIndex(0);
							comboBoxFormacion.setSelectedIndex(0);
							comboBoxMunicipio.setSelectedIndex(0);
							comboBoxPersonaFacilitadora.setSelectedIndex(0);
							comboBoxSectorInteres.setSelectedIndex(0);
						}
					} else {
						errorChecks(1);
					}
				}
			}
		}
	}
}
