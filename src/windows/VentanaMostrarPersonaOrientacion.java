package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaMostrarPersonaOrientacion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listNom, listApoyo, listFormacion, listEspecialidad, listSectorInteres, listCVLink,
			listCertifDiscapacidad, listEuskera, listIngles, listOtrosIdiomas, listLocalidad, listObservaciones,
			listAccesibilidad, listInteresesPersonales, listSituacionActual, listUltimoAñoTrabajado;
	private JButton btnModificarPersona;

	public VentanaMostrarPersonaOrientacion(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar personas en orientacion y seguimiento");
		setBounds(100, 100, 1080, 410);
		getContentPane().setLayout(null);

		listNom = new JList<>();
		listNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNom.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listApoyo = new JList<>();
		listApoyo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFormacion = new JList<>();
		listFormacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEspecialidad = new JList<>();
		listEspecialidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSectorInteres = new JList<>();
		listSectorInteres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCVLink = new JList<>();
		listCVLink.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCertifDiscapacidad = new JList<>();
		listCertifDiscapacidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listUltimoAñoTrabajado = new JList<>();
		listUltimoAñoTrabajado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listInteresesPersonales = new JList<>();
		listInteresesPersonales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSituacionActual = new JList<>();
		listSituacionActual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEuskera = new JList<>();
		listEuskera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listIngles = new JList<>();
		listIngles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listOtrosIdiomas = new JList<>();
		listOtrosIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listLocalidad = new JList<>();
		listLocalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listAccesibilidad = new JList<>();
		listAccesibilidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listObservaciones = new JList<>();
		listObservaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));

		addPersonas();

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 1033, 267);
		panel.add(listNom);
		panel.add(listApoyo);
		panel.add(listFormacion);
		panel.add(listEspecialidad);
		panel.add(listSectorInteres);
		panel.add(listCVLink);
		panel.add(listCertifDiscapacidad);
		panel.add(listUltimoAñoTrabajado);
		panel.add(listInteresesPersonales);
		panel.add(listSituacionActual);
		panel.add(listEuskera);
		panel.add(listIngles);
		panel.add(listOtrosIdiomas);
		panel.add(listLocalidad);
		panel.add(listAccesibilidad);
		panel.add(listObservaciones);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 1033, 267);
		getContentPane().add(scrollPane);

		btnModificarPersona = new JButton("Modificar persona en orientacion");
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(346, 287, 395, 72);
		getContentPane().add(btnModificarPersona);
		btnModificarPersona.addActionListener(this);
	}

	public void addPersonas() {
		Map<String, PersonaOrientacion> personasOrientacion = cont.mostrarPersonas();
		DefaultListModel<String> modelNom = new DefaultListModel<>();
		DefaultListModel<String> modelApoyo = new DefaultListModel<>();
		DefaultListModel<String> modelFormacion = new DefaultListModel<>();
		DefaultListModel<String> modelEspecialidad = new DefaultListModel<>();
		DefaultListModel<String> modelSectorInteres = new DefaultListModel<>();
		DefaultListModel<String> modelCVLink = new DefaultListModel<>();
		DefaultListModel<String> modelCertificadoDiscapacidad = new DefaultListModel<>();
		DefaultListModel<String> modelUltimoAñoTrabajado = new DefaultListModel<>();
		DefaultListModel<String> modelInteresesPersonales = new DefaultListModel<>();
		DefaultListModel<String> modelSituacionActual = new DefaultListModel<>();
		DefaultListModel<String> modelEuskera = new DefaultListModel<>();
		DefaultListModel<String> modelIngles = new DefaultListModel<>();
		DefaultListModel<String> modelOtrosIdiomas = new DefaultListModel<>();
		DefaultListModel<String> modelLocalidad = new DefaultListModel<>();
		DefaultListModel<String> modelAccesibilidad = new DefaultListModel<>();
		DefaultListModel<String> modelObservaciones = new DefaultListModel<>();

		modelNom.addElement("Nombres");
		modelApoyo.addElement("Apoyo");
		modelFormacion.addElement("Formacion");
		modelEspecialidad.addElement("Especialidad (descripciones)");
		modelSectorInteres.addElement("Sector de interes");
		modelCVLink.addElement("Links de CVs");
		modelCertificadoDiscapacidad.addElement("Certificado de discapacidad");
		modelUltimoAñoTrabajado.addElement("Ultimo año trabajado");
		modelInteresesPersonales.addElement("Intereses personales");
		modelSituacionActual.addElement("Situacion actual");
		modelEuskera.addElement("Euskera");
		modelIngles.addElement("Ingles");
		modelOtrosIdiomas.addElement("Otros idiomas");
		modelLocalidad.addElement("Localidades");
		modelAccesibilidad.addElement("Accesibilidad");
		modelObservaciones.addElement("Observaciones");
		if (!personasOrientacion.isEmpty()) {
			for (PersonaOrientacion p : personasOrientacion.values()) {
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

				modelEspecialidad.addElement(p.getEspecialidad());
				switch (p.getSectorInteres()) {
				case AGRICULTURA_GANADERIA:
					modelSectorInteres.addElement("Agricultura y ganadería");
					break;

				case BIENESCONSUMO:
					modelSectorInteres.addElement("Bienes de consumo");
					break;

				case COMERCIOELECTRONICO:
					modelSectorInteres.addElement("Comercio electrónico");
					break;

				case COMERCIO_ESTABLECIMIENTOS:
					modelSectorInteres.addElement("Comercio y establecimientos");
					break;

				case CONSTRUCCION:
					modelSectorInteres.addElement("Construcción");
					break;

				case DEPORTE_OCIO:
					modelSectorInteres.addElement("Deporte y ocio");
					break;

				case ENERGIA_MEDIOAMBIENTE:
					modelSectorInteres.addElement("Energía y medio ambiente");
					break;

				case FINANZAS_SEGUROS_BIENESINMUEBLES:
					modelSectorInteres.addElement("Finanzas, seguros y bienes inmuebles");
					break;

				case INTERNET:
					modelSectorInteres.addElement("Internet");
					break;

				case LOGISTICA_TRANSPORTE:
					modelSectorInteres.addElement("Logística y transporte");
					break;

				case MEDIOSCOMUNICACION_MARKETING:
					modelSectorInteres.addElement("Medios de comunicación y marketing");
					break;

				case METALURGIA_ELECTRONICA:
					modelSectorInteres.addElement("Metalurgia y electrónica");
					break;

				case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
					modelSectorInteres.addElement("Productos químicos y materias primas");
					break;

				case SALUD_INDUSTRIAFARMACEUTICA:
					modelSectorInteres.addElement("Salud e industria farmacéutica");
					break;

				case SERVICIOS:
					modelSectorInteres.addElement("Servicios");
					break;

				case SOCIEDAD:
					modelSectorInteres.addElement("Sociedad");
					break;

				case TECNOLOGIA_TELECOMUNICACIONES:
					modelSectorInteres.addElement("Tecnología y telecomunicaciones");
					break;

				case TURISMO_HOSTELERIA:
					modelSectorInteres.addElement("Turismo y hostelería");
					break;

				case VIDA:
					modelSectorInteres.addElement("Vida");
					break;

				default:
					System.out.println("Tipo incorrecto");
				}

				switch (p.getCerfificadoDiscapacidad()) {
				case NO:
					modelCertificadoDiscapacidad.addElement("No");
					break;

				case NO_SABE:
					modelCertificadoDiscapacidad.addElement("No sabe");
					break;

				case SI:
					modelCertificadoDiscapacidad.addElement("Si");
					break;

				case TRAMITANDO:
					modelCertificadoDiscapacidad.addElement("Tramitando");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (p.getEuskera()) {
				case A1:
					modelEuskera.addElement("A1");
					break;

				case A2:
					modelEuskera.addElement("A2");
					break;

				case B1:
					modelEuskera.addElement("B1");
					break;

				case B2:
					modelEuskera.addElement("B2");
					break;

				case C1:
					modelEuskera.addElement("C1");
					break;

				case C2:
					modelEuskera.addElement("C2");
					break;

				case CONOCIMIENTO_NOACREDITADO:
					modelEuskera.addElement("Conocimiento, pero sin acreditar");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (p.getIngles()) {
				case A1:
					modelIngles.addElement("A1");
					break;

				case A2:
					modelIngles.addElement("A2");
					break;

				case B1:
					modelIngles.addElement("B1");
					break;

				case B2:
					modelIngles.addElement("B2");
					break;

				case C1:
					modelIngles.addElement("C1");
					break;

				case C2:
					modelIngles.addElement("C2");
					break;

				case CONOCIMIENTO_NOACREDITADO:
					modelIngles.addElement("Conocimiento, pero sin acreditar");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (p.getLocalidad()) {
				case ABADIÑO:
					modelLocalidad.addElement("Abadiño");
					break;

				case ABANTO_ZIERBENA:
					modelLocalidad.addElement("Abanto-Zierbena");
					break;

				case AJANGIZ:
					modelLocalidad.addElement("Ajangiz");
					break;

				case ALONSOTEGI:
					modelLocalidad.addElement("Alonsotegi");
					break;

				case AMOREBIETA:
					modelLocalidad.addElement("Amorebieta");
					break;

				case AMOROTO:
					modelLocalidad.addElement("Amoroto");
					break;

				case AMURRIO:
					modelLocalidad.addElement("Amurrio");
					break;

				case ARAKALDO:
					modelLocalidad.addElement("Arakaldo");
					break;

				case ARANTZAZU:
					modelLocalidad.addElement("Arantzazu");
					break;

				case AREATZA_BILARO:
					modelLocalidad.addElement("Areatza o Bilaro");
					break;

				case ARRANKUDIAGA:
					modelLocalidad.addElement("Arrankudiaga");
					break;

				case ARRATZU:
					modelLocalidad.addElement("Arratzu");
					break;

				case ARRIETA:
					modelLocalidad.addElement("Arrieta");
					break;

				case ARRIGORRIAGA:
					modelLocalidad.addElement("Arrigorriaga");
					break;

				case ARTZENTALES:
					modelLocalidad.addElement("Artzentales");
					break;

				case ARTZINIEGA:
					modelLocalidad.addElement("Artziniega");
					break;

				case AULESTI:
					modelLocalidad.addElement("Aulesti");
					break;

				case AXPEATXONDO:
					modelLocalidad.addElement("Axpe Atxondo");
					break;

				case AYALA_AIARA:
					modelLocalidad.addElement("Ayala/Aiara");
					break;

				case BAKIO:
					modelLocalidad.addElement("Bakio");
					break;

				case BALMASEDA:
					modelLocalidad.addElement("Balmaseda");
					break;

				case BARAKALDO:
					modelLocalidad.addElement("Barakaldo");
					break;

				case BARRIKA:
					modelLocalidad.addElement("Barrika");
					break;

				case BASAURI:
					modelLocalidad.addElement("Basauri");
					break;

				case BEDIA:
					modelLocalidad.addElement("Bedia");
					break;

				case BERANGO:
					modelLocalidad.addElement("Berango");
					break;

				case BERMEO:
					modelLocalidad.addElement("Bermeo");
					break;

				case BERRIATUA:
					modelLocalidad.addElement("Berriatua");
					break;

				case BERRIZ:
					modelLocalidad.addElement("Berriz");
					break;

				case BILBAO:
					modelLocalidad.addElement("Bilbao");
					break;

				case BUSTURIA:
					modelLocalidad.addElement("Busturia");
					break;

				case CASTROURDIALES:
					modelLocalidad.addElement("Castro Urdiales");
					break;

				case DERIO:
					modelLocalidad.addElement("Derio");
					break;

				case DIMA:
					modelLocalidad.addElement("Dima");
					break;

				case DURANGO:
					modelLocalidad.addElement("Durango");
					break;

				case EA:
					modelLocalidad.addElement("Ea");
					break;

				case ELANTXOBE:
					modelLocalidad.addElement("Elantxobe");
					break;

				case ELORRIO:
					modelLocalidad.addElement("Elorrio");
					break;

				case ERANDIO:
					modelLocalidad.addElement("Erandio");
					break;

				case EREÑO:
					modelLocalidad.addElement("Ereño");
					break;

				case ERMUA:
					modelLocalidad.addElement("Ermua");
					break;

				case ERRIGOITI:
					modelLocalidad.addElement("Errigoiti");
					break;

				case ETXEBARRI:
					modelLocalidad.addElement("Etxebarri");
					break;

				case ETXEBARRIA:
					modelLocalidad.addElement("Etxebarria");
					break;

				case FORUA:
					modelLocalidad.addElement("Forua");
					break;

				case FRUIZ:
					modelLocalidad.addElement("Fruiz");
					break;

				case GALDAKAO:
					modelLocalidad.addElement("Galdakao");
					break;

				case GALDAMES:
					modelLocalidad.addElement("Galdames");
					break;

				case GAMIZFIKA:
					modelLocalidad.addElement("Gamiz-Fika");
					break;

				case GARAI:
					modelLocalidad.addElement("Garai");
					break;

				case GATIKA:
					modelLocalidad.addElement("Gatika");
					break;

				case GAUTEGIZ:
					modelLocalidad.addElement("Gautegiz");
					break;

				case GAZTELUELEXABEITIA_ARTEAGA:
					modelLocalidad.addElement("Gaztelu-Elexabeitia o Arteaga");
					break;

				case GERNIKALUMO:
					modelLocalidad.addElement("Gernika-Lumo");
					break;

				case GETXO:
					modelLocalidad.addElement("Getxo");
					break;

				case GIZABURUAGA:
					modelLocalidad.addElement("Gizaburuaga");
					break;

				case GORDEXOLA:
					modelLocalidad.addElement("Gordexola");
					break;

				case GORLIZ:
					modelLocalidad.addElement("Gorliz");
					break;

				case GUEÑES:
					modelLocalidad.addElement("Gueñes");
					break;

				case IBARRANGELU:
					modelLocalidad.addElement("Ibarrangelu");
					break;

				case IGORRE:
					modelLocalidad.addElement("Igorre");
					break;

				case ISPASTER:
					modelLocalidad.addElement("Ispaster");
					break;

				case IURRETA:
					modelLocalidad.addElement("Iurreta");
					break;

				case IZURTZA:
					modelLocalidad.addElement("Izurtza");
					break;

				case KARRANTZAHARANA:
					modelLocalidad.addElement("Karrantza Harana");
					break;

				case KORTEZUBI:
					modelLocalidad.addElement("Kortezubi");
					break;

				case LANESTOSA:
					modelLocalidad.addElement("Lanestosa");
					break;

				case LARRABETZU:
					modelLocalidad.addElement("Larrabetzu");
					break;

				case LAUDIO_LLODIO:
					modelLocalidad.addElement("Laudio/Llodio");
					break;

				case LAUKIZ:
					modelLocalidad.addElement("Laukiz");
					break;

				case LEIOA:
					modelLocalidad.addElement("Leioa");
					break;

				case LEKEITIO:
					modelLocalidad.addElement("Lekeitio");
					break;

				case LEMOA:
					modelLocalidad.addElement("Lemoa");
					break;

				case LEMOIZ:
					modelLocalidad.addElement("Lemoiz");
					break;

				case LEZAMA:
					modelLocalidad.addElement("Lezama");
					break;

				case LOIU:
					modelLocalidad.addElement("Loiu");
					break;

				case MALLABIA:
					modelLocalidad.addElement("Mallabia");
					break;

				case MARKINAXEMEIN:
					modelLocalidad.addElement("Markina-Xemein");
					break;

				case MARURI:
					modelLocalidad.addElement("Maruri");
					break;

				case MAÑARIA:
					modelLocalidad.addElement("Mañaria");
					break;

				case MENDATA:
					modelLocalidad.addElement("Mendata");
					break;

				case MENDEXA:
					modelLocalidad.addElement("Mendexa");
					break;

				case MEÑAKA:
					modelLocalidad.addElement("Meñaka");
					break;

				case MORGA:
					modelLocalidad.addElement("Morga");
					break;

				case MUNDAKA:
					modelLocalidad.addElement("Mundaka");
					break;

				case MUNGIA:
					modelLocalidad.addElement("Mungia");
					break;

				case MUNITIBARARBATZEGI_GERRIKAITZ:
					modelLocalidad.addElement("Munitibar-Arbatzegi Gerrikaitz");
					break;

				case MURUETA:
					modelLocalidad.addElement("Murueta");
					break;

				case MUSKIZ:
					modelLocalidad.addElement("Muskiz");
					break;

				case MUXIKA:
					modelLocalidad.addElement("Muxika");
					break;

				case NABARNIZ:
					modelLocalidad.addElement("Nabarniz");
					break;

				case ONDARROA:
					modelLocalidad.addElement("Ondarroa");
					break;

				case ORDUÑA:
					modelLocalidad.addElement("Orduña");
					break;

				case OROZKO:
					modelLocalidad.addElement("Orozko");
					break;

				case ORTUELLA:
					modelLocalidad.addElement("Ortuella");
					break;

				case OTXANDIO:
					modelLocalidad.addElement("Otxandio");
					break;

				case PLENTZIA:
					modelLocalidad.addElement("Plentzia");
					break;

				case PORTUGALETE:
					modelLocalidad.addElement("Portugalete");
					break;

				case SANTURTZI:
					modelLocalidad.addElement("Santurtzi");
					break;

				case SESTAO:
					modelLocalidad.addElement("Sestao");
					break;

				case SONDIKA:
					modelLocalidad.addElement("Sondika");
					break;

				case SOPELA:
					modelLocalidad.addElement("Sopela");
					break;

				case SOPUERTA:
					modelLocalidad.addElement("Sopuerta");
					break;

				case SUKARRIETA:
					modelLocalidad.addElement("Sukarrieta");
					break;

				case TRAPAGARAN:
					modelLocalidad.addElement("Trapagaran");
					break;

				case TURTZIOZ:
					modelLocalidad.addElement("Turtzioz");
					break;

				case UBIDE:
					modelLocalidad.addElement("Ubide");
					break;

				case UGAOMIRABALLES:
					modelLocalidad.addElement("Ugao-Miraballes");
					break;

				case URDULIZ:
					modelLocalidad.addElement("Urduliz");
					break;

				case URDUÑA:
					modelLocalidad.addElement("Urduña");
					break;

				case USANSOLO:
					modelLocalidad.addElement("Usansolo");
					break;

				case ZALDIBAR:
					modelLocalidad.addElement("Zaldibar");
					break;

				case ZALLA:
					modelLocalidad.addElement("Zalla");
					break;

				case ZAMUDIO:
					modelLocalidad.addElement("Zamudio");
					break;

				case ZARATAMO:
					modelLocalidad.addElement("Zaratamo");
					break;

				case ZEANURI:
					modelLocalidad.addElement("Zeanuri");
					break;

				case ZEBERIO:
					modelLocalidad.addElement("Zeberio");
					break;

				case ZIERBENA:
					modelLocalidad.addElement("Zierbena");
					break;

				case ZIORTZA_BOLIBAR:
					modelLocalidad.addElement("Ziortza-Bolibar");
					break;

				case ZORNOTZA:
					modelLocalidad.addElement("Zornotza");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (p.getAccesibilidad()) {
				case CARNET:
					modelAccesibilidad.addElement("Carnet");
					break;

				case CARNET_COCHE:
					modelAccesibilidad.addElement("Carnet + Coche");
					break;

				case TRANSPORTE_PUBLICO:
					modelAccesibilidad.addElement("Transporte publico");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				modelNom.addElement(p.getNombre());
				modelApoyo.addElement(p.getApoyo());
				modelCVLink.addElement(p.getCvLink());
				modelInteresesPersonales.addElement(p.getInteresesPersonales());
				modelOtrosIdiomas.addElement(p.getOtrosIdiomas());
				modelObservaciones.addElement(p.getObservaciones());
				modelSituacionActual.addElement(p.getSituacionActual());
				modelUltimoAñoTrabajado.addElement("" + p.getUltimoAñoTrabajado());
			}

			listNom.setModel(modelNom);
			listApoyo.setModel(modelApoyo);
			listFormacion.setModel(modelFormacion);
			listEspecialidad.setModel(modelEspecialidad);
			listSectorInteres.setModel(modelSectorInteres);
			listCVLink.setModel(modelCVLink);
			listCertifDiscapacidad.setModel(modelCertificadoDiscapacidad);
			listUltimoAñoTrabajado.setModel(modelUltimoAñoTrabajado);
			listInteresesPersonales.setModel(modelInteresesPersonales);
			listSituacionActual.setModel(modelSituacionActual);
			listEuskera.setModel(modelEuskera);
			listIngles.setModel(modelIngles);
			listOtrosIdiomas.setModel(modelOtrosIdiomas);
			listLocalidad.setModel(modelLocalidad);
			listAccesibilidad.setModel(modelAccesibilidad);
			listObservaciones.setModel(modelObservaciones);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona en orientacion para visualizar."
							+ "\nPor favor, añada una persona en orientacion anter the abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarPersona) {
			if (!listNom.isSelectionEmpty()) {
				if (!listNom.getSelectedValue().equals("Nombre")) {
					VentanaModificarPersonaOrientacion dialog = new VentanaModificarPersonaOrientacion(this, cont,
							cont.getPersona(listNom.getSelectedValue()));
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
