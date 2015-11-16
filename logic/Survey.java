package logic;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Survey extends Application{
	
	File folder = new File(
			"C:\\Users\\matthew\\Desktop\\Folders\\CS201\\CS202\\Tinvey\\resources\\Confirmed");
	File[] listOfFiles = folder.listFiles();
	File selectedFile;

	public boolean confirmResults(int confirm) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Is this correct? Y/N");
		String correct = scanner.next();
		if (correct.equals("Y")) {
			return true;
		} else {
			return false;
		}
	}

	public void ifConfirmed(boolean confirmed, File file) {
		if (confirmed) {
			Path copyFrom = Paths.get(file.getAbsolutePath());
			Path copyTo = Paths
					.get("C:\\Users\\matthew\\Desktop\\Folders\\CS201\\CS202\\Tinvey\\resources\\Confirmed");
			try {
				Files.copy(copyFrom, copyTo);
			} catch (IOException e) {
				System.err.println(e);
			}
		}

	}

	public void surveyList() {
		listOfFiles = null;
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {

				System.out.println(i
						+ 1
						+ ". "
						+ listOfFiles[i].getName().substring(
								0,
								listOfFiles[i].getName().toString()
										.indexOf('.')));
			} else if (listOfFiles[i].isDirectory()) {
				System.out.println("Directory " + listOfFiles[i].getName());
			}
		}
	}

	public File selectCSV( Stage primaryStage) throws Exception {
		selectedFile = null;
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Spread Sheets", "*.csv"));

		selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null) {
			return selectedFile.getAbsoluteFile();
		} else {
			return null;
		}
	}

	@Override
	public synchronized void start(Stage primaryStage) throws Exception {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Resource File");
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("Spread Sheets", "*.csv"));

		selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null) {
			System.out.println(selectedFile.getAbsolutePath());
		}
	}

}
