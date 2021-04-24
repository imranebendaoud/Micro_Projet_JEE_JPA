package ConnectionPack;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import JavaBeans.Article;
import JavaBeans.Categorie;
import JavaBeans.Client;

public class JpaConnection {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("GI-4");
		EntityManager entitymanager = emfactory.createEntityManager();
		return entitymanager;
	}
	
	public static String insertDataJpa(Client client) {
		
			EntityManager entitymanager = getEntityManager();
			entitymanager.getTransaction().begin();
			entitymanager.persist(client);
			entitymanager.getTransaction().commit();
			entitymanager.close();
			return "inserted";			
		}


	public static boolean testLoginJpa(Client client) {
		EntityManager entitymanager = getEntityManager();
		try {
			Client c = entitymanager.createQuery("SELECT b FROM Client as b WHERE b.email = :email and b.motpasse= :mdp",Client.class)
					.setParameter("email", client.getEmail()).setParameter("mdp", client.getMotpasse()).getSingleResult();
			return true;
		}catch (Exception e) {
			return false;
		}

	}
	public static ArrayList<Article> getArticleJpa(String categorie) {
		EntityManager entityManager = getEntityManager();
		try {
			Categorie categoriee = entityManager.createQuery("select a from Categorie as a where a.id= :refcat", Categorie.class)
				 .setParameter("refcat", Integer.parseInt(categorie)).getSingleResult();
			String cat = categoriee.getCategorie();
			ArrayList<Article> listArticles = (ArrayList<Article>) entityManager.createQuery("select c from Article as c where c.categorie= :cat", Article.class)
					 .setParameter("cat", cat).getResultList();
			return listArticles;
		}catch (Exception e) {
			 return null;
		}
	}
	
	public static ArrayList<Categorie> listCategoriesJpa() {
		EntityManager entityManager = getEntityManager();
        return (ArrayList<Categorie>) entityManager.createQuery("from Categorie",Categorie.class).getResultList();
    }

	public static Article getArticle2Jpa(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.createQuery("select a from Article as a where a.id=:id",Article.class).setParameter("id", id).getSingleResult();
		
	}
	
	public static String getClientJpa(String email) {
		EntityManager entityManager = getEntityManager();
		Client c = entityManager.createQuery("select c from Client as c where c.email=:email",Client.class).setParameter("email", email).getSingleResult();
		return c.getNom();
	}

	
}