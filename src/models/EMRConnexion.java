package models;

import controllers.AppController;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeType;

public class EMRConnexion {

	private Shape startShape;
	private Shape endShape;
	private Line line;
	
	public EMRConnexion(Shape s1,Shape s2, AppController a) {
		startShape=s1;
		endShape=s2;
		this.line = connect(s1,s2);
		a.getEmrPane().getChildren().add(this.line);
	}

	public Shape getStartShape() {
		return startShape;
	}

	public void setStartShape(Shape startShape) {
		this.startShape = startShape;
	}

	public Shape getEndShape() {
		return endShape;
	}

	public void setEndShape(Shape endShape) {
		this.endShape = endShape;
	}
	private Line connect(Shape c1, Shape c2) {
		Line line = new Line();
		line.startXProperty().bind(c1.translateXProperty());
		line.startYProperty().bind(c1.translateYProperty());
		line.endXProperty().bind(c2.translateXProperty());
		line.endYProperty().bind(c2.translateYProperty());
		line.getStrokeDashArray().addAll(21d,10d);
		return line;
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}
	
	@Override
	public String toString() {
			return EMRShapeFactory.LINE_ID+","+String.valueOf(startShape.hashCode())+","+String.valueOf(endShape.hashCode());

	}
	
}
