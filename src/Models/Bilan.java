package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Connexion;

public class Bilan {
	private static int id = 0;
	private int id_bilan;
	private String nom_bilan;
	private String resultat_bilan;
	public Bilan( String nom_bilan, String resultat_bilan) {
		super();
		id++;
		this.id_bilan = id;
		this.nom_bilan = nom_bilan;
		this.resultat_bilan = resultat_bilan;
		
	}
	public Bilan() {
		id++;
		this.setId_bilan(id);
	}
	public int getId_bilan() {
		return id_bilan;
	}
	public void setId_bilan(int id_bilan) {
		this.id_bilan = id_bilan;
	}
	public String getNom_bilan() {
		return nom_bilan;
	}
	public void setNom_bilan(String nom_bilan) {
		this.nom_bilan = nom_bilan;
	}
	public String getResultat_bilan() {
		return resultat_bilan;
	}
	public void setResultat_bilan(String resultat_bilan) {
		this.resultat_bilan = resultat_bilan;
	}
	@Override
	public String toString() {
		return "Bilan [id_bilan=" + id_bilan + ", nom_bilan=" + nom_bilan + ", resultat_bilan=" + resultat_bilan + "]";
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Bilan.id = id;
	}
/*
 *  ----------------------------------------- -------- ----------------------------
 ID_BILAN                                  NOT NULL VARCHAR2(5)
 NOM_BILAN                                 NOT NULL VARCHAR2(300)
 RESULTAT_BILAN                            NOT NULL VARCHAR2(300)
 ID_CONSULTATION                           NOT NULL VARCHAR2(10)
 ID_PATIENT	
 */

 public  static boolean create( Bilan b,int c,int idp) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("insert into Bilan values (?,?,?,?,?) ");
			
			pst.setInt(1,b.getId_bilan() );
			pst.setString(2,b.getNom_bilan() );
			pst.setString(4,b.getResultat_bilan() );
			pst.setInt(5, c);
			pst.setInt(6, idp);
			System.out.println(pst.toString());

			int rowsInserted;
		
			rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("le bilan  à été rajouté"); return true;
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

 //TODO METTRE A JOUR LE RESULTAT D4UNE ANALYSE
public  static boolean update( Bilan b,int c,int idp) {
Connection con = Connexion.getConnection();
		try {
			String updateQuery = "UPDATE Bilan "
				+ "SET resultat_bilan = '" + b.getResultat_bilan()               + "'"
                             + "WHERE id_patient = " + idp;


		int rowsInserted;
		PreparedStatement pst = con.prepareStatement(updateQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("l'analyse a ete mis a jour"); return true;
		}else return false;

		} catch (Exception ex) {
			System.out.println("Problem in  update" + ex);
			return false;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

	}	

//TODO recuperer les analyses d'un patients

		public static ArrayList<Bilan> all(int id) {
		ArrayList<Bilan> bilans = new ArrayList<Bilan>();	
Connection con = Connexion.getConnection();
		try {
			
		    PreparedStatement pst = con.prepareStatement("Select * from Bilan WHERE id_consultation = ?");
		    pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Bilan c = new Bilan();

				c.setId_bilan(rs.getInt("id_bilan"));
				c.setNom_bilan(rs.getString("nom_bilan"));

				c.setResultat_bilan(rs.getString("resultat_bilan"));

				bilans.add(c);
			}

		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog( null, "Problem in all - <Bilan> all "+ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

		return bilans;
	}


 
}
