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

		MessageController messageController = SessionController.getMessageController();
		
		/* Initial Data */
		// User1
		User usr1 = new User();
		usr1.setUserName("penghanyuan");
		usr1.setPassword("123");
		usr1.setFirstName("Hanyuan");
		usr1.setLastName("Peng");
		usr1.setEmail("penghanyuan@gmail.com");
		usr1.setCreatedDate(new Date());
		usr1.setAddress("Grandmont");

		Date date = new Date();
		
		DateFormat df= new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		try {
			date = df.parse(df.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(date.toString());

		Image img1_1 = new Image();
		Image img1_2 = new Image();
		Link link1_1 = new Link();
		Link link1_2 = new Link();
		KeyWord keyword1_1 = new KeyWord();
		KeyWord keyword1_2 = new KeyWord();
		KeyWord keyword1_3 = new KeyWord();

		img1_1.setPath("path img01");
		img1_2.setPath("path img02");
		link1_1.setText("link text01");
		link1_2.setText("link text02");
		link1_1.setAddress("link addr01");
		link1_2.setAddress("link addr02");
		keyword1_1.setText("hello");
		keyword1_2.setText("greeting");
		keyword1_3.setText("tired");

	


		List<Image> images = new ArrayList<Image>();
		List<Link> links = new ArrayList<Link>();
		List<KeyWord> keywords1_1 = new ArrayList<KeyWord>();
		List<KeyWord> keywords1_2 = new ArrayList<KeyWord>();

		images.add(img1_1);
		images.add(img1_2);
		links.add(link1_1);
		links.add(link1_2);
		keywords1_1.add(keyword1_1);
		keywords1_1.add(keyword1_2);
		keywords1_2.add(keyword1_3);

		messageController.insert("Hello", "Hello ! I'm Hanyuan Peng !", date, usr1, null, null, keywords1_1);
		messageController.insert("Tired", "I'm tired ! I have a lot of work !", date, usr1, images, links, keywords1_2);

		// User2
		User usr2 = new User();
		usr2.setUserName("wangtianxue");
		usr2.setPassword("123");
		usr1.setFirstName("Tianxue");
		usr1.setLastName("Wang");
		usr1.setEmail("wangtianxue@gmail.com");
		usr1.setCreatedDate(new Date());
		usr1.setAddress("Alouette");

		KeyWord keyword2_1 = new KeyWord();
		KeyWord keyword2_2 = new KeyWord();
		KeyWord keyword2_3 = new KeyWord();

		keyword2_1.setText("blog");
		keyword2_2.setText("cute");
		keyword2_3.setText("dog");

		List<KeyWord> keywords2_1 = new ArrayList<KeyWord>();
		List<KeyWord> keywords2_2 = new ArrayList<KeyWord>();
		
		keywords2_1.add(keyword2_1);
		keywords2_1.add(keyword2_2);
		keywords2_2.add(keyword2_3);

		messageController.insert("My Blog", "This is my blog !", date, usr2, null, null, keywords2_1);
		messageController.insert("A cute dog", "I've seen a cute dog today.", date, usr2, null, null, keywords2_2);
		messageController.insert("Not title", "I don't want to say anything.", date, usr2, null, null, null);

		/*View*/
		LoginView loginView = new LoginView();
		loginView.run(args);
		// for(Message message : messageController.getAll()){
		// System.out.println(message.getText().toString());
		// }
		//
		// for(User user : userController.getAll()){
		// System.out.println(user.getUserName().toString());
		// }
	}

}
