package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;

public class VentanaBorrar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private LoginController cont;
	private JTextField textField;

	public VentanaBorrar(JFrame parent, LoginController cont) {
		super(parent, true);
		setTitle("Borrar empresa");
		this.cont = cont;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(76, 102, 101, 21);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Introduce el nombre de la empresa a borrar:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 25, 271, 21);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(33, 56, 237, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
