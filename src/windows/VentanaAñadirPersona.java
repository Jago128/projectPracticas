package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;

public class VentanaAñadirPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JButton btnAñadir;

	private JTextField textFieldApoyo;

	private JComboBox<String> comboBoxFormacion;

	private JComboBox<String> comboBoxEspecialidad;

	private JComboBox<String> comboBoxSectorInteres;

	private JTextField textFieldCVLink;

	private JComboBox<String> comboBoxCertifDiscapacidad;

	private JComboBox<String> comboBoxEuskera;

	private JComboBox<String> comboBoxIngles;

	private JTextField textFieldOtrosIdiomas;

	private JComboBox<String> comboBoxLocalidad;

	private JComboBox<String> comboBoxAccesibilidad;

	private JTextArea textAreaObservaciones;
	private JTextField textFieldNom;

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
		lblObligatorio.setBounds(20, 10, 721, 19);
		getContentPane().add(lblObligatorio);
		
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
		comboBoxFormacion.setSelectedIndex(0);
		comboBoxFormacion.setBounds(170, 80, 163, 21);
		getContentPane().add(comboBoxFormacion);

		JLabel lblEspecialidad = new JLabel("Especialidad: *");
		lblEspecialidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEspecialidad.setBounds(379, 77, 108, 28);
		getContentPane().add(lblEspecialidad);

		comboBoxEspecialidad = new JComboBox<>();
		comboBoxEspecialidad.setModel(new DefaultComboBoxModel<>(new String[] {}));
		comboBoxEspecialidad.setSelectedIndex(0);
		comboBoxEspecialidad.setBounds(497, 82, 163, 21);
		getContentPane().add(comboBoxEspecialidad);

		JLabel lblSectorInteres = new JLabel("Sector interes: *");
		lblSectorInteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectorInteres.setBounds(41, 111, 119, 28);
		getContentPane().add(lblSectorInteres);

		comboBoxSectorInteres = new JComboBox<>();
		comboBoxSectorInteres.setModel(new DefaultComboBoxModel<>(new String[] {}));
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
		comboBoxCertifDiscapacidad.setSelectedIndex(0);
		comboBoxCertifDiscapacidad.setBounds(170, 154, 163, 21);
		getContentPane().add(comboBoxCertifDiscapacidad);

		JLabel lblEuskera = new JLabel("Euskera:");
		lblEuskera.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEuskera.setBounds(378, 153, 78, 28);
		getContentPane().add(lblEuskera);

		comboBoxEuskera = new JComboBox<>();
		comboBoxEuskera.setSelectedIndex(0);
		comboBoxEuskera.setBounds(497, 158, 163, 21);
		getContentPane().add(comboBoxEuskera);

		JLabel lblIngles = new JLabel("Ingles:");
		lblIngles.setHorizontalAlignment(SwingConstants.CENTER);
		lblIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIngles.setBounds(51, 187, 78, 28);
		getContentPane().add(lblIngles);

		comboBoxIngles = new JComboBox<>();
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
		comboBoxLocalidad.setModel(new DefaultComboBoxModel<>(new String[] {}));
		comboBoxLocalidad.setSelectedIndex(0);
		comboBoxLocalidad.setBounds(170, 231, 163, 21);
		getContentPane().add(comboBoxLocalidad);

		JLabel lblAccesibilidad = new JLabel("Accesibilidad: *");
		lblAccesibilidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAccesibilidad.setBounds(364, 232, 120, 31);
		getContentPane().add(lblAccesibilidad);

		comboBoxAccesibilidad = new JComboBox<>();
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
		
		JLabel lblNom = new JLabel("Nombre: *");
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNom.setBounds(51, 39, 103, 28);
		getContentPane().add(lblNom);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(170, 45, 163, 19);
		getContentPane().add(textFieldNom);
		btnAñadir.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
