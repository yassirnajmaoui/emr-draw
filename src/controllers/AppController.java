package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import models.EMRMode;
import models.EMRModeConnexion;
import models.EMRModeDessin;
import models.EMRShape;
import models.EMRShapeFactory;
import models.EMRShapeFactory.eShape;
import models.FileStrategy;
import models.TXTStrategy;
import models.XMLStrategy;
import models.iterator.ShapeContainer;

public class AppController {

	static EMRMode mode;
	public FileStrategy myStrategy;
	public ShapeContainer emrShapes;

	public static EMRMode getMode() {
		if (mode == null)
			mode = new EMRModeDessin();
		return mode;
	}

	@FXML
	public Ellipse emrEllipse; // Shape #6
	@FXML
	public Polygon emrParallelogramme1; // Shape #8
	@FXML
	public Polygon emrParallelogramme2; // Shape #10
	@FXML
	public Polygon emrHexagon; // Shape #11
	@FXML
	public Circle emrCircle; // Shape #13
	@FXML
	public Rectangle emrSquare; // Shape #14
	@FXML
	public Polygon emrParallelogrammeDiago;
	@FXML
	public Label statusBar;
	@FXML
	public Button connexionBtn;
	@FXML
	public Button dessinBtn;
	@FXML
	public Pane emrPane;
	@FXML
	public GridPane gridPalette;

	public AppController() {
		emrShapes = new ShapeContainer();
	}

	public void addNode(EMRShape n) {
		emrShapes.addShape(n);
	}

	@FXML
	public void circleMouseRelease(MouseEvent e) {
		addNode(new EMRShape(EMRShapeFactory.CIRCLE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void rectMouseRelease(MouseEvent e) {
		addNode(new EMRShape(EMRShapeFactory.SQUARE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void ellipseMouseRelease(MouseEvent e) {
		addNode(new EMRShape(EMRShapeFactory.ELLIPSE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void hexagonMouseRelease(MouseEvent e) {
		addNode(new EMRShape(EMRShapeFactory.HEXAGON_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void connexionModeClicked(ActionEvent e) {
		System.out.println("Mode Connexion clicked: Des connexions peuvent désormais être établies");
		statusBar.setText("Mode Connexion clicked: Des connexions peuvent désormais être établies");
		connexionBtn.setStyle("-fx-border-color: #0000ff; -fx-border-width: 1px" );
		dessinBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 0px");
		gridPalette.setDisable(true);
		mode = new EMRModeConnexion(); 
	}

	@FXML
	public void dessinModeClicked(ActionEvent e) {
		System.out.println("Mode Dessin clicked: Des formes peuvent désormais être drag & dropped dans le canevas");
		statusBar.setText("Mode Dessin clicked: Des formes peuvent désormais être drag & dropped dans le canevas");
		connexionBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 0px");
		dessinBtn.setStyle("-fx-border-color: #0000ff; -fx-border-width: 1px");
		gridPalette.setDisable(false);
		mode = new EMRModeDessin();
	}

	@FXML
	public void openMenuXMLClicked(ActionEvent a) {
		System.out.println("Menu File-OpenXML clicked");
		statusBar.setText("Menu File-OpenXML clicked");
	}

	@FXML
	public void openMenuTXTClicked(ActionEvent a) {
		System.out.println("Menu File-OpenTXT clicked");
		statusBar.setText("Menu File-OpenTXT clicked");

		this.emrShapes.clearShapes();
		emrPane.getChildren().clear();
		myStrategy = new TXTStrategy();
		myStrategy.openFile("myTXTFile.txt", this.emrShapes, this);
	}

	@FXML
	public void saveMenuXMLClicked(ActionEvent e) {
		System.out.println("Menu File-save clicked");
		statusBar.setText("Menu File-save clicked");
		myStrategy = new XMLStrategy();
		myStrategy.saveFile("myXMLFile.xml", emrShapes);
	}

	@FXML
	public void saveMenuTXTClicked(ActionEvent e) {
		System.out.println("Menu File-save clicked");
		statusBar.setText("Menu File-save clicked");
		myStrategy = new TXTStrategy();
		myStrategy.saveFile("myTXTFile.txt", emrShapes);
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
 * areaTxtField.setText("wroooong"); } }
 */

/*
 * code temporaire à deleter quand on est sûr que c'est ok d'instancier les
 * formes de la palette dans le fxml public class Hexagon {
 * 
 * public Hexagon(){;}
 * 
 * public Polygon createHexagon() { Polygon hexagon = new Polygon();
 * hexagon.getPoints().addAll(new Double[]{
 * 
 * 12.0, 0.0, 32.0, 0.0, 44.0, 20.0, 32.0, 40.0, 12.0, 40.0, 0.0, 20.0
 * 
 * }); return hexagon; } }
 */