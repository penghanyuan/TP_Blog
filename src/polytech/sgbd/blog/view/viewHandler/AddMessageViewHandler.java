package polytech.sgbd.blog.view.viewHandler;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AddMessageViewHandler {
	private int numImages;
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
		System.out.println(file.getAbsolutePath());
		if (numImages == 0) {
			image1.setImage(new Image("/Users/penghanyuan/Pictures/119_4444_d59d3e597931c8e.jpg"));
			numImages++;
		} else if (numImages == 1) {
			image2.setImage(new Image(file.getAbsolutePath()));
			numImages++;
			addimages.setDisable(true);
		}
	}

	public void onSaveClicked() {

	}
}
