package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.regex.*;

import controller.LoginController;
import exceptions.EmailFormatException;
import model.*;

public class VentanaModificarEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Empresa emp;
	private Contacto con;
	private JTextArea textAreaEmpresa, textAreaObservaciones, textAreaInfoUltimoCont;
	private JTextField textFieldDatosContacto, textFieldContactoEmpresa, textFieldContacto1, textFieldContacto2,
			textFieldContacto3, textFieldContacto4, textFieldFechaResolucion;
	private JComboBox<String> comboBoxEstado, comboBoxResultadoUltimoContacto, comboBoxResultadoFinal,
			comboBoxPersonaContacto;
	private JButton btnModificar;

	public VentanaModificarEmpresa(JDialog parent, LoginController cont, Empresa emp) {
		super(parent, true);
		getContentPane().setBackground(new Color(38, 201, 236));
		setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.emp = emp;
		this.con = cont.getContacto(emp.getNom_empresa());

		setResizable(false);
		setTitle("Modificar empresa");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 600);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaModificarEmpresa.class.getResource("/img/apnabilan.png")));
		logo.setBounds(25, 10, 325, 78);
		getContentPane().add(logo);

		JLabel lblDatosEmpresa = new JLabel("Informacion de la empresa seleccionada:");
		lblDatosEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosEmpresa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDatosEmpresa.setBounds(370, 10, 506, 28);
		getContentPane().add(lblDatosEmpresa);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(10, 82, 377, 28);
		getContentPane().add(lblNota);

		JLabel lblFechaFormato = new JLabel("Formato de fechas: AAAA-MM-DD");
		lblFechaFormato.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaFormato.setBounds(42, 113, 275, 16);
		getContentPane().add(lblFechaFormato);

		textAreaEmpresa = new JTextArea();
		textAreaEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaEmpresa.setText("");
		textAreaEmpresa.setBackground(new Color(255, 255, 255));
		textAreaEmpresa.setLineWrap(true);
		textAreaEmpresa.setEditable(false);
		textAreaEmpresa.setBounds(380, 37, 506, 367);
		getContentPane().add(textAreaEmpresa);

		loadEmpresa();

		JLabel lblDatosContacto = new JLabel("Datos de contacto:");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(21, 133, 140, 28);
		getContentPane().add(lblDatosContacto);

		textFieldDatosContacto = new JTextField();
		textFieldDatosContacto.setColumns(10);
		textFieldDatosContacto.setBounds(187, 139, 163, 19);
		getContentPane().add(textFieldDatosContacto);

		JLabel lblContactoEmpresa = new JLabel("Contactos en la empresa:");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(10, 171, 151, 28);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(187, 177, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblPersonaContacto = new JLabel("Persona de contacto:");
		lblPersonaContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonaContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonaContacto.setBounds(21, 209, 140, 28);
		getContentPane().add(lblPersonaContacto);

		comboBoxPersonaContacto = new JComboBox<>();
		comboBoxPersonaContacto.setEditable(true);
		comboBoxPersonaContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxPersonaContacto.setSelectedIndex(0);
		comboBoxPersonaContacto.setBounds(187, 215, 163, 19);
		getContentPane().add(comboBoxPersonaContacto);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(42, 249, 119, 28);
		getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox<String>();
		comboBoxEstado.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Informado", "Valorando/interesado",
				"Planificando inserciones", "Proximo año", "No interesado" }));
		comboBoxEstado.setSelectedIndex(0);
		comboBoxEstado.setBounds(187, 254, 163, 21);
		getContentPane().add(comboBoxEstado);

		JLabel lblContacto1 = new JLabel("Contacto 1:");
		lblContacto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto1.setBounds(77, 287, 78, 28);
		getContentPane().add(lblContacto1);

		textFieldContacto1 = new JTextField();
		textFieldContacto1.setColumns(10);
		textFieldContacto1.setBounds(168, 293, 163, 19);
		getContentPane().add(textFieldContacto1);

		JLabel lblFecha_1 = new JLabel("(Fecha)");
		lblFecha_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_1.setBounds(21, 286, 67, 31);
		getContentPane().add(lblFecha_1);

		JLabel lblContacto2 = new JLabel("Contacto 2:");
		lblContacto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto2.setBounds(77, 325, 78, 28);
		getContentPane().add(lblContacto2);

		textFieldContacto2 = new JTextField();
		textFieldContacto2.setColumns(10);
		textFieldContacto2.setBounds(168, 331, 163, 19);
		getContentPane().add(textFieldContacto2);

		JLabel lblFecha_2 = new JLabel("(Fecha)");
		lblFecha_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_2.setBounds(21, 322, 67, 31);
		getContentPane().add(lblFecha_2);

		JLabel lblContacto3 = new JLabel("Contacto 3:");
		lblContacto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto3.setBounds(77, 363, 78, 28);
		getContentPane().add(lblContacto3);

		textFieldContacto3 = new JTextField();
		textFieldContacto3.setColumns(10);
		textFieldContacto3.setBounds(168, 369, 163, 19);
		getContentPane().add(textFieldContacto3);

		JLabel lblFecha_3 = new JLabel("(Fecha)");
		lblFecha_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_3.setBounds(21, 363, 67, 31);
		getContentPane().add(lblFecha_3);

		JLabel lblContacto4 = new JLabel("Contacto 4:");
		lblContacto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContacto4.setBounds(77, 401, 78, 28);
		getContentPane().add(lblContacto4);

		textFieldContacto4 = new JTextField();
		textFieldContacto4.setColumns(10);
		textFieldContacto4.setBounds(168, 398, 163, 19);
		getContentPane().add(textFieldContacto4);

		JLabel lblFecha_4 = new JLabel("(Fecha)");
		lblFecha_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFecha_4.setBounds(27, 400, 61, 31);
		getContentPane().add(lblFecha_4);

		JLabel lblObservaciones = new JLabel("Observaciones:");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(370, 423, 108, 31);
		getContentPane().add(lblObservaciones);

		JLabel lblMaxChars = new JLabel("(Max 750 caracteres)");
		lblMaxChars.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxChars.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxChars.setBounds(360, 451, 126, 31);
		getContentPane().add(lblMaxChars);

		textAreaObservaciones = new JTextArea();
		textAreaObservaciones.setLineWrap(true);
		textAreaObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaObservaciones.setBounds(496, 421, 230, 61);
		getContentPane().add(textAreaObservaciones);

		JLabel lblResultadoUltimoCont = new JLabel("Resultado ultimo contacto:");
		lblResultadoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoUltimoCont.setBounds(21, 439, 162, 31);
		getContentPane().add(lblResultadoUltimoCont);

		comboBoxResultadoUltimoContacto = new JComboBox<>();
		comboBoxResultadoUltimoContacto.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Comunicacion sin respuesta", "Nos pospone la respuesta", "Programada reunion",
						"Respuesta no concluyente", "Inicio valoracion oferta" }));
		comboBoxResultadoUltimoContacto.setSelectedIndex(0);
		comboBoxResultadoUltimoContacto.setBounds(187, 441, 163, 21);
		getContentPane().add(comboBoxResultadoUltimoContacto);

		JLabel lblResultadoFinal = new JLabel("Resultado final prospeccion:");
		lblResultadoFinal.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResultadoFinal.setBounds(14, 481, 163, 31);
		getContentPane().add(lblResultadoFinal);

		comboBoxResultadoFinal = new JComboBox<String>();
		comboBoxResultadoFinal.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Oferta de empleo",
				"Convenio de colaboracion", "Medidas alternativas", "Relacion concluida", "Relacion pospuesta" }));
		comboBoxResultadoFinal.setSelectedIndex(0);
		comboBoxResultadoFinal.setBounds(187, 487, 163, 21);
		getContentPane().add(comboBoxResultadoFinal);

		JLabel lblFechaResolucion = new JLabel("Fecha resolucion:");
		lblFechaResolucion.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaResolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaResolucion.setBounds(42, 522, 120, 31);
		getContentPane().add(lblFechaResolucion);

		textFieldFechaResolucion = new JTextField();
		textFieldFechaResolucion.setColumns(10);
		textFieldFechaResolucion.setBounds(175, 529, 163, 19);
		getContentPane().add(textFieldFechaResolucion);

		JLabel lblInfoUltimoCont = new JLabel("Informacion ultimo contacto:");
		lblInfoUltimoCont.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfoUltimoCont.setBounds(352, 492, 177, 31);
		getContentPane().add(lblInfoUltimoCont);

		textAreaInfoUltimoCont = new JTextArea();
		textAreaInfoUltimoCont.setLineWrap(true);
		textAreaInfoUltimoCont.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoUltimoCont.setBounds(539, 492, 230, 61);
		getContentPane().add(textAreaInfoUltimoCont);

		JLabel lblmaxChars_1 = new JLabel("(Max 500 caracteres)");
		lblmaxChars_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxChars_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxChars_1.setBounds(375, 522, 126, 31);
		getContentPane().add(lblmaxChars_1);

		JScrollPane scrollPane = new JScrollPane(textAreaEmpresa);
		scrollPane.setBounds(380, 37, 506, 367);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaObservaciones);
		scrollPane_1.setBounds(496, 421, 230, 61);
		getContentPane().add(scrollPane_1);

		JScrollPane scrollPane_2 = new JScrollPane(textAreaInfoUltimoCont);
		scrollPane_2.setBounds(539, 492, 230, 61);
		getContentPane().add(scrollPane_2);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(745, 421, 151, 55);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void loadEmpresa() {
		StringBuilder infoEmpresa = new StringBuilder("");
		String sector = "", estado = "", resultadoFinal = "", resultadoUltimoCont = "";

		textAreaEmpresa.setText("");
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
			sector = "---";
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
			estado = "---";
		}

		switch (con.getResultadoUltimoContacto()) {
		case COMUNICACION_SINRESPUESTA:
			resultadoUltimoCont = "Comunicacion sin respuesta";
			break;

		case INICIO_VALORACIONOFERTA:
			resultadoUltimoCont = "Inicio valoracion oferta";
			break;

		case RESPUESTA_NOCONCLUYENTE:
			resultadoUltimoCont = "Respuesta no concluyente";
			break;

		case RESPUESTA_POSPUESTA:
			resultadoUltimoCont = "Nos pospone la respuesta";
			break;

		case REUNION_PROGRAMADA:
			resultadoUltimoCont = "Programada reunion";
			break;

		default:
			resultadoUltimoCont = "---";
		}

		switch (con.getResultadoFinal()) {
		case CONVENIO_COLABORACION:
			resultadoFinal = "Convenio de colaboracion";
			break;

		case MEDIDAS_ALTERNATIVAS:
			resultadoFinal = "Medidas alternativas";
			break;

		case OFERTA_EMPLEO:
			resultadoFinal = "Oferta de empleo";
			break;

		case RELACION_CONCLUIDA:
			resultadoFinal = "Relacion concluida";
			break;

		case RELACION_POSPUESTA:
			resultadoFinal = "Relacion pospuesta";
			break;

		default:
			resultadoFinal = "---";
		}

		infoEmpresa.append("Nombre: " + emp.getNom_empresa()).append("\n");
		infoEmpresa.append("Sector: " + sector).append("\n");

		if (emp.getPuesto() == null) {
			infoEmpresa.append("Puesto: ---").append("\n");
		} else {
			infoEmpresa.append("Puesto: " + emp.getPuesto()).append("\n");
		}

		if (emp.getDatosContacto() == null) {
			infoEmpresa.append("Datos de contacto: ---").append("\n");
		} else {
			infoEmpresa.append("Datos de contacto: " + emp.getDatosContacto()).append("\n");
		}

		if (emp.getContactoEmpresa() == null) {
			infoEmpresa.append("Contacto en la empresa: ---").append("\n");
		} else {
			infoEmpresa.append("Contacto en la empresa: " + emp.getContactoEmpresa()).append("\n");
		}

		infoEmpresa.append("Persona de contacto: " + emp.getContactoApnabi()).append("\n");
		infoEmpresa.append("Estado: " + estado).append("\n");

		if (con.getContacto1() == null) {
			infoEmpresa.append("1. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("1. contacto: " + con.getContacto1()).append("\n");
		}

		if (con.getContacto2() == null) {
			infoEmpresa.append("2. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("2. contacto: " + con.getContacto2()).append("\n");
		}

		if (con.getContacto3() == null) {
			infoEmpresa.append("3. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("3. contacto: " + con.getContacto3()).append("\n");
		}

		if (con.getContacto4() == null) {
			infoEmpresa.append("4. contacto: ---").append("\n");
		} else {
			infoEmpresa.append("4. contacto: " + con.getContacto4()).append("\n");
		}

		if (con.getObservaciones() == null) {
			infoEmpresa.append("Observaciones: ---").append("\n");
		} else {
			infoEmpresa.append("Observaciones: " + con.getObservaciones()).append("\n");
		}

		infoEmpresa.append("Resultado ultimo contacto: " + resultadoUltimoCont).append("\n");
		if (con.getInfoUltimo() == null) {
			infoEmpresa.append("Informacion ultimo contacto: ---").append("\n");
		} else {
			infoEmpresa.append("Informacion ultimo contacto: " + con.getInfoUltimo()).append("\n");
		}

		infoEmpresa.append("Resultado final prospeccion: " + resultadoFinal).append("\n");
		if (con.getFechaResolucion() == null) {
			infoEmpresa.append("Fecha resolucion: ---");
		} else {
			infoEmpresa.append("Fecha resolucion: " + con.getFechaResolucion());
		}
		textAreaEmpresa.setText(infoEmpresa.toString());
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
			error = addError();
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

	public boolean addError() { // ErrorID: 1
		boolean check = true;
		StringBuilder infoError = new StringBuilder("Un error ha occurrido en ");
		try {
			if (!textFieldDatosContacto.getText().isBlank()) {
				if (textFieldDatosContacto.getText().contains("@") && !textFieldDatosContacto.getText().contains("/")
						&& !textFieldDatosContacto.getText().contains("-")
						&& (textFieldDatosContacto.getText().contains(".com")
								|| textFieldDatosContacto.getText().contains(".es")
								|| textFieldDatosContacto.getText().contains(".eus")
								|| textFieldDatosContacto.getText().contains(".org")
								|| textFieldDatosContacto.getText().contains(".it")
								|| textFieldDatosContacto.getText().contains(".eu"))) {
					emailFormatCheck(textFieldDatosContacto.getText());
				}
				check = cont.modificarDatosContacto(textFieldDatosContacto.getText(), emp.getNom_empresa());
				if (!check) {
					infoError.append("Datos de contacto");
				}
			}

			if (!textFieldContactoEmpresa.getText().isBlank() && check) {
				check = cont.modificarContactoEmpresa(textFieldContactoEmpresa.getText(), emp.getNom_empresa());
				if (!check) {
					infoError.append("Contacto en la empresa");
				}
			}

			if (!comboBoxPersonaContacto.getEditor().getItem().equals("---") && check) {
				check = cont.modificarPersonaContacto((String) comboBoxPersonaContacto.getEditor().getItem(),
						emp.getNom_empresa());
				if (!check) {
					infoError.append("Persona de contacto");
				}
			}

			if (!comboBoxEstado.getSelectedItem().equals("---") && check) {
				check = cont.modificarEstado(comboBoxEstado.getItemAt(comboBoxEstado.getSelectedIndex()),
						emp.getNom_empresa());
				if (!check) {
					infoError.append("Estado");
				}
			}

			if (!textFieldContacto1.getText().isBlank() && check) {
				check = cont.modificarContacto1(textFieldContacto1.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("1. contacto");
				}
			}

			if (!textFieldContacto2.getText().isBlank() && check) {
				check = cont.modificarContacto2(textFieldContacto2.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("2. contacto");
				}
			}

			if (!textFieldContacto3.getText().isBlank() && check) {
				check = cont.modificarContacto3(textFieldContacto3.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("3. contacto");
				}
			}

			if (!textFieldContacto4.getText().isBlank() && check) {
				check = cont.modificarContacto4(textFieldContacto4.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("4. contacto");
				}
			}

			if (!textAreaObservaciones.getText().isBlank() && check) {
				check = cont.modificarObservaciones(textAreaObservaciones.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("Observaciones");
				}
			}

			if (!textAreaInfoUltimoCont.getText().isBlank() && check) {
				check = cont.modificarInformacionUltimoContacto(textAreaInfoUltimoCont.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("Resultado ultimo contacto");
				}
			}

			if (!comboBoxResultadoUltimoContacto.getSelectedItem().equals("---") && check) {
				check = cont.modificarResultadoUltimoContacto(
						comboBoxResultadoUltimoContacto.getItemAt(comboBoxResultadoUltimoContacto.getSelectedIndex()),
						con.getEmp_Nom());
				if (!check) {
					infoError.append("Informacion ultimo contacto");
				}
			}

			if (!comboBoxResultadoFinal.getSelectedItem().equals("---") && check) {
				check = cont.modificarResultadoFinal(
						comboBoxResultadoFinal.getItemAt(comboBoxResultadoFinal.getSelectedIndex()), con.getEmp_Nom());
				if (!check) {
					infoError.append("Resultado final prospeccion");
				}
			}

			if (!textFieldFechaResolucion.getText().isBlank() && check) {
				check = cont.modificarObservaciones(textAreaObservaciones.getText(), con.getEmp_Nom());
				if (!check) {
					infoError.append("Fecha de resolucion");
				}
			}

			if (!check) {
				infoError.append(" al intentar actualizar la empresa.");
				JOptionPane.showMessageDialog(null, infoError.toString()
						+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion de empresa.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		} catch (EmailFormatException e) {
			check = false;
			if (!check) {
				infoError.append(
						"Datos de contacto al intentar actualizar la empresa, debido a que el formato del email introducido es incorrecto.");
				JOptionPane.showMessageDialog(null, infoError.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		return check;
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
		Contacto con = cont.getContacto(emp.getNom_empresa());
		LocalDate cont1 = LocalDate.parse("9999-1-1", format), cont2 = LocalDate.parse("9999-1-1", format),
				cont3 = LocalDate.parse("9999-1-1", format), cont4 = LocalDate.parse("9999-1-1", format);

		if (!textFieldContacto1.getText().isBlank()) {
			cont1 = LocalDate.parse(textFieldContacto1.getText(), format);
		} else {
			cont1 = LocalDate.parse(con.getContacto1(), format);
		}

		if (!textFieldContacto2.getText().isBlank() && con.getContacto2() == null) {
			cont2 = LocalDate.parse(textFieldContacto2.getText(), format);
		} else if (con.getContacto2() != null) {
			cont2 = LocalDate.parse(con.getContacto2(), format);
		}

		if (!textFieldContacto3.getText().isBlank() && con.getContacto3() == null) {
			cont3 = LocalDate.parse(textFieldContacto3.getText(), format);
		} else if (con.getContacto3() != null) {
			cont3 = LocalDate.parse(con.getContacto3(), format);
		}

		if (!textFieldContacto4.getText().isBlank() && con.getContacto4() == null) {
			cont4 = LocalDate.parse(textFieldContacto4.getText(), format);
		} else if (con.getContacto4() != null) {
			cont4 = LocalDate.parse(con.getContacto4(), format);
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
		if (event.getSource() == btnModificar) {
			if (errorChecks(2)) {
				JOptionPane.showMessageDialog(null,
						"El formato de una de las fechas es incorrecta. El formato correcto es AAAA-MM-DD", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else if (errorChecks(3)) {
				if (textFieldContacto1.getText().isBlank()) {
					JOptionPane.showMessageDialog(null,
							"Una o varias de las fechas introducidas no estan en orden cronologico."
									+ "\nComprueba la fecha del 1. Contacto del recuadro de informacion de empresa si tienes dudas, y compruba el orden de las fechas.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					JOptionPane
							.showMessageDialog(null,
									"Una o varias de las fechas introducidas no estan en orden cronologico."
											+ "\nComprueba el orden de las fechas.",
									"ERROR", JOptionPane.ERROR_MESSAGE);
				}
			} else if (errorChecks(4)) {
				JOptionPane.showMessageDialog(null,
						"Hay mas caracteres que el limite de caracteres en uno de los campos de texto con limite especificado.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (textFieldDatosContacto.getText().contains("@")
							&& (textFieldDatosContacto.getText().contains(".com")
									|| textFieldDatosContacto.getText().contains(".es")
									|| textFieldDatosContacto.getText().contains(".eus"))) {
						emailFormatCheck(textFieldDatosContacto.getText());
					}

					if (!errorChecks(1)) {
						emp = cont.getEmpresa(emp.getNom_empresa());
						loadEmpresa();
					} else {
						JOptionPane.showMessageDialog(null, "La empresa ha sido modificada correctamente."
								+ "\nLa informacion en el recuadro de infomacion de empresa se actualizara para reflejar los cambios.");
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
