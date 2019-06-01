package models;

import controllers.AppController;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class EMRShapeFactory {

	public static final double CIRCLE_RADIUS = 20.0d;
	public static final double SQUARE_SIZE = 38.0d;
	public static final double ELLIPSE_WIDTH = 45.0d/2.0d;
	public static final double ELLIPSE_HEIGHT = 24.0d/2.0d;
	
	private static double orgSceneX, orgSceneY;
	private static boolean dragging;


	public static Circle createCircle(double x, double y, AppController a) {
		Circle circle = new Circle(x, y, CIRCLE_RADIUS, Color.GOLD);
		circle.setStroke(Color.RED);
		circle.setCursor(Cursor.HAND);
		manageEvents(circle,a);
		return circle;
	}
	
	public static Rectangle createRect(double x, double y, AppController a) {
		Rectangle rectangle = new Rectangle(x, y, SQUARE_SIZE, SQUARE_SIZE);
		rectangle.setFill(Color.GOLD);
		rectangle.setStroke(Color.RED);
		rectangle.setCursor(Cursor.HAND);
		manageEvents(rectangle,a);
		return rectangle;
	}
	
	public static Ellipse createEllipse(double x, double y, AppController a) {
		Ellipse el = new Ellipse(x, y, ELLIPSE_WIDTH, ELLIPSE_HEIGHT);
		el.setFill	(Color.PALEGREEN);
		el.setStroke(Color.GREEN);
		el.setCursor(Cursor.HAND);
		manageEvents(el,a);
		return el;
	}
	
	private static void manageEvents(Shape n, AppController a)
	{
		n.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
			      orgSceneX = t.getSceneX();
			      orgSceneY = t.getSceneY();

			      Shape c = (Shape) (t.getSource());
			      c.toFront();			}
		});
		n.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				AppController.getMode().handleDragWhile(t,a);
			}
		});
		n.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				AppController.getMode().handleDragOver(t,a);
			}
		});
	}

	public static boolean isDragging() {
		return dragging;
	}
	public static void setDragging(boolean b) {
		dragging = b;
	}

	public static double getOrgSceneX() {
		return orgSceneX;
	}

	public static void setOrgSceneX(double orgSceneX) {
		EMRShapeFactory.orgSceneX = orgSceneX;
	}

	public static double getOrgSceneY() {
		return orgSceneY;
	}

	public static void setOrgSceneY(double orgSceneY) {
		EMRShapeFactory.orgSceneY = orgSceneY;
	}
	
}
