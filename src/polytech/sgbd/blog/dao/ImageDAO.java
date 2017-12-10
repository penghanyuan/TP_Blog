package polytech.sgbd.blog.dao;

import javax.persistence.EntityManager;

import polytech.sgbd.blog.model.Image;

public class ImageDAO {

	private EntityManager em;
	
	public ImageDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(Image image){
		em.getTransaction().begin();
		em.persist(image);
		em.getTransaction().commit();
	}
}
