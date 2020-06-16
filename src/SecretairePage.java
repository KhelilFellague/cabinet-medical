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
public class SecretairePage extends JFrame {
	
	private JPanel contentPane;
	private final JPanel panel_main2 = new JPanel();

	/**
	 * Cr	eate the frame.
	 */
	private Visite p_visite;
	public SecretairePage() {
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
		
		p_visite = new Visite();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 102, 204));
		panelMenu.setBounds(0, 0, 315, 783);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel pp_visite = new JPanel();
		pp_visite.addMouseListener(new PanelButtonMouseAdapter(pp_visite) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(p_visite);
			}
		});	
		pp_visite.setForeground(new Color(0, 0, 51));
		pp_visite.setBackground(new Color(0, 102, 204));
		pp_visite.setBounds(0, 239, 315, 87);
		panelMenu.add(pp_visite);
		pp_visite.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(167, 5, 0, 0);
		pp_visite.add(label);
		
		JLabel lblGestionDesPatients = new JLabel("Les visites");
		lblGestionDesPatients.setBackground(new Color(0, 0, 51));
		lblGestionDesPatients.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestionDesPatients.setForeground(new Color(255, 255, 255));
		lblGestionDesPatients.setFont(new Font("Dialog", Font.BOLD, 16));
		lblGestionDesPatients.setBounds(30, 25, 212, 38);
		pp_visite.add(lblGestionDesPatients);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(SecretairePage.class.getResource("/images/calendar1.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(12, 17, 66, 58);
		pp_visite.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SecretairePage.class.getResource("/images/secretary1.png")));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 303, 227);
		panelMenu.add(lblNewLabel);
		
		JPanel panel_deconnecter = new JPanel();
		panel_deconnecter.addMouseListener(new PanelButtonMouseAdapter(panel_deconnecter) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null, "veuillez vous confirmer votre deconnexion")==0)	 {
					//Login flogin = new Login();
					//flogin.setVisible(true);
					SecretairePage.this.dispose();
				}
			}
		});	
		
		panel_deconnecter.setLayout(null);
		panel_deconnecter.setForeground(new Color(0, 0, 51));
		panel_deconnecter.setBackground(new Color(0, 102, 204));
		panel_deconnecter.setBounds(0, 326, 315, 81);
		panelMenu.add(panel_deconnecter);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(167, 5, 0, 0);
		panel_deconnecter.add(label_1);
		
		JLabel lblDeconnecter = new JLabel("Deconnecter");
		lblDeconnecter.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeconnecter.setForeground(Color.WHITE);
		lblDeconnecter.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDeconnecter.setBackground(new Color(0, 0, 51));
		lblDeconnecter.setBounds(70, 5, 155, 58);
		panel_deconnecter.add(lblDeconnecter);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("");
		lblNewLabel_1_2_1.setIcon(new ImageIcon(MedecinPage.class.getResource("/images/deconnexion_icon.png")));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setBounds(12, 12, 66, 58);
		panel_deconnecter.add(lblNewLabel_1_2_1);
		
		JPanel panel_main2 = new JPanel();
		panel_main2.setBounds(317, 0, 898, 783);
		contentPane.add(panel_main2);
		panel_main2.setLayout(null);
		
		panel_main2.add(p_visite);
		menuClicked(pp_visite);
		
	}	
	public void menuClicked(JPanel panel) {
		panel_main2.setVisible(false);
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
