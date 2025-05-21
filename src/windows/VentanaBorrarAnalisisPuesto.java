package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.Map;

import javax.swing.*;

import controller.LoginController;
import model.AnalisisPuesto;
import model.Usuario;

public class VentanaBorrarAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	// private Usuario user;
	private JButton btnBorrar;
	private JList<String> listAnalisisPuestos;

	public VentanaBorrarAnalisisPuesto(JDialog parent, LoginController cont, Usuario user) {
		super(parent, true);
		setBackground(new Color(38, 201, 236));
		getContentPane().setBackground(new Color(38, 201, 236));
		this.cont = cont;
		// this.user = user;
		setResizable(false);
		setTitle("Borrar analisis de puesto");
		setBounds(100, 100, 450, 390);
		getContentPane().setLayout(null);

		JLabel logo = new JLabel("");
		logo.setIcon(new ImageIcon(VentanaBorrarAnalisisPuesto.class.getResource("/img/apnabilan.png")));
		logo.setBounds(47, 0, 325, 78);
		getContentPane().add(logo);

		JLabel lblInfo = new JLabel("Seleccione el nombre de una empresa para borrar su analisis de puesto:");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBounds(10, 86, 419, 23);
		getContentPane().add(lblInfo);

		listAnalisisPuestos = new JList<>();
		listAnalisisPuestos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAnalisisPuestos.setBounds(92, 119, 255, 163);
		listAnalisisPuestos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		getContentPane().add(listAnalisisPuestos);

		JScrollPane scrollPane = new JScrollPane(listAnalisisPuestos);
		scrollPane.setBounds(92, 119, 255, 163);
		getContentPane().add(scrollPane);

		btnBorrar = new JButton("Borrar");
		btnBorrar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBorrar.setBounds(160, 292, 118, 37);
		getContentPane().add(btnBorrar);
		btnBorrar.addActionListener(this);
	}

	public void loadNomEmpresas() {
		Map<String, AnalisisPuesto> aPs = cont.mostrarAPEmpresas();
		DefaultListModel<String> modelAP = new DefaultListModel<>();

		listAnalisisPuestos.removeAll();
		if (!aPs.isEmpty()) {
			for (AnalisisPuesto aP : aPs.values()) {
				modelAP.addElement(aP.getEmpresa());
			}
			listAnalisisPuestos.setModel(modelAP);
		} else {
			JOptionPane.showMessageDialog(null,
					"No hay ningun analisis de puesto."
							+ "\nPor favor, añada un analisis de puesto anter de abrir esta ventana.",
					"AVISO!", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnBorrar) {
			if (!listAnalisisPuestos.isSelectionEmpty()) {
				int result = JOptionPane.showConfirmDialog(null,
						"¿Esta seguro de que quieras borrar el analisis de puesto de la empresa '"
								+ listAnalisisPuestos.getSelectedValue() + "'?",
						"Confirmacion", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (cont.eliminarAnalisisPuesto(listAnalisisPuestos.getSelectedValue())) {
						result = JOptionPane.showConfirmDialog(null,
								"El analisis de puesto ha sido borrado correctamente. ¿Quiere borrar mas analisis de puestos?",
								"Analisis de puesto eliminado", JOptionPane.YES_NO_OPTION);
						if (result == JOptionPane.NO_OPTION) {
							this.dispose();
						} else if (result == JOptionPane.YES_OPTION) {
							loadNomEmpresas();
							listAnalisisPuestos.setSelectedIndex(-1);
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"El analisis de puesto que esta intentando borrar no existe.", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null,
						"No hay ninguna seleccion hecha. Por favor, selecciona un nombre de empresa de la lista.",
						"ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
