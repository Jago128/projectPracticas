package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
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
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
