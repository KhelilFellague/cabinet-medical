package Models;

public class Ordonnance {
	private int id_Med;
	private String nom_Med;
	private int dosage_Med;
	private String dureeTraitement;
	private String posologie;
	public Ordonnance(int id_Med, String nom_Med, int dosage_Med, String dureeTraitement, String posologie) {
		super();
		this.id_Med = id_Med;
		this.nom_Med = nom_Med;
		this.dosage_Med = dosage_Med;
		this.dureeTraitement = dureeTraitement;
		this.posologie = posologie;
	}
	public int getId_Med() {
		return id_Med;
	}
	public void setId_Med(int id_Med) {
		this.id_Med = id_Med;
	}
	public String getNom_Med() {
		return nom_Med;
	}
	public void setNom_Med(String nom_Med) {
		this.nom_Med = nom_Med;
	}
	public int getDosage_Med() {
		return dosage_Med;
	}
	public void setDosage_Med(int dosage_Med) {
		this.dosage_Med = dosage_Med;
	}
	public String getDureeTraitement() {
		return dureeTraitement;
	}
	public void setDureeTraitement(String dureeTraitement) {
		this.dureeTraitement = dureeTraitement;
	}
	public String getPosologie() {
		return posologie;
	}
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}
	@Override
	public String toString() {
		return "Ordonnance \n"
				+ "id_Med=" + id_Med + ", nom_Med=" + nom_Med + ", dosage_Med=" + dosage_Med
				+ ", dureeTraitement=" + dureeTraitement + ", posologie=" + posologie + "]";
	}
	
	
}
