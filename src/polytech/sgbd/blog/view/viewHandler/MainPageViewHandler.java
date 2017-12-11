package polytech.sgbd.blog.view.viewHandler;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;

public class MainPageViewHandler {
	@FXML
	private ListView list;
	@FXML
	private Button add;

	public void onAddClicked() {
		BorderPane pane = new BorderPane();

		ObservableList<String> strList = FXCollections.observableArrayList("红色", "黄色", "绿色", "绿色", "绿色", "绿色", "绿色",
				"绿色", "绿色");
		list.setFixedCellSize(100);
		list.setItems(strList);
		list.refresh();
	}

}
