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
	private Usuario user;
	private JList<String> listSectores, listEmpresas, listPuestos, listDatosContacto, listContactosEmpresa, listContactosApnabi, listEstados;
	private JButton btnContactos, btnModificarEmpresa;

	public VentanaMostrar(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;
		setTitle("Mostrar Empresas");
		setBounds(100, 100, 920, 600);
		getContentPane().setLayout(null);

		listSectores = new JList<>();
		listSectores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listSectores.setBounds(10, 56, 123, 417);

		listEmpresas = new JList<String>();
		listEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listEmpresas.setBounds(130, 56, 130, 417);

		listPuestos = new JList<String>();
		listPuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listPuestos.setBounds(258, 56, 116, 417);

		listDatosContacto = new JList<String>();
		listDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listDatosContacto.setBounds(370, 56, 138, 417);

		listContactosEmpresa = new JList<String>();
		listContactosEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listContactosEmpresa.setBounds(503, 56, 143, 417);

		listContactosApnabi = new JList<String>();
		listContactosApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listContactosApnabi.setBounds(640, 56, 150, 417);

		listEstados = new JList<String>();
		listEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));
		listEstados.setBounds(790, 56, 106, 417);

		addEmpresas();

		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 886, 417);
		panel.add(listSectores);
		panel.add(listEmpresas);
		panel.add(listPuestos);
		panel.add(listDatosContacto);
		panel.add(listContactosEmpresa);
		panel.add(listContactosApnabi);
		panel.add(listEstados);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 56, 886, 417);
		getContentPane().add(scrollPane);

		JLabel lblSectores = new JLabel("Sectores");
		lblSectores.setHorizontalAlignment(SwingConstants.CENTER);
		lblSectores.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSectores.setBounds(30, 20, 90, 26);
		getContentPane().add(lblSectores);

		JLabel lblEmpresas = new JLabel("Empresas");
		lblEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresas.setBounds(142, 20, 90, 26);
		getContentPane().add(lblEmpresas);

		JLabel lblPuestos = new JLabel("Puestos");
		lblPuestos.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuestos.setBounds(258, 20, 90, 26);
		getContentPane().add(lblPuestos);

		JLabel lblDatosContacto = new JLabel("Datos de contacto");
		lblDatosContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatosContacto.setBounds(374, 20, 123, 26);
		getContentPane().add(lblDatosContacto);

		JLabel lblContactosEmpresa = new JLabel("Contacto en la empresa");
		lblContactosEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactosEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactosEmpresa.setBounds(495, 20, 151, 26);
		getContentPane().add(lblContactosEmpresa);

		JLabel lblPersonasContacto = new JLabel("Persona de Contacto");
		lblPersonasContacto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonasContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPersonasContacto.setBounds(651, 20, 130, 26);
		getContentPane().add(lblPersonasContacto);

		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(803, 20, 80, 26);
		getContentPane().add(lblEstado);

		btnContactos = new JButton("Ver contactos y Observaciones");
		btnContactos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnContactos.setBounds(465, 483, 431, 59);
		getContentPane().add(btnContactos);

		btnModificarEmpresa = new JButton("Modificar empresa");
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarEmpresa.setBounds(20, 483, 431, 59);
		getContentPane().add(btnModificarEmpresa);

		btnContactos.addActionListener(this);
	}

	public void addEmpresas() {
		Map<String, Empresa> empresas = cont.mostrarEmpresas();
		DefaultListModel<String> modelSector = new DefaultListModel<>(), modelNom = new DefaultListModel<>(), modelPuesto = new DefaultListModel<>(),
				modelDatosContacto = new DefaultListModel<>(), modelContactosEmpresa = new DefaultListModel<>(), modelContactosApnabi = new DefaultListModel<>(),
				modelEstado = new DefaultListModel<>();

		listSectores.removeAll();
		listEmpresas.removeAll();
		listPuestos.removeAll();
		listDatosContacto.removeAll();
		listContactosEmpresa.removeAll();
		listContactosApnabi.removeAll();
		listEstados.removeAll();

		if (!empresas.isEmpty()) {
			for (Empresa emp:empresas.values()) {
				switch (emp.getSector()) {
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
				
				switch (emp.getEstado()) {
				case INFORMADO:
					modelEstado.addElement("Informado");
					break;

				case NOINTERESADO:
					modelEstado.addElement("No interesado");
					break;

				case PLANIFICANDOINSERCIONES:
					modelEstado.addElement("Planificando inserciones");
					break;

				case PROXIMOAÑO:
					modelEstado.addElement("Proximo año");
					break;

				case VALORANDO_INTERESADO:
					modelEstado.addElement("Valorando/interesado");
					break;

				default:
					System.out.println("Tipo invalido.");
				}
				
				modelNom.addElement(emp.getNom_empresa());
				modelPuesto.addElement(emp.getPuesto());
				modelDatosContacto.addElement(emp.getDatosContacto());
				modelContactosEmpresa.addElement(emp.getContactoEmpresa());
				modelContactosApnabi.addElement(emp.getContactoApnabi());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnContactos) {
			if (!listEmpresas.isSelectionEmpty()) {
				VentanaContactosYObservaciones dialog = new VentanaContactosYObservaciones(this, cont, listEmpresas.getSelectedValue(), user);
				dialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elija una empresa de la lista de nombres de empresas.");
			}
		} else {
			if (!listEmpresas.isSelectionEmpty()) {
				VentanaModificar dialog = new VentanaModificar(this, cont, cont.getEmpresa(listEmpresas.getSelectedValue()));
				dialog.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "[ERROR] Elija una empresa de la lista de nombres de empresas.");
			}
		}
	}
}
