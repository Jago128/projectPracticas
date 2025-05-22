package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.*;

public class VentanaBorrarEmpresa extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listEmpresas;

	public VentanaBorrarEmpresa(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;

		setResizable(false);
		setTitle("Borrar empresa");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 360, 400);
		getContentPane().setLayout(null);

		JLabel lblInfo = new JLabel("Seleccione el nombre de la empresa a borrar:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(41, 98, 256, 23);
		getContentPane().add(lblInfo);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaBorrarEmpresa.class.getResource("/img/apnabilan.png")));
		logo.setBounds(10, 10, 325, 78);
		getContentPane().add(logo);

		listEmpresas = new JList<>();
		listEmpresas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listEmpresas.setBounds(76, 131, 188, 163);
		listEmpresas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listEmpresas);

		JScrollPane scrollPane = new JScrollPane(listEmpresas);
		scrollPane.setBounds(76, 131, 188, 163);
		getContentPane().add(scrollPane);

		addNomEmpresas();

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(116, 304, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);
	}

	public void addNomEmpresas() {
		Map<String, Empresa> empresas = cont.mostrarNomEmpresas();
		DefaultListModel<String> modelEmpresas = new DefaultListModel<>();

		listEmpresas.removeAll();
		if (!empresas.isEmpty()) {
			for (Empresa emp : empresas.values()) {
				modelEmpresas.addElement(emp.getNom_empresa());
			}
			listEmpresas.setModel(modelEmpresas);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ninguna empresa para visualizar."
							+ "\nPor favor, añada una empresa anter de abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			if (!listEmpresas.isSelectionEmpty()) {
				int result = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro de que quieras borrar la empresa '" + listEmpresas.getSelectedValue() + "'?",
						"Confirmacion", JOptionPane.YES_NO_OPTION);

				if (result == JOptionPane.YES_OPTION) {
					if (cont.eliminarContacto(listEmpresas.getSelectedValue())) {
						if (cont.eliminarEmpresa(listEmpresas.getSelectedValue())) {
							result = JOptionPane.showConfirmDialog(null,
									"La empresa ha sido borrada correctamente. ¿Quiere borrar mas empresas?",
									"Empresa eliminada", JOptionPane.YES_NO_OPTION);
							if (result == JOptionPane.NO_OPTION) {
								this.dispose();
							} else if (result == JOptionPane.YES_OPTION) {
								addNomEmpresas();
								listEmpresas.setSelectedIndex(-1);
							}
						} else {
							JOptionPane.showMessageDialog(null, "La empresa que estas intentando borrar no existe.",
									"ERROR", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "La empresa que estas intentando borrar no existe.",
								"ERROR", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay ninguna seleccion hecha. Por favor, selecciona una empresa de la lista.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
