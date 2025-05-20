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
		setBounds(100, 100, 380, 230);
		getContentPane().setLayout(null);

		JLabel lblRegistro = new JLabel("Introduzca la informacion para registrarse:");
		lblRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setBounds(52, 10, 266, 41);
		getContentPane().add(lblRegistro);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(75, 61, 79, 29);
		getContentPane().add(lblNombre);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(64, 94, 90, 29);
		getContentPane().add(lblContraseña);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(164, 67, 96, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(164, 100, 96, 19);
		getContentPane().add(passwordField);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(new Color(38, 201, 236));
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(112, 133, 110, 29);
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
