package polytech.sgbd.blog.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionController {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_blog");
	private static EntityManager em = emf.createEntityManager();
	private static UserController userController = new UserController(em);
	private static MessageController messageController = new MessageController(em);
	private static KeywordController keywordController = new KeywordController(em);

	private static int actuelUserId;
	
	private static int openMessageId;

	public static EntityManager getEm() {
		return em;
	}

	public static int getActuelUserId() {
		return actuelUserId;
	}

	public static void setActuelUserId(int actuelUserId) {
		SessionController.actuelUserId = actuelUserId;
	}

	public static UserController getUserController() {
		return userController;
	}

	public static MessageController getMessageController() {
		return messageController;
	}

	public static KeywordController getKeywordController() {
		return keywordController;
	}

	public static int getOpenMessageId() {
		return openMessageId;
	}

	public static void setOpenMessageId(int openMessageId) {
		SessionController.openMessageId = openMessageId;
	}

}
