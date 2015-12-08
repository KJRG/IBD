package ibd.carshowroom.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "samochod")
public class Car {

	public Car() {
	}
	
	@Id
	@Column(name = "id_samochodu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "marka")
	String make;
	
	@Column(name = "model")
	String model;
	
	@Column(name = "wersja")
	String version;
	
	@Column(name = "cena")
	BigDecimal price;
	
	@Column(name = "spalanie")
	double fuelConsumption;
	
	@Column(name = "pojemnosc")
	short capacity;

	@Column(name = "rodzaj_paliwa")
	String fuel;
	
	@OneToMany(mappedBy = "car", cascade = CascadeType.REMOVE)
	Set<Transaction> transactions = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public short getCapacity() {
		return capacity;
	}

	public void setCapacity(short capacity) {
		this.capacity = capacity;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return make + " " + model + " " + version + " " + capacity + " " + fuel;
	}
}
