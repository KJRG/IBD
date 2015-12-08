package ibd.carshowroom.jsf.beans;

import java.util.List;

import ibd.carshowroom.entities.Address;
import ibd.carshowroom.entities.Employee;
import ibd.carshowroom.service.AddressManagementService;
import ibd.carshowroom.service.EmployeeManagementService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "employeeBean")
public class EmployeeBean {

	@EJB
	EmployeeManagementService employeeService;

	@EJB
	AddressManagementService addressService;
	
	private Employee employee;
	private Address address;
	
	public Employee getEmployee() {
		if(employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	public Address getAddress() {
		if(address == null) {
			address = new Address();
		}
		return address;
	}
	
	public List<Employee> getEmployees() {
		return employeeService.findAllEmployees();
	}
	
	public String addEmployee() {
		if (address != null && employee != null) {
			addressService.addAddress(address);

			employee.setAddress(address);
			employeeService.addEmployee(employee);

			address = null;
			employee = null;
		}
		
		return "employeeList";
	}
	
	public String editEmployee(Employee employee) {
		this.employee = employee;
		return "editEmployee";
	}
	
	public String updateEmployee() {
		employeeService.updateEmployee(employee);
		employee = null;
		return "employeeList";
	}
	
	public String deleteEmployee(Employee employee) {
		employeeService.deleteEmployee(employee);
		
		return "employeeList";
	}
}
