package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Persona;

public class VentanaModificarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Persona persona;
	private JTextArea textareaPersona, textAreaObservaciones;
	private JTextField textFieldApoyo, textFieldOtrosIdiomas, textFieldCVLink;
	private JComboBox<String> comboBoxSectorInteres, comboBoxEspecialidad, comboBoxLocalidad, comboBoxFormacion,
			comboBoxCertifDiscapacidad, comboBoxEuskera, comboBoxIngles, comboBoxAccesibilidad;
	private JButton btnModificar;

	public VentanaModificarPersona(JDialog parent, LoginController cont, Persona persona) {
		super(parent, true);
		this.cont = cont;
		this.persona = persona;

		setResizable(false);
		setTitle("Modificar empresa");
		setBounds(100, 100, 920, 530);
		getContentPane().setLayout(null);

		JLabel lblDatosPersona = new JLabel("Informacion de la persona seleccionada:");
		lblDatosPersona.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosPersona.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosPersona.setBounds(378, 10, 506, 28);
		getContentPane().add(lblDatosPersona);

		textareaPersona = new JTextArea();
		textareaPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textareaPersona.setText("");
		textareaPersona.setBackground(new Color(255, 255, 255));
		textareaPersona.setLineWrap(true);
		textareaPersona.setEditable(false);
		textareaPersona.setBounds(388, 37, 506, 373);
		getContentPane().add(textareaPersona);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(10, 7, 377, 28);
		getContentPane().add(lblNota);

		loadPersona();

		JLabel lblApoyo = new JLabel("Apoyo:");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(25, 37, 140, 28);
		getContentPane().add(lblApoyo);

		textFieldApoyo = new JTextField();
		textFieldApoyo.setColumns(10);
		textFieldApoyo.setBounds(175, 43, 163, 19);
		getContentPane().add(textFieldApoyo);

		JLabel lblFormacion = new JLabel("Formacion:");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(14, 75, 151, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(175, 80, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad:");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(25, 113, 140, 28);
		getContentPane().add(lblEspecialidad);

		comboBoxEspecialidad = new JComboBox<>();
		comboBoxEspecialidad.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxEspecialidad.setSelectedIndex(0);
		comboBoxEspecialidad.setBounds(175, 118, 163, 21);
		getContentPane().add(comboBoxEspecialidad);

		JLabel lblSectorInteres = new JLabel("Sector interes:");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(46, 153, 119, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(175, 158, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		JLabel lblCVLink = new JLabel("CV Link:");
		lblCVLink.setHorizontalAlignment(SwingConstants.CENTER);
		lblCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCVLink.setBounds(56, 191, 78, 28);
		getContentPane().add(lblCVLink);

		textFieldCVLink = new JTextField();
		textFieldCVLink.setColumns(10);
		textFieldCVLink.setBounds(175, 197, 163, 19);
		getContentPane().add(textFieldCVLink);

		JLabel lblCertifDiscapacidad = new JLabel("Certificado discapacidad:");
		lblCertifDiscapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCertifDiscapacidad.setBounds(25, 229, 140, 28);
		getContentPane().add(lblCertifDiscapacidad);

		comboBoxCertifDiscapacidad = new JComboBox<>();
		comboBoxCertifDiscapacidad
				.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No", "No sabe", "Tramitando" }));
		comboBoxCertifDiscapacidad.setSelectedIndex(0);
		comboBoxCertifDiscapacidad.setBounds(175, 234, 163, 21);
		getContentPane().add(comboBoxCertifDiscapacidad);

		JLabel lblEuskera = new JLabel("Euskera:");
		lblEuskera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEuskera.setBounds(56, 267, 78, 28);
		getContentPane().add(lblEuskera);

		comboBoxEuskera = new JComboBox<>();
		comboBoxEuskera.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxEuskera.setSelectedIndex(0);
		comboBoxEuskera.setBounds(175, 272, 163, 21);
		getContentPane().add(comboBoxEuskera);

		JLabel lblIngles = new JLabel("Ingles:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngles.setBounds(56, 305, 78, 28);
		getContentPane().add(lblIngles);

		comboBoxIngles = new JComboBox<>();
		comboBoxIngles.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxIngles.setSelectedIndex(0);
		comboBoxIngles.setBounds(175, 310, 163, 21);
		getContentPane().add(comboBoxIngles);

		JLabel lblOtrosIdiomas = new JLabel("Otros idiomas:");
		lblOtrosIdiomas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtrosIdiomas.setBounds(25, 343, 126, 31);
		getContentPane().add(lblOtrosIdiomas);

		textFieldOtrosIdiomas = new JTextField();
		textFieldOtrosIdiomas.setColumns(10);
		textFieldOtrosIdiomas.setBounds(175, 350, 163, 19);
		getContentPane().add(textFieldOtrosIdiomas);

		JLabel lblLocalidad = new JLabel("Localidad:");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(14, 385, 163, 31);
		getContentPane().add(lblLocalidad);

		comboBoxLocalidad = new JComboBox<>();
		comboBoxLocalidad.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxLocalidad.setSelectedIndex(0);
		comboBoxLocalidad.setBounds(175, 389, 163, 21);
		getContentPane().add(comboBoxLocalidad);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad:");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(42, 426, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(175, 432, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(369, 418, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(359, 446, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(500, 418, 230, 61);
		getContentPane().add(textAreaObservaciones);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(749, 424, 151, 55);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void loadPersona() {
		StringBuilder infoPersona = new StringBuilder("");
		String formacion = "", especialidad = "", sectorInteres = "", discapacidad = "", euskera = "", ingles = "",
				localidad = "", accesibilidad = "";

		textareaPersona.removeAll();
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

		// Especialidades, SectorInteres [TBD]

		switch (persona.getCerfificadoDiscapacidad()) {
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

		if (persona.getEuskera() != null) {
			switch (persona.getEuskera()) {
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

			if (persona.getIngles() != null) {
				switch (persona.getIngles()) {
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

			switch (persona.getLocalidad()) {
			// TBD

			default:
				System.out.println("Tipo invalido");
			}
		}

		switch (persona.getAccesibilidad()) {
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

		infoPersona.append("Nombre: " + persona.getNombre()).append("\n");
		infoPersona.append("Apoyo: " + persona.getApoyo()).append("\n");
		infoPersona.append("Formacion: " + formacion).append("\n");
		infoPersona.append("Especialidad: " + especialidad).append("\n");
		infoPersona.append("Sector de interes: " + sectorInteres).append("\n");
		infoPersona.append("CV Link: " + persona.getCvLink()).append("\n");
		infoPersona.append("Certificado de discapacidad: " + discapacidad).append("\n");
		if (persona.getOtrosIdiomas() != null) {
			infoPersona.append("Euskera: " + euskera).append("\n");
		} else {
			infoPersona.append("Euskera: ---").append("\n");
		}

		if (persona.getOtrosIdiomas() != null) {
			infoPersona.append("Ingles: " + ingles).append("\n");
		} else {
			infoPersona.append("Ingles: ---").append("\n");
		}

		if (persona.getOtrosIdiomas() != null) {
			infoPersona.append("Otros idiomas: " + persona.getOtrosIdiomas()).append("\n");
		} else {
			infoPersona.append("Otros idiomas: ---").append("\n");
		}

		infoPersona.append("Localidad: " + localidad).append("\n");
		infoPersona.append("Accesibilidad: " + accesibilidad).append("\n");
		if (persona.getOtrosIdiomas() != null) {
			infoPersona.append("Observaciones: " + persona.getObservaciones());
		} else {
			infoPersona.append("Observaciones: ---");
		}
		textareaPersona.setText(infoPersona.toString());
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
		}
		return error;
	}

	public boolean addError() { // ErrorID: 1
		boolean check = false;
		StringBuilder infoError = new StringBuilder("Un error ha occurrido en ");

		if (!textFieldApoyo.getText().isBlank()) {
			check = cont.modificarApoyo(textFieldApoyo.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Apoyo");
			}
		}

		if (!comboBoxFormacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarFormacion(comboBoxFormacion.getItemAt(comboBoxFormacion.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Formacion");
			}
		}

		if (!comboBoxEspecialidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarEspecialidad(comboBoxEspecialidad.getItemAt(comboBoxEspecialidad.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Especialidad");
			}
		}

		if (!comboBoxSectorInteres.getSelectedItem().equals("---") && check) {
			check = cont.modificarSectorInteres(
					comboBoxSectorInteres.getItemAt(comboBoxSectorInteres.getSelectedIndex()), persona.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textFieldCVLink.getText().isBlank()) {
			check = cont.modificarCVLink(textFieldCVLink.getText(), persona.getNombre());
			if (!check) {
				infoError.append("CV Link");
			}
		}

		if (!comboBoxCertifDiscapacidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarDiscapacidad(
					comboBoxCertifDiscapacidad.getItemAt(comboBoxCertifDiscapacidad.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Certificado de discapacidad");
			}
		}

		if (!comboBoxEuskera.getSelectedItem().equals("---") && check) {
			check = cont.modificarEuskera(comboBoxEuskera.getItemAt(comboBoxEuskera.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Euskera");
			}
		}

		if (!comboBoxIngles.getSelectedItem().equals("---") && check) {
			check = cont.modificarIngles(comboBoxIngles.getItemAt(comboBoxIngles.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Ingles");
			}
		}

		if (!textFieldOtrosIdiomas.getText().isBlank()) {
			check = cont.modificarOtrosIdiomas(textFieldOtrosIdiomas.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Otros idiomas");
			}
		}

		if (!comboBoxLocalidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarLocalidad(comboBoxLocalidad.getItemAt(comboBoxLocalidad.getSelectedIndex()),
					persona.getNombre());
			if (!check) {
				infoError.append("Localidad");
			}
		}

		if (!comboBoxAccesibilidad.getSelectedItem().equals("---") && check) {
			check = cont.modificarAccesibilidad(
					comboBoxAccesibilidad.getItemAt(comboBoxAccesibilidad.getSelectedIndex()), persona.getNombre());
			if (!check) {
				infoError.append("Sector de interes");
			}
		}

		if (!textAreaObservaciones.getText().isBlank()) {
			check = cont.modificarPersonaObservaciones(textAreaObservaciones.getText(), persona.getNombre());
			if (!check) {
				infoError.append("Observaciones");
			}
		}

		if (!check) {
			infoError.append(" al intentar actualizar la persona.");
			JOptionPane.showMessageDialog(null, infoError.toString()
					+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion de la persona.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}

		return check;
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaObservaciones.getText().length() > 500) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			if (errorChecks(2)) {
				JOptionPane.showMessageDialog(null,
						"Hay mas caracteres que el limite de caracteres en el campo de observaciones.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (!errorChecks(1)) {
					persona = cont.getPersona(persona.getNombre());
					loadPersona();
				} else {
					JOptionPane.showMessageDialog(null, "La persona ha sido modificada correctamente."
							+ "\nLa informacion en el recuadro de infomacion de la persona se acualizara para reflejar los cambios.");
					persona = cont.getPersona(persona.getNombre());
					loadPersona();
				}
			}
		}
	}
}
