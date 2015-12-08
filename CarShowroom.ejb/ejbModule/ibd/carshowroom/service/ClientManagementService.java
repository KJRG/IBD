package ibd.carshowroom.service;

import ibd.carshowroom.entities.Client;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ClientManagementService
 */
@Stateless
@LocalBean
public class ClientManagementService {

	@PersistenceContext(unitName = "CarPU")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public ClientManagementService() {
    }

    public List<Client> findAllClients() {
    	return em.createQuery("Select c From Client c", Client.class).getResultList();
    }
    
    public Client findClientById(int id) {
    	return em.find(Client.class, id);
    }
    
    public void addClient(Client client) {
    	em.persist(client);
    }

    public void updateClient(Client client) {
    	em.merge(client);
    }
    
    public void deleteClient(Client client) {
    	Client clientToBeRemoved = em.getReference(Client.class, client.getId());
    	em.remove(clientToBeRemoved);
    }
}
