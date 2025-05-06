package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

import controller.LoginController;
import model.Usuario;

public class VentanaBorrar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private LoginController cont;
	private Usuario user;
	private JTextField textFieldNombre;
	private JButton btnBorrar;

	public VentanaBorrar(JFrame parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		this.user = user;

		setTitle("Borrar empresa");
		setBounds(100, 100, 310, 180);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 0, 0);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		getContentPane().setLayout(null);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(94, 85, 101, 21);
		getContentPane().add(btnBorrar);

		JLabel lblMensaje = new JLabel("Introduce el nombre de la empresa a borrar:");
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMensaje.setBounds(10, 25, 271, 21);
		getContentPane().add(lblMensaje);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(33, 56, 237, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			int result = JOptionPane.showConfirmDialog(btnBorrar, "¿Esta seguro de que quieras borrar la empresa '"
					+ textFieldNombre.getText() + "', " + user.getNombre() + "?", "Confirmacion",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				if (cont.eliminarEmpresa(textFieldNombre.getText())) {
					result = JOptionPane.showConfirmDialog(null,
							"La empresa ha sido borrada correctamente. Quiere añadir mas empresas?", "",
							JOptionPane.YES_NO_OPTION);
					if (result == JOptionPane.NO_OPTION) {
						this.dispose();
					} else if (result == JOptionPane.YES_OPTION) {
						textFieldNombre.setText("");
					}
				}
			} else {
				JOptionPane.showMessageDialog(btnBorrar, "La empresa que estas intentando borrar no existe.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
