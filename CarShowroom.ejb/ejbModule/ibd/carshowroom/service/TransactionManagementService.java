package ibd.carshowroom.service;

import ibd.carshowroom.entities.Transaction;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class TransactionManagementService
 */
@Stateless
@LocalBean
public class TransactionManagementService {

	@PersistenceContext(unitName = "CarPU")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public TransactionManagementService() {
    }

    public List<Transaction> findAllTransactions() {
    	return em.createQuery("Select t From Transaction t", Transaction.class).getResultList();
    }
    
    public void addTransaction(Transaction transaction) {
    	em.persist(transaction);
    }
    
    public void updateTransaction(Transaction transaction) {
    	em.merge(transaction);
    }
    
    public void deleteTransaction(Transaction transaction) {
    	Transaction transactionToBeRemoved = em.getReference(Transaction.class, transaction.getId());
    	em.remove(transactionToBeRemoved);
    }
}
