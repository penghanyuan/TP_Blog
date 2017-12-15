package polytech.sgbd.blog.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

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
			List<Keyword> keywords) {
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
		List<Keyword> keywords = new ArrayList<Keyword>();
		for (String k : keywordTexts) {
			Keyword keyword = new Keyword();
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

	public List<Message> getByDate(String date) {
		return messageDAO.selectByDate(date);
	}

	public Message getById(int id) {
		return messageDAO.selectById(id);
	}

	public List<Message> getByKeyword(String keyword) {
		return messageDAO.selectByKeyword(keyword);
	}

	public void deleteById(int id) {
		messageDAO.deleteById(id);
	}
	
	public List<Message> getByUsername(String username){
		return messageDAO.selectByUsername(username);
	}

	public void modifyMessage(Message message, String newText, String newTitle, String newImagePath1, String newImagePath2,
			Date date, List<String> linkAddress, List<String> linkTexts, List<String> keywordTexts) {
		//在修改时需要注意对提取出来的对象进行修改，（或许hibernate在实现时采用了某种单例模式，
		//多次从数据库中搜索同一个id的对象时第二次会无法获取相关对象）
		/* Modify the images */
		Image image1 = message.getImages().get(0);
		image1.setPath(newImagePath1);

		Image image2 = message.getImages().get(1);
		image2.setPath(newImagePath2);

		/* Modify the links */
		for (int i = 0; i < message.getLinks().size(); i++) {
			Link link = message.getLinks().get(i);
			link.setAddress(linkAddress.get(i));
			link.setText(linkTexts.get(i));
		}

		/* Modify the keywords */
		/* Delete the old keywords*/
		for(Keyword k : message.getKeyWords()){
			SessionController.getKeywordController().delete(k);
		}
		/* Insert the new ones*/
		List<Keyword> keywordsNew = new ArrayList<Keyword>();
		for (int i = 0; i < keywordTexts.size(); i++) {
			Keyword keyword = new Keyword();
			keyword.setText(keywordTexts.get(i));
			keywordsNew.add(keyword);
		}
		
		message.setKeyWords(keywordsNew);
		message.setText(newText);
		message.setTitle(newTitle);
		message.setDate(date);

		messageDAO.modifyById(message);

	}
}
