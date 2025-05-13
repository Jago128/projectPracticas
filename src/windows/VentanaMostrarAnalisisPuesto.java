package windows;

import java.awt.EventQueue;

import javax.swing.JDialog;

import controller.LoginController;
import model.Usuario;

public class VentanaMostrarAnalisisPuesto extends JDialog {
	private static final long serialVersionUID = 1L;
	
	

	public VentanaMostrarAnalisisPuesto(JDialog parent, LoginController cont, Usuario user) {
		setBounds(100, 100, 450, 300);

	}

}
