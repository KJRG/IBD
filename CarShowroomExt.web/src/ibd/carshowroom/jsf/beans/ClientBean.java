package ibd.carshowroom.jsf.beans;

import ibd.carshowroom.entities.Address;
import ibd.carshowroom.entities.Client;
import ibd.carshowroom.service.AddressManagementService;
import ibd.carshowroom.service.ClientManagementService;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SessionScoped
@ManagedBean(name = "clientBean")
public class ClientBean {

	@EJB
	ClientManagementService clientService;

	@EJB
	AddressManagementService addressService;
	
	private Client client;
	private Address address;
	
	public Client getClient() {
		if(client == null) {
			client = new Client();
		}
		return client;
	}

	public Address getAddress() {
		if(address == null) {
			address = new Address();
		}
		return address;
	}
	
	public List<Client> getClients() {
		return clientService.findAllClients();
	}
	
	public String addClient() {
		if (address != null && client != null) {
			addressService.addAddress(address);

			client.setAddress(address);
			clientService.addClient(client);

			address = null;
			client = null;
		}
		
		return "clientList";
	}
	
	public String editClient(Client client) {
		this.client = client;
		return "editClient";
	}
	
	public String updateClient() {
		clientService.updateClient(client);
		client = null;
		return "clientList";
	}
	
	public String deleteClient(Client client) {
		clientService.deleteClient(client);
		
		return "clientList";
	}
}
