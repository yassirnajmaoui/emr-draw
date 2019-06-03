package models;

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

	//@XStreamOmitField
	private  Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public EMRShape(String id, double x, double y, AppController a) {
		switch (id) {
		case EMRShapeFactory.ELLIPSE_ID:
			this.shape=EMRShapeFactory.createEllipse(x, y, a);
			break;
		case EMRShapeFactory.CIRCLE_ID:
			this.shape=EMRShapeFactory.createCircle(x, y, a);
			break;
		case EMRShapeFactory.SQUARE_ID:
			this.shape=EMRShapeFactory.createRect(x, y, a);
			break;
		case EMRShapeFactory.HEXAGON_ID:
			this.shape=EMRShapeFactory.createHexagon(x, y, a);
			break;
		case EMRShapeFactory.LINE_ID:
			// We ignore the creation of line,
			//another method for creating them should be made
			return;
		default:
			break;
		}
		setX(x);
		setY(y);
		setDefaultIdentifier();
		a.emrPane.getChildren().add(this.shape);
	}
	public EMRShape(Shape s, AppController a)
	{
		this.shape=s;
		setDefaultIdentifier();
		a.emrPane.getChildren().add(this.shape);
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

	public String getIdentifier() {return this.identifier;}

	private void setDefaultIdentifier() {
		if (shape instanceof Rectangle) {
			this.identifier = EMRShapeFactory.SQUARE_ID;
		} else if (shape instanceof Ellipse) {
			this.identifier = EMRShapeFactory.ELLIPSE_ID;
		} else if (shape instanceof Circle) {
			this.identifier = EMRShapeFactory.CIRCLE_ID;
		} else if (shape instanceof Line) {
			this.identifier = EMRShapeFactory.LINE_ID;
		} else if (shape instanceof Polygon && ((Polygon) shape).getPoints().size() == 6) {
			this.identifier = EMRShapeFactory.HEXAGON_ID;
		}
	}


	@Override
	public String toString() {
		// Ignore "Line"s here!
		return identifier + "," + String.valueOf(this.getX()) + "," + String.valueOf(this.getY());
	}

}
