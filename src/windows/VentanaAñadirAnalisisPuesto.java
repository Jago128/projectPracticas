package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import controller.LoginController;
import enums.*;
import exceptions.EmailFormatException;
import model.AnalisisPuesto;

public class VentanaAñadirAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldEmpresa, textFieldPuesto, textFieldUbicacion, textFieldContactoEmpresa, textFieldCargo,
			textFieldEmail, textFieldTelefono;
	private JComboBox<String> comboBoxFormacionMinima, comboBoxIdiomasReq, comboBoxResponsableApnabi, comboBoxSector,
			comboBoxCaracteristicasSensoriales, comboBoxComunicacion, comboBoxFinde;
	private JButton btnAñadir;
	private JTextArea textAreaHorario;
	private JCheckBox chckbxEsfuerzoFisico, chckbxTurnos, chckbxResistencia;
	private JLabel logo;

	public VentanaAñadirAnalisisPuesto(JDialog parent, LoginController cont) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 960, 390);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(434, 35, 209, 19);
		getContentPane().add(lblObligatorio);

		JLabel lblEmpresa = new JLabel("Empresa: *");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresa.setBounds(20, 10, 89, 31);
		getContentPane().add(lblEmpresa);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setColumns(10);
		textFieldEmpresa.setBounds(121, 17, 163, 19);
		getContentPane().add(textFieldEmpresa);

		JLabel lblPuesto = new JLabel("Puesto: *");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(30, 51, 89, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(131, 58, 163, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblHorario = new JLabel("Horario: *");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorario.setBounds(661, 106, 89, 21);
		getContentPane().add(lblHorario);

		JLabel lblmaxCaracteres = new JLabel("(Max 150 caracteres)");
		lblmaxCaracteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxCaracteres.setBounds(643, 125, 119, 21);
		getContentPane().add(lblmaxCaracteres);

		textAreaHorario = new JTextArea();
		textAreaHorario.setLineWrap(true);
		textAreaHorario.setBounds(772, 90, 178, 68);
		getContentPane().add(textAreaHorario);

		JLabel lblFormacionMinima = new JLabel("Formacion Minima: *");
		lblFormacionMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacionMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacionMinima.setBounds(20, 87, 128, 31);
		getContentPane().add(lblFormacionMinima);

		comboBoxFormacionMinima = new JComboBox<String>();
		comboBoxFormacionMinima.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO",
				"EPA", "FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacionMinima.setSelectedIndex(0);
		comboBoxFormacionMinima.setBounds(160, 93, 178, 21);
		getContentPane().add(comboBoxFormacionMinima);

		JLabel lblUbicacion = new JLabel("Ubicacion: *");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUbicacion.setBounds(368, 90, 89, 31);
		getContentPane().add(lblUbicacion);

		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(469, 97, 163, 19);
		getContentPane().add(textFieldUbicacion);

		JLabel lblSector = new JLabel("Sector: *");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(10, 127, 89, 31);
		getContentPane().add(lblSector);

		comboBoxSector = new JComboBox<>();
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSector.setSelectedIndex(0);
		comboBoxSector.setBounds(111, 133, 178, 21);
		getContentPane().add(comboBoxSector);

		JLabel lbl_IdiomasReq = new JLabel("Idiomas requeridos: *");
		lbl_IdiomasReq.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IdiomasReq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IdiomasReq.setBounds(312, 125, 133, 31);
		getContentPane().add(lbl_IdiomasReq);

		comboBoxIdiomasReq = new JComboBox<>();
		comboBoxIdiomasReq.setEditable(true);
		comboBoxIdiomasReq.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Ingles", "Euskera", "Español" }));
		comboBoxIdiomasReq.setSelectedIndex(0);
		comboBoxIdiomasReq.setBounds(455, 131, 178, 21);
		getContentPane().add(comboBoxIdiomasReq);

		JLabel lblContactoEmpresa = new JLabel("Contacto con la empresa: *");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(20, 168, 155, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(185, 175, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblCargo = new JLabel("Cargo: *");
		lblCargo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCargo.setBounds(374, 166, 76, 31);
		getContentPane().add(lblCargo);

		textFieldCargo = new JTextField();
		textFieldCargo.setColumns(10);
		textFieldCargo.setBounds(460, 173, 163, 19);
		getContentPane().add(textFieldCargo);

		JLabel lblResponsableApnabi = new JLabel("Responsable de Apnabi: *");
		lblResponsableApnabi.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResponsableApnabi.setBounds(10, 209, 155, 31);
		getContentPane().add(lblResponsableApnabi);

		comboBoxResponsableApnabi = new JComboBox<String>();
		comboBoxResponsableApnabi.setEditable(true);
		comboBoxResponsableApnabi.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxResponsableApnabi.setSelectedIndex(0);
		comboBoxResponsableApnabi.setBounds(175, 215, 178, 21);
		getContentPane().add(comboBoxResponsableApnabi);

		JLabel lblFinde = new JLabel("Se trabaja durante el fin de semana?");
		lblFinde.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinde.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFinde.setBounds(368, 207, 215, 31);
		getContentPane().add(lblFinde);

		comboBoxFinde = new JComboBox<String>();
		comboBoxFinde.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Si", "Sabados", "Domingos", "No" }));
		comboBoxFinde.setSelectedIndex(0);
		comboBoxFinde.setBounds(593, 214, 178, 21);
		getContentPane().add(comboBoxFinde);

		chckbxTurnos = new JCheckBox("Se trabaja de turnos?");
		chckbxTurnos.setBackground(new Color(38, 201, 236));
		chckbxTurnos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxTurnos.setBounds(781, 207, 163, 33);
		getContentPane().add(chckbxTurnos);

		JLabel lblEmail = new JLabel("Email: *");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(293, 246, 68, 31);
		getContentPane().add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(371, 253, 257, 19);
		getContentPane().add(textFieldEmail);

		JLabel lblTelefono = new JLabel("Telefono: *");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTelefono.setBounds(20, 246, 84, 31);
		getContentPane().add(lblTelefono);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(108, 254, 163, 19);
		getContentPane().add(textFieldTelefono);

		chckbxEsfuerzoFisico = new JCheckBox("Es necesario realizar esfuerzo fisico?");
		chckbxEsfuerzoFisico.setBackground(new Color(38, 201, 236));
		chckbxEsfuerzoFisico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxEsfuerzoFisico.setBounds(666, 167, 257, 31);
		getContentPane().add(chckbxEsfuerzoFisico);

		chckbxResistencia = new JCheckBox("Es necesario tener resistencia?");
		chckbxResistencia.setBackground(new Color(38, 201, 236));
		chckbxResistencia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chckbxResistencia.setBounds(681, 241, 224, 33);
		getContentPane().add(chckbxResistencia);

		JLabel lblComunicacion = new JLabel("Comunicacion: *");
		lblComunicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblComunicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblComunicacion.setBounds(10, 287, 99, 31);
		getContentPane().add(lblComunicacion);

		comboBoxComunicacion = new JComboBox<String>();
		comboBoxComunicacion.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Sin necesidad de comunicacion",
				"Comunicación con personal de la empesa", "Comunicación con personas externas a la empresa",
				"Comunicacion con personal de la empresa  y fuera de la empresa" }));
		comboBoxComunicacion.setSelectedIndex(0);
		comboBoxComunicacion.setBounds(119, 289, 464, 28);
		getContentPane().add(comboBoxComunicacion);

		JLabel lblCaracteristicasSensoriales = new JLabel("Caracteristicas sensoriales: *");
		lblCaracteristicasSensoriales.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaracteristicasSensoriales.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCaracteristicasSensoriales.setBounds(601, 268, 163, 31);
		getContentPane().add(lblCaracteristicasSensoriales);

		comboBoxCaracteristicasSensoriales = new JComboBox<String>();
		comboBoxCaracteristicasSensoriales
				.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Ruido", "Luz", "Orden", "Limpieza" }));
		comboBoxCaracteristicasSensoriales.setSelectedIndex(0);
		comboBoxCaracteristicasSensoriales.setEditable(true);
		comboBoxCaracteristicasSensoriales.setBounds(774, 274, 170, 21);
		getContentPane().add(comboBoxCaracteristicasSensoriales);

		btnAñadir = new JButton("Añadir analisis de puesto");
		btnAñadir.setBackground(new Color(38, 201, 236));
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(611, 299, 317, 35);
		getContentPane().add(btnAñadir);
		
		logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAñadirAnalisisPuesto.class.getResource("/img/apnabilan.png")));
		logo.setBounds(611, 2, 325, 78);
		getContentPane().add(logo);
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
			error = lengthCheck();
			break;
		}
		return error;
	}

	public void addError() { // ErrorID: 1
		JOptionPane.showMessageDialog(null, "Ha habido un error al intentar añadir el analisis de puesto.", "ERROR",
				JOptionPane.ERROR_MESSAGE);
	}

	public boolean lengthCheck() { // ErrorID: 2
		if (textAreaHorario.getText().length() > 150) {
			return true;
		}
		return false;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnAñadir) {
			if (textAreaHorario.getText().isBlank() || textFieldCargo.getText().isBlank()
					|| textFieldContactoEmpresa.getText().isBlank() || textFieldEmail.getText().isBlank()
					|| textFieldEmpresa.getText().isBlank() || textFieldPuesto.getText().isBlank()
					|| textFieldTelefono.getText().isBlank() || textFieldUbicacion.getText().isBlank()
					|| comboBoxCaracteristicasSensoriales.getSelectedItem().equals("---")
					|| comboBoxComunicacion.getSelectedItem().equals("---")
					|| comboBoxFinde.getSelectedItem().equals("---")
					|| comboBoxFormacionMinima.getSelectedItem().equals("---")
					|| comboBoxIdiomasReq.getEditor().getItem().equals("---")
					|| comboBoxResponsableApnabi.getEditor().getItem().equals("---")
					|| comboBoxSector.getSelectedItem().equals("---")) {
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarAP(textFieldEmpresa.getText())) {
				JOptionPane.showMessageDialog(null,
						"Ya existe un analisis de puesto con el mismo nombre de empresa en la base de datos.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			} else {
				if (errorChecks(2)) {
					JOptionPane.showMessageDialog(null,
							"Hay mas caracteres que el limite de caracteres en el campo de horario.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				} else {
					Sector sector = null;
					Formacion formacion = null;
					Finde finde = null;
					Comunicacion com = null;
					Sensoriales sense = null;
					boolean turnos = false, esfuerzoFisico = false, resistencia = false;
					int result = 0;

					try {

						if (!textFieldEmail.getText().contains("/")) {
							emailFormatCheck(textFieldEmail.getText());
						}

						switch ((String) comboBoxFormacionMinima.getSelectedItem()) {
						case "AT":
							formacion = Formacion.AT;
							break;

						case "Primaria":
							formacion = Formacion.PRIMARIA;
							break;

						case "ESO":
							formacion = Formacion.ESO;
							break;

						case "EPA":
							formacion = Formacion.EPA;
							break;

						case "FP Basica":
							formacion = Formacion.FP_BASICA;
							break;

						case "GM":
							formacion = Formacion.GM;
							break;

						case "Bachillerato":
							formacion = Formacion.BACHILLERATO;
							break;

						case "GS":
							formacion = Formacion.GS;
							break;

						case "Universidad":
							formacion = Formacion.UNIVERSIDAD;
							break;

						case "Master":
							formacion = Formacion.MASTER;
							break;

						case "Doctorado":
							formacion = Formacion.DOCTORADO;
							break;
						}

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

						switch ((String) comboBoxFinde.getSelectedItem()) {
						case "Si":
							finde = Finde.SI;
							break;

						case "Sabados":
							finde = Finde.SOLOSABADOS;
							break;

						case "Domingos":
							finde = Finde.SOLODOMINGOS;
							break;

						case "No":
							finde = Finde.NO;
							break;
						}

						switch ((String) comboBoxComunicacion.getSelectedItem()) {
						case "Sin necesidad de comunicacion":
							com = Comunicacion.SINNECESIDADCOMUNICACION;
							break;

						case "Comunicación con personal de la empesa":
							com = Comunicacion.COMUNICACIONCONPERSONALEMPESA;
							break;

						case "Comunicación con personas externas a la empresa":
							com = Comunicacion.COMUNICACIONCONPERSONASEXTERNASEMPRESA;
							break;

						case "Comunicacion con personal de la empresa  y fuera de la empresa":
							com = Comunicacion.COMUNICACIONCONPERSONALEMPRESA_FUERAEMPRESA;
							break;
						}

						switch ((String) comboBoxCaracteristicasSensoriales.getSelectedItem()) {
						case "Ruido":
							sense = Sensoriales.RUIDO;
							break;

						case "Luz":
							sense = Sensoriales.LUZ;
							break;

						case "Orden":
							sense = Sensoriales.ORDEN;
							break;

						case "Limpieza":
							sense = Sensoriales.LIMPIEZA;
							break;
						}

						if (chckbxEsfuerzoFisico.isSelected()) {
							esfuerzoFisico = true;
						}

						if (chckbxResistencia.isSelected()) {
							resistencia = true;
						}

						if (chckbxTurnos.isSelected()) {
							turnos = true;
						}

						AnalisisPuesto aP = new AnalisisPuesto(textFieldEmpresa.getText(), textFieldPuesto.getText(),
								textAreaHorario.getText(), finde, turnos, formacion, textFieldUbicacion.getText(),
								sector, (String) comboBoxIdiomasReq.getEditor().getItem(),
								textFieldContactoEmpresa.getText(), textFieldCargo.getText(),
								textFieldTelefono.getText(), textFieldEmail.getText(),
								(String) comboBoxResponsableApnabi.getEditor().getItem(), esfuerzoFisico, resistencia,
								com, sense);

						if (cont.añadirAnalisisPuesto(aP)) {
							result = JOptionPane.showConfirmDialog(null,
									"El analisis de puesto ha sido añadido correctamente. Quiere añadir mas analisis de puestos?",
									"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
							if (result == JOptionPane.NO_OPTION) {
								this.dispose();
							} else if (result == JOptionPane.YES_OPTION) {
								textAreaHorario.setText("");
								textFieldCargo.setText("");
								textFieldContactoEmpresa.setText("");
								textFieldEmail.setText("");
								textFieldEmpresa.setText("");
								textFieldPuesto.setText("");
								textFieldTelefono.setText("");
								textFieldUbicacion.setText("");
								comboBoxCaracteristicasSensoriales.setSelectedIndex(0);
								comboBoxComunicacion.setSelectedIndex(0);
								comboBoxFinde.setSelectedIndex(0);
								comboBoxFormacionMinima.setSelectedIndex(0);
								comboBoxIdiomasReq.setSelectedIndex(0);
								comboBoxResponsableApnabi.setSelectedIndex(0);
								comboBoxSector.setSelectedIndex(0);
								chckbxEsfuerzoFisico.setSelected(false);
								chckbxResistencia.setSelected(false);
								chckbxTurnos.setSelected(false);
							}
						} else {
							errorChecks(1);
						}
					} catch (EmailFormatException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		}
	}
}