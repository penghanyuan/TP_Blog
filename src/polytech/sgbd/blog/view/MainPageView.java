package polytech.sgbd.blog.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MainPageView {

	public Scene getScene() {

		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getClassLoader().getResource("mainpage.fxml"));
			scene = new Scene(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}

}
