import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Login extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JPasswordField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.setUndecorated(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 316, 480);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/images/med2.png")));
		panel.add(lblNewLabel);
		
		Button button = new Button("LOGIN");
		button.setForeground(SystemColor.text);
		button.setBackground(new Color(21,47,82));
		button.setBounds(352, 315, 305, 44);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
		
			}
		});
		frame.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(352, 115, 305, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(352, 151, 305, 11);
		frame.getContentPane().add(separator);
		
		JLabel lblNomDutilisateur = new JLabel("Mot de passe");
		lblNomDutilisateur.setBounds(352, 164, 222, 44);
		frame.getContentPane().add(lblNomDutilisateur);
		
		JLabel lblMotDePasse = new JLabel("Nom d'utilisateur");
		lblMotDePasse.setBounds(352, 59, 222, 44);
		frame.getContentPane().add(lblMotDePasse);
		
		textField_1 = new JPasswordField();
		textField_1.setColumns(10);
		textField_1.setBounds(352, 219, 305, 36);
		frame.getContentPane().add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(352, 255, 305, 11);
		frame.getContentPane().add(separator_1);
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 714, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}