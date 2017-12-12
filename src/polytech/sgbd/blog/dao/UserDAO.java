package polytech.sgbd.blog.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import polytech.sgbd.blog.model.Message;
import polytech.sgbd.blog.model.User;

public class UserDAO {
	private EntityManager em;
	
	public UserDAO(EntityManager em){
		this.em = em;
	}
	
	public void insert(User user){
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
	}
	
	public List<User> selectAll(){
		String sql = "select user from User user";
		Query query = em.createQuery(sql);
		List <User> users = new ArrayList<User>();
	
		users.addAll(query.getResultList());

		return users;
	}
	
	public User selectUserByUsername(String userName){
		String sql = "select user from User user where user.userName = :userName";
		Query query = em.createQuery(sql);
		query.setParameter("userName", userName);
		User user = null;
		try{
			user = (User) query.getSingleResult();
		} catch (NoResultException e){
			user = null;
		}
		
		return user;
	}
}
