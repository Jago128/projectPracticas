package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import model.Persona;

public class VentanaAñadirPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldApoyo, textFieldCVLink, textFieldOtrosIdiomas, textFieldNom;
	private JComboBox<String> comboBoxFormacion, comboBoxEspecialidad, comboBoxSectorInteres,
			comboBoxCertifDiscapacidad, comboBoxEuskera, comboBoxIngles, comboBoxLocalidad, comboBoxAccesibilidad;
	private JTextArea textAreaObservaciones;
	private JButton btnAñadir;

	public VentanaAñadirPersona(JDialog parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 690, 430);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(215, 10, 241, 19);
		getContentPane().add(lblObligatorio);

		JLabel lblNom = new JLabel("Nombre: *");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(51, 39, 103, 28);
		getContentPane().add(lblNom);

		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(170, 45, 163, 19);
		getContentPane().add(textFieldNom);

		JLabel lblApoyo = new JLabel("Apoyo: *");
		lblApoyo.setHorizontalAlignment(SwingConstants.CENTER);
		lblApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApoyo.setBounds(390, 39, 97, 28);
		getContentPane().add(lblApoyo);

		textFieldApoyo = new JTextField();
		textFieldApoyo.setColumns(10);
		textFieldApoyo.setBounds(497, 45, 163, 19);
		getContentPane().add(textFieldApoyo);

		JLabel lblFormacion = new JLabel("Formacion: *");
		lblFormacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacion.setBounds(21, 77, 151, 28);
		getContentPane().add(lblFormacion);

		comboBoxFormacion = new JComboBox<>();
		comboBoxFormacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO", "EPA",
				"FP Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(170, 80, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad: *");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(379, 77, 108, 28);
		getContentPane().add(lblEspecialidad);

		comboBoxEspecialidad = new JComboBox<>();
		comboBoxEspecialidad.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxEspecialidad.setSelectedIndex(0);
		comboBoxEspecialidad.setBounds(497, 82, 163, 21);
		getContentPane().add(comboBoxEspecialidad);

		JLabel lblSectorInteres = new JLabel("Sector de interes: *");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(31, 111, 129, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxSectorInteres.setSelectedIndex(0);
		comboBoxSectorInteres.setBounds(170, 116, 163, 21);
		getContentPane().add(comboBoxSectorInteres);

		JLabel lblCVLink = new JLabel("CV Link:");
		lblCVLink.setHorizontalAlignment(SwingConstants.CENTER);
		lblCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCVLink.setBounds(378, 115, 78, 28);
		getContentPane().add(lblCVLink);

		textFieldCVLink = new JTextField();
		textFieldCVLink.setColumns(10);
		textFieldCVLink.setBounds(497, 121, 163, 19);
		getContentPane().add(textFieldCVLink);

		JLabel lblCertifDiscapacidad = new JLabel("Certificado discapacidad: *");
		lblCertifDiscapacidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCertifDiscapacidad.setBounds(10, 149, 152, 28);
		getContentPane().add(lblCertifDiscapacidad);

		comboBoxCertifDiscapacidad = new JComboBox<>();
		comboBoxCertifDiscapacidad
				.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "No", "No sabe", "Tramitando" }));
		comboBoxCertifDiscapacidad.setSelectedIndex(0);
		comboBoxCertifDiscapacidad.setBounds(170, 154, 163, 21);
		getContentPane().add(comboBoxCertifDiscapacidad);

		JLabel lblEuskera = new JLabel("Euskera:");
		lblEuskera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEuskera.setBounds(378, 153, 78, 28);
		getContentPane().add(lblEuskera);

		comboBoxEuskera = new JComboBox<>();
		comboBoxEuskera.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxEuskera.setSelectedIndex(0);
		comboBoxEuskera.setBounds(497, 158, 163, 21);
		getContentPane().add(comboBoxEuskera);

		JLabel lblIngles = new JLabel("Ingles:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngles.setBounds(51, 187, 78, 28);
		getContentPane().add(lblIngles);

		comboBoxIngles = new JComboBox<>();
		comboBoxIngles.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "A1", "A2", "B1", "B2", "C1", "C2", "Conocimiento, pero sin acreditar" }));
		comboBoxIngles.setSelectedIndex(0);
		comboBoxIngles.setBounds(170, 192, 163, 21);
		getContentPane().add(comboBoxIngles);

		JLabel lblOtrosIdiomas = new JLabel("Otros idiomas:");
		lblOtrosIdiomas.setHorizontalAlignment(SwingConstants.CENTER);
		lblOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOtrosIdiomas.setBounds(347, 191, 126, 31);
		getContentPane().add(lblOtrosIdiomas);

		textFieldOtrosIdiomas = new JTextField();
		textFieldOtrosIdiomas.setColumns(10);
		textFieldOtrosIdiomas.setBounds(497, 198, 163, 19);
		getContentPane().add(textFieldOtrosIdiomas);

		JLabel lblLocalidad = new JLabel("Localidad: *");
		lblLocalidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLocalidad.setBounds(37, 225, 120, 31);
		getContentPane().add(lblLocalidad);

		comboBoxLocalidad = new JComboBox<>();
		comboBoxLocalidad.setModel(new DefaultComboBoxModel<>(new String[] { "---" }));
		comboBoxLocalidad.setSelectedIndex(0);
		comboBoxLocalidad.setBounds(170, 231, 163, 21);
		getContentPane().add(comboBoxLocalidad);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad: *");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(364, 232, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
		comboBoxAccesibilidad.setModel(
				new DefaultComboBoxModel<>(new String[] { "---", "Carnet + coche", "Carnet", "Transporte publico" }));
		comboBoxAccesibilidad.setSelectedIndex(0);
		comboBoxAccesibilidad.setBounds(497, 238, 163, 21);
		getContentPane().add(comboBoxAccesibilidad);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(172, 275, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(162, 303, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(303, 275, 230, 61);
		getContentPane().add(textAreaObservaciones);

		btnAñadir = new JButton("Añadir persona");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(153, 346, 380, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	public boolean errorChecks(int errorID) {
		boolean error = false;

		switch (errorID) {
		case 1:
			addError();
			break;

		case 2:
			error = lengthCheck();
			break;
		}
		return error;
	}

	public void addError() { // ErrorID: 1
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la persona.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaObservaciones.getText().length() > 500) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldNom.getText().isBlank() || textFieldApoyo.getText().isBlank()
					|| comboBoxFormacion.getSelectedItem().equals("---")
					|| comboBoxEspecialidad.getSelectedItem().equals("---")
					|| comboBoxSectorInteres.getSelectedItem().equals("---")
					|| comboBoxCertifDiscapacidad.getSelectedItem().equals("---")
					|| comboBoxLocalidad.getSelectedItem().equals("---")
					|| comboBoxAccesibilidad.getSelectedItem().equals("---")) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarPersona(textFieldNom.getText())) {
				JOptionPane.showMessageDialog(null, "Ya existe una persona con el mismo nombre en la base de datos.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				if (errorChecks(2)) {
					JOptionPane.showMessageDialog(null,
							"Hay mas caracteres que el limite de caracteres en el campo de observaciones.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int result = 0;
					Persona persona = new Persona();

					persona.setNombre(textFieldNom.getText());
					persona.setApoyo(textFieldApoyo.getText());
					switch ((String) comboBoxFormacion.getSelectedItem()) {
					case "AT":
						persona.setFormacion(Formacion.AT);
						break;

					case "Primaria":
						persona.setFormacion(Formacion.PRIMARIA);
						break;

					case "ESO":
						persona.setFormacion(Formacion.ESO);
						break;

					case "EPA":
						persona.setFormacion(Formacion.EPA);
						break;

					case "FP Basica":
						persona.setFormacion(Formacion.FP_BASICA);
						break;

					case "GM":
						persona.setFormacion(Formacion.GM);
						break;

					case "Bachillerato":
						persona.setFormacion(Formacion.BACHILLERATO);
						break;

					case "GS":
						persona.setFormacion(Formacion.GS);
						break;

					case "Universidad":
						persona.setFormacion(Formacion.UNIVERSIDAD);
						break;

					case "Master":
						persona.setFormacion(Formacion.MASTER);
						break;

					case "Doctorado":
						persona.setFormacion(Formacion.DOCTORADO);
						break;
					}

					// Especialidad

					/*
					 * switch ((String) comboBoxSectorInteres.getSelectedItem()) {
					 * 
					 * }
					 */

					if (!textFieldCVLink.getText().isBlank()) {
						persona.setCvLink(textFieldCVLink.getText());
					}

					switch ((String) comboBoxCertifDiscapacidad.getSelectedItem()) {
					case "Si":
						persona.setCerfificadoDiscapacidad(Discapacidad.SI);
						break;
						
					case "No":
						persona.setCerfificadoDiscapacidad(Discapacidad.NO);
						break;
						
					case "No sabe":
						persona.setCerfificadoDiscapacidad(Discapacidad.NO_SABE);
						break;
						
					case "Tramitando":
						persona.setCerfificadoDiscapacidad(Discapacidad.TRAMITANDO);
						break;
					}

					if (!comboBoxEuskera.getSelectedItem().equals("---")) {
						switch ((String) comboBoxEuskera.getSelectedItem()) {
						case "A1":
							persona.setEuskera(Euskera.A1);
							break;
							
						case "A2":
							persona.setEuskera(Euskera.A2);
							break;
							
						case "B1":
							persona.setEuskera(Euskera.B1);
							break;
							
						case "B2":
							persona.setEuskera(Euskera.B2);
							break;
							
						case "C1":
							persona.setEuskera(Euskera.C1);
							break;
							
						case "C2":
							persona.setEuskera(Euskera.C2);
							break;
							
						case "Conocimiento, pero sin acreditar":
							persona.setEuskera(Euskera.CONOCIMIENTO_NOACREDITADO);
							break;
						}
					}

					if (!comboBoxIngles.getSelectedItem().equals("---")) {
						switch ((String) comboBoxIngles.getSelectedItem()) {
						case "A1":
							persona.setIngles(Ingles.A1);
							break;
							
						case "A2":
							persona.setIngles(Ingles.A2);
							break;
							
						case "B1":
							persona.setIngles(Ingles.B1);
							break;
							
						case "B2":
							persona.setIngles(Ingles.B2);
							break;
							
						case "C1":
							persona.setIngles(Ingles.C1);
							break;
							
						case "C2":
							persona.setIngles(Ingles.C2);
							break;
							
						case "Conocimiento, pero sin acreditar":
							persona.setIngles(Ingles.CONOCIMIENTO_NOACREDITADO);
							break;
						}
					}

					if (!textFieldOtrosIdiomas.getText().isBlank()) {
						persona.setOtrosIdiomas(textFieldOtrosIdiomas.getText());
					}

					switch ((String) comboBoxLocalidad.getSelectedItem()) {
						// TBD
					}

					switch ((String) comboBoxAccesibilidad.getSelectedItem()) {
					case "Carnet + coche":
						persona.setAccesibilidad(Accesibilidad.CARNET_COCHE);
						break;
						
					case "Carnet":
						persona.setAccesibilidad(Accesibilidad.CARNET);
						break;
						
					case "Transporte publico":
						persona.setAccesibilidad(Accesibilidad.TRANSPORTE_PUBLICO);
						break;
					}

					if (cont.añadirPersona(persona)) {
						result = JOptionPane.showConfirmDialog(null,
								"La empresa ha sido añadida correctamente. Quiere añadir mas empresas?", "",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							textAreaObservaciones.setText("");
						}
					} else {
						errorChecks(1);
					}
				}
			}
		}
	}
}
