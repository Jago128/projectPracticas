package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaBorrarPersonaInclusion extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listPersonas;

	public VentanaBorrarPersonaInclusion(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Borrar personas en inclusion");
		setBounds(100, 100, 380, 380);
		getContentPane().setLayout(null);

		JLabel lblInfo = new JLabel("Seleccione el nombre de la persona en inclusion a borrar:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 94, 346, 23);
		getContentPane().add(lblInfo);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaBorrarPersonaInclusion.class.getResource("/img/apnabilan.png")));
		logo.setBounds(10, 10, 325, 78);
		getContentPane().add(logo);

		listPersonas = new JList<>();
		listPersonas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPersonas.setBounds(76, 127, 236, 163);
		listPersonas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listPersonas);

		JScrollPane scrollPane = new JScrollPane(listPersonas);
		scrollPane.setBounds(76, 127, 236, 163);
		getContentPane().add(scrollPane);

		addNomPersonas();

		btnBorrar = new JButton("Borrar");
		btnBorrar.setBackground(new Color(38, 201, 236));
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(131, 300, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);
	}

	public void addNomPersonas() {
		Map<String, PersonaInclusion> personasInclusion = cont.mostrarNomPersonasInclusion();
		DefaultListModel<String> modelPersonas = new DefaultListModel<>();

		listPersonas.removeAll();
		if (!personasInclusion.isEmpty()) {
			for (PersonaInclusion p : personasInclusion.values()) {
				modelPersonas.addElement(p.getNombre());
			}
			listPersonas.setModel(modelPersonas);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna persona en inclusion para visualizar."
							+ "\nPor favor, añada una persona en inclusion anter de abrir esta ventana.",
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
								"¿Esta seguro de que quieras borrar la persona en inclusion '"
										+ listPersonas.getSelectedValue() + "'?",
								"Confirmacion", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (cont.eliminarPersonaInclusion(listPersonas.getSelectedValue())) {
						result = JOptionPane.showConfirmDialog(null,
								"La persona en inclusion ha sido borrada correctamente. ¿Quiere borrar mas personas en inclusion?",
								"Persona en inclusion eliminada", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							addNomPersonas();
							listPersonas.setSelectedIndex(-1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"La persona en inclusion que estas intentando borrar no existe.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay ninguna seleccion hecha. Por favor, selecciona una persona en inclusion de la lista.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
