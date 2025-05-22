package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaMostrarPersonaPracticas extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listNom, listApoyo, listFormacion, listCurso, listCentro, listFechas, listDuracion,
			listPracticas, listEmpApnabi;
	private JButton btnModificarPersona;
	private JTextArea textAreaInfo;

	public VentanaMostrarPersonaPracticas(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar personas en practicas");
		setBounds(100, 100, 1080, 410);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		
		listNom = new JList<>();
		listNom.setBackground(new Color(38, 201, 236));
		listNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNom.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listApoyo = new JList<>();
		listApoyo.setBackground(new Color(38, 201, 236));
		listApoyo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFormacion = new JList<>();
		listFormacion.setBackground(new Color(38, 201, 236));
		listFormacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCurso = new JList<>();
		listCurso.setBackground(new Color(38, 201, 236));
		listCurso.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCurso.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCentro = new JList<>();
		listCentro.setBackground(new Color(38, 201, 236));
		listCentro.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCentro.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFechas = new JList<>();
		listFechas.setBackground(new Color(38, 201, 236));
		listFechas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFechas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listDuracion = new JList<>();
		listDuracion.setBackground(new Color(38, 201, 236));
		listDuracion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDuracion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPracticas = new JList<>();
		listPracticas.setBackground(new Color(38, 201, 236));
		listPracticas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPracticas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEmpApnabi = new JList<String>();
		listEmpApnabi.setBackground(new Color(38, 201, 236));
		listEmpApnabi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		addPersonas();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 201, 236));
		panel.setBounds(10, 10, 1033, 267);
		panel.add(listNom);
		panel.add(listApoyo);
		panel.add(listFormacion);
		panel.add(listCurso);
		panel.add(listCentro);
		panel.add(listFechas);
		panel.add(listDuracion);
		panel.add(listPracticas);
		panel.add(listEmpApnabi);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 1033, 267);
		getContentPane().add(scrollPane);

		btnModificarPersona = new JButton("Modificar persona en practicas");
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(575, 287, 395, 72);
		getContentPane().add(btnModificarPersona);
		
		textAreaInfo = new JTextArea();
		textAreaInfo.setText("Selecciona un nombre, y despues pulsa el boton\npara modificar la persona en practicas.");
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaInfo.setEditable(false);
		textAreaInfo.setBackground(new Color(38, 201, 236));
		textAreaInfo.setBounds(84, 291, 481, 57);
		getContentPane().add(textAreaInfo);
		btnModificarPersona.addActionListener(this);
	}

	public void addPersonas() {
		Map<String, PersonaPracticas> personas = cont.mostrarPersonasPracticas();
		DefaultListModel<String> modelNom = new DefaultListModel<>();
		DefaultListModel<String> modelApoyo = new DefaultListModel<>();
		DefaultListModel<String> modelFormacion = new DefaultListModel<>();
		DefaultListModel<String> modelCurso = new DefaultListModel<>();
		DefaultListModel<String> modelCentro = new DefaultListModel<>();
		DefaultListModel<String> modelFechas = new DefaultListModel<>();
		DefaultListModel<String> modelDuracion = new DefaultListModel<>();
		DefaultListModel<String> modelPracticas = new DefaultListModel<>();
		DefaultListModel<String> modelEmpApnabi = new DefaultListModel<>();

		modelNom.addElement("Nombres");
		modelApoyo.addElement("Apoyo");
		modelFormacion.addElement("Formacion");
		modelCentro.addElement("Centro");
		modelFechas.addElement("Fechas");
		modelDuracion.addElement("Duracion");
		modelPracticas.addElement("Empresa Practicas");
		modelEmpApnabi.addElement("Empresa nuestra?");
		if (!personas.isEmpty()) {
			for (PersonaPracticas p : personas.values()) {
				switch (p.getFormacion()) {
				case AT:
					modelFormacion.addElement("AT");
					break;

				case BACHILLERATO:
					modelFormacion.addElement("Bachillerato");
					break;

				case DOCTORADO:
					modelFormacion.addElement("Doctorado");
					break;

				case EPA:
					modelFormacion.addElement("EPA");
					break;

				case ESO:
					modelFormacion.addElement("ESO");
					break;

				case FP_BASICA:
					modelFormacion.addElement("FP_Basica");
					break;

				case GM:
					modelFormacion.addElement("GM");
					break;

				case GS:
					modelFormacion.addElement("GS");
					break;

				case MASTER:
					modelFormacion.addElement("Master");
					break;

				case PRIMARIA:
					modelFormacion.addElement("Primaria");
					break;

				case UNIVERSIDAD:
					modelFormacion.addElement("Universidad");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (p.getCentro()) {
				case ADSIS_BILBAO_OLHIP:
					modelCentro.addElement("ADSIS BILBAO OLHIP");
					break;

				case CEINMARK:
					modelCentro.addElement("CEINMARK");
					break;

				case CENTROMIKELDI:
					modelCentro.addElement("Centro Mikeldi");
					break;

				case CENTROSANLUIS:
					modelCentro.addElement("Centro San Luis");
					break;

				case CIFP_AGRARIODERIO_DERIONEKAZARITZA_LHII:
					modelCentro.addElement("CIFP AGRARIO DERIO/DERIO NEKAZARITZA LHII");
					break;

				case CIFP_ANDRA_MARI_BHI:
					modelCentro.addElement("CIFP Andra Mari BHI");
					break;

				case CIFP_ARRATIAKOZULAIBAR_LANBIDEIKASTEGIA:
					modelCentro.addElement("CIFP Arratiako Zulaibar Lanbide Ikastegia");
					break;

				case CIFP_BIDEBIETA:
					modelCentro.addElement("CIFP Bidebieta");
					break;

				case CIFP_CALASANZ_LANBIDEIKASTEGIA:
					modelCentro.addElement("CIFP Calasanz Lanbide Ikastegia");
					break;

				case CIFP_CONSTRUCCIONBIZKAIA_LHII:
					modelCentro.addElement("CIFP CONSTRUCCIÓN BIZKAIA LHII");
					break;

				case CIFP_ELORRIETAERREKA_MARI_GBLHI:
					modelCentro.addElement("CIFP Elorrieta Erreka Mari GBLHI");
					break;

				case CIFP_EMILIOCAMPUZANO:
					modelCentro.addElement("CIFP Emilio Campuzano");
					break;

				case CIFP_ESCUELAHOSTELERIA_LHII:
					modelCentro.addElement("CIFP Escuela de Hostelería LHII");
					break;

				case CIFP_FADURA_GBLHI:
					modelCentro.addElement("CIFP Fadura GBLHI");
					break;

				case CIFP_HOSTELERIA_OSTALARITZA_LHII:
					modelCentro.addElement("CIFP HOSTELERÍA/OSTALARITZA LHII");
					break;

				case CIFP_HOSTELERIA_HOSTALARITZA_LHII:
					modelCentro.addElement("CIFP Hostelería/Hostalaritza LHII");
					break;

				case CIFP_IBAIONDO:
					modelCentro.addElement("CIFP Ibaiondo");
					break;

				case CIFP_IURRETA_GBLHI:
					modelCentro.addElement("CIFP Iurreta GBLHI");
					break;

				case CIFP_LEA_ARTIBAI:
					modelCentro.addElement("CIFP Lea-Artibai");
					break;

				case CIFP_NAUTICOBERMEO_BERMEOKONAUTIKA_LHII:
					modelCentro.addElement("CIFP NÁUTICO BERMEO/BERMEOKO NAUTIKA LHII");
					break;

				case CIFP_REPELEGA_GBLHI:
					modelCentro.addElement("CIFP Repelega GBLHI");
					break;

				case CIFP_SANJORGE_GBLHI:
					modelCentro.addElement("CIFP San Jorge GBLHI");
					break;

				case CIFP_TARTANGA_GBLHI:
					modelCentro.addElement("CIFP Tartanga GBLHI");
					break;

				case CIFP_TXURDINAGA_LHII:
					modelCentro.addElement("CIFP TXURDINAGA LHII");
					break;

				case CIFP_UNI_EIBARERMUA:
					modelCentro.addElement("CIFP Uni Eibar Ermua");
					break;

				case CIFP_ZORNOTZA_LHII:
					modelCentro.addElement("CIFP ZORNOTZA LHII");
					break;

				case CPEIPS_ANGELESCUSTODIOS_HLBHIP:
					modelCentro.addElement("CPEIPS ANGELES CUSTODIOS HLBHIP");
					break;

				case CPEIPS_MARISTAS_SANMIGUEL_HLBHIP:
					modelCentro.addElement("CPEIPS MARISTAS-SAN MIGUEL HLBHIP");
					break;

				case CPEIPS_NTRA_SRA_DE_LA_ANTIGUA_HLBHIP:
					modelCentro.addElement("CPEIPS NTRA. SRA. DE LA ANTIGUA HLBHIP");
					break;

				case CPES_ALMI_BHIP:
					modelCentro.addElement("CPES ALMI BHIP");
					break;

				case CPES_ARANGOYA_BHIP:
					modelCentro.addElement("CPES ARANGOYA BHIP");
					break;

				case CPES_ARCE_BHIP:
					modelCentro.addElement("CPES ARCE BHIP");
					break;

				case CPES_ARMENGOL_BHIP:
					modelCentro.addElement("CPES ARMENGOL BHIP");
					break;

				case CPES_BAGABILTZA_BHIP:
					modelCentro.addElement("CPES BAGABILTZA BHIP");
					break;

				case CPES_EIDE_BHIP:
					modelCentro.addElement("CPES EIDE BHIP");
					break;

				case CPES_ESPERANZA_ALHAMA_BHIP:
					modelCentro.addElement("CPES ESPERANZA ALHAMA BHIP");
					break;

				case CPES_IBAIZABAL_IKASTOLA_BHIP:
					modelCentro.addElement("CPES IBAIZABAL IKASTOLA BHIP");
					break;

				case CPES_IKASAUTO_BHIP:
					modelCentro.addElement("CPES IKASAUTO BHIP");
					break;

				case CPES_NTRA_SRA_DE_LA_ANTIGUA_BHIP:
					modelCentro.addElement("CPES NTRA. SRA. DE LA ANTIGUA BHIP");
					break;

				case CPES_ORUE_ESKOLA_BHIP:
					modelCentro.addElement("CPES ORUE ESKOLA BHIP");
					break;

				case CPES_XABIER_BHIP:
					modelCentro.addElement("CPES XABIER BHIP");
					break;

				case CPFPB_ADSISLEIOA_OLHIP:
					modelCentro.addElement("CPFPB ADSIS LEIOA OLHIP");
					break;

				case CPFPB_ADSIS_GETXO_OLHIP:
					modelCentro.addElement("CPFPB ADSIS GETXO OLHIP");
					break;

				case CPFPB_MEATZALDEA_OLHIP:
					modelCentro.addElement("CPFPB MEATZALDEA OLHIP");
					break;

				case CPFPB_PEÑASCALMARKINA_OLHIP:
					modelCentro.addElement("CPFPB PEÑASCAL MARKINA OLHIP");
					break;

				case CPIFP_BARAKALDO:
					modelCentro.addElement("CPIFP Barakaldo");
					break;

				case CPIFP_HARROBIA:
					modelCentro.addElement("CPIFP Harrobia");
					break;

				case CPIFP_HARROBIA_LHIPI:
					modelCentro.addElement("CPIFP HARROBIA LHIPI");
					break;

				case CPIFP_INNOVACIONSOCIALDIEGO_BERGUICES_OTXARKOAGA:
					modelCentro.addElement("CPIFP Innovación Social Diego Berguices-Otxarkoaga");
					break;

				case CPIFP_JESUITAKPOLITEKNIKOA:
					modelCentro.addElement("CPIFP Jesuitak Politeknikoa");
					break;

				case CPIFP_MARISTAKDURANGO:
					modelCentro.addElement("CPIFP Maristak Durango");
					break;

				case CPIFP_PEÑASCAL:
					modelCentro.addElement("CPIFP Peñascal");
					break;

				case CPIFP_SALESIANOSDEUSTO:
					modelCentro.addElement("CPIFP Salesianos Deusto");
					break;

				case CPIFP_SANVIATOR:
					modelCentro.addElement("CPIFP San Viator");
					break;

				case CPIFP_SOMORROSTRO_LHIPI:
					modelCentro.addElement("CPIFP SOMORROSTRO LHIPI");
					break;

				case CRUZROJA:
					modelCentro.addElement("CRUZ ROJA");
					break;

				case ESCUELASUPERIORHOSTELERIABILBAO:
					modelCentro.addElement("ESCUELA SUPERIOR DE HOSTELERÍA BILBAO");
					break;

				case ESCUELAUNIVERSITARIAMAGISTERIO_BAM_BEGOÑAKO_ANDRA_MARI:
					modelCentro.addElement("Escuela Universitaria de Magisterio BAM – Begoñako Andra Mari");
					break;

				case FERNANDO_BHIP:
					modelCentro.addElement("FERNANDO BHIP");
					break;

				case HERMANOSLARRINAGA_SL_BHIP:
					modelCentro.addElement("HERMANOS LARRINAGA S.L. BHIP");
					break;

				case IES_BALMASEDA_BHI:
					modelCentro.addElement("IES BALMASEDA BHI");
					break;

				case IES_BARRUTIALDE_BHI:
					modelCentro.addElement("IES BARRUTIALDE BHI");
					break;

				case IES_DOLORESIBARRURI_BHI:
					modelCentro.addElement("IES DOLORES IBARRURI BHI");
					break;

				case IES_ESKURTZE_BHI:
					modelCentro.addElement("IES ESKURTZE BHI");
					break;

				case IES_FRAYJUAN_DE_ZUMARRAGA_DURANGO_BHI:
					modelCentro.addElement("IES FRAY JUAN DE ZUMARRAGA-DURANGO BHI");
					break;

				case IES_GERNIKA_BHI:
					modelCentro.addElement("IES GERNIKA BHI");
					break;

				case IES_IBARREKOLANDA_BHI:
					modelCentro.addElement("IES IBARREKOLANDA BHI");
					break;

				case IES_JOSEMIGUELBARANDIARAN_BHI:
					modelCentro.addElement("IES JOSE MIGUEL BARANDIARAN BHI");
					break;

				case IES_JUAN_ANTONIO_ZUNZUNEGUI_BHI:
					modelCentro.addElement("IES JUAN ANTONIO ZUNZUNEGUI BHI");
					break;

				case IES_LEKEITIO_BHI:
					modelCentro.addElement("IES LEKEITIO BHI");
					break;

				case IES_MARTIN_DE_BERTENDONA_BHI:
					modelCentro.addElement("IES Martín de Bertendona BHI");
					break;

				case IES_MUNGIA_BHI:
					modelCentro.addElement("IES MUNGIA BHI");
					break;

				case IES_ONDARROA_BHI:
					modelCentro.addElement("IES ONDARROA BHI");
					break;

				case IES_SATURNINO_DE_LA_PEÑA_BHI:
					modelCentro.addElement("IES SATURNINO DE LA PEÑA BHI");
					break;

				case IMFPB_GERNIKA_LUMO_OLHUI:
					modelCentro.addElement("IMFPB GERNIKA-LUMO OLHUI");
					break;

				case IMFPB_BASAURI_OLHUI:
					modelCentro.addElement("IMFPB BASAURI OLHUI");
					break;

				case IMFPB_BERMEO_OLHUI:
					modelCentro.addElement("IMFPB BERMEO OLHUI");
					break;

				case IMFPB_BITURITXA_BARAKALDO_OLHUI:
					modelCentro.addElement("IMFPB BITURITXA-BARAKALDO OLHUI");
					break;

				case IMFPB_DURANGO_OLHUI:
					modelCentro.addElement("IMFPB DURANGO OLHUI");
					break;

				case IMFPB_ERANDIO_OLHUI:
					modelCentro.addElement("IMFPB ERANDIO OLHUI");
					break;

				case IMFPB_ERMUA_MALLABIA_OLHUI:
					modelCentro.addElement("IMFPB ERMUA-MALLABIA OLHUI");
					break;

				case IMFPB_MUNGIA_OLHUI:
					modelCentro.addElement("IMFPB MUNGIA OLHUI");
					break;

				case IMFPB_PORTUGALETE_OLHUI:
					modelCentro.addElement("IMFPB PORTUGALETE OLHUI");
					break;

				case IMFPB_SANTURTZI_OLHUI:
					modelCentro.addElement("IMFPB SANTURTZI OLHUI");
					break;

				case IMFPB_SESTAO_OLHUI:
					modelCentro.addElement("IMFPB SESTAO OLHUI");
					break;

				case MARGOTU_OLHIP:
					modelCentro.addElement("MARGOTU OLHIP");
					break;

				case MARIA_INMACULADA_BHIP:
					modelCentro.addElement("MARIA INMACULADA BHIP");
					break;

				case PASTELERIA_COMERCIOBIZKAIA_OLHIP:
					modelCentro.addElement("PASTELERÍA Y COMERCIO BIZKAIA OLHIP");
					break;

				case SOPEÑABILBAO:
					modelCentro.addElement("Sopeña Bilbao");
					break;

				case STA_MARIA_DE_ARTAGAN_BHIP:
					modelCentro.addElement("STA. MARIA DE ARTAGAN BHIP");
					break;

				case TXORIERRIPOLITEKNIKOA:
					modelCentro.addElement("Txorierri Politeknikoa");
					break;

				case UNED_UNIVERSIDADNACIONALESPAÑOLA_A_DISTANCIA:
					modelCentro.addElement("UNED (Universidad Nacional Española a Distancia)");
					break;

				case UNIVERSIDAD_DEUSTO:
					modelCentro.addElement("Universidad de Deusto");
					break;

				case UPV_EHU:
					modelCentro.addElement("UPV/EHU");
					break;

				case ZABALBURUIKASTETXEA_S_COOP:
					modelCentro.addElement("Zabalburu Ikastetxea S. Coop");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				modelNom.addElement(p.getNombre());
				modelApoyo.addElement(p.getApoyo());
				modelCurso.addElement("" + p.getCurso());
				modelFechas.addElement(p.getFechas());
				modelDuracion.addElement(p.getDuracion());
				modelPracticas.addElement(p.getEmpresaPracticas());
				if (p.isEmpresaNuestra()) {
					modelEmpApnabi.addElement("Si");
				} else {
					modelEmpApnabi.addElement("No");
				}
			}

			listNom.setModel(modelNom);
			listApoyo.setModel(modelApoyo);
			listFormacion.setModel(modelFormacion);
			listCurso.setModel(modelCurso);
			listCentro.setModel(modelCentro);
			listFechas.setModel(modelFechas);
			listDuracion.setModel(modelDuracion);
			listPracticas.setModel(modelPracticas);
			listEmpApnabi.setModel(modelEmpApnabi);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona en orientacion para visualizar."
							+ "\nPor favor, añada una persona en practicas anter de abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarPersona) {
			if (!listNom.isSelectionEmpty()) {
				if (!listNom.getSelectedValue().equals("Nombres")) {
					VentanaModificarPersonaPracticas dialog = new VentanaModificarPersonaPracticas(this, cont,
							cont.getPersonaPracticas(listNom.getSelectedValue()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "[ERROR] No se puede modificar el titulo de la columna.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elije un nombre de la lista de nombres.");
			}
		}
	}
}
