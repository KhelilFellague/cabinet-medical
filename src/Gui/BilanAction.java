package Gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BilanAction extends JFrame {

	private JPanel contentPane;
	private JTextField nomtf;
	private JTextField resultattf;

	/**
	 * Create the frame.
	 */
	public BilanAction() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 685, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel noml = new JLabel("Nom Bilan");
		noml.setBounds(36, 53, 68, 14);
		contentPane.add(noml);
		
		JLabel resultatl = new JLabel("Resultat");
		resultatl.setBounds(394, 53, 68, 14);
		contentPane.add(resultatl);
		
		JButton addButton = new JButton("Enregistrer");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton.setBounds(195, 210, 89, 23);
		contentPane.add(addButton);
		
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cancelButton.setBounds(325, 210, 89, 23);
		contentPane.add(cancelButton);
		
		nomtf = new JTextField();
		nomtf.setBounds(114, 50, 186, 20);
		contentPane.add(nomtf);
		nomtf.setColumns(10);
		
		resultattf = new JTextField();
		resultattf.setColumns(10);
		resultattf.setBounds(444, 50, 186, 20);
		contentPane.add(resultattf);
	}
}
