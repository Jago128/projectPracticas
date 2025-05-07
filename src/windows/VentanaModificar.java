package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.LoginController;
import exceptions.EmailFormatException;
import model.*;

public class VentanaModificar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Empresa emp;
	private JTextArea textareaEmpresa;
	private JTextField textFieldDatosContacto, textFieldContactoEmpresa, textFieldPersonaContacto, textFieldContacto1,
	textFieldContacto2, textFieldContacto3, textFieldContacto4;
	private JComboBox<String> comboBoxEstado;
	private JButton btnModificar;
	private JLabel lblDatosEmpresa;
	private JTextArea textAreaObservaciones;
	private JLabel lblNewLabel;

	public VentanaModificar(JDialog parent, LoginController cont, Empresa emp) {
		super(parent, true);
		this.cont = cont;
		this.emp = emp;

		setResizable(false);
		setTitle("Modificar empresa");
		setBounds(100, 100, 920, 480);
		getContentPane().setLayout(null);

		textareaEmpresa = new JTextArea();
		textareaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textareaEmpresa.setText("");
		textareaEmpresa.setBackground(new Color(255, 255, 255));
		textareaEmpresa.setLineWrap(true);
		textareaEmpresa.setEditable(false);
		textareaEmpresa.setBounds(378, 55, 506, 299);
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
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] {"", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado"}));
		comboBoxEstado.setBounds(187, 179, 163, 21);
		getContentPane().add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("Contacto 1:");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(34, 212, 140, 28);
		getContentPane().add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(187, 218, 163, 19);
		getContentPane().add(textFieldContacto1);

		JLabel lblContacto2 = new JLabel("Contacto 2:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(34, 250, 140, 28);
		getContentPane().add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(187, 256, 163, 19);
		getContentPane().add(textFieldContacto2);

		JLabel lblContacto3 = new JLabel("Contacto 3:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(34, 288, 140, 28);
		getContentPane().add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(187, 294, 163, 19);
		getContentPane().add(textFieldContacto3);

		JLabel lblContacto4 = new JLabel("Contacto 4:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(34, 326, 140, 28);
		getContentPane().add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(187, 332, 163, 19);
		getContentPane().add(textFieldContacto4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(31, 366, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 100 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(21, 394, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(157, 364, 230, 61);
		getContentPane().add(textAreaObservaciones);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(428, 366, 439, 67);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(10, 7, 377, 38);
		getContentPane().add(lblNota);

		lblDatosEmpresa = new JLabel("Informacion de la empresa seleccionada:");
		lblDatosEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosEmpresa.setBounds(378, 10, 506, 38);
		getContentPane().add(lblDatosEmpresa);

		lblNewLabel = new JLabel("Formato de fechas: AAAA-MM-DD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(42, 38, 275, 16);
		getContentPane().add(lblNewLabel);

		loadEmpresa();
	}

	public void loadEmpresa() {
		StringBuilder infoEmpresa = new StringBuilder("");
		String sector = "", estado = "";

		switch (emp.getSector()) {
		case AGRICULTURA_GANADERIA:
			sector = "Agricultura y ganadería";
			break;

		case BIENESCONSUMO:
			sector = "Bienes de consumo";
			break;

		case COMERCIOELECTRONICO:
			sector = "Comercio electrónico";
			break;

		case COMERCIO_ESTABLECIMIENTOS:
			sector = "Comercio y establecimientos";
			break;

		case CONSTRUCCION:
			sector = "Construcción";
			break;

		case DEPORTE_OCIO:
			sector = "Deporte y ocio";
			break;

		case ENERGIA_MEDIOAMBIENTE:
			sector = "Energía y medio ambiente";
			break;

		case FINANZAS_SEGUROS_BIENESINMUEBLES:
			sector = "Finanzas, seguros y bienes inmuebles";
			break;

		case INTERNET:
			sector = "Internet";
			break;

		case LOGISTICA_TRANSPORTE:
			sector = "Logística y transporte";
			break;

		case MEDIOSCOMUNICACION_MARKETING:
			sector = "Medios de comunicación y marketing";
			break;

		case METALURGIA_ELECTRONICA:
			sector = "Metalurgia y electrónica";
			break;

		case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
			sector = "Productos químicos y materias primas";
			break;

		case SALUD_INDUSTRIAFARMACEUTICA:
			sector = "Salud e industria farmacéutica";
			break;

		case SERVICIOS:
			sector = "Servicios";
			break;

		case SOCIEDAD:
			sector = "Sociedad";
			break;

		case TECNOLOGIA_TELECOMUNICACIONES:
			sector = "Tecnología y telecomunicaciones";
			break;

		case TURISMO_HOSTELERIA:
			sector = "Turismo y hostelería";
			break;

		case VIDA:
			sector = "Vida";
			break;

		default:
			System.out.println("Tipo incorrecto");
		}

		switch (emp.getEstado()) {
		case INFORMADO:
			estado = "Informado";
			break;

		case NOINTERESADO:
			estado = "No interesado";
			break;

		case PLANIFICANDOINSERCIONES:
			estado = "Planificando inserciones";
			break;

		case PROXIMOAÑO:
			estado = "Proximo año";
			break;

		case VALORANDO_INTERESADO:
			estado = "Valorando/interesado";
			break;

		default:
			System.out.println("Tipo invalido.");
		}

		infoEmpresa.append("Nombre: "+emp.getNom_empresa()).append("\n");
		infoEmpresa.append("Sector: "+sector).append("\n");
		if (emp.getPuesto() == null) {
			infoEmpresa.append("Puesto: ---").append("\n");
		} else {
			infoEmpresa.append("Puesto: "+emp.getPuesto()).append("\n");
		}
		infoEmpresa.append("Datos de contacto: "+emp.getDatosContacto()).append("\n");
		infoEmpresa.append("Contacto en la empresa: "+emp.getContactoEmpresa()).append("\n");
		infoEmpresa.append("Persona de contacto: "+emp.getContactoApnabi()).append("\n");
		infoEmpresa.append("Estado: "+estado).append("\n");
		infoEmpresa.append("1. contacto: "+emp.getContacto1()).append("\n");
		if (emp.getContacto2().equals("")) {
			infoEmpresa.append("2. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("2. contacto: "+emp.getContacto2()).append("\n");
		}

		if (emp.getContacto3().equals("")) {
			infoEmpresa.append("3. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("3. contacto: "+emp.getContacto3()).append("\n");
		}

		if (emp.getContacto4().equals("")) {
			infoEmpresa.append("4. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("4. contacto: "+emp.getContacto4()).append("\n");
		}

		if (emp.getObservaciones() == null) {
			infoEmpresa.append("Observaciones: ---");
		} else {
			infoEmpresa.append("Observaciones: "+emp.getObservaciones());
		}

		textareaEmpresa.setText(infoEmpresa.toString());
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
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
			if (!textFieldContacto1.getText().isBlank()) {
				LocalDate.parse(textFieldContacto1.getText(), format);
			}
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
		if (event.getSource() == btnModificar) {
			if (dateFormatErrorCheck()) {
				JOptionPane.showMessageDialog(null, "El formato de una de las fechas es incorrecta. El formato correcto es AAAA-MM-DD",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				Estado estado = null;
				boolean check = false;
				try {
					if (textFieldDatosContacto.getText().contains("@")) {
						emailFormatCheck(textFieldDatosContacto.getText());
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

					default:
						estado = null;
						break;
					}
					if (!textFieldDatosContacto.getText().isBlank()) {
						check = cont.modificarDatosContacto(textFieldDatosContacto.getText(), emp.getNom_empresa());
					}

					if (!textFieldContactoEmpresa.getText().isBlank()) {
						check = cont.modificarContactoEmpresa(textFieldContactoEmpresa.getText(), emp.getNom_empresa());
					}

					if (!textFieldPersonaContacto.getText().isBlank()) {
						check = cont.modificarPersonaContacto(textFieldPersonaContacto.getText(), emp.getNom_empresa());
					}

					if (comboBoxEstado.getSelectedIndex() != -1) {
						check = cont.modificarEstado(estado, emp.getNom_empresa());
					}

					if (!textFieldContacto1.getText().isBlank()) {
						check = cont.modificarContacto1(textFieldContacto1.getText(), emp.getNom_empresa());
					}

					if (!textFieldContacto2.getText().isBlank()) {
						check = cont.modificarContacto2(textFieldContacto2.getText(), emp.getNom_empresa());
					}

					if (!textFieldContacto3.getText().isBlank()) {
						check = cont.modificarContacto3(textFieldContacto3.getText(), emp.getNom_empresa());
					}

					if (!textFieldContacto4.getText().isBlank()) {
						check = cont.modificarContacto4(textFieldContacto4.getText(), emp.getNom_empresa());
					}

					if (!textAreaObservaciones.getText().isBlank()) {
						check = cont.modificarObservaciones(textAreaObservaciones.getText(), emp.getNom_empresa());
					}

					if (!check) {
						JOptionPane.showMessageDialog(null, "Ha occurrido un error al modificar la empresa.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "La empresa ha sido modificada correctamente.");
						emp = cont.getEmpresa(emp.getNom_empresa());
						loadEmpresa();
					}
				} catch (EmailFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
