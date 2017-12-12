package polytech.sgbd.blog.view;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MessageView {
	private Parent root = null;
	public Scene getScene() {

		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getClassLoader().getResource("message.fxml"));
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
