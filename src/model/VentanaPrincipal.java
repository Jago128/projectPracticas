package model;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import windows.VentanaEmpresa;
import windows.VentanaPersona;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnEmpresa;
	private JButton btnPersona;

	public VentanaPrincipal(LoginController cont, Usuario user) {
		this.cont = cont;
		this.user = user;

		setTitle("Bienvenido, "+user.getNombre());
		setBounds(100, 100, 450, 150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblOpciones = new JLabel("Elije una de las dos opciones para gestionar:");
		lblOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpciones.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOpciones.setBounds(80, 10, 268, 30);
		getContentPane().add(lblOpciones);

		btnEmpresa = new JButton("Empresas");
		btnEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEmpresa.setBounds(65, 50, 145, 45);
		getContentPane().add(btnEmpresa);

		btnPersona = new JButton("Personas");
		btnPersona.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPersona.setBounds(230, 50, 145, 45);
		getContentPane().add(btnPersona);
		
		btnEmpresa.addActionListener(this);
		btnPersona.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEmpresa) {
			VentanaEmpresa frame = new VentanaEmpresa(this, cont, user);
			frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} else {
			VentanaPersona dialog = new VentanaPersona(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
