package models;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class EMRShapeFactory {

	public static final double CIRCLE_RADIUS = 20.0d;
	public static final double SQUARE_SIZE = 38.0d;
	public static final double ELLIPSE_WIDTH = 45.0d/2.0d;
	public static final double ELLIPSE_HEIGHT = 24.0d/2.0d;
	
	private static double orgSceneX, orgSceneY;

	public static Circle createCircle(double x, double y) {
		Circle circle = new Circle(x, y, CIRCLE_RADIUS, Color.GOLD);
		circle.setStroke(Color.RED);
		circle.setCursor(Cursor.HAND);

		circle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();

				Circle c = (Circle) (t.getSource());
				c.toFront();
			}
		});
		circle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;

				Circle c = (Circle) (t.getSource());

				c.setCenterX(c.getCenterX() + offsetX);
				c.setCenterY(c.getCenterY() + offsetY);

				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
			}
		});
		return circle;
	}
	
	public static Rectangle createRect(double x, double y) {
		Rectangle rectangle = new Rectangle(x, y, SQUARE_SIZE, SQUARE_SIZE);
		rectangle.setFill(Color.GOLD);
		rectangle.setStroke(Color.RED);
		rectangle.setCursor(Cursor.HAND);

		rectangle.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();

				Rectangle c = (Rectangle) (t.getSource());
				c.toFront();
			}
		});
		rectangle.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;

				Rectangle c = (Rectangle) (t.getSource());

				c.setX(c.getX() + offsetX);
				c.setY(c.getY() + offsetY);

				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
			}
		});
		return rectangle;
	}
	
	public static Ellipse createEllipse(double x, double y) {
		Ellipse el = new Ellipse(x, y, ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
		el.setFill(Color.PALEGREEN);
		el.setStroke(Color.GREEN);
		el.setCursor(Cursor.HAND);

		el.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();

				Ellipse c = (Ellipse) (t.getSource());
				c.toFront();
			}
		});
		el.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				double offsetX = t.getSceneX() - orgSceneX;
				double offsetY = t.getSceneY() - orgSceneY;

				Ellipse c = (Ellipse) (t.getSource());

				c.setCenterX(c.getCenterX() + offsetX);
				c.setCenterY(c.getCenterY() + offsetY);

				orgSceneX = t.getSceneX();
				orgSceneY = t.getSceneY();
			}
		});
		return el;
	}
	
}
