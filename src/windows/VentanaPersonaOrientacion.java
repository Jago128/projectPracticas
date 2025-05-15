package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaPersonaOrientacion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnMostrar, btnAñadir, btnBorrar;

	public VentanaPersonaOrientacion(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;

		setResizable(false);
		setTitle("Personas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 180);
		getContentPane().setLayout(null);

		btnAñadir = new JButton("Añadir personas");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(215, 76, 145, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar personas");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(215, 21, 145, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar personas");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(29, 31, 145, 45);
		getContentPane().add(btnMostrar);

		JTextArea textAreaInfoModificar = new JTextArea();
		textAreaInfoModificar.setEditable(false);
		textAreaInfoModificar.setBackground(UIManager.getColor("Button.background"));
		textAreaInfoModificar.setLineWrap(true);
		textAreaInfoModificar.setText("Se modifican las personas desde esta ventana.");
		textAreaInfoModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoModificar.setBounds(29, 77, 145, 34);
		getContentPane().add(textAreaInfoModificar);

		btnAñadir.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadirPersonaOrientacion dialog = new VentanaAñadirPersonaOrientacion(this, cont);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrar) {
			VentanaBorrarPersonaOrientacion dialog = new VentanaBorrarPersonaOrientacion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrarPersonaOrientacion dialog = new VentanaMostrarPersonaOrientacion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
