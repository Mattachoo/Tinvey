package visual;

import javafx.application.Application;
import javafx.stage.Stage;

public class NewRunner extends Application {
Runner runner = new Runner();
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		runner.start(primaryStage);
	}
}
