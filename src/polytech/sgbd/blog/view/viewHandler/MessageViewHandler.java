package polytech.sgbd.blog.view.viewHandler;

import java.io.File;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.KeyWord;
import polytech.sgbd.blog.model.Message;

public class MessageViewHandler {
	private boolean lImage = false;
	private boolean rImage = false;
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
	private Button save;
	@FXML
	private Button edit;
	@FXML
	private Button delete;
	@FXML
	private Button addimages;
	@FXML
	private ImageView image1;
	@FXML
	private ImageView image2;
	@FXML
	private Button delete1;
	@FXML
	private Button delete2;

	private String path1;
	private String path2;

	private MessageController messageController = SessionController.getMessageController();

	private Message msg;

	@FXML
	protected void initialize() {
		System.out.println("now" + SessionController.getOpenMessageId());
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
			for (KeyWord k : msg.getKeyWords()) {
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

	public void onEditClicked() {
		title.setEditable(true);
		link1.setEditable(true);
		link2.setEditable(true);
		linktext1.setEditable(true);
		linktext2.setEditable(true);
		keywords.setEditable(true);
		message.setEditable(true);
		save.setVisible(true);
		addimages.setVisible(true);
		delete1.setVisible(true);
		delete2.setVisible(true);
	}

	public void onAddImagesClicked() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Select images");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"), new FileChooser.ExtensionFilter("GIF", "*.gif"),
				new FileChooser.ExtensionFilter("BMP", "*.bmp"), new FileChooser.ExtensionFilter("PNG", "*.png"));
		File file = fileChooser.showOpenDialog(stage);

		if (!lImage) {
			try {
				path1 = file.toURI().toURL().toString();
				image1.setImage(new Image(path1));
				delete1.setVisible(true);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lImage = true;
		} else if (!rImage) {
			try {
				path2 = file.toURI().toURL().toString();
				image2.setImage(new Image(path2));
				delete2.setVisible(true);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rImage = true;
			addimages.setDisable(true);
		}
	}

	public void onSaveClicked() {
		title.setEditable(false);
		keywords.setEditable(false);
		link1.setEditable(false);
		link2.setEditable(false);
		linktext1.setEditable(false);
		linktext2.setEditable(false);
		message.setEditable(false);
		save.setVisible(false);
		delete1.setVisible(false);
		delete2.setVisible(false);
		delete.setDisable(true);
		edit.setDisable(true);

		List<String> linkAddress = new ArrayList<String>();
		List<String> linkTexts = new ArrayList<String>();
		List<String> keywordTexts = new ArrayList<String>();

		linkAddress.add(link1.getText());
		linkAddress.add(link2.getText());
		linkTexts.add(linktext1.getText());
		linkTexts.add(linktext2.getText());
		String[] keys = keywords.getText().split(",");
		for (int i = 0; i < keys.length; i++) {
			keywordTexts.add(keys[i]);
		}
		messageController.insert(message.getText(), title.getText(), SessionController.getActuelUserId(), new Date(),
				path1, path2, linkAddress, linkTexts, keywordTexts);
		save.setDisable(true);
		addimages.setDisable(true);
		// this.stage.close();
	}

	public void onDeleteClicked() {
		messageController.deleteById(SessionController.getOpenMessageId());
	}

	public void onDel1Clicked() {
		image1.setImage(null);
		lImage = false;
		addimages.setDisable(false);

	}

	public void onDel2Clicked() {
		image2.setImage(null);
		rImage = false;
		addimages.setDisable(false);
	}

}
