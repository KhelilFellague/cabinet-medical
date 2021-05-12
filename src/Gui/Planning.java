package Gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.time.LocalTime;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import org.jdesktop.swingx.JXDatePicker;
import com.github.lgooddatepicker.components.TimePicker;
import com.github.lgooddatepicker.components.TimePickerSettings;
import com.github.lgooddatepicker.components.TimePickerSettings.TimeArea;

import Models.Patient;
import Models.Rdv;
import Models.Secretaire;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Planning extends JFrame {
	
	private JPanel contentPane;
	
/*
 * on mettra la secretaire qui a crée le rdv comme argument pour ajouter le rdv créé a son arraylist, apres dans Secretaire page
 * dans l'action listener pour prendre un rdv il y'aura l'appel à la methode fireTableDataChanged(); qui notifiera la table modele de 
 * la jtable Rtable(celles des rdv)
 */
	/**
	 * @wbp.parser.constructor
	 */
	public Planning(String nom,String prenom,Secretaire s) { 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		TimePickerSettings timeSettings = new TimePickerSettings();
        timeSettings.setColor(TimeArea.TimePickerTextValidTime, Color.blue);
        timeSettings.initialTime = LocalTime.now();
        
		JLabel patientLabel = new JLabel("Patient : ");
		patientLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblDate = new JLabel("* Date : ");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblHeure = new JLabel("* Heure : ");
		lblHeure.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JTextArea patientText = new JTextArea(nom+" "+prenom);
		patientText.setEditable(false);
		
		JLabel lblType = new JLabel("* Type : ");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JXDatePicker datePicker = new JXDatePicker();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		datePicker.setFormats(sdf);
		TimePicker timePicker = new TimePicker(timeSettings);
		
		JTextArea typeText = new JTextArea();
		typeText.setToolTipText("N'utilisez pas d'apostrophe !!!");
		typeText.setRows(3);
		
		JButton createButton = new JButton("Enregistrer");
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				Rdv rdv = new Rdv();
				rdv.setDate_rdv(datePicker.getDate());
				rdv.setHeure_rdv(timePicker.getText().toString());
				rdv.setPatient(Patient.ReadString(patientText.getText().substring(0, patientText.getText().indexOf(' ')) ));
				rdv.setType(typeText.getText());
				if(rdv.getPatient()!=null) {
					if(Rdv.create(rdv)==false ) {
						JOptionPane.showMessageDialog(rootPane, "Le rendez-vous n'a pas été enregistré veuillez réessayer", "Erreur Enregistrement", 1);

					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Le rendez-vous a bien été  enregistré", "Enregistrement effectué", 1);
						s.getRdvs().add(rdv);
						setVisible(false);
					}
				}//fin if
				else {
					if(Rdv.createN(rdv)==false ) {
						JOptionPane.showMessageDialog(rootPane, "Le rendez-vous n'a pas été enregistré veuillez réessayer", "Erreur Enregistrement", 1);

					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Le rendez-vous a bien été  enregistré", "Enregistrement effectué", 1);
						s.getRdvs().add(rdv);
						setVisible(false);
					}
				}
			}});//fin du action listener
		createButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRendezvous = new JLabel("  Rendez-vous");
		lblRendezvous.setFont(new Font("Tahoma", Font.BOLD, 11));


		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(patientLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(patientText, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(datePicker, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHeure, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(timePicker, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(typeText, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(106, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(48)
					.addComponent(createButton)
					.addPreferredGap(ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
					.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(138))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(211)
					.addComponent(lblRendezvous, GroupLayout.PREFERRED_SIZE, 91, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(226, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRendezvous)
					.addGap(40)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(patientLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(patientText, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(datePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblHeure, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(40)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblType, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addComponent(typeText, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)))
						.addComponent(timePicker, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(createButton)
						.addComponent(cancelButton, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(31))
		);
		contentPane.setLayout(gl_contentPane);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
	}
}
