
/**
 * @author Ines
 *
 */
public class Medecin extends Utilisateur{
	
	private String specialite;
	private String adresse_cabinet;
	private String num_ordre;

public Medecin(int id_user, String login, String mdp, String nom, String prenom, int num_tel, String email,RoleUser role,
String specialite,String adresse_cabinet, String num_ordre) {
		super(id_user, login, mdp, nom, prenom, num_tel, email,role);
		this.specialite = specialite;
		this.adresse_cabinet = adresse_cabinet;
		this.num_ordre = num_ordre;
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
			+ ", getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp() + ", getNom()="
			+ getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel() + ", getEmail()="
			+ getEmail() + ", getRole()=" + getRole()+ "]";
}
	
}
