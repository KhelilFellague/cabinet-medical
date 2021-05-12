package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import database.Connexion;

/**
 * @author Ines
 *
 */
public class Rdv {
	private Date date_rdv;
	private String heure_rdv;
	private String type;
	private Patient patient;
	public Rdv(Date date_rdv, String heure_rdv, String type, Patient patient) {
		super();
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.type = type;
		this.patient = patient;
	}

	public Rdv() {
		super();
	}

	public Date getDate_rdv() {
		return date_rdv;
	}
	public void setDate_rdv(Date date_rdv) {
		this.date_rdv = date_rdv;
	}
	public String getHeure_rdv() {
		return heure_rdv;
	}
	public void setHeure_rdv(String heure_rdv) {
		this.heure_rdv = heure_rdv;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
  @Override
	public String toString() {
		return "Rdv [date_rdv=" + date_rdv + ", heure_rdv=" + heure_rdv + ", type=" + type + ", patient=" + patient
				+ "]";
	}

  public static boolean create(Rdv d)  {

	  Connection con = Connexion.getConnection();
	  PreparedStatement pst;
	  int rowsInserted;
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	  try { 
		  String insertQuery = "INSERT INTO Rdv(date_rdv, heure_rdv, type ,  id_patient ) VALUES("

				+ "to_Date ('" + sdf.format(d.getDate_rdv())        + "','dd-MM-YYYY'), "
				+ "'" + d.getHeure_rdv()                           + "', "
				+ "'" + d.getType()                                + "', "
				+   d.getPatient().getId_patient()                 + ")";                    
		  
		  pst = con.prepareStatement(insertQuery);
		  rowsInserted = pst.executeUpdate();
		  if (rowsInserted > 0) {
			  return true;
		  }else return false;


	  } catch (Exception ex) {
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
  
  public static boolean createN(Rdv d)  {

	  Connection con = Connexion.getConnection();
	  PreparedStatement pst;
	  int rowsInserted;
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	  try { 
		  String insertQuery = "INSERT INTO Rdv(date_rdv, heure_rdv, type ) VALUES("

				+ "to_Date ('" + sdf.format(d.getDate_rdv())        + "','dd-MM-YYYY'), "
				+ "'" + d.getHeure_rdv()                           + "', "
				+ "'" + d.getType()                                + "') ";                    
		 

		  pst = con.prepareStatement(insertQuery);
		  rowsInserted = pst.executeUpdate();
		  if (rowsInserted > 0) {
			  return true;
		  }else return false;


	  } catch (Exception ex) {
		  System.out.println("Problem in  createN" + ex);
		  return false;
	  }
	  finally {
		  try {
			  con.close();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }}

  }
		
//all	 
	     public static ArrayList<Rdv> all() {
		  
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		Connection con = Connexion.getConnection();

		try {
			
		    PreparedStatement pst = con.prepareStatement("Select * from Rdv  order by date_rdv,heure_rdv");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Rdv rdv = new Rdv();

				rdv.setDate_rdv(rs.getDate("date_rdv"));
				rdv.setHeure_rdv(rs.getString("heure_rdv"));
				rdv.setType(rs.getString("type"));
				rdv.setPatient(Patient.ReadId(rs.getInt("id_patient")));
				rdvs.add(rdv);
			}

		} catch (Exception ex) {
			System.out.println("Problem in all - <Rdv> all" + ex);
		}
		finally {
			try {
				con.close();
				} catch (SQLException e) {
						e.printStackTrace();
				}}

		return rdvs;
	}
	 
	 public static ArrayList<Rdv> allDate(ArrayList<Rdv> r,Date d){
		 ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		 for(Rdv rdv: r) {
			 if(rdv.getDate_rdv().compareTo(d)==0) {
				 rdvs.add(rdv);
			 }
		 }
		 
		return rdvs;
		 
	 }
	
}
