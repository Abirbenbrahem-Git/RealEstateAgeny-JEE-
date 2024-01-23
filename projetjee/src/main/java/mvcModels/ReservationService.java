package mvcModels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Clientimmo;
import entities.Immobilier;
import entities.Reservation;

/**
 * Session Bean implementation class ReservationService
 */
@Stateless
@LocalBean
public class ReservationService {
	@PersistenceContext(unitName="projetjee")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public ReservationService() {
        // TODO Auto-generated constructor stub
    }
    
    public List<Reservation> getAllReservations()
	{
	List<Reservation> reservations = new ArrayList<Reservation>();
	TypedQuery<Reservation> query = em.createNamedQuery("Reservation.findAll",Reservation.class);
	reservations = query.getResultList();
	return reservations;
	}
    
    public List<Reservation> deleteClientById(int idres)
	{
		List<Reservation> reservations = new ArrayList<Reservation>();
		Reservation reservation = em.find(Reservation.class, idres);
		if(reservation!=null)
			em.remove(reservation);
		
		reservations = this.getAllReservations();
		return reservations;
	}
    public boolean addReservation(int idClient, Date datedepart, Date datearrive, int idImmob)
	{
    	try {
        	Clientimmo client = em.find(Clientimmo.class, idClient);
        	Immobilier imm = em.find(Immobilier.class, idImmob);
        	Reservation r = new Reservation();
        	r.setClientimmo(client);
        	r.setDatearrive(datearrive);
        	r.setDatedepart(datedepart);
        	r.setImmobilier(imm);
    		em.persist(r);
    		return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }

	}
}
