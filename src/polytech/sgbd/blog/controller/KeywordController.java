package polytech.sgbd.blog.controller;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.dao.KeyWordDAO;
import polytech.sgbd.blog.model.Keyword;

public class KeywordController {
	private EntityManager em;
	public KeywordController(EntityManager em){
		this.em = em;
	}
	
	/*
	public void insert(String text){
		KeyWord keyword = new KeyWord();
		keyword.setText(text);
		
		KeyWordDAO keywordDAO = new KeyWordDAO(em);
		keywordDAO.insert(keyword);
	}
	*/
	
	public void delete(Keyword keyword){
		KeyWordDAO keywordDAO = new KeyWordDAO(em);
		keywordDAO.delete(keyword);	
	}
}
