package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaMostrarEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JList<String> listSectores, listEmpresas, listPuestos, listDatosContacto, listContactosEmpresa,
			listContactosApnabi, listEstados, listContacto1, listContacto2, listContacto3, listContacto4,
			listObservaciones, listResultadoUltimoContacto, listInfoUltimo, listResultadoFinal, listFechaResolucion,
			listContEmpresas;
	private JButton btnModificarEmpresa;

	public VentanaMostrarEmpresa(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar empresas");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 920, 480);
		getContentPane().setLayout(null);

		listSectores = new JList<>();
		listSectores.setBackground(new Color(38, 201, 236));
		listSectores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectores.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEmpresas = new JList<String>();
		listEmpresas.setBackground(new Color(38, 201, 236));
		listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listPuestos = new JList<String>();
		listPuestos.setBackground(new Color(38, 201, 236));
		listPuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listDatosContacto = new JList<String>();
		listDatosContacto.setBackground(new Color(38, 201, 236));
		listDatosContacto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDatosContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactosEmpresa = new JList<String>();
		listContactosEmpresa.setBackground(new Color(38, 201, 236));
		listContactosEmpresa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactosEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContactosApnabi = new JList<String>();
		listContactosApnabi.setBackground(new Color(38, 201, 236));
		listContactosApnabi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContactosApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEstados = new JList<String>();
		listEstados.setBackground(new Color(38, 201, 236));
		listEstados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEstados.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContEmpresas = new JList<>();
		listContEmpresas.setBackground(new Color(38, 201, 236));
		listContEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto1 = new JList<>();
		listContacto1.setBackground(new Color(38, 201, 236));
		listContacto1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto2 = new JList<>();
		listContacto2.setBackground(new Color(38, 201, 236));
		listContacto2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto3 = new JList<>();
		listContacto3.setBackground(new Color(38, 201, 236));
		listContacto3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto3.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listContacto4 = new JList<>();
		listContacto4.setBackground(new Color(38, 201, 236));
		listContacto4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listContacto4.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listObservaciones = new JList<>();
		listObservaciones.setBackground(new Color(38, 201, 236));
		listObservaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listResultadoUltimoContacto = new JList<>();
		listResultadoUltimoContacto.setBackground(new Color(38, 201, 236));
		listResultadoUltimoContacto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResultadoUltimoContacto.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listInfoUltimo = new JList<>();
		listInfoUltimo.setBackground(new Color(38, 201, 236));
		listInfoUltimo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listInfoUltimo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listResultadoFinal = new JList<>();
		listResultadoFinal.setBackground(new Color(38, 201, 236));
		listResultadoFinal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listResultadoFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFechaResolucion = new JList<>();
		listFechaResolucion.setBackground(new Color(38, 201, 236));
		listFechaResolucion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFechaResolucion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		addEmpresas();

		JPanel panelEmpresas = new JPanel();
		panelEmpresas.setBackground(new Color(38, 201, 236));
		panelEmpresas.setBounds(10, 10, 886, 170);
		panelEmpresas.add(listSectores);
		panelEmpresas.add(listEmpresas);
		panelEmpresas.add(listPuestos);
		panelEmpresas.add(listDatosContacto);
		panelEmpresas.add(listContactosEmpresa);
		panelEmpresas.add(listContactosApnabi);
		panelEmpresas.add(listEstados);
		getContentPane().add(panelEmpresas);

		JPanel panelContactos = new JPanel();
		panelContactos.setBackground(new Color(38, 201, 236));
		panelContactos.setBounds(10, 190, 886, 174);
		panelContactos.add(listContEmpresas);
		panelContactos.add(listContacto1);
		panelContactos.add(listContacto2);
		panelContactos.add(listContacto3);
		panelContactos.add(listContacto4);
		panelContactos.add(listObservaciones);
		panelContactos.add(listResultadoUltimoContacto);
		panelContactos.add(listInfoUltimo);
		panelContactos.add(listResultadoFinal);
		panelContactos.add(listFechaResolucion);
		getContentPane().add(panelContactos);

		JScrollPane scrollPaneEmpresas = new JScrollPane(panelEmpresas);
		scrollPaneEmpresas.setBounds(10, 10, 886, 170);
		getContentPane().add(scrollPaneEmpresas);

		JScrollPane scrollPaneContactos = new JScrollPane(panelContactos);
		scrollPaneContactos.setBounds(10, 190, 886, 174);
		getContentPane().add(scrollPaneContactos);

		btnModificarEmpresa = new JButton("Modificar empresa");
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarEmpresa.setBounds(501, 361, 395, 72);
		getContentPane().add(btnModificarEmpresa);

		JTextArea textAreaInfo = new JTextArea();
		textAreaInfo.setText("Selecciona un nombre de empresa, y despues pulsa el boton\npara modificar la empresa.");
		textAreaInfo.setLineWrap(true);
		textAreaInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaInfo.setEditable(false);
		textAreaInfo.setBackground(new Color(38, 201, 236));
		textAreaInfo.setBounds(10, 376, 481, 57);
		getContentPane().add(textAreaInfo);
		btnModificarEmpresa.addActionListener(this);
	}

	public void addEmpresas() {
		Map<String, Empresa> empresas = cont.mostrarEmpresas();
		Map<String, Contacto> conts = cont.mostrarContactos();
		DefaultListModel<String> modelSectores = new DefaultListModel<>();
		DefaultListModel<String> modelEmpresas = new DefaultListModel<>();
		DefaultListModel<String> modelPuestos = new DefaultListModel<>();
		DefaultListModel<String> modelDatosContacto = new DefaultListModel<>();
		DefaultListModel<String> modelContactosEmpresa = new DefaultListModel<>();
		DefaultListModel<String> modelContactosApnabi = new DefaultListModel<>();
		DefaultListModel<String> modelEstados = new DefaultListModel<>();
		DefaultListModel<String> modelContEmpresas = new DefaultListModel<>();
		DefaultListModel<String> modelContactos1 = new DefaultListModel<>();
		DefaultListModel<String> modelContactos2 = new DefaultListModel<>();
		DefaultListModel<String> modelContactos3 = new DefaultListModel<>();
		DefaultListModel<String> modelContactos4 = new DefaultListModel<>();
		DefaultListModel<String> modelObservaciones = new DefaultListModel<>();
		DefaultListModel<String> modelResultadoUltimoCont = new DefaultListModel<>();
		DefaultListModel<String> modelInfoUltimo = new DefaultListModel<>();
		DefaultListModel<String> modelResultadoFinal = new DefaultListModel<>();
		DefaultListModel<String> modelFechaResolucion = new DefaultListModel<>();

		if (!empresas.isEmpty() || !conts.isEmpty()) {
			modelSectores.addElement("Sector");
			modelEmpresas.addElement("Empresas");
			modelPuestos.addElement("Puestos");
			modelDatosContacto.addElement("Datos de contactos");
			modelContactosEmpresa.addElement("Contactos en la empresas");
			modelContactosApnabi.addElement("Personas de contactos");
			modelEstados.addElement("Estados");
			modelContEmpresas.addElement("Nombre empresa");
			modelContactos1.addElement("1. contacto");
			modelContactos2.addElement("2. contacto");
			modelContactos3.addElement("3. contacto");
			modelContactos4.addElement("4. contacto");
			modelObservaciones.addElement("Observaciones");
			modelResultadoUltimoCont.addElement("Resultados del ultimo contacto");
			modelInfoUltimo.addElement("Informacion ultimo contacto");
			modelResultadoFinal.addElement("Resultados finales prospeccion");
			modelFechaResolucion.addElement("Fechas de resoluciones");
			for (Empresa emp : empresas.values()) {
				if (emp.getSector() != null) {
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
						modelSectores.addElement("oops");
						System.out.println("Tipo sector incorrecto");
					}
				} else {
					modelSectores.addElement("---");
				}

				if (emp.getEstado() != null) {
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
						modelEstados.addElement("Bugged out!");
					}
				} else {
					modelEstados.addElement("---");
				}

				modelEmpresas.addElement(emp.getNom_empresa());
				if (emp.getPuesto() == null) {
					modelPuestos.addElement("---");
				} else {
					modelPuestos.addElement(emp.getPuesto());
				}

				if (emp.getDatosContacto() == null) {
					modelDatosContacto.addElement("---");
				} else {
					modelDatosContacto.addElement(emp.getDatosContacto());
				}

				if (emp.getContactoEmpresa() == null) {
					modelContactosEmpresa.addElement("---");
				} else {
					modelContactosEmpresa.addElement(emp.getContactoEmpresa());
				}

				modelContactosApnabi.addElement(emp.getContactoApnabi());
			}
			for (Contacto con : conts.values()) {
				if (con.getResultadoUltimoContacto() == null) {
					modelResultadoUltimoCont.addElement("---");
				} else {
					switch (con.getResultadoUltimoContacto()) {
					case COMUNICACION_SINRESPUESTA:
						modelResultadoUltimoCont.addElement("Comunicacion sin respuesta");
						break;

					case INICIO_VALORACIONOFERTA:
						modelResultadoUltimoCont.addElement("Inicio valoracion oferta");
						break;

					case RESPUESTA_NOCONCLUYENTE:
						modelResultadoUltimoCont.addElement("Respuesta no concluyente");
						break;

					case RESPUESTA_POSPUESTA:
						modelResultadoUltimoCont.addElement("Nos pospone la respuesta");
						break;

					case REUNION_PROGRAMADA:
						modelResultadoUltimoCont.addElement("Programada reunion");
						break;

					default:
						System.out.println("Tipo invalido.");
						modelResultadoUltimoCont.addElement("Bugged out!");
					}
				}

				if (con.getResultadoFinal() == null) {
					modelResultadoFinal.addElement("---");
				} else {
					switch (con.getResultadoFinal()) {
					case CONVENIO_COLABORACION:
						modelResultadoFinal.addElement("Convenio de colaboracion");
						break;

					case MEDIDAS_ALTERNATIVAS:
						modelResultadoFinal.addElement("Medidas alternativas");
						break;

					case OFERTA_EMPLEO:
						modelResultadoFinal.addElement("Oferta de empleo");
						break;

					case RELACION_CONCLUIDA:
						modelResultadoFinal.addElement("Relacion concluida");
						break;

					case RELACION_POSPUESTA:
						modelResultadoFinal.addElement("Relacion pospuesta");
						break;

					default:
						System.out.println("Tipo invalido.");
					}
				}

				modelContEmpresas.addElement(con.getEmp_Nom());
				if (con.getContacto1() == null) {
					modelContactos1.addElement("---");
				} else {
					modelContactos1.addElement(con.getContacto1());
				}

				if (con.getContacto2() == null) {
					modelContactos2.addElement("---");
				} else {
					modelContactos2.addElement(con.getContacto2());
				}

				if (con.getContacto3() == null) {
					modelContactos3.addElement("---");
				} else {
					modelContactos3.addElement(con.getContacto3());
				}

				if (con.getContacto4() == null) {
					modelContactos4.addElement("---");
				} else {
					modelContactos4.addElement(con.getContacto4());
				}

				if (con.getObservaciones() == null) {
					modelObservaciones.addElement("---");
				} else {
					modelObservaciones.addElement(con.getObservaciones());
				}

				if (con.getInfoUltimo() == null) {
					modelInfoUltimo.addElement("---");
				} else {
					modelInfoUltimo.addElement(con.getInfoUltimo());
				}

				if (con.getFechaResolucion() == null) {
					modelFechaResolucion.addElement("---");
				} else {
					modelFechaResolucion.addElement(con.getFechaResolucion());
				}
			}

			listSectores.setModel(modelSectores);
			listEmpresas.setModel(modelEmpresas);
			listPuestos.setModel(modelPuestos);
			listDatosContacto.setModel(modelDatosContacto);
			listContactosEmpresa.setModel(modelContactosEmpresa);
			listContactosApnabi.setModel(modelContactosApnabi);
			listEstados.setModel(modelEstados);
			// List here
			listContacto1.setModel(modelContactos1);
			listContacto2.setModel(modelContactos2);
			listContacto3.setModel(modelContactos3);
			listContacto4.setModel(modelContactos4);
			listObservaciones.setModel(modelObservaciones);
			listResultadoUltimoContacto.setModel(modelResultadoUltimoCont);
			listInfoUltimo.setModel(modelInfoUltimo);
			listResultadoFinal.setModel(modelResultadoFinal);
			listFechaResolucion.setModel(modelFechaResolucion);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna empresa para visualizar."
							+ "\nPor favor, añada una empresa anter the abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnModificarEmpresa) {
			if (!listEmpresas.isSelectionEmpty()) {
				if (!listEmpresas.getSelectedValue().equals("Empresas")) {
					VentanaModificarEmpresa dialog = new VentanaModificarEmpresa(this, cont,
							cont.getEmpresa(listEmpresas.getSelectedValue()));
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
