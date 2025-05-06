package windows;

import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.*;

public class VentanaAñadir extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private LoginController cont;
	private JTextField textFieldNombre, textFieldPuesto, textFieldDatosContacto, textFieldContactoEmpresa,
	textFieldContacto1, textFieldContacto2;
	private JTextField textFieldContacto3, textFieldContacto4, textFieldPersonaContacto;
	private JTextArea textAreaObservaciones;
	private JComboBox<String> comboBoxSector, comboBoxEstado;
	private JButton btnAñadir;

	public VentanaAñadir(JFrame parent, LoginController cont) {
		super(parent, true);
		setTitle("Añadir empresa");
		this.cont = cont;

		setBounds(100, 100, 400, 660);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblObligatorio = new JLabel("* Obligatorio. Formato de fechas: AAAA-MM-DD");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(10, 6, 366, 19);
		contentPanel.add(lblObligatorio);

		JLabel lblNombre = new JLabel("Nombre: *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(28, 28, 108, 31);
		contentPanel.add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(191, 35, 163, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblSector = new JLabel("Sector: *");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(28, 68, 108, 31);
		contentPanel.add(lblSector);

		comboBoxSector = new JComboBox<>();
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] {"", "Agricultura y Ganaderia", "Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion", "Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet", "Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica", "Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad", "Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida"}));
		comboBoxSector.setBounds(191, 74, 163, 21);
		contentPanel.add(comboBoxSector);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(28, 109, 108, 31);
		contentPanel.add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(191, 116, 163, 19);
		contentPanel.add(textFieldPuesto);

		JLabel lblDatosContacto = new JLabel("Datos de contacto: *");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(28, 145, 129, 31);
		contentPanel.add(lblDatosContacto);

		textFieldDatosContacto = new JTextField();
		textFieldDatosContacto.setColumns(10);
		textFieldDatosContacto.setBounds(191, 152, 163, 19);
		contentPanel.add(textFieldDatosContacto);

		JLabel lblContactoEmpresa = new JLabel("Contacto en la empresa: *");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(10, 187, 147, 31);
		contentPanel.add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(191, 194, 163, 19);
		contentPanel.add(textFieldContactoEmpresa);

		JLabel lblPersonaContacto = new JLabel("Persona de contacto: *");
		lblPersonaContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaContacto.setBounds(10, 230, 153, 31);
		contentPanel.add(lblPersonaContacto);

		textFieldPersonaContacto = new JTextField();
		textFieldPersonaContacto.setColumns(10);
		textFieldPersonaContacto.setBounds(191, 237, 163, 19);
		contentPanel.add(textFieldPersonaContacto);

		JLabel lblEstado = new JLabel("Estado: *");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(28, 271, 108, 31);
		contentPanel.add(lblEstado);

		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] {"", "Informado", "Valorando/interesado", "Planificando inserciones", "Proximo año", "No interesado"}));
		comboBoxEstado.setBounds(191, 277, 163, 21);
		contentPanel.add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("1. contacto: *");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(28, 312, 108, 31);
		contentPanel.add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(191, 319, 163, 19);
		contentPanel.add(textFieldContacto1);

		JLabel lblContacto2 = new JLabel("2. contacto:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(28, 348, 108, 31);
		contentPanel.add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(191, 355, 163, 19);
		contentPanel.add(textFieldContacto2);

		JLabel lblContacto3 = new JLabel("3. contacto:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(28, 393, 108, 31);
		contentPanel.add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(191, 400, 163, 19);
		contentPanel.add(textFieldContacto3);

		JLabel lblContacto4 = new JLabel("4. contacto:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(28, 437, 108, 31);
		contentPanel.add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(191, 444, 163, 19);
		contentPanel.add(textFieldContacto4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(20, 489, 108, 31);
		contentPanel.add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 100 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(10, 517, 126, 31);
		contentPanel.add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setBounds(146, 487, 230, 61);
		contentPanel.add(textAreaObservaciones);

		btnAñadir = new JButton("Añadir empresa");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(107, 569, 147, 37);
		contentPanel.add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	public boolean dateFormatErrorCheck() {
		boolean error = false;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("YYYY-MM-DD");
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldContacto1.getText().isBlank() || textFieldContactoEmpresa.getText().isBlank()
					|| textFieldDatosContacto.getText().isEmpty() || textFieldNombre.getText().isBlank()
					|| textFieldPersonaContacto.getText().isBlank() || textFieldPuesto.getText().isBlank()
					|| comboBoxEstado.getSelectedIndex() == -1 || comboBoxSector.getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda la informacion obligatoria.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (dateFormatErrorCheck()) {
					JOptionPane.showMessageDialog(null, "El formato de una de las fechas es incorrecta. El formato correcto es AAAA-MM-DD", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Sector sector = null;
					Estado estado = null;
					int result = 0;
					switch ((String) comboBoxSector.getSelectedItem()) {
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

					switch ((String) comboBoxEstado.getSelectedItem()) {
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
							textFieldPersonaContacto.getText(), estado, Date.valueOf(textFieldContacto1.getText()));

					if (!textFieldContacto2.getText().isBlank()) {
						emp.setContacto2(Date.valueOf(textFieldContacto2.getText()));
					}

					if (!textFieldContacto3.getText().isBlank()) {
						emp.setContacto3(Date.valueOf(textFieldContacto3.getText()));
					}

					if (!textFieldContacto4.getText().isBlank()) {
						emp.setContacto4(Date.valueOf(textFieldContacto4.getText()));
					}

					if (!textAreaObservaciones.getText().isBlank()) {
						emp.setObservaciones(textAreaObservaciones.getText());
					}

					if (cont.añadirEmpresa(emp)) {
						result = JOptionPane.showConfirmDialog(null,
								"La empresa ha sido añadida correctamente. Quiere añadir mas empresas?", "",
								JOptionPane.YES_NO_OPTION);
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
						JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la empresa.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}
