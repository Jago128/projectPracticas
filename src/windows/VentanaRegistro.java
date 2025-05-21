package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaRegistro extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField textFieldNombre;
	private JPasswordField passwordField;
	private JButton btnRegistro;
	private LoginController cont;

	public VentanaRegistro(LoginController cont) {
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Registro de nuevo usuario");
		setBounds(100, 100, 380, 270);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaRegistro.class.getResource("/img/apnabilan.png")));
		logo.setBounds(10, 10, 325, 78);
		getContentPane().add(logo);

		JLabel lblRegistro = new JLabel("Introduzca la informacion para registrarse:");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(37, 87, 266, 41);
		getContentPane().add(lblRegistro);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(47, 121, 79, 29);
		getContentPane().add(lblNombre);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(36, 150, 90, 29);
		getContentPane().add(lblContraseña);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(136, 127, 150, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(136, 156, 150, 19);
		getContentPane().add(passwordField);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(119, 189, 110, 29);
		getContentPane().add(btnRegistro);
		btnRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistro) {
			if (!textFieldNombre.getText().isBlank() && !new String(passwordField.getPassword()).isBlank()) {
				if (cont.registrarUsuario(
						new Usuario(textFieldNombre.getText(), new String(passwordField.getPassword())))) {
					JOptionPane.showMessageDialog(null, "Se ha registrado el usuario correctamente.");
					LoginController cont = new LoginController();
					cont.showWindow();
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(null, "Ha occurrido un error al registarse.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "No estan rellenados los campos necesarios.");
			}
		}
	}

}
