package Gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import Models.Medecin;
import Models.Patient;

import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import org.jdesktop.swingx.JXDatePicker;


@SuppressWarnings("serial")
public class PatientAction extends JFrame {
	
	private JPanel contentPane;
	private JTextField emailtf;
	private JTextField nomtf;
	private JTextField prenomtf;
	private JTextField adressetf;
	private JTextField numtf;
	private JXDatePicker datePicker = new JXDatePicker();
	private String sexe[]={"Femme","Homme"}; 
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private JComboBox comboBox = new JComboBox(sexe);
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public PatientAction(Medecin m, JTable t) {
		setType(Type.POPUP);
		setBounds(100, 100, 897, 422);
//TODO INIT the main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
//TODO INIT LES LABELS		
		JLabel NomLabel = new JLabel("Nom  : ");
		NomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel PrenomLabel = new JLabel("Prénom  : ");
		PrenomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel DatenLabel = new JLabel("Né(e) le  : ");
		DatenLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel SexeLabel = new JLabel("Sexe  : ");
		SexeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel AdresseLabel = new JLabel("Adresse  : ");
		AdresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel NumTLabel = new JLabel("Téléphone  : ");
		NumTLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel EmailLabel = new JLabel("Email  : ");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//TODO INIT LES TEXT FIELD ET DATE PICKER ...		
		emailtf = new JTextField();
		emailtf.setColumns(10);
		
		nomtf = new JTextField();
		nomtf.setColumns(10);
		
		prenomtf = new JTextField();
		prenomtf.setColumns(10);
		
		adressetf = new JTextField();
		adressetf.setColumns(10);
		
		numtf = new JTextField();
		numtf.setColumns(10);
		
		
		datePicker.setToolTipText("selectionnez ou ecrivez une date dd/MM/yyyy");
		//init la table model
		DefaultTableModel model = (DefaultTableModel) t.getModel();
		
		
		
		JButton enregistrerB = new JButton("Enregistrer");
		enregistrerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient p = new Patient();

				try {
				
					p.setNom(nomtf.getText());
					p.setPrenom(prenomtf.getText());
					p.setDate_naissance(datePicker.getDate());
					p.setSexe(comboBox.getItemAt(comboBox.getSelectedIndex()).toString());
					p.setAdresse(adressetf.getText());
					p.setNum_tel(numtf.getText());
					p.setEmail(emailtf.getText());
					if(p.getNom()!=null &&p.getPrenom()!=null &&p.getDate_naissance()!=null &&p.getSexe()!=null &&p.getAdresse()!=null &&p.getNum_tel()!=null &&p.getEmail()!=null ) {
						if(Patient.create(p)==false ) {
							JOptionPane.showMessageDialog(rootPane, "Le patient n'a pas été enregistré veuillez réessayer", "Erreur Enregistrement", 1);
						}
						else {
							JOptionPane.showMessageDialog(rootPane, "Le patient a bien été  enregistré", "Enregistrement effectué", 1);
							p.setId_patient(Patient.ReadString(p.getNom()).getId_patient());
							m.getPatients().add(p);
							((AbstractTableModel) t.getModel()).fireTableDataChanged();
							//§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
					model.addRow(new Object[] {p.getId_patient(),p.getNom(),p.getPrenom(),p.getDate_naissance(),p.getSexe(),p.getAdresse(),p.getNum_tel(),p.getEmail()});
								
							}
							dispose();
						}
					
					else 	JOptionPane.showMessageDialog(rootPane, " Veuillez remplir toutes les cases", "Erreur", 1);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex, "Erreur", 1);
				}
			}
		});
		
		JButton annulerB = new JButton("Annuler");
		annulerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("             Nouveau Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		
		
		//layout and add ...
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(EmailLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
						.addComponent(NomLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(DatenLabel)
						.addComponent(SexeLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(nomtf, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(datePicker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(emailtf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(AdresseLabel)
						.addComponent(NumTLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(PrenomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(numtf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(prenomtf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
						.addComponent(adressetf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
					.addGap(62))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(346)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(enregistrerB)
							.addGap(44)
							.addComponent(annulerB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(314, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(NomLabel)
						.addComponent(nomtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(prenomtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(PrenomLabel))
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(DatenLabel)
						.addComponent(adressetf, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
						.addComponent(AdresseLabel)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(SexeLabel)
						.addComponent(numtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(NumTLabel))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(EmailLabel)
						.addComponent(emailtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(enregistrerB)
						.addComponent(annulerB))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}//fin du premier constructeur qui est utilisé pour creer un patient
	
//TODO init un autre constructeur qui sera utiliser pour changer les infos d'un patient
	public PatientAction(Medecin m, JTable t,int id, String s1, String s2,Date d,String s3,String s4,String s5, String s6,int row) {
		setBounds(100, 100, 897, 422);
		setType(Type.POPUP);
//TODO INIT the main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
//TODO INIT LES LABELS		
		JLabel NomLabel = new JLabel("Nom  : ");
		NomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel PrenomLabel = new JLabel("Prénom  : ");
		PrenomLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel DatenLabel = new JLabel("Né(e) le  : ");
		DatenLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel SexeLabel = new JLabel("Sexe  : ");
		SexeLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel AdresseLabel = new JLabel("Adresse  : ");
		AdresseLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel NumTLabel = new JLabel("Téléphone  : ");
		NumTLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel EmailLabel = new JLabel("Email  : ");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
//TODO INIT LES TEXT FIELD ET DATE PICKER ...		
		emailtf = new JTextField();
		emailtf.setColumns(10);
		
		nomtf = new JTextField();
		nomtf.setColumns(10);
		
		prenomtf = new JTextField();
		prenomtf.setColumns(10);
		
		adressetf = new JTextField();
		adressetf.setColumns(10);
		
		numtf = new JTextField();
		numtf.setColumns(10);
		
		//remplir les textfield
		nomtf.setText(s1);
		prenomtf.setText(s2);
		datePicker.setDate(d);
		comboBox.setSelectedItem(s3);
		adressetf.setText(s4);
		numtf.setText(s5);
		emailtf.setText(s6);
		
		datePicker.setToolTipText("selectionnez ou ecrivez une date dd/MM/yyyy");
		
		//init la table model
				DefaultTableModel model = (DefaultTableModel) t.getModel();
		
		
		JButton enregistrerB = new JButton("Enregistrer");
		enregistrerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Patient p = new Patient();

				try {
					p.setId_patient(id);
					p.setNom(nomtf.getText());
					p.setPrenom(prenomtf.getText());
					p.setDate_naissance(datePicker.getDate());
					p.setSexe(comboBox.getItemAt(comboBox.getSelectedIndex()).toString());
					p.setAdresse(adressetf.getText());
					p.setNum_tel(numtf.getText());
					p.setEmail(emailtf.getText());
					if(p.getNom()!=null &&p.getPrenom()!=null &&p.getDate_naissance()!=null &&p.getSexe()!=null &&p.getAdresse()!=null &&p.getNum_tel()!=null &&p.getEmail()!=null ) {
						if(Patient.update(p)==false ) {
							JOptionPane.showMessageDialog(rootPane, "Le patient n'a pas été mis à jour veuillez réessayer", "Erreur mis à jour", 1);

						}
						else {
							JOptionPane.showMessageDialog(rootPane, "Le patient a bien été  mis à jour", "Mis à jour effectué", 1);
							p.setId_patient(Patient.ReadString(p.getNom()).getId_patient());
							m.getPatients().add(p);
							((AbstractTableModel) t.getModel()).fireTableDataChanged();
							//§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
						
							//model.fireTableRowsUpdated(row, row); not working :(
							model.removeRow(row);
							model.addRow(new Object[] {p.getId_patient(),p.getNom(),p.getPrenom(),p.getDate_naissance(),p.getSexe(),p.getAdresse(),p.getNum_tel(),p.getEmail()});
							dispose();
						}
					}
					else 	JOptionPane.showMessageDialog(rootPane, " Veuillez remplir toutes les cases", "Erreur", 1);
				}
				catch(Exception ex) {
					JOptionPane.showMessageDialog(rootPane, ex, "Erreur", 1);
				}
			}
		});
		
		JButton annulerB = new JButton("Annuler");
		annulerB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("         Mis à jour Patient");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		//layout and add ...
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(EmailLabel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
								.addComponent(NomLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
								.addComponent(DatenLabel)
								.addComponent(SexeLabel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(nomtf, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(datePicker, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(emailtf, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)))
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(AdresseLabel)
								.addComponent(NumTLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(PrenomLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(numtf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addComponent(prenomtf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE)
								.addComponent(adressetf, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
							.addGap(62))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(346)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(enregistrerB)
									.addGap(44)
									.addComponent(annulerB, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(314, Short.MAX_VALUE))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(NomLabel)
								.addComponent(nomtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(prenomtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(PrenomLabel))
							.addGap(48)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(DatenLabel)
								.addComponent(adressetf, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addComponent(AdresseLabel)
								.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(SexeLabel)
								.addComponent(numtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(NumTLabel))
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(EmailLabel)
								.addComponent(emailtf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(enregistrerB)
								.addComponent(annulerB))
							.addContainerGap())
				);
				contentPane.setLayout(gl_contentPane);
	}

}
