package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaMenuPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnEmpresa, btnPersona, btnAnalisisPuesto, btnPersonaInclusion, btnPersonaPracticas;

	public VentanaMenuPrincipal(LoginController cont, Usuario user) {
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		this.user = user;

		setTitle("Bienvenido, " + user.getNombre());
		setBounds(100, 100, 430, 340);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaMenuPrincipal.class.getResource("/img/apnabilan.png")));
		logo.setBounds(42, 10, 325, 78);
		getContentPane().add(logo);

		JLabel lblOpciones = new JLabel("Elije una de las opciones para gestionar, " + user.getNombre() + ":");
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOpciones.setBounds(36, 98, 328, 30);
		getContentPane().add(lblOpciones);

		btnEmpresa = new JButton("Empresas");
		btnEmpresa.setBackground(new Color(38, 201, 236));
		btnEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEmpresa.setBounds(10, 138, 145, 45);
		getContentPane().add(btnEmpresa);

		btnPersona = new JButton("Personas en Orientacion y seguimiento");
		btnPersona.setBackground(new Color(38, 201, 236));
		btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPersona.setBounds(165, 138, 235, 45);
		getContentPane().add(btnPersona);

		btnAnalisisPuesto = new JButton("Analisis de puesto");
		btnAnalisisPuesto.setBackground(new Color(38, 201, 236));
		btnAnalisisPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAnalisisPuesto.setBounds(10, 193, 198, 45);
		getContentPane().add(btnAnalisisPuesto);

		btnPersonaInclusion = new JButton("Personas en inclusion");
		btnPersonaInclusion.setBackground(new Color(38, 201, 236));
		btnPersonaInclusion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPersonaInclusion.setBounds(218, 193, 177, 45);
		getContentPane().add(btnPersonaInclusion);

		btnPersonaPracticas = new JButton("Personas en practicas");
		btnPersonaPracticas.setBackground(new Color(38, 201, 236));
		btnPersonaPracticas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPersonaPracticas.setBounds(76, 248, 235, 45);
		getContentPane().add(btnPersonaPracticas);

		btnEmpresa.addActionListener(this);
		btnPersona.addActionListener(this);
		btnAnalisisPuesto.addActionListener(this);
		btnPersonaInclusion.addActionListener(this);
		btnPersonaPracticas.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpresa) {
			VentanaMenuEmpresa dialog = new VentanaMenuEmpresa(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnPersona) {
			VentanaMenuPersonaOrientacion dialog = new VentanaMenuPersonaOrientacion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnAnalisisPuesto) {
			VentanaMenuAnalisisPuesto dialog = new VentanaMenuAnalisisPuesto(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnPersonaInclusion) {
			VentanaMenuPersonaInclusion dialog = new VentanaMenuPersonaInclusion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else {
			VentanaMenuPersonaPracticas dialog = new VentanaMenuPersonaPracticas(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
