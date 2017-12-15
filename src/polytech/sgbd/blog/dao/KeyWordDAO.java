package polytech.sgbd.blog.dao;

import javax.persistence.EntityManager;

import polytech.sgbd.blog.model.Keyword;

public class KeyWordDAO {

	private EntityManager em;
	
	public KeyWordDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(Keyword keyword){
		em.getTransaction().begin();
		em.persist(keyword);
		em.getTransaction().commit();
	}
	
	public void delete(Keyword keyword){
		//em.getTransaction().begin();
		em.remove(keyword);
		
	}
}
