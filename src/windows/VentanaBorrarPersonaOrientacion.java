package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaBorrarPersonaOrientacion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listPersonas;

	public VentanaBorrarPersonaOrientacion(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Borrar personas en orientacion y seguimiento");
		setBounds(100, 100, 400, 300);
		getContentPane().setLayout(null);

		listPersonas = new JList<>();
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setBounds(77, 43, 251, 163);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listPersonas);

		addNomPersonas();

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(38, 201, 236));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(134, 216, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);

		JLabel lblInfo = new JLabel("Seleccione el nombre de la persona en orientacion a borrar:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(23, 10, 352, 23);
		getContentPane().add(lblInfo);
	}

	public void addNomPersonas() {
		Map<String, PersonaOrientacion> personasOrientacion = cont.mostrarNomPersonas();
		DefaultListModel<String> modelPersonas = new DefaultListModel<>();

		listPersonas.removeAll();
		if (!personasOrientacion.isEmpty()) {
			for (PersonaOrientacion p : personasOrientacion.values()) {
				modelPersonas.addElement(p.getNombre());
			}
			listPersonas.setModel(modelPersonas);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona en orientacion para visualizar."
							+ "\nPor favor, añada una persona en orientacion anter de abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			if (!listPersonas.isSelectionEmpty()) {
				int result = JOptionPane
						.showConfirmDialog(null,
								"¿Esta seguro de que quieras borrar la persona en orientacion '"
										+ listPersonas.getSelectedValue() + "'?",
								"Confirmacion", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (cont.eliminarPersona(listPersonas.getSelectedValue())) {
						result = JOptionPane.showConfirmDialog(null,
								"La persona en orientacion ha sido borrada correctamente. ¿Quiere borrar mas personas en orientacion?",
								"Persona en orientacion eliminada", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							addNomPersonas();
							listPersonas.setSelectedIndex(-1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"La persona en orientacion que estas intentando borrar no existe.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay ninguna seleccion hecha. Por favor, selecciona una persona en orientacion de la lista.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
