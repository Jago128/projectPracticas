package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaMostrarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listNom, listApoyo, listFormacion, listEspecialidad, listSectorInteres, listCVLink,
	listCertifDiscapacidad, listEuskera, listIngles, listOtrosIdiomas, listLocalidad, listObservaciones,
	listAccesibilidad;
	private JButton btnModificarEmpresa;

	public VentanaMostrarPersona(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar personas");
		setBounds(100, 100, 1080, 410);
		getContentPane().setLayout(null);

		listNom = new JList<>();
		listNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNom.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listApoyo = new JList<String>();
		listApoyo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFormacion = new JList<String>();
		listFormacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEspecialidad = new JList<String>();
		listEspecialidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSectorInteres = new JList<String>();
		listSectorInteres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCVLink = new JList<String>();
		listCVLink.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCertifDiscapacidad = new JList<String>();
		listCertifDiscapacidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

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

		btnModificarEmpresa = new JButton("Modificar empresa");
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarEmpresa.setBounds(346, 287, 395, 72);
		getContentPane().add(btnModificarEmpresa);
		btnModificarEmpresa.addActionListener(this);
	}

	public void addPersonas() {
		Map<String, Persona> personas = cont.mostrarPersonas();
		DefaultListModel<String> modelNom = new DefaultListModel<>();
		DefaultListModel<String> modelApoyo = new DefaultListModel<>();
		DefaultListModel<String> modelFormacion = new DefaultListModel<>();
		DefaultListModel<String> modelEspecialidad = new DefaultListModel<>();
		DefaultListModel<String> modelSectorInteres = new DefaultListModel<>();
		DefaultListModel<String> modelCVLink = new DefaultListModel<>();
		DefaultListModel<String> modelCertifDiscapacidad = new DefaultListModel<>();
		DefaultListModel<String> modelEuskera = new DefaultListModel<>();
		DefaultListModel<String> modelIngles = new DefaultListModel<>();
		DefaultListModel<String> modelOtrosIdiomas = new DefaultListModel<>();
		DefaultListModel<String> modelLocalidad = new DefaultListModel<>();
		DefaultListModel<String> modelAccesibilidad = new DefaultListModel<>();
		DefaultListModel<String> modelObservaciones = new DefaultListModel<>();

		modelNom.addElement("");
		modelApoyo.addElement("");
		modelFormacion.addElement("");
		modelEspecialidad.addElement("");
		modelSectorInteres.addElement("");
		modelCVLink.addElement("");
		modelCertifDiscapacidad.addElement("");
		modelEuskera.addElement("");
		modelIngles.addElement("");
		modelOtrosIdiomas.addElement("");
		modelLocalidad.addElement("Localidad");
		modelAccesibilidad.addElement("");
		modelObservaciones.addElement("");

		if (!personas.isEmpty()) {

			for (Persona p : personas.values()) {

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

				// Especialidades, SectorInteres [TBD]

						switch (p.getCerfificadoDiscapacidad()) {
						case NO:

							break;

						case NOSABE:

							break;

						case SI:

							break;

						case TRAMITANDO:

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

						default:
							System.out.println("Tipo invalido");
						}

						switch (p.getAccesibilidad()) {
						case CARNET:
							
							break;
							
						case CARNET_COCHE:
							
							break;
							
						case TRANSPORTEPUBLICO:
							
							break;
							
						default:
							System.out.println("Tipo invalido");
						}

						modelNom.addElement(p.getNombre());
						modelApoyo.addElement(p.getApoyo());
						modelCVLink.addElement(p.getCvLink());
						modelOtrosIdiomas.addElement(p.getOtrosIdiomas());
						modelObservaciones.addElement(p.getObservaciones());
			}
		}
		listNom.setModel(modelNom);
		listApoyo.setModel(modelApoyo);
		listFormacion.setModel(modelFormacion);
		listEspecialidad.setModel(modelEspecialidad);
		listSectorInteres.setModel(modelSectorInteres);
		listCVLink.setModel(modelCVLink);
		listCertifDiscapacidad.setModel(modelCertifDiscapacidad);
		listEuskera.setModel(modelEuskera);
		listIngles.setModel(modelIngles);
		listOtrosIdiomas.setModel(modelOtrosIdiomas);
		listLocalidad.setModel(modelLocalidad);
		listAccesibilidad.setModel(modelAccesibilidad);
		listObservaciones.setModel(modelObservaciones);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaModificarPersona dialog = new VentanaModificarPersona(this, cont, null); // Not ready
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
