package models;

import controllers.AppController;
import javafx.beans.property.DoubleProperty;
import javafx.scene.shape.Shape;

public class EMRShape {

	private String identifier;

	private Shape shape;

	public Shape getShape() {
		return shape;
	}

	public EMRShape(String id, double x, double y, AppController a) {
		switch (id) {
		case EMRShapeFactory.FLECHENOIRE_ID:
			this.shape = EMRShapeFactory.createFlecheNoire(x, y, a);
			break;
		case EMRShapeFactory.ELLIPSE_ID:
			this.shape = EMRShapeFactory.createEllipse(x, y, a);
			break;
		case EMRShapeFactory.CIRCLE_ID:
			this.shape = EMRShapeFactory.createCircle(x, y, a);
			break;
		case EMRShapeFactory.SQUARE_ID:
			this.shape = EMRShapeFactory.createRect(x, y, a);
			break;
		case EMRShapeFactory.HEXAGON_ID:
			this.shape = EMRShapeFactory.createHexagon(x, y, a);
			break;
		case EMRShapeFactory.TRAPEZE_ID:
			this.shape = EMRShapeFactory.createTrapeze(x, y, a);
			break;
		case EMRShapeFactory.TRAPEZEDIAGO_ID:
			this.shape = EMRShapeFactory.createTrapezeDiago(x, y, a);
			break;
		case EMRShapeFactory.TRAPEZEPLEIN_ID:
			this.shape = EMRShapeFactory.createTrapezePlein(x, y, a);
			break;
		case EMRShapeFactory.RECTANGLEDIAGO_ID:
			this.shape = EMRShapeFactory.createRectangleDiago(x, y, a);
			break;
		case EMRShapeFactory.TRIPLECARREE_ID:
			this.shape = EMRShapeFactory.createTripleCarree(x, y, a);
			break;
		case EMRShapeFactory.DOUBLETRAPEZE_ID:
			this.shape = EMRShapeFactory.createDoubleTrapeze(x, y, a);
			break;
		case EMRShapeFactory.DOUBLECERCLE_ID:
			this.shape = EMRShapeFactory.createDoubleCercle(x, y, a);
			break;
		default:
			return;
		}
		this.identifier = id;
		a.getEmrPane().getChildren().add(this.shape);
	}

	public double getX() {
			return this.shape.getTranslateX();
	}

	public double getY() {
			return this.shape.getTranslateY();
	}

	public void setX(double x) {
			this.shape.setTranslateX(x);
	}

	public void setY(double y) {
			shape.setTranslateY(y);
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


	@Override
	public String toString() {
		return identifier + "," + String.valueOf(this.getX()) + "," + String.valueOf(this.getY()) + "," + this.shape.hashCode();
	}

	public int getHash() {
		return this.shape.hashCode();
	}

}
