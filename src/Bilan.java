package Models;

public class Bilan {
	private int id_bilan;
	private String nom_bilan;
	private String resultat_bilan;
	public Bilan(int id_bilan, String nom_bilan, String resultat_bilan) {
		super();
		this.id_bilan = id_bilan;
		this.nom_bilan = nom_bilan;
		this.resultat_bilan = resultat_bilan;
	}
	public int getId_bilan() {
		return id_bilan;
	}
	public void setId_bilan(int id_bilan) {
		this.id_bilan = id_bilan;
	}
	public String getNom_bilan() {
		return nom_bilan;
	}
	public void setNom_bilan(String nom_bilan) {
		this.nom_bilan = nom_bilan;
	}
	public String getResultat_bilan() {
		return resultat_bilan;
	}
	public void setResultat_bilan(String resultat_bilan) {
		this.resultat_bilan = resultat_bilan;
	}
	@Override
	public String toString() {
		return "Bilan [id_bilan=" + id_bilan + ", nom_bilan=" + nom_bilan + ", resultat_bilan=" + resultat_bilan + "]";
	}
	
}
