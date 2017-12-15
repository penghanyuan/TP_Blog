package polytech.sgbd.blog.view.viewHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.Keyword;
import polytech.sgbd.blog.model.Message;

public class SearchMessageViewHandler {
	private Stage stage;
	@FXML
	private Pane pane;
	@FXML
	private TextArea message;
	@FXML
	private TextField title;
	@FXML
	private TextField link1;
	@FXML
	private TextField linktext1;
	@FXML
	private TextField link2;
	@FXML
	private TextField linktext2;
	@FXML
	private TextField keywords;
	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;


	private String path1;
	private String path2;

	private MessageController messageController = SessionController.getMessageController();

	private Message msg;

	@FXML
	protected void initialize() {
		msg = messageController.getById(SessionController.getOpenMessageId());
		message.setText(msg.getText());
		title.setText(msg.getTitle());
		if (msg.getLinks() != null) {
			linktext1.setText(msg.getLinks().get(0).getText());
			linktext2.setText(msg.getLinks().get(1).getText());
			link1.setText(msg.getLinks().get(0).getAddress());
			link2.setText(msg.getLinks().get(1).getAddress());
		}
		if (msg.getKeyWords() != null) {
			String kwords = "";
			for (Keyword k : msg.getKeyWords()) {
				kwords += k.getText() + ",";
			}
			kwords = kwords.substring(0, kwords.length() - 1);
			keywords.setText(kwords);
		}
		if (msg.getImages() != null) {
			try {
				image1.setImage(new Image(msg.getImages().get(0).getPath()));
			} catch (Exception e) {
				image1.setImage(null);
			}
			path1 = msg.getImages().get(0).getPath();
			try {
				image2.setImage(new Image(msg.getImages().get(1).getPath()));
			} catch (Exception e) {
				image2.setImage(null);
			}
			path2 = msg.getImages().get(1).getPath();
		}

	}

}
