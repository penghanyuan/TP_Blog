package polytech.sgbd.blog.model;

import javax.persistence.*;

@Entity
public class Address {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String country;
	private String city;
	private String postcode;
	private String street;
	private int nStreet;
	private String complement;
	
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "address")
	private User user;


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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPostcode() {
		return postcode;
	}


	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public int getnStreet() {
		return nStreet;
	}


	public void setnStreet(int nStreet) {
		this.nStreet = nStreet;
	}


	public String getComplement() {
		return complement;
	}


	public void setComplement(String complement) {
		this.complement = complement;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
}