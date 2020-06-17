package Models;


import java.sql.*;
import java.util.ArrayList;

import database.Connexion;

/**
 * @author Ines
 *
 */

public class Medecin extends Utilisateur {

	private String specialite;
	private String adresse_cabinet;
	private String num_ordre;
	private ArrayList<Patient> patients = new ArrayList<Patient>();
public Medecin(int id_user, String login, String mdp, String nom, String prenom, int num_tel, String email,
String specialite,String adresse_cabinet, String num_ordre) {
		super(id_user, login, mdp, nom, prenom, num_tel, email);
		this.specialite = specialite;
		this.adresse_cabinet = adresse_cabinet;
		this.num_ordre = num_ordre;
	}

public Medecin() {
	super();
}

public String getSpecialite() {
	return specialite;
}

public void setSpecialite(String specialite) {
	this.specialite = specialite;
}

public String getAdresse_cabinet() {
	return adresse_cabinet;
}

public void setAdresse_cabinet(String adresse_cabinet) {
	this.adresse_cabinet = adresse_cabinet;
}

public String getNum_ordre() {
	return num_ordre;
}

public void setNum_ordre(String num_ordre) {
	this.num_ordre = num_ordre;
}

@Override
public String toString() {
	return "Medecin [specialite=" + specialite + ", adresse_cabinet=" + adresse_cabinet + ", num_ordre=" + num_ordre
			+ ", getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getNom()="
			+ getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel() + ", getEmail()="
			+ getEmail()  + "]";
}

 public static Medecin Read(String login, String mdp) {
        
     try {
    	 System.out.println("AZUUUUUUL try du medecin 1");
     	Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement("Select * from Medecin where login = ? and mdp = ?");
		pst.setString(1, login);
		pst.setString(2, mdp);
		ResultSet rs = pst.executeQuery();
   
            if(rs.next()) {
            	Medecin medecin = new Medecin();
            	 System.out.println("AZUUUUUUL rs.next du medecin 1");
            medecin.setId_user(rs.getInt("id_user"));
			medecin.setLogin(rs.getString("login"));
			medecin.setMdp(rs.getString("mdp"));
			medecin.setNom(rs.getString("nom"));
			medecin.setPrenom(rs.getString("prenom"));
			medecin.setPrenom(rs.getString("adresse"));
			medecin.setNum_tel(rs.getInt("num_tel"));
			medecin.setEmail(rs.getString("email"));
			medecin.setSpecialite(rs.getString("specialite"));
			medecin.setAdresse_cabinet(rs.getString("adresse_cabinet"));
			medecin.setNum_ordre(rs.getString("num_ordre"));
			System.out.println("AZUUUUUUL FIN rs next Medecin 1");
			return medecin;
			}
        } catch (SQLException ex) {
            System.out.println("Error : Medecin.Read()" + ex);
        }
	return null;
        
    }

public ArrayList<Patient> getPatients() {
	return patients;
}

public void setPatients(ArrayList<Patient> patients) {
	this.patients = patients;
}

}
