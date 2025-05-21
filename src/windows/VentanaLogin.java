package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaLogin extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPasswordField passwordField;
	private JTextField textFieldNombre;
	private JButton btnIniciarSesion, btnRegistro;
	private LoginController cont;
	private JLabel lblMensaje;

	public VentanaLogin(LoginController cont) {
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;

		setResizable(false);
		setTitle("Inicio de sesion");
		setBounds(100, 100, 410, 260);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaLogin.class.getResource("/img/apnabilan.png")));
		logo.setBounds(39, 9, 325, 78);
		getContentPane().add(logo);

		passwordField = new JPasswordField();
		passwordField.setBounds(211, 138, 96, 19);
		getContentPane().add(passwordField);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(211, 97, 96, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(75, 90, 126, 30);
		getContentPane().add(lblNombre);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(75, 131, 126, 30);
		getContentPane().add(lblContraseña);

		btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIniciarSesion.setBounds(62, 186, 126, 30);
		getContentPane().add(btnIniciarSesion);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(221, 186, 126, 30);
		getContentPane().add(btnRegistro);

		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(39, 186, 308, 30);
		getContentPane().add(lblMensaje);

		btnIniciarSesion.addActionListener(this);
		btnRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciarSesion) {
			if (textFieldNombre.getText().isBlank() && new String(passwordField.getPassword()).isBlank()) {
				lblMensaje.setText("Los campos estan vacios.");
				JOptionPane.showMessageDialog(null, "Por favor, rellena los campos.", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			} else {
				Usuario user = new Usuario(textFieldNombre.getText(), new String(passwordField.getPassword()));
				if (cont.verificarUsuario(user)) {
					if (cont.verificarContraseñaUsuario(user)) {
						user = cont.getUsuario(user);
						lblMensaje.setText("Se ha iniciado sesion correctamente.");
						JOptionPane.showMessageDialog(null, "Bienvenido, " + user.getNombre());
						VentanaMenuPrincipal frame = new VentanaMenuPrincipal(cont, user);
						frame.setVisible(true);
						this.dispose();
					} else {
						lblMensaje.setText("Contraseña incorrecta.");
						JOptionPane.showMessageDialog(null, "La contraseña introducida es incorrecta.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					lblMensaje.setText("No existe el usuario introducido.");
					JOptionPane.showMessageDialog(null,
							"No existe el usuario " + user.getNombre() + ". Registrase para iniciar sesion.", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		if (e.getSource() == btnRegistro) {
			VentanaRegistro dialog = new VentanaRegistro(cont);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			this.dispose();
		}
	}
}
