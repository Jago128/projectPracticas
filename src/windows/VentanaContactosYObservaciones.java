package windows;

import java.awt.*;

import javax.swing.*;

import controller.LoginController;

public class VentanaContactosYObservaciones extends JDialog {
	private static final long serialVersionUID = 1L;

	public VentanaContactosYObservaciones(JDialog parent, LoginController cont, String nomEmp) {
		super(parent, true);
		setBounds(100, 100, 450, 300);

	}

}
