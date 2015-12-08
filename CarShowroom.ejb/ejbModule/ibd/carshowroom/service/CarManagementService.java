package ibd.carshowroom.service;

import ibd.carshowroom.entities.Car;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class CarManagementService
 */
@Stateless
@LocalBean
public class CarManagementService {

	@PersistenceContext(unitName = "CarPU")
	EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CarManagementService() {
    }

    public List<Car> findAllCars() {
    	return em.createQuery("Select c From Car c", Car.class).getResultList();
    }
    
    public Car findCarById(int id) {
    	return em.find(Car.class, id);
    }
    
    public void addCar(Car car) {
    	em.persist(car);
    }
    
    public void updateCar(Car car) {
    	em.merge(car);
    }
    
    public void deleteCar(Car car) {
    	Car carToBeRemoved = em.getReference(Car.class, car.getId());
    	em.remove(carToBeRemoved);
    }
}
