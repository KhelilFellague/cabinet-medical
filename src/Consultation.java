package Models;

import java.util.ArrayList;
import java.util.Date;

public class Consultation {
	private int id_consultation;
	private Date date_consultation;
	private double poids;
	private double glycemie;
	private double cholestérol;
	private double tension;
	private String maladies;
	private String observation;
	private double montant_payé;
	private ArrayList<Bilan>bilans;
	private ArrayList<Ordonnance> ordonnances;
	
	public Consultation(int id_consultation, Date date_consultation, double poids, double glycemie, double cholestérol,
			double tension, String maladies, String observation, double montant_payé) {
		super();
		this.id_consultation = id_consultation;
		this.date_consultation = date_consultation;
		this.poids = poids;
		this.glycemie = glycemie;
		this.cholestérol = cholestérol;
		this.tension = tension;
		this.maladies = maladies;
		this.observation = observation;
		this.montant_payé = montant_payé;
		this.bilans = new ArrayList<Bilan>();
		this.ordonnances = new ArrayList<Ordonnance>();
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

	public double getCholestérol() {
		return cholestérol;
	}

	public void setCholestérol(double cholestérol) {
		this.cholestérol = cholestérol;
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

	public double getMontant_payé() {
		return montant_payé;
	}

	public void setMontant_payé(double montant_payé) {
		this.montant_payé = montant_payé;
	}

	public ArrayList<Bilan> getBilans() {
		return bilans;
	}

	public void setBilans(ArrayList<Bilan> bilans) {
		this.bilans = bilans;
	}

	public ArrayList<Ordonnance> getOrdonnances() {
		return ordonnances;
	}

	public void setOrdonnances(ArrayList<Ordonnance> ordonnances) {
		this.ordonnances = ordonnances;
	}

	@Override
	public String toString() {
		return "Consultation [id_consultation=" + id_consultation + ", date_consultation=" + date_consultation
				+ ", poids=" + poids + ", glycemie=" + glycemie + ", cholestérol=" + cholestérol + ", tension="
				+ tension + ", maladies=" + maladies + ", observation=" + observation + ", montant_payé=" + montant_payé
				+ ", bilans=" + bilans + ", ordonnances=" + ordonnances + "]";
	}
	
	
}
