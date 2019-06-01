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
	private Shape currentShape;

	@Override
	public void handleDragOn(MouseEvent t, AppController a) {
	}

	@Override
	public void handleDragWhile(MouseEvent t, AppController a) {

	}

	@Override
	public void handleDragOver(MouseEvent t, AppController a) {
		System.out.println("Clicked! " + t.getSource() + "\nPrevious: " + currentShape);
		if (t.getSource() instanceof Shape && t.getSource() != null && currentShape == null) {
			currentShape = (Shape) t.getSource();
			currentShape.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		} else if ((Shape) t.getSource() != null) {
			if(currentShape != t.getSource())
			{
				a.addNode(connect(currentShape, (Shape) t.getSource()));
			}
			currentShape.setStyle("");
			currentShape = null;
		}
	}

	private static Line connect(Shape c1, Shape c2) {
		Line line = new Line();
		if (c1 instanceof Rectangle) {
			line.startXProperty().bind(((Rectangle)c1).xProperty());
			line.startYProperty().bind(((Rectangle)c1).yProperty());
		} else if (c1 instanceof Ellipse) {
			line.startXProperty().bind(((Ellipse)c1).centerXProperty());
			line.startYProperty().bind(((Ellipse)c1).centerYProperty());
		} else if (c1 instanceof Circle) {
			line.startXProperty().bind(((Circle)c1).centerXProperty());
			line.startYProperty().bind(((Circle)c1).centerYProperty());
		}
		
		if (c2 instanceof Rectangle) {
			line.endXProperty().bind(((Rectangle)c2).xProperty());
			line.endYProperty().bind(((Rectangle)c2).yProperty());
		} else if (c2 instanceof Ellipse) {
			line.endXProperty().bind(((Ellipse)c2).centerXProperty());
			line.endYProperty().bind(((Ellipse)c2).centerYProperty());
		} else if (c2 instanceof Circle) {
			line.endXProperty().bind(((Circle)c2).centerXProperty());
			line.endYProperty().bind(((Circle)c2).centerYProperty());
		}
		return line;
	}

	public Line getCurrentLine() {
		return currentLine;
	}

	public void setCurrentLine(Line currentLine) {
		this.currentLine = currentLine;
	}

}
