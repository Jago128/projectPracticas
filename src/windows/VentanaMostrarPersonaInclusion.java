package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import controller.LoginController;
import model.Usuario;

public class VentanaMostrarPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;


	public VentanaMostrarPersonaInclusion(JDialog parent, LoginController cont, Usuario user) {
		setBounds(100, 100, 450, 300);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
