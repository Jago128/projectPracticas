package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaMenuPersonaPracticas extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnMostrar, btnAñadir, btnBorrar;

	public VentanaMenuPersonaPracticas(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;

		setResizable(false);
		setTitle("Personas orientacion y seguimiento");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 230);
		getContentPane().setLayout(null);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaMenuPersonaPracticas.class.getResource("/img/apnabilan.png")));
		logo.setBounds(119, 0, 325, 78);
		getContentPane().add(logo);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(204, 99, 145, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(379, 99, 145, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(24, 99, 145, 45);
		getContentPane().add(btnMostrar);

		JTextArea textAreaInfoModificar = new JTextArea();
		textAreaInfoModificar.setEditable(false);
		textAreaInfoModificar.setBackground(new Color(38, 201, 236));
		textAreaInfoModificar.setLineWrap(true);
		textAreaInfoModificar.setText("Para acceder a la ventana de modificar, se hace desde la ventana de mostrar.");
		textAreaInfoModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaInfoModificar.setBounds(34, 154, 498, 29);
		getContentPane().add(textAreaInfoModificar);

		btnAñadir.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadirPersonaPracticas dialog = new VentanaAñadirPersonaPracticas(this, cont);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrar) {
			VentanaBorrarPersonaPracticas dialog = new VentanaBorrarPersonaPracticas(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrarPersonaPracticas dialog = new VentanaMostrarPersonaPracticas(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
