package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Connexion;

public class Ordonnance {
	private static int id = 0;
	private int id_Med;
	private String nom_Med;
	private int dosage_Med;
	private String dureeTraitement;
	private String posologie;
	public Ordonnance( String nom_Med, int dosage_Med, String dureeTraitement, String posologie) {
		super();
		id++;
		this.id_Med = id;
		this.nom_Med = nom_Med;
		this.dosage_Med = dosage_Med;
		this.dureeTraitement = dureeTraitement;
		this.posologie = posologie;
		
	}
	public Ordonnance() {
		id++;
		this.setId_Med(id);
	}
	public int getId_Med() {
		return id_Med;
	}
	public void setId_Med(int id_Med) {
		this.id_Med = id_Med;
	}
	public String getNom_Med() {
		return nom_Med;
	}
	public void setNom_Med(String nom_Med) {
		this.nom_Med = nom_Med;
	}
	public int getDosage_Med() {
		return dosage_Med;
	}
	public void setDosage_Med(int dosage_Med) {
		this.dosage_Med = dosage_Med;
	}
	public String getDureeTraitement() {
		return dureeTraitement;
	}
	public void setDureeTraitement(String dureeTraitement) {
		this.dureeTraitement = dureeTraitement;
	}
	public String getPosologie() {
		return posologie;
	}
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}
	@Override
	public String toString() {
		return "Ordonnance \n"
				+ "id_Med=" + id_Med + ", nom_Med=" + nom_Med + ", dosage_Med=" + dosage_Med
				+ ", dureeTraitement=" + dureeTraitement + ", posologie=" + posologie + "]";
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Ordonnance.id = id;
	}
	
 public  static boolean create( Ordonnance o,int c,int idp) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("insert into ordonnance values (?,?,?,?,?,?,?) ");
			
			pst.setInt(1, o.getId_Med());
			pst.setString(2, o.getNom_Med());
			pst.setInt(3, o.getDosage_Med());
			pst.setString(4, o.getDureeTraitement());
			pst.setString(5, o.getPosologie());
			pst.setInt(5, c);
			pst.setInt(6, idp);
			System.out.println(pst.toString());

			int rowsInserted;
		
			rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("l'ordonnance  à été rajouté"); return true;
			}else return false;
			}
			catch (Exception ex) {
				System.out.println("Problem in  create" + ex);
				return false;
			}

			finally {
				try {
					con.close();
					} catch (SQLException e) {
							e.printStackTrace();
					}}
	}	 
 
 //TODO ALL 
	public static ArrayList<Ordonnance> all(int id) {
	ArrayList<Ordonnance> ords = new ArrayList<Ordonnance>();	
Connection con = Connexion.getConnection();
	try {
		
	    PreparedStatement pst = con.prepareStatement("Select * from Ordonnance WHERE id_consultation = ?");
	    pst.setInt(1,id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			Ordonnance c = new Ordonnance();

			c.setId_Med(rs.getInt("id_med"));
			c.setNom_Med(rs.getString("nom_bilan"));
			c.setDosage_Med(rs.getInt("dosage_med"));
			c.setDureeTraitement(rs.getString("duree_traitement"));
			c.setPosologie(rs.getString("posologie"));
			
			ords.add(c);
		}

	} catch (Exception ex) {
		
		JOptionPane.showMessageDialog( null, "Problem in all - <Ordonnance> all "+ex, "Erreur", 1);
	}
	finally {
		try {
			con.close();
			} catch (SQLException e) {
					e.printStackTrace();
			}}

	return ords;
}

	 
}
