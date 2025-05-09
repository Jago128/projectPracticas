package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;

public class VentanaAñadirPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldNombre, textFieldPuesto, textFieldDatosContacto, textFieldContactoEmpresa,
			textFieldContacto1, textFieldContacto2, textFieldContacto3, textFieldContacto4, textFieldPersonaContacto,
			textFieldFechaResolucion;
	private JTextArea textAreaObservaciones, textAreaInfoUltimoCont;
	private JComboBox<String> comboBoxSector, comboBoxResultadoUltimoContacto, comboBoxEstado, comboBoxResultadoFinal;
	private JButton btnAñadir;

	public VentanaAñadirPersona(JDialog parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 800, 480);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel(
				"Los campos con * son obligatorias. Formato de fechas: AAAA-MM-DD (excepto en campos que no sean de fecha)");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(20, 10, 721, 19);
		getContentPane().add(lblObligatorio);

		JLabel lblNombre = new JLabel("Nombre: *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(20, 28, 89, 31);
		getContentPane().add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(121, 35, 163, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblSector = new JLabel("Sector: *");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(30, 69, 80, 31);
		getContentPane().add(lblSector);

		comboBoxSector = new JComboBox<>();
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSector.setSelectedIndex(0);
		comboBoxSector.setBounds(114, 75, 251, 21);
		getContentPane().add(comboBoxSector);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(33, 104, 75, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(121, 111, 163, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblDatosContacto = new JLabel("Datos de contacto: *");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(20, 145, 129, 31);
		getContentPane().add(lblDatosContacto);

		textFieldDatosContacto = new JTextField();
		textFieldDatosContacto.setColumns(10);
		textFieldDatosContacto.setBounds(166, 152, 163, 19);
		getContentPane().add(textFieldDatosContacto);

		JLabel lblContactoEmpresa = new JLabel("Contacto en la empresa: *");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(16, 187, 147, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(181, 194, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblPersonaContacto = new JLabel("Persona de contacto: *");
		lblPersonaContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaContacto.setBounds(10, 230, 153, 31);
		getContentPane().add(lblPersonaContacto);

		textFieldPersonaContacto = new JTextField();
		textFieldPersonaContacto.setColumns(10);
		textFieldPersonaContacto.setBounds(181, 237, 163, 19);
		getContentPane().add(textFieldPersonaContacto);

		JLabel lblEstado = new JLabel("Estado: *");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(60, 271, 89, 31);
		getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado" }));
		comboBoxEstado.setSelectedIndex(0);
		comboBoxEstado.setBounds(166, 277, 178, 21);
		getContentPane().add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("1. contacto: *");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(375, 28, 95, 31);
		getContentPane().add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(480, 35, 163, 19);
		getContentPane().add(textFieldContacto1);

		JLabel lblFecha = new JLabel("(Fecha)");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(653, 28, 88, 31);
		getContentPane().add(lblFecha);

		JLabel lblContacto2 = new JLabel("2. contacto:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(375, 69, 88, 31);
		getContentPane().add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(480, 76, 163, 19);
		getContentPane().add(textFieldContacto2);

		JLabel lblContacto3 = new JLabel("3. contacto:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(375, 104, 88, 31);
		getContentPane().add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(480, 111, 163, 19);
		getContentPane().add(textFieldContacto3);

		JLabel lblContacto4 = new JLabel("4. contacto:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(375, 145, 85, 31);
		getContentPane().add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(480, 152, 163, 19);
		getContentPane().add(textFieldContacto4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(385, 187, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(375, 215, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setBounds(511, 193, 230, 61);
		getContentPane().add(textAreaObservaciones);

		JLabel lblResultadoUltimoCont = new JLabel("Resultado ultimo contacto:");
		lblResultadoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoUltimoCont.setBounds(395, 348, 162, 31);
		getContentPane().add(lblResultadoUltimoCont);

		comboBoxResultadoUltimoContacto = new JComboBox<>();
		comboBoxResultadoUltimoContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Comunicacion sin respuesta", "Nos pospone la respuesta", "Programada reunion",
						"Respuesta no concluyente", "Inicio valoracion oferta" }));
		comboBoxResultadoUltimoContacto.setSelectedIndex(0);
		comboBoxResultadoUltimoContacto.setBounds(564, 354, 198, 21);
		getContentPane().add(comboBoxResultadoUltimoContacto);

		JLabel lblInfoUltimoCont = new JLabel("Informacion ultimo contacto:");
		lblInfoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoUltimoCont.setBounds(362, 277, 177, 31);
		getContentPane().add(lblInfoUltimoCont);

		JLabel lblResultadoFinal = new JLabel("Resultado final prospeccion:");
		lblResultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoFinal.setBounds(10, 348, 163, 31);
		getContentPane().add(lblResultadoFinal);

		comboBoxResultadoFinal = new JComboBox<String>();
		comboBoxResultadoFinal.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Oferta de empleo",
				"Convenio de colaboracion", "Medidas alternativas", "Relacion concluida", "Relacion pospuesta" }));
		comboBoxResultadoFinal.setSelectedIndex(0);
		comboBoxResultadoFinal.setBounds(181, 354, 190, 21);
		getContentPane().add(comboBoxResultadoFinal);

		JLabel lblFechaResolucion = new JLabel("Fecha resolucion:");
		lblFechaResolucion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaResolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaResolucion.setBounds(33, 312, 120, 31);
		getContentPane().add(lblFechaResolucion);

		JLabel lblFecha_1 = new JLabel("(Fecha)");
		lblFecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_1.setBounds(653, 69, 88, 31);
		getContentPane().add(lblFecha_1);

		JLabel lblFecha_2 = new JLabel("(Fecha)");
		lblFecha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_2.setBounds(653, 104, 88, 31);
		getContentPane().add(lblFecha_2);

		JLabel lblFecha_3 = new JLabel("(Fecha)");
		lblFecha_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_3.setBounds(653, 145, 88, 31);
		getContentPane().add(lblFecha_3);

		textFieldFechaResolucion = new JTextField();
		textFieldFechaResolucion.setColumns(10);
		textFieldFechaResolucion.setBounds(166, 319, 163, 19);
		getContentPane().add(textFieldFechaResolucion);

		textAreaInfoUltimoCont = new JTextArea();
		textAreaInfoUltimoCont.setLineWrap(true);
		textAreaInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoUltimoCont.setBounds(549, 277, 230, 61);
		getContentPane().add(textAreaInfoUltimoCont);

		JLabel lblmaxChars_1 = new JLabel("(Max 500 caracteres)");
		lblmaxChars_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxChars_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxChars_1.setBounds(385, 312, 126, 31);
		getContentPane().add(lblmaxChars_1);

		btnAñadir = new JButton("Añadir empresa");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(215, 385, 380, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}

}
