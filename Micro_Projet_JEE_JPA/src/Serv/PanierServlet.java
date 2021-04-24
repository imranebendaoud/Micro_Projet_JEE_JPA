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


@WebServlet("/PanierServlet")
public class PanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static ArrayList<Article> articlelist = new ArrayList<Article>();

    
    public PanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Article article = JpaConnection.getArticle2Jpa(id);
		
		if(request.getParameter("ordre").equals("ajouter")){
			articlelist.add(article);
		}
		if(request.getSession(false).getAttribute("nom") == null) {
			articlelist.clear();
		}
		
		request.setAttribute("articlelist", articlelist);
		request.getRequestDispatcher("panier.jsp").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
