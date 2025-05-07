package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.Usuario;

public class VentanaPrincipal extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnMostrar;
	private JButton btnAñadir;
	private JButton btnBorrarempresas;
	private LoginController cont;
	private Usuario user;

	public VentanaPrincipal(LoginController cont, Usuario user) {
		this.cont = cont;
		this.user = user;
		
		setResizable(false);
		setTitle("Base de datos Apnabi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnAñadir = new JButton("Añadir empresas");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(213, 103, 145, 45);
		contentPane.add(btnAñadir);

		btnBorrarempresas = new JButton("Borrar empresas");
		btnBorrarempresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarempresas.setBounds(213, 48, 145, 45);
		contentPane.add(btnBorrarempresas);

		btnMostrar = new JButton("Mostrar empresas");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(28, 48, 145, 45);
		contentPane.add(btnMostrar);

		JLabel lblEmpresas = new JLabel("Empresas:");
		lblEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresas.setBounds(115, 10, 138, 28);
		contentPane.add(lblEmpresas);

		JTextArea textAreaModify = new JTextArea();
		textAreaModify.setEditable(false);
		textAreaModify.setBackground(UIManager.getColor("Button.background"));
		textAreaModify.setLineWrap(true);
		textAreaModify.setText("Se modifican las empresas desde esta ventana.");
		textAreaModify.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textAreaModify.setBounds(28, 94, 145, 34);
		contentPane.add(textAreaModify);

		btnAñadir.addActionListener(this);
		btnBorrarempresas.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAñadir) {
			VentanaAñadir dialog = new VentanaAñadir(this, cont);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnBorrarempresas) {
			VentanaBorrar dialog = new VentanaBorrar(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} else if (e.getSource() == btnMostrar) {
			VentanaMostrar dialog = new VentanaMostrar(this, cont, user);
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
