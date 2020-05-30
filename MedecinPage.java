import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Ines
 *
 */
@SuppressWarnings("serial")
public class MedecinPage extends JFrame {

	private JPanel contentPane;
	private JTextField txtAzul;

	/**
	 * Create the frame.
	 */
	public MedecinPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(42)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 329, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(43)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(73, Short.MAX_VALUE))
				);

		txtAzul = new JTextField();
		txtAzul.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtAzul.setHorizontalAlignment(SwingConstants.CENTER);
		txtAzul.setText("AZUL ");
		panel_1.add(txtAzul);
		txtAzul.setColumns(10);
		panel.setLayout(gl_panel);
	}
}
