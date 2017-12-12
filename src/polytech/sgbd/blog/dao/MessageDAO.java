package polytech.sgbd.blog.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import javassist.compiler.ast.Keyword;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.Message;
import polytech.sgbd.blog.model.User;

public class MessageDAO {
	private EntityManager em;

	public MessageDAO(EntityManager em) {
		this.em = em;
	}

	public void insert(Message message) {
		em.getTransaction().begin();
		em.persist(message);
		em.getTransaction().commit();
	}

	public List<Message> selectAll() {
		String sql = "select message from Message message";
		Query query = em.createQuery(sql);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
	}

	public List<Message> selectByUser(User user) {
		// unsafe
		String sql = "select message from Message message where message.user = :user";
		Query query = em.createQuery(sql);
		query.setParameter(0, user);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
	}

	public List<Message> selectByUserId(int userId) {
		String sql = "select message from Message message where message.user.id = :userId";
		Query query = em.createQuery(sql);
		query.setParameter("userId", userId);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
	}

	public List<Message> selectByDate(Date date) {
		String sql = "select message from Message message where message.date = :date";
		Query query = em.createQuery(sql);
		query.setParameter("date", date);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
	}

	public List<Message> selectByKeyword(Keyword keyword) {
		String sql = "select message from Message message where message.keyword = :keyword";
		Query query = em.createQuery(sql);
		query.setParameter("keyword", keyword);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
	}

	public Message selectById(int id) {
		return SessionController.getEm().find(Message.class, id);
	}
	
	public boolean deleteById(int id){
		String sql = "delete message from Message message where message.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean modifyById(int id, String newText){
		String sql = "update Message message set message.text = :newText where message.id = :id";
		Query query = em.createQuery(sql);
		query.setParameter("newText", newText);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		
		if(result > 0){
			return true;
		}else{
			return false;
		}
	}
}
