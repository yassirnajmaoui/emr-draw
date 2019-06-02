package models;

import java.io.FileWriter;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class EMRShape {
	private String identifier;
	private double x;
	private double y;
	private transient Shape shape;

	public Shape getShape() { return shape; }

	public void setShape(Shape shape) { this.shape = shape; }

	public EMRShape() { setDefaultIdentifier();}

	public EMRShape(Shape shape) {
		this.shape = shape;
		setDefaultIdentifier();
	}

	public EMRShape(double x, double y) {
		setX(x);
		setY(y);
		setDefaultIdentifier();
	}

	public double getX() { return this.shape.getTranslateX();}

	public void setX(double x) {this.shape.setTranslateX(x);}

	public double getY() {return this.shape.getTranslateY();}

	public void setY(double y) {shape.setTranslateY(y);}

	public DoubleProperty getXProperty() {return shape.translateXProperty();}

	public DoubleProperty getYProperty() {return shape.translateYProperty();}

	public String getIdentifier() {return this.identifier;}

	public void setDefaultIdentifier() {
		if (shape instanceof Rectangle) {
			this.identifier = "Rectangle";
		} else if (shape instanceof Ellipse) {
			this.identifier = "Ellipse";
		} else if (shape instanceof Circle) {
			this.identifier = "Circle";
		} else if (shape instanceof Line) {
			this.identifier = "Line";
		} else if (shape instanceof Polygon && ((Polygon) shape).getPoints().size() == 6) {
			this.identifier = "Hexagon";
		}
	}

	public void setIdentifier(String identifier) { this.identifier = identifier;}
	
	@Override
	public String toString() {
		// Ignore "Line"s here!
		return identifier + "," + String.valueOf(this.getX()) + "," + String.valueOf(this.getY());
	}
}
