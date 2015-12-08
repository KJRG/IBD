package ibd.carshowroom.entities;

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
@Table(name = "adres")
public class Address {

	public Address() {
	}
	
	@Id
	@Column(name = "id_adresu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "kraj")
	String country;

	@Column(name = "wojewodztwo")
	String district;

	@Column(name = "miasto")
	String city;

	@Column(name = "ulica")
	String street;

	@Column(name = "nr_domu")
	String houseNumber;

	@Column(name = "nr_mieszkania")
	String apartmentNumber;
	
	@OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
	Set<Client> clients = new HashSet<>();

	@OneToMany(mappedBy = "address", cascade = CascadeType.REMOVE)
	Set<Employee> employees = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
}
