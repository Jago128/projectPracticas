package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaBorrarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listEmpresas;

	public VentanaBorrarPersona(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Borrar empresa");
		setBounds(100, 100, 310, 300);
		getContentPane().setLayout(null);

		listEmpresas = new JList<String>();
		listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresas.setBounds(63, 43, 188, 163);
		listEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listEmpresas);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(91, 216, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);

		JLabel lblInfo = new JLabel("Seleccione el nombre de la empresa a borrar:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(25, 10, 256, 23);
		getContentPane().add(lblInfo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
