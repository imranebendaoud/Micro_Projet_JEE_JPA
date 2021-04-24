package JavaBeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity@Table(name = "categories")
public class Categorie {
	@Id@Column(name="RefCat")

	int id;
	@Column(name="Cat")

	String categorie;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Categorie(int id, String categorie) {
		super();
		this.id = id;
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		return "Categorie [id=" + id + ", categorie=" + categorie + "]";
	}
}
