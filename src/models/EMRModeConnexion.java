package models;

import controllers.AppController;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class EMRModeConnexion implements EMRMode {

	private Line currentLine;
	private EMRShape currentShape;

	@Override
	public void handleDragOn(MouseEvent t, AppController a) {
	}

	@Override
	public void handleDragWhile(MouseEvent t, AppController a) {

	}

	@Override
	public void handleDragOver(MouseEvent t, AppController a) {
		//System.out.println("Clicked! " + t.getSource() + "\nPrevious: " + currentShape);
		if (t.getSource() instanceof Shape && t.getSource() != null && currentShape == null) {
			currentShape = new EMRShape((Shape) t.getSource());
			currentShape.getShape().setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		} else if ((Shape) t.getSource() != null) {
			if(currentShape.getShape() != t.getSource())
			{
				// Starting to connect stuff
				a.addNode(connect(currentShape, new EMRShape((Shape) t.getSource())));
			}
			currentShape.getShape().setStyle("");
			currentShape = null;
		}
	}

	private static Line connect(EMRShape c1, EMRShape c2) {
		Line line = new Line();
		line.startXProperty().bind(c1.getXProperty());
		line.startYProperty().bind(c1.getYProperty());
		line.endXProperty().bind(c2.getXProperty());
		line.endYProperty().bind(c2.getYProperty());
		return line;
	}

	public Line getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(Line currentLine) {
		this.currentLine = currentLine;
	}

}
