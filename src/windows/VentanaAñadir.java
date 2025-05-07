package windows;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.*;
import java.time.temporal.ChronoField;
import java.util.regex.*;

import javax.swing.*;

import controller.LoginController;
import exceptions.EmailFormatException;
import model.*;

public class VentanaAñadir extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldNombre, textFieldPuesto, textFieldDatosContacto, textFieldContactoEmpresa,
			textFieldContacto1, textFieldContacto2, textFieldContacto3, textFieldContacto4, textFieldPersonaContacto;
	private JTextArea textAreaObservaciones;
	private JComboBox<String> comboBoxSector, comboBoxEstado;
	private JButton btnAñadir;

	public VentanaAñadir(JFrame parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 800, 660);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("* Obligatorio. Formato de fechas: AAAA-MM-DD");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(189, 10, 366, 19);
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
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] {"", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida"}));
		comboBoxSector.setBounds(121, 74, 163, 21);
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
		lblEstado.setBounds(20, 271, 89, 31);
		getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] {"", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado"}));
		comboBoxEstado.setBounds(108, 277, 163, 21);
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

		JLabel lblMaxChars = new JLabel("(Max 100 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(375, 215, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setBounds(511, 193, 230, 61);
		getContentPane().add(textAreaObservaciones);

		btnAñadir = new JButton("Añadir empresa");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(107, 569, 147, 37);
		getContentPane().add(btnAñadir);
		
		JLabel lblEstado_1 = new JLabel("Estado: *");
		lblEstado_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado_1.setBounds(16, 312, 89, 31);
		getContentPane().add(lblEstado_1);
		
		JComboBox<String> comboBoxEstado_1 = new JComboBox<String>();
		comboBoxEstado_1.setBounds(104, 318, 163, 21);
		getContentPane().add(comboBoxEstado_1);
		
		JLabel lblEstado_2 = new JLabel("Estado: *");
		lblEstado_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado_2.setBounds(375, 271, 89, 31);
		getContentPane().add(lblEstado_2);
		
		JComboBox<String> comboBoxEstado_2 = new JComboBox<String>();
		comboBoxEstado_2.setBounds(463, 277, 163, 21);
		getContentPane().add(comboBoxEstado_2);
		btnAñadir.addActionListener(this);
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{3,})$");
		Matcher matcher = modelo.matcher(email);
		if (!matcher.matches()) {
			throw new EmailFormatException();
		}
	}

	public boolean dateFormatErrorCheck() {
		boolean error = false;
		DateTimeFormatter format = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4).appendLiteral('-')
				.appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('-')
				.appendValue(ChronoField.DAY_OF_MONTH).toFormatter();
		try {
			LocalDate.parse(textFieldContacto1.getText(), format);
			if (!textFieldContacto2.getText().isBlank()) {
				LocalDate.parse(textFieldContacto2.getText(), format);
			}

			if (!textFieldContacto3.getText().isBlank()) {
				LocalDate.parse(textFieldContacto3.getText(), format);
			}

			if (!textFieldContacto4.getText().isBlank()) {
				LocalDate.parse(textFieldContacto4.getText(), format);
			}
		} catch (DateTimeParseException e) {
			error = true;
		}
		return error;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAñadir) {
			if (textFieldNombre.getText().isBlank() || comboBoxSector.getSelectedIndex() == -1
					|| textFieldDatosContacto.getText().isBlank() || textFieldContactoEmpresa.getText().isBlank()
					|| textFieldPersonaContacto.getText().isBlank() || comboBoxEstado.getSelectedIndex() == -1
					|| textFieldContacto1.getText().isBlank()) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else {
				try {
					if (textFieldDatosContacto.getText().contains("@") && (textFieldDatosContacto.getText().contains(".com")
						|| textFieldDatosContacto.getText().contains(".es") || textFieldDatosContacto.getText().contains(".eus"))) {
						emailFormatCheck(textFieldDatosContacto.getText());
					}
					if (dateFormatErrorCheck()) {
						JOptionPane.showMessageDialog(null, "El formato de una de las fechas es incorrecta. El formato correcto es AAAA-MM-DD",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						Sector sector = null;
						Estado estado = null;
						int result = 0;
						switch ((String)comboBoxSector.getSelectedItem()) {
						case "Agricultura y Ganaderia":
							sector = Sector.AGRICULTURA_GANADERIA;
							break;

						case "Bienes de Consumo":
							sector = Sector.BIENESCONSUMO;
							break;

						case "Comercio electronico":
							sector = Sector.COMERCIOELECTRONICO;
							break;

						case "Comercio y establecimientos":
							sector = Sector.COMERCIO_ESTABLECIMIENTOS;
							break;

						case "Construccion":
							sector = Sector.CONSTRUCCION;
							break;

						case "Deporte y ocio":
							sector = Sector.DEPORTE_OCIO;
							break;

						case "Energia y medio ambiente":
							sector = Sector.ENERGIA_MEDIOAMBIENTE;
							break;

						case "Finanzas, Seguros y bienes inmuebles":
							sector = Sector.FINANZAS_SEGUROS_BIENESINMUEBLES;
							break;

						case "Internet":
							sector = Sector.INTERNET;
							break;

						case "Logistica y Transporte":
							sector = Sector.LOGISTICA_TRANSPORTE;
							break;

						case "Medios de comunicacion y marketing":
							sector = Sector.MEDIOSCOMUNICACION_MARKETING;
							break;

						case "Metalurgia y electronica":
							sector = Sector.METALURGIA_ELECTRONICA;
							break;

						case "Productos quimicos y materias primas":
							sector = Sector.PRODUCTOSQUIMICOS_MATERIASPRIMAS;
							break;

						case "Salud e industria farmaceutica":
							sector = Sector.SALUD_INDUSTRIAFARMACEUTICA;
							break;
						case "Servicios":
							sector = Sector.SERVICIOS;
							break;

						case "Sociedad":
							sector = Sector.SOCIEDAD;
							break;

						case "Tecnologia y telecomunicaciones":
							sector = Sector.TECNOLOGIA_TELECOMUNICACIONES;
							break;

						case "Turismo y hosteleria":
							sector = Sector.TURISMO_HOSTELERIA;
							break;

						case "Vida":
							sector = Sector.VIDA;
							break;
						}

						switch ((String)comboBoxEstado.getSelectedItem()) {
						case "Informado":
							estado = Estado.INFORMADO;
							break;

						case "Valorando/interesado":
							estado = Estado.VALORANDO_INTERESADO;
							break;

						case "Planificando inserciones":
							estado = Estado.PLANIFICANDOINSERCIONES;
							break;

						case "Proximo año":
							estado = Estado.PROXIMOAÑO;
							break;

						case "No interesado":
							estado = Estado.NOINTERESADO;
							break;
						}

						Empresa emp = new Empresa(textFieldNombre.getText(), sector, textFieldPuesto.getText(),
								textFieldDatosContacto.getText(), textFieldContactoEmpresa.getText(),
								textFieldPersonaContacto.getText(), estado, textFieldContacto1.getText());
						if (!textFieldContacto2.getText().isBlank()) {
							emp.setContacto2(textFieldContacto2.getText());
						}

						if (!textFieldContacto3.getText().isBlank()) {
							emp.setContacto3(textFieldContacto3.getText());
						}

						if (!textFieldContacto4.getText().isBlank()) {
							emp.setContacto4(textFieldContacto4.getText());
						}

						if (!textAreaObservaciones.getText().isBlank()) {
							emp.setObservaciones(textAreaObservaciones.getText());
						}

						if (cont.añadirEmpresa(emp)) {
							result = JOptionPane.showConfirmDialog(null, "La empresa ha sido añadida correctamente. Quiere añadir mas empresas?",
									"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
							if (result == JOptionPane.NO_OPTION) {
								this.dispose();
							} else if (result == JOptionPane.YES_OPTION) {
								textAreaObservaciones.setText("");
								textFieldContacto1.setText("");
								textFieldContacto2.setText("");
								textFieldContacto3.setText("");
								textFieldContacto4.setText("");
								textFieldContactoEmpresa.setText("");
								textFieldDatosContacto.setText("");
								textFieldNombre.setText("");
								textFieldPersonaContacto.setText("");
								textFieldPuesto.setText("");
								comboBoxEstado.setSelectedIndex(-1);
								comboBoxSector.setSelectedIndex(-1);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la empresa.",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (EmailFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
