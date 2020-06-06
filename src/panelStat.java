import javax.swing.JPanel;
import javax.swing.JLabel;

public class panelStat extends JPanel {

	/**
	 * Create the panel.
	 */
	public panelStat() {
		setBounds(317,0,898,783);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("stats");
		lblNewLabel.setBounds(69, 126, 527, 222);
		add(lblNewLabel);
		
		setVisible(true);

	}

}
