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
	private JButton btnModificarPersona;

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

		btnModificarPersona = new JButton("Modificar persona");
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(346, 287, 395, 72);
		getContentPane().add(btnModificarPersona);
		btnModificarPersona.addActionListener(this);
	}

	public void addPersonas() {
		Map<String, Persona> personas = cont.mostrarPersonas();
		DefaultListModel<String> modelNom = new DefaultListModel<>();
		DefaultListModel<String> modelApoyo = new DefaultListModel<>();
		DefaultListModel<String> modelFormacion = new DefaultListModel<>();
		DefaultListModel<String> modelEspecialidad = new DefaultListModel<>();
		DefaultListModel<String> modelSectorInteres = new DefaultListModel<>();
		DefaultListModel<String> modelCVLink = new DefaultListModel<>();
		DefaultListModel<String> modelCertificadoDiscapacidad = new DefaultListModel<>();
		DefaultListModel<String> modelEuskera = new DefaultListModel<>();
		DefaultListModel<String> modelIngles = new DefaultListModel<>();
		DefaultListModel<String> modelOtrosIdiomas = new DefaultListModel<>();
		DefaultListModel<String> modelLocalidad = new DefaultListModel<>();
		DefaultListModel<String> modelAccesibilidad = new DefaultListModel<>();
		DefaultListModel<String> modelObservaciones = new DefaultListModel<>();

		modelNom.addElement("Nombre");
		modelApoyo.addElement("Apoyo");
		modelFormacion.addElement("Formacion");
		modelEspecialidad.addElement("Especialidad");
		modelSectorInteres.addElement("Sector de interes");
		modelCVLink.addElement("CV Link");
		modelCertificadoDiscapacidad.addElement("Certificado de discapacidad");
		modelEuskera.addElement("Euskera");
		modelIngles.addElement("Ingles");
		modelOtrosIdiomas.addElement("Otros idiomas");
		modelLocalidad.addElement("Localidad");
		modelAccesibilidad.addElement("Accesibilidad");
		modelObservaciones.addElement("Observaciones");
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
				// TBD

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
				modelOtrosIdiomas.addElement(p.getOtrosIdiomas());
				modelObservaciones.addElement(p.getObservaciones());
			}
			
			listNom.setModel(modelNom);
			listApoyo.setModel(modelApoyo);
			listFormacion.setModel(modelFormacion);
			listEspecialidad.setModel(modelEspecialidad);
			listSectorInteres.setModel(modelSectorInteres);
			listCVLink.setModel(modelCVLink);
			listCertifDiscapacidad.setModel(modelCertificadoDiscapacidad);
			listEuskera.setModel(modelEuskera);
			listIngles.setModel(modelIngles);
			listOtrosIdiomas.setModel(modelOtrosIdiomas);
			listLocalidad.setModel(modelLocalidad);
			listAccesibilidad.setModel(modelAccesibilidad);
			listObservaciones.setModel(modelObservaciones);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona para visualizar."
							+ "\nPor favor, añada una persona anter the abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarPersona) {
			if (!listNom.isSelectionEmpty()) {
				if (!listNom.getSelectedValue().equals("Nombre")) {
					VentanaModificarPersona dialog = new VentanaModificarPersona(this, cont,
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
