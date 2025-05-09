package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton btnMostrar;
	private JButton btnAñadir;
	private JButton btnBorrar;
	private LoginController cont;
	private Usuario user;

	public VentanaEmpresa(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;
		
		setResizable(false);
		setTitle("Empresas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 180);
		getContentPane().setLayout(null);

		btnAñadir = new JButton("Añadir empresas");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(215, 76, 145, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar empresas");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(215, 21, 145, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar empresas");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(29, 31, 145, 45);
		getContentPane().add(btnMostrar);

		JTextArea textAreaInfoModificar = new JTextArea();
		textAreaInfoModificar.setEditable(false);
		textAreaInfoModificar.setBackground(UIManager.getColor("Button.background"));
		textAreaInfoModificar.setLineWrap(true);
		textAreaInfoModificar.setText("Se modifican las empresas desde esta ventana.");
		textAreaInfoModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoModificar.setBounds(25, 79, 145, 34);
		getContentPane().add(textAreaInfoModificar);

		btnAñadir.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadirEmpresa dialog = new VentanaAñadirEmpresa(this, cont);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrar) {
			VentanaBorrarEmpresa dialog = new VentanaBorrarEmpresa(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrarEmpresa dialog = new VentanaMostrarEmpresa(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
