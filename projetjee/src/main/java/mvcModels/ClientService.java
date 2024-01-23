package mvcModels;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Clientimmo;
import entities.Clientimmo;
/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ClientService {
	@PersistenceContext(unitName="projetjee")
	private EntityManager em;
    /**
     * Default constructor. 
     */
	public ClientService() {
        // TODO Auto-generated constructor stub
    }
	

	public List<Clientimmo> getAllClients()
	{
	List<Clientimmo> clients = new ArrayList<Clientimmo>();
	TypedQuery<Clientimmo> query = em.createNamedQuery("Clientimmo.findAll",Clientimmo.class);
	clients = query.getResultList();
	return clients;
	}
	//
	public List<Clientimmo> deleteClientById(int idClient)
	{
		List<Clientimmo> clients = new ArrayList<Clientimmo>();
		Clientimmo client = em.find(Clientimmo.class, idClient);
		if(client!=null)
			em.remove(client);
		
		clients = this.getAllClients();
		return clients;
	}
	
	public boolean addClient(Clientimmo client)
	{
		try {
			em.persist(client);
			return true;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }

	}
    

}
