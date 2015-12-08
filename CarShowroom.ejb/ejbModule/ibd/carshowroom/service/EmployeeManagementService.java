package ibd.carshowroom.service;

import ibd.carshowroom.entities.Employee;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Session Bean implementation class EmployeeManagementService
 */
@Stateless
@LocalBean
public class EmployeeManagementService {

	@PersistenceContext(unitName = "CarPU")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public EmployeeManagementService() {
    }

    @RolesAllowed({"admin"})
    public List<Employee> findAllEmployees() {
    	return em.createQuery("Select e From Employee e", Employee.class).getResultList();
    }
    
    public Employee findEmployeeById(int id) {
    	return em.find(Employee.class, id);
    }
    
    public Employee findEmployeeByUsername(String username) {
    	final String queryString = "Select e From Employee e Where e.username Like :username";
    	TypedQuery<Employee> query = em.createQuery(queryString, Employee.class);
    	query.setParameter("username", username);
    	return query.getSingleResult();
    }
    
    @RolesAllowed({"admin"})
    public void addEmployee(Employee employee) {
    	em.persist(employee);
    }
    
    @RolesAllowed({"admin"})
    public void updateEmployee(Employee employee) {
    	em.merge(employee);
    }
    
    @RolesAllowed({"admin"})
    public void deleteEmployee(Employee employee) {
    	Employee employeeToBeRemoved = em.getReference(Employee.class, employee.getId());
    	em.remove(employeeToBeRemoved);
    }
}
