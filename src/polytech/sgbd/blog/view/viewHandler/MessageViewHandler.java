package polytech.sgbd.blog.view.viewHandler;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.Message;

public class MessageViewHandler {
	@FXML
	private TextArea text;
	@FXML
	private Button delete;
	@FXML
	private Button save;
	@FXML
	private Button edit;

	private MessageController messageController = SessionController.getMessageController();

	private Message message;

	@FXML
	protected void initialize() {
		message = messageController.getById(SessionController.getOpenMessageId());
		text.setText(message.getText());
	}

	public void onEditClicked() {
		text.setEditable(true);
		save.setVisible(true);
	}

	public void onSaveClicked() {
		text.setEditable(false);
		save.setVisible(false);
		messageController.modifyById(SessionController.getOpenMessageId(), text.getText());
		
		
	}

	public void onDeleteClicked() {
		messageController.deleteById(SessionController.getOpenMessageId());
	}

	

}
