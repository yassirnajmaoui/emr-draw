package models;

import controllers.AppController;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

//----------------------------------------------------
//This class makes part of the Factory Design Pattern
//----------------------------------------------------
public class EMRShapeFactory {

	private static double orgSceneX, orgSceneY;
	private static boolean dragging;
	public static final String ELLIPSE_ID = "ovalevert";
	public static final String CIRCLE_ID = "cercle";
	public static final String SQUARE_ID = "carre";
	public static final String HEXAGON_ID = "hexagone";
	public static final String TRAPEZEPLEIN_ID = "trapezeplein";
	public static final String LINE_ID = "connexion";
	
	public static Circle createCircle(double x, double y, AppController a) {
		Circle circle = new Circle(a.emrCircle.getRadius());
		circle.setTranslateX(x);
		circle.setTranslateY(y);
		circle.setStroke(a.emrCircle.getStroke());
		circle.setFill(a.emrCircle.getFill());
		manageEvents(circle,a);
		return circle;
	}
	
	public static Rectangle createRect(double x, double y, AppController a) {
		Rectangle rectangle = new Rectangle(a.emrSquare.getWidth(), a.emrSquare.getHeight());
		rectangle.setTranslateX(x);
		rectangle.setTranslateY(y);
		rectangle.setFill(Color.GOLD);
		rectangle.setStroke(Color.RED);
		manageEvents(rectangle, a);
		return rectangle;
	}
	
	public static Ellipse createEllipse(double x, double y, AppController a) {
		Ellipse el = new Ellipse(a.emrEllipse.getRadiusX(), a.emrEllipse.getRadiusY());
		el.setTranslateX(x);
		el.setTranslateY(y);
		el.setFill(a.emrEllipse.getFill());
		el.setStroke(a.emrEllipse.getStroke());
		manageEvents(el,a);
		return el;
	}
	public static Polygon createHexagon(double x, double y, AppController a) {
		Polygon poly = new Polygon();
		poly.getPoints().addAll(a.emrHexagon.getPoints());
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setStroke(a.emrHexagon.getStroke());
		poly.setFill(a.emrHexagon.getFill());
		manageEvents(poly,a);
		return poly;
	}
	public static Polygon createTrapezePlein(double x, double y, AppController a) {
		Polygon poly = new Polygon();
		poly.getPoints().addAll(a.emrParallelogramme1.getPoints());
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setStroke(a.emrParallelogramme1.getStroke());
		poly.setFill(a.emrParallelogramme1.getFill());
		manageEvents(poly,a);
		return poly;
	}
	
	
	private static void manageEvents(Shape n, AppController a)
	{
		n.setCursor(Cursor.HAND);
		n.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
			      orgSceneX = t.getSceneX();
			      orgSceneY = t.getSceneY();

			      Shape c = (Shape) (t.getSource());
			      c.toFront();
			}
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
