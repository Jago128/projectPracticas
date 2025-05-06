package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.Usuario;

public class VentanaLogin extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField textFieldNombre;
	private JButton btnIniciarSesion, btnRegistro;
	private LoginController cont;
	private JLabel lblMensaje;

	public VentanaLogin(LoginController cont) {
		this.cont = cont;
		
		setTitle("Inicio de sesion");
		setBounds(100, 100, 410, 260);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("Base de datos Apnabi");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTitulo.setBounds(126, 10, 138, 30);
		contentPanel.add(lblTitulo);

		passwordField = new JPasswordField();
		passwordField.setBounds(203, 98, 96, 19);
		contentPanel.add(passwordField);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(203, 57, 96, 19);
		contentPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);

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

		lblMensaje = new JLabel("");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(39, 186, 308, 30);
		contentPanel.add(lblMensaje);
		
		btnIniciarSesion.addActionListener(this);
		btnRegistro.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnIniciarSesion) {
			Usuario user = new Usuario(textFieldNombre.getText(), new String(passwordField.getPassword()));
			if (cont.verificarUsuario(user)) {
				if (cont.verificarContraseñaUsuario(user)) {
					user = cont.getUsuario(user);
					lblMensaje.setText("Se ha iniciado sesion correctamente.");
					JOptionPane.showMessageDialog(null, "Bienvenido, "+user.getNombre());
					VentanaPrincipal frame = new VentanaPrincipal(cont, user);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setVisible(true);
					this.dispose();
				} else {
					lblMensaje.setText("Contraseña incorrecta.");
					JOptionPane.showMessageDialog(null, "ERROR", "La contraseña es incorrecta.", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				lblMensaje.setText("No existe el usuario introducido.");
				JOptionPane.showMessageDialog(null, "No existe el usuario "+user.getNombre()+". Registrase para iniciar sesion.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		if (e.getSource()==btnRegistro) {
			VentanaRegistro dialog = new VentanaRegistro(cont);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			this.dispose();
		}
	}
}
