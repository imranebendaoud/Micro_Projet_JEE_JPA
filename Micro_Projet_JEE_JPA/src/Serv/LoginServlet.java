package Serv;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ConnectionPack.DBConnection;
import ConnectionPack.JpaConnection;
import JavaBeans.Client;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String mdp = request.getParameter("password");
		Client client = new Client(email, mdp);
		Boolean b = JpaConnection.testLoginJpa(client);
		
		HttpSession session = request.getSession(true);
		String nom = JpaConnection.getClientJpa(email);
		
		if(b.equals(true)) {
			session.setAttribute("email", email);
			session.setAttribute("password", mdp);
			session.setAttribute("nom", nom);
			request.getRequestDispatcher("acceuil1.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", "Invalid user or password");
			request.getRequestDispatcher("identiferror.jsp").forward(request, response);

		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
