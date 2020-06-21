package Models;

import java.util.ArrayList;

public class DossierPatient {
	private Patient patient;
	private String groupe_sanguin;
	private String taille;
	private String antecedants;
	private ArrayList<Consultation> consultations;
	public DossierPatient(Patient patient, String groupe_sanguin, String taille, String antecedants) {
		super();
		this.patient = patient;
		this.groupe_sanguin = groupe_sanguin;
		this.taille = taille;
		this.antecedants = antecedants;
		this.setConsultations(new ArrayList<Consultation>());
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
	
	
}
