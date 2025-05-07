package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaMostrar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listSectores, listEmpresas, listPuestos, listDatosContacto, listContactosEmpresa,
	listContactosApnabi, listEstados, listContacto1, listContacto2, listContacto3, listContacto4,
	listObservaciones;
	private JButton btnModificarEmpresa;

	public VentanaMostrar(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		setResizable(false);
		this.cont = cont;
		// this.user = user;
		setTitle("Mostrar Empresas");
		setBounds(100, 100, 920, 390);
		getContentPane().setLayout(null);

		listSectores = new JList<>();
		listSectores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectores.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEmpresas = new JList<String>();
		listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPuestos = new JList<String>();
		listPuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listDatosContacto = new JList<String>();
		listDatosContacto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactosEmpresa = new JList<String>();
		listContactosEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactosEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactosApnabi = new JList<String>();
		listContactosApnabi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactosApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEstados = new JList<String>();
		listEstados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto1 = new JList<>();
		listContacto1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto2 = new JList<>();
		listContacto2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto3 = new JList<>();
		listContacto3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto4 = new JList<>();
		listContacto4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listObservaciones = new JList<>();
		listObservaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));

		addEmpresas();

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 886, 246);
		panel.add(listSectores);
		panel.add(listEmpresas);
		panel.add(listPuestos);
		panel.add(listDatosContacto);
		panel.add(listContactosEmpresa);
		panel.add(listContactosApnabi);
		panel.add(listEstados);
		panel.add(listContacto1);
		panel.add(listContacto2);
		panel.add(listContacto3);
		panel.add(listContacto4);
		panel.add(listObservaciones);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 10, 886, 246);
		getContentPane().add(scrollPane);

		btnModificarEmpresa = new JButton("Modificar empresa");
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarEmpresa.setBounds(254, 271, 431, 59);
		getContentPane().add(btnModificarEmpresa);
		btnModificarEmpresa.addActionListener(this);
	}

	public void addEmpresas() {
		Map<String, Empresa> empresas = cont.mostrarEmpresas();
		DefaultListModel<String> modelSectores = new DefaultListModel<>(), modelEmpresas = new DefaultListModel<>(),
				modelPuestos = new DefaultListModel<>(), modelDatosContacto = new DefaultListModel<>(),
				modelContactosEmpresa = new DefaultListModel<>(), modelContactosApnabi = new DefaultListModel<>(),
				modelEstados = new DefaultListModel<>(), modelContactos1 = new DefaultListModel<>(), modelContactos2 = new DefaultListModel<>(),
				modelContactos3 = new DefaultListModel<>(), modelContactos4 = new DefaultListModel<>(),
				modelObservaciones = new DefaultListModel<>();

		if (!empresas.isEmpty()) {
			modelSectores.addElement("Sectores");
			modelEmpresas.addElement("Empresas");
			modelPuestos.addElement("Puestos");
			modelDatosContacto.addElement("Datos de contacto");
			modelContactosEmpresa.addElement("Contacto en la empresa");
			modelContactosApnabi.addElement("Persona de contacto");
			modelEstados.addElement("Estado");
			modelContactos1.addElement("1. contacto");
			modelContactos2.addElement("2. contacto");
			modelContactos3.addElement("3. contacto");
			modelContactos4.addElement("4. contacto");
			modelObservaciones.addElement("Observaciones");
			for (Empresa emp : empresas.values()) {
				switch (emp.getSector()) {
				case AGRICULTURA_GANADERIA:
					modelSectores.addElement("Agricultura y ganadería");
					break;

				case BIENESCONSUMO:
					modelSectores.addElement("Bienes de consumo");
					break;

				case COMERCIOELECTRONICO:
					modelSectores.addElement("Comercio electrónico");
					break;

				case COMERCIO_ESTABLECIMIENTOS:
					modelSectores.addElement("Comercio y establecimientos");
					break;

				case CONSTRUCCION:
					modelSectores.addElement("Construcción");
					break;

				case DEPORTE_OCIO:
					modelSectores.addElement("Deporte y ocio");
					break;

				case ENERGIA_MEDIOAMBIENTE:
					modelSectores.addElement("Energía y medio ambiente");
					break;

				case FINANZAS_SEGUROS_BIENESINMUEBLES:
					modelSectores.addElement("Finanzas, seguros y bienes inmuebles");
					break;

				case INTERNET:
					modelSectores.addElement("Internet");
					break;

				case LOGISTICA_TRANSPORTE:
					modelSectores.addElement("Logística y transporte");
					break;

				case MEDIOSCOMUNICACION_MARKETING:
					modelSectores.addElement("Medios de comunicación y marketing");
					break;

				case METALURGIA_ELECTRONICA:
					modelSectores.addElement("Metalurgia y electrónica");
					break;

				case PRODUCTOSQUIMICOS_MATERIASPRIMAS:
					modelSectores.addElement("Productos químicos y materias primas");
					break;

				case SALUD_INDUSTRIAFARMACEUTICA:
					modelSectores.addElement("Salud e industria farmacéutica");
					break;

				case SERVICIOS:
					modelSectores.addElement("Servicios");
					break;

				case SOCIEDAD:
					modelSectores.addElement("Sociedad");
					break;

				case TECNOLOGIA_TELECOMUNICACIONES:
					modelSectores.addElement("Tecnología y telecomunicaciones");
					break;

				case TURISMO_HOSTELERIA:
					modelSectores.addElement("Turismo y hostelería");
					break;

				case VIDA:
					modelSectores.addElement("Vida");
					break;

				default:
					System.out.println("Tipo incorrecto");
				}

				switch (emp.getEstado()) {
				case INFORMADO:
					modelEstados.addElement("Informado");
					break;

				case NOINTERESADO:
					modelEstados.addElement("No interesado");
					break;

				case PLANIFICANDOINSERCIONES:
					modelEstados.addElement("Planificando inserciones");
					break;

				case PROXIMOAÑO:
					modelEstados.addElement("Proximo año");
					break;

				case VALORANDO_INTERESADO:
					modelEstados.addElement("Valorando/interesado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}

				modelEmpresas.addElement(emp.getNom_empresa());
				if (emp.getPuesto()==null) {
					modelPuestos.addElement("---");
				} else {
					modelPuestos.addElement(emp.getPuesto());
				}
				modelDatosContacto.addElement(emp.getDatosContacto());
				modelContactosEmpresa.addElement(emp.getContactoEmpresa());
				modelContactosApnabi.addElement(emp.getContactoApnabi());
				modelContactos1.addElement(emp.getContacto1());

				if (emp.getContacto2().equals("")) {
					modelContactos2.addElement("---");
				} else {
					modelContactos2.addElement(emp.getContacto2());
				}

				if (emp.getContacto3().equals("")) {
					modelContactos3.addElement("---");
				} else {
					modelContactos3.addElement(emp.getContacto3());
				}

				if (emp.getContacto4().equals("")) {
					modelContactos4.addElement("---");
				} else {
					modelContactos4.addElement(emp.getContacto4());
				}

				if (emp.getObservaciones()==null) {
					modelObservaciones.addElement("---");
				} else {
					modelObservaciones.addElement(emp.getObservaciones());
				}
			}
			listSectores.setModel(modelSectores);
			listEmpresas.setModel(modelEmpresas);
			listPuestos.setModel(modelPuestos);
			listDatosContacto.setModel(modelDatosContacto);
			listContactosEmpresa.setModel(modelContactosEmpresa);
			listContactosApnabi.setModel(modelContactosApnabi);
			listEstados.setModel(modelEstados);
			listContacto1.setModel(modelContactos1);
			listContacto2.setModel(modelContactos2);
			listContacto3.setModel(modelContactos3);
			listContacto4.setModel(modelContactos4);
			listObservaciones.setModel(modelObservaciones);
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == btnModificarEmpresa) {
			if (!listEmpresas.isSelectionEmpty()) {
				if (!listEmpresas.getSelectedValue().equals("Empresas")) {
					VentanaModificar dialog = new VentanaModificar(this, cont, cont.getEmpresa(listEmpresas.getSelectedValue()));
					dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "[ERROR] No se puede modificar el titulo de la columna.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elija una empresa de la lista de empresas.");
			}
		}
	}
}
