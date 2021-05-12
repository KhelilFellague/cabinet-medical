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

public class Consultation {
	private int id_consultation;
	private Date date_consultation;
	private String heure_consultation;
	private double poids;
	private double glycemie;
	private double cholesterol;
	private double tension;
	private String maladies;
	private String observation;
	private double montant_paye;
	private ArrayList<Bilan>bilans ;
	private ArrayList<Ordonnance> ordonnances;
	private static int id = 0;
	
	public Consultation( Date date_consultation,String heure_consultation, double poids, double glycemie, double cholesterol,
			double tension, String maladies, String observation, double montant_payé) {
		super();
		id++;
		this.id_consultation = id;
		this.date_consultation = date_consultation;
		this.heure_consultation = heure_consultation;
		this.poids = poids;
		this.glycemie = glycemie;
		this.cholesterol = cholesterol;
		this.tension = tension;
		this.maladies = maladies;
		this.observation = observation;
		this.montant_paye = montant_payé;
		this.bilans = new ArrayList<Bilan>();
		this.ordonnances = new ArrayList<Ordonnance>();
	}

	public Consultation() {
		id++;
		this.setId_consultation(id);
	}

	public int getId_consultation() {
		return id_consultation;
	}

	public void setId_consultation(int id_consultation) {
		this.id_consultation = id_consultation;
	}

	public Date getDate_consultation() {
		return date_consultation;
	}

	public void setDate_consultation(Date date_consultation) {
		this.date_consultation = date_consultation;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getGlycemie() {
		return glycemie;
	}

	public void setGlycemie(double glycemie) {
		this.glycemie = glycemie;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public double getTension() {
		return tension;
	}

	public void setTension(double tension) {
		this.tension = tension;
	}

	public String getMaladies() {
		return maladies;
	}

	public void setMaladies(String maladies) {
		this.maladies = maladies;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public double getMontant_paye() {
		return montant_paye;
	}

	public void setMontant_paye(double montant_payé) {
		this.montant_paye = montant_payé;
	}

	public ArrayList<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(ArrayList<Bilan> bilans) {
		this.bilans = bilans;
	}
	//remplir dynamiquement les bilans
	public void setBilans2() {
		this.bilans = Bilan.all(this.id_consultation);
	}

	public ArrayList<Ordonnance> getOrdonnances() {
		return ordonnances;
	}

	public void setOrdonnances(ArrayList<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}
	//remplir dynamiquement les ordonnances
	public void setOrdonnances2() {
		this.ordonnances = Ordonnance.all(this.id_consultation);
	}
	
	public String getHeure_consultation() {
		return heure_consultation;
	}

	public void setHeure_consultation(String heure_consultation) {
		this.heure_consultation = heure_consultation;
	}
	

	@Override
	public String toString() {
		return "Consultation [id_consultation=" + id_consultation + ", date_consultation=" + date_consultation
				+ ", poids=" + poids + ", glycemie=" + glycemie + ", cholestérol=" + cholesterol + ", tension="
				+ tension + ", maladies=" + maladies + ", observation=" + observation + ", montant_paye=" + montant_paye
				+ ", bilans=" + bilans + ", ordonnances=" + ordonnances + "]";
	}
	
	//database
	public static Consultation Read(int id) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("Select * from consultation where id_consultation = ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Consultation consultation = new Consultation();
				consultation.setId_consultation(rs.getInt("id_consultation"));
				consultation.setDate_consultation(rs.getDate("date_consultation"));
				consultation.setHeure_consultation(rs.getString("heure_consultation"));
				//consultation.setPatient(Patient.ReadId(rs.getInt("id_patient")));
				consultation.setPoids(rs.getDouble("poids"));
				consultation.setGlycemie(rs.getDouble("glycemie"));
				consultation.setCholesterol(rs.getDouble("cholesterol"));
				consultation.setTension(rs.getDouble("tension"));
				consultation.setMaladies(rs.getString("maladies"));
				consultation.setObservation(rs.getString("observation"));
				consultation.setMontant_paye(rs.getDouble("montant_paye"));
				return consultation;
			}
		} catch (SQLException ex) {
			System.out.println("Error : consultation.Read()" + ex);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}
		return null;

	}
	public static Consultation ReadC(DossierPatient dp) {
Connection con = Connexion.getConnection();
		try {
			
			PreparedStatement pst = con.prepareStatement("Select * from consultation where id_dossier = ? ");
			pst.setInt(1, dp.getPatient().getId_patient());
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				Consultation consultation = new Consultation();
				consultation.setId_consultation(rs.getInt("id_consultation"));
				consultation.setDate_consultation(rs.getDate("date_consultation"));
				consultation.setHeure_consultation(rs.getString("heure_consultation"));
				//consultation.setPatient(Patient.ReadId(rs.getInt("id_patient")));
				consultation.setPoids(rs.getDouble("poids"));
				consultation.setGlycemie(rs.getDouble("glycemie"));
				consultation.setCholesterol(rs.getDouble("cholesterol"));
				consultation.setTension(rs.getDouble("tension"));
				consultation.setMaladies(rs.getString("maladies"));
				consultation.setObservation(rs.getString("observation"));
				consultation.setMontant_paye(rs.getDouble("montant_paye"));
				return consultation;
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e, "Erreur", 1);
				}}
		return null;

	}
	
	/*
	 *  ID_CONSULTATION                           NOT NULL VARCHAR2(10)
 DATE_CONSULTATION                         
 HEURE_CONSULTATION                        
 POIDS                                              
 GLYCEMIE                                           
 CHOLESTEROL                                        
 TENSION                                          
 MALADIES                                           
 OBSERVATION                                        
 MONTANT_PAYE                              
 ID_Patient                                
	 */
	

/*	public static boolean create(Consultation p , int id) {

Connection con = Connexion.getConnection();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {  String insertQuery = "INSERT INTO Consultation(DATE_CONSULTATION ,HEURE_CONSULTATION , POIDS,GLYCEMIE,"
		+"CHOLESTEROL,TENSION,MALADIES,OBSERVATION,MONTANT_PAYE,ID_PATIENT) VALUES("
		+ "to_Date ('" + sdf.format(p.getDate_consultation())  + "', 'dd-MM-yyyy'),"
		+ "'" + p.getHeure_consultation()            + "', "
		
		+ "" + p.getPoids()            + ", "
		+ "" + p.getGlycemie()         + ", "
		+ "" + p.getCholesterol()      + ", "
		+ "" + p.getTension()          + ", "
		+ "'"+ p.getMaladies()         + "', "
		+ "'"+ p.getObservation()      + "', "
		+ "" + p.getMontant_paye()     + ", "
		+ "" + id                      + " "
                             + ")";
		System.out.println(insertQuery);

		int rowsInserted;
		
		PreparedStatement pst = con.prepareStatement(insertQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("la consultation à été rajouté"); return true;
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

	} */
	public static boolean create(Consultation p , int id) {

Connection con = Connexion.getConnection();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {  String insertQuery = "INSERT INTO Consultation VALUES("
		+ "" + p.getId_consultation()            + ", "		
		+ "to_Date ('" + sdf.format(p.getDate_consultation())  + "', 'dd-MM-yyyy'),"
		+ "'" + p.getHeure_consultation()            + "', "
		
		+ "" + p.getPoids()            + ", "
		+ "" + p.getGlycemie()         + ", "
		+ "" + p.getCholesterol()      + ", "
		+ "" + p.getTension()          + ", "
		+ "'"+ p.getMaladies()         + "', "
		+ "'"+ p.getObservation()      + "', "
		+ "" + p.getMontant_paye()     + ", "
		+ "" + id                      + " "
                             + ")";
		System.out.println(insertQuery);

		int rowsInserted;
		
		PreparedStatement pst = con.prepareStatement(insertQuery);
		rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			 return true;
		}else return false;
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex, "Erreur", 1);
			return false;
		}

		finally {
			try {
				con.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e, "Erreur", 1);
				}}

	}	
//TODO INIT CONSULTATION.ALL
/*
 * ID_CONSULTATION                           NOT NULL VARCHAR2(10)
 DATE_CONSULTATION                         NOT NULL DATE
 HEURE_CONSULTATION                        NOT NULL VARCHAR2(5)
 POIDS                                              FLOAT(3)
 GLYCEMIE                                           FLOAT(3)
 CHOLESTEROL                                        FLOAT(3)
 TENSION                                            FLOAT(3)
 MALADIES                                           VARCHAR2(600)
 OBSERVATION                                        VARCHAR2(600)
 MONTANT_PAYE                              NOT NULL FLOAT(4)
 ID_PATIENT                                NOT NULL NUMBER(5)
 */

 	public static ArrayList<Consultation> all(int id) {
		ArrayList<Consultation> consultations = new ArrayList<Consultation>();

	
			
Connection con = Connexion.getConnection();
		try {
			
		    PreparedStatement pst = con.prepareStatement("Select * from Consultation WHERE id_patient = ?");
		    pst.setInt(1,id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Consultation c = new Consultation();

				c.setId_consultation(rs.getInt("id_consultation"));
				c.setDate_consultation(rs.getDate("date_consultation"));
				c.setHeure_consultation(rs.getString("heure_consultation"));
				c.setPoids(rs.getDouble("poids"));
				c.setGlycemie(rs.getDouble("glycemie"));
				c.setCholesterol(rs.getDouble("cholesterol"));
				c.setTension(rs.getDouble("tension"));
				c.setMaladies(rs.getString("maladies"));
				c.setObservation(rs.getString("observation"));
				c.setMontant_paye(rs.getDouble("montant_paye"));

				consultations.add(c);
			}

		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog( null, "Problem in all - <Consultation> all "+ex, "Erreur", 1);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e, "Erreur", 1);
				}}

		return consultations;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Consultation.id = id;
	}


	
}
