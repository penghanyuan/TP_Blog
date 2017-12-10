package polytech.sgbd.blog.dao;

import javax.persistence.EntityManager;

import polytech.sgbd.blog.model.Link;

public class LinkDAO {
	private EntityManager em;
	
	public LinkDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(Link link){
		em.getTransaction().begin();
		em.persist(link);
		em.getTransaction().commit();
	}
}
