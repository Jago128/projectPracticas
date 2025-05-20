package windows;

import java.awt.*;
import java.awt.event.*;

import java.time.*;
import java.time.format.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import model.PersonaOrientacion;

public class VentanaAñadirPersonaOrientacion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldCVLink, textFieldOtrosIdiomas, textFieldNom, textFieldUltimoAñoTrabajado;
	private JComboBox<String> comboBoxFormacion, comboBoxSectorInteres, comboBoxCertifDiscapacidad, comboBoxEuskera,
			comboBoxIngles, comboBoxLocalidad, comboBoxAccesibilidad, comboBoxApoyo;
	private JTextArea textAreaObservaciones, textAreaInteresesPersonales, textAreaSituacionActual, textAreaEspecialidad;
	private JButton btnAñadir;

	public VentanaAñadirPersonaOrientacion(JDialog parent, LoginController cont) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir personas en orientacion y seguimiento");
		setBounds(100, 100, 960, 650);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(369, 10, 241, 24);
		getContentPane().add(lblObligatorio);

		JLabel lblNom = new JLabel("Nombre: *");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(10, 39, 103, 28);
		getContentPane().add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(129, 45, 163, 19);
		getContentPane().add(textFieldNom);

		JLabel lblApoyo = new JLabel("Apoyo: *");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(318, 39, 97, 28);
		getContentPane().add(lblApoyo);

		comboBoxApoyo = new JComboBox<>();
		comboBoxApoyo.setEditable(true);
		comboBoxApoyo.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxApoyo.setSelectedIndex(0);
		comboBoxApoyo.setBounds(425, 44, 163, 21);
		getContentPane().add(comboBoxApoyo);

		JLabel lblFormacion = new JLabel("Formacion: *");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(32, 80, 108, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(150, 85, 163, 21);

		getContentPane().add(comboBoxFormacion);
		JLabel lblEspecialidad = new JLabel("Especialidad: * (Describa la especialidad)");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(607, 410, 313, 28);
		getContentPane().add(lblEspecialidad);

		textAreaEspecialidad = new JTextArea();
		textAreaEspecialidad.setLineWrap(true);
		textAreaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaEspecialidad.setBounds(500, 448, 446, 107);
		getContentPane().add(textAreaEspecialidad);

		JLabel lblSectorInteres = new JLabel("Sector de interes: *");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(32, 118, 129, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(171, 123, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		JLabel lblCVLink = new JLabel("CV Link:");
		lblCVLink.setHorizontalAlignment(SwingConstants.CENTER);
		lblCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCVLink.setBounds(350, 77, 78, 28);
		getContentPane().add(lblCVLink);

		textFieldCVLink = new JTextField();
		textFieldCVLink.setColumns(10);
		textFieldCVLink.setBounds(422, 83, 524, 19);
		getContentPane().add(textFieldCVLink);

		JLabel lblCertifDiscapacidad = new JLabel("Certificado discapacidad: *");
		lblCertifDiscapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCertifDiscapacidad.setBounds(344, 118, 152, 28);
		getContentPane().add(lblCertifDiscapacidad);

		comboBoxCertifDiscapacidad = new JComboBox<>();
		comboBoxCertifDiscapacidad
				.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No", "No sabe", "Tramitando" }));
		comboBoxCertifDiscapacidad.setSelectedIndex(0);
		comboBoxCertifDiscapacidad.setBounds(504, 123, 163, 21);
		getContentPane().add(comboBoxCertifDiscapacidad);

		JLabel lblUltimoAñoTrabajado = new JLabel("Ultimo año trabajado:");
		lblUltimoAñoTrabajado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUltimoAñoTrabajado.setBounds(494, 190, 163, 31);
		getContentPane().add(lblUltimoAñoTrabajado);

		textFieldUltimoAñoTrabajado = new JTextField();
		textFieldUltimoAñoTrabajado.setColumns(10);
		textFieldUltimoAñoTrabajado.setBounds(671, 197, 163, 19);
		getContentPane().add(textFieldUltimoAñoTrabajado);

		textAreaInteresesPersonales = new JTextArea();
		textAreaInteresesPersonales.setLineWrap(true);
		textAreaInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInteresesPersonales.setBounds(10, 273, 446, 110);
		getContentPane().add(textAreaInteresesPersonales);

		JLabel lbl_InteresesPersonales = new JLabel("Intereses personales:");
		lbl_InteresesPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_InteresesPersonales.setBounds(105, 232, 163, 31);
		getContentPane().add(lbl_InteresesPersonales);

		textAreaSituacionActual = new JTextArea();
		textAreaSituacionActual.setLineWrap(true);
		textAreaSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaSituacionActual.setBounds(500, 273, 446, 110);
		getContentPane().add(textAreaSituacionActual);

		JLabel lblSituacionActual = new JLabel("Situacion actual:");
		lblSituacionActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituacionActual.setBounds(649, 236, 152, 31);
		getContentPane().add(lblSituacionActual);

		JLabel lblEuskera = new JLabel("Euskera:");
		lblEuskera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEuskera.setBounds(690, 118, 78, 28);
		getContentPane().add(lblEuskera);

		comboBoxEuskera = new JComboBox<>();
		comboBoxEuskera.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxEuskera.setSelectedIndex(0);
		comboBoxEuskera.setBounds(773, 123, 163, 21);
		getContentPane().add(comboBoxEuskera);

		JLabel lblIngles = new JLabel("Ingles:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngles.setBounds(32, 156, 78, 28);
		getContentPane().add(lblIngles);

		comboBoxIngles = new JComboBox<>();
		comboBoxIngles.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxIngles.setSelectedIndex(0);
		comboBoxIngles.setBounds(120, 161, 163, 21);
		getContentPane().add(comboBoxIngles);

		JLabel lblOtrosIdiomas = new JLabel("Otros idiomas:");
		lblOtrosIdiomas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtrosIdiomas.setBounds(303, 154, 108, 31);
		getContentPane().add(lblOtrosIdiomas);

		textFieldOtrosIdiomas = new JTextField();
		textFieldOtrosIdiomas.setColumns(10);
		textFieldOtrosIdiomas.setBounds(425, 161, 163, 19);
		getContentPane().add(textFieldOtrosIdiomas);

		JLabel lblLocalidad = new JLabel("Localidad: *");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(628, 154, 103, 31);
		getContentPane().add(lblLocalidad);

		comboBoxLocalidad = new JComboBox<>();
		comboBoxLocalidad.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Abadiño", "Abanto-Zierbena",
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
		comboBoxLocalidad.setSelectedIndex(0);
		comboBoxLocalidad.setBounds(739, 160, 163, 21);
		getContentPane().add(comboBoxLocalidad);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad: *");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(170, 190, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(303, 196, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(169, 409, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres para los cuatro)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(383, 393, 217, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(20, 446, 446, 110);
		getContentPane().add(textAreaObservaciones);

		btnAñadir = new JButton("Añadir persona");
		btnAñadir.setBackground(new Color(38, 201, 236));
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(345, 566, 286, 37);
		getContentPane().add(btnAñadir);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAñadirPersonaOrientacion.class.getResource("/img/apnabilan.png")));
		logo.setBounds(611, 10, 325, 78);
		getContentPane().add(logo);
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
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la persona en orientacion.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaObservaciones.getText().length() > 500) {
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
			Year.parse(textFieldUltimoAñoTrabajado.getText());
		} catch (DateTimeParseException e) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldNom.getText().isBlank() || comboBoxApoyo.getEditor().getItem().equals("---")
					|| textAreaEspecialidad.getText().isBlank() || comboBoxFormacion.getSelectedItem().equals("---")
					|| comboBoxSectorInteres.getSelectedItem().equals("---")
					|| comboBoxCertifDiscapacidad.getSelectedItem().equals("---")
					|| comboBoxLocalidad.getSelectedItem().equals("---")
					|| comboBoxAccesibilidad.getSelectedItem().equals("---")) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarPersona(textFieldNom.getText())) {
				JOptionPane.showMessageDialog(null,
						"Ya existe una persona en orientacion con el mismo nombre en la base de datos.", "ERROR",
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
					String cv = null, oI = null, observaciones = null, intereses = null, situacion = null;
					int result = 0, year = 0;
					Accesibilidad accesibilidad = null;
					Discapacidad discapacidad = null;
					Euskera eus = null;
					Formacion formacion = null;
					Ingles en = null;
					Localidad localidad = null;
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

					switch ((String) comboBoxCertifDiscapacidad.getSelectedItem()) {
					case "Si":
						discapacidad = Discapacidad.SI;
						break;

					case "No":
						discapacidad = Discapacidad.NO;
						break;

					case "No sabe":
						discapacidad = Discapacidad.NO_SABE;
						break;

					case "Tramitando":
						discapacidad = Discapacidad.TRAMITANDO;
						break;
					}

					if (!comboBoxEuskera.getSelectedItem().equals("---")) {
						switch ((String) comboBoxEuskera.getSelectedItem()) {
						case "A1":
							eus = Euskera.A1;
							break;

						case "A2":
							eus = Euskera.A2;
							break;

						case "B1":
							eus = Euskera.B1;
							break;

						case "B2":
							eus = Euskera.B2;
							break;

						case "C1":
							eus = Euskera.C1;
							break;

						case "C2":
							eus = Euskera.C2;
							break;

						case "Conocimiento, pero sin acreditar":
							eus = Euskera.CONOCIMIENTO_NOACREDITADO;
							break;
						}
					}

					if (!comboBoxIngles.getSelectedItem().equals("---")) {
						switch ((String) comboBoxIngles.getSelectedItem()) {
						case "A1":
							en = Ingles.A1;
							break;

						case "A2":
							en = Ingles.A2;
							break;

						case "B1":
							en = Ingles.B1;
							break;

						case "B2":
							en = Ingles.B2;
							break;

						case "C1":
							en = Ingles.C1;
							break;

						case "C2":
							en = Ingles.C2;
							break;

						case "Conocimiento, pero sin acreditar":
							en = Ingles.CONOCIMIENTO_NOACREDITADO;
							break;
						}
					}

					switch ((String) comboBoxLocalidad.getSelectedItem()) {
					case "Abadiño":
						localidad = Localidad.ABADIÑO;
						break;

					case "Abanto-Zierbena":
						localidad = Localidad.ABANTO_ZIERBENA;
						break;

					case "Ajangiz":
						localidad = Localidad.AJANGIZ;
						break;

					case "Alonsotegi":
						localidad = Localidad.ALONSOTEGI;
						break;

					case "Amorebieta":
						localidad = Localidad.AMOREBIETA;
						break;

					case "Amoroto":
						localidad = Localidad.AMOROTO;
						break;

					case "Amurrio":
						localidad = Localidad.AMURRIO;
						break;

					case "Arakaldo":
						localidad = Localidad.ARAKALDO;
						break;

					case "Arantzazu":
						localidad = Localidad.ARANTZAZU;
						break;

					case "Areatza o Bilaro":
						localidad = Localidad.AREATZA_BILARO;
						break;

					case "Arrankudiaga":
						localidad = Localidad.ARRANKUDIAGA;
						break;

					case "Arratzu":
						localidad = Localidad.ARRATZU;
						break;

					case "Arrieta":
						localidad = Localidad.ARRIETA;
						break;

					case "Arrigorriaga":
						localidad = Localidad.ARRIGORRIAGA;
						break;

					case "Artzentales":
						localidad = Localidad.ARTZENTALES;
						break;

					case "Artziniega":
						localidad = Localidad.ARTZINIEGA;
						break;

					case "Aulesti":
						localidad = Localidad.AULESTI;
						break;

					case "Axpe Atxondo":
						localidad = Localidad.AXPEATXONDO;
						break;

					case "Ayala/Aiara":
						localidad = Localidad.AYALA_AIARA;
						break;

					case "Bakio":
						localidad = Localidad.BAKIO;
						break;

					case "Balmaseda":
						localidad = Localidad.BALMASEDA;
						break;

					case "Barakaldo":
						localidad = Localidad.BARAKALDO;
						break;

					case "Barrika":
						localidad = Localidad.BARRIKA;
						break;

					case "Basauri":
						localidad = Localidad.BASAURI;
						break;

					case "Bedia":
						localidad = Localidad.BEDIA;
						break;

					case "Berango":
						localidad = Localidad.BERANGO;
						break;

					case "Bermeo":
						localidad = Localidad.BERMEO;
						break;

					case "Berriatua":
						localidad = Localidad.BERRIATUA;
						break;

					case "Berriz":
						localidad = Localidad.BERRIZ;
						break;

					case "Bilbao":
						localidad = Localidad.BILBAO;
						break;

					case "Busturia":
						localidad = Localidad.BUSTURIA;
						break;

					case "Castro Urdiales":
						localidad = Localidad.CASTROURDIALES;
						break;

					case "Derio":
						localidad = Localidad.DERIO;
						break;

					case "Dima":
						localidad = Localidad.DIMA;
						break;

					case "Durango":
						localidad = Localidad.DURANGO;
						break;

					case "Ea":
						localidad = Localidad.EA;
						break;

					case "Elantxobe":
						localidad = Localidad.ELANTXOBE;
						break;

					case "Elorrio":
						localidad = Localidad.ELORRIO;
						break;

					case "Erandio":
						localidad = Localidad.ERANDIO;
						break;

					case "Ereño":
						localidad = Localidad.EREÑO;
						break;

					case "Ermua":
						localidad = Localidad.ERMUA;
						break;

					case "Errigoiti":
						localidad = Localidad.ERRIGOITI;
						break;

					case "Etxebarri":
						localidad = Localidad.ETXEBARRI;
						break;

					case "Etxebarria":
						localidad = Localidad.ETXEBARRIA;
						break;

					case "Forua":
						localidad = Localidad.FORUA;
						break;

					case "Fruiz":
						localidad = Localidad.FRUIZ;
						break;

					case "Galdakao":
						localidad = Localidad.GALDAKAO;
						break;

					case "Galdames":
						localidad = Localidad.GALDAMES;
						break;

					case "Gamiz-Fika":
						localidad = Localidad.GAMIZFIKA;
						break;

					case "Garai":
						localidad = Localidad.GARAI;
						break;

					case "Gatika":
						localidad = Localidad.GATIKA;
						break;

					case "Gautegiz":
						localidad = Localidad.GAUTEGIZ;
						break;

					case "Gaztelu-Elexabeitia o Arteaga":
						localidad = Localidad.GAZTELUELEXABEITIA_ARTEAGA;
						break;

					case "Gernika-Lumo":
						localidad = Localidad.GERNIKALUMO;
						break;

					case "Getxo":
						localidad = Localidad.GETXO;
						break;

					case "Gizaburuaga":
						localidad = Localidad.GIZABURUAGA;
						break;

					case "Gordexola":
						localidad = Localidad.GORDEXOLA;
						break;

					case "Gorliz":
						localidad = Localidad.GORLIZ;
						break;

					case "Gueñes":
						localidad = Localidad.GUEÑES;
						break;

					case "Ibarrangelu":
						localidad = Localidad.IBARRANGELU;
						break;

					case "Igorre":
						localidad = Localidad.IGORRE;
						break;

					case "Ispaster":
						localidad = Localidad.ISPASTER;
						break;

					case "Iurreta":
						localidad = Localidad.IURRETA;
						break;

					case "Izurtza":
						localidad = Localidad.IZURTZA;
						break;

					case "Karrantza Harana":
						localidad = Localidad.KARRANTZAHARANA;
						break;

					case "Kortezubi":
						localidad = Localidad.KORTEZUBI;
						break;

					case "Lanestosa":
						localidad = Localidad.LANESTOSA;
						break;

					case "Larrabetzu":
						localidad = Localidad.LARRABETZU;
						break;

					case "Laudio/Llodio":
						localidad = Localidad.LAUDIO_LLODIO;
						break;

					case "Laukiz":
						localidad = Localidad.LAUKIZ;
						break;

					case "Leioa":
						localidad = Localidad.LEIOA;
						break;

					case "Lekeitio":
						localidad = Localidad.LEKEITIO;
						break;

					case "Lemoa":
						localidad = Localidad.LEMOA;
						break;

					case "Lemoiz":
						localidad = Localidad.LEMOIZ;
						break;

					case "Lezama":
						localidad = Localidad.LEZAMA;
						break;

					case "Loiu":
						localidad = Localidad.LOIU;
						break;

					case "Mallabia":
						localidad = Localidad.MALLABIA;
						break;

					case "Mañaria":
						localidad = Localidad.MAÑARIA;
						break;

					case "Markina-Xemein":
						localidad = Localidad.MARKINAXEMEIN;
						break;

					case "Maruri":
						localidad = Localidad.MARURI;
						break;

					case "Mendata":
						localidad = Localidad.MENDATA;
						break;

					case "Mendexa":
						localidad = Localidad.MENDEXA;
						break;

					case "Meñaka":
						localidad = Localidad.MEÑAKA;
						break;

					case "Morga":
						localidad = Localidad.MORGA;
						break;

					case "Mundaka":
						localidad = Localidad.MUNDAKA;
						break;

					case "Mungia":
						localidad = Localidad.MUNGIA;
						break;

					case "Munitibar-Arbatzegi Gerrikaitz":
						localidad = Localidad.MUNITIBARARBATZEGI_GERRIKAITZ;
						break;

					case "Murueta":
						localidad = Localidad.MURUETA;
						break;

					case "Muskiz":
						localidad = Localidad.MUSKIZ;
						break;

					case "Muxika":
						localidad = Localidad.MUXIKA;
						break;

					case "Nabarniz":
						localidad = Localidad.NABARNIZ;
						break;

					case "Ondarroa":
						localidad = Localidad.ONDARROA;
						break;

					case "Orduña":
						localidad = Localidad.ORDUÑA;
						break;

					case "Orozko":
						localidad = Localidad.OROZKO;
						break;

					case "Ortuella":
						localidad = Localidad.ORTUELLA;
						break;

					case "Otxandio":
						localidad = Localidad.OTXANDIO;
						break;

					case "Plentzia":
						localidad = Localidad.PLENTZIA;
						break;

					case "Portugalete":
						localidad = Localidad.PORTUGALETE;
						break;

					case "Santurtzi":
						localidad = Localidad.SANTURTZI;
						break;

					case "Sestao":
						localidad = Localidad.SESTAO;
						break;

					case "Sondika":
						localidad = Localidad.SONDIKA;
						break;

					case "Sopela":
						localidad = Localidad.SOPELA;
						break;

					case "Sopuerta":
						localidad = Localidad.SOPUERTA;
						break;

					case "Sukarrieta":
						localidad = Localidad.SUKARRIETA;
						break;

					case "Trapagaran":
						localidad = Localidad.TRAPAGARAN;
						break;

					case "Turtzioz":
						localidad = Localidad.TURTZIOZ;
						break;

					case "Ubide":
						localidad = Localidad.UBIDE;
						break;

					case "Ugao-Miraballes":
						localidad = Localidad.UGAOMIRABALLES;
						break;

					case "Urduliz":
						localidad = Localidad.URDULIZ;
						break;

					case "Urduña":
						localidad = Localidad.URDUÑA;
						break;

					case "Usansolo":
						localidad = Localidad.USANSOLO;
						break;

					case "Zaldibar":
						localidad = Localidad.ZALDIBAR;
						break;

					case "Zalla":
						localidad = Localidad.ZALLA;
						break;

					case "Zamudio":
						localidad = Localidad.ZAMUDIO;
						break;

					case "Zaratamo":
						localidad = Localidad.ZARATAMO;
						break;

					case "Zeanuri":
						localidad = Localidad.ZEANURI;
						break;

					case "Zeberio":
						localidad = Localidad.ZEBERIO;
						break;

					case "Zierbena":
						localidad = Localidad.ZIERBENA;
						break;

					case "Ziortza-Bolibar":
						localidad = Localidad.ZIORTZA_BOLIBAR;
						break;

					case "Zornotza":
						localidad = Localidad.ZORNOTZA;
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

					if (!textFieldCVLink.getText().isBlank()) {
						cv = textFieldCVLink.getText();
					}

					if (!textFieldOtrosIdiomas.getText().isBlank()) {
						oI = textFieldOtrosIdiomas.getText();
					}

					if (!textAreaObservaciones.getText().isBlank()) {
						observaciones = textAreaObservaciones.getText();
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

					if (cont.añadirPersona(
							new PersonaOrientacion(textFieldNom.getText(), (String) comboBoxApoyo.getEditor().getItem(),
									formacion, textAreaEspecialidad.getText(), sectorInteres, cv, discapacidad, year,
									intereses, situacion, eus, en, oI, localidad, accesibilidad, observaciones))) {
						result = JOptionPane.showConfirmDialog(null,
								"La persona en orientacion ha sido añadida correctamente. Quiere añadir mas personas en orientacion?",
								"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							textAreaEspecialidad.setText("");
							textAreaInteresesPersonales.setText("");
							textAreaObservaciones.setText("");
							textAreaSituacionActual.setText("");
							textFieldCVLink.setText("");
							textFieldNom.setText("");
							textFieldOtrosIdiomas.setText("");
							textFieldUltimoAñoTrabajado.setText("");
							comboBoxAccesibilidad.setSelectedIndex(0);
							comboBoxApoyo.setSelectedIndex(0);
							comboBoxCertifDiscapacidad.setSelectedIndex(0);
							comboBoxEuskera.setSelectedIndex(0);
							comboBoxFormacion.setSelectedIndex(0);
							comboBoxIngles.setSelectedIndex(0);
							comboBoxLocalidad.setSelectedIndex(0);
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
