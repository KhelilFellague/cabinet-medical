package Gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.DossierPatient;
import Models.Patient;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DossierAction extends JFrame {

	private JPanel contentPane;
	private JTextField patienttf;
	private JTextField tailletf;
	private JTextField gstf;


	/**
	 * Create the frame.
	 */
	public DossierAction(Patient pat) {
		setType(Type.POPUP);
		setBounds(100, 100, 897, 422);
//TODO INIT the main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel titre = new JLabel("        Nouveau Dossier");
		titre.setFont(new Font("Tahoma", Font.BOLD, 11));
		titre.setBounds(353, 11, 134, 14);
		contentPane.add(titre);
		
		JLabel patientL = new JLabel("Patient :");
		patientL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		patientL.setBounds(35, 54, 63, 14);
		contentPane.add(patientL);
		
		JLabel tailleL = new JLabel("Taille :");
		tailleL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tailleL.setBounds(35, 139, 63, 14);
		contentPane.add(tailleL);
		
		JLabel gsL = new JLabel("Groupe Sanguin :");
		gsL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gsL.setBounds(430, 53, 117, 17);
		contentPane.add(gsL);
		
		JLabel antecedantsL = new JLabel("Antécédants :");
		antecedantsL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		antecedantsL.setBounds(430, 139, 85, 14);
		contentPane.add(antecedantsL);
		
		patienttf = new JTextField();
		patienttf.setEditable(false);
		patienttf.setBounds(99, 53, 217, 20);
		contentPane.add(patienttf);
		patienttf.setColumns(10);
		patienttf.setText(pat.getNom() +" "+ pat.getPrenom());
		
		tailletf = new JTextField();
		tailletf.setToolTipText("Donnez la taille en cm");
		tailletf.setColumns(10);
		tailletf.setBounds(99, 138, 217, 20);
		contentPane.add(tailletf);
		
		
		gstf = new JTextField();
		gstf.setColumns(10);
		gstf.setBounds(557, 53, 217, 20);
		contentPane.add(gstf);
		
		
		JTextArea antecta = new JTextArea();
		antecta.setRows(7);
		antecta.setToolTipText("Ecrivez tous les antécédants du patient ");
		antecta.setBackground(SystemColor.control);
		antecta.setBounds(525, 136, 346, 165);
		contentPane.add(antecta);
		
		JButton AddButton = new JButton("Enregistrer");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gstf.getText()!=""&&tailletf.getText()!=""&&antecta.getText()!="") {
				DossierPatient d = new DossierPatient();
				Patient p = new Patient();
				p = pat;
				//p = Patient.ReadString(patienttf.getText());
				d.setPatient(p);
				d.setGroupe_sanguin(gstf.getText());
				d.setTaille(tailletf.getText());
				d.setAntecedants(antecta.getText());
				if(DossierPatient.create(d,p.getId_patient())==false ) {
					JOptionPane.showMessageDialog(rootPane, "Le dossier du patient n'a pas été enregistré veuillez réessayer", "Erreur Enregistrement", 1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Le dossier du patient a bien été  enregistré", "Enregistrement effectué", 1);
				p.setDp(d);
				dispose();
				}
				}//fin if
				else 	JOptionPane.showMessageDialog(rootPane, " Veuillez remplir toutes les cases", "Erreur", 1);
			}//fin action event
		});//fin action listener
		AddButton.setBounds(269, 349, 102, 23);
		contentPane.add(AddButton);
		
		JButton cancelButton = new JButton("Annuler");
		cancelButton.setBounds(399, 349, 89, 23);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
	}//fin du premier constructeur qui est utilisé pour la création d'un dossier

//TODO init un deuxieme constructeur popur modifier les infos d'un dossier d'un patient
	/**
	 * @wbp.parser.constructor
	 */
	public DossierAction(Patient pat,String g,String t, String a) {
		setType(Type.POPUP);
		setBounds(100, 100, 897, 422);
//TODO INIT the main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel titre = new JLabel("     Mise à jour Dossier");
		titre.setFont(new Font("Tahoma", Font.BOLD, 11));
		titre.setBounds(353, 11, 162, 14);
		contentPane.add(titre);
		
		JLabel patientL = new JLabel("Patient :");
		patientL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		patientL.setBounds(35, 54, 63, 14);
		contentPane.add(patientL);
		
		JLabel tailleL = new JLabel("Taille :");
		tailleL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tailleL.setBounds(35, 139, 63, 14);
		contentPane.add(tailleL);
		
		JLabel gsL = new JLabel("Groupe Sanguin :");
		gsL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gsL.setBounds(430, 53, 117, 17);
		contentPane.add(gsL);
		
		JLabel antecedantsL = new JLabel("Antécédants :");
		antecedantsL.setFont(new Font("Tahoma", Font.PLAIN, 14));
		antecedantsL.setBounds(430, 139, 85, 14);
		contentPane.add(antecedantsL);
		
		patienttf = new JTextField();
		patienttf.setEditable(false); //il sera modifié si le nom du patients est chnger à partir de la jtable car c'est une info general pas medical 
		patienttf.setBounds(99, 53, 217, 20);
		contentPane.add(patienttf);
		patienttf.setColumns(10);
		patienttf.setText(pat.getNom() +" "+ pat.getPrenom());
		
		tailletf = new JTextField();
		tailletf.setToolTipText("Donnez la taille en cm");
		tailletf.setColumns(10);
		tailletf.setBounds(99, 138, 217, 20);
		contentPane.add(tailletf);
		tailletf.setText(t);
		
		gstf = new JTextField();
		gstf.setColumns(10);
		gstf.setBounds(557, 53, 217, 20);
		contentPane.add(gstf);
		gstf.setText(g);
		
		JTextArea antecta = new JTextArea();
		antecta.setRows(7);
		antecta.setToolTipText("Ecrivez tous les antécédants du patient ");
		antecta.setBackground(SystemColor.control);
		antecta.setBounds(525, 136, 346, 165);
		contentPane.add(antecta);
		antecta.setText(a);
		
		JButton AddButton = new JButton("Enregistrer");
		AddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gstf.getText()!=""&&tailletf.getText()!=""&&antecta.getText()!="") {
				DossierPatient d = new DossierPatient();
				Patient p = new Patient();
				p = pat;
				//p = Patient.ReadString(patienttf.getText());
				d.setPatient(p);
				d.setGroupe_sanguin(gstf.getText());
				d.setTaille(tailletf.getText());
				d.setAntecedants(antecta.getText());
				if(DossierPatient.update(d, p.getId_patient())==false ) {
					JOptionPane.showMessageDialog(rootPane, "Le dossier du patient n'a pas été mis à jour veuillez réessayer", "Erreur Enregistrement", 1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "Le dossier du patient a bien été  mis à jour", "Enregistrement effectué", 1);
				p.setDp(d);
				dispose();
				}
				}//fin if
				else 	JOptionPane.showMessageDialog(rootPane, " Veuillez remplir toutes les cases", "Erreur", 1);
			}//fin action event
		});//fin action listener
		AddButton.setBounds(269, 349, 102, 23);
		contentPane.add(AddButton);
		
		JButton cancelButton = new JButton("Annuler");
		cancelButton.setBounds(399, 349, 89, 23);
		contentPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
