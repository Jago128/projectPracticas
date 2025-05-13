package windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JDialog;

import controller.LoginController;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VentanaAñadirAnalisisPuesto extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JTextField textFieldEmpresa, textFieldPuesto, textFieldHorario, textFieldUbicacion,
			textFieldContactoEmpresa;
	private JComboBox<String> comboBoxFormacionMinima, comboBoxIdiomasReq, comboBoxResponsableApnabi, comboBoxSector;
	private JButton btnAñadir;

	public VentanaAñadirAnalisisPuesto(JDialog parent, LoginController cont) {
		super(parent, true);
		this.cont = cont;

		setResizable(false);
		setTitle("Añadir empresa");
		setBounds(100, 100, 700, 290);
		getContentPane().setLayout(null);

		JLabel lblObligatorio = new JLabel("Los campos con * son obligatorias.");
		lblObligatorio.setHorizontalAlignment(SwingConstants.CENTER);
		lblObligatorio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblObligatorio.setBounds(227, 10, 209, 19);
		getContentPane().add(lblObligatorio);

		JLabel lblEmpresa = new JLabel("Empresa: *");
		lblEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmpresa.setBounds(30, 39, 89, 31);
		getContentPane().add(lblEmpresa);

		textFieldEmpresa = new JTextField();
		textFieldEmpresa.setColumns(10);
		textFieldEmpresa.setBounds(131, 46, 163, 19);
		getContentPane().add(textFieldEmpresa);

		JLabel lblPuesto = new JLabel("Puesto: *");
		lblPuesto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPuesto.setBounds(359, 39, 89, 31);
		getContentPane().add(lblPuesto);

		textFieldPuesto = new JTextField();
		textFieldPuesto.setColumns(10);
		textFieldPuesto.setBounds(460, 46, 163, 19);
		getContentPane().add(textFieldPuesto);

		JLabel lblHorario = new JLabel("Horario: *");
		lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
		lblHorario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHorario.setBounds(30, 80, 89, 31);
		getContentPane().add(lblHorario);

		textFieldHorario = new JTextField();
		textFieldHorario.setColumns(10);
		textFieldHorario.setBounds(131, 87, 163, 19);
		getContentPane().add(textFieldHorario);

		JLabel lblFormacionMinima = new JLabel("Formacion Minima: *");
		lblFormacionMinima.setHorizontalAlignment(SwingConstants.CENTER);
		lblFormacionMinima.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacionMinima.setBounds(320, 80, 128, 31);
		getContentPane().add(lblFormacionMinima);

		comboBoxFormacionMinima = new JComboBox<String>();
		comboBoxFormacionMinima.setSelectedIndex(0);
		comboBoxFormacionMinima.setBounds(460, 86, 178, 21);
		getContentPane().add(comboBoxFormacionMinima);

		JLabel lblUbicacion = new JLabel("Ubicacion: *");
		lblUbicacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblUbicacion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUbicacion.setBounds(30, 121, 89, 31);
		getContentPane().add(lblUbicacion);

		textFieldUbicacion = new JTextField();
		textFieldUbicacion.setColumns(10);
		textFieldUbicacion.setBounds(131, 128, 163, 19);
		getContentPane().add(textFieldUbicacion);

		JLabel lblSector = new JLabel("Sector: *");
		lblSector.setHorizontalAlignment(SwingConstants.CENTER);
		lblSector.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSector.setBounds(359, 121, 89, 31);
		getContentPane().add(lblSector);

		comboBoxSector = new JComboBox<String>();
		comboBoxSector.setSelectedIndex(0);
		comboBoxSector.setBounds(460, 127, 178, 21);
		getContentPane().add(comboBoxSector);

		JLabel lbl_IdiomasReq = new JLabel("Idiomas requeridos: *");
		lbl_IdiomasReq.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IdiomasReq.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_IdiomasReq.setBounds(10, 162, 133, 31);
		getContentPane().add(lbl_IdiomasReq);

		comboBoxIdiomasReq = new JComboBox<String>();
		comboBoxIdiomasReq.setSelectedIndex(0);
		comboBoxIdiomasReq.setBounds(153, 168, 178, 21);
		getContentPane().add(comboBoxIdiomasReq);

		JLabel lblContactoEmpresa = new JLabel("Contacto con la empresa: *");
		lblContactoEmpresa.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContactoEmpresa.setBounds(341, 162, 155, 31);
		getContentPane().add(lblContactoEmpresa);

		textFieldContactoEmpresa = new JTextField();
		textFieldContactoEmpresa.setColumns(10);
		textFieldContactoEmpresa.setBounds(506, 169, 163, 19);
		getContentPane().add(textFieldContactoEmpresa);

		JLabel lblResponsableApnabi = new JLabel("Responsable de Apnabi: *");
		lblResponsableApnabi.setHorizontalAlignment(SwingConstants.CENTER);
		lblResponsableApnabi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblResponsableApnabi.setBounds(10, 203, 155, 31);
		getContentPane().add(lblResponsableApnabi);

		comboBoxResponsableApnabi = new JComboBox<String>();
		comboBoxResponsableApnabi.setSelectedIndex(0);
		comboBoxResponsableApnabi.setBounds(175, 209, 178, 21);
		getContentPane().add(comboBoxResponsableApnabi);

		btnAñadir = new JButton("Añadir analisis de puesto");
		btnAñadir.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnAñadir.setBounds(383, 198, 286, 37);
		getContentPane().add(btnAñadir);
		btnAñadir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
