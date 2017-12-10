package polytech.sgbd.blog.dao;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.model.Address;

public class AddressDAO {
	private EntityManager em;
	
	public AddressDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(Address addr){
		em.getTransaction().begin();
		em.persist(addr);
		em.getTransaction().commit();
	}
}
