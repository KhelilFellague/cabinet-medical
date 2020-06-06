
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;


@SuppressWarnings("serial")
public class MedecinPage extends JFrame {
	
	private JPanel contentPane;
	private final JPanel panel_main = new JPanel();
	private panelStat p_stat;
	private panelGestionPatient p_gestion_patient;
	private panelConsultation p_consultation;

	/**
	 * Cr	eate the frame.
	 */
	public MedecinPage() {
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(null);
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1215, 813);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//CREATION DES FENETRES
		
		p_gestion_patient = new panelGestionPatient();
		p_stat = new panelStat();
		p_consultation = new panelConsultation();
		
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 102, 204));
		panelMenu.setBounds(0, 0, 315, 783);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panel_gestion_patient = new JPanel();
		panel_gestion_patient.addMouseListener(new PanelButtonMouseAdapter(panel_gestion_patient) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(p_gestion_patient);
			}
		});	
		panel_gestion_patient.setForeground(new Color(0, 0, 51));
		panel_gestion_patient.setBackground(new Color(0, 102, 204));
		panel_gestion_patient.setBounds(0, 227, 315, 75);
		panelMenu.add(panel_gestion_patient);
		panel_gestion_patient.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(167, 5, 0, 0);
		panel_gestion_patient.add(label);
		
		JLabel lblGestionDesPatients = new JLabel("Gestion des patients");
		lblGestionDesPatients.setBackground(new Color(0, 0, 51));
		lblGestionDesPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesPatients.setForeground(new Color(255, 255, 255));
		lblGestionDesPatients.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGestionDesPatients.setBounds(63, 17, 212, 38);
		panel_gestion_patient.add(lblGestionDesPatients);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/patient_icon.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(0, 5, 66, 58);
		panel_gestion_patient.add(lblNewLabel_1_1);
		
		JPanel panel_stat = new JPanel();
		panel_stat.addMouseListener(new PanelButtonMouseAdapter(panel_stat) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(p_stat);
			}
		});	
		
		panel_stat.setForeground(new Color(0, 0, 51));
		panel_stat.setBackground(new Color(0, 102, 204));
		panel_stat.setBounds(0, 301, 323, 82);
		panelMenu.add(panel_stat);
		panel_stat.setLayout(null);
		
		JLabel lblConsulterLesStatistiques = new JLabel("Consulter les statistiques");
		lblConsulterLesStatistiques.setBackground(new Color(0, 0, 51));
		lblConsulterLesStatistiques.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsulterLesStatistiques.setForeground(new Color(255, 255, 255));
		lblConsulterLesStatistiques.setFont(new Font("Dialog", Font.BOLD, 16));
		lblConsulterLesStatistiques.setBounds(66, 12, 245, 58);
		panel_stat.add(lblConsulterLesStatistiques);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/stat_icon.png")));
		lblNewLabel_1.setBounds(0, 12, 66, 58);
		panel_stat.add(lblNewLabel_1);
		
		JPanel panel_consultation = new JPanel();
		panel_consultation.addMouseListener(new PanelButtonMouseAdapter(panel_consultation) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(p_consultation);
			}
		});	
		
		panel_consultation.setForeground(new Color(0, 0, 51));
		panel_consultation.setBackground(new Color(0, 102, 204));
		panel_consultation.setBounds(0, 383, 315, 82);
		panelMenu.add(panel_consultation);
		panel_consultation.setLayout(null);
		
		JLabel lblInscrireLeDiagnostique = new JLabel("Le diagnostic  ");
		lblInscrireLeDiagnostique.setBackground(new Color(0, 0, 51));
		lblInscrireLeDiagnostique.setHorizontalAlignment(SwingConstants.CENTER);
		lblInscrireLeDiagnostique.setForeground(new Color(255, 255, 255));
		lblInscrireLeDiagnostique.setFont(new Font("Dialog", Font.BOLD, 16));
		lblInscrireLeDiagnostique.setBounds(47, 12, 197, 70);
		panel_consultation.add(lblInscrireLeDiagnostique);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/diagnostic_icon .png")));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setBounds(0, 12, 66, 58);
		panel_consultation.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/home_icon.jpg")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 0, 303, 227);
		panelMenu.add(lblNewLabel);
		
		JPanel panel_deconnecter = new JPanel();
		panel_deconnecter.addMouseListener(new PanelButtonMouseAdapter(panel_deconnecter) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "veuillez vous confirmer votre deconnexion")==0)	 {
					//Login flogin = new Login();
					//flogin.setVisible(true);
					MedecinPage.this.dispose();
				}
			}
		});	
		
		panel_deconnecter.setLayout(null);
		panel_deconnecter.setForeground(new Color(0, 0, 51));
		panel_deconnecter.setBackground(new Color(0, 102, 204));
		panel_deconnecter.setBounds(0, 465, 315, 75);
		panelMenu.add(panel_deconnecter);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(167, 5, 0, 0);
		panel_deconnecter.add(label_1);
		
		JLabel lblDeconnecter = new JLabel("Deconnecter");
		lblDeconnecter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeconnecter.setForeground(Color.WHITE);
		lblDeconnecter.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeconnecter.setBackground(new Color(0, 0, 51));
		lblDeconnecter.setBounds(55, 12, 155, 58);
		panel_deconnecter.add(lblDeconnecter);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/deconnexion_icon.png")));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(0, 12, 66, 58);
		panel_deconnecter.add(lblNewLabel_1_2_1);
		panel_main.setBounds(317, 0, 898, 783);
		contentPane.add(panel_main);
		panel_main.setLayout(null);
		
		
		//pour ajouter les fenetres a la fenetre principale
		panel_main.add(p_gestion_patient);
		panel_main.add(p_stat);
		panel_main.add(p_consultation);
		menuClicked(panel_gestion_patient);
	}	
	public void menuClicked(JPanel panel) {
		p_gestion_patient.setVisible(false);
		p_stat.setVisible(false);
		p_consultation.setVisible(false);
		
		panel.setVisible(true);
	}
	//cette methode permet de confondre entre les case du mennu en defilant l
       private class PanelButtonMouseAdapter extends MouseAdapter{
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(1, 103, 153));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(0, 102, 204));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(153, 21, 0));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(1, 103, 153));

		}
		
		
	}
}
