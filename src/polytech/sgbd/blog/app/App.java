package polytech.sgbd.blog.app;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;

import polytech.sgbd.blog.model.*;
import polytech.sgbd.blog.view.LoginView;

public class App {

	public static void main(String[] args) {
		
		
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("tp_blog");
//		EntityManager em = emf.createEntityManager();
//		
//		AddressController addressController = new AddressController(em);
		MessageController messageController = SessionController.getMessageController();
//		UserController userController = new UserController(em);
//		
//		addressController.insert("China", "Beijing", "100083", "Street East", 2, "c1");
//		
		Date date = new Date();
		
	
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try {
			date = df.parse(df.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date.toString());
//		Address addr = new Address();
//		userController.insert("LydieXXX", "Tianxue", "Wang", "123", date, null);
//		
		Image img1 = new Image();
		Image img2 = new Image();
		Link link1 = new Link();
		Link link2 = new Link();
		KeyWord keyword1 = new KeyWord();
		KeyWord keyword2 = new KeyWord();
		img1.setPath("path img01");
		img2.setPath("path img02");
		link1.setText("link text01");
		link2.setText("link text02");
		link1.setAddress("link addr01");
		link2.setAddress("link addr02");
		keyword1.setText("keyword01");
		keyword2.setText("keyword02");
//		
		List<Image> images = new ArrayList<Image>();
		List<Link> links = new ArrayList<Link>();
		List<KeyWord> keywords = new ArrayList<KeyWord>();
//		
		images.add(img1);
		images.add(img2);
		links.add(link1);
		links.add(link2);
		keywords.add(keyword1);
		keywords.add(keyword2);
//		
		User usr = new User();

		usr.setUserName("penghanyuan");
		usr.setPassword("123");
		
		messageController.insert("Hello", "Hello World !", date, usr, null, null, null);
		messageController.insert("Goodbye", "Goodbye World !", date, usr, images, links, keywords);
		
		List<String> keywordsNew = new ArrayList<String>();
		keywordsNew.add("new1");
		keywordsNew.add("new2");
		keywordsNew.add("new3");
		keywordsNew.add("new4");
		
		List<String> addrNew = new ArrayList<String>();
		addrNew.add("new1");
		addrNew.add("new2");
		
		List<String> textNew = new ArrayList<String>();
		textNew.add("new1");
		textNew.add("new2");

		//messageController.modifyById(2, "OKOK", "Hey", "xxx", "yyy", null, addrNew, textNew, keywordsNew);
		LoginView loginView = new LoginView();
		loginView.run(args);
//		for(Message message : messageController.getAll()){
//			System.out.println(message.getText().toString());
//		}
//		
//		for(User user : userController.getAll()){
//			System.out.println(user.getUserName().toString());
//		}
	}

}
