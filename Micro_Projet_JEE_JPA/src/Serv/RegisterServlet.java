package Serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ConnectionPack.DBConnection;
import ConnectionPack.JpaConnection;
import JavaBeans.Client;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("nom") == null){
			request.getRequestDispatcher("inscrire1.jsp").forward(request, response);
		}
		else {
			
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String email = request.getParameter("email");
		String adresse = request.getParameter("adresse");
		int tel = Integer.parseInt(request.getParameter("tel"));
		String mdp = request.getParameter("password");

		Client client = new Client(email, nom, prenom, adresse, mdp, tel);
		String inserted = JpaConnection.insertDataJpa(client);

		if (inserted.equals("inserted")) {

			request.getRequestDispatcher("identif1.jsp").forward(request, response);

		} else {
			request.getRequestDispatcher("inscrire1.jsp").forward(request, response);
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
