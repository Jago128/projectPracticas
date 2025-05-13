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
			listReqIdiomas, listContactoEmpresa, listResponsableApnabi;
	private JButton btnModificarPersona;

	public VentanaMostrarAnalisisPuesto(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar analisis de puestos");
		setBounds(100, 100, 930, 390);
		getContentPane().setLayout(null);

		listEmpresa = new JList<>();
		listEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPuesto = new JList<>();
		listPuesto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listHorario = new JList<>();
		listHorario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listMin_Formacion = new JList<>();
		listMin_Formacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMin_Formacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listUbicacion = new JList<>();
		listUbicacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSector = new JList<>();
		listSector.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSector.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listReqIdiomas = new JList<>();
		listReqIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listReqIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactoEmpresa = new JList<>();
		listContactoEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listResponsableApnabi = new JList<>();
		listResponsableApnabi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		loadAnalisisPuestos();

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 887, 267);
		panel.add(listEmpresa);
		panel.add(listPuesto);
		panel.add(listHorario);
		panel.add(listMin_Formacion);
		panel.add(listUbicacion);
		panel.add(listSector);
		panel.add(listReqIdiomas);
		panel.add(listContactoEmpresa);
		panel.add(listResponsableApnabi);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 887, 267);
		getContentPane().add(scrollPane);

		btnModificarPersona = new JButton("Modificar analisis de puesto");
		btnModificarPersona.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarPersona.setBounds(245, 287, 432, 55);
		getContentPane().add(btnModificarPersona);
		btnModificarPersona.addActionListener(this);
	}

	public void loadAnalisisPuestos() {
		Map<String, AnalisisPuesto> aPs = cont.mostrarAnalisisPuestos();
		DefaultListModel<String> modelEmpresa = new DefaultListModel<>();
		DefaultListModel<String> modelPuesto = new DefaultListModel<>();
		DefaultListModel<String> modelHorario = new DefaultListModel<>();
		DefaultListModel<String> modelMin_Formacion = new DefaultListModel<>();
		DefaultListModel<String> modelUbicacion = new DefaultListModel<>();
		DefaultListModel<String> modelSector = new DefaultListModel<>();
		DefaultListModel<String> modelReq_Idiomas = new DefaultListModel<>();
		DefaultListModel<String> modelContactoEmpresa = new DefaultListModel<>();
		DefaultListModel<String> modelResponsableApModel = new DefaultListModel<>();

		if (!aPs.isEmpty()) {
			modelEmpresa.addElement("Empresas");
			modelPuesto.addElement("Puestos");
			modelMin_Formacion.addElement("Formacion minima");
			modelUbicacion.addElement("Ubicaciones");
			modelSector.addElement("Sectores");
			modelReq_Idiomas.addElement("Idiomas requeridos");
			modelContactoEmpresa.addElement("Contactos con las empresas");
			modelResponsableApModel.addElement("Responsables de Apnabi");
			for (AnalisisPuesto aP : aPs.values()) {
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
				modelContactoEmpresa.addElement(aP.getContactoEmpresa());
				modelEmpresa.addElement(aP.getEmpresa());
				modelHorario.addElement(aP.getHorario());
				modelPuesto.addElement(aP.getPuesto());
				modelReq_Idiomas.addElement(aP.getReq_idiomas());
				modelResponsableApModel.addElement(aP.getResponsableApnabi());
				modelUbicacion.addElement(aP.getUbicacion());
			}
			
			listContactoEmpresa.setModel(modelContactoEmpresa);
			listEmpresa.setModel(modelEmpresa);
			listHorario.setModel(modelHorario);
			listMin_Formacion.setModel(modelMin_Formacion);
			listPuesto.setModel(modelPuesto);
			listReqIdiomas.setModel(modelReq_Idiomas);
			listResponsableApnabi.setModel(modelResponsableApModel);
			listSector.setModel(modelSector);
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
				if (!listEmpresa.getSelectedValue().equals("Nombre")) {
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
