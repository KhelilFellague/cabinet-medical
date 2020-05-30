import java.sql.*;

/**
 * @author Ines
 *
 */
public class Connexion {
	static Connection con;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:INES","INES","magicalclover");
		}
		catch(Exception e ) {
			System.out.println(e);
		}
		return con;
	}
}
