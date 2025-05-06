package windows;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;

public class VentanaBorrar extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private final JPanel contentPanel = new JPanel();
	private LoginController cont;

	public VentanaBorrar(JFrame parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		getContentPane().setLayout(null);
	
	}
}
