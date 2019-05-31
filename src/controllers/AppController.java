package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import models.EMRMode;
import models.EMRModeConnexion;
import models.EMRModeDessin;
import models.EMRShapeFactory;

public class AppController {

	EMRMode mode;

	@FXML
	public Circle emrCircle;
	@FXML
	public Ellipse emrEllipse;
	@FXML
	public Rectangle emrSquare;
	@FXML
	public Label statusBar;
	@FXML
	public BorderPane  emrPane;

	@FXML
	public void openMenuClicked(ActionEvent a) {
		System.out.println("Menu File-Open clicked");
		statusBar.setText("Menu File-Open clicked");
	}

	@FXML
	public void saveMenuClicked(ActionEvent e) {
		System.out.println("Menu File-save clicked");
		statusBar.setText("Menu File-save clicked");
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
	}

	@FXML
	public void connexionModeClicked(ActionEvent e) {
		System.out.println("Mode Connexion clicked");
		statusBar.setText("Mode Connexion clicked");
		mode = new EMRModeConnexion();
	}

	@FXML
	public void dessinModeClicked(ActionEvent e) {
		System.out.println("Mode Dessin clicked");
		statusBar.setText("Mode Dessin clicked");
		mode = new EMRModeDessin();
	}
	@FXML
	public void circleMouseDrag(MouseEvent e) {
		emrPane.getChildren().add(EMRShapeFactory.createCircle(e.getSceneX(), e.getSceneY()));
	}
	@FXML
	public void rectMouseDrag(MouseEvent e) {
		emrPane.getChildren().add(EMRShapeFactory.createRect(e.getSceneX(), e.getSceneY()));
	}
	@FXML
	public void ellipseMouseDrag(MouseEvent e) {
		emrPane.getChildren().add(EMRShapeFactory.createEllipse(e.getSceneX(), e.getSceneY()));
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
 * 
 * 
 * }
 */
