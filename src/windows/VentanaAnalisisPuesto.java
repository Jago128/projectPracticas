package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private Usuario user;
	private JButton btnMostrar, btnAñadir, btnBorrar;

	public VentanaAnalisisPuesto(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(255, 255, 255));
		getContentPane().setBackground(new Color(255, 255, 255));
		this.cont = cont;
		this.user = user;

		setResizable(false);
		setTitle("Analisis de puestos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 210);
		getContentPane().setLayout(null);

		btnAñadir = new JButton("Añadir");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(191, 115, 145, 45);
		getContentPane().add(btnAñadir);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(20, 115, 145, 45);
		getContentPane().add(btnBorrar);

		btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(236, 10, 145, 45);
		getContentPane().add(btnMostrar);

		JTextArea textAreaInfoModificar = new JTextArea();
		textAreaInfoModificar.setEditable(false);
		textAreaInfoModificar.setBackground(new Color(255, 255, 255));
		textAreaInfoModificar.setLineWrap(true);
		textAreaInfoModificar.setText("Se modifican los analisis de puestos\r\ndesde esta ventana.");
		textAreaInfoModificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaInfoModificar.setBounds(236, 54, 195, 34);
		getContentPane().add(textAreaInfoModificar);
		
		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaAnalisisPuesto.class.getResource("/img/LOGOAPNABI.png")));
		logo.setBounds(10, 10, 225, 95);
		getContentPane().add(logo);

		btnAñadir.addActionListener(this);
		btnBorrar.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadirAnalisisPuesto dialog = new VentanaAñadirAnalisisPuesto(this, cont);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrar) {
			VentanaBorrarAnalisisPuesto dialog = new VentanaBorrarAnalisisPuesto(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrarAnalisisPuesto dialog = new VentanaMostrarAnalisisPuesto(this, cont, user);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
