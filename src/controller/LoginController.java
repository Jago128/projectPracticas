package controller;

import model.*;
import windows.LoginWindow;

public class LoginController {
	ApnabiDAO dao = new DBImplementacion();
	
	public void showWindow() {
		LoginWindow dialog = new LoginWindow();
		dialog.setVisible(true);
	}
}
