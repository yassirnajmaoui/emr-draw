package controllers;

import java.awt.Color;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import models.EMRMode;
import models.EMRModeConnexion;
import models.EMRModeDessin;
import models.EMRShape;
import models.EMRShapeFactory;
import models.iterator.ShapeContainer;

public class AppController {
	
	static EMRMode mode;
	public ShapeContainer emrShapes;
	public static EMRMode getMode()
	{
		if(mode == null) mode = new EMRModeDessin();
		return mode;
	}

	@FXML
	public Circle emrCircle;
	@FXML
	public Ellipse emrEllipse;
	@FXML
	public Rectangle emrSquare;
	@FXML
	public Polygon emrHexagon;
	@FXML
	public Label statusBar;
	@FXML
	public Button connexionBtn;
	@FXML
	public Button dessinBtn;
	@FXML
	public BorderPane emrPane;
	@FXML
	public VBox vboxPalette;

	
	public AppController()
	{
		emrShapes = new ShapeContainer();
	}
	
	public void addNode(Shape n)
	{
		emrPane.getChildren().add(n);
		EMRShape tmpEmrShape = new EMRShape(n);
		emrShapes.addShape(tmpEmrShape);
		//System.out.println(emrShapes);
	}
	
	@FXML
	public void circleMouseRelease(MouseEvent e) {
		addNode(EMRShapeFactory.createCircle(e.getSceneX(), e.getSceneY(),this));
	}
	@FXML
	public void rectMouseRelease(MouseEvent e) {
		addNode(EMRShapeFactory.createRect(e.getSceneX(), e.getSceneY(),this));
	}
	@FXML
	public void ellipseMouseRelease(MouseEvent e) {
		addNode(EMRShapeFactory.createEllipse(e.getSceneX(), e.getSceneY(),this));
	}
	@FXML
	public void hexagonMouseRelease(MouseEvent e) {
		addNode(EMRShapeFactory.createHexagon(e.getSceneX(), e.getSceneY(),this));
	}
	
	@FXML
	public void connexionModeClicked(ActionEvent e) {
		System.out.println("Mode Connexion clicked");
		statusBar.setText("Mode Connexion clicked");
		connexionBtn.setStyle("-fx-background-color:white");
		dessinBtn.setStyle("-fx-background-color:gray");
		vboxPalette.setDisable(true);
		mode = new EMRModeConnexion();
	}

	@FXML
	public void dessinModeClicked(ActionEvent e) {
		System.out.println("Mode Dessin clicked");
		statusBar.setText("Mode Dessin clicked");
		dessinBtn.setStyle("-fx-background-color:white");
		connexionBtn.setStyle("-fx-background-color:gray");
		vboxPalette.setDisable(false);
		mode = new EMRModeDessin();
	}
	
	@FXML
	public void openMenuClicked(ActionEvent a) {
		System.out.println("Menu File-Open clicked");
		statusBar.setText("Menu File-Open clicked");
		// TODO: open text files
		emrShapes.importXML("myFile.xml");
	}
	
	@FXML
	public void saveMenuClicked(ActionEvent e) {
		System.out.println("Menu File-save clicked");
		statusBar.setText("Menu File-save clicked");
		emrShapes.saveToXML("myFile.xml");
		//emrShapes.saveToFile("myFile.txt");
	}

	@FXML
	public void quitMenuClicked(ActionEvent a) {
		System.out.println("Menu File-quit clicked");
		statusBar.setText("Menu File-quit clicked");
	}

	@FXML
	public void undoMenuClicked(ActionEvent a) {
		System.out.println("Menu Edit-undo clicked");
		statusBar.setText("Menu Edit-undo clicked");
	}

	@FXML
	public void redoMenuClicked(ActionEvent e) {
		System.out.println("Menu Edit-redo clicked");
		statusBar.setText("Menu Edit-redo clicked");
	}

	@FXML
	public void aboutMenuClicked(ActionEvent e) {
		System.out.println("Menu Help-About clicked");
		statusBar.setText("Menu Help-About clicked");
		System.out.println(emrShapes.toString()); // Temporaire
	}
}

/*
 * @FXML public void btnCircleClicked(ActionEvent a){ //to do: add
 * numberFormatException //System.out.println("Button Circle clicked"); try {
 * int width = Integer.parseInt(widthTxtField.getText()); int height = 0;
 * ShapeFactory shapeFactory = new ShapeFactory(); Shape circle =
 * shapeFactory.makeShape(eShape.CIRCLE, width, height);
 * areaTxtField.setText(String.valueOf(circle.getArea())); } catch
 * (NumberFormatException e) { System.out.println(e.getMessage());
 * areaTxtField.setText("wroooong"); }
 * }
 */

/* code temporaire à deleter quand on est sûr que c'est ok d'instancier les formes de la palette dans le fxml
public class Hexagon {
	
	public Hexagon(){;}
	
	public Polygon createHexagon() {
	    Polygon hexagon = new Polygon();
	    hexagon.getPoints().addAll(new Double[]{        

		    12.0, 0.0,
		    32.0, 0.0,
		    44.0, 20.0,
		    32.0, 40.0,
		    12.0, 40.0,
		    0.0, 20.0

	    		});
	    return hexagon;
	}
}
*/