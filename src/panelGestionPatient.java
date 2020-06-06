import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;


public class panelGestionPatient extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelGestionPatient() {
		setBounds(317,0,898,783);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("gestion des patients");
		lblNewLabel.setBounds(105, 102, 201, 418);
		add(lblNewLabel);
		setVisible(true);

	}
}
