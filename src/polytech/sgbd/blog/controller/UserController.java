package polytech.sgbd.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import polytech.sgbd.blog.model.User;
import polytech.sgbd.blog.model.Message;
import polytech.sgbd.blog.dao.UserDAO;;

public class UserController {
	private EntityManager em;
	UserDAO userDAO;

	public UserController(EntityManager em) {
		this.em = em;
		this.userDAO = new UserDAO(em);
	}

	public void insert(String userName, String firstName, String lastName, String password, Date createdDate,
			String address) {
		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setAddress(address);
		user.setCreatedDate(createdDate);
		userDAO.insert(user);
	}

	public boolean verifyUserPsd(String username, String psd) {
		User user = this.getUserByUsername(username);
		if (user != null && user.getPassword().equals(psd)) {
			SessionController.setActuelUserId(user.getId());
			System.out.println(SessionController.getActuelUserId());
			return true;

		} else {
			return false;
		}
	}

	public User getUserByUsername(String userName) {
		return userDAO.selectByUsername(userName);
	}
	
	public User getUserById(int id) {
		return userDAO.selectById(id);
	}

	public List<User> getAll() {
		return userDAO.selectAll();
	}
}
