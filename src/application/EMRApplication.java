package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EMRApplication extends Application {

	public static void main(String[] args) {

		// Start the JavaFX application by calling launch().
		launch(args);
	} 

	// Override the start() method.
	public void start(Stage primaryStage) {
		try {
			Pane root = FXMLLoader.load(getClass().getResource("/views/EMR_ui.fxml"));
			Scene scene = new Scene(root,600,750);
					
			primaryStage.setScene(scene);
			primaryStage.setTitle("EMR Application");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
/*
 * ------------------------------------------------------------------------------------------
TODO:
	- Faire les autres formes
	- Drag & drop sur les path
	- Rapport MVC JavaFX versus MVC classique
	- Faire plusieurs projets/int�grations avec chaque prototype
	- Rapport UML
	- S'assurer que les design patterns utilis�s sont sp�cifi�s selon chaque classe
	- Remettre le projet sous forme de commit sur le git de l'�cole
	- V�rifier que l'ouverture du projet fonctionnne sur les ordis de l'�cole
* ------------------------------------------------------------------------------------------
*/
