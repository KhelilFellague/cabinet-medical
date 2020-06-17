package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connexion;

/**
 * @author Ines
 *
 */
public class Secretaire extends Utilisateur{
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Rdv> rdvs = new ArrayList<Rdv>();

	public Secretaire(int id_user, String login, String mdp, String nom, String prenom, int num_tel, String email) {
		super(id_user, login, mdp, nom, prenom, num_tel, email);
	}
	public Secretaire() {
		super();
	}
	@Override
	public String toString() {
		return "Secretaire [getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel()
				+ ", getEmail()=" + getEmail()  + "]";
	}

 public static Secretaire Read(String login, String mdp) {
        
     try { 
    	 System.out.println("AZUUUUUUL try secretaire 1");
    	 Secretaire secretaire = new Secretaire();   
     	Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement("Select * from Secretaire where login = ? and mdp = ?");
		pst.setString(1, login);
		pst.setString(2, mdp);
		ResultSet rs = pst.executeQuery();
   
            if(rs.next()){
            	 System.out.println("AZUUUUUUL rs next secretaire 1");	
            secretaire.setId_user(rs.getInt("id_user"));
			secretaire.setLogin(rs.getString("login"));
			secretaire.setMdp(rs.getString("mdp"));
			secretaire.setNom(rs.getString("nom"));
			secretaire.setPrenom(rs.getString("prenom"));
			secretaire.setPrenom(rs.getString("adresse"));
			secretaire.setNum_tel(rs.getInt("num_tel"));
			secretaire.setEmail(rs.getString("email"));
			System.out.println("AZUUUUUUL FIN rs next secretaire 1");
			return secretaire;}
        } catch (SQLException ex) {
            System.out.println("Error : Secretaire.Read()" + ex);
        }
	return null;
        
       
    }
public ArrayList<Patient> getPatients() {
	return patients;
}
public void setPatients(ArrayList<Patient> patients) {
	this.patients = patients;
}
public ArrayList<Rdv> getRdvs() {
	return rdvs;
}
public void setRdvs(ArrayList<Rdv> rdvs) {
	this.rdvs = rdvs;
}
 

}
