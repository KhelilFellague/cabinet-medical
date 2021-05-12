package Core;
import java.awt.EventQueue;

import Gui.Login;







/**
 * @author Ines
 *
 */
public class App {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
			Login window = new Login();
					window.setUndecorated(true);
					window.getFrame().setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
