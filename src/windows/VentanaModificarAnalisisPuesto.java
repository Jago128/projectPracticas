package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.AnalisisPuesto;

public class VentanaModificarAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private AnalisisPuesto aP;
	private JButton btnModificar;
	private JTextField textFieldPuesto, textFieldUbicacion, textFieldTelefono, textFieldEmail, textFieldContactoEmpresa;
	private JTextArea textAreaAP, textAreaHorario;
	private JComboBox<String> comboBoxFormacionMinima, comboBoxIdiomasReq, comboBoxResponsableApnabi,
			comboBoxComunicacion;

	public VentanaModificarAnalisisPuesto(JDialog parent, LoginController cont, AnalisisPuesto aP) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.aP = aP;

		setResizable(false);
		setTitle("Modificar analisis de puesto");
		setBounds(100, 100, 940, 530);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaModificarAnalisisPuesto.class.getResource("/img/apnabilan.png")));
		logo.setBounds(66, 10, 325, 78);
		getContentPane().add(logo);

		textAreaAP = new JTextArea();
		textAreaAP.setLineWrap(true);
		textAreaAP.setBounds(408, 48, 507, 380);
		getContentPane().add(textAreaAP);

		JLabel lblNota = new JLabel("No hace falta rellenar toda la informacion.");
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblNota.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNota.setBounds(458, 10, 377, 28);
		getContentPane().add(lblNota);

		loadAPs();

		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(45, 83, 89, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(144, 87, 231, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblHorario = new JLabel("Horario:");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorario.setBounds(39, 135, 78, 21);
		getContentPane().add(lblHorario);

		JLabel lblmaxCaracteres = new JLabel("(Max 150 caracteres)");
		lblmaxCaracteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxCaracteres.setBounds(14, 158, 119, 21);
		getContentPane().add(lblmaxCaracteres);

		textAreaHorario = new JTextArea();
		textAreaHorario.setLineWrap(true);
		textAreaHorario.setBounds(144, 124, 254, 66);
		getContentPane().add(textAreaHorario);

		JLabel lblFormacionMinima = new JLabel("Formacion Minima:");
		lblFormacionMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacionMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacionMinima.setBounds(30, 194, 128, 31);
		getContentPane().add(lblFormacionMinima);

		comboBoxFormacionMinima = new JComboBox<String>();
		comboBoxFormacionMinima.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO",
				"EPA", "FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacionMinima.setSelectedIndex(0);
		comboBoxFormacionMinima.setBounds(160, 200, 224, 21);
		getContentPane().add(comboBoxFormacionMinima);

		JLabel lblUbicacion = new JLabel("Ubicacion:");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUbicacion.setBounds(46, 230, 89, 31);
		getContentPane().add(lblUbicacion);

		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(150, 235, 217, 19);
		getContentPane().add(textFieldUbicacion);

		JLabel lbl_IdiomasReq = new JLabel("Idiomas requeridos:");
		lbl_IdiomasReq.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IdiomasReq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IdiomasReq.setBounds(30, 264, 133, 31);
		getContentPane().add(lbl_IdiomasReq);

		comboBoxIdiomasReq = new JComboBox<String>();
		comboBoxIdiomasReq.setEditable(true);
		comboBoxIdiomasReq.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Ingles", "Euskera", "Español" }));
		comboBoxIdiomasReq.setSelectedIndex(0);
		comboBoxIdiomasReq.setBounds(173, 416, 222, 21);
		getContentPane().add(comboBoxIdiomasReq);

		JLabel lblContactoEmpresa = new JLabel("Contacto con la empresa:");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(29, 301, 155, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(194, 308, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(30, 371, 68, 31);
		getContentPane().add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(108, 378, 257, 19);
		getContentPane().add(textFieldEmail);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(48, 337, 84, 31);
		getContentPane().add(lblTelefono);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(166, 344, 207, 19);
		getContentPane().add(textFieldTelefono);

		JLabel lblResponsableApnabi = new JLabel("Responsable de Apnabi:");
		lblResponsableApnabi.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResponsableApnabi.setBounds(10, 410, 149, 31);
		getContentPane().add(lblResponsableApnabi);

		comboBoxResponsableApnabi = new JComboBox<String>();
		comboBoxResponsableApnabi.setEditable(true);
		comboBoxResponsableApnabi.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxResponsableApnabi.setSelectedIndex(0);
		comboBoxResponsableApnabi.setBounds(179, 270, 178, 21);
		getContentPane().add(comboBoxResponsableApnabi);

		JLabel lblComunicacion = new JLabel("Comunicacion:");
		lblComunicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblComunicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComunicacion.setBounds(10, 451, 99, 31);
		getContentPane().add(lblComunicacion);

		comboBoxComunicacion = new JComboBox<String>();
		comboBoxComunicacion.setSelectedIndex(0);
		comboBoxComunicacion.setBounds(119, 453, 557, 28);
		getContentPane().add(comboBoxComunicacion);

		JScrollPane scrollPane = new JScrollPane(textAreaAP);
		scrollPane.setBounds(408, 48, 507, 380);
		getContentPane().add(scrollPane);

		JScrollPane scrollPane_1 = new JScrollPane(textAreaHorario);
		scrollPane_1.setBounds(144, 124, 254, 66);
		getContentPane().add(scrollPane_1);

		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(new Color(38, 201, 236));
		btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificar.setBounds(706, 438, 209, 47);
		getContentPane().add(btnModificar);
		btnModificar.addActionListener(this);
	}

	public void loadAPs() {
		StringBuilder infoAP = new StringBuilder("");
		String min_Formacion = "", sector = "", finde = "", comunicacion = "", sensoriales = "";

		textAreaAP.setText("");
		switch (aP.getFinde()) {
		case SOLODOMINGOS:
			finde = "Solo domingos";
			break;

		case NO:
			finde = "No";
			break;

		case SOLOSABADOS:
			finde = "Solo sabados";
			break;

		case SI:
			finde = "Si";
			break;

		default:
			System.out.println("Tipo incorrecto");
		}

		switch (aP.getMin_Formacion()) {
		case AT:
			min_Formacion = "AT";
			break;

		case BACHILLERATO:
			min_Formacion = "Bachillerato";
			break;

		case DOCTORADO:
			min_Formacion = "Doctorado";
			break;

		case EPA:
			min_Formacion = "EPA";
			break;

		case ESO:
			min_Formacion = "ESO";
			break;

		case FP_BASICA:
			min_Formacion = "FP_Basica";
			break;

		case GM:
			min_Formacion = "GM";
			break;

		case GS:
			min_Formacion = "GS";
			break;

		case MASTER:
			min_Formacion = "Master";
			break;

		case PRIMARIA:
			min_Formacion = "Primaria";
			break;

		case UNIVERSIDAD:
			min_Formacion = "Universidad";
			break;

		default:
			System.out.println("Tipo invalido");
		}

		switch (aP.getSector()) {
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

		switch (aP.getComunicacion()) {
		case COMUNICACIONCONPERSONALEMPESA:
			comunicacion = "Comunicación con personal de la empesa";
			break;

		case COMUNICACIONCONPERSONALEMPRESA_FUERAEMPRESA:
			comunicacion = "Comunicacion con personal de la empresa  y fuera de la empresa";
			break;

		case COMUNICACIONCONPERSONASEXTERNASEMPRESA:
			comunicacion = "Comunicación con personas externas a la empresa";
			break;

		case SIN_NECESIDADCOMUNICACION:
			comunicacion = "Sin necesidad de comunicacion";
			break;

		default:
			System.out.println("Tipo incorrecto");
		}

		switch (aP.getCaractersiticasSensoriales()) {
		case LIMPIEZA:
			sensoriales = "Limpieza";
			break;

		case LUZ:
			sensoriales = "Luz";
			break;

		case ORDEN:
			sensoriales = "Orden";
			break;

		case RUIDO:
			sensoriales = "Ruido";
			break;

		default:
			System.out.println("Tipo invalido.");
		}

		infoAP.append("Empresa: " + aP.getEmpresa()).append("\n");
		infoAP.append("Puesto: " + aP.getPuesto()).append("\n");
		infoAP.append("Horario: " + aP.getHorario()).append("\n");
		infoAP.append("Trabajo de fin de semana: " + finde).append("\n");
		if (aP.isTurnos()) {
			infoAP.append("Trabajo de turnos: Si").append("\n");
		} else {
			infoAP.append("Trabajo de turnos: No").append("\n");
		}
		infoAP.append("Formacion minima: " + min_Formacion).append("\n");
		infoAP.append("Ubicacion: " + aP.getUbicacion()).append("\n");
		infoAP.append("Sector: " + sector).append("\n");
		infoAP.append("Idiomas requerido: " + aP.getReq_idiomas()).append("\n");
		infoAP.append("Contacto con las empresa: " + aP.getContactoEmpresa()).append("\n");
		infoAP.append("Cargo: " + aP.getCargo()).append("\n");
		infoAP.append("Numero de telefono: " + aP.getTelefono()).append("\n");
		infoAP.append("Email: " + aP.getEmail()).append("\n");
		infoAP.append("Responsables de Apnabi: " + aP.getResponsableApnabi()).append("\n");
		if (aP.isEsfuerzoFisico()) {
			infoAP.append("Necesidad de esfuerzo fisico: Si").append("\n");
		} else {
			infoAP.append("Necesidad de esfuerzo fisico: No").append("\n");
		}

		if (aP.isResistencia()) {
			infoAP.append("Necesidad de resistencia: Si").append("\n");
		} else {
			infoAP.append("Necesidad de resistencia: No").append("\n");
		}
		infoAP.append("Comunicacion: " + comunicacion).append("\n");
		infoAP.append("Caracteristicas sensoriales: " + sensoriales);
		textAreaAP.setText(infoAP.toString());
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

		check = cont.modificarPuesto(textFieldPuesto.getText(), aP.getEmpresa());
		if (!check) {
			infoError.append("Puesto");
		}

		if (textAreaHorario.getText().isBlank() && check) {
			check = cont.modificarHorario(textAreaHorario.getText(), aP.getEmpresa());
			if (!check) {
				infoError.append("Horario");
			}
		}

		if (comboBoxFormacionMinima.getSelectedItem().equals("---") && check) {
			check = cont.modificarFormacionMinima(
					comboBoxFormacionMinima.getItemAt(comboBoxFormacionMinima.getSelectedIndex()), aP.getEmpresa());
			if (!check) {
				infoError.append("Formacion minima");
			}
		}

		if (textFieldUbicacion.getText().isBlank() && check) {
			check = cont.modificarUbicacion(textFieldUbicacion.getText(), aP.getEmpresa());
			if (!check) {
				infoError.append("Ubicacion");
			}
		}

		if (comboBoxIdiomasReq.getSelectedItem().equals("---") && check) {
			check = cont.modificarIdiomaReq((String) comboBoxIdiomasReq.getEditor().getItem(), aP.getEmpresa());
			if (!check) {
				infoError.append("Idiomas requeridos");
			}
		}

		if (textFieldContactoEmpresa.getText().isBlank() && check) {
			check = cont.modificarAPContactoEmpresa(textFieldContactoEmpresa.getText(), aP.getEmpresa());
			if (!check) {
				infoError.append("Contacto con la empresa");
			}
		}

		if (textFieldTelefono.getText().isBlank() && check) {
			check = cont.modificarNumTelefono(textFieldTelefono.getText(), aP.getEmpresa());
			if (!check) {
				infoError.append("Numero de telefono");
			}
		}

		if (textFieldEmail.getText().isBlank() && check) {
			check = cont.modificarEmail(textFieldEmail.getText(), aP.getEmpresa());
			if (!check) {
				infoError.append("Email");
			}
		}

		if (comboBoxResponsableApnabi.getEditor().getItem().equals("---") && check) {
			check = cont.modificarResponsableApnabi((String) comboBoxResponsableApnabi.getEditor().getItem(),
					aP.getEmpresa());
			if (!check) {
				infoError.append("Responsable de Apnabi");
			}
		}

		if (comboBoxComunicacion.getSelectedItem().equals("---") && check) {
			check = cont.modificarComunicacion(comboBoxComunicacion.getItemAt(comboBoxComunicacion.getSelectedIndex()),
					aP.getEmpresa());
			if (!check) {
				infoError.append("Comunicacion");
			}
		}

		if (!check) {
			infoError.append(" al intentar actualizar el analisis de puesto.");
			JOptionPane.showMessageDialog(null, infoError.toString()
					+ "\nLa informacion cambiada correctamente se actualizara en el recuadro de infomacion del analisis de puesto.",
					"ERROR", JOptionPane.ERROR_MESSAGE);
		}
		return check;
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaHorario.getText().length() > 150) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificar) {
			if (errorChecks(2)) {
				JOptionPane.showMessageDialog(null,
						"Hay mas caracteres que el limite de caracteres en el campo de horario.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (!errorChecks(1)) {
					aP = cont.getAnalisisPuesto(aP.getEmpresa());
					loadAPs();
				} else {
					JOptionPane.showMessageDialog(null, "El analisis de puesto ha sido modificado correctamente."
							+ "\nLa informacion en el recuadro de infomacion deñ analisis de puesto se acualizara para reflejar los cambios.");
					aP = cont.getAnalisisPuesto(aP.getEmpresa());
					loadAPs();
				}
			}
		}
	}
}
