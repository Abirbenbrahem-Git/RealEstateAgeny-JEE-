package mvcModels;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Clientimmo;
import entities.Proprietaire;

/**
 * Session Bean implementation class proprietaireService
 */
@Stateless
@LocalBean
public class proprietaireService {
	@PersistenceContext(unitName="projetjee")
	private EntityManager em;

    /**
     * Default constructor. 
     */
	 public proprietaireService() {
	        // TODO Auto-generated constructor stub
	    	
	    }
	public List<Proprietaire> getAllProprietaires()
	{
	List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
	TypedQuery<Proprietaire> query = em.createNamedQuery("Proprietaire.findAll",Proprietaire.class);
	proprietaires = query.getResultList();
	return proprietaires;
	}
	public List<Proprietaire> deleteProprietaireById(int idProprietaire)
	{
		List<Proprietaire> proprietaires = new ArrayList<Proprietaire>();
		Proprietaire proprietaire = em.find(Proprietaire.class, idProprietaire);
		if(proprietaire!=null)
			em.remove(proprietaire);
		
		proprietaires = this.getAllProprietaires();
		return proprietaires;
	}
	public void addProprietaire(Proprietaire proprietaire)
	{
		em.persist(proprietaire);
	}
   

}
