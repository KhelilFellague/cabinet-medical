package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Connexion;

public class DossierPatient {
	private Patient patient;
	private String groupe_sanguin;
	private String taille;
	private String antecedants;
	//private ArrayList<Consultation> consultations = new ArrayList<Consultation>();
	private ArrayList<Consultation> consultations;
	public DossierPatient(Patient patient, String groupe_sanguin, String taille, String antecedants) {
		super();
		this.patient = patient;
		this.groupe_sanguin = groupe_sanguin;
		this.taille = taille;
		this.antecedants = antecedants;
		this.consultations = Consultation.all(this.patient.getId_patient());
	}
	public DossierPatient() {
		super();
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getGroupe_sanguin() {
		return groupe_sanguin;
	}
	public void setGroupe_sanguin(String groupe_sanguin) {
		this.groupe_sanguin = groupe_sanguin;
	}
	public String getTaille() {
		return taille;
	}
	public void setTaille(String taille) {
		this.taille = taille;
	}
	public String getAntecedants() {
		return antecedants;
	}
	public void setAntecedants(String antecedants) {
		this.antecedants = antecedants;
	}
	public ArrayList<Consultation> getConsultations() {
		return consultations;
	}
	public void setConsultations(ArrayList<Consultation> consultations) {
		this.consultations = consultations;
	}

	@Override
	public String toString() {
		return "DossierPatient [patient=" + patient + ", groupe_sanguin=" + groupe_sanguin + ", taille=" + taille
				+ ", antecedants=" + antecedants + "]";
	}
	
	/*
	 * private Patient patient;
	private String groupe_sanguin;
	private String taille;
	private String antecedants;
	 */
	
	
public static DossierPatient ReadP(int idp) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("Select * from dossier where id_patient = ? ");
			
			pst.setInt(1, idp);

			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				
				DossierPatient dp = new DossierPatient();
				dp.setPatient(Patient.ReadId(rs.getInt("id_patient")));
				dp.setGroupe_sanguin(rs.getString("groupe_sanguin"));
				dp.setTaille(rs.getString("taille"));
				dp.setAntecedants(rs.getString("antecedants"));
				return dp;
			}
		} catch (SQLException ex) {
			System.out.println("Error : DossierPatient.ReadP()" + ex);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}
		return null;

	}
/*
 *  GROUPE_SANGUIN                            NOT NULL VARCHAR2(3)
 TAILLE                                    NOT NULL VARCHAR2(3)
 ANTECEDANTS                               NOT NULL VARCHAR2(600)
 ID_PATIENT                                NOT NULL NUMBER(5)
 */

 public  static boolean create(DossierPatient dp, int idp) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("insert into dossier values (?,?,?,?) ");
			
			pst.setString(1, dp.getGroupe_sanguin());
			pst.setString(2, dp.getTaille());
			pst.setString(3, dp.getAntecedants());
			pst.setInt(4, idp);
			System.out.println(pst.toString());

			int rowsInserted;
		
			rowsInserted = pst.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("ledossier  à été rajouté"); return true;
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
 /*
  *  GROUPE_SANGUIN                            NOT NULL VARCHAR2(3)
 TAILLE                                    NOT NULL VARCHAR2(3)
 ANTECEDANTS                               NOT NULL VARCHAR2(600)
 ID_PATIENT                                NOT NULL NUMBER(5)
  */

 public  static boolean update(DossierPatient dp, int idp) {
Connection con = Connexion.getConnection();
		try {
			
			String updateQuery = "UPDATE Dossier "
				+ "SET groupe_sanguin = " + "'" + dp.getGroupe_sanguin()                + "', "
				+ "TAILLE  = '"  + dp.getTaille()               + "', "
				+ "ANTECEDANTS  = '" + dp.getAntecedants()                     + "' "
				
                             + "WHERE id_patient = " + idp;
                 System.out.println(updateQuery);
			int rowsInserted;
		PreparedStatement pst = con.prepareStatement(updateQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			JOptionPane.showMessageDialog(null, "Le dossier du patient a bien été  mis à jour", "Enregistrement effectué", 1); return true;
		}else return false;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null,"Problem in  update"+ex , "Enregistrement effectué", 1);
			return false;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}



	}	 	
 	 
	
}
