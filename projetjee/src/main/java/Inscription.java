

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Clientimmo;
import mvcModels.ClientService;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientService clientService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("inscription.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd ;
		// TODO Auto-generated method stub
		String nom = request.getParameter("Nom");
		String prenom = request.getParameter("Prenom");
		String email = request.getParameter("Email");
		String pwd = request.getParameter("password");
		int CINClient = Integer.parseInt(request.getParameter("CIN"));
		Clientimmo client = new Clientimmo();
		client.setCINClient(CINClient);
		client.setMailClient(email);
		client.setMdpClient(pwd);
		client.setPrenomClient(prenom);
		boolean test = clientService.addClient(client);
		if (test) {
			//response.sendRedirect("./index");
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			response.getWriter().append("Error.");
			
		}
		//doGet(request, response);
	}

}
