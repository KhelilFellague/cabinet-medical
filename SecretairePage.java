
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.JTextField;
import java.awt.Font;


/**
 * @author Ines
 *
 */
@SuppressWarnings("serial")
public class SecretairePage extends JFrame {

	private JPanel contentPane;
	private JTextField txtHeySecretaire;

	/**
	 * Create the frame.
	 */
	public SecretairePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		txtHeySecretaire = new JTextField();
		txtHeySecretaire.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtHeySecretaire.setText("Hey secretaire");
		txtHeySecretaire.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(111)
						.addComponent(txtHeySecretaire, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(11, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(36)
						.addComponent(txtHeySecretaire, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(188, Short.MAX_VALUE))
				);
		contentPane.setLayout(gl_contentPane);
	}
}
