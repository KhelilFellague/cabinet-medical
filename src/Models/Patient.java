package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import database.Connexion;

public class Patient {
	private int id_patient;
	private String nom;
	private String prenom;
	private Date date_naissance;
	private String sexe;
	private String adresse;
	private String num_tel;
	private String email;
	private ArrayList<Rdv> rdvPatient ;
	private DossierPatient dp ;
	public Patient(int id_patient, String nom, String prenom, Date date_naissance, String sexe, String adresse,
			String num_tel, String email) {
		super();
		this.id_patient = id_patient;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.num_tel = num_tel;
		this.email = email;
		this.rdvPatient = new ArrayList<Rdv>();
		this.dp = new DossierPatient();
	}
	public Patient() {

	}
	public Patient(String nom, String prenom, Date date_naissance, String sexe, String adresse,
			String num_tel, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance = date_naissance;
		this.sexe = sexe;
		this.adresse = adresse;
		this.num_tel = num_tel;
		this.email = email;
		this.rdvPatient = new ArrayList<Rdv>();
		this.dp = new DossierPatient();
		
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
	public String getNum_tel() {
		return num_tel;
	}
	public void setNum_tel(String num_tel) {
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
	

	@Override
	public String toString() {
		return "Patient [id_patient=" + id_patient + ", nom=" + nom + ", prenom=" + prenom + ", date_naissance="
				+ date_naissance + ", sexe=" + sexe + ", adresse=" + adresse + ", num_tel=" + num_tel + ", email="
				+ email +  "]";
	}
	public static Patient ReadId(int id_patient) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("Select * from Patient where id_patient = ? ");
			pst.setInt(1, id_patient);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Patient patient = new Patient();
				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setSexe(rs.getString("sexe"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getString("num_tel"));
				patient.setEmail(rs.getString("email"));
				return patient;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog( null, "Error : patient.ReadId() "+ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}
		return null;

	}

	public static Patient ReadString(String s) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("Select * from Patient WHERE nom = ? ");
			pst.setString(1, s);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Patient patient = new Patient();
				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setSexe(rs.getString("sexe"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getString("num_tel"));
				patient.setEmail(rs.getString("email"));
				return patient;
			}
		} catch (SQLException ex) {
			
			
			JOptionPane.showMessageDialog( null, "Error : patient.ReadString() "+ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}
		return null;

	}


	public static ArrayList<Patient> all() {
		ArrayList<Patient> patients = new ArrayList<Patient>();

	
			
Connection con = Connexion.getConnection();
		try {
			
		    PreparedStatement pst = con.prepareStatement("Select * from Patient order by id_patient");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Patient patient = new Patient();

				patient.setId_patient(rs.getInt("id_patient"));
				patient.setNom(rs.getString("nom"));
				patient.setPrenom(rs.getString("prenom"));
				patient.setDate_naissance(rs.getDate("date_naissance"));
				patient.setSexe(rs.getString("sexe"));
				patient.setAdresse(rs.getString("adresse"));
				patient.setNum_tel(rs.getString("num_tel"));
				patient.setEmail(rs.getString("email"));

				patients.add(patient);
			}

		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog( null, "Problem in all - <Patient> all "+ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

		return patients;
	}


	public static boolean create(Patient p) {

Connection con = Connexion.getConnection();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {  String insertQuery = "INSERT INTO Patient(NOM, PRENOM, "
				+ " DATE_NAISSANCE ,  SEXE ,  ADRESSE, NUM_TEL, EMAIL) VALUES("
				+ "'" + p.getNom()             + "', "
				+ "'" + p.getPrenom()             + "', "
				//+ "'" + p.getDate_naissance()  + "', "
				//+ "to_Date ('" + sdf.format(d.getDate_rdv())        + "','dd-MM-YYYY'), "
				+ "to_Date ('" + sdf.format(p.getDate_naissance())  + "', 'dd-MM-yyyy'),"
				+ "'" + p.getSexe()            + "', "
				+ "'" + p.getAdresse()         + "', "
			    + "'" + p.getNum_tel()   + "', "
				+ "'" + p.getEmail()           + "' "

                             + ")";
		
		

		int rowsInserted;
		
		PreparedStatement pst = con.prepareStatement(insertQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			 return true;
		}else return false;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Problem in  create "+ex, "Erreur", 1);
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

Connection con = Connexion.getConnection();
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			String date = sdf.format(p.getDate_naissance());
				String updateQuery = "UPDATE Patient "
				+ "SET nom = " + "'" + p.getNom()                + "', "
				+ "prenom = '"  + p.getPrenom()                  + "', "
				+ "date_naissance = to_Date ('" + date  + "', 'dd-MM-yyyy'),"
				+ "sexe = '" + p.getSexe()                       + "', "
				+ "adresse = '" + p.getAdresse()                  + "', "
				+ "num_tel = '" + p.getNum_tel()                  + "', "
				+ "email = '" + p.getEmail()                    + "' "

                             + "WHERE id_patient = " + p.getId_patient()+ "";
		int rowsInserted;
		PreparedStatement pst = con.prepareStatement(updateQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			 return true;
		}else return false;

		} catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Error : patient.Update() "+ex, "Erreur", 1);
			return false;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

	}

	public static boolean delete(Patient p) {
		
		Connection con = Connexion.getConnection();
		try{ String deleteQuery = "DELETE FROM Patient "
				+ "WHERE id_patient = " + p.getId_patient();
		int rowsInserted;
		
		PreparedStatement pst = con.prepareStatement(deleteQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			 return true;
		}else return false;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Error : patient.Delete() "+ex, "Erreur", 1);
			return false;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}
	}
//retourne le nombre de patientes	
public static int nombreFemme() {
	int nb = 0;

 Connection con = Connexion.getConnection();
		try{     
		String Query = "select * from patient where sexe = 'Femme'";
                             
		PreparedStatement pst = con.prepareStatement(Query);
		nb = pst.executeUpdate();
			 return nb;
		

		} catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Error : nombreFemme "+ex, "Erreur", 1);
			return nb;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

}

//retourne le nombre de patients
public static int nombreHomme() {
	int nb = 0;

 Connection con = Connexion.getConnection();
		try{     
		String Query = "select * from patient where sexe = 'Homme'";
                             
		PreparedStatement pst = con.prepareStatement(Query);
		nb = pst.executeUpdate();
			 return nb;
		

		} catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Error : nombreHomme "+ex, "Erreur", 1);
			return nb;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

}

//retourne un tableau qui contient le nb de patients par tranche d'age <18 , 18<= <= 40 , >40

public static int[] byAge() {
	int tab[] = new int[3];
	String s[] = new String [3];
	s[0] ="select * from patient where ( SELECT TRUNC(TO_NUMBER(SYSDATE - date_naissance) / 365.25) AS AGE FROM DUAL ) < 18 ";
	s[1] = "select * from patient where ( SELECT TRUNC(TO_NUMBER(SYSDATE - date_naissance) / 365.25) AS AGE FROM DUAL ) BETWEEN 18 AND 40 ";
	s[2] = "select * from patient where ( SELECT TRUNC(TO_NUMBER(SYSDATE - date_naissance) / 365.25) AS AGE FROM DUAL )  >40 ";
	
	  Connection con = Connexion.getConnection();
		try{     
		for(int i = 0; i < 3; i++ ){                     
		PreparedStatement pst = con.prepareStatement(s[i]);
		tab[i] = pst.executeUpdate();
		
	}//fin for
	return tab;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog( null, "Error : byage "+ex, "Erreur", 1);
			return tab;
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

}
public DossierPatient getDp() {
	return dp;
}
public void setDp(DossierPatient dp) {
	this.dp = dp;
}

/*public static int id() {
	int nb = 0;

	 Connection con = Connexion.getConnection();
			try{     
			String Query = "select id_patient_seq.NEXTVAL from dual";                     
			PreparedStatement pst = con.prepareStatement(Query);
			nb = pst.executeUpdate();
				 return nb;
			

			} catch (Exception ex) {
				System.out.println("Problem in  id" + ex);
				return nb;
			}
			finally {
				try {
					con.close();
					} catch (SQLException e) {
							e.printStackTrace();
					}}
}*/
}
