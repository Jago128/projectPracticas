package windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.time.format.DateTimeParseException;

import javax.swing.*;

import controller.LoginController;
import model.PersonaInclusion;

public class VentanaModificarPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private PersonaInclusion pI;
	private JTextField textFieldCV, textFieldIdioma, textFieldUltimoAñoTrabajado;
	private JComboBox<String> comboBoxFormacion, comboBoxSectorInteres, comboBoxMunicipio, comboBoxAccesibilidad,
			comboBoxPersonaFacilitadora;
	private JTextArea textAreaOtros, textAreaInteresesPersonales, textAreaSituacionActual, textAreaEspecialidad,
			textAreaPersona;
	private JSpinner spinnerEdad;
	private JButton btnModificar;

	public VentanaModificarPersonaInclusion(JDialog parent, LoginController cont, PersonaInclusion pI) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.pI = pI;

		setResizable(false);
		setTitle("Modificar persona en inclusion");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 770);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaModificarPersonaInclusion.class.getResource("/img/apnabilan.png")));
		logo.setBounds(10, 10, 325, 78);
		getContentPane().add(logo);

		textAreaPersona = new JTextArea();
		textAreaPersona.setText("");
		textAreaPersona.setLineWrap(true);
		textAreaPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaPersona.setEditable(false);
		textAreaPersona.setBackground(Color.WHITE);
		textAreaPersona.setBounds(390, 37, 506, 293);
		getContentPane().add(textAreaPersona);

		JLabel lblDatosPersona = new JLabel("Informacion de la persona en inclusion seleccionada:");
		lblDatosPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPersona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosPersona.setBounds(390, 11, 506, 28);
		getContentPane().add(lblDatosPersona);

		JLabel lblEdad = new JLabel("Edad:");
		lblEdad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEdad.setBounds(54, 107, 103, 28);
		getContentPane().add(lblEdad);

		SpinnerModel sm = new SpinnerNumberModel(16, 0, null, 1);
		spinnerEdad = new JSpinner(sm);
		spinnerEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		spinnerEdad.setBounds(167, 106, 179, 31);
		getContentPane().add(spinnerEdad);
		JLabel lblMunicipio = new JLabel("Municipio:");
		lblMunicipio.setHorizontalAlignment(SwingConstants.CENTER);
		lblMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMunicipio.setBounds(54, 147, 103, 31);
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
		comboBoxMunicipio.setBounds(165, 153, 181, 21);
		getContentPane().add(comboBoxMunicipio);

		JLabel lblFormacion = new JLabel("Formacion:");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(54, 188, 108, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(172, 193, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad: (Describa la especialidad)");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(102, 529, 244, 28);
		getContentPane().add(lblEspecialidad);

		textAreaEspecialidad = new JTextArea();
		textAreaEspecialidad.setLineWrap(true);
		textAreaEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaEspecialidad.setBounds(10, 567, 424, 107);
		getContentPane().add(textAreaEspecialidad);

		JLabel lblOtros = new JLabel("Otros titulos, certificados, carnets:");
		lblOtros.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtros.setBounds(528, 528, 352, 31);
		getContentPane().add(lblOtros);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres para los cuatro)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(356, 528, 217, 31);
		getContentPane().add(lblMaxChars);

		textAreaOtros = new JTextArea();
		textAreaOtros.setLineWrap(true);
		textAreaOtros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaOtros.setBounds(450, 564, 446, 110);
		getContentPane().add(textAreaOtros);

		JLabel lblIdioma = new JLabel("Idiomas:");
		lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdioma.setBounds(54, 226, 108, 31);
		getContentPane().add(lblIdioma);

		textFieldIdioma = new JTextField();
		textFieldIdioma.setColumns(10);
		textFieldIdioma.setBounds(176, 233, 163, 19);
		getContentPane().add(textFieldIdioma);

		JLabel lblUltimoAñoTrabajado = new JLabel("Ultimo año trabajado:");
		lblUltimoAñoTrabajado.setHorizontalAlignment(SwingConstants.CENTER);
		lblUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUltimoAñoTrabajado.setBounds(44, 267, 143, 31);
		getContentPane().add(lblUltimoAñoTrabajado);

		textFieldUltimoAñoTrabajado = new JTextField();
		textFieldUltimoAñoTrabajado.setColumns(10);
		textFieldUltimoAñoTrabajado.setBounds(183, 274, 163, 19);
		getContentPane().add(textFieldUltimoAñoTrabajado);

		JLabel lblSectorInteres = new JLabel("Sector de interes:");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(54, 308, 129, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(193, 313, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		JLabel lbl_InteresesPersonales = new JLabel("Intereses personales:");
		lbl_InteresesPersonales.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_InteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_InteresesPersonales.setBounds(102, 367, 163, 31);
		getContentPane().add(lbl_InteresesPersonales);

		textAreaInteresesPersonales = new JTextArea();
		textAreaInteresesPersonales.setLineWrap(true);
		textAreaInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInteresesPersonales.setBounds(10, 408, 424, 110);
		getContentPane().add(textAreaInteresesPersonales);

		JLabel lblSituacionActual = new JLabel("Situacion actual:");
		lblSituacionActual.setHorizontalAlignment(SwingConstants.CENTER);
		lblSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSituacionActual.setBounds(594, 367, 152, 31);
		getContentPane().add(lblSituacionActual);

		textAreaSituacionActual = new JTextArea();
		textAreaSituacionActual.setLineWrap(true);
		textAreaSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaSituacionActual.setBounds(445, 408, 451, 110);
		getContentPane().add(textAreaSituacionActual);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad:");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(218, 340, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(345, 346, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblCV = new JLabel("CV:");
		lblCV.setHorizontalAlignment(SwingConstants.CENTER);
		lblCV.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCV.setBounds(505, 340, 51, 28);
		getContentPane().add(lblCV);

		textFieldCV = new JTextField();
		textFieldCV.setColumns(10);
		textFieldCV.setBounds(553, 349, 322, 19);
		getContentPane().add(textFieldCV);

		JLabel lblPersonaFacilitadora = new JLabel("Persona facilitadora:");
		lblPersonaFacilitadora.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaFacilitadora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaFacilitadora.setBounds(262, 370, 137, 28);
		getContentPane().add(lblPersonaFacilitadora);

		comboBoxPersonaFacilitadora = new JComboBox<>();
		comboBoxPersonaFacilitadora.setEditable(true);
		comboBoxPersonaFacilitadora.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxPersonaFacilitadora.setSelectedIndex(0);
		comboBoxPersonaFacilitadora.setBounds(409, 375, 179, 21);
		getContentPane().add(comboBoxPersonaFacilitadora);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaEspecialidad);
		scrollPane_1.setBounds(10, 567, 424, 107);
		getContentPane().add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane(textAreaOtros);
		scrollPane_2.setBounds(450, 564, 446, 110);
		getContentPane().add(scrollPane_2);

		JScrollPane scrollPane_3 = new JScrollPane(textAreaInteresesPersonales);
		scrollPane_3.setBounds(10, 408, 424, 110);
		getContentPane().add(scrollPane_3);

		JScrollPane scrollPane_4 = new JScrollPane(textAreaSituacionActual);
		scrollPane_4.setBounds(445, 408, 451, 110);
		getContentPane().add(scrollPane_4);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(363, 684, 175, 43);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void loadPersona() {
		StringBuilder infoPersona = new StringBuilder("");
		String formacion = "", sectorInteres = "", municipio = "", accesibilidad = "";

		switch (pI.getFormacion()) {
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

		switch (pI.getSectorInteres()) {
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
			System.out.println("Tipo incorrecto");
		}

		switch (pI.getMunicipio()) {
		case ABADIÑO:
			municipio = "Abadiño";
			break;

		case ABANTO_ZIERBENA:
			municipio = "Abanto-Zierbena";
			break;

		case AJANGIZ:
			municipio = "Ajangiz";
			break;

		case ALONSOTEGI:
			municipio = "Alonsotegi";
			break;

		case AMOREBIETA:
			municipio = "Amorebieta";
			break;

		case AMOROTO:
			municipio = "Amoroto";
			break;

		case AMURRIO:
			municipio = "Amurrio";
			break;

		case ARAKALDO:
			municipio = "Arakaldo";
			break;

		case ARANTZAZU:
			municipio = "Arantzazu";
			break;

		case AREATZA_BILARO:
			municipio = "Areatza o Bilaro";
			break;

		case ARRANKUDIAGA:
			municipio = "Arrankudiaga";
			break;

		case ARRATZU:
			municipio = "Arratzu";
			break;

		case ARRIETA:
			municipio = "Arrieta";
			break;

		case ARRIGORRIAGA:
			municipio = "Arrigorriaga";
			break;

		case ARTZENTALES:
			municipio = "Artzentales";
			break;

		case ARTZINIEGA:
			municipio = "Artziniega";
			break;

		case AULESTI:
			municipio = "Aulesti";
			break;

		case AXPEATXONDO:
			municipio = "Axpe Atxondo";
			break;

		case AYALA_AIARA:
			municipio = "Ayala/Aiara";
			break;

		case BAKIO:
			municipio = "Bakio";
			break;

		case BALMASEDA:
			municipio = "Balmaseda";
			break;

		case BARAKALDO:
			municipio = "Barakaldo";
			break;

		case BARRIKA:
			municipio = "Barrika";
			break;

		case BASAURI:
			municipio = "Basauri";
			break;

		case BEDIA:
			municipio = "Bedia";
			break;

		case BERANGO:
			municipio = "Berango";
			break;

		case BERMEO:
			municipio = "Bermeo";
			break;

		case BERRIATUA:
			municipio = "Berriatua";
			break;

		case BERRIZ:
			municipio = "Berriz";
			break;

		case BILBAO:
			municipio = "Bilbao";
			break;

		case BUSTURIA:
			municipio = "Busturia";
			break;

		case CASTROURDIALES:
			municipio = "Castro Urdiales";
			break;

		case DERIO:
			municipio = "Derio";
			break;

		case DIMA:
			municipio = "Dima";
			break;

		case DURANGO:
			municipio = "Durango";
			break;

		case EA:
			municipio = "Ea";
			break;

		case ELANTXOBE:
			municipio = "Elantxobe";
			break;

		case ELORRIO:
			municipio = "Elorrio";
			break;

		case ERANDIO:
			municipio = "Erandio";
			break;

		case EREÑO:
			municipio = "Ereño";
			break;

		case ERMUA:
			municipio = "Ermua";
			break;

		case ERRIGOITI:
			municipio = "Errigoiti";
			break;

		case ETXEBARRI:
			municipio = "Etxebarri";
			break;

		case ETXEBARRIA:
			municipio = "Etxebarria";
			break;

		case FORUA:
			municipio = "Forua";
			break;

		case FRUIZ:
			municipio = "Fruiz";
			break;

		case GALDAKAO:
			municipio = "Galdakao";
			break;

		case GALDAMES:
			municipio = "Galdames";
			break;

		case GAMIZFIKA:
			municipio = "Gamiz-Fika";
			break;

		case GARAI:
			municipio = "Garai";
			break;

		case GATIKA:
			municipio = "Gatika";
			break;

		case GAUTEGIZ:
			municipio = "Gautegiz";
			break;

		case GAZTELUELEXABEITIA_ARTEAGA:
			municipio = "Gaztelu-Elexabeitia o Arteaga";
			break;

		case GERNIKALUMO:
			municipio = "Gernika-Lumo";
			break;

		case GETXO:
			municipio = "Getxo";
			break;

		case GIZABURUAGA:
			municipio = "Gizaburuaga";
			break;

		case GORDEXOLA:
			municipio = "Gordexola";
			break;

		case GORLIZ:
			municipio = "Gorliz";
			break;

		case GUEÑES:
			municipio = "Gueñes";
			break;

		case IBARRANGELU:
			municipio = "Ibarrangelu";
			break;

		case IGORRE:
			municipio = "Igorre";
			break;

		case ISPASTER:
			municipio = "Ispaster";
			break;

		case IURRETA:
			municipio = "Iurreta";
			break;

		case IZURTZA:
			municipio = "Izurtza";
			break;

		case KARRANTZAHARANA:
			municipio = "Karrantza Harana";
			break;

		case KORTEZUBI:
			municipio = "Kortezubi";
			break;

		case LANESTOSA:
			municipio = "Lanestosa";
			break;

		case LARRABETZU:
			municipio = "Larrabetzu";
			break;

		case LAUDIO_LLODIO:
			municipio = "Laudio/Llodio";
			break;

		case LAUKIZ:
			municipio = "Laukiz";
			break;

		case LEIOA:
			municipio = "Leioa";
			break;

		case LEKEITIO:
			municipio = "Lekeitio";
			break;

		case LEMOA:
			municipio = "Lemoa";
			break;

		case LEMOIZ:
			municipio = "Lemoiz";
			break;

		case LEZAMA:
			municipio = "Lezama";
			break;

		case LOIU:
			municipio = "Loiu";
			break;

		case MALLABIA:
			municipio = "Mallabia";
			break;

		case MARKINAXEMEIN:
			municipio = "Markina-Xemein";
			break;

		case MARURI:
			municipio = "Maruri";
			break;

		case MAÑARIA:
			municipio = "Mañaria";
			break;

		case MENDATA:
			municipio = "Mendata";
			break;

		case MENDEXA:
			municipio = "Mendexa";
			break;

		case MEÑAKA:
			municipio = "Meñaka";
			break;

		case MORGA:
			municipio = "Morga";
			break;

		case MUNDAKA:
			municipio = "Mundaka";
			break;

		case MUNGIA:
			municipio = "Mungia";
			break;

		case MUNITIBARARBATZEGI_GERRIKAITZ:
			municipio = "Munitibar-Arbatzegi Gerrikaitz";
			break;

		case MURUETA:
			municipio = "Murueta";
			break;

		case MUSKIZ:
			municipio = "Muskiz";
			break;

		case MUXIKA:
			municipio = "Muxika";
			break;

		case NABARNIZ:
			municipio = "Nabarniz";
			break;

		case ONDARROA:
			municipio = "Ondarroa";
			break;

		case ORDUÑA:
			municipio = "Orduña";
			break;

		case OROZKO:
			municipio = "Orozko";
			break;

		case ORTUELLA:
			municipio = "Ortuella";
			break;

		case OTXANDIO:
			municipio = "Otxandio";
			break;

		case PLENTZIA:
			municipio = "Plentzia";
			break;

		case PORTUGALETE:
			municipio = "Portugalete";
			break;

		case SANTURTZI:
			municipio = "Santurtzi";
			break;

		case SESTAO:
			municipio = "Sestao";
			break;

		case SONDIKA:
			municipio = "Sondika";
			break;

		case SOPELA:
			municipio = "Sopela";
			break;

		case SOPUERTA:
			municipio = "Sopuerta";
			break;

		case SUKARRIETA:
			municipio = "Sukarrieta";
			break;

		case TRAPAGARAN:
			municipio = "Trapagaran";
			break;

		case TURTZIOZ:
			municipio = "Turtzioz";
			break;

		case UBIDE:
			municipio = "Ubide";
			break;

		case UGAOMIRABALLES:
			municipio = "Ugao-Miraballes";
			break;

		case URDULIZ:
			municipio = "Urduliz";
			break;

		case URDUÑA:
			municipio = "Urduña";
			break;

		case USANSOLO:
			municipio = "Usansolo";
			break;

		case ZALDIBAR:
			municipio = "Zaldibar";
			break;

		case ZALLA:
			municipio = "Zalla";
			break;

		case ZAMUDIO:
			municipio = "Zamudio";
			break;

		case ZARATAMO:
			municipio = "Zaratamo";
			break;

		case ZEANURI:
			municipio = "Zeanuri";
			break;

		case ZEBERIO:
			municipio = "Zeberio";
			break;

		case ZIERBENA:
			municipio = "Zierbena";
			break;

		case ZIORTZA_BOLIBAR:
			municipio = "Ziortza-Bolibar";
			break;

		case ZORNOTZA:
			municipio = "Zornotza";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		switch (pI.getAccesibilidad()) {
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
		infoPersona.append("Nombre:" + pI.getNombre());
		infoPersona.append("Apellido:" + pI.getApellido());
		infoPersona.append("Edad:" + pI.getEdad());
		infoPersona.append("Municipio:" + municipio);
		infoPersona.append("Formacion:" + formacion);
		infoPersona.append("Especialidad:" + pI.getEspecialidad());
		infoPersona.append("Otros titulos, certificados, carnets:" + pI.getOtros());
		infoPersona.append("Idioma:" + pI.getIdioma());
		infoPersona.append("Ultimo año trabajando:" + pI.getUltimoAñoTrabajado());
		infoPersona.append("Sector interes:" + sectorInteres);
		infoPersona.append("Intereses personales:" + pI.getInteresesPersonales());
		infoPersona.append("Situacion actual:" + pI.getSituacionActual());
		infoPersona.append("Accesibilidad:" + accesibilidad);
		infoPersona.append("CV:" + pI.getCv());
		infoPersona.append("Persona facilitadora:" + pI.getPersonaFacilitadora());
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

		if ((Integer) spinnerEdad.getValue() != 0) {
			check = cont.modificarEdad((Integer) spinnerEdad.getValue(), pI.getNombre());
			if (!check) {
				infoError.append("Edad");
			}
		}

		if (!comboBoxMunicipio.getSelectedItem().equals("---") && check) {
			check = cont.modificarMunicipio(comboBoxMunicipio.getItemAt(comboBoxMunicipio.getSelectedIndex()),
					pI.getNombre());
			if (!check) {
				infoError.append("Municipio");
			}
		}

		if (!comboBoxFormacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarFormacionPI(comboBoxFormacion.getItemAt(comboBoxFormacion.getSelectedIndex()),
					pI.getNombre());
			if (!check) {
				infoError.append("Formacion");
			}
		}

		if (!textAreaEspecialidad.getText().isBlank() && check) {
			check = cont.modificarEspecialidadPI(textAreaEspecialidad.getText(), pI.getNombre());
			if (!check) {
				infoError.append("Especialidad");
			}
		}

		if (!textAreaOtros.getText().isBlank() && check) {
			check = cont.modificarOtros(textAreaOtros.getText(), pI.getNombre());
			if (!check) {
				infoError.append("Otros titulos, certificados, carnets");
			}
		}

		if (!textFieldIdioma.getText().isBlank() && check) {
			check = cont.modificarIdioma(textFieldIdioma.getText(), pI.getNombre());
			if (!check) {
				infoError.append("Idiomas");
			}
		}

		if (!textFieldUltimoAñoTrabajado.getText().isBlank() && check) {
			check = cont.modificarUltimoAñoTrabajadorPI(Integer.parseInt(textFieldUltimoAñoTrabajado.getText()),
					pI.getNombre());
			if (!check) {
				infoError.append("Ultimo año trabajado");
			}
		}

		if (!comboBoxSectorInteres.getSelectedItem().equals("---") && check) {
			check = cont.modificarSectorInteresPI(
					comboBoxSectorInteres.getItemAt(comboBoxSectorInteres.getSelectedIndex()), pI.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textAreaInteresesPersonales.getText().isBlank() && check) {
			check = cont.modificarInteresesPersonalesPI(textAreaInteresesPersonales.getText(), pI.getNombre());
			if (!check) {
				infoError.append("Intereses personales");
			}
		}

		if (!textAreaSituacionActual.getText().isBlank() && check) {
			check = cont.modificarSituacionActualPI(textAreaSituacionActual.getText(), pI.getNombre());
			if (!check) {
				infoError.append("Situacion actual");
			}
		}

		if (!comboBoxAccesibilidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarAccesibilidadPI(
					comboBoxAccesibilidad.getItemAt(comboBoxAccesibilidad.getSelectedIndex()), pI.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textFieldCV.getText().isBlank() && check) {
			check = cont.modificarCV(textFieldCV.getText(), pI.getNombre());
			if (!check) {
				infoError.append("CV");
			}
		}

		if (!comboBoxPersonaFacilitadora.getEditor().getItem().equals("---") && check) {
			check = cont.modificarPersonaFacilitadora((String) comboBoxAccesibilidad.getEditor().getItem(),
					pI.getNombre());
			if (!check) {
				infoError.append("Persona facilitadora");
			}
		}

		if (!check) {
			infoError.append(" al intentar actualizar la persona en inclusion.");
			JOptionPane.showMessageDialog(null, infoError.toString()
					+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion de la persona en inclusion.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return check;
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
			if (!textFieldUltimoAñoTrabajado.getText().isEmpty()) {
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
					pI = cont.getPersonaInclusion(pI.getNombre());
					loadPersona();
				} else {
					JOptionPane.showMessageDialog(null, "La persona en inclusion ha sido modificada correctamente."
							+ "\nLa informacion en el recuadro de infomacion de la persona en inclusion se acualizara para reflejar los cambios.");
					pI = cont.getPersonaInclusion(pI.getNombre());
					loadPersona();
				}
			}
		}
	}
}