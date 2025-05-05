package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.Usuario;

public class LoginWindow extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton btnIniciarSesion, btnRegistro;
	private LoginController cont;
	private JLabel lblMensa;

	public LoginWindow() {
		setBounds(100, 100, 410, 290);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("Inicio de sesion");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(126, 10, 126, 30);
		contentPanel.add(lblTitulo);

		passwordField = new JPasswordField();
		passwordField.setBounds(203, 98, 96, 19);
		contentPanel.add(passwordField);

		textField = new JTextField();
		textField.setBounds(203, 57, 96, 19);
		contentPanel.add(textField);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(67, 50, 126, 30);
		contentPanel.add(lblNombre);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.CENTER);
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(67, 91, 126, 30);
		contentPanel.add(lblContraseña);

		btnIniciarSesion = new JButton("Iniciar sesion");
		btnIniciarSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIniciarSesion.setBounds(54, 146, 126, 30);
		contentPanel.add(btnIniciarSesion);

		btnRegistro = new JButton("Registrarse");
		btnRegistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRegistro.setBounds(213, 146, 126, 30);
		contentPanel.add(btnRegistro);
		
		lblMensa = new JLabel("Inicio de sesion");
		lblMensa.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensa.setBounds(54, 198, 308, 30);
		contentPanel.add(lblMensa);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource()==btnIniciarSesion) {
			Usuario user = new Usuario(textField.getText(), new String(passwordField.getPassword()));
			if (cont.verificarUsuario(user)) {
				if (cont.verificarContraseñaUsuario(user)) {
					
				} else {
					
				}
			} else {
				
			}
			
			MainWindow frame = new MainWindow();
			frame.setVisible(true);
		}

	}
}
