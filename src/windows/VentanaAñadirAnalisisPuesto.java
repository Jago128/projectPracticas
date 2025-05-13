package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import enums.*;

public class VentanaAñadirAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldEmpresa, textFieldPuesto, textFieldUbicacion, textFieldContactoEmpresa;
	private JComboBox<String> comboBoxFormacionMinima, comboBoxIdiomasReq, comboBoxResponsableApnabi, comboBoxSector;
	private JButton btnAñadir;
	private JTextArea textAreaHorario;

	public VentanaAñadirAnalisisPuesto(JDialog parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 700, 290);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(227, 10, 209, 19);
		getContentPane().add(lblObligatorio);

		JLabel lblEmpresa = new JLabel("Empresa: *");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresa.setBounds(30, 39, 89, 31);
		getContentPane().add(lblEmpresa);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setColumns(10);
		textFieldEmpresa.setBounds(131, 46, 163, 19);
		getContentPane().add(textFieldEmpresa);

		JLabel lblPuesto = new JLabel("Puesto: *");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(359, 39, 89, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(460, 46, 163, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblHorario = new JLabel("Horario: *");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorario.setBounds(30, 71, 89, 21);
		getContentPane().add(lblHorario);

		JLabel lblmaxCaracteres = new JLabel("(Max 150 caracteres)");
		lblmaxCaracteres.setHorizontalAlignment(SwingConstants.CENTER);
		lblmaxCaracteres.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblmaxCaracteres.setBounds(12, 90, 119, 21);
		getContentPane().add(lblmaxCaracteres);

		textAreaHorario = new JTextArea();
		textAreaHorario.setLineWrap(true);
		textAreaHorario.setBounds(141, 75, 178, 48);
		getContentPane().add(textAreaHorario);

		JLabel lblFormacionMinima = new JLabel("Formacion Minima: *");
		lblFormacionMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacionMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacionMinima.setBounds(320, 80, 128, 31);
		getContentPane().add(lblFormacionMinima);

		comboBoxFormacionMinima = new JComboBox<String>();
		comboBoxFormacionMinima.setModel(new DefaultComboBoxModel<>(new String[] { "---", "AT", "Primaria", "ESO",
				"EPA", "FP_Basica", "GM", "Bachillerato", "GS", "Universidad", "Master", "Doctorado" }));
		comboBoxFormacionMinima.setSelectedIndex(0);
		comboBoxFormacionMinima.setBounds(460, 86, 178, 21);
		getContentPane().add(comboBoxFormacionMinima);

		JLabel lblUbicacion = new JLabel("Ubicacion: *");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUbicacion.setBounds(30, 121, 89, 31);
		getContentPane().add(lblUbicacion);

		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(131, 128, 163, 19);
		getContentPane().add(textFieldUbicacion);

		JLabel lblSector = new JLabel("Sector: *");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(359, 121, 89, 31);
		getContentPane().add(lblSector);

		comboBoxSector = new JComboBox<>();
		comboBoxSector.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Agricultura y Ganaderia",
				"Bienes de Consumo", "Comercio electronico", "Comercio y establecimientos", "Construccion",
				"Deporte y ocio", "Energia y medio ambiente", "Finanzas, Seguros y bienes inmuebles", "Internet",
				"Logistica y Transporte", "Medios de comunicacion y marketing", "Metalurgia y electronica",
				"Productos quimicos y materias primas", "Salud e industria farmaceutica", "Servicios", "Sociedad",
				"Tecnologia y telecomunicaciones", "Turismo y hosteleria", "Vida" }));
		comboBoxSector.setSelectedIndex(0);
		comboBoxSector.setBounds(460, 127, 178, 21);
		getContentPane().add(comboBoxSector);

		JLabel lbl_IdiomasReq = new JLabel("Idiomas requeridos: *");
		lbl_IdiomasReq.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IdiomasReq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IdiomasReq.setBounds(10, 162, 133, 31);
		getContentPane().add(lbl_IdiomasReq);

		comboBoxIdiomasReq = new JComboBox<>();
		comboBoxIdiomasReq.setModel(new DefaultComboBoxModel<>(new String[] { "---", "Ingles", "Euskera", "Español" }));
		comboBoxIdiomasReq.setSelectedIndex(0);
		comboBoxIdiomasReq.setBounds(153, 168, 178, 21);
		getContentPane().add(comboBoxIdiomasReq);

		JLabel lblContactoEmpresa = new JLabel("Contacto con la empresa: *");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(341, 162, 155, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(506, 169, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblResponsableApnabi = new JLabel("Responsable de Apnabi: *");
		lblResponsableApnabi.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResponsableApnabi.setBounds(10, 203, 155, 31);
		getContentPane().add(lblResponsableApnabi);

		comboBoxResponsableApnabi = new JComboBox<String>();
		comboBoxResponsableApnabi.setModel(new DefaultComboBoxModel<>(
				new String[] { "---", "Alba", "Ellen", "Selene", "Piti", "María", "Gorka", "Rocío" }));
		comboBoxResponsableApnabi.setSelectedIndex(0);
		comboBoxResponsableApnabi.setBounds(175, 209, 178, 21);
		getContentPane().add(comboBoxResponsableApnabi);

		btnAñadir = new JButton("Añadir analisis de puesto");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(383, 198, 286, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			if (textFieldEmpresa.getText().isBlank()) { // Not finished
				JOptionPane.showMessageDialog(null, "Por favor, rellena toda todos los campos obligatorios.",
						"Falta informacion", JOptionPane.INFORMATION_MESSAGE);
			} else if (cont.verificarAP(textFieldEmpresa.getText())) {
				JOptionPane.showMessageDialog(null, "Ya existe una empresa con el mismo nombre en la base de datos.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			} else {
				if (errorChecks(2)) {
					JOptionPane.showMessageDialog(null,
							"Hay mas caracteres que el limite de caracteres en uno de los campos de texto con limite especificado.",
							"ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					Sector sector = null;
					Formacion formacion = null;
					int result = 0;

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

					AnalisisPuesto aP = new AnalisisPuesto(textFieldEmpresa.getText(), textFieldPuesto.getText(),
							textAreaHorario.getText(), formacion, textFieldUbicacion.getText(), sector,
							(String) comboBoxIdiomasReq.getEditor().getItem(), textFieldContactoEmpresa.getText(),
							(String) comboBoxResponsableApnabi.getEditor().getItem());

					if (cont.añadirAnalisisPuesto(aP)) {
						result = JOptionPane.showConfirmDialog(null,
								"El analisis de puesto ha sido añadido correctamente. Quiere añadir mas analisis de puestos?",
								"", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							textFieldContactoEmpresa.setText("");
							textFieldEmpresa.setText("");
							textAreaHorario.setText("");
							textFieldPuesto.setText("");
							textFieldUbicacion.setText("");
							comboBoxFormacionMinima.setSelectedIndex(0);
							comboBoxIdiomasReq.setSelectedIndex(0);
							comboBoxResponsableApnabi.setSelectedIndex(0);
							comboBoxSector.setSelectedIndex(0);
						}
					} else {
						errorChecks(1);
					}
				}
			}
		}
	}
}