
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.GestionClient;
import mvcModels.ClientService;
import mvcModels.proprietaireService;
import mvcModels.ReservationService;
import entities.Clientimmo;
import entities.Immobilier;
import entities.Proprietaire;
import entities.Reservation;



/**
 * Servlet implementation class ProjetServlet
 */
@WebServlet("/ProjetServlet")
public class ProjetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ClientService clientService;
	private proprietaireService proprietaireService;  
	private ReservationService reservationService; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext ctx = getServletContext();
		
		
        String action = request.getParameter("action");
        RequestDispatcher rd ;
        //inscription d'un client
        String agent = request.getParameter("agent");
		if(action!=null && action.equals("S'inscrire"))
		{
			
				String chaineIdClient = request.getParameter("CIN");
				int CINClient = Integer.parseInt(chaineIdClient);
				String nom = request.getParameter("Nom");
				String prenom = request.getParameter("Prenom");
				String email = request.getParameter("Email");
				String pwd = request.getParameter("password");
				Clientimmo client = new Clientimmo();
				client.setCINClient(CINClient);
				client.setMailClient(email);
				client.setMdpClient(pwd);
				client.setPrenomClient(prenom);
				clientService.addClient(client);
			}
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		
			if(action!=null && action.equals("Reserver"))
			{
				
//					String chaineIdClient = request.getParameter("idres");
//					int idres = Integer.parseInt(chaineIdClient);
//					
//					String datearrive = request.getParameter("datearrive");
//					String datedepart = request.getParameter("datedepart");
//					Clientimmo idClient = request.getParameter("idClient");
//					Immobilier idimmobilier = request.getParameter("idimmobilier");
//					Reservation reservation = new Reservation();
//					reservation.setIdres(idres);
//					reservation.setDatearrive(datearrive);
//					reservation.setDatedepart(datedepart);
//					reservation.setClientimmo(idClient);
//					reservation.setImmobilier(idimmobilier);
//					reservationService.addReservation(reservation);
				}
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			
			
			
	}
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
