package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.AnalisisPuesto;
import model.Usuario;

public class VentanaMostrarAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listEmpresa, listPuesto, listHorario, listMin_Formacion, listSector, listUbicacion,
			listReqIdiomas, listContactoEmpresa, listResponsableApnabi, listFinde, listTurnos, listCargo, listTelefono,
			listEmail, listEsfuerzoFisico, listResistencia, listComunicacion, listSensoriales;
	private JButton btnModificarPersona;
	private JTextArea textAreaInfo;

	public VentanaMostrarAnalisisPuesto(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		getContentPane().setBackground(new Color(38, 201, 236));
		setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar analisis de puestos");
		setBounds(100, 100, 1090, 390);
		getContentPane().setLayout(null);

		listEmpresa = new JList<>();
		listEmpresa.setBackground(new Color(38, 201, 236));
		listEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPuesto = new JList<>();
		listPuesto.setBackground(new Color(38, 201, 236));
		listPuesto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listHorario = new JList<>();
		listHorario.setBackground(new Color(38, 201, 236));
		listHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFinde = new JList<>();
		listFinde.setBackground(new Color(38, 201, 236));
		listFinde.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFinde.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listTurnos = new JList<>();
		listTurnos.setBackground(new Color(38, 201, 236));
		listTurnos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTurnos.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listMin_Formacion = new JList<>();
		listMin_Formacion.setBackground(new Color(38, 201, 236));
		listMin_Formacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMin_Formacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listUbicacion = new JList<>();
		listUbicacion.setBackground(new Color(38, 201, 236));
		listUbicacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSector = new JList<>();
		listSector.setBackground(new Color(38, 201, 236));
		listSector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSector.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listReqIdiomas = new JList<>();
		listReqIdiomas.setBackground(new Color(38, 201, 236));
		listReqIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listReqIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactoEmpresa = new JList<>();
		listContactoEmpresa.setBackground(new Color(38, 201, 236));
		listContactoEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCargo = new JList<>();
		listCargo.setBackground(new Color(38, 201, 236));
		listCargo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listTelefono = new JList<>();
		listTelefono.setBackground(new Color(38, 201, 236));
		listTelefono.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTelefono.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEmail = new JList<>();
		listEmail.setBackground(new Color(38, 201, 236));
		listEmail.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listResponsableApnabi = new JList<>();
		listResponsableApnabi.setBackground(new Color(38, 201, 236));
		listResponsableApnabi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEsfuerzoFisico = new JList<>();
		listEsfuerzoFisico.setBackground(new Color(38, 201, 236));
		listEsfuerzoFisico.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEsfuerzoFisico.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listResistencia = new JList<String>();
		listResistencia.setBackground(new Color(38, 201, 236));
		listResistencia.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResistencia.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listComunicacion = new JList<String>();
		listComunicacion.setBackground(new Color(38, 201, 236));
		listComunicacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listComunicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSensoriales = new JList<String>();
		listSensoriales.setBackground(new Color(38, 201, 236));
		listSensoriales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSensoriales.setFont(new Font("Tahoma", Font.PLAIN, 12));

		loadAnalisisPuestos();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 201, 236));
		panel.setBounds(10, 10, 1056, 267);
		panel.add(listEmpresa);
		panel.add(listPuesto);
		panel.add(listHorario);
		panel.add(listFinde);
		panel.add(listTurnos);
		panel.add(listMin_Formacion);
		panel.add(listUbicacion);
		panel.add(listSector);
		panel.add(listReqIdiomas);
		panel.add(listContactoEmpresa);
		panel.add(listTelefono);
		panel.add(listEmail);
		panel.add(listResponsableApnabi);
		panel.add(listCargo);
		panel.add(listEsfuerzoFisico);
		panel.add(listResistencia);
		panel.add(listComunicacion);
		panel.add(listSensoriales);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 1056, 267);
		getContentPane().add(scrollPane);

		btnModificarPersona = new JButton("Modificar analisis de puesto");
		btnModificarPersona.setBackground(new Color(38, 201, 236));
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(570, 287, 432, 55);
		getContentPane().add(btnModificarPersona);
		
		textAreaInfo = new JTextArea();
		textAreaInfo.setText("Selecciona un nombre de empresa, y despues pulsa el boton\r\npara modificar el analisis de puesto.");
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaInfo.setEditable(false);
		textAreaInfo.setBackground(new Color(38, 201, 236));
		textAreaInfo.setBounds(54, 285, 481, 57);
		getContentPane().add(textAreaInfo);
		btnModificarPersona.addActionListener(this);
	}

	public void loadAnalisisPuestos() {
		Map<String, AnalisisPuesto> aPs = cont.mostrarAnalisisPuestos();
		DefaultListModel<String> modelEmpresa = new DefaultListModel<>();
		DefaultListModel<String> modelPuesto = new DefaultListModel<>();
		DefaultListModel<String> modelHorario = new DefaultListModel<>();
		DefaultListModel<String> modelFinde = new DefaultListModel<>();
		DefaultListModel<String> modelTurnos = new DefaultListModel<>();
		DefaultListModel<String> modelMin_Formacion = new DefaultListModel<>();
		DefaultListModel<String> modelUbicacion = new DefaultListModel<>();
		DefaultListModel<String> modelSector = new DefaultListModel<>();
		DefaultListModel<String> modelReqIdiomas = new DefaultListModel<>();
		DefaultListModel<String> modelContactoEmpresa = new DefaultListModel<>();
		DefaultListModel<String> modelCargo = new DefaultListModel<>();
		DefaultListModel<String> modelTelefono = new DefaultListModel<>();
		DefaultListModel<String> modelEmail = new DefaultListModel<>();
		DefaultListModel<String> modelResponsableApnabi = new DefaultListModel<>();
		DefaultListModel<String> modelEsfuerzoFisico = new DefaultListModel<>();
		DefaultListModel<String> modelResistencia = new DefaultListModel<>();
		DefaultListModel<String> modelComunicacion = new DefaultListModel<>();
		DefaultListModel<String> modelSensoriales = new DefaultListModel<>();

		if (!aPs.isEmpty()) {
			modelEmpresa.addElement("Empresas");
			modelPuesto.addElement("Puestos");
			modelHorario.addElement("Horarios");
			modelFinde.addElement("Trabajo de fin de semana");
			modelTurnos.addElement("Trabajo de turnos");
			modelMin_Formacion.addElement("Formacion minima");
			modelUbicacion.addElement("Ubicaciones");
			modelSector.addElement("Sectores");
			modelReqIdiomas.addElement("Idiomas requeridos");
			modelContactoEmpresa.addElement("Contactos con las empresas");
			modelCargo.addElement("Cargos");
			modelTelefono.addElement("Numeros de telefono");
			modelEmail.addElement("Emails");
			modelResponsableApnabi.addElement("Responsables de Apnabi");
			modelEsfuerzoFisico.addElement("Necesidad de esfuerzo fisico");
			modelResistencia.addElement("Necesidad de resistencia");
			modelComunicacion.addElement("Comunicacion");
			modelSensoriales.addElement("Caracteristicas sensoriales");
			for (AnalisisPuesto aP : aPs.values()) {
				switch (aP.getFinde()) {
				case SOLODOMINGOS:
					modelFinde.addElement("Solo domingos");
					break;

				case NO:
					modelFinde.addElement("No");
					break;

				case SOLOSABADOS:
					modelFinde.addElement("Solo sabados");
					break;

				case SI:
					modelFinde.addElement("Si");
					break;

				default:
					System.out.println("Tipo incorrecto");
				}

				switch (aP.getMin_Formacion()) {
				case AT:
					modelMin_Formacion.addElement("AT");
					break;

				case BACHILLERATO:
					modelMin_Formacion.addElement("Bachillerato");
					break;

				case DOCTORADO:
					modelMin_Formacion.addElement("Doctorado");
					break;

				case EPA:
					modelMin_Formacion.addElement("EPA");
					break;

				case ESO:
					modelMin_Formacion.addElement("ESO");
					break;

				case FP_BASICA:
					modelMin_Formacion.addElement("FP_Basica");
					break;

				case GM:
					modelMin_Formacion.addElement("GM");
					break;

				case GS:
					modelMin_Formacion.addElement("GS");
					break;

				case MASTER:
					modelMin_Formacion.addElement("Master");
					break;

				case PRIMARIA:
					modelMin_Formacion.addElement("Primaria");
					break;

				case UNIVERSIDAD:
					modelMin_Formacion.addElement("Universidad");
					break;

				default:
					System.out.println("Tipo invalido");
				}

				switch (aP.getSector()) {
				case AGRICULTURA_GANADERIA:
					modelSector.addElement("Agricultura y ganadería");
					break;

				case BIENESCONSUMO:
					modelSector.addElement("Bienes de consumo");
					break;

				case COMERCIOELECTRONICO:
					modelSector.addElement("Comercio electrónico");
					break;

				case COMERCIO_ESTABLECIMIENTOS:
					modelSector.addElement("Comercio y establecimientos");
					break;

				case CONSTRUCCION:
					modelSector.addElement("Construcción");
					break;

				case DEPORTE_OCIO:
					modelSector.addElement("Deporte y ocio");
					break;

				case ENERGIA_MEDIOAMBIENTE:
					modelSector.addElement("Energía y medio ambiente");
					break;

				case FINANZAS_SEGUROS_BIENESINMUEBLES:
					modelSector.addElement("Finanzas, seguros y bienes inmuebles");
					break;

				case INTERNET:
					modelSector.addElement("Internet");
					break;

				case LOGISTICA_TRANSPORTE:
					modelSector.addElement("Logística y transporte");
					break;

				case MEDIOSCOMUNICACION_MARKETING:
					modelSector.addElement("Medios de comunicación y marketing");
					break;

				case METALURGIA_ELECTRONICA:
					modelSector.addElement("Metalurgia y electrónica");
					break;

				case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
					modelSector.addElement("Productos químicos y materias primas");
					break;

				case SALUD_INDUSTRIAFARMACEUTICA:
					modelSector.addElement("Salud e industria farmacéutica");
					break;

				case SERVICIOS:
					modelSector.addElement("Servicios");
					break;

				case SOCIEDAD:
					modelSector.addElement("Sociedad");
					break;

				case TECNOLOGIA_TELECOMUNICACIONES:
					modelSector.addElement("Tecnología y telecomunicaciones");
					break;

				case TURISMO_HOSTELERIA:
					modelSector.addElement("Turismo y hostelería");
					break;

				case VIDA:
					modelSector.addElement("Vida");
					break;

				default:
					System.out.println("Tipo incorrecto");
				}

				switch (aP.getComunicacion()) {
				case COMUNICACIONCONPERSONALEMPESA:
					modelComunicacion.addElement("Comunicación con personal de la empesa");
					break;

				case COMUNICACIONCONPERSONALEMPRESA_FUERAEMPRESA:
					modelComunicacion.addElement("Comunicacion con personal de la empresa  y fuera de la empresa");
					break;

				case COMUNICACIONCONPERSONASEXTERNASEMPRESA:
					modelComunicacion.addElement("Comunicación con personas externas a la empresa");
					break;

				case SINNECESIDADCOMUNICACION:
					modelComunicacion.addElement("Sin necesidad de comunicacion");
					break;

				default:
					System.out.println("Tipo incorrecto");
				}

				switch (aP.getCaractersiticasSensoriales()) {
				case LIMPIEZA:
					modelSensoriales.addElement("Limpieza");
					break;

				case LUZ:
					modelSensoriales.addElement("Luz");
					break;

				case ORDEN:
					modelSensoriales.addElement("Orden");
					break;

				case RUIDO:
					modelSensoriales.addElement("Ruido");
					break;

				default:
					System.out.println("Tipo invalido.");
				}

				modelCargo.addElement(aP.getCargo());
				modelContactoEmpresa.addElement(aP.getContactoEmpresa());
				modelEmail.addElement(aP.getEmail());
				modelEmpresa.addElement(aP.getEmpresa());
				if (aP.isEsfuerzoFisico()) {
					modelEsfuerzoFisico.addElement("Si");
				} else {
					modelEsfuerzoFisico.addElement("No");
				}
				modelHorario.addElement(aP.getHorario());
				modelPuesto.addElement(aP.getPuesto());
				modelReqIdiomas.addElement(aP.getReq_idiomas());
				modelTelefono.addElement(aP.getTelefono());
				modelUbicacion.addElement(aP.getUbicacion());
				if (aP.isResistencia()) {
					modelResistencia.addElement("Si");
				} else {
					modelResistencia.addElement("No");
				}
				if (aP.isTurnos()) {
					modelTurnos.addElement("Si");
				} else {
					modelTurnos.addElement("No");
				}
			}

			listCargo.setModel(modelCargo);
			listComunicacion.setModel(modelComunicacion);
			listContactoEmpresa.setModel(modelContactoEmpresa);
			listEmail.setModel(modelEmail);
			listEmpresa.setModel(modelEmpresa);
			listEsfuerzoFisico.setModel(modelEsfuerzoFisico);
			listFinde.setModel(modelFinde);
			listHorario.setModel(modelHorario);
			listMin_Formacion.setModel(modelMin_Formacion);
			listPuesto.setModel(modelPuesto);
			listReqIdiomas.setModel(modelReqIdiomas);
			listResistencia.setModel(modelResistencia);
			listResponsableApnabi.setModel(modelResponsableApnabi);
			listSector.setModel(modelSector);
			listSensoriales.setModel(modelSensoriales);
			listTelefono.setModel(modelTelefono);
			listTurnos.setModel(modelTurnos);
			listUbicacion.setModel(modelUbicacion);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ningun analisis de puesto para visualizar."
							+ "\nPor favor, añada un analisis de puesto anter de abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarPersona) {
			if (!listEmpresa.isSelectionEmpty()) {
				if (!listEmpresa.getSelectedValue().equals("Empresas")) {
					VentanaModificarAnalisisPuesto dialog = new VentanaModificarAnalisisPuesto(this, cont,
							cont.getAnalisisPuesto(listEmpresa.getSelectedValue()));
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "[ERROR] No se puede modificar el titulo de la columna.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elija un nombre de la lista de nombres de empresas.");
			}
		}
	}
}
