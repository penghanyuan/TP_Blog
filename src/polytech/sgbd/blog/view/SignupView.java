package polytech.sgbd.blog.view;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignupView {
	public Scene getScene() {

		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getClassLoader().getResource("signup.fxml"));
			scene = new Scene(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}
}
