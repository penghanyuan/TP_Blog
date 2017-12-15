package polytech.sgbd.blog.view;

import java.io.IOException;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

public class LoginView extends Application {
	private static Stage stage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setScene(this.getScene());
		primaryStage.setTitle("Login");
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });

	}

	public Scene getScene() {

		Parent root = null;
		Scene scene = null;
		try {
			root = FXMLLoader.load(this.getClass().getClassLoader().getResource("login.fxml"));
			scene = new Scene(root);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}

	public void run(String[] args) {
		launch(args);
	}

	public static Stage getStage() {
		return stage;
	}

}