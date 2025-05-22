package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import model.PersonaPracticas;

public class VentanaAñadirPersonaPracticas extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldPracticas, textFieldDuracion, textFieldNom, textFieldFecha;
	private JComboBox<String> comboBoxFormacion, comboBoxCurso, comboBoxCentroFormativo, comboBoxApoyo;

	private JButton btnAñadir;
	private JCheckBox chckbxEmpresaApnabi;

	public VentanaAñadirPersonaPracticas(JDialog parent, LoginController cont) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir personas en practicas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 290);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(199, 10, 241, 24);
		getContentPane().add(lblObligatorio);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAñadirPersonaPracticas.class.getResource("/img/apnabilan.png")));
		logo.setBounds(443, 0, 325, 78);
		getContentPane().add(logo);

		JLabel lblNom = new JLabel("Nombre: *");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(16, 39, 103, 28);
		getContentPane().add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(129, 45, 183, 19);
		getContentPane().add(textFieldNom);

		JLabel lblCentroFormativo = new JLabel("Centro Formativo: *");
		lblCentroFormativo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCentroFormativo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCentroFormativo.setBounds(46, 166, 118, 31);
		getContentPane().add(lblCentroFormativo);

		comboBoxCentroFormativo = new JComboBox<>();
		comboBoxCentroFormativo.setModel(new DefaultComboBoxModel<>(new String[] { "---", "CPIFP Jesuitak Politeknikoa",
				"CPIFP Salesianos Deusto", "CPIFP Peñascal", "CIFP Lea-Artibai",
				"CIFP Arratiako Zulaibar Lanbide Ikastegia", "CIFP Uni Eibar Ermua", "CIFP Elorrieta Erreka Mari GBLHI",
				"CPIFP Harrobia", "CPIFP Maristak Durango", "Zabalburu Ikastetxea S. Coop",
				"CIFP Construcción Bizkaia LHII", "CPIFP Barakaldo", "CIFP Tartanga GBLHI",
				"CIFP Hostelería/Hostalaritza LHII", "CIFP Andra Mari BHI", "CIFP Fadura GBLHI", "CIFP Iurreta GBLHI",
				"CIFP Escuela de Hostelería LHII", "CIFP Repelega GBLHI", "CIFP San Jorge GBLHI",
				"CIFP Calasanz Lanbide Ikastegia", "CPIFP Innovación Social Diego Berguices-Otxarkoaga",
				"CPIFP San Viator", "UPV/EHU", "Universidad de Deusto",
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
				"PASTELERÍA Y COMERCIO BIZKAIA OLHIP", "MARGOTU OLHIP", "CPIFP HARROBIA LHIPI",
				"CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII", "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI",
				"IMFPB DURANGO OLHUI", "CPES IBAIZABAL IKASTOLA BHIP", "IMFPB ERANDIO OLHUI",
				"CIFP HOSTELERÍA/OSTALARITZA LHII", "IES GERNIKA BHI", "IMFPB GERNIKA-LUMO OLHUI",
				"CPFPB ADSIS GETXO OLHIP", "IES JOSE MIGUEL BARANDIARAN BHI", "CPFPB ADSIS LEIOA OLHIP",
				"IES LEKEITIO BHI", "CPES ESPERANZA ALHAMA BHIP", "IMFPB ERMUA-MALLABIA OLHUI",
				"CPFPB PEÑASCAL MARKINA OLHIP", "IES MUNGIA BHI", "IMFPB MUNGIA OLHUI", "CPIFP SOMORROSTRO LHIPI",
				"IES ONDARROA BHI", "CPES NTRA. SRA. DE LA ANTIGUA BHIP", "CPFPB MEATZALDEA OLHIP",
				"IES JUAN ANTONIO ZUNZUNEGUI BHI", "IMFPB PORTUGALETE OLHUI", "CPES XABIER BHIP",
				"IMFPB SANTURTZI OLHUI", "CPES EIDE BHIP", "IES SATURNINO DE LA PEÑA BHI", "IMFPB SESTAO OLHUI",
				"CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP", "CPEIPS MARISTAS-SAN MIGUEL HLBHIP",
				"IES Martín de Bertendona BHI" }));
		comboBoxCentroFormativo.setSelectedIndex(0);
		comboBoxCentroFormativo.setBounds(174, 172, 181, 21);
		getContentPane().add(comboBoxCentroFormativo);

		JLabel lblFormacion = new JLabel("Formacion: *");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(300, 74, 108, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(418, 79, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblDuracion = new JLabel("Duracion: *");
		lblDuracion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDuracion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuracion.setBounds(366, 166, 87, 31);
		getContentPane().add(lblDuracion);

		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(452, 173, 163, 19);
		getContentPane().add(textFieldDuracion);

		JLabel lblFechas = new JLabel("Fechas: *");
		lblFechas.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechas.setBounds(321, 112, 75, 31);
		getContentPane().add(lblFechas);

		textFieldFecha = new JTextField();
		textFieldFecha.setColumns(10);
		textFieldFecha.setBounds(406, 119, 163, 19);
		getContentPane().add(textFieldFecha);

		JLabel lblCurso = new JLabel("Curso: *");
		lblCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCurso.setBounds(36, 119, 87, 28);
		getContentPane().add(lblCurso);

		comboBoxCurso = new JComboBox<>();
		comboBoxCurso.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2" }));
		comboBoxCurso.setSelectedIndex(0);
		comboBoxCurso.setBounds(131, 124, 163, 21);
		getContentPane().add(comboBoxCurso);

		JLabel lblPracticas = new JLabel("Empresa practicas: *");
		lblPracticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblPracticas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPracticas.setBounds(46, 207, 123, 28);
		getContentPane().add(lblPracticas);

		textFieldPracticas = new JTextField();
		textFieldPracticas.setColumns(10);
		textFieldPracticas.setBounds(179, 213, 172, 19);
		getContentPane().add(textFieldPracticas);

		JLabel lblApoyo = new JLabel("Apoyo: *");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(26, 77, 103, 28);
		getContentPane().add(lblApoyo);

		comboBoxApoyo = new JComboBox<String>();
		comboBoxApoyo.setEditable(true);
		comboBoxApoyo.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxApoyo.setSelectedIndex(0);
		comboBoxApoyo.setBounds(127, 82, 163, 21);
		getContentPane().add(comboBoxApoyo);

		chckbxEmpresaApnabi = new JCheckBox("Es empresa nuestra?");
		chckbxEmpresaApnabi.setBackground(new Color(38, 201, 236));
		chckbxEmpresaApnabi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxEmpresaApnabi.setBounds(605, 90, 163, 33);
		getContentPane().add(chckbxEmpresaApnabi);

		btnAñadir = new JButton("Añadir persona en practicas");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(396, 207, 339, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	public void addError() { // ErrorID: 1
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la persona en practicas.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldNom.getText().isBlank() || comboBoxApoyo.getEditor().getItem().equals("---")
					|| comboBoxFormacion.getSelectedItem().equals("---")
					|| comboBoxCentroFormativo.getSelectedItem().equals("---") || textFieldFecha.getText().isBlank()
					|| textFieldDuracion.getText().isBlank() || textFieldPracticas.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarPersonaPracticas(textFieldNom.getText())) {
				JOptionPane.showMessageDialog(null,
						"Ya existe una persona en practicas con el mismo nombre en la base de datos.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				int result = 0;
				Formacion formacion = null;
				CentrosFormativos centro = null;
				boolean empresaApnabi;

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

				switch ((String) comboBoxCentroFormativo.getSelectedItem()) {
				case "CPIFP Jesuitak Politeknikoa":
					centro = CentrosFormativos.CPIFP_JESUITAKPOLITEKNIKOA;
					break;

				case "CPIFP Salesianos Deusto":
					centro = CentrosFormativos.CPIFP_SALESIANOSDEUSTO;
					break;

				case "CPIFP Peñascal":
					centro = CentrosFormativos.CPIFP_PEÑASCAL;
					break;

				case "CIFP Lea-Artibai":
					centro = CentrosFormativos.CIFP_LEA_ARTIBAI;
					break;

				case "CIFP Arratiako Zulaibar Lanbide Ikastegia":
					centro = CentrosFormativos.CIFP_ARRATIAKOZULAIBAR_LANBIDEIKASTEGIA;
					break;

				case "CIFP Uni Eibar Ermua":
					centro = CentrosFormativos.CIFP_UNI_EIBARERMUA;
					break;

				case "CIFP Elorrieta Erreka Mari GBLHI":
					centro = CentrosFormativos.CIFP_ELORRIETAERREKA_MARI_GBLHI;
					break;

				case "CPIFP Harrobia":
					centro = CentrosFormativos.CPIFP_HARROBIA;
					break;

				case "CPIFP Maristak Durango":
					centro = CentrosFormativos.CPIFP_MARISTAKDURANGO;
					break;

				case "Zabalburu Ikastetxea S. Coop":
					centro = CentrosFormativos.ZABALBURUIKASTETXEA_S_COOP;
					break;

				case "CIFP Construcción Bizkaia LHII":
					centro = CentrosFormativos.CIFP_CONSTRUCCIONBIZKAIA_LHII;
					break;

				case "CPIFP Barakaldo":
					centro = CentrosFormativos.CPIFP_BARAKALDO;
					break;

				case "CIFP Tartanga GBLHI":
					centro = CentrosFormativos.CIFP_TARTANGA_GBLHI;
					break;

				case "CIFP Hostelería/Hostalaritza LHII":
					centro = CentrosFormativos.CIFP_HOSTELERIA_HOSTALARITZA_LHII;
					break;

				case "CIFP Andra Mari BHI":
					centro = CentrosFormativos.CIFP_ANDRA_MARI_BHI;
					break;

				case "CIFP Fadura GBLHI":
					centro = CentrosFormativos.CIFP_FADURA_GBLHI;
					break;

				case "CIFP Iurreta GBLHI":
					centro = CentrosFormativos.CIFP_IURRETA_GBLHI;
					break;

				case "CIFP Escuela de Hostelería LHII":
					centro = CentrosFormativos.CIFP_ESCUELAHOSTELERIA_LHII;
					break;

				case "CIFP Repelega GBLHI":
					centro = CentrosFormativos.CIFP_REPELEGA_GBLHI;
					break;

				case "CIFP San Jorge GBLHI":
					centro = CentrosFormativos.CIFP_SANJORGE_GBLHI;
					break;

				case "CIFP Calasanz Lanbide Ikastegia":
					centro = CentrosFormativos.CIFP_CALASANZ_LANBIDEIKASTEGIA;
					break;

				case "CPIFP Innovación Social Diego Berguices-Otxarkoaga":
					centro = CentrosFormativos.CPIFP_INNOVACIONSOCIALDIEGO_BERGUICES_OTXARKOAGA;
					break;

				case "CPIFP San Viator":
					centro = CentrosFormativos.CPIFP_SANVIATOR;
					break;

				case "UPV/EHU":
					centro = CentrosFormativos.UPV_EHU;
					break;

				case "Universidad de Deusto":
					centro = CentrosFormativos.UNIVERSIDAD_DEUSTO;
					break;

				case "Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari":
					centro = CentrosFormativos.ESCUELAUNIVERSITARIAMAGISTERIO_BAM_BEGOÑAKO_ANDRA_MARI;
					break;

				case "UNED (Universidad Nacional Española a Distancia)":
					centro = CentrosFormativos.UNED_UNIVERSIDADNACIONALESPAÑOLA_A_DISTANCIA;
					break;

				case "CIFP Emilio Campuzano":
					centro = CentrosFormativos.CIFP_EMILIOCAMPUZANO;
					break;

				case "Centro San Luis":
					centro = CentrosFormativos.CENTROSANLUIS;
					break;

				case "Centro Mikeldi":
					centro = CentrosFormativos.CENTROMIKELDI;
					break;

				case "Txorierri Politeknikoa":
					centro = CentrosFormativos.TXORIERRIPOLITEKNIKOA;
					break;

				case "Sopeña Bilbao":
					centro = CentrosFormativos.SOPEÑABILBAO;
					break;

				case "CIFP Bidebieta":
					centro = CentrosFormativos.CIFP_BIDEBIETA;
					break;

				case "CIFP Ibaiondo":
					centro = CentrosFormativos.CIFP_IBAIONDO;
					break;

				case "IES DOLORES IBARRURI BHI":
					centro = CentrosFormativos.IES_DOLORESIBARRURI_BHI;
					break;

				case "CIFP ZORNOTZA LHII":
					centro = CentrosFormativos.CIFP_ZORNOTZA_LHII;
					break;

				case "CPES ORUE ESKOLA BHIP":
					centro = CentrosFormativos.CPES_ORUE_ESKOLA_BHIP;
					break;

				case "IES BARRUTIALDE BHI":
					centro = CentrosFormativos.IES_BARRUTIALDE_BHI;
					break;

				case "IES BALMASEDA BHI":
					centro = CentrosFormativos.IES_BALMASEDA_BHI;
					break;

				case "CPES BAGABILTZA BHIP":
					centro = CentrosFormativos.CPES_BAGABILTZA_BHIP;
					break;

				case "IMFPB BITURITXA-BARAKALDO OLHUI":
					centro = CentrosFormativos.IMFPB_BITURITXA_BARAKALDO_OLHUI;
					break;

				case "CPES IKASAUTO BHIP":
					centro = CentrosFormativos.CPES_IKASAUTO_BHIP;
					break;

				case "IMFPB BASAURI OLHUI":
					centro = CentrosFormativos.IMFPB_BASAURI_OLHUI;
					break;

				case "CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII":
					centro = CentrosFormativos.CIFP_NAUTICOBERMEO_BERMEOKONAUTIKA_LHII;
					break;

				case "IMFPB BERMEO OLHUI":
					centro = CentrosFormativos.IMFPB_BERMEO_OLHUI;
					break;

				case "CIFP TXURDINAGA LHII":
					centro = CentrosFormativos.CIFP_TXURDINAGA_LHII;
					break;

				case "IES ESKURTZE BHI":
					centro = CentrosFormativos.IES_ESKURTZE_BHI;
					break;

				case "IES IBARREKOLANDA BHI":
					centro = CentrosFormativos.IES_IBARREKOLANDA_BHI;
					break;

				case "CPEIPS ANGELES CUSTODIOS HLBHIP":
					centro = CentrosFormativos.CPEIPS_ANGELESCUSTODIOS_HLBHIP;
					break;

				case "CPES ALMI BHIP":
					centro = CentrosFormativos.CPES_ALMI_BHIP;
					break;

				case "CPES ARANGOYA BHIP":
					centro = CentrosFormativos.CPES_ARANGOYA_BHIP;
					break;

				case "CPES ARCE BHIP":
					centro = CentrosFormativos.CPES_ARCE_BHIP;
					break;

				case "CPES ARMENGOL BHIP":
					centro = CentrosFormativos.CPES_ARMENGOL_BHIP;
					break;

				case "CEINMARK":
					centro = CentrosFormativos.CEINMARK;
					break;

				case "CRUZ ROJA":
					centro = CentrosFormativos.CRUZROJA;
					break;

				case "ESCUELA SUPERIOR DE HOSTELERÍA BILBAO":
					centro = CentrosFormativos.ESCUELASUPERIORHOSTELERIABILBAO;
					break;

				case "FERNANDO BHIP":
					centro = CentrosFormativos.FERNANDO_BHIP;
					break;

				case "HERMANOS LARRINAGA S.L. BHIP":
					centro = CentrosFormativos.HERMANOSLARRINAGA_SL_BHIP;
					break;

				case "MARIA INMACULADA BHIP":
					centro = CentrosFormativos.MARIA_INMACULADA_BHIP;
					break;

				case "STA. MARIA DE ARTAGAN BHIP":
					centro = CentrosFormativos.STA_MARIA_DE_ARTAGAN_BHIP;
					break;

				case "ADSIS BILBAO OLHIP":
					centro = CentrosFormativos.ADSIS_BILBAO_OLHIP;
					break;

				case "PASTELERÍA Y COMERCIO BIZKAIA OLHIP":
					centro = CentrosFormativos.PASTELERIA_COMERCIOBIZKAIA_OLHIP;
					break;

				case "MARGOTU OLHIP":
					centro = CentrosFormativos.MARGOTU_OLHIP;
					break;

				case "CPIFP HARROBIA LHIPI":
					centro = CentrosFormativos.CPIFP_HARROBIA_LHIPI;
					break;

				case "CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII":
					centro = CentrosFormativos.CIFP_AGRARIODERIO_DERIONEKAZARITZA_LHII;
					break;

				case "IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI":
					centro = CentrosFormativos.IES_FRAYJUAN_DE_ZUMARRAGA_DURANGO_BHI;
					break;

				case "IMFPB DURANGO OLHUI":
					centro = CentrosFormativos.IMFPB_DURANGO_OLHUI;
					break;

				case "CPES IBAIZABAL IKASTOLA BHIP":
					centro = CentrosFormativos.CPES_IBAIZABAL_IKASTOLA_BHIP;
					break;

				case "IMFPB ERANDIO OLHUI":
					centro = CentrosFormativos.IMFPB_ERANDIO_OLHUI;
					break;

				case "CIFP HOSTELERÍA/OSTALARITZA LHII":
					centro = CentrosFormativos.CIFP_HOSTELERIA_OSTALARITZA_LHII;
					break;

				case "IES GERNIKA BHI":
					centro = CentrosFormativos.IES_GERNIKA_BHI;
					break;

				case "IMFPB GERNIKA-LUMO OLHUI":
					centro = CentrosFormativos.IMFPB_GERNIKA_LUMO_OLHUI;
					break;

				case "CPFPB ADSIS GETXO OLHIP":
					centro = CentrosFormativos.CPFPB_ADSIS_GETXO_OLHIP;
					break;

				case "IES JOSE MIGUEL BARANDIARAN BHI":
					centro = CentrosFormativos.IES_JOSEMIGUELBARANDIARAN_BHI;
					break;

				case "CPFPB ADSIS LEIOA OLHIP":
					centro = CentrosFormativos.CPFPB_ADSISLEIOA_OLHIP;
					break;

				case "IES LEKEITIO BHI":
					centro = CentrosFormativos.IES_LEKEITIO_BHI;
					break;

				case "CPES ESPERANZA ALHAMA BHIP":
					centro = CentrosFormativos.CPES_ESPERANZA_ALHAMA_BHIP;
					break;

				case "IMFPB ERMUA-MALLABIA OLHUI":
					centro = CentrosFormativos.IMFPB_ERMUA_MALLABIA_OLHUI;
					break;

				case "CPFPB PEÑASCAL MARKINA OLHIP":
					centro = CentrosFormativos.CPFPB_PEÑASCALMARKINA_OLHIP;
					break;

				case "IES MUNGIA BHI":
					centro = CentrosFormativos.IES_MUNGIA_BHI;
					break;

				case "IMFPB MUNGIA OLHUI":
					centro = CentrosFormativos.IMFPB_MUNGIA_OLHUI;
					break;

				case "CPIFP SOMORROSTRO LHIPI":
					centro = CentrosFormativos.CPIFP_SOMORROSTRO_LHIPI;
					break;

				case "IES ONDARROA BHI":
					centro = CentrosFormativos.IES_ONDARROA_BHI;
					break;

				case "CPES NTRA. SRA. DE LA ANTIGUA BHIP":
					centro = CentrosFormativos.CPES_NTRA_SRA_DE_LA_ANTIGUA_BHIP;
					break;

				case "CPFPB MEATZALDEA OLHIP":
					centro = CentrosFormativos.CPFPB_MEATZALDEA_OLHIP;
					break;

				case "IES JUAN ANTONIO ZUNZUNEGUI BHI":
					centro = CentrosFormativos.IES_JUAN_ANTONIO_ZUNZUNEGUI_BHI;
					break;

				case "IMFPB PORTUGALETE OLHUI":
					centro = CentrosFormativos.IMFPB_PORTUGALETE_OLHUI;
					break;

				case "CPES XABIER BHIP":
					centro = CentrosFormativos.CPES_XABIER_BHIP;
					break;

				case "IMFPB SANTURTZI OLHUI":
					centro = CentrosFormativos.IMFPB_SANTURTZI_OLHUI;
					break;

				case "CPES EIDE BHIP":
					centro = CentrosFormativos.CPES_EIDE_BHIP;
					break;

				case "IES SATURNINO DE LA PEÑA BHI":
					centro = CentrosFormativos.IES_SATURNINO_DE_LA_PEÑA_BHI;
					break;

				case "IMFPB SESTAO OLHUI":
					centro = CentrosFormativos.IMFPB_SESTAO_OLHUI;
					break;

				case "CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP":
					centro = CentrosFormativos.CPEIPS_NTRA_SRA_DE_LA_ANTIGUA_HLBHIP;
					break;

				case "CPEIPS MARISTAS-SAN MIGUEL HLBHIP":
					centro = CentrosFormativos.CPEIPS_MARISTAS_SANMIGUEL_HLBHIP;
					break;

				case "IES Martín de Bertendona BHI":
					centro = CentrosFormativos.IES_MARTIN_DE_BERTENDONA_BHI;
					break;
				}

				if (chckbxEmpresaApnabi.isSelected()) {
					empresaApnabi = true;
				} else {
					empresaApnabi = false;
				}

				if (cont.añadirPersonaPracticas(
						new PersonaPracticas(textFieldNom.getText(), (String) comboBoxApoyo.getEditor().getItem(),
								formacion, Integer.parseInt((String)comboBoxCurso.getSelectedItem()), centro, textFieldFecha.getText(),
								textFieldDuracion.getText(), textFieldPracticas.getText(), empresaApnabi))) {
					result = JOptionPane.showConfirmDialog(null,
							"La persona en practicas ha sido añadida correctamente. Quiere añadir mas personas en practicas?",
							"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.NO_OPTION) {
						this.dispose();
					} else if (result == JOptionPane.YES_OPTION) {
						textFieldDuracion.setText("");
						textFieldFecha.setText("");
						textFieldNom.setText("");
						textFieldPracticas.setText("");
						comboBoxApoyo.setSelectedIndex(0);
						comboBoxCentroFormativo.setSelectedIndex(0);
						comboBoxCurso.setSelectedIndex(0);
						comboBoxFormacion.setSelectedIndex(0);
						chckbxEmpresaApnabi.setSelected(false);
					}
				} else {
					addError();
				}
			}
		}
	}
}
