package ibd.carshowroom.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pracownik")
public class Employee {

	public Employee() {
	}

	@Id
	@Column(name = "id_pracownika")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "login")
	String username;

	@Column(name = "haslo")
	String password;

	@Column(name = "imie_pracownika")
	String firstName;

	@Column(name = "nazwisko_pracownika")
	String lastName;

	@Column(name = "nr_telefonu")
	String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "adres_id_adresu", referencedColumnName = "id_adresu", nullable = false)
	private Address address;

	@OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
	Set<Transaction> transactions = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	@Override
	public String toString() {
		return id + ". " + firstName + " " + lastName;
	}
}
