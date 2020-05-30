
/**
 * @author Ines
 *
 */
public class Secretaire extends Utilisateur{

	public Secretaire(int id_user, String login, String mdp, String nom, String prenom, int num_tel, String email,
			RoleUser role) {
		super(id_user, login, mdp, nom, prenom, num_tel, email, role);
	}

	@Override
	public String toString() {
		return "Secretaire [getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel()
				+ ", getEmail()=" + getEmail() + ", getRole()=" + getRole() + "]";
	}

}
