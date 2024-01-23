package mvcModels;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import entities.Clientimmo;

/**
 * Session Bean implementation class LoginService
 */
@Stateless
@LocalBean
public class LoginService {
	@PersistenceContext(unitName="projetjee")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public LoginService() {
        // TODO Auto-generated constructor stub
    }
    
    public int checkLogin(String email, String password) {
    	TypedQuery<Clientimmo> query = em.createQuery("SELECT l FROM Clientimmo l WHERE l.mailClient = :email and l.mdpClient = :password", Clientimmo.class);
    	query.setParameter("email", email);
    	query.setParameter("password", password);
    	try {
    		Clientimmo client = query.getSingleResult();
    		return client.getIdClient();
    	} catch (NoResultException ex) {
	        return -1;
	    }
    	
    }

}
