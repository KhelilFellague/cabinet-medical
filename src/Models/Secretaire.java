package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.Connexion;

/**
 * @author Ines
 *
 */
public class Secretaire extends Utilisateur{
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	private ArrayList<Rdv> rdvs = new ArrayList<Rdv>();

	public Secretaire(int id_user, String login, String mdp, String nom, String prenom,String adresse, int num_tel, String email) {
		super(id_user, login, mdp, nom, prenom,adresse, num_tel, email);
		this.patients.addAll(Patient.all()) ;
		this.rdvs.addAll(Rdv.all());
	}
	public Secretaire() {
		super();
		this.patients.addAll(Patient.all()) ;
		this.rdvs.addAll(Rdv.all());
	}
	@Override
	public String toString() {
		return "Secretaire [getId_user()=" + getId_user() + ", getLogin()=" + getLogin() + ", getMdp()=" + getMdp()
				+ ", getNom()=" + getNom() + ", getPrenom()=" + getPrenom() + ", getNum_tel()=" + getNum_tel()
				+ ", getEmail()=" + getEmail()  + "]";
	}

 public static Secretaire Read(String login, String mdp) {
        
     try { 
    	 Secretaire secretaire = new Secretaire();   
     	Connection con = Connexion.getConnection();
		PreparedStatement pst = con.prepareStatement("Select * from Secretaire where login = ? and mdp = ?");
		pst.setString(1, login);
		pst.setString(2, mdp);
		ResultSet rs = pst.executeQuery();
   
            if(rs.next()){
            secretaire.setId_user(rs.getInt("id_user"));
			secretaire.setLogin(rs.getString("login"));
			secretaire.setMdp(rs.getString("mdp"));
			secretaire.setNom(rs.getString("nom"));
			secretaire.setPrenom(rs.getString("prenom"));
			secretaire.setAdresse(rs.getString("adresse"));
			secretaire.setNum_tel(rs.getInt("num_tel"));
			secretaire.setEmail(rs.getString("email"));
			return secretaire;}
        } catch (SQLException ex) {
            System.out.println("Error : Secretaire.Read()" + ex);
        }
	return null;
        
       
    }
public ArrayList<Patient> getPatients() {
	return patients;
}
public void setPatients(ArrayList<Patient> patients) {
	this.patients = patients;
}
public ArrayList<Rdv> getRdvs() {
	return rdvs;
}
public void setRdvs(ArrayList<Rdv> rdvs) {
	this.rdvs = rdvs;
}
/*public JTable tablep() {
	  Object[] column = {"ID", "NON", "PRENOM", "DATE DE NAISSANCE", "SEXE", "ADRESSE","NUMERO","EMAIL"};
	   
      DefaultTableModel dtm = new DefaultTableModel(); 
      dtm.setColumnIdentifiers(column);
      Object[] [] rowData = new Object [this.getPatients().size()][];
		for(int i = 0; i< this.getPatients().size(); i++) {
			rowData[0]  [i] = this.getPatients().get(i).getId_patient();
			rowData[1] [i]= this.getPatients().get(i).getNom();
			rowData[2] [i]= this.getPatients().get(i).getPrenom();
			rowData[3] [i]= this.getPatients().get(i).getDate_naissance();
			rowData[4] [i]= this.getPatients().get(i).getSexe();
			rowData[5] [i]= this.getPatients().get(i).getAdresse();
			rowData[6] [i]= this.getPatients().get(i).getNum_tel();
			rowData[7] [i]= this.getPatients().get(i).getEmail();
			dtm.addRow(rowData);
		}
      JTable table = new JTable(dtm);
      table.setModel(dtm);
	return table;
}*/
}


