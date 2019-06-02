package models;

import java.io.FileWriter;

import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class EMRShape {
	private String identifier;
	private double x;
	private double y;
	private transient Shape shape;

	public Shape getShape() {
		return shape;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public EMRShape() {
		setDefaultIdentifier();
	}

	public EMRShape(Shape shape) {
		this.shape = shape;
		setDefaultIdentifier();
	}

	public EMRShape(double x, double y) {
		setX(x);
		setY(y);
		setDefaultIdentifier();
	}

	public double getX() {/*
		if (shape instanceof Rectangle) {
			this.x = ((Rectangle) shape).getX();
		} else if (shape instanceof Ellipse) {
			this.x = ((Ellipse) shape).getCenterX();
		} else if (shape instanceof Circle) {
			this.x = ((Circle) shape).getCenterX();
		}
		return this.x;*/
		return this.shape.getTranslateX();
	}

	public void setX(double x) {/*
		if (shape instanceof Rectangle) {
			((Rectangle) shape).setX(x);
		} else if (shape instanceof Ellipse) {
			((Ellipse) shape).setCenterX(x);
		} else if (shape instanceof Circle) {
			((Circle) shape).setCenterX(x);
		}
		this.x = x;*/
		this.shape.setTranslateX(x);
	}

	public double getY() {/*
		if (shape instanceof Rectangle) {
			this.y = ((Rectangle) shape).getY();
		} else if (shape instanceof Ellipse) {
			this.y = ((Ellipse) shape).getCenterY();
		} else if (shape instanceof Circle) {
			this.y = ((Circle) shape).getCenterY();
		}
		return this.y;*/
		return this.shape.getTranslateY();
	}

	public void setY(double y) {/*
		if (shape instanceof Rectangle) {
			((Rectangle) shape).setY(y);
		} else if (shape instanceof Ellipse) {
			((Ellipse) shape).setCenterY(y);
		} else if (shape instanceof Circle) {
			((Circle) shape).setCenterY(y);
		}
		this.y = y;*/
		shape.setTranslateY(y);
	}

	public DoubleProperty getXProperty() {
		/*
		if (shape instanceof Rectangle) {
			return (((Rectangle) shape).xProperty());
		} else if (shape instanceof Ellipse) {
			return (((Ellipse) shape).centerXProperty());
		} else if (shape instanceof Circle) {
			return (((Circle) shape).centerXProperty());
		} else
			return null;*/
		return shape.translateXProperty();
	}

	public DoubleProperty getYProperty() {
		/*
		if (shape instanceof Rectangle) {
			return (((Rectangle) shape).yProperty());
		} else if (shape instanceof Ellipse) {
			return (((Ellipse) shape).centerYProperty());
		} else if (shape instanceof Circle) {
			return (((Circle) shape).centerYProperty());
		} else
			return null;*/
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
		}
	}


	public void setIdentifier(String identifier) { this.identifier = identifier;}
	

	public String toString() {
		// Ignore "Line"s here!
		return identifier + "-(" + String.valueOf(this.getX()) + ", " + String.valueOf(this.getY()) + ")";
	}



}
