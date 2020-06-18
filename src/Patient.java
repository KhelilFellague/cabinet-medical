package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.Connexion;

public class Patient {
	private int id_patient;
	private String nom;
	private String prenom;
	private Date date_naissance;
	private String sexe;
	private String adresse;
	private int num_tel;
	private String email;
	private ArrayList<Rdv> rdvPatient = new ArrayList<Rdv>();
	public Patient(int id_patient, String nom, String prenom, Date date_naissance, String sexe, String adresse,
			int num_tel, String email) {
		super();
		this.id_patient = id_patient;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.num_tel = num_tel;
		this.email = email;
	}
	public Patient() {

	}
	public int getId_patient() {
		return id_patient;
	}
	public void setId_patient(int id_patient) {
		this.id_patient = id_patient;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public Date getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(int num_tel) {
		this.num_tel = num_tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<Rdv> getRdvPatient() {
		return rdvPatient;
	}
	public void setRdvPatient(ArrayList<Rdv> rdvPatient) {
		this.rdvPatient = rdvPatient;
	}  

	public static Patient ReadId(int id_patient) {

		try {
			System.out.println("AZUUUUUUL try du patient 1");
			Connection con = Connexion.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Patient where id_patient = ? ");
			pst.setInt(1, id_patient);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Patient patient = new Patient();
				System.out.println("AZUUUUUUL rs.next du Patient 1");
				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getInt("num_tel"));
				patient.setEmail(rs.getString("email"));

				System.out.println("AZUUUUUUL FIN rs next Patient 1");
				return patient;
			}
		} catch (SQLException ex) {
			System.out.println("Error : patient.ReadId()" + ex);
		}
		return null;

	}

	public static Patient ReadString(String s) {

		try {
			System.out.println("AZUUUUUUL try du patient 1");
			Connection con = Connexion.getConnection();
			PreparedStatement pst = con.prepareStatement("Select * from Patient where (nom = ? or prenom = ?) ");
			pst.setString(1, s);
			pst.setString(2, s);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Patient patient = new Patient();
				System.out.println("AZUUUUUUL rs.next du Patient 1");
				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getInt("num_tel"));
				patient.setEmail(rs.getString("email"));

				System.out.println("AZUUUUUUL FIN rs next Patient 1");
				return patient;
			}
		} catch (SQLException ex) {
			System.out.println("Error : patient.ReadString()" + ex);
		}
		return null;

	}


	public static ArrayList<Patient> all() {
		ArrayList<Patient> patients = new ArrayList<Patient>();



		try {
			Connection con = Connexion.getConnection();

			PreparedStatement pst = con.prepareStatement("Select * from Patient  ");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {

				Patient patient = new Patient();

				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getInt("num_tel"));
				patient.setEmail(rs.getString("email"));

				patients.add(patient);
			}

		} catch (Exception ex) {
			System.out.println("Problem in all - <Patient> all" + ex);
		}

		return patients;
	}


	public static boolean create(Patient p) {


		try {  String insertQuery = "INSERT INTO Patient(NOM, PRENOM, "
				+ " DATE_NAISSANCE ,  SEXE ,  ADRESSE, NUM_TEL, EMAIL) VALUES("
				+ "'" + p.getNom()             + "', "
				+ "'" + p.getDate_naissance()  + "', "
				+ "'" + p.getSexe()            + "', "
				+ "'" + p.getAdresse()         + "', "
				+ "'" + p.getNum_tel()         + "', "
				+ "'" + p.getEmail()           + "', "

                             + ");";

		int rowsInserted;
		Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement(insertQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("un patient a ete rajouté"); return true;
		}else return false;
		}
		catch (Exception ex) {
			System.out.println("Problem in all - create" + ex);
			return false;
		}



	} 

	/*
	 *  ID_PATIENT                                NOT NULL NUMBER(5)
	 NOM                                       NOT NULL VARCHAR2(15)
	 PRENOM                                    NOT NULL VARCHAR2(15)
	 DATE_NAISSANCE                            NOT NULL DATE
	 SEXE                                      NOT NULL VARCHAR2(5)
	 ADRESSE                                   NOT NULL VARCHAR2(50)
	 NUM_TEL                                   NOT NULL NUMBER(10)
	 EMAIL
	 */


	public static boolean update(Patient p) {


		try{     String updateQuery = "UPDATE Patient "
				+ "SET nom = " + "'" + p.getNom()                + "', "
				+ "prenom = '"  + p.getPrenom()                  + "', "
				+ "date_naissance = '" + p.getDate_naissance()   + "', "
				+ "sexe = '" + p.getSexe()                       + "', "
				+ "adresse = '" + p.getAdresse()                  + "', "
				+ "num_tel = '" + p.getNum_tel()                  + "', "
				+ "email = '" + p.getEmail()                    + "', "

                             + ");"
                             + "WHERE id_patient = '" + p.getId_patient()+ "';";
		int rowsInserted;
		Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement(updateQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("un patient a ete mis a jour"); return true;
		}else return false;

		} catch (Exception ex) {
			System.out.println("Problem in all - update" + ex);
			return false;
		}

	}

	public static boolean delete(Patient p) {
		try{ String deleteQuery = "DELETE FROM Patient "
				+ "WHERE id_patient = " + p.getId_patient()+ ";";
		int rowsInserted;
		Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement(deleteQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("un patient a ete supprime"); return true;
		}else return false;
		} catch (Exception ex) {
			System.out.println("Problem in all - delete" + ex);
			return false;
		}
	}
	


}
