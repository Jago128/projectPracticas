package windows;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.format.*;
import java.time.temporal.ChronoField;
import java.util.regex.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import exceptions.EmailFormatException;
import model.*;

public class VentanaAñadirEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldNombre, textFieldPuesto, textFieldDatosContacto, textFieldContactoEmpresa,
			textFieldContacto1, textFieldContacto2, textFieldContacto3, textFieldContacto4, textFieldFechaResolucion;
	private JTextArea textAreaObservaciones, textAreaInfoUltimoCont;
	private JComboBox<String> comboBoxSector, comboBoxResultadoUltimoContacto, comboBoxEstado, comboBoxResultadoFinal,
			comboBoxPersonaContacto;
	private JButton btnAñadir;

	public VentanaAñadirEmpresa(JDialog parent, LoginController cont) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 560);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel(
				"Los campos con * son obligatorias. Formato de fechas: AAAA-MM-DD (excepto en campos que no sean de fecha)");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(20, 90, 721, 19);
		getContentPane().add(lblObligatorio);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAñadirEmpresa.class.getResource("/img/apnabilan.png")));
		logo.setBounds(232, 10, 325, 78);
		getContentPane().add(logo);

		JLabel lblNombre = new JLabel("Nombre: *");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(20, 119, 89, 31);
		getContentPane().add(lblNombre);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(121, 126, 163, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblSector = new JLabel("Sector:");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(30, 160, 80, 31);
		getContentPane().add(lblSector);

		comboBoxSector = new JComboBox<>();
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSector.setSelectedIndex(0);
		comboBoxSector.setBounds(114, 166, 251, 21);
		getContentPane().add(comboBoxSector);

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(33, 195, 75, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(121, 202, 163, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblDatosContacto = new JLabel("Datos de contacto:");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(20, 236, 129, 31);
		getContentPane().add(lblDatosContacto);

		textFieldDatosContacto = new JTextField();
		textFieldDatosContacto.setColumns(10);
		textFieldDatosContacto.setBounds(166, 243, 163, 19);
		getContentPane().add(textFieldDatosContacto);

		JLabel lblContactoEmpresa = new JLabel("Contacto en la empresa:");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(16, 278, 155, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(181, 285, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblPersonaContacto = new JLabel("Persona de contacto: *");
		lblPersonaContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaContacto.setBounds(10, 321, 153, 31);
		getContentPane().add(lblPersonaContacto);

		comboBoxPersonaContacto = new JComboBox<>();
		comboBoxPersonaContacto.setEditable(true);
		comboBoxPersonaContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxPersonaContacto.setSelectedIndex(0);
		comboBoxPersonaContacto.setBounds(166, 327, 178, 21);
		getContentPane().add(comboBoxPersonaContacto);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(60, 362, 89, 31);
		getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox<>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado" }));
		comboBoxEstado.setSelectedIndex(0);
		comboBoxEstado.setBounds(166, 368, 178, 21);
		getContentPane().add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("1. contacto:");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(375, 119, 95, 31);
		getContentPane().add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(480, 126, 163, 19);
		getContentPane().add(textFieldContacto1);

		JLabel lblFecha = new JLabel("(Fecha)");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha.setBounds(653, 119, 88, 31);
		getContentPane().add(lblFecha);

		JLabel lblContacto2 = new JLabel("2. contacto:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(375, 160, 88, 31);
		getContentPane().add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(480, 167, 163, 19);
		getContentPane().add(textFieldContacto2);

		JLabel lblContacto3 = new JLabel("3. contacto:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(375, 195, 88, 31);
		getContentPane().add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(480, 202, 163, 19);
		getContentPane().add(textFieldContacto3);

		JLabel lblContacto4 = new JLabel("4. contacto:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(375, 236, 85, 31);
		getContentPane().add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(480, 243, 163, 19);
		getContentPane().add(textFieldContacto4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(385, 278, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 750 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(375, 306, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setBounds(511, 284, 230, 61);
		getContentPane().add(textAreaObservaciones);

		JLabel lblResultadoUltimoCont = new JLabel("Resultado ultimo contacto:");
		lblResultadoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoUltimoCont.setBounds(395, 439, 162, 31);
		getContentPane().add(lblResultadoUltimoCont);

		comboBoxResultadoUltimoContacto = new JComboBox<>();
		comboBoxResultadoUltimoContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Comunicacion sin respuesta", "Nos pospone la respuesta", "Programada reunion",
						"Respuesta no concluyente", "Inicio valoracion oferta" }));
		comboBoxResultadoUltimoContacto.setSelectedIndex(0);
		comboBoxResultadoUltimoContacto.setBounds(564, 445, 198, 21);
		getContentPane().add(comboBoxResultadoUltimoContacto);

		JLabel lblInfoUltimoCont = new JLabel("Informacion ultimo contacto:");
		lblInfoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoUltimoCont.setBounds(362, 368, 177, 31);
		getContentPane().add(lblInfoUltimoCont);

		JLabel lblResultadoFinal = new JLabel("Resultado final prospeccion:");
		lblResultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoFinal.setBounds(10, 439, 163, 31);
		getContentPane().add(lblResultadoFinal);

		comboBoxResultadoFinal = new JComboBox<String>();
		comboBoxResultadoFinal.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Oferta de empleo",
				"Convenio de colaboracion", "Medidas alternativas", "Relacion concluida", "Relacion pospuesta" }));
		comboBoxResultadoFinal.setSelectedIndex(0);
		comboBoxResultadoFinal.setBounds(181, 445, 190, 21);
		getContentPane().add(comboBoxResultadoFinal);

		JLabel lblFechaResolucion = new JLabel("Fecha resolucion:");
		lblFechaResolucion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaResolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaResolucion.setBounds(33, 403, 120, 31);
		getContentPane().add(lblFechaResolucion);

		JLabel lblFecha_1 = new JLabel("(Fecha)");
		lblFecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_1.setBounds(653, 160, 88, 31);
		getContentPane().add(lblFecha_1);

		JLabel lblFecha_2 = new JLabel("(Fecha)");
		lblFecha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_2.setBounds(653, 195, 88, 31);
		getContentPane().add(lblFecha_2);

		JLabel lblFecha_3 = new JLabel("(Fecha)");
		lblFecha_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_3.setBounds(653, 236, 88, 31);
		getContentPane().add(lblFecha_3);

		textFieldFechaResolucion = new JTextField();
		textFieldFechaResolucion.setColumns(10);
		textFieldFechaResolucion.setBounds(166, 410, 163, 19);
		getContentPane().add(textFieldFechaResolucion);

		textAreaInfoUltimoCont = new JTextArea();
		textAreaInfoUltimoCont.setLineWrap(true);
		textAreaInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoUltimoCont.setBounds(549, 368, 230, 61);
		getContentPane().add(textAreaInfoUltimoCont);

		JLabel lblmaxChars_1 = new JLabel("(Max 500 caracteres)");
		lblmaxChars_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxChars_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxChars_1.setBounds(385, 403, 126, 31);
		getContentPane().add(lblmaxChars_1);

		JScrollPane scrollPane = new JScrollPane(textAreaObservaciones);
		scrollPane.setBounds(511, 284, 230, 61);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaInfoUltimoCont);
		scrollPane_1.setBounds(549, 368, 230, 61);
		getContentPane().add(scrollPane_1);

		btnAñadir = new JButton("Añadir empresa");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(215, 476, 380, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	public void emailFormatCheck(String email) throws EmailFormatException {
		Pattern modelo = Pattern.compile(
				"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher matcher = modelo.matcher(email);
		if (!matcher.matches()) {
			throw new EmailFormatException();
		}
	}

	public boolean errorChecks(int errorID) {
		boolean error = false;
		switch (errorID) {
		case 1:
			addError();
			break;

		case 2:
			error = dateFormatErrorCheck();
			break;

		case 3:
			error = dateAfterCheck();
			break;

		case 4:
			error = lengthCheck();
			break;
		}
		return error;
	}

	public void addError() { // ErrorID: 1
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir la empresa.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public boolean dateFormatErrorCheck() { // ErrorID: 2
		DateTimeFormatter format = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4).appendLiteral('-')
				.appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH)
				.toFormatter();
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

			if (!textFieldFechaResolucion.getText().isBlank()) {
				LocalDate.parse(textFieldFechaResolucion.getText(), format);
			}
		} catch (DateTimeParseException e) {
			return true;
		}
		return false;
	}

	public boolean dateAfterCheck() { // ErrorID: 3
		DateTimeFormatter format = new DateTimeFormatterBuilder().appendValue(ChronoField.YEAR, 4).appendLiteral('-')
				.appendValue(ChronoField.MONTH_OF_YEAR).appendLiteral('-').appendValue(ChronoField.DAY_OF_MONTH)
				.toFormatter();
		LocalDate cont1 = LocalDate.parse("9999-1-1", format), cont2 = LocalDate.parse("9999-1-1", format),
				cont3 = LocalDate.parse("9999-1-1", format), cont4 = LocalDate.parse("9999-1-1", format);

		if (!textFieldContacto1.getText().isBlank()) {
			cont1 = LocalDate.parse(textFieldContacto1.getText(), format);
		}

		if (!textFieldContacto2.getText().isBlank()) {
			cont2 = LocalDate.parse(textFieldContacto2.getText(), format);
		}

		if (!textFieldContacto3.getText().isBlank()) {
			cont3 = LocalDate.parse(textFieldContacto3.getText(), format);
		}

		if (!textFieldContacto4.getText().isBlank()) {
			cont4 = LocalDate.parse(textFieldContacto4.getText(), format);
		}

		if (!cont4.isAfter(cont3) || !cont4.isAfter(cont2) || !cont4.isAfter(cont1)) {
			return false;
		}

		if (!cont3.isAfter(cont2) || !cont3.isAfter(cont1)) {
			return false;
		}

		if (!cont2.isAfter(cont1)) {
			return false;
		}
		return true;
	}

	public boolean lengthCheck() { // ErrorID: 4
		if (textAreaObservaciones.getText().length() > 750) {
			return true;
		}

		if (textAreaInfoUltimoCont.getText().length() > 500) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAñadir) {
			if (textFieldNombre.getText().isBlank() || comboBoxPersonaContacto.getSelectedItem().equals("---")) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarEmpresa(textFieldNombre.getText())) {
				JOptionPane.showMessageDialog(null, "Ya existe una empresa con el mismo nombre en la base de datos.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (textFieldDatosContacto.getText().contains("@")
							&& !textFieldDatosContacto.getText().contains("/")
							&& !textFieldDatosContacto.getText().contains("-")
							&& (textFieldDatosContacto.getText().contains(".com")
									|| textFieldDatosContacto.getText().contains(".es")
									|| textFieldDatosContacto.getText().contains(".eus")
									|| textFieldDatosContacto.getText().contains(".org")
									|| textFieldDatosContacto.getText().contains(".it")
									|| textFieldDatosContacto.getText().contains(".eu"))) {
						emailFormatCheck(textFieldDatosContacto.getText());
					}
					if (errorChecks(2)) {
						JOptionPane.showMessageDialog(null,
								"El formato de una de las fechas es incorrecta. El formato correcto es AAAA-MM-DD",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else if (errorChecks(3)) {
						if (textFieldContacto1.getText().isBlank()) {
							JOptionPane.showMessageDialog(null,
									"Una o varias de las fechas introducidas no estan en orden cronologico."
											+ "\nComprueba la fecha del 1. Contacto del recuadro de informacion de empresa si tienes dudas.",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null,
									"Una o varias de las fechas introducidas no estan en orden cronologico.", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (errorChecks(4)) {
						JOptionPane.showMessageDialog(null,
								"Hay mas caracteres que el limite de caracteres en uno de los campos de texto con limite especificado.",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					} else {
						Sector sector = null;
						Estado estado = null;
						ResultadoUltimoContacto resultadoUltimoCont = null;
						ResultadoFinal resultadoFinal = null;
						String contactoEmpresa = "", puesto = "", datosContacto = "";
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

						switch ((String) comboBoxResultadoUltimoContacto.getSelectedItem()) {
						case "Comunicacion sin respuesta":
							resultadoUltimoCont = ResultadoUltimoContacto.COMUNICACION_SINRESPUESTA;
							break;

						case "Nos pospone la respuesta":
							resultadoUltimoCont = ResultadoUltimoContacto.RESPUESTA_POSPUESTA;
							break;

						case "Programada reunion":
							resultadoUltimoCont = ResultadoUltimoContacto.REUNION_PROGRAMADA;
							break;

						case "Respuesta no concluyente":
							resultadoUltimoCont = ResultadoUltimoContacto.RESPUESTA_NOCONCLUYENTE;
							break;

						case "Inicio valoracion oferta":
							resultadoUltimoCont = ResultadoUltimoContacto.INICIO_VALORACIONOFERTA;
							break;
						}

						switch ((String) comboBoxResultadoFinal.getSelectedItem()) {
						case "Oferta de empleo":
							resultadoFinal = ResultadoFinal.OFERTA_EMPLEO;
							break;

						case "Convenio de colaboracion":
							resultadoFinal = ResultadoFinal.CONVENIO_COLABORACION;
							break;

						case "Medidas alternativas":
							resultadoFinal = ResultadoFinal.MEDIDAS_ALTERNATIVAS;
							break;

						case "Relacion concluida":
							resultadoFinal = ResultadoFinal.RELACION_CONCLUIDA;
							break;

						case "Relacion pospuesta":
							resultadoFinal = ResultadoFinal.RELACION_POSPUESTA;
							break;
						}

						if (!textFieldPuesto.getText().isBlank()) {
							puesto = textFieldPuesto.getText();
						}

						if (!textFieldDatosContacto.getText().isBlank()) {
							datosContacto = textFieldDatosContacto.getText();
						}

						if (!textFieldContactoEmpresa.getText().isBlank()) {
							contactoEmpresa = textFieldContactoEmpresa.getText();
						}

						Empresa emp = new Empresa(textFieldNombre.getText(), sector, puesto, datosContacto,
								contactoEmpresa, (String) comboBoxPersonaContacto.getEditor().getItem(), estado);
						Contacto con = new Contacto();

						if (!textFieldContacto1.getText().isBlank()) {
							con.setContacto1(textFieldContacto1.getText());
						}

						if (!textFieldContacto2.getText().isBlank()) {
							con.setContacto2(textFieldContacto2.getText());
						}

						if (!textFieldContacto3.getText().isBlank()) {
							con.setContacto3(textFieldContacto3.getText());
						}

						if (!textFieldContacto4.getText().isBlank()) {
							con.setContacto4(textFieldContacto4.getText());
						}

						if (!textAreaObservaciones.getText().isBlank()) {
							con.setObservaciones(textAreaObservaciones.getText());
						}

						if (!textAreaInfoUltimoCont.getText().isBlank()) {
							con.setInfoUltimo(textAreaInfoUltimoCont.getText());
						}

						con.setResultadoUltimoContacto(resultadoUltimoCont);
						if (!textFieldFechaResolucion.getText().isBlank()) {
							con.setFechaResolucion(textFieldFechaResolucion.getText());
						}

						con.setResultadoFinal(resultadoFinal);
						if (cont.añadirEmpresa(emp)) {
							if (cont.añadirContacto(con, textFieldNombre.getText())) {
								result = JOptionPane.showConfirmDialog(null,
										"La empresa ha sido añadida correctamente junto a la informacion de contacto. Quiere añadir mas empresas?",
										"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
								if (result == JOptionPane.NO_OPTION) {
									this.dispose();
								} else if (result == JOptionPane.YES_OPTION) {
									textAreaInfoUltimoCont.setText("");
									textAreaObservaciones.setText("");
									textFieldContacto1.setText("");
									textFieldContacto2.setText("");
									textFieldContacto3.setText("");
									textFieldContacto4.setText("");
									textFieldContactoEmpresa.setText("");
									textFieldDatosContacto.setText("");
									textFieldFechaResolucion.setText("");
									textFieldNombre.setText("");
									textFieldPuesto.setText("");
									comboBoxEstado.setSelectedIndex(0);
									comboBoxPersonaContacto.setSelectedIndex(0);
									comboBoxResultadoFinal.setSelectedIndex(0);
									comboBoxResultadoUltimoContacto.setSelectedIndex(0);
									comboBoxSector.setSelectedIndex(0);
								}
							} else {
								errorChecks(1);
								cont.eliminarEmpresa(textFieldNombre.getText());
							}
						} else {
							errorChecks(1);
						}
					}
				} catch (EmailFormatException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}
