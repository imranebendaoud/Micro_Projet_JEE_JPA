package JavaBeans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name = "clients")
public class Client {
@Id
int id;
String email,nom,prenom,adresse,motpasse;
int tel;


public Client() {
	super();
	// TODO Auto-generated constructor stub
}
public Client(String email, String motpasse) {
	super();
	this.email = email;
	this.motpasse = motpasse;
}
public Client(String email, String nom, String prenom, String adresse, String motpasse, int tel) {
	super();
	this.email = email;
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.motpasse = motpasse;
	this.tel = tel;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
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
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getMotpasse() {
	return motpasse;
}
public void setMotpasse(String motpasse) {
	this.motpasse = motpasse;
}
public int getTel() {
	return tel;
}
public void setTel(int tel) {
	this.tel = tel;
}

}
