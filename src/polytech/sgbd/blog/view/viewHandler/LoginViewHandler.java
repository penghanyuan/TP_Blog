package polytech.sgbd.blog.view.viewHandler;

import java.io.IOException;

import com.sun.javafx.robot.impl.FXRobotHelper;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.controller.UserController;
import polytech.sgbd.blog.view.LoginView;
import polytech.sgbd.blog.view.MainPageView;
import polytech.sgbd.blog.view.SignupView;

public class LoginViewHandler {

	@FXML
	private TextField username;
	@FXML
	private PasswordField password;
	@FXML
	private Label error;

	private UserController userController = SessionController.getUserController();

	public void onLoginClicked() {
		if (userController.verifyUserPsd(username.getText(), password.getText())) {
			MainPageView main = new MainPageView();
			LoginView.getStage().setScene(main.getScene());
			error.setVisible(false);
		} else {
			error.setVisible(true);
		}

	}

	public void onSignupClicked() throws IOException {
		SignupView sv = new SignupView();
		LoginView.getStage().setScene(sv.getScene());
	}

}
