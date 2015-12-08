package ibd.carshowroom.jsf.beans;

import java.util.List;

import ibd.carshowroom.entities.Car;
import ibd.carshowroom.service.CarManagementService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "carBean")
public class CarBean {

	@EJB
	CarManagementService carService;
	
	private Car car;
	
	public Car getCar() {
		if(car == null) {
			car = new Car();
		}
		return car;
	}
	
	public List<Car> getCars() {
		return carService.findAllCars();
	}
	
	public String addCar() {
		if (car != null) {
			carService.addCar(car);
			car = null;
		}
		
		return "carList";
	}
	
	public String editCar(Car car) {
		this.car = car;
		return "editCar";
	}
	
	public String updateCar() {
		carService.updateCar(car);
		car = null;
		return "carList";
	}
	
	public String deleteCar(Car car) {
		carService.deleteCar(car);
		
		return "carList";
	}
}
