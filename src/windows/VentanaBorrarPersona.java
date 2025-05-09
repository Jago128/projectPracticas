package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaBorrarPersona extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listPersonas;

	public VentanaBorrarPersona(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Borrar persona");
		setBounds(100, 100, 310, 300);
		getContentPane().setLayout(null);

		listPersonas = new JList<String>();
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setBounds(63, 43, 188, 163);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listPersonas);
		
		addNomPersonas();

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(91, 216, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);

		JLabel lblInfo = new JLabel("Seleccione el nombre de la persona a borrar:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(25, 10, 256, 23);
		getContentPane().add(lblInfo);
	}

	public void addNomPersonas() {
		Map<String, Persona> personas = cont.mostrarNomPersonas();
		DefaultListModel<String> modelPersona = new DefaultListModel<>();

		listPersonas.removeAll();

		if (!personas.isEmpty()) {
			for (Persona p : personas.values()) {
				modelPersona.addElement(p.getNombre());
			}
			listPersonas.setModel(modelPersona);
		} else {
			JOptionPane.showMessageDialog(null, "No hay ninguna persona para visualizar."
					+ "\nPor favor, añada una persona anter the abrir esta ventana.", "AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			if (!listPersonas.isSelectionEmpty()) {
				int result = JOptionPane.showConfirmDialog(null, "¿Esta seguro de que quieras borrar la persona '"+listPersonas.getSelectedValue()+"'?",
						"Confirmacion", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (cont.eliminarEmpresa(listPersonas.getSelectedValue())) {
						result = JOptionPane.showConfirmDialog(null, "La persona ha sido borrada correctamente. ¿Quiere borrar mas personas?",
								"Persona eliminada.", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							addNomPersonas();
							listPersonas.setSelectedIndex(-1);
						}
					} else {
						JOptionPane.showMessageDialog(null, "La persona que estas intentando borrar no existe.",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "No hay ninguna seleccion hecha. Por favor, selecciona una persona de la lista.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
