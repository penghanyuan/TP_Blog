package polytech.sgbd.blog.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import javassist.compiler.ast.Keyword;
import polytech.sgbd.blog.dao.MessageDAO;
import polytech.sgbd.blog.model.*;

public class MessageController {
	private EntityManager em;
	private MessageDAO messageDAO;
	public MessageController(EntityManager em){
		this.em = em;
		this.messageDAO = new MessageDAO(em);
	}
	
	public void insert(String title, String text, Date date, User user,
			List<Image> images, List<Link> links, List<KeyWord> keywords){
		Message message = new Message();
		message.setTitle(title);
		message.setText(text);
		message.setDate(date);
		message.setUser(user);
		message.setImages(images);
		message.setLinks(links);
		message.setKeyWords(keywords);
		
		messageDAO.insert(message);
	}
	
	public List<Message> getAll(){
		return messageDAO.selectAll();
	}
	
	public List<Message> getByUser(User user){
		return messageDAO.selectByUser(user);
	}
	
	public List<Message> getByDate(Date date){
		return messageDAO.selectByDate(date);
	}
	
	public List<Message> getByKeyword(Keyword keyword){
		return messageDAO.selectByKeyword(keyword);
	}
}
