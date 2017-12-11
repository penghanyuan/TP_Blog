package polytech.sgbd.blog.view.viewHandler;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import polytech.sgbd.blog.view.LoginView;

public class SignupViewHandler {

	@FXML
	private TextField username;
	@FXML
	private TextField firstname;
	@FXML
	private TextField lastname;
	@FXML
	private TextField email;
	@FXML
	private PasswordField psd;
	@FXML
	private PasswordField cpsd;
	@FXML
	private Label info;

	public void onSignupClicked() {
		if (username.getText().isEmpty() || firstname.getText().isEmpty() || lastname.getText().isEmpty()
				|| email.getText().isEmpty() || psd.getText().isEmpty() || cpsd.getText().isEmpty()) {
			info.setText("All fields should be completed!");
			info.setVisible(true);
		} else if (!psd.getText().equals(cpsd.getText())) {
			info.setText("Two passwords are different\n please check!");
			info.setVisible(true);
		} else {

		}
	}

	public void onBackClicked() {
		LoginView lv = new LoginView();
		LoginView.getStage().setScene(lv.getScene());
	}
}
