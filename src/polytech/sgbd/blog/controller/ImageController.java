package polytech.sgbd.blog.controller;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.dao.ImageDAO;
import polytech.sgbd.blog.model.Image;

public class ImageController {
	private EntityManager em;
	public ImageController(EntityManager em){
		this.em = em;
	}
	
	public void insert(String path){
		Image image = new Image();
		image.setPath(path);
		
		ImageDAO imageDAO = new ImageDAO(em);
		imageDAO.insert(image);
	}
}
