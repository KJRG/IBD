package ibd.carshowroom.jsf.beans;

import java.util.List;

import ibd.carshowroom.entities.Car;
import ibd.carshowroom.entities.Client;
import ibd.carshowroom.entities.Employee;
import ibd.carshowroom.entities.Transaction;
import ibd.carshowroom.jsf.beans.ejb.ContextProviderBean;
import ibd.carshowroom.service.CarManagementService;
import ibd.carshowroom.service.ClientManagementService;
import ibd.carshowroom.service.EmployeeManagementService;
import ibd.carshowroom.service.TransactionManagementService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "transactionBean")
public class TransactionBean {

	@EJB
	ContextProviderBean contextProviderBean;
	
	@EJB
	ClientManagementService clientService;

	@EJB
	EmployeeManagementService employeeService;

	@EJB
	CarManagementService carService;

	@EJB
	TransactionManagementService transactionService;

	private Client client;
	private Employee employee;
	private Car car;
	private Transaction transaction;
	private List<Employee> employees;
	private List<Car> cars;
	
	private int employeeId = 0;
	private int carId = 0;
	private java.util.Date utilDate = new java.util.Date();
	
	@PostConstruct
	private void init() {
		transaction = new Transaction();
		employees = employeeService.findAllEmployees();
		cars = carService.findAllCars();
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	public java.util.Date getUtilDate() {
		return utilDate;
	}

	public void setUtilDate(java.util.Date utilDate) {
		this.utilDate = utilDate;
	}

	public Client getClient() {
		if(client == null) {
			client = new Client();
		}
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		if(employee == null) {
			employee = new Employee();
		}
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Car getCar() {
		if(car == null) {
			car = new Car();
		}
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Transaction getTransaction() {
		if(transaction == null) {
			transaction = new Transaction();
		}
		return transaction;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public List<Car> getCars() {
		return cars;
	}

	public List<Transaction> getTransactions() {
		return transactionService.findAllTransactions();
	}

	public String sell() {
		if(client != null && employeeId != 0 && carId != 0 && transaction != null) {
			car = carService.findCarById(carId);
//			employee = employeeService.findEmployeeById(employeeId);
			String username = contextProviderBean.getSessionContext().getCallerPrincipal().getName();
			if(username == null) {
				return "transactionList";
			}
			
			employee = employeeService.findEmployeeByUsername(username);
			
			transaction.setDate(new java.sql.Date(utilDate.getTime()));
			transaction.setClient(client);
			transaction.setEmployee(employee);
			transaction.setCar(car);
			transactionService.addTransaction(transaction);

			client = null;
			employee = null;
			car = null;
			employeeId = 0;
			carId = 0;
			transaction = null;
		}
		
		return "transactionList";
	}
	
	public String editTransaction(Transaction transaction) {
		this.transaction = transaction;
		return "editTransaction";
	}
	
	public String updateTransaction() {
		transactionService.updateTransaction(transaction);
		transaction = null;
		return "transactionList";
	}
	
	public String deleteTransaction(Transaction transaction) {
		transactionService.deleteTransaction(transaction);

		return "transactionList";
	}
	
	public String sellToClient(Client client) {
		this.client = client;
		
		return "addTransaction";
	}
}
