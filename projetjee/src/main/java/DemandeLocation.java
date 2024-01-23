

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvcModels.ReservationService;



/**
 * Servlet implementation class DemandeLocation
 */
@WebServlet("/demandeLocation")
public class DemandeLocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private ReservationService reservationService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandeLocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		if (session.getAttribute("loggedIn") == null) {

			response.sendRedirect("./login");

		} else { 
			RequestDispatcher rd = request.getRequestDispatcher("DemandeLocation.jsp");
			rd.include(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession(true);
		
		if (session.getAttribute("loggedIn") == null) {

			response.sendRedirect("./login");

		} else { 
			int idClient = (int) session.getAttribute("idClient");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String datearriveString = request.getParameter("datearrive");
			String datedepartString = request.getParameter("datedepart");
			int idimmobilier = Integer.parseInt(request.getParameter("idimmobilier"));
			Date datearrive = null;
			Date datedepart = null;
			try {
				datearrive = dateFormat.parse(datearriveString);
				datedepart = dateFormat.parse(datedepartString);
				boolean done = reservationService.addReservation(idClient, datedepart, datearrive, idimmobilier);
				if (done) {
					response.getWriter().append("Reservation crée avec success.");
				} else {
					response.getWriter().append("Error.");
				}
				
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
