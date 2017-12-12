package polytech.sgbd.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import javassist.compiler.ast.Keyword;
import polytech.sgbd.blog.dao.MessageDAO;
import polytech.sgbd.blog.model.*;

public class MessageController {
	private EntityManager em;
	private MessageDAO messageDAO;

	public MessageController(EntityManager em) {
		this.em = em;
		this.messageDAO = new MessageDAO(em);
	}

	public void insert(String title, String text, Date date, User user, List<Image> images, List<Link> links,
			List<KeyWord> keywords) {
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

	public void insert(String messageText, String messageTitle, int userId, Date date, String imagePath1,
			String imagePath2, List<String> linkAddress, List<String> linkTexts, List<String> keywordTexts) {

		/* Links */
		List<Link> links = new ArrayList<Link>();
		for (int i = 0; i < linkAddress.size(); i++) {
			Link link = new Link();
			link.setAddress(linkAddress.get(i));
			link.setText(linkTexts.get(i));
			links.add(link);
		}
		/* Images */
		List<Image> images = new ArrayList<Image>();
		Image image1 = new Image();
		Image image2 = new Image();
		image1.setPath(imagePath1);
		image2.setPath(imagePath2);
		images.add(image1);
		images.add(image2);
		/* Keywords */
		List<KeyWord> keywords = new ArrayList<KeyWord>();
		for (String k : keywordTexts) {
			KeyWord keyword = new KeyWord();
			keyword.setText(k);
			keywords.add(keyword);
		}

		Message message = new Message();
		message.setTitle(messageTitle);
		message.setText(messageText);
		message.setDate(date);
		message.setImages(images);
		message.setLinks(links);
		message.setKeyWords(keywords);

		User user = SessionController.getUserController().getUserById(userId);
		message.setUser(user);

		messageDAO.insert(message);
	}

	public List<Message> getAll() {
		return messageDAO.selectAll();
	}

	public List<Message> getByUserId(int userId) {
		return messageDAO.selectByUserId(userId);
	}

	public List<Message> getByDate(Date date) {
		return messageDAO.selectByDate(date);
	}

	public Message getById(int id) {
		return messageDAO.selectById(id);
	}

	public List<Message> getByKeyword(Keyword keyword) {
		return messageDAO.selectByKeyword(keyword);
	}

	public void deleteById(int id) {
		messageDAO.deleteById(id);
	}

	public void modifyById(int id, String newText) {
		messageDAO.modifyById(id, newText);
	}
}
