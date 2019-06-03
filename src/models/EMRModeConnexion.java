package models;

import controllers.AppController;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

//--------------------------------------------------
//This class makes part of the State Design Pattern
//--------------------------------------------------
public class EMRModeConnexion implements EMRMode {

	private Line currentLine;
	private Shape currentShape;

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
			currentShape = ((Shape) t.getSource());
			currentShape.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		} else if ((Shape) t.getSource() != null) {
			if(currentShape != t.getSource())
			{
				// Starting to connect stuff
				a.addNode(new EMRShape(connect(currentShape, (Shape) t.getSource()),a));
			}
			currentShape.setStyle("");
			currentShape = null;
		}
	}

	private static Line connect(Shape c1, Shape c2) {
		Line line = new Line();
		line.startXProperty().bind(c1.translateXProperty());
		line.startYProperty().bind(c1.translateYProperty());
		line.endXProperty().bind(c2.translateXProperty());
		line.endYProperty().bind(c2.translateYProperty());
		return line;
	}

	public Line getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(Line currentLine) {
		this.currentLine = currentLine;
	}

}
