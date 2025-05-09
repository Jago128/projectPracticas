package windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.LoginController;
import model.Persona;

public class VentanaModificarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private LoginController cont;
	private Persona persona;
	private JTextArea textareaEmpresa, textAreaObservaciones, textAreaInfoUltimoCont;
	private JTextField textFieldDatosContacto, textFieldContactoEmpresa, textFieldPersonaContacto, textFieldContacto1,
	textFieldContacto2, textFieldContacto3, textFieldContacto4, textFieldFechaResolucion;
	private JComboBox<String> comboBoxEstado, comboBoxResultadoUltimoContacto, comboBoxResultadoFinal;
	private JButton btnModificar;
	private JLabel lblDatosEmpresa, lblFechaFormato;

	public VentanaModificarPersona(JDialog parent, LoginController cont, Persona persona) {
		super(parent, true);
		this.cont = cont;
		this.persona = persona;

		setResizable(false);
		setTitle("Modificar empresa");
		setBounds(100, 100, 920, 530);
		getContentPane().setLayout(null);

		textareaEmpresa = new JTextArea();
		textareaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textareaEmpresa.setText("");
		textareaEmpresa.setBackground(new Color(255, 255, 255));
		textareaEmpresa.setLineWrap(true);
		textareaEmpresa.setEditable(false);
		textareaEmpresa.setBounds(388, 37, 506, 299);
		getContentPane().add(textareaEmpresa);

		JLabel lblDatosContacto = new JLabel("Datos de contacto:");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(21, 58, 140, 28);
		getContentPane().add(lblDatosContacto);

		textFieldDatosContacto = new JTextField();
		textFieldDatosContacto.setColumns(10);
		textFieldDatosContacto.setBounds(187, 64, 163, 19);
		getContentPane().add(textFieldDatosContacto);

		JLabel lblContactoEmpresa = new JLabel("Contactos en la empresa:");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(10, 96, 151, 28);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(187, 102, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblPersonaContacto = new JLabel("Persona de contacto:");
		lblPersonaContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaContacto.setBounds(21, 134, 140, 28);
		getContentPane().add(lblPersonaContacto);

		textFieldPersonaContacto = new JTextField();
		textFieldPersonaContacto.setColumns(10);
		textFieldPersonaContacto.setBounds(187, 140, 163, 19);
		getContentPane().add(textFieldPersonaContacto);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(42, 174, 119, 28);
		getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado" }));
		comboBoxEstado.setSelectedIndex(0);
		comboBoxEstado.setBounds(187, 179, 163, 21);
		getContentPane().add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("Contacto 1:");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(77, 212, 78, 28);
		getContentPane().add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(168, 218, 163, 19);
		getContentPane().add(textFieldContacto1);

		JLabel lblFecha_1 = new JLabel("(Fecha)");
		lblFecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_1.setBounds(21, 211, 67, 31);
		getContentPane().add(lblFecha_1);

		JLabel lblContacto2 = new JLabel("Contacto 2:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(77, 250, 78, 28);
		getContentPane().add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(168, 256, 163, 19);
		getContentPane().add(textFieldContacto2);

		JLabel lblFecha_2 = new JLabel("(Fecha)");
		lblFecha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_2.setBounds(21, 247, 67, 31);
		getContentPane().add(lblFecha_2);

		JLabel lblContacto3 = new JLabel("Contacto 3:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(77, 288, 78, 28);
		getContentPane().add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(168, 294, 163, 19);
		getContentPane().add(textFieldContacto3);

		JLabel lblFecha_3 = new JLabel("(Fecha)");
		lblFecha_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_3.setBounds(21, 288, 67, 31);
		getContentPane().add(lblFecha_3);

		JLabel lblContacto4 = new JLabel("Contacto 4:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(77, 326, 78, 28);
		getContentPane().add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(168, 323, 163, 19);
		getContentPane().add(textFieldContacto4);

		JLabel lblFecha_4 = new JLabel("(Fecha)");
		lblFecha_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_4.setBounds(27, 325, 61, 31);
		getContentPane().add(lblFecha_4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(370, 348, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 500 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(360, 376, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(496, 346, 230, 61);
		getContentPane().add(textAreaObservaciones);

		JLabel lblResultadoUltimoCont = new JLabel("Resultado ultimo contacto:");
		lblResultadoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoUltimoCont.setBounds(21, 364, 162, 31);
		getContentPane().add(lblResultadoUltimoCont);

		comboBoxResultadoUltimoContacto = new JComboBox<>();
		comboBoxResultadoUltimoContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Comunicacion sin respuesta", "Nos pospone la respuesta", "Programada reunion",
						"Respuesta no concluyente", "Inicio valoracion oferta" }));
		comboBoxResultadoUltimoContacto.setSelectedIndex(0);
		comboBoxResultadoUltimoContacto.setBounds(187, 366, 163, 21);
		getContentPane().add(comboBoxResultadoUltimoContacto);

		JLabel lblInfoUltimoCont = new JLabel("Informacion ultimo contacto:");
		lblInfoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoUltimoCont.setBounds(352, 417, 177, 31);
		getContentPane().add(lblInfoUltimoCont);

		JLabel lblResultadoFinal = new JLabel("Resultado final prospeccion:");
		lblResultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoFinal.setBounds(14, 406, 163, 31);
		getContentPane().add(lblResultadoFinal);

		comboBoxResultadoFinal = new JComboBox<String>();
		comboBoxResultadoFinal.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Oferta de empleo",
				"Convenio de colaboracion", "Medidas alternativas", "Relacion concluida", "Relacion pospuesta" }));
		comboBoxResultadoFinal.setSelectedIndex(0);
		comboBoxResultadoFinal.setBounds(187, 412, 163, 21);
		getContentPane().add(comboBoxResultadoFinal);

		JLabel lblFechaResolucion = new JLabel("Fecha resolucion:");
		lblFechaResolucion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaResolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaResolucion.setBounds(42, 447, 120, 31);
		getContentPane().add(lblFechaResolucion);

		textFieldFechaResolucion = new JTextField();
		textFieldFechaResolucion.setColumns(10);
		textFieldFechaResolucion.setBounds(175, 454, 163, 19);
		getContentPane().add(textFieldFechaResolucion);

		textAreaInfoUltimoCont = new JTextArea();
		textAreaInfoUltimoCont.setLineWrap(true);
		textAreaInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoUltimoCont.setBounds(539, 417, 230, 61);
		getContentPane().add(textAreaInfoUltimoCont);

		JLabel lblmaxChars_1 = new JLabel("(Max 500 caracteres)");
		lblmaxChars_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxChars_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxChars_1.setBounds(375, 447, 126, 31);
		getContentPane().add(lblmaxChars_1);

		lblDatosEmpresa = new JLabel("Informacion de la empresa seleccionada:");
		lblDatosEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosEmpresa.setBounds(378, 10, 506, 28);
		getContentPane().add(lblDatosEmpresa);

		lblFechaFormato = new JLabel("Formato de fechas: AAAA-MM-DD");
		lblFechaFormato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFormato.setBounds(42, 38, 275, 16);
		getContentPane().add(lblFechaFormato);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(10, 7, 377, 28);
		getContentPane().add(lblNota);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(745, 346, 151, 55);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
