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
@Table(name = "klient")
public class Client {

	public Client() {
	}

	@Id
	@Column(name = "id_klienta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	@Column(name = "imie_klienta")
	String firstName;

	@Column(name = "nazwisko_klienta")
	String lastName;

	@Column(name = "nr_telefonu")
	String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "adres_id_adresu", referencedColumnName = "id_adresu", nullable = false)
	private Address address;

	@OneToMany(mappedBy = "client", cascade = CascadeType.REMOVE)
	Set<Transaction> transactions = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
