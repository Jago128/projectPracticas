package windows;

import java.awt.*;
import java.awt.event.*;
import java.time.Year;
import java.time.format.DateTimeParseException;

import javax.swing.*;

import controller.LoginController;
import model.PersonaOrientacion;

public class VentanaModificarPersonaOrientacion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private PersonaOrientacion pO;
	private JTextArea textAreaPersona, textAreaObservaciones, textAreaEspecialidad, textAreaInteresesPersonales,
			textAreaSituacionActual;
	private JTextField textFieldOtrosIdiomas, textFieldCVLink, textFieldUltimoAñoTrabajado;
	private JComboBox<String> comboBoxSectorInteres, comboBoxLocalidad, comboBoxFormacion, comboBoxCertifDiscapacidad,
			comboBoxEuskera, comboBoxIngles, comboBoxAccesibilidad, comboBoxApoyo;
	private JButton btnModificar;

	public VentanaModificarPersonaOrientacion(JDialog parent, LoginController cont,
			PersonaOrientacion personaOrientacion) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.pO = personaOrientacion;

		setResizable(false);
		setTitle("Modificar persona en orientacion y seguimiento");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 810);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaModificarPersonaOrientacion.class.getResource("/img/apnabilan.png")));
		logo.setBounds(21, 10, 325, 78);
		getContentPane().add(logo);

		JLabel lblDatosPersona = new JLabel("Informacion de la persona en orientacion seleccionada:");
		lblDatosPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPersona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosPersona.setBounds(378, 10, 506, 28);
		getContentPane().add(lblDatosPersona);

		textAreaPersona = new JTextArea();
		textAreaPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaPersona.setText("");
		textAreaPersona.setBackground(new Color(255, 255, 255));
		textAreaPersona.setLineWrap(true);
		textAreaPersona.setEditable(false);
		textAreaPersona.setBounds(388, 43, 496, 330);
		getContentPane().add(textAreaPersona);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(10, 86, 377, 28);
		getContentPane().add(lblNota);

		loadPersona();

		JLabel lblApoyo = new JLabel("Apoyo:");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(25, 121, 140, 28);
		getContentPane().add(lblApoyo);

		comboBoxApoyo = new JComboBox<>();
		comboBoxApoyo.setEditable(true);
		comboBoxApoyo.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxApoyo.setSelectedIndex(0);
		comboBoxApoyo.setBounds(175, 127, 163, 19);
		getContentPane().add(comboBoxApoyo);

		JLabel lblFormacion = new JLabel("Formacion:");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(14, 159, 151, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(175, 164, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad: (Describa la especialidad)");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(71, 424, 245, 28);
		getContentPane().add(lblEspecialidad);

		textAreaEspecialidad = new JTextArea();
		textAreaEspecialidad.setLineWrap(true);
		textAreaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaEspecialidad.setBounds(25, 455, 416, 105);
		getContentPane().add(textAreaEspecialidad);

		JLabel lblSectorInteres = new JLabel("Sector interes:");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(46, 187, 119, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(175, 192, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		JLabel lblCVLink = new JLabel("CV Link:");
		lblCVLink.setHorizontalAlignment(SwingConstants.CENTER);
		lblCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCVLink.setBounds(46, 219, 78, 28);
		getContentPane().add(lblCVLink);

		textFieldCVLink = new JTextField();
		textFieldCVLink.setColumns(10);
		textFieldCVLink.setBounds(165, 225, 163, 19);
		getContentPane().add(textFieldCVLink);

		JLabel lblCertifDiscapacidad = new JLabel("Certificado discapacidad:");
		lblCertifDiscapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCertifDiscapacidad.setBounds(25, 257, 140, 28);
		getContentPane().add(lblCertifDiscapacidad);

		comboBoxCertifDiscapacidad = new JComboBox<>();
		comboBoxCertifDiscapacidad
				.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No", "No sabe", "Tramitando" }));
		comboBoxCertifDiscapacidad.setSelectedIndex(0);
		comboBoxCertifDiscapacidad.setBounds(175, 262, 163, 21);
		getContentPane().add(comboBoxCertifDiscapacidad);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres para los cuatro)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(347, 561, 217, 31);
		getContentPane().add(lblMaxChars);

		textAreaInteresesPersonales = new JTextArea();
		textAreaInteresesPersonales.setLineWrap(true);
		textAreaInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInteresesPersonales.setBounds(25, 602, 416, 110);
		getContentPane().add(textAreaInteresesPersonales);

		JLabel lbl_InteresesPersonales = new JLabel("Intereses personales:");
		lbl_InteresesPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_InteresesPersonales.setBounds(174, 570, 163, 31);
		getContentPane().add(lbl_InteresesPersonales);

		JLabel lblSituacionActual = new JLabel("Situacion actual:");
		lblSituacionActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituacionActual.setBounds(613, 570, 152, 31);
		getContentPane().add(lblSituacionActual);

		textAreaSituacionActual = new JTextArea();
		textAreaSituacionActual.setLineWrap(true);
		textAreaSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaSituacionActual.setBounds(451, 602, 433, 110);
		getContentPane().add(textAreaSituacionActual);

		JLabel lblUltimoAñoTrabajado = new JLabel("Ultimo año trabajado:");
		lblUltimoAñoTrabajado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUltimoAñoTrabajado.setBounds(310, 416, 131, 31);
		getContentPane().add(lblUltimoAñoTrabajado);

		textFieldUltimoAñoTrabajado = new JTextField();
		textFieldUltimoAñoTrabajado.setColumns(10);
		textFieldUltimoAñoTrabajado.setBounds(451, 424, 163, 19);
		getContentPane().add(textFieldUltimoAñoTrabajado);

		JLabel lblEuskera = new JLabel("Euskera:");
		lblEuskera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEuskera.setBounds(56, 295, 78, 26);
		getContentPane().add(lblEuskera);

		comboBoxEuskera = new JComboBox<>();
		comboBoxEuskera.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxEuskera.setSelectedIndex(0);
		comboBoxEuskera.setBounds(175, 300, 163, 21);
		getContentPane().add(comboBoxEuskera);

		JLabel lblIngles = new JLabel("Ingles:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngles.setBounds(56, 337, 78, 28);
		getContentPane().add(lblIngles);

		comboBoxIngles = new JComboBox<>();
		comboBoxIngles.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxIngles.setSelectedIndex(0);
		comboBoxIngles.setBounds(175, 342, 163, 21);
		getContentPane().add(comboBoxIngles);

		JLabel lblOtrosIdiomas = new JLabel("Otros idiomas:");
		lblOtrosIdiomas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtrosIdiomas.setBounds(3, 375, 126, 31);
		getContentPane().add(lblOtrosIdiomas);

		textFieldOtrosIdiomas = new JTextField();
		textFieldOtrosIdiomas.setColumns(10);
		textFieldOtrosIdiomas.setBounds(153, 382, 163, 19);
		getContentPane().add(textFieldOtrosIdiomas);

		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(273, 383, 163, 31);
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
		comboBoxLocalidad.setBounds(434, 387, 163, 21);
		getContentPane().add(comboBoxLocalidad);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad:");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(588, 383, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(721, 389, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(634, 423, 108, 31);
		getContentPane().add(lblObservaciones);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(451, 455, 433, 105);
		getContentPane().add(textAreaObservaciones);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaEspecialidad);
		scrollPane_1.setBounds(25, 455, 416, 105);
		getContentPane().add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane(textAreaInteresesPersonales);
		scrollPane_2.setBounds(25, 602, 416, 110);
		getContentPane().add(scrollPane_2);

		JScrollPane scrollPane_3 = new JScrollPane(textAreaSituacionActual);
		scrollPane_3.setBounds(451, 602, 433, 110);
		getContentPane().add(scrollPane_3);

		JScrollPane scrollPane_4 = new JScrollPane(textAreaObservaciones);
		scrollPane_4.setBounds(451, 455, 433, 105);
		getContentPane().add(scrollPane_4);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(363, 722, 175, 43);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void loadPersona() {
		StringBuilder infoPersona = new StringBuilder("");
		String formacion = "", sectorInteres = "", discapacidad = "", euskera = "", ingles = "", localidad = "",
				accesibilidad = "";

		textAreaPersona.setText("");
		switch (pO.getFormacion()) {
		case AT:
			formacion = "AT";
			break;

		case BACHILLERATO:
			formacion = "Bachillerato";
			break;

		case DOCTORADO:
			formacion = "Doctorado";
			break;

		case EPA:
			formacion = "EPA";
			break;

		case ESO:
			formacion = "ESO";
			break;

		case FP_BASICA:
			formacion = "FP_Basica";
			break;

		case GM:
			formacion = "GM";
			break;

		case GS:
			formacion = "GS";
			break;

		case MASTER:
			formacion = "Master";
			break;

		case PRIMARIA:
			formacion = "Primaria";
			break;

		case UNIVERSIDAD:
			formacion = "Universidad";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		switch (pO.getSectorInteres()) {
		case AGRICULTURA_GANADERIA:
			sectorInteres = "Agricultura y ganadería";
			break;

		case BIENESCONSUMO:
			sectorInteres = "Bienes de consumo";
			break;

		case COMERCIOELECTRONICO:
			sectorInteres = "Comercio electrónico";
			break;

		case COMERCIO_ESTABLECIMIENTOS:
			sectorInteres = "Comercio y establecimientos";
			break;

		case CONSTRUCCION:
			sectorInteres = "Construcción";
			break;

		case DEPORTE_OCIO:
			sectorInteres = "Deporte y ocio";
			break;

		case ENERGIA_MEDIOAMBIENTE:
			sectorInteres = "Energía y medio ambiente";
			break;

		case FINANZAS_SEGUROS_BIENESINMUEBLES:
			sectorInteres = "Finanzas, seguros y bienes inmuebles";
			break;

		case INTERNET:
			sectorInteres = "Internet";
			break;

		case LOGISTICA_TRANSPORTE:
			sectorInteres = "Logística y transporte";
			break;

		case MEDIOSCOMUNICACION_MARKETING:
			sectorInteres = "Medios de comunicación y marketing";
			break;

		case METALURGIA_ELECTRONICA:
			sectorInteres = "Metalurgia y electrónica";
			break;

		case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
			sectorInteres = "Productos químicos y materias primas";
			break;

		case SALUD_INDUSTRIAFARMACEUTICA:
			sectorInteres = "Salud e industria farmacéutica";
			break;

		case SERVICIOS:
			sectorInteres = "Servicios";
			break;

		case SOCIEDAD:
			sectorInteres = "Sociedad";
			break;

		case TECNOLOGIA_TELECOMUNICACIONES:
			sectorInteres = "Tecnología y telecomunicaciones";
			break;

		case TURISMO_HOSTELERIA:
			sectorInteres = "Turismo y hostelería";
			break;

		case VIDA:
			sectorInteres = "Vida";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		switch (pO.getCerfificadoDiscapacidad()) {
		case NO:
			discapacidad = "No";
			break;

		case NO_SABE:
			discapacidad = "No sabe";
			break;

		case SI:
			discapacidad = "Si";
			break;

		case TRAMITANDO:
			discapacidad = "Tramitando";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		if (pO.getEuskera() != null) {
			switch (pO.getEuskera()) {
			case A1:
				euskera = "A1";
				break;

			case A2:
				euskera = "A2";
				break;

			case B1:
				euskera = "B1";
				break;

			case B2:
				euskera = "B2";
				break;

			case C1:
				euskera = "C1";
				break;

			case C2:
				euskera = "C2";
				break;

			case CONOCIMIENTO_NOACREDITADO:
				euskera = "Conocimiento, pero sin acreditar";
				break;

			default:
				System.out.println("Tipo invalido");
			}

			if (pO.getIngles() != null) {
				switch (pO.getIngles()) {
				case A1:
					ingles = "A1";
					break;

				case A2:
					ingles = "A2";
					break;

				case B1:
					ingles = "B1";
					break;

				case B2:
					ingles = "B2";
					break;

				case C1:
					ingles = "C1";
					break;

				case C2:
					ingles = "C2";
					break;

				case CONOCIMIENTO_NOACREDITADO:
					ingles = "Conocimiento, pero sin acreditar";
					break;

				default:
					System.out.println("Tipo invalido");
				}
			}

			switch (pO.getLocalidad()) {
			case ABADIÑO:
				localidad = "Abadiño";
				break;

			case ABANTO_ZIERBENA:
				localidad = "Abanto-Zierbena";
				break;

			case AJANGIZ:
				localidad = "Ajangiz";
				break;

			case ALONSOTEGI:
				localidad = "Alonsotegi";
				break;

			case AMOREBIETA:
				localidad = "Amorebieta";
				break;

			case AMOROTO:
				localidad = "Amoroto";
				break;

			case AMURRIO:
				localidad = "Amurrio";
				break;

			case ARAKALDO:
				localidad = "Arakaldo";
				break;

			case ARANTZAZU:
				localidad = "Arantzazu";
				break;

			case AREATZA_BILARO:
				localidad = "Areatza o Bilaro";
				break;

			case ARRANKUDIAGA:
				localidad = "Arrankudiaga";
				break;

			case ARRATZU:
				localidad = "Arratzu";
				break;

			case ARRIETA:
				localidad = "Arrieta";
				break;

			case ARRIGORRIAGA:
				localidad = "Arrigorriaga";
				break;

			case ARTZENTALES:
				localidad = "Artzentales";
				break;

			case ARTZINIEGA:
				localidad = "Artziniega";
				break;

			case AULESTI:
				localidad = "Aulesti";
				break;

			case AXPEATXONDO:
				localidad = "Axpe Atxondo";
				break;

			case AYALA_AIARA:
				localidad = "Ayala/Aiara";
				break;

			case BAKIO:
				localidad = "Bakio";
				break;

			case BALMASEDA:
				localidad = "Balmaseda";
				break;

			case BARAKALDO:
				localidad = "Barakaldo";
				break;

			case BARRIKA:
				localidad = "Barrika";
				break;

			case BASAURI:
				localidad = "Basauri";
				break;

			case BEDIA:
				localidad = "Bedia";
				break;

			case BERANGO:
				localidad = "Berango";
				break;

			case BERMEO:
				localidad = "Bermeo";
				break;

			case BERRIATUA:
				localidad = "Berriatua";
				break;

			case BERRIZ:
				localidad = "Berriz";
				break;

			case BILBAO:
				localidad = "Bilbao";
				break;

			case BUSTURIA:
				localidad = "Busturia";
				break;

			case CASTROURDIALES:
				localidad = "Castro Urdiales";
				break;

			case DERIO:
				localidad = "Derio";
				break;

			case DIMA:
				localidad = "Dima";
				break;

			case DURANGO:
				localidad = "Durango";
				break;

			case EA:
				localidad = "Ea";
				break;

			case ELANTXOBE:
				localidad = "Elantxobe";
				break;

			case ELORRIO:
				localidad = "Elorrio";
				break;

			case ERANDIO:
				localidad = "Erandio";
				break;

			case EREÑO:
				localidad = "Ereño";
				break;

			case ERMUA:
				localidad = "Ermua";
				break;

			case ERRIGOITI:
				localidad = "Errigoiti";
				break;

			case ETXEBARRI:
				localidad = "Etxebarri";
				break;

			case ETXEBARRIA:
				localidad = "Etxebarria";
				break;

			case FORUA:
				localidad = "Forua";
				break;

			case FRUIZ:
				localidad = "Fruiz";
				break;

			case GALDAKAO:
				localidad = "Galdakao";
				break;

			case GALDAMES:
				localidad = "Galdames";
				break;

			case GAMIZFIKA:
				localidad = "Gamiz-Fika";
				break;

			case GARAI:
				localidad = "Garai";
				break;

			case GATIKA:
				localidad = "Gatika";
				break;

			case GAUTEGIZ:
				localidad = "Gautegiz";
				break;

			case GAZTELUELEXABEITIA_ARTEAGA:
				localidad = "Gaztelu-Elexabeitia o Arteaga";
				break;

			case GERNIKALUMO:
				localidad = "Gernika-Lumo";
				break;

			case GETXO:
				localidad = "Getxo";
				break;

			case GIZABURUAGA:
				localidad = "Gizaburuaga";
				break;

			case GORDEXOLA:
				localidad = "Gordexola";
				break;

			case GORLIZ:
				localidad = "Gorliz";
				break;

			case GUEÑES:
				localidad = "Gueñes";
				break;

			case IBARRANGELU:
				localidad = "Ibarrangelu";
				break;

			case IGORRE:
				localidad = "Igorre";
				break;

			case ISPASTER:
				localidad = "Ispaster";
				break;

			case IURRETA:
				localidad = "Iurreta";
				break;

			case IZURTZA:
				localidad = "Izurtza";
				break;

			case KARRANTZAHARANA:
				localidad = "Karrantza Harana";
				break;

			case KORTEZUBI:
				localidad = "Kortezubi";
				break;

			case LANESTOSA:
				localidad = "Lanestosa";
				break;

			case LARRABETZU:
				localidad = "Larrabetzu";
				break;

			case LAUDIO_LLODIO:
				localidad = "Laudio/Llodio";
				break;

			case LAUKIZ:
				localidad = "Laukiz";
				break;

			case LEIOA:
				localidad = "Leioa";
				break;

			case LEKEITIO:
				localidad = "Lekeitio";
				break;

			case LEMOA:
				localidad = "Lemoa";
				break;

			case LEMOIZ:
				localidad = "Lemoiz";
				break;

			case LEZAMA:
				localidad = "Lezama";
				break;

			case LOIU:
				localidad = "Loiu";
				break;

			case MALLABIA:
				localidad = "Mallabia";
				break;

			case MARKINAXEMEIN:
				localidad = "Markina-Xemein";
				break;

			case MARURI:
				localidad = "Maruri";
				break;

			case MAÑARIA:
				localidad = "Mañaria";
				break;

			case MENDATA:
				localidad = "Mendata";
				break;

			case MENDEXA:
				localidad = "Mendexa";
				break;

			case MEÑAKA:
				localidad = "Meñaka";
				break;

			case MORGA:
				localidad = "Morga";
				break;

			case MUNDAKA:
				localidad = "Mundaka";
				break;

			case MUNGIA:
				localidad = "Mungia";
				break;

			case MUNITIBARARBATZEGI_GERRIKAITZ:
				localidad = "Munitibar-Arbatzegi Gerrikaitz";
				break;

			case MURUETA:
				localidad = "Murueta";
				break;

			case MUSKIZ:
				localidad = "Muskiz";
				break;

			case MUXIKA:
				localidad = "Muxika";
				break;

			case NABARNIZ:
				localidad = "Nabarniz";
				break;

			case ONDARROA:
				localidad = "Ondarroa";
				break;

			case ORDUÑA:
				localidad = "Orduña";
				break;

			case OROZKO:
				localidad = "Orozko";
				break;

			case ORTUELLA:
				localidad = "Ortuella";
				break;

			case OTXANDIO:
				localidad = "Otxandio";
				break;

			case PLENTZIA:
				localidad = "Plentzia";
				break;

			case PORTUGALETE:
				localidad = "Portugalete";
				break;

			case SANTURTZI:
				localidad = "Santurtzi";
				break;

			case SESTAO:
				localidad = "Sestao";
				break;

			case SONDIKA:
				localidad = "Sondika";
				break;

			case SOPELA:
				localidad = "Sopela";
				break;

			case SOPUERTA:
				localidad = "Sopuerta";
				break;

			case SUKARRIETA:
				localidad = "Sukarrieta";
				break;

			case TRAPAGARAN:
				localidad = "Trapagaran";
				break;

			case TURTZIOZ:
				localidad = "Turtzioz";
				break;

			case UBIDE:
				localidad = "Ubide";
				break;

			case UGAOMIRABALLES:
				localidad = "Ugao-Miraballes";
				break;

			case URDULIZ:
				localidad = "Urduliz";
				break;

			case URDUÑA:
				localidad = "Urduña";
				break;

			case USANSOLO:
				localidad = "Usansolo";
				break;

			case ZALDIBAR:
				localidad = "Zaldibar";
				break;

			case ZALLA:
				localidad = "Zalla";
				break;

			case ZAMUDIO:
				localidad = "Zamudio";
				break;

			case ZARATAMO:
				localidad = "Zaratamo";
				break;

			case ZEANURI:
				localidad = "Zeanuri";
				break;

			case ZEBERIO:
				localidad = "Zeberio";
				break;

			case ZIERBENA:
				localidad = "Zierbena";
				break;

			case ZIORTZA_BOLIBAR:
				localidad = "Ziortza-Bolibar";
				break;

			case ZORNOTZA:
				localidad = "Zornotza";
				break;

			default:
				System.out.println("Tipo invalido");
			}
		}

		switch (pO.getAccesibilidad()) {
		case CARNET:
			accesibilidad = "Carnet";
			break;

		case CARNET_COCHE:
			accesibilidad = "Carnet + Coche";
			break;

		case TRANSPORTE_PUBLICO:
			accesibilidad = "Transporte publico";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		infoPersona.append("Nombre: " + pO.getNombre()).append("\n");
		infoPersona.append("Apoyo: " + pO.getApoyo()).append("\n");
		infoPersona.append("Formacion: " + formacion).append("\n");
		infoPersona.append("Especialidad: " + pO.getEspecialidad()).append("\n");
		infoPersona.append("Sector de interes: " + sectorInteres).append("\n");
		infoPersona.append("CV Link: " + pO.getCvLink()).append("\n");
		infoPersona.append("Certificado de discapacidad: " + discapacidad).append("\n");

		if (pO.getUltimoAñoTrabajado() != 0) {
			infoPersona.append("Ultimo año trabajado: " + pO.getUltimoAñoTrabajado()).append("\n");
		} else {
			infoPersona.append("Ultimo año trabajado: ---").append("\n");
		}

		if (pO.getInteresesPersonales() != null) {
			infoPersona.append("Intereses personales: " + pO.getInteresesPersonales()).append("\n");
		} else {
			infoPersona.append("Intereses personales: ---").append("\n");
		}

		if (pO.getSituacionActual() != null) {
			infoPersona.append("Situacion actual: " + pO.getSituacionActual()).append("\n");
		} else {
			infoPersona.append("Situacion actual: ---").append("\n");
		}

		if (pO.getEuskera() != null) {
			infoPersona.append("Euskera: " + euskera).append("\n");
		} else {
			infoPersona.append("Euskera: ---").append("\n");
		}

		if (pO.getIngles() != null) {
			infoPersona.append("Ingles: " + ingles).append("\n");
		} else {
			infoPersona.append("Ingles: ---").append("\n");
		}

		if (pO.getOtrosIdiomas() != null) {
			infoPersona.append("Otros idiomas: " + pO.getOtrosIdiomas()).append("\n");
		} else {
			infoPersona.append("Otros idiomas: ---").append("\n");
		}

		infoPersona.append("Localidad: " + localidad).append("\n");
		infoPersona.append("Accesibilidad: " + accesibilidad).append("\n");
		if (pO.getOtrosIdiomas() != null) {
			infoPersona.append("Observaciones: " + pO.getObservaciones());
		} else {
			infoPersona.append("Observaciones: ---");
		}
		textAreaPersona.setText(infoPersona.toString());
	}

	public boolean errorChecks(int errorID) {
		boolean error = false;

		switch (errorID) {
		case 1:
			error = addError();
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

	public boolean addError() { // ErrorID: 1
		boolean check = true;
		StringBuilder infoError = new StringBuilder("Un error ha occurrido en ");

		if (!comboBoxApoyo.getEditor().getItem().equals("---")) {
			check = cont.modificarApoyo((String) comboBoxApoyo.getEditor().getItem(), pO.getNombre());
			if (!check) {
				infoError.append("Apoyo");
			}
		}

		if (!comboBoxFormacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarFormacion(comboBoxFormacion.getItemAt(comboBoxFormacion.getSelectedIndex()),
					pO.getNombre());
			if (!check) {
				infoError.append("Formacion");
			}
		}

		if (!textAreaEspecialidad.getText().isBlank() && check) {
			check = cont.modificarEspecialidad(textAreaEspecialidad.getText(), pO.getNombre());
			if (!check) {
				infoError.append("Especialidad");
			}
		}

		if (!comboBoxSectorInteres.getSelectedItem().equals("---") && check) {
			check = cont.modificarSectorInteres(
					comboBoxSectorInteres.getItemAt(comboBoxSectorInteres.getSelectedIndex()), pO.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textFieldCVLink.getText().isBlank() && check) {
			check = cont.modificarCVLink(textFieldCVLink.getText(), pO.getNombre());
			if (!check) {
				infoError.append("CV Link");
			}
		}

		if (!comboBoxCertifDiscapacidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarDiscapacidad(
					comboBoxCertifDiscapacidad.getItemAt(comboBoxCertifDiscapacidad.getSelectedIndex()),
					pO.getNombre());
			if (!check) {
				infoError.append("Certificado de discapacidad");
			}
		}

		if (!textFieldUltimoAñoTrabajado.getText().isBlank() && check) {
			check = cont.modificarUltimoAñoTrabajador(Integer.parseInt(textFieldUltimoAñoTrabajado.getText()),
					pO.getNombre());
			if (!check) {
				infoError.append("Ultimo año trabajado");
			}
		}

		if (!textAreaInteresesPersonales.getText().isBlank() && check) {
			check = cont.modificarInteresesPersonales(textAreaInteresesPersonales.getText(), pO.getNombre());
			if (!check) {
				infoError.append("Intereses personales");
			}
		}

		if (!textAreaSituacionActual.getText().isBlank() && check) {
			check = cont.modificarSituacionActual(textAreaSituacionActual.getText(), pO.getNombre());
			if (!check) {
				infoError.append("Situacion actual");
			}
		}

		if (!comboBoxEuskera.getSelectedItem().equals("---") && check) {
			check = cont.modificarEuskera(comboBoxEuskera.getItemAt(comboBoxEuskera.getSelectedIndex()),
					pO.getNombre());
			if (!check) {
				infoError.append("Euskera");
			}
		}

		if (!comboBoxIngles.getSelectedItem().equals("---") && check) {
			check = cont.modificarIngles(comboBoxIngles.getItemAt(comboBoxIngles.getSelectedIndex()), pO.getNombre());
			if (!check) {
				infoError.append("Ingles");
			}
		}

		if (!textFieldOtrosIdiomas.getText().isBlank() && check) {
			check = cont.modificarOtrosIdiomas(textFieldOtrosIdiomas.getText(), pO.getNombre());
			if (!check) {
				infoError.append("Otros idiomas");
			}
		}

		if (!comboBoxLocalidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarLocalidad(comboBoxLocalidad.getItemAt(comboBoxLocalidad.getSelectedIndex()),
					pO.getNombre());
			if (!check) {
				infoError.append("Localidad");
			}
		}

		if (!comboBoxAccesibilidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarAccesibilidad(
					comboBoxAccesibilidad.getItemAt(comboBoxAccesibilidad.getSelectedIndex()), pO.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textAreaObservaciones.getText().isBlank() && check) {
			check = cont.modificarPersonaObservaciones(textAreaObservaciones.getText(), pO.getNombre());
			if (!check) {
				infoError.append("Observaciones");
			}
		}

		if (!check) {
			infoError.append(" al intentar actualizar la persona en orientacion.");
			JOptionPane.showMessageDialog(null, infoError.toString()
					+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion de la persona en orientacion.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return check;
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
		if (e.getSource() == btnModificar) {
			if (errorChecks(2)) {
				JOptionPane.showMessageDialog(null,
						"Hay mas caracteres que el limite de caracteres en uno de los campos de texto con limite especificado.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else if (errorChecks(3)) {
				JOptionPane.showMessageDialog(null,
						"El formato de ultimo año trabajado es incorrecto. Introduce un año numerico y valido.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				if (!errorChecks(1)) {
					pO = cont.getPersona(pO.getNombre());
					loadPersona();
				} else {
					JOptionPane.showMessageDialog(null, "La persona en orientacion ha sido modificada correctamente."
							+ "\nLa informacion en el recuadro de infomacion de la persona en orientacion se actualizara para reflejar los cambios.");
					pO = cont.getPersona(pO.getNombre());
					loadPersona();
				}
			}
		}
	}
}
