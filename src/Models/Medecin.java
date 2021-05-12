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
	private ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
	
	public Medecin(int id_user, String login, String mdp, String nom, String prenom,String adresse, int num_tel, String email,
			String specialite,String adresse_cabinet, String num_ordre) {
		super(id_user, login, mdp, nom, prenom,adresse, num_tel, email);
		this.specialite = specialite;
		this.adresse_cabinet = adresse_cabinet;
		this.num_ordre = num_ordre;
		this.patients.addAll(Patient.all()) ;
		this.rdvs.addAll(Rdv.all());
	}

	public Medecin() {
		super();
		this.patients.addAll(Patient.all()) ;
		this.rdvs.addAll(Rdv.all());
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
				+ ", patients=" + patients + ", getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()="
				+ getMdp() + ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel()
				+ ", getEmail()=" + getEmail() + ", getAdresse()=" + getAdresse() + "]";
	}

	public static Medecin Read(String login, String mdp) {

		try {
			Connection con = Connexion.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Medecin where login = ? and mdp = ?");
			pst.setString(1, login);
			pst.setString(2, mdp);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Medecin medecin = new Medecin();
				medecin.setId_user(rs.getInt("id_user"));
				medecin.setLogin(rs.getString("login"));
				medecin.setMdp(rs.getString("mdp"));
				medecin.setNom(rs.getString("nom"));
				medecin.setPrenom(rs.getString("prenom"));
				medecin.setAdresse(rs.getString("adresse"));
				medecin.setNum_tel(rs.getInt("num_tel"));
				medecin.setEmail(rs.getString("email"));
				medecin.setSpecialite(rs.getString("specialite"));
				medecin.setAdresse_cabinet(rs.getString("adresse_cabinet"));
				medecin.setNum_ordre(rs.getString("num_ordre"));
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

	public ArrayList<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(ArrayList<Rdv> rdvs) {
		this.rdvs = rdvs;
	}
	
}
