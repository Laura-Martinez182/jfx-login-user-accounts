package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Classroom;

public class Main extends Application{

	private ClassroomGUI classroomGUI;
	private Classroom classroom;
	
	public static void main(String[] args) {
		launch(args);
		
	}
	
	
	public Main () {
		
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		classroom = new Classroom();
		classroomGUI = new ClassroomGUI(classroom);
		
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		
		fxmlLoader.setController(classroomGUI);
		Parent root = fxmlLoader.load();
		classroomGUI.loadLogin();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Classroom");
		primaryStage.show();
	}

}
	
