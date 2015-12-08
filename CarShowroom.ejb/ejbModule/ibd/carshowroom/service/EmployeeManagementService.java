package ibd.carshowroom.service;

import ibd.carshowroom.entities.Employee;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

    public List<Employee> findAllEmployees() {
    	return em.createQuery("Select e From Employee e", Employee.class).getResultList();
    }
    
    public Employee findEmployeeById(int id) {
    	return em.find(Employee.class, id);
    }
    
    public void addEmployee(Employee employee) {
    	em.persist(employee);
    }
    
    public void updateEmployee(Employee employee) {
    	em.merge(employee);
    }
    
    public void deleteEmployee(Employee employee) {
    	Employee employeeToBeRemoved = em.getReference(Employee.class, employee.getId());
    	em.remove(employeeToBeRemoved);
    }
}
