package polytech.sgbd.blog.controller;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import polytech.sgbd.blog.model.User;
import polytech.sgbd.blog.model.Address;
import polytech.sgbd.blog.dao.UserDAO;;

public class UserController {
	private EntityManager em;
	UserDAO userDAO ;
	public UserController(EntityManager em){
		this.em = em;
		this.userDAO = new UserDAO(em);
	}
	
	public void insert(String userName, String firstName, String lastName,
			String password, Date createdDate, Address address){
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setAddress(address);
		user.setCreatedDate(createdDate);
		
		
		userDAO.insert(user);
	}
	
	public List<User> getAll(){
		return userDAO.selectAll();
	}
}
