package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnMostrar, btnAñadir, btnBorrar;
	
	public VentanaPersonaInclusion(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;

		setResizable(false);
		setTitle("Personas inclusion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 170);
		getContentPane().setLayout(null);

		btnAñadir = new JButton("Añadir personas inclusion");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(224, 67, 161, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar personas inclusion");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(224, 10, 161, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar personas inclusion");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(35, 10, 169, 45);
		getContentPane().add(btnMostrar);

		JTextArea textAreaInfoModificar = new JTextArea();
		textAreaInfoModificar.setEditable(false);
		textAreaInfoModificar.setBackground(UIManager.getColor("Button.background"));
		textAreaInfoModificar.setLineWrap(true);
		textAreaInfoModificar.setText("Se modifican las personas inclusion desde esta ventana.");
		textAreaInfoModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoModificar.setBounds(25, 56, 192, 34);
		getContentPane().add(textAreaInfoModificar);

		btnAñadir.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnMostrar.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadirPersonaInclusion dialog = new VentanaAñadirPersonaInclusion(this, cont);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrar) {
			VentanaBorrarPersonaInclusion dialog = new VentanaBorrarPersonaInclusion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrarPersonaInclusion dialog = new VentanaMostrarPersonaInclusion(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
