package ibd.carshowroom.entities;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transakcja")
public class Transaction {

	public Transaction() {
		price = new BigDecimal(0);
	}
	
	@Id
	@Column(name = "id_transakcji")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "data")
	Date date; 
	
	@Column(name = "cena")
	BigDecimal price;
	
	@Column(name = "nr_vin")
	String vin;
	
	@ManyToOne
	@JoinColumn(name = "klient_id_klienta", referencedColumnName = "id_klienta", nullable = false)
	private Client client;

	@ManyToOne
	@JoinColumn(name = "pracownik_id_pracownika", referencedColumnName = "id_pracownika", nullable = false)
	private Employee employee;

	@ManyToOne
	@JoinColumn(name = "samochod_id_samochodu", referencedColumnName = "id_samochodu", nullable = false)
	private Car car;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
}
