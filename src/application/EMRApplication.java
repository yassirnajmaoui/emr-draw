package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.Hexagon;

public class EMRApplication extends Application {

	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().
		launch(args);
	}

	// Override the start() method.
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/views/EMR_ui.fxml"));
			Scene scene = new Scene(root,600,600);
			
			Hexagon shape1 = new Hexagon();
			Node hexagon = shape1.createHexagon();
			
			root.getChildren().add(hexagon);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("EMR Application");
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
