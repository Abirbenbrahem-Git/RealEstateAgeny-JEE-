package mvcModels;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Immobilier;
/**
 * Session Bean implementation class ClientService
 */
@Stateless
@LocalBean
public class ImmobilierService {
	@PersistenceContext(unitName="projetjee")
	private EntityManager em;
    /**
     * Default constructor. 
     */
	public ImmobilierService() {
        // TODO Auto-generated constructor stub
    }
	
	//affichier les immobiliers
	public List<Immobilier> getAllImmobiliers()
	{
		List<Immobilier> Immobiliers = new ArrayList<Immobilier>();
		TypedQuery<Immobilier> query = em.createNamedQuery("Immobilier.findAll",Immobilier.class);
		Immobiliers = query.getResultList();
		return Immobiliers;
	}
	
	
	//supprimer un immobilier
	public List<Immobilier> deleteImmobilierById(int immobilierId)
	{
		List<Immobilier> immoList = new ArrayList<Immobilier>();
		Immobilier immo = em.find(Immobilier.class, immobilierId);
		if(immo!=null)
			em.remove(immo);
		immoList = this.getAllImmobiliers();
		return immoList;
	}
    

}
