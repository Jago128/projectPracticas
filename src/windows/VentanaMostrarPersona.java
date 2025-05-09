package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaMostrarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private LoginController cont;
	// private Usuario user;
	private JList<String> listNom, listApoyo, listFormacion, listEspecialidad, listSectorInteres,
	listCVLink, listCertifDiscapacidad, listEuskera, listIngles, listOtrosIdiomas, listLocalidad, listObservaciones,
	listAccesibilidad, listInfoUltimo, listResultadoFinal, listFechaResolucion;
	private JButton btnModificarEmpresa;
	
	public VentanaMostrarPersona(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Mostrar empresas");
		setBounds(100, 100, 920, 480);
		getContentPane().setLayout(null);

		listNom = new JList<>();
		listNom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listNom.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listApoyo = new JList<String>();
		listApoyo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listApoyo.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listFormacion = new JList<String>();
		listFormacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFormacion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEspecialidad = new JList<String>();
		listEspecialidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEspecialidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listSectorInteres = new JList<String>();
		listSectorInteres.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSectorInteres.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCVLink = new JList<String>();
		listCVLink.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCVLink.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listCertifDiscapacidad = new JList<String>();
		listCertifDiscapacidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCertifDiscapacidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listEuskera = new JList<>();
		listEuskera.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEuskera.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listIngles = new JList<>();
		listIngles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listIngles.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listOtrosIdiomas = new JList<>();
		listOtrosIdiomas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOtrosIdiomas.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listLocalidad = new JList<>();
		listLocalidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));

		listAccesibilidad = new JList<>();
		listAccesibilidad.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAccesibilidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		listObservaciones = new JList<>();
		listObservaciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 886, 170);
		panel.add(listNom);
		panel.add(listApoyo);
		panel.add(listFormacion);
		panel.add(listEspecialidad);
		panel.add(listSectorInteres);
		panel.add(listCVLink);
		panel.add(listCertifDiscapacidad);
		panel.add(listEuskera);
		panel.add(listIngles);
		panel.add(listOtrosIdiomas);
		panel.add(listLocalidad);
		panel.add(listAccesibilidad);
		panel.add(listObservaciones);
		getContentPane().add(panel);

		JScrollPane scrollPaneEmpresas = new JScrollPane(panel);
		scrollPaneEmpresas.setBounds(10, 10, 886, 170);
		getContentPane().add(scrollPaneEmpresas);

		btnModificarEmpresa = new JButton("Modificar empresa");
		btnModificarEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnModificarEmpresa.setBounds(263, 361, 395, 72);
		getContentPane().add(btnModificarEmpresa);
		btnModificarEmpresa.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		VentanaModificarPersona dialog = new VentanaModificarPersona(this, cont, null); // Not ready
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
