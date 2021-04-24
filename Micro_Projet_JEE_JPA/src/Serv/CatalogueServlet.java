package Serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConnectionPack.DBConnection;
import ConnectionPack.JpaConnection;
import JavaBeans.Article;
import JavaBeans.Categorie;


@WebServlet("/CatalogueServlet")
public class CatalogueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CatalogueServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			ArrayList<Categorie> listCategorie = JpaConnection.listCategoriesJpa();			
			request.setAttribute("listCategorie", listCategorie);
			ArrayList<Article> listArticle = JpaConnection.getArticleJpa(request.getParameter("select"));
			request.setAttribute("listArticle", listArticle);
			request.getRequestDispatcher("catalogue.jsp").forward(request, response);
		     
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
