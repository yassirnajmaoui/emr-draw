package models;

import java.io.FileWriter;

import com.thoughtworks.xstream.annotations.XStreamOmitField;
import controllers.AppController;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import models.EMRShapeFactory.eShape;



public class EMRShape {

	private String identifier;

	private double xPos;

	private double yPos;

	@XStreamOmitField
	private  Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public EMRShape(eShape s, double x, double y, AppController a) {
		if(s==eShape.ELLIPSE)
			this.shape=EMRShapeFactory.createEllipse(x, y, a);
		else if(s==eShape.CIRCLE)
			this.shape=EMRShapeFactory.createCircle(x, y, a);
		else if(s==eShape.SQUARE)
			this.shape=EMRShapeFactory.createRect(x, y, a);
		else if(s==eShape.HEXAGON)
			this.shape=EMRShapeFactory.createHexagon(x, y, a);
		setX(x);
		setY(y);
		setDefaultIdentifier();
	}
	public EMRShape(Shape s)
	{
		this.shape=s;
	}


	public double getX() {
		double tmp=this.shape.getTranslateX();
		this.xPos=tmp;
		return tmp;
	}

	public double getY() {
		double tmp=this.shape.getTranslateY();
		this.yPos=tmp;
		return tmp;
	}

	public void setX(double x) {
		this.shape.setTranslateX(x);
		this.xPos=x;
	}
	
	public void setY(double y) {
		shape.setTranslateY(y);
		this.yPos=y;
	}

	public DoubleProperty getXProperty() {
		return shape.translateXProperty();
	}

	public DoubleProperty getYProperty() {
		return shape.translateYProperty();
	}

	public String getIdentifier() {
		return this.identifier;
	}

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

	@Override
	public String toString() {
		// Ignore "Line"s here!
		return identifier + "," + String.valueOf(this.getX()) + "," + String.valueOf(this.getY());
	}

}
