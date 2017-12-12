package polytech.sgbd.blog.view.viewHandler;

import java.io.File;
import java.net.MalformedURLException;

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

public class AddMessageViewHandler {
	private boolean lImage = false;
	private boolean rImage = false;
	private Stage stage;
	@FXML
	private Pane pane;
	@FXML
	private TextArea message;
	@FXML
	private TextField link;
	@FXML
	private TextField linktext;
	@FXML
	private TextField keywords;
	@FXML
	private Button save;
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

	public void setStage(Stage stage) {
		this.stage = stage;
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
				image1.setImage(new Image(path1, true));
				delete1.setVisible(true);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lImage = true;
		} else if (!rImage) {
			try {
				path2 = file.toURI().toURL().toString();
				image2.setImage(new Image(path2, true));
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
		// messageController.insert();
	}

	public void onDel1Clicked() {
		image1.setImage(null);
		//numImages==;
		
	}

	public void onDel2Clicked() {

	}

}
