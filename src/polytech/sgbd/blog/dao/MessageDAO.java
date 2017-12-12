package polytech.sgbd.blog.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import javassist.compiler.ast.Keyword;
import polytech.sgbd.blog.model.Message;

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
		TypedQuery<Message> query = em.createQuery(sql, Message.class);
		List<Message> results = query.getResultList();
		return results;
	}

	public List<Message> selectByUserId(int userId) {
		/*
		String sql = "select message from Message message where message.user.id = :userId";
		Query query = em.createQuery(sql);
		query.setParameter("userId", userId);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
		*/
		String sql = "select message from Message message where message.user.id = :userId";
		TypedQuery<Message> query = em.createQuery(sql, Message.class);
		query.setParameter("userId", userId);
		List<Message> results = query.getResultList();
		return results;
	}
	
	public List<Message> selectByUsername(String username) {
		String sql = "select message from Message message where message.user.username = :username";
		TypedQuery<Message> query = em.createQuery(sql, Message.class);
		query.setParameter("username", username);
		List<Message> results = query.getResultList();
		return results;
	} 

	public List<Message> selectByDate(Date date) {
		/*
		String sql = "select message from Message message where message.date = :date";
		Query query = em.createQuery(sql);
		query.setParameter("date", date);
		List<Message> messages = new ArrayList<Message>();
		messages.addAll(query.getResultList());

		return messages;
		*/
		String sql = "select message from Message message where message.date = :date";
		TypedQuery<Message> query = em.createQuery(sql, Message.class);
		query.setParameter("date", date);
		List<Message> results = query.getResultList();
		return results;
	}

	public List<Message> selectByKeyword(Keyword keyword) {
		String sql = "select message from Message message where message.keyword = :keyword";
		TypedQuery<Message> query = em.createQuery(sql, Message.class);
		query.setParameter("keyword", keyword);
		List<Message> results = query.getResultList();
		return results;
	}

	public Message selectById(int id) {
		return em.find(Message.class, id);
	}

	public void deleteById(int id) {
		Message message = em.find(Message.class, 1);

		em.getTransaction().begin();
		em.remove(message);
		em.getTransaction().commit();
	}

	public void modifyById(int id, String newText) {
		Message message = em.find(Message.class, 1);

		em.getTransaction().begin();
		message.setText(newText);
		em.getTransaction().commit();
	}
}
