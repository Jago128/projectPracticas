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
	private JButton btnModificarEmpresas;
	private JButton btnBorrarempresas;
	private LoginController cont;
	private Usuario user;

	public VentanaPrincipal(LoginController cont, Usuario user) {
		this.cont = cont;
		this.user = user;
		setTitle("Base de datos Apnabi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnAñadir = new JButton("Añadir empresas");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAñadir.setBounds(209, 48, 145, 45);
		contentPane.add(btnAñadir);
		
		btnModificarEmpresas = new JButton("Modificar empresas");
		btnModificarEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificarEmpresas.setBounds(30, 103, 145, 45);
		contentPane.add(btnModificarEmpresas);
		
		btnBorrarempresas = new JButton("Borrar empresas");
		btnBorrarempresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrarempresas.setBounds(209, 103, 145, 45);
		contentPane.add(btnBorrarempresas);
		
		btnMostrar = new JButton("Mostrar empresas");
		btnMostrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMostrar.setBounds(30, 48, 145, 45);
		contentPane.add(btnMostrar);
		
		JLabel lblEmpresas = new JLabel("Empresas:");
		lblEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresas.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresas.setBounds(115, 10, 138, 28);
		contentPane.add(lblEmpresas);
		
		btnAñadir.addActionListener(this);
		btnBorrarempresas.addActionListener(this);
		btnModificarEmpresas.addActionListener(this);
		btnMostrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAñadir) {
			VentanaAñadir dialog = new VentanaAñadir(this, cont);
			dialog.setVisible(true);
		} else if (e.getSource()==btnBorrarempresas) {
			VentanaBorrar dialog = new VentanaBorrar(this, cont);
			dialog.setVisible(true);
		} else if (e.getSource()==btnModificarEmpresas) {
			VentanaModificar dialog = new VentanaModificar(this, cont);
			dialog.setVisible(true);
		} else if (e.getSource()==btnMostrar) {
			VentanaMostrar dialog = new VentanaMostrar(this, cont, user);
			dialog.setVisible(true);
		}
	}
}
