package polytech.sgbd.blog.dao;

import javax.persistence.EntityManager;

import polytech.sgbd.blog.model.KeyWord;

public class KeyWordDAO {

	private EntityManager em;
	
	public KeyWordDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(KeyWord keyword){
		em.getTransaction().begin();
		em.persist(keyword);
		em.getTransaction().commit();
	}
	
	public void delete(KeyWord keyword){
		em.getTransaction().begin();
		em.remove(keyword);
		em.getTransaction().commit();
	}
}
