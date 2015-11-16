package visual;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.Survey;

public class Runner extends Application {
	Survey survey = new Survey();

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Tinvey");
		BorderPane pane = new BorderPane();
		//VBox vbox = new VBox();
		ToolBar toolBar = new ToolBar(new Button("Import Survey"), new Button("Take a Survey"), new Button("View Survey"));
		toolBar.setOrientation(Orientation.VERTICAL);
		toolBar.getStyleClass().add("hbox");
		toolBar.setId("hbox-custom");
		/*	vbox.getStyleClass().add("hbox");
		vbox.setMaxHeight(10);
		vbox.setId("hbox-custom");*/
		Button buttonCurrent = new Button("Import Survey");
		buttonCurrent.setPrefSize(200, 20);
		buttonCurrent.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					survey.selectCSV(primaryStage);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
		;

		Button buttonProjected = new Button("Projected");
		buttonProjected.setPrefSize(100, 20);

		//vbox.getChildren().addAll(buttonCurrent, buttonProjected);
		pane.setCenter(toolBar);
		
		Scene scene = new Scene(pane, 800, 600);
		scene.getStylesheets().clear();
		scene.getStylesheets()
				.add("file:///C:/Users/matthew/Desktop/Folders/CS201/CS202/Tinvey/visual/test.css");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
