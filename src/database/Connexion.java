package database;
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
			//il faut  changer le drive
			
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:INES","SYSTEM","Idirines9501");
		}
		catch(Exception e ) {
			System.out.println(e+"ERREUR DANS LA CLASSE CONNEXION");
		}
		return con;
	}
}
