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
	private JList<String> listNom, listApoyo, listFormacion, listEspecialidad, listSectorInteres, listCVLink,
			listCertifDiscapacidad, listEuskera, listIngles, listOtrosIdiomas, listLocalidad, listObservaciones,
			listAccesibilidad, listInteresesPersonales, listSituacionActual, listUltimoAñoTrabajado;
	private JButton btnModificarPersona;
	
	public VentanaMostrarPersonaPracticas(JDialog parent, LoginController cont, Usuario user) {
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

		modelNom.addElement("Nombres");
		modelApoyo.addElement("Apoyo");
		modelFormacion.addElement("Formacion");
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

				modelNom.addElement(p.getNombre());
				modelApoyo.addElement(p.getApoyo());
			}

			listNom.setModel(modelNom);
			listApoyo.setModel(modelApoyo);
			listFormacion.setModel(modelFormacion);
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
					
				} else {
					JOptionPane.showMessageDialog(null, "[ERROR] No se puede modificar el titulo de la columna.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elije un nombre de la lista de nombres.");
			}
		}
	}
}
