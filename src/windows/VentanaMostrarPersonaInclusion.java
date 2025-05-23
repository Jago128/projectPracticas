package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.PersonaInclusion;
import model.Usuario;

public class VentanaMostrarPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listNom, listPersonaFacilitadora, listFormacion, listEspecialidad, listSectorInteres, listCV,
			listOtros, listIdioma, listMunicipio, listAccesibilidad, listInteresesPersonales, listSituacionActual,
			listUltimoAñoTrabajado, listApellido, listEdad;
	private JButton btnModificarPersona;
	private JTextArea textAreaInfo;

	public VentanaMostrarPersonaInclusion(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar personas en inclusion");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1080, 410);
		getContentPane().setLayout(null);

		listNom = new JList<>();
		listNom.setBackground(new Color(38, 201, 236));
		listNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNom.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listApellido = new JList<>();
		listApellido.setBackground(new Color(38, 201, 236));
		listApellido.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEdad = new JList<String>();
		listEdad.setBackground(new Color(38, 201, 236));
		listEdad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEdad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listMunicipio = new JList<>();
		listMunicipio.setBackground(new Color(38, 201, 236));
		listMunicipio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFormacion = new JList<>();
		listFormacion.setBackground(new Color(38, 201, 236));
		listFormacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEspecialidad = new JList<>();
		listEspecialidad.setBackground(new Color(38, 201, 236));
		listEspecialidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listOtros = new JList<>();
		listOtros.setBackground(new Color(38, 201, 236));
		listOtros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOtros.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listIdioma = new JList<>();
		listIdioma.setBackground(new Color(38, 201, 236));
		listIdioma.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listIdioma.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listUltimoAñoTrabajado = new JList<>();
		listUltimoAñoTrabajado.setBackground(new Color(38, 201, 236));
		listUltimoAñoTrabajado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUltimoAñoTrabajado.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSectorInteres = new JList<>();
		listSectorInteres.setBackground(new Color(38, 201, 236));
		listSectorInteres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listInteresesPersonales = new JList<>();
		listInteresesPersonales.setBackground(new Color(38, 201, 236));
		listInteresesPersonales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInteresesPersonales.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSituacionActual = new JList<>();
		listSituacionActual.setBackground(new Color(38, 201, 236));
		listSituacionActual.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSituacionActual.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listAccesibilidad = new JList<>();
		listAccesibilidad.setBackground(new Color(38, 201, 236));
		listAccesibilidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCV = new JList<>();
		listCV.setBackground(new Color(38, 201, 236));
		listCV.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCV.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPersonaFacilitadora = new JList<>();
		listPersonaFacilitadora.setBackground(new Color(38, 201, 236));
		listPersonaFacilitadora.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonaFacilitadora.setFont(new Font("Tahoma", Font.PLAIN, 12));

		addPersonas();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 201, 236));
		panel.setBounds(10, 10, 1033, 267);
		panel.add(listNom);
		panel.add(listApellido);
		panel.add(listEdad);
		panel.add(listMunicipio);
		panel.add(listFormacion);
		panel.add(listEspecialidad);
		panel.add(listOtros);
		panel.add(listIdioma);
		panel.add(listUltimoAñoTrabajado);
		panel.add(listSectorInteres);
		panel.add(listInteresesPersonales);
		panel.add(listSituacionActual);
		panel.add(listAccesibilidad);
		panel.add(listCV);
		panel.add(listPersonaFacilitadora);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 1033, 267);
		getContentPane().add(scrollPane);

		btnModificarPersona = new JButton("Modificar persona en inclusion");
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(524, 287, 395, 72);
		getContentPane().add(btnModificarPersona);

		textAreaInfo = new JTextArea();
		textAreaInfo.setText("Selecciona un nombre, y despues pulsa el boton\npara modificar la persona en inclusion.");
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaInfo.setEditable(false);
		textAreaInfo.setBackground(new Color(38, 201, 236));
		textAreaInfo.setBounds(20, 287, 481, 57);
		getContentPane().add(textAreaInfo);
		btnModificarPersona.addActionListener(this);
	}

	public void addPersonas() {
		Map<String, PersonaInclusion> personasInclusion = cont.mostrarPersonasInclusion();
		DefaultListModel<String> modelNom = new DefaultListModel<>();
		DefaultListModel<String> modelApellido = new DefaultListModel<>();
		DefaultListModel<String> modelEdad = new DefaultListModel<>();
		DefaultListModel<String> modelMunicipio = new DefaultListModel<>();
		DefaultListModel<String> modelFormacion = new DefaultListModel<>();
		DefaultListModel<String> modelEspecialidad = new DefaultListModel<>();
		DefaultListModel<String> modelOtros = new DefaultListModel<>();
		DefaultListModel<String> modelIdioma = new DefaultListModel<>();
		DefaultListModel<String> modelUltimoAñoTrabajado = new DefaultListModel<>();
		DefaultListModel<String> modelSectorInteres = new DefaultListModel<>();
		DefaultListModel<String> modelInteresesPersonales = new DefaultListModel<>();
		DefaultListModel<String> modelSituacionActual = new DefaultListModel<>();
		DefaultListModel<String> modelAccesibilidad = new DefaultListModel<>();
		DefaultListModel<String> modelCV = new DefaultListModel<>();
		DefaultListModel<String> modelPersonaFacilitadora = new DefaultListModel<>();

		modelNom.addElement("Nombres");
		modelApellido.addElement("Apellidos");
		modelEdad.addElement("Edad");
		modelMunicipio.addElement("Municipios");
		modelFormacion.addElement("Formacion");
		modelEspecialidad.addElement("Especialidad");
		modelOtros.addElement("Otros titulos, certificados, carnets");
		modelIdioma.addElement("Idioma");
		modelUltimoAñoTrabajado.addElement("Ultimo año trabajando");
		modelSectorInteres.addElement("Sector interes");
		modelInteresesPersonales.addElement("Intereses personales");
		modelSituacionActual.addElement("Situacion actual");
		modelAccesibilidad.addElement("Accesibilidad");
		modelCV.addElement("CV");
		modelPersonaFacilitadora.addElement("Persona facilitadora");
		if (!personasInclusion.isEmpty()) {
			for (PersonaInclusion p : personasInclusion.values()) {
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

				switch (p.getMunicipio()) {
				case ABADIÑO:
					modelMunicipio.addElement("Abadiño");
					break;

				case ABANTO_ZIERBENA:
					modelMunicipio.addElement("Abanto-Zierbena");
					break;

				case AJANGIZ:
					modelMunicipio.addElement("Ajangiz");
					break;

				case ALONSOTEGI:
					modelMunicipio.addElement("Alonsotegi");
					break;

				case AMOREBIETA:
					modelMunicipio.addElement("Amorebieta");
					break;

				case AMOROTO:
					modelMunicipio.addElement("Amoroto");
					break;

				case AMURRIO:
					modelMunicipio.addElement("Amurrio");
					break;

				case ARAKALDO:
					modelMunicipio.addElement("Arakaldo");
					break;

				case ARANTZAZU:
					modelMunicipio.addElement("Arantzazu");
					break;

				case AREATZA_BILARO:
					modelMunicipio.addElement("Areatza o Bilaro");
					break;

				case ARRANKUDIAGA:
					modelMunicipio.addElement("Arrankudiaga");
					break;

				case ARRATZU:
					modelMunicipio.addElement("Arratzu");
					break;

				case ARRIETA:
					modelMunicipio.addElement("Arrieta");
					break;

				case ARRIGORRIAGA:
					modelMunicipio.addElement("Arrigorriaga");
					break;

				case ARTZENTALES:
					modelMunicipio.addElement("Artzentales");
					break;

				case ARTZINIEGA:
					modelMunicipio.addElement("Artziniega");
					break;

				case AULESTI:
					modelMunicipio.addElement("Aulesti");
					break;

				case AXPEATXONDO:
					modelMunicipio.addElement("Axpe Atxondo");
					break;

				case AYALA_AIARA:
					modelMunicipio.addElement("Ayala/Aiara");
					break;

				case BAKIO:
					modelMunicipio.addElement("Bakio");
					break;

				case BALMASEDA:
					modelMunicipio.addElement("Balmaseda");
					break;

				case BARAKALDO:
					modelMunicipio.addElement("Barakaldo");
					break;

				case BARRIKA:
					modelMunicipio.addElement("Barrika");
					break;

				case BASAURI:
					modelMunicipio.addElement("Basauri");
					break;

				case BEDIA:
					modelMunicipio.addElement("Bedia");
					break;

				case BERANGO:
					modelMunicipio.addElement("Berango");
					break;

				case BERMEO:
					modelMunicipio.addElement("Bermeo");
					break;

				case BERRIATUA:
					modelMunicipio.addElement("Berriatua");
					break;

				case BERRIZ:
					modelMunicipio.addElement("Berriz");
					break;

				case BILBAO:
					modelMunicipio.addElement("Bilbao");
					break;

				case BUSTURIA:
					modelMunicipio.addElement("Busturia");
					break;

				case CASTROURDIALES:
					modelMunicipio.addElement("Castro Urdiales");
					break;

				case DERIO:
					modelMunicipio.addElement("Derio");
					break;

				case DIMA:
					modelMunicipio.addElement("Dima");
					break;

				case DURANGO:
					modelMunicipio.addElement("Durango");
					break;

				case EA:
					modelMunicipio.addElement("Ea");
					break;

				case ELANTXOBE:
					modelMunicipio.addElement("Elantxobe");
					break;

				case ELORRIO:
					modelMunicipio.addElement("Elorrio");
					break;

				case ERANDIO:
					modelMunicipio.addElement("Erandio");
					break;

				case EREÑO:
					modelMunicipio.addElement("Ereño");
					break;

				case ERMUA:
					modelMunicipio.addElement("Ermua");
					break;

				case ERRIGOITI:
					modelMunicipio.addElement("Errigoiti");
					break;

				case ETXEBARRI:
					modelMunicipio.addElement("Etxebarri");
					break;

				case ETXEBARRIA:
					modelMunicipio.addElement("Etxebarria");
					break;

				case FORUA:
					modelMunicipio.addElement("Forua");
					break;

				case FRUIZ:
					modelMunicipio.addElement("Fruiz");
					break;

				case GALDAKAO:
					modelMunicipio.addElement("Galdakao");
					break;

				case GALDAMES:
					modelMunicipio.addElement("Galdames");
					break;

				case GAMIZFIKA:
					modelMunicipio.addElement("Gamiz-Fika");
					break;

				case GARAI:
					modelMunicipio.addElement("Garai");
					break;

				case GATIKA:
					modelMunicipio.addElement("Gatika");
					break;

				case GAUTEGIZ:
					modelMunicipio.addElement("Gautegiz");
					break;

				case GAZTELUELEXABEITIA_ARTEAGA:
					modelMunicipio.addElement("Gaztelu-Elexabeitia o Arteaga");
					break;

				case GERNIKALUMO:
					modelMunicipio.addElement("Gernika-Lumo");
					break;

				case GETXO:
					modelMunicipio.addElement("Getxo");
					break;

				case GIZABURUAGA:
					modelMunicipio.addElement("Gizaburuaga");
					break;

				case GORDEXOLA:
					modelMunicipio.addElement("Gordexola");
					break;

				case GORLIZ:
					modelMunicipio.addElement("Gorliz");
					break;

				case GUEÑES:
					modelMunicipio.addElement("Gueñes");
					break;

				case IBARRANGELU:
					modelMunicipio.addElement("Ibarrangelu");
					break;

				case IGORRE:
					modelMunicipio.addElement("Igorre");
					break;

				case ISPASTER:
					modelMunicipio.addElement("Ispaster");
					break;

				case IURRETA:
					modelMunicipio.addElement("Iurreta");
					break;

				case IZURTZA:
					modelMunicipio.addElement("Izurtza");
					break;

				case KARRANTZAHARANA:
					modelMunicipio.addElement("Karrantza Harana");
					break;

				case KORTEZUBI:
					modelMunicipio.addElement("Kortezubi");
					break;

				case LANESTOSA:
					modelMunicipio.addElement("Lanestosa");
					break;

				case LARRABETZU:
					modelMunicipio.addElement("Larrabetzu");
					break;

				case LAUDIO_LLODIO:
					modelMunicipio.addElement("Laudio/Llodio");
					break;

				case LAUKIZ:
					modelMunicipio.addElement("Laukiz");
					break;

				case LEIOA:
					modelMunicipio.addElement("Leioa");
					break;

				case LEKEITIO:
					modelMunicipio.addElement("Lekeitio");
					break;

				case LEMOA:
					modelMunicipio.addElement("Lemoa");
					break;

				case LEMOIZ:
					modelMunicipio.addElement("Lemoiz");
					break;

				case LEZAMA:
					modelMunicipio.addElement("Lezama");
					break;

				case LOIU:
					modelMunicipio.addElement("Loiu");
					break;

				case MALLABIA:
					modelMunicipio.addElement("Mallabia");
					break;

				case MARKINAXEMEIN:
					modelMunicipio.addElement("Markina-Xemein");
					break;

				case MARURI:
					modelMunicipio.addElement("Maruri");
					break;

				case MAÑARIA:
					modelMunicipio.addElement("Mañaria");
					break;

				case MENDATA:
					modelMunicipio.addElement("Mendata");
					break;

				case MENDEXA:
					modelMunicipio.addElement("Mendexa");
					break;

				case MEÑAKA:
					modelMunicipio.addElement("Meñaka");
					break;

				case MORGA:
					modelMunicipio.addElement("Morga");
					break;

				case MUNDAKA:
					modelMunicipio.addElement("Mundaka");
					break;

				case MUNGIA:
					modelMunicipio.addElement("Mungia");
					break;

				case MUNITIBARARBATZEGI_GERRIKAITZ:
					modelMunicipio.addElement("Munitibar-Arbatzegi Gerrikaitz");
					break;

				case MURUETA:
					modelMunicipio.addElement("Murueta");
					break;

				case MUSKIZ:
					modelMunicipio.addElement("Muskiz");
					break;

				case MUXIKA:
					modelMunicipio.addElement("Muxika");
					break;

				case NABARNIZ:
					modelMunicipio.addElement("Nabarniz");
					break;

				case ONDARROA:
					modelMunicipio.addElement("Ondarroa");
					break;

				case ORDUÑA:
					modelMunicipio.addElement("Orduña");
					break;

				case OROZKO:
					modelMunicipio.addElement("Orozko");
					break;

				case ORTUELLA:
					modelMunicipio.addElement("Ortuella");
					break;

				case OTXANDIO:
					modelMunicipio.addElement("Otxandio");
					break;

				case PLENTZIA:
					modelMunicipio.addElement("Plentzia");
					break;

				case PORTUGALETE:
					modelMunicipio.addElement("Portugalete");
					break;

				case SANTURTZI:
					modelMunicipio.addElement("Santurtzi");
					break;

				case SESTAO:
					modelMunicipio.addElement("Sestao");
					break;

				case SONDIKA:
					modelMunicipio.addElement("Sondika");
					break;

				case SOPELA:
					modelMunicipio.addElement("Sopela");
					break;

				case SOPUERTA:
					modelMunicipio.addElement("Sopuerta");
					break;

				case SUKARRIETA:
					modelMunicipio.addElement("Sukarrieta");
					break;

				case TRAPAGARAN:
					modelMunicipio.addElement("Trapagaran");
					break;

				case TURTZIOZ:
					modelMunicipio.addElement("Turtzioz");
					break;

				case UBIDE:
					modelMunicipio.addElement("Ubide");
					break;

				case UGAOMIRABALLES:
					modelMunicipio.addElement("Ugao-Miraballes");
					break;

				case URDULIZ:
					modelMunicipio.addElement("Urduliz");
					break;

				case URDUÑA:
					modelMunicipio.addElement("Urduña");
					break;

				case USANSOLO:
					modelMunicipio.addElement("Usansolo");
					break;

				case ZALDIBAR:
					modelMunicipio.addElement("Zaldibar");
					break;

				case ZALLA:
					modelMunicipio.addElement("Zalla");
					break;

				case ZAMUDIO:
					modelMunicipio.addElement("Zamudio");
					break;

				case ZARATAMO:
					modelMunicipio.addElement("Zaratamo");
					break;

				case ZEANURI:
					modelMunicipio.addElement("Zeanuri");
					break;

				case ZEBERIO:
					modelMunicipio.addElement("Zeberio");
					break;

				case ZIERBENA:
					modelMunicipio.addElement("Zierbena");
					break;

				case ZIORTZABOLIBAR:
					modelMunicipio.addElement("Ziortza-Bolibar");
					break;

				case ZORNOTZA:
					modelMunicipio.addElement("Zornotza");
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
				modelApellido.addElement(p.getApellido());
				modelEdad.addElement("" + p.getEdad());
				modelEspecialidad.addElement(p.getEspecialidad());
				if (p.getOtros() == null) {
					modelOtros.addElement("---");
				} else {
					modelOtros.addElement(p.getOtros());
				}
				modelIdioma.addElement(p.getIdioma());
				if (p.getUltimoAñoTrabajado() == 0) {
					modelUltimoAñoTrabajado.addElement("---");
				} else {
					modelUltimoAñoTrabajado.addElement("" + p.getUltimoAñoTrabajado());
				}
				
				if (p.getInteresesPersonales() == null) {
					modelInteresesPersonales.addElement("---");
				} else {
					modelInteresesPersonales.addElement(p.getInteresesPersonales());
				}
				
				if (p.getSituacionActual() == null) {
					modelSituacionActual.addElement("---");
				} else {
					modelSituacionActual.addElement(p.getSituacionActual());
				}
				
				if (p.getCv() == null) {
					modelCV.addElement("---");
				} else {
					modelCV.addElement(p.getCv());
				}
				modelPersonaFacilitadora.addElement(p.getPersonaFacilitadora());
			}

			listNom.setModel(modelNom);
			listApellido.setModel(modelApellido);
			listEdad.setModel(modelEdad);
			listMunicipio.setModel(modelMunicipio);
			listFormacion.setModel(modelEspecialidad);
			listEspecialidad.setModel(modelEspecialidad);
			listOtros.setModel(modelOtros);
			listIdioma.setModel(modelIdioma);
			listUltimoAñoTrabajado.setModel(modelUltimoAñoTrabajado);
			listSectorInteres.setModel(modelSectorInteres);
			listInteresesPersonales.setModel(modelInteresesPersonales);
			listSituacionActual.setModel(modelSituacionActual);
			listAccesibilidad.setModel(modelAccesibilidad);
			listCV.setModel(modelCV);
			listPersonaFacilitadora.setModel(modelPersonaFacilitadora);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona en inclusion para visualizar."
							+ "\nPor favor, añada una persona en inclusion anter the abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarPersona) {
			if (!listNom.isSelectionEmpty()) {
				if (!listNom.getSelectedValue().equals("Nombres")) {
					VentanaModificarPersonaInclusion dialog = new VentanaModificarPersonaInclusion(this, cont,
							cont.getPersonaInclusion(listNom.getSelectedValue()));
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
