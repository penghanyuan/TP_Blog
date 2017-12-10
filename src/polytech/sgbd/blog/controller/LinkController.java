package polytech.sgbd.blog.controller;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.dao.LinkDAO;
import polytech.sgbd.blog.model.Link;

public class LinkController {
	private EntityManager em;
	public LinkController(EntityManager em){
		this.em = em;
	}
	
	/*
	public void insert(String address, String text){
		Link link = new Link();
		link.setAddress(address);
		link.setText(text);
		
		LinkDAO linkDAO = new LinkDAO(em);
		linkDAO.insert(link);
	}
	*/
}
