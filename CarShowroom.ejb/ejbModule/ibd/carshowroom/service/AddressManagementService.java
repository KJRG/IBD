package ibd.carshowroom.service;

import ibd.carshowroom.entities.Address;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class AddressManagementService
 */
@Stateless
@LocalBean
public class AddressManagementService {

	@PersistenceContext(unitName = "CarPU")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public AddressManagementService() {
    }

    public List<Address> findAllAddresses() {
    	return em.createQuery("Select a From Address a", Address.class).getResultList();
    }
    
    public void addAddress(Address address) {
    	em.persist(address);
    }
    
    public void deleteAddress(Address address) {
    	Address addressToBeRemoved = em.getReference(Address.class, address.getId());
    	em.remove(addressToBeRemoved);
    }
}
