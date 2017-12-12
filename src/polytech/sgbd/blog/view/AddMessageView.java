package polytech.sgbd.blog.view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import polytech.sgbd.blog.view.viewHandler.AddMessageViewHandler;

public class AddMessageView {
	private Parent root = null;
	private Stage stage;
	public Scene getScene() {
		Scene scene = null;
		try {
			FXMLLoader loader = new FXMLLoader(this.getClass().getClassLoader().getResource("add.fxml"));
			root = loader.load();
			scene = new Scene(root);
			AddMessageViewHandler controller = (AddMessageViewHandler)loader.getController();
			controller.setStage(stage); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}
	
	public Stage showMessage() {
		stage = new Stage();
		stage.initStyle(StageStyle.DECORATED);
		stage.setScene(this.getScene());
		stage.setTitle("Add new message");
		stage.show();
		return stage;
	}
}
