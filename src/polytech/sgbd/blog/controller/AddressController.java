package polytech.sgbd.blog.controller;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.dao.AddressDAO;
import polytech.sgbd.blog.model.Address;

public class AddressController {
	private EntityManager em;
	public AddressController(EntityManager em){
		this.em = em;
	}
	
	public void insert(String country, String city, String postcode, String street,
			int nStreet, String complement){
		Address address = new Address();
		address.setCountry(country);
		address.setCity(city);
		address.setPostcode(postcode);
		address.setStreet(street);
		address.setnStreet(nStreet);
		address.setComplement(complement);

		AddressDAO addressDAO = new AddressDAO(em);
		addressDAO.insert(address);
	}
}
