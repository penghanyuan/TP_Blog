package polytech.sgbd.blog.view.viewHandler;

import java.util.Date;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.Message;
import polytech.sgbd.blog.view.AddMessageView;
import polytech.sgbd.blog.view.MessageView;

public class MainPageViewHandler {

	@FXML
	private ListView<Message> list;
	@FXML
	private Button add;
	@FXML
	private Button search;
	@FXML
	private ListView<String> searchresult;

	private List<Message> messageList;

	private MessageController messageController = SessionController.getMessageController();

	@FXML
	protected void initialize() {
		messageList = messageController.getByUserId(SessionController.getActuelUserId());
		ObservableList<Message> msgList = FXCollections.observableArrayList(messageList);
		list.setFixedCellSize(100);
		list.setItems(msgList);
		list.refresh();
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Message>() {
			public void changed(ObservableValue<? extends Message> observable, Message oldValue, Message newValue) {
				MessageView msgView = new MessageView();
				SessionController.setOpenMessageId(observable.getValue().getId());
				Stage stage = msgView.showMessage();
				list.setDisable(true);
				stage.setOnCloseRequest(event -> {
					list.setDisable(false);
					list.refresh();
				});
			}
		});
	}

	public void onAddClicked() {
		AddMessageView addMsgView = new AddMessageView();
		Stage stage = addMsgView.showMessage();
		add.setDisable(true);
		stage.setOnCloseRequest(event -> {
			add.setDisable(false);
			list.refresh();
		});

	}

	public void onSearchClicked() {
		ObservableList<String> strList = FXCollections.observableArrayList("红色", "黄色", "绿色", "绿色", "绿色", "绿色", "绿色",
				"绿色", "绿色");
		searchresult.setFixedCellSize(100);
		searchresult.setItems(strList);
		list.refresh();
	}

}
