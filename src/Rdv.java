package Models;

import java.util.Date;

/**
 * @author Ines
 *
 */
public class Rdv {
	private int id_rdv;
	private Date date_rdv;
	private String heure_rdv;
	private String type;
	private Patient patient;
	public Rdv(int id_rdv, Date date_rdv, String heure_rdv, String type, Patient patient) {
		super();
		this.id_rdv = id_rdv;
		this.date_rdv = date_rdv;
		this.heure_rdv = heure_rdv;
		this.type = type;
		this.patient = patient;
	}
	public int getId_rdv() {
		return id_rdv;
	}
	public void setId_rdv(int id_rdv) {
		this.id_rdv = id_rdv;
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
	
}
