package polytech.sgbd.blog.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SearchMessageView {
	private Parent root = null;
	public Scene getScene() {

		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getClassLoader().getResource("searchmessage.fxml"));
			scene = new Scene(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}

	public Stage showMessage() {
		Stage stage = new Stage();
		stage.initStyle(StageStyle.DECORATED);
		stage.setScene(this.getScene());
		stage.setTitle("Message");
		stage.show();
		return stage;
	}
}
