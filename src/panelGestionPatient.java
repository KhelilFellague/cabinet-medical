import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;


public class panelGestionPatient extends JPanel {

	/**
	 * Create the panel.
	 */
	Connection connection = null;
	private Patient patient;
	private JTable table;
	public panelGestionPatient() {
		setForeground(Color.WHITE);
		setBounds(0,0,898,783);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Dr.Anonym");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setBounds(742, 724, 144, 47);
		add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(12, 119, 874, 581);
		add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 12, 850, 558);
		panel.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		
		JButton btnNewButton = new JButton("Liste des patients");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(153, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//patient.all();
					Connection connexion = Connexion.getConnection();
					String query = "select * from Patient";
					PreparedStatement pst = connexion.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}	
			}
		});
		btnNewButton.setBounds(54, 63, 221, 34);
		add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(12, 57, 45, 47);
		add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon(panelGestionPatient.class.getResource("/images/liste1.png")));
		setVisible(true);
	}
}
