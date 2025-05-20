package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.PersonaPracticas;

public class VentanaModificarPersonaPracticas extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private PersonaPracticas persona;
	private JButton btnModificar;
	private JTextField textFieldPracticas, textFieldDuracion, textFieldFecha;
	private JComboBox<String> comboBoxFormacion, comboBoxCurso, comboBoxCentroFormativo, comboBoxApoyo;
	private JTextArea textAreaPersona;
	private JCheckBox chckbxEmpresaApnabi;
	private JLabel logo;

	public VentanaModificarPersonaPracticas(JDialog parent, LoginController cont, PersonaPracticas persona) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.persona = persona;

		setResizable(false);
		setTitle("Modificar persona en practicas");
		setBounds(100, 100, 870, 480);
		getContentPane().setLayout(null);

		textAreaPersona = new JTextArea();
		textAreaPersona.setText("");
		textAreaPersona.setLineWrap(true);
		textAreaPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaPersona.setEditable(false);
		textAreaPersona.setBackground(Color.WHITE);
		textAreaPersona.setBounds(337, 49, 495, 324);
		getContentPane().add(textAreaPersona);

		JLabel lblDatosPersona = new JLabel("Informacion de la persona en practicas seleccionada:");
		lblDatosPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPersona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosPersona.setBounds(337, 10, 479, 28);
		getContentPane().add(lblDatosPersona);

		loadPersona();

		JLabel lblApoyo = new JLabel("Apoyo:");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(28, 107, 68, 28);
		getContentPane().add(lblApoyo);

		comboBoxApoyo = new JComboBox<String>();
		comboBoxApoyo.setEditable(true);
		comboBoxApoyo.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxApoyo.setSelectedIndex(0);
		comboBoxApoyo.setBounds(129, 112, 163, 21);
		getContentPane().add(comboBoxApoyo);

		JLabel lblCentroFormativo = new JLabel("Centro Formativo:");
		lblCentroFormativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroFormativo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCentroFormativo.setBounds(1, 211, 118, 31);
		getContentPane().add(lblCentroFormativo);

		comboBoxCentroFormativo = new JComboBox<>();
		comboBoxCentroFormativo.setModel(new DefaultComboBoxModel<>(new String[] { "---",
				"CpersonaFP Jesuitak Politeknikoa", "CpersonaFP Salesianos Deusto", "CpersonaFP Peñascal",
				"CIFP Lea-Artibai", "CIFP Arratiako Zulaibar Lanbide Ikastegia", "CIFP Uni Eibar Ermua",
				"CIFP Elorrieta Erreka Mari GBLHI", "CpersonaFP Harrobia", "CpersonaFP Maristak Durango",
				"Zabalburu Ikastetxea S. Coop", "CIFP Construcción Bizkaia LHII", "CpersonaFP Barakaldo",
				"CIFP Tartanga GBLHI", "CIFP Hostelería/Hostalaritza LHII", "CIFP Andra Mari BHI", "CIFP Fadura GBLHI",
				"CIFP Iurreta GBLHI", "CIFP Escuela de Hostelería LHII", "CIFP Repelega GBLHI", "CIFP San Jorge GBLHI",
				"CIFP Calasanz Lanbide Ikastegia", "CpersonaFP Innovación Social Diego Berguices-Otxarkoaga",
				"CpersonaFP San Viator", "UPV/EHU", "Universidad de Deusto",
				"Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari",
				"UNED (Universidad Nacional Española a Distancia)", "CIFP Emilio Campuzano", "Centro San Luis",
				"Centro Mikeldi", "Txorierri Politeknikoa", "Sopeña Bilbao", "CIFP Bidebieta", "CIFP Ibaiondo",
				"IES DOLORES IBARRURI BHI", "CIFP ZORNOTZA LHII", "CPES ORUE ESKOLA BHIP", "IES BARRUTIALDE BHI",
				"CIFP CONSTRUCCIÓN BIZKAIA LHII", "IES BALMASEDA BHI", "CPES BAGABILTZA BHIP",
				"IMFPB BITURITXA-BARAKALDO OLHUI", "CPES IKASAUTO BHIP", "IMFPB BASAURI OLHUI",
				"CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII", "IMFPB BERMEO OLHUI", "CIFP TXURDINAGA LHII",
				"IES ESKURTZE BHI", "IES IBARREKOLANDA BHI", "CPEIPS ANGELES CUSTODIOS HLBHIP", "CPES ALMI BHIP",
				"CPES ARANGOYA BHIP", "CPES ARCE BHIP", "CPES ARMENGOL BHIP", "CEINMARK", "CRUZ ROJA",
				"ESCUELA SUPERIOR DE HOSTELERÍA BILBAO", "FERNANDO BHIP", "HERMANOS LARRINAGA S.L. BHIP",
				"MARIA INMACULADA BHIP", "STA. MARIA DE ARTAGAN BHIP", "ADSIS BILBAO OLHIP",
				"PASTELERÍA Y COMERCIO BIZKAIA OLHIP", "MARGOTU OLHIP", "CpersonaFP HARROBIA LHIpersona",
				"CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII", "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI",
				"IMFPB DURANGO OLHUI", "CPES IBAIZABAL IKASTOLA BHIP", "IMFPB ERANDIO OLHUI",
				"CIFP HOSTELERÍA/OSTALARITZA LHII", "IES GERNIKA BHI", "IMFPB GERNIKA-LUMO OLHUI",
				"CPFPB ADSIS GETXO OLHIP", "IES JOSE MIGUEL BARANDIARAN BHI", "CPFPB ADSIS LEIOA OLHIP",
				"IES LEKEITIO BHI", "CPES ESPERANZA ALHAMA BHIP", "IMFPB ERMUA-MALLABIA OLHUI",
				"CPFPB PEÑASCAL MARKINA OLHIP", "IES MUNGIA BHI", "IMFPB MUNGIA OLHUI",
				"CpersonaFP SOMORROSTRO LHIpersona", "IES ONDARROA BHI", "CPES NTRA. SRA. DE LA ANTIGUA BHIP",
				"CPFPB MEATZALDEA OLHIP", "IES JUAN ANTONIO ZUNZUNEGUI BHI", "IMFPB PORTUGALETE OLHUI",
				"CPES XABIER BHIP", "IMFPB SANTURTZI OLHUI", "CPES EIDE BHIP", "IES SATURNINO DE LA PEÑA BHI",
				"IMFPB SESTAO OLHUI", "CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP", "CPEIPS MARISTAS-SAN MIGUEL HLBHIP",
				"IES Martín de Bertendona BHI" }));
		comboBoxCentroFormativo.setSelectedIndex(0);
		comboBoxCentroFormativo.setBounds(120, 217, 196, 21);
		getContentPane().add(comboBoxCentroFormativo);

		JLabel lblFormacion = new JLabel("Formacion:");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(17, 143, 87, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(129, 148, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblDuracion = new JLabel("Duracion:");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuracion.setBounds(43, 295, 73, 31);
		getContentPane().add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(129, 302, 163, 19);
		getContentPane().add(textFieldDuracion);

		JLabel lblFechas = new JLabel("Fechas:");
		lblFechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechas.setBounds(44, 254, 68, 31);
		getContentPane().add(lblFechas);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(129, 261, 163, 19);
		getContentPane().add(textFieldFecha);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(36, 181, 60, 28);
		getContentPane().add(lblCurso);

		comboBoxCurso = new JComboBox<>();
		comboBoxCurso.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2" }));
		comboBoxCurso.setSelectedIndex(0);
		comboBoxCurso.setBounds(129, 178, 163, 21);
		getContentPane().add(comboBoxCurso);

		JLabel lblPracticas = new JLabel("Empresa practicas:");
		lblPracticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPracticas.setBounds(7, 329, 118, 28);
		getContentPane().add(lblPracticas);

		textFieldPracticas = new JTextField();
		textFieldPracticas.setColumns(10);
		textFieldPracticas.setBounds(129, 335, 172, 19);
		getContentPane().add(textFieldPracticas);

		JLabel lblExtraInfo = new JLabel("Si no quieres cambiar esta opcion, no hace falta tocarlo.");
		lblExtraInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblExtraInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblExtraInfo.setBounds(1, 363, 319, 28);
		getContentPane().add(lblExtraInfo);

		chckbxEmpresaApnabi = new JCheckBox("Es empresa nuestra?");
		chckbxEmpresaApnabi.setBackground(new Color(38, 201, 236));
		chckbxEmpresaApnabi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxEmpresaApnabi.setBounds(73, 383, 163, 33);
		getContentPane().add(chckbxEmpresaApnabi);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(337, 383, 495, 43);
		getContentPane().add(btnModificar);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaModificarPersonaPracticas.class.getResource("/img/apnabilan.png")));
		logo.setBounds(10, 25, 325, 78);
		getContentPane().add(logo);
		btnModificar.addActionListener(this);
	}

	public void loadPersona() {
		StringBuilder infoPersona = new StringBuilder("");
		String formacion = "", centro = "";

		switch (persona.getFormacion()) {
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

		switch (persona.getCentro()) {
		case ADSIS_BILBAO_OLHIP:
			centro = "ADSIS BILBAO OLHIP";
			break;

		case CEINMARK:
			centro = "CEINMARK";
			break;

		case CENTROMIKELDI:
			centro = "Centro Mikeldi";
			break;

		case CENTROSANLUIS:
			centro = "Centro San Luis";
			break;

		case CIFP_AGRARIODERIO_DERIONEKAZARITZA_LHII:
			centro = "CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII";
			break;

		case CIFP_ANDRA_MARI_BHI:
			centro = "CIFP Andra Mari BHI";
			break;

		case CIFP_ARRATIAKOZULAIBAR_LANBIDEIKASTEGIA:
			centro = "CIFP Arratiako Zulaibar Lanbide Ikastegia";
			break;

		case CIFP_BIDEBIETA:
			centro = "CIFP Bidebieta";
			break;

		case CIFP_CALASANZ_LANBIDEIKASTEGIA:
			centro = "CIFP Calasanz Lanbide Ikastegia";
			break;

		case CIFP_CONSTRUCCIONBIZKAIA_LHII:
			centro = "CIFP CONSTRUCCIÓN BIZKAIA LHII";
			break;

		case CIFP_ELORRIETAERREKA_MARI_GBLHI:
			centro = "CIFP Elorrieta Erreka Mari GBLHI";
			break;

		case CIFP_EMILIOCAMPUZANO:
			centro = "CIFP Emilio Campuzano";
			break;

		case CIFP_ESCUELAHOSTELERIA_LHII:
			centro = "CIFP Escuela de Hostelería LHII";
			break;

		case CIFP_FADURA_GBLHI:
			centro = "CIFP Fadura GBLHI";
			break;

		case CIFP_HOSTELERIA_OSTALARITZA_LHII:
			centro = "CIFP HOSTELERÍA/OSTALARITZA LHII";
			break;

		case CIFP_HOSTELERIA_HOSTALARITZA_LHII:
			centro = "CIFP Hostelería/Hostalaritza LHII";
			break;

		case CIFP_IBAIONDO:
			centro = "CIFP Ibaiondo";
			break;

		case CIFP_IURRETA_GBLHI:
			centro = "CIFP Iurreta GBLHI";
			break;

		case CIFP_LEA_ARTIBAI:
			centro = "CIFP Lea-Artibai";
			break;

		case CIFP_NAUTICOBERMEO_BERMEOKONAUTIKA_LHII:
			centro = "CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII";
			break;

		case CIFP_REPELEGA_GBLHI:
			centro = "CIFP Repelega GBLHI";
			break;

		case CIFP_SANJORGE_GBLHI:
			centro = "CIFP San Jorge GBLHI";
			break;

		case CIFP_TARTANGA_GBLHI:
			centro = "CIFP Tartanga GBLHI";
			break;

		case CIFP_TXURDINAGA_LHII:
			centro = "CIFP TXURDINAGA LHII";
			break;

		case CIFP_UNI_EIBARERMUA:
			centro = "CIFP Uni Eibar Ermua";
			break;

		case CIFP_ZORNOTZA_LHII:
			centro = "CIFP ZORNOTZA LHII";
			break;

		case CPEIPS_ANGELESCUSTODIOS_HLBHIP:
			centro = "CPEIPS ANGELES CUSTODIOS HLBHIP";
			break;

		case CPEIPS_MARISTAS_SANMIGUEL_HLBHIP:
			centro = "CPEIPS MARISTAS-SAN MIGUEL HLBHIP";
			break;

		case CPEIPS_NTRA_SRA_DE_LA_ANTIGUA_HLBHIP:
			centro = "CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP";
			break;

		case CPES_ALMI_BHIP:
			centro = "CPES ALMI BHIP";
			break;

		case CPES_ARANGOYA_BHIP:
			centro = "CPES ARANGOYA BHIP";
			break;

		case CPES_ARCE_BHIP:
			centro = "CPES ARCE BHIP";
			break;

		case CPES_ARMENGOL_BHIP:
			centro = "CPES ARMENGOL BHIP";
			break;

		case CPES_BAGABILTZA_BHIP:
			centro = "CPES BAGABILTZA BHIP";
			break;

		case CPES_EIDE_BHIP:
			centro = "CPES EIDE BHIP";
			break;

		case CPES_ESPERANZA_ALHAMA_BHIP:
			centro = "CPES ESPERANZA ALHAMA BHIP";
			break;

		case CPES_IBAIZABAL_IKASTOLA_BHIP:
			centro = "CPES IBAIZABAL IKASTOLA BHIP";
			break;

		case CPES_IKASAUTO_BHIP:
			centro = "CPES IKASAUTO BHIP";
			break;

		case CPES_NTRA_SRA_DE_LA_ANTIGUA_BHIP:
			centro = "CPES NTRA. SRA. DE LA ANTIGUA BHIP";
			break;

		case CPES_ORUE_ESKOLA_BHIP:
			centro = "CPES ORUE ESKOLA BHIP";
			break;

		case CPES_XABIER_BHIP:
			centro = "CPES XABIER BHIP";
			break;

		case CPFPB_ADSISLEIOA_OLHIP:
			centro = "CPFPB ADSIS LEIOA OLHIP";
			break;

		case CPFPB_ADSIS_GETXO_OLHIP:
			centro = "CPFPB ADSIS GETXO OLHIP";
			break;

		case CPFPB_MEATZALDEA_OLHIP:
			centro = "CPFPB MEATZALDEA OLHIP";
			break;

		case CPFPB_PEÑASCALMARKINA_OLHIP:
			centro = "CPFPB PEÑASCAL MARKINA OLHIP";
			break;

		case CPIFP_BARAKALDO:
			centro = "CPIFP Barakaldo";
			break;

		case CPIFP_HARROBIA:
			centro = "CPIFP Harrobia";
			break;

		case CPIFP_HARROBIA_LHIPI:
			centro = "CPIFP HARROBIA LHIPI";
			break;

		case CPIFP_INNOVACIONSOCIALDIEGO_BERGUICES_OTXARKOAGA:
			centro = "CPIFP Innovación Social Diego Berguices-Otxarkoaga";
			break;

		case CPIFP_JESUITAKPOLITEKNIKOA:
			centro = "CPIFP Jesuitak Politeknikoa";
			break;

		case CPIFP_MARISTAKDURANGO:
			centro = "CPIFP Maristak Durango";
			break;

		case CPIFP_PEÑASCAL:
			centro = "CPIFP Peñascal";
			break;

		case CPIFP_SALESIANOSDEUSTO:
			centro = "CPIFP Salesianos Deusto";
			break;

		case CPIFP_SANVIATOR:
			centro = "CPIFP San Viator";
			break;

		case CPIFP_SOMORROSTRO_LHIPI:
			centro = "CPIFP SOMORROSTRO LHIPI";
			break;

		case CRUZROJA:
			centro = "CRUZ ROJA";
			break;

		case ESCUELASUPERIORHOSTELERIABILBAO:
			centro = "ESCUELA SUPERIOR DE HOSTELERÍA BILBAO";
			break;

		case ESCUELAUNIVERSITARIAMAGISTERIO_BAM_BEGOÑAKO_ANDRA_MARI:
			centro = "Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari";
			break;

		case FERNANDO_BHIP:
			centro = "FERNANDO BHIP";
			break;

		case HERMANOSLARRINAGA_SL_BHIP:
			centro = "HERMANOS LARRINAGA S.L. BHIP";
			break;

		case IES_BALMASEDA_BHI:
			centro = "IES BALMASEDA BHI";
			break;

		case IES_BARRUTIALDE_BHI:
			centro = "IES BARRUTIALDE BHI";
			break;

		case IES_DOLORESIBARRURI_BHI:
			centro = "IES DOLORES IBARRURI BHI";
			break;

		case IES_ESKURTZE_BHI:
			centro = "IES ESKURTZE BHI";
			break;

		case IES_FRAYJUAN_DE_ZUMARRAGA_DURANGO_BHI:
			centro = "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI";
			break;

		case IES_GERNIKA_BHI:
			centro = "IES GERNIKA BHI";
			break;

		case IES_IBARREKOLANDA_BHI:
			centro = "IES IBARREKOLANDA BHI";
			break;

		case IES_JOSEMIGUELBARANDIARAN_BHI:
			centro = "IES JOSE MIGUEL BARANDIARAN BHI";
			break;

		case IES_JUAN_ANTONIO_ZUNZUNEGUI_BHI:
			centro = "IES JUAN ANTONIO ZUNZUNEGUI BHI";
			break;

		case IES_LEKEITIO_BHI:
			centro = "IES LEKEITIO BHI";
			break;

		case IES_MARTIN_DE_BERTENDONA_BHI:
			centro = "IES Martín de Bertendona BHI";
			break;

		case IES_MUNGIA_BHI:
			centro = "IES MUNGIA BHI";
			break;

		case IES_ONDARROA_BHI:
			centro = "IES ONDARROA BHI";
			break;

		case IES_SATURNINO_DE_LA_PEÑA_BHI:
			centro = "IES SATURNINO DE LA PEÑA BHI";
			break;

		case IMFPB_GERNIKA_LUMO_OLHUI:
			centro = "IMFPB GERNIKA-LUMO OLHUI";
			break;

		case IMFPB_BASAURI_OLHUI:
			centro = "IMFPB BASAURI OLHUI";
			break;

		case IMFPB_BERMEO_OLHUI:
			centro = "IMFPB BERMEO OLHUI";
			break;

		case IMFPB_BITURITXA_BARAKALDO_OLHUI:
			centro = "IMFPB BITURITXA-BARAKALDO OLHUI";
			break;

		case IMFPB_DURANGO_OLHUI:
			centro = "IMFPB DURANGO OLHUI";
			break;

		case IMFPB_ERANDIO_OLHUI:
			centro = "IMFPB ERANDIO OLHUI";
			break;

		case IMFPB_ERMUA_MALLABIA_OLHUI:
			centro = "IMFPB ERMUA-MALLABIA OLHUI";
			break;

		case IMFPB_MUNGIA_OLHUI:
			centro = "IMFPB MUNGIA OLHUI";
			break;

		case IMFPB_PORTUGALETE_OLHUI:
			centro = "IMFPB PORTUGALETE OLHUI";
			break;

		case IMFPB_SANTURTZI_OLHUI:
			centro = "IMFPB SANTURTZI OLHUI";
			break;

		case IMFPB_SESTAO_OLHUI:
			centro = "IMFPB SESTAO OLHUI";
			break;

		case MARGOTU_OLHIP:
			centro = "MARGOTU OLHIP";
			break;

		case MARIA_INMACULADA_BHIP:
			centro = "MARIA INMACULADA BHIP";
			break;

		case PASTELERIA_COMERCIOBIZKAIA_OLHIP:
			centro = "PASTELERÍA Y COMERCIO BIZKAIA OLHIP";
			break;

		case SOPEÑABILBAO:
			centro = "Sopeña Bilbao";
			break;

		case STA_MARIA_DE_ARTAGAN_BHIP:
			centro = "STA. MARIA DE ARTAGAN BHIP";
			break;

		case TXORIERRIPOLITEKNIKOA:
			centro = "Txorierri Politeknikoa";
			break;

		case UNED_UNIVERSIDADNACIONALESPAÑOLA_A_DISTANCIA:
			centro = "UNED (Universidad Nacional Española a Distancia";
			break;

		case UNIVERSIDAD_DEUSTO:
			centro = "Universidad de Deusto";
			break;

		case UPV_EHU:
			centro = "UPV/EHU";
			break;

		case ZABALBURUIKASTETXEA_S_COOP:
			centro = "Zabalburu Ikastetxea S. Coop";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		infoPersona.append("Nombre" + persona.getNombre());
		infoPersona.append("Apoyo" + persona.getApoyo());
		infoPersona.append("Formacion" + formacion);
		infoPersona.append("Centro" + centro);
		infoPersona.append("Fechas" + persona.getFechas());
		infoPersona.append("Duracion" + persona.getDuracion());
		infoPersona.append("Empresa Practicas" + persona.getEmpresaPracticas());
		if (persona.isEmpresaNuestra()) {
			infoPersona.append("Empresa nuestra? Si");
			chckbxEmpresaApnabi.setSelected(true);
		} else {
			infoPersona.append("Empresa nuestra? No");
			chckbxEmpresaApnabi.setSelected(false);
		}
		textAreaPersona.setText(infoPersona.toString());
	}

	public boolean addError() {
		boolean check = false;
		StringBuilder infoError = new StringBuilder("Un error ha occurrido en ");

		if (!comboBoxApoyo.getSelectedItem().equals("---")) {
			check = cont.modificarApoyoPracticas(comboBoxApoyo.getItemAt(comboBoxApoyo.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Apoyo");
			}
		}

		if (!comboBoxFormacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarFormacionPracticas(comboBoxFormacion.getItemAt(comboBoxFormacion.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Formacion");
			}
		}

		if (!comboBoxCurso.getSelectedItem().equals("---") && check) {
			check = cont.modificarCurso(Integer.parseInt(comboBoxCurso.getItemAt(comboBoxCurso.getSelectedIndex())),
					persona.getNombre());
			if (!check) {
				infoError.append("Curso");
			}
		}

		if (!comboBoxFormacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarCentro(comboBoxCentroFormativo.getItemAt(comboBoxCentroFormativo.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Centro");
			}
		}

		if (!textFieldFecha.getText().isBlank() && check) {
			check = cont.modificarDuracion(textFieldFecha.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Fecha");
			}
		}

		if (!textFieldDuracion.getText().isBlank() && check) {
			check = cont.modificarDuracion(textFieldDuracion.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Duracion");
			}
		}

		if (!textFieldPracticas.getText().isBlank() && check) {
			check = cont.modificarEmpPracticas(textFieldPracticas.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Empresa practicas");
			}
		}

		if (persona.isEmpresaNuestra() != chckbxEmpresaApnabi.isSelected() && check) {
			check = cont.modificarEmpApnabi(chckbxEmpresaApnabi.isSelected(), persona.getNombre());
			if (!check) {
				infoError.append("Empresa nuestra");
			}
		}

		if (!check) {
			infoError.append(" al intentar actualizar la persona en practicas.");
			JOptionPane.showMessageDialog(null, infoError.toString()
					+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion de la persona en practicas.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return check;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			if (!addError()) {
				persona = cont.getPersonaPracticas(persona.getNombre());
				loadPersona();
			} else {
				JOptionPane.showMessageDialog(null, "La persona en practicas ha sido modificada correctamente."
						+ "\nLa informacion en el recuadro de infomacion de la persona en practicas se acualizara para reflejar los cambios.");
				persona = cont.getPersonaPracticas(persona.getNombre());
				loadPersona();
			}
		}
	}
}
