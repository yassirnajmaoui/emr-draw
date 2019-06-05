package controllers;

import java.io.File;

import javax.swing.JFileChooser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import models.EMRConnexion;
import models.EMRShape;
import models.EMRShapeFactory;
import models.file.strategy.OpenStrategy;
import models.file.strategy.OpenTextStrategy;
import models.file.strategy.OpenXMLStrategy;
import models.file.strategy.SaveStrategy;
import models.file.strategy.SaveTextStrategy;
import models.file.strategy.SaveXMLStrategy;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;
import models.state.EMRMode;
import models.state.EMRModeConnexion;
import models.state.EMRModeDessin;

public class AppController {

	static EMRMode mode;
	public SaveStrategy mySaveStrategy;
	public OpenStrategy myOpenStrategy;
	public ShapeContainer emrShapes;
	public ConnexionContainer emrConnexions;

	public EMRMode getMode() {
		if (mode == null)
			mode = new EMRModeDessin();
		return mode;
	}
	
	@FXML
	public Path emrFlecheNoire; // Shape #1
	@FXML
	public Ellipse emrEllipse; // Shape #6
	@FXML
	public Path emrTrapezeDiago; // Shape #7
	@FXML
	public Polygon emrTrapeze; // Shape #8
	@FXML
	public Path emrDoubleTrapeze; // Shape #9
	@FXML
	public Polygon emrTrapezePlein; // Shape #10
	@FXML
	public Polygon emrHexagon; // Shape #11
	@FXML
	public Path emrTripleCarree; // Shape #12
	@FXML
	public Circle emrCircle; // Shape #13
	@FXML
	public Rectangle emrSquare; // Shape #14
	@FXML
	public Path emrRectangleDiago; // Shape #15
	@FXML
	public Path emrDoubleCercle; // Shape #16
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
		emrConnexions = new ConnexionContainer();
	}

	public void addShape(EMRShape n) {
		emrShapes.addShape(n);
	}
	public void addConnexion(EMRConnexion n) {
		emrConnexions.addConnexion(n);
	}

	@FXML
	public void circleMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.CIRCLE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void rectMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.SQUARE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void ellipseMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.ELLIPSE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void hexagonMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.HEXAGON_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}

	@FXML
	public void trapezeMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.TRAPEZE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	@FXML
	public void trapezeDiagoMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.TRAPEZEDIAGO_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	@FXML
	public void trapezePleinMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.TRAPEZEPLEIN_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	@FXML
	public void rectangleDiagoMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.RECTANGLEDIAGO_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	@FXML
	public void flecheNoireMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.FLECHENOIRE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	
	@FXML
	public void tripleCarreeMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.TRIPLECARREE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this)); 
	}
	
	@FXML
	public void doubleTrapezeMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.DOUBLETRAPEZE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
	
	@FXML
	public void doubleCercleMouseRelease(MouseEvent e) {
		addShape(new EMRShape(EMRShapeFactory.DOUBLECERCLE_ID, e.getSceneX() - emrPane.getLayoutX(), e.getSceneY() - emrPane.getLayoutY(),
				this));
	}
		
	@FXML
	public void connexionModeClicked(ActionEvent e) {
		System.out.println("Mode Connexion clicked: Des connexions peuvent desormais etre etablies");
		statusBar.setText("Mode Connexion clicked: Des connexions peuvent desormais etre etablies");
		connexionBtn.setStyle("-fx-border-color: #0000ff; -fx-border-width: 1px" );
		dessinBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 0px");
		gridPalette.setDisable(true);
		mode = new EMRModeConnexion();
	}

	@FXML
	public void dessinModeClicked(ActionEvent e) {
		System.out.println("Mode Dessin clicked: Des formes peuvent desormais etre drag & dropped dans le canevas");
		statusBar.setText("Mode Dessin clicked: Des formes peuvent desormais etre drag & dropped dans le canevas");
		connexionBtn.setStyle("-fx-border-color: #000000; -fx-border-width: 0px");
		dessinBtn.setStyle("-fx-border-color: #0000ff; -fx-border-width: 1px");
		gridPalette.setDisable(false);
		mode = new EMRModeDessin();
	}

	@FXML
	public void openMenuXMLClicked(ActionEvent a) {
		System.out.println("Menu File-OpenXML clicked");
		statusBar.setText("Menu File-OpenXML clicked");

		/*
		 * this.emrShapes.clearShapes(); this.emrConnexions.clearConnexions();
		 * emrPane.getChildren().clear(); myOpenStrategy = new OpenXMLStrategy();
		 * myOpenStrategy.open("src/views/myXMLFile.xml", this.emrShapes,
		 * this.emrConnexions, this);
		 */
	}

	@FXML
	public void openMenuTXTClicked(ActionEvent a) {
		System.out.println("Menu File-OpenTXT clicked");
		statusBar.setText("Menu File-OpenTXT clicked");

		this.emrShapes.clearShapes();
		this.emrConnexions.clearConnexions();
		emrPane.getChildren().clear();
		
		myOpenStrategy = new OpenTextStrategy();
		myOpenStrategy.open(this.emrShapes, this.emrConnexions, this);
	}

	@FXML
	public void saveMenuXMLClicked(ActionEvent e) {
		/*
		 * System.out.println("Menu File-save clicked");
		 * statusBar.setText("Menu File-save clicked"); mySaveStrategy = new
		 * SaveXMLStrategy(); mySaveStrategy.save("src/views/myXMLFile.xml", emrShapes,
		 * emrConnexions);
		 */	 
	}

	@FXML
	public void saveMenuTXTClicked(ActionEvent e) {
		//---------------------------------------------------
		System.out.println("Menu File-save-saveTXT clicked");
		statusBar.setText("Menu File-save-saveTXT clicked");
		//---------------------------------------------------
		mySaveStrategy = new SaveTextStrategy();
		mySaveStrategy.save(emrShapes, emrConnexions);
		//---------------------------------------------------
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
