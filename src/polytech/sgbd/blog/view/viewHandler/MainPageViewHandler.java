package polytech.sgbd.blog.view.viewHandler;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import polytech.sgbd.blog.controller.MessageController;
import polytech.sgbd.blog.controller.SessionController;
import polytech.sgbd.blog.model.Message;
import polytech.sgbd.blog.view.AddMessageView;
import polytech.sgbd.blog.view.LoginView;
import polytech.sgbd.blog.view.MessageView;
import polytech.sgbd.blog.view.SearchMessageView;

public class MainPageViewHandler {

	@FXML
	private ListView<Message> list;
	@FXML
	private Button add;
	@FXML
	private Button search1;
	@FXML
	private Button search2;
	@FXML
	private Button search3;
	@FXML
	private TextField username;
	@FXML
	private DatePicker date;
	@FXML
	private TextField keyword;
	@FXML
	private ListView<Message> searchresult;

	private List<Message> messageList;

	private MessageController messageController = SessionController.getMessageController();

	private void refreshList() {
		messageList = messageController.getByUserId(SessionController.getActuelUserId());
		ObservableList<Message> msgList = FXCollections.observableArrayList(messageList);
		// list.setFixedCellSize(100);
		ObservableList<Message> strList = FXCollections.observableArrayList(messageController.getAll());
		searchresult.setItems(strList);
		list.setItems(msgList);
		list.refresh();
		searchresult.refresh();
	}

	@FXML
	protected void initialize() {
		this.refreshList();
		list.minHeight(100);
		list.autosize();
		searchresult.minHeight(100);
		searchresult.autosize();
		date.setValue(LocalDate.now());
		list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Message>() {
			public void changed(ObservableValue<? extends Message> observable, Message oldValue, Message newValue) {
				MessageView msgView = new MessageView();
				if (observable.getValue() != null) {
					SessionController.setOpenMessageId(observable.getValue().getId());
					Stage stage = msgView.showMessage();
					list.setDisable(true);
					stage.setOnCloseRequest(event -> {
						list.getSelectionModel().clearSelection();
						list.setDisable(false);
						SessionController.setOpenMessageId(0);
						refreshList();
					});
				}
			}
		});
		searchresult.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Message>() {
			public void changed(ObservableValue<? extends Message> observable, Message oldValue, Message newValue) {
				SearchMessageView msgView = new SearchMessageView();
				if (observable.getValue() != null) {
					SessionController.setOpenMessageId(observable.getValue().getId());
					Stage stage = msgView.showMessage();
					searchresult.setDisable(true);
					stage.setOnCloseRequest(event -> {
						searchresult.getSelectionModel().clearSelection();
						searchresult.setDisable(false);
						SessionController.setOpenMessageId(0);
						refreshList();
					});
				}
			}
		});
	}

	public void onAddClicked() {
		AddMessageView addMsgView = new AddMessageView();
		Stage stage = addMsgView.showMessage();
		add.setDisable(true);
		stage.setOnCloseRequest(event -> {
			add.setDisable(false);
			refreshList();
		});

	}

	public void onSearch1Clicked() {
		ObservableList<Message> strList = FXCollections
				.observableArrayList(messageController.getByUsername(username.getText()));
		searchresult.setItems(strList);
		searchresult.refresh();
		
	}

	public void onSearch2Clicked() {
	
		
		ObservableList<Message> strList = FXCollections
				.observableArrayList(messageController.getByDate(date.getValue().toString()));
		searchresult.setItems(strList);
		searchresult.refresh();
	}

	public void onSearch3Clicked() {
		ObservableList<Message> strList = FXCollections
				.observableArrayList(messageController.getByKeyword(keyword.getText()));
		searchresult.setItems(strList);
		searchresult.refresh();
	}

	public void onRefreshClicked() {
		this.refreshList();
		SessionController.setOpenMessageId(0);
	}

	public void onLogoutClicked() {
		SessionController.setActuelUserId(0);
		SessionController.setOpenMessageId(0);
		LoginView lv = new LoginView();
		System.out.println("logout");
		//LoginView.getStage().setTitle("Login");
		LoginView.getStage().setScene(lv.getScene());
		
	}

}
