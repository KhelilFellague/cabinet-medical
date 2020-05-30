
/**
 * @author Assia, Ines
 *
 */
public class Utilisateur {
	private int id_user;
	private String login; // contrainte unique
	private String mdp;
	private String nom;
	private String prenom;
	private int num_tel;
	private String email;
	private RoleUser role;
	public Utilisateur(int id_user, String login, String mdp, String nom, String prenom, int num_tel, String email,RoleUser role) {
		super();
		this.id_user = id_user;
		this.login = login;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.num_tel = num_tel;
		this.email = email;
		this.role = role;
	}

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMdp() {
		return mdp;
	}
	public void setMdp(String mdp) {
		this.mdp = mdp;
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
	
	public RoleUser getRole() {
		return role;
	}
	public void setRole(RoleUser role) {
		this.role = role;
	}
}
