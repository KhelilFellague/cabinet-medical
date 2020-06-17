package Gui;
import java.awt.*;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Models.Medecin;
import Models.Secretaire;


/**
 * @author Assia,Ines
 *
 */

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;
	private Medecin medecin ;
	private Secretaire secretaire ;
	/**
	 * Create the application.
	 */

	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(Color.WHITE);
		getFrame().getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 316, 471);
		getFrame().getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("New label");
		File sourceimage = new File("C:\\Users\\DaMi\\ProjetGL\\Cabinet-Médical\\Assets\\docteur.png");
		try {
			Image image = ImageIO.read(sourceimage);
			lblNewLabel.setIcon(new ImageIcon(image));
			panel.add(lblNewLabel);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Button button = new Button("LOGIN");
		button.setForeground(SystemColor.text);
		button.setBackground(new Color(21,47,82));
		button.setBounds(352, 315, 305, 44);

		button.addActionListener(new ActionListener() {

			// action performed du boutton login			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();	
				String psw = textField_1.getText();	

				// si l'utilisateur laisse une case vide (ou les deux ), un message d'erreur apparaitra 
				if(name.equals("")||psw.equals("")) {
					JOptionPane.showMessageDialog(rootPane, " Veuillez remplir toutes les cases", "Erreur", 1);
				}
				//sinon
				else {

					//debut try connexion a la bd
					try {
						medecin = Medecin.Read(name,psw); 

						if(medecin != null) {	
						MedecinPage med = new MedecinPage();
						med.setMedecin(medecin);
						med.setVisible(true);
						
						setVisible(false);
						}

						else {
							secretaire = Secretaire.Read(name,psw); 
							if(secretaire != null) {
								SecretairePage sec = new SecretairePage(); 
								sec.setSecretaire(secretaire);
								sec.setVisible(true);
								setVisible(false);}

							else {// medecin et secretaire non existant dans la bd 
								JOptionPane.showMessageDialog(rootPane, "Nom d'utilisateur ou mot de passe erroné", "Erreur login", 1);
							}
						}
					}//fin try connexion a la bd

					catch(Exception ex ) {
						System.out.println("ERREUR DE CONNEXION "+ ex);
						System.out.println(ex.getStackTrace());
						System.out.println(ex.getCause());
					}


				}
			}


			;}); //FIN ACTION LISTENER  

		getFrame().getContentPane().add(button);
		textField = new JTextField();
		textField.setBounds(352, 115, 305, 36);
		getFrame().getContentPane().add(textField);
		textField.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(352, 151, 305, 11);
		getFrame().getContentPane().add(separator);

		JLabel lblNomDutilisateur = new JLabel("Mot de passe");
		lblNomDutilisateur.setBounds(352, 164, 222, 44);
		getFrame().getContentPane().add(lblNomDutilisateur);

		JLabel lblMotDePasse = new JLabel("Nom d'utilisateur");
		lblMotDePasse.setBounds(352, 59, 222, 44);
		getFrame().getContentPane().add(lblMotDePasse);

		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(352, 219, 305, 36);
		getFrame().getContentPane().add(textField_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(352, 255, 305, 11);
		getFrame().getContentPane().add(separator_1);
		getFrame().setBackground(Color.WHITE);
		getFrame().setBounds(100, 100, 714, 510);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}
	//getters + setters 
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}



}
