package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaMenuEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton btnMostrar, btnAñadir, btnBorrar;
	private LoginController cont;
	private Usuario user;

	public VentanaMenuEmpresa(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;

		setResizable(false);
		setTitle("Empresas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 230);
		getContentPane().setLayout(null);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));

		btnAñadir = new JButton("Añadir");
		btnAñadir.setBackground(new Color(38, 201, 236));
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(204, 99, 145, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(38, 201, 236));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(379, 99, 145, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.setForeground(new Color(0, 0, 0));
		btnMostrar.setBackground(new Color(38, 201, 236));
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(38, 201, 236));
		panel.setBounds(0, 10, 556, 86);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel logo = new JLabel("");
		logo.setBounds(171, 0, 225, 78);
		panel.add(logo);
		logo.setIcon(new ImageIcon(VentanaMenuAnalisisPuesto.class.getResource("/img/LOGOAPNABI.png")));

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
