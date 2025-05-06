package windows;

import java.awt.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaContactosYObservaciones extends JDialog {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JList<String> listContacto1, listContacto2, listContacto3, listContacto4, listObservaciones;

	public VentanaContactosYObservaciones(JDialog parent, LoginController cont, String nomEmp, Usuario user) {
		super(parent, true);
		setTitle("Contactos y Observaciones de "+nomEmp);
		this.cont = cont;

		setBounds(100, 100, 750, 430);
		getContentPane().setLayout(null);

		listContacto1 = new JList<>();
		listContacto1.setBounds(25, 94, 132, 286);

		listContacto2 = new JList<>();
		listContacto2.setBounds(157, 94, 132, 286);

		listContacto3 = new JList<>();
		listContacto3.setBounds(288, 94, 132, 286);

		listContacto4 = new JList<>();
		listContacto4.setBounds(420, 94, 132, 286);

		listObservaciones = new JList<>();
		listObservaciones.setBounds(552, 94, 162, 286);

		loadContactosObservaciones();

		JPanel panel = new JPanel();
		panel.setBounds(25, 94, 689, 286);
		panel.add(listContacto1);
		panel.add(listContacto2);
		panel.add(listContacto3);
		panel.add(listContacto4);
		panel.add(listObservaciones);
		getContentPane().add(panel);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(25, 94, 689, 286);
		getContentPane().add(scrollPane);

		JLabel lblContactos1 = new JLabel("Contacto 1");
		lblContactos1.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactos1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactos1.setBounds(44, 58, 90, 26);
		getContentPane().add(lblContactos1);

		JLabel lblContactos2 = new JLabel("Contacto 2");
		lblContactos2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactos2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactos2.setBounds(172, 58, 90, 26);
		getContentPane().add(lblContactos2);

		JLabel lblContactos3 = new JLabel("Contacto 3");
		lblContactos3.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactos3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactos3.setBounds(304, 58, 90, 26);
		getContentPane().add(lblContactos3);

		JLabel lblContactos4 = new JLabel("Contacto 4");
		lblContactos4.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactos4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactos4.setBounds(437, 58, 90, 26);
		getContentPane().add(lblContactos4);

		JLabel lblObservaciones = new JLabel("Observaciones");
		lblObservaciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblObservaciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObservaciones.setBounds(579, 58, 105, 26);
		getContentPane().add(lblObservaciones);

		JLabel lblInfo = new JLabel("Si quieres ver los contactos y observaciones de otra empresa, "+user.getNombre()+", vuelve a la ventana anterior.");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setBounds(70, 22, 604, 26);
		getContentPane().add(lblInfo);
	}

	public void loadContactosObservaciones() {
		Map<String, Empresa> empresas = cont.mostrarEmpresas();
		DefaultListModel<String> modelContactos1 = new DefaultListModel<>(), modelContactos2 = new DefaultListModel<>(),
				modelContactos3 = new DefaultListModel<>(), modelContactos4 = new DefaultListModel<>(), modelObservaciones = new DefaultListModel<>();

		if (!empresas.isEmpty()) {
			for (Empresa emp:empresas.values()) {
				modelContactos1.addElement(emp.getContacto1());
				
				if (emp.getObservaciones()==null) {
					modelContactos2.addElement("");
				} else {
					modelContactos2.addElement(emp.getContacto2());
				}
				
				if (emp.getObservaciones()==null) {
					modelContactos3.addElement("");
				} else {
					modelContactos3.addElement(emp.getContacto3());
				}
				
				if (emp.getObservaciones()==null) {
					modelContactos4.addElement("");
				} else {
					modelContactos4.addElement(emp.getContacto4());
				}
				
				if (emp.getObservaciones()==null) {
					modelObservaciones.addElement("");
				} else {
					modelObservaciones.addElement(emp.getObservaciones());
				}
			}
			listContacto1.setModel(modelContactos1);
			listContacto2.setModel(modelContactos2);
			listContacto3.setModel(modelContactos3);
			listContacto4.setModel(modelContactos4);
			listObservaciones.setModel(modelObservaciones);
		}
	}
}