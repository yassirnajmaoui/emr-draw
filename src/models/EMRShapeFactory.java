package models;

import controllers.AppController;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

//----------------------------------------------------
//This class makes part of the Factory Design Pattern
//----------------------------------------------------
public class EMRShapeFactory {

	private static double orgSceneX, orgSceneY;
	private static boolean dragging;

	public static final String LINE_ID = "connexion";
	public static final String SHAPES_XML_ID = "shapes";
	public static final String LINES_XML_ID = "connexions";
	public static final String SHAPE_XML_ID = "shape";
	public static final String TYPE_XML_ID = "type";
	public static final String X_XML_ID = "x";
	public static final String Y_XML_ID = "y";
	public static final String SHAPEHASH_XML_ID = "shapehash";
	public static final String STARTSHAPE_XML_ID = "startshape";
	public static final String ENDSHAPE_XML_ID = "endshape";
	public static final String FLECHENOIRE_ID = "flecheNoire"; // Shape #1
	public static final String FLECHEPOINTILLEE_ID = "flechePointillee"; // Shape #2
	public static final String FLECHEROUGE_ID = "flecheRouge"; // Shape #3
	public static final String FLECHE90POINTILLEE_ID = "fleche90pointillee"; // Shape #4
	public static final String FLECHE90_ID = "fleche90"; // Shape #5
	public static final String ELLIPSE_ID = "ovalevert"; // Shape #6
	public static final String TRAPEZEDIAGO_ID = "trapezediago"; // Shape #7
	public static final String TRAPEZE_ID = "trapeze"; // Shape #8
	public static final String DOUBLETRAPEZE_ID = "doubletrapeze"; // Shape #9
	public static final String TRAPEZEPLEIN_ID = "trapezeplein"; // Shape #10
	public static final String HEXAGON_ID = "hexagone"; // Shape #11
	public static final String TRIPLECARREE_ID = "triplecarree"; // Shape #12
	public static final String CIRCLE_ID = "cercle"; // Shape #13
	public static final String SQUARE_ID = "carre"; // Shape #14
	public static final String RECTANGLEDIAGO_ID = "rectanglediago"; // Shape #15
	public static final String DOUBLECERCLE_ID = "doublecercle"; // Shape #16
	
	public static Circle createCircle(double x, double y, AppController a) {
		Circle circle = new Circle(a.getEmrCircle().getRadius());
		circle.setTranslateX(x);
		circle.setTranslateY(y);
		circle.setStroke(a.getEmrCircle().getStroke());
		circle.setFill(a.getEmrCircle().getFill());
		manageEvents(circle,a);
		return circle;
	}
	
	public static Rectangle createRect(double x, double y, AppController a) {
		Rectangle rectangle = new Rectangle(a.getEmrSquare().getWidth(), a.getEmrSquare().getHeight());
		rectangle.setTranslateX(x);
		rectangle.setTranslateY(y);
		rectangle.setFill(Color.GOLD);
		rectangle.setStroke(Color.RED);
		manageEvents(rectangle, a);
		return rectangle;
	}
	
	public static Ellipse createEllipse(double x, double y, AppController a) {
		Ellipse el = new Ellipse(a.getEmrEllipse().getRadiusX(), a.getEmrEllipse().getRadiusY());
		el.setTranslateX(x);
		el.setTranslateY(y);
		el.setFill(a.getEmrEllipse().getFill());
		el.setStroke(a.getEmrEllipse().getStroke());
		manageEvents(el,a);
		return el;
	}
	public static Polygon createHexagon(double x, double y, AppController a) {
		Polygon poly = new Polygon();
		poly.getPoints().addAll(a.getEmrHexagon().getPoints());
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setStroke(a.getEmrHexagon().getStroke());
		poly.setFill(a.getEmrHexagon().getFill());
		manageEvents(poly,a);
		return poly;
	}
	public static Polygon createTrapeze(double x, double y, AppController a) {
		Polygon poly = new Polygon();
		poly.getPoints().addAll(a.getEmrTrapeze().getPoints());
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setStroke(a.getEmrTrapeze().getStroke());
		poly.setFill(a.getEmrTrapeze().getFill());
		manageEvents(poly,a);
		return poly;
	}
	public static Polygon createTrapezePlein(double x, double y, AppController a) {
		Polygon poly = new Polygon();
		poly.getPoints().addAll(a.getEmrTrapezePlein().getPoints());
		poly.setTranslateX(x);
		poly.setTranslateY(y);
		poly.setStroke(a.getEmrTrapezePlein().getStroke());
		poly.setFill(a.getEmrTrapezePlein().getFill());
		manageEvents(poly,a);
		return poly;
	}
	
	public static Path createTrapezeDiago(double x, double y, AppController a) {
		Path path = new Path(a.getEmrTrapezeDiago().getElements());
		path.setFillRule(a.getEmrTrapezeDiago().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrTrapezeDiago().getStroke());
		path.setFill(a.getEmrTrapezeDiago().getFill());
		manageEvents(path,a);
		return path;
	}
	
	public static Path createRectangleDiago(double x, double y, AppController a) {
		Path path = new Path(a.getEmrRectangleDiago().getElements());
		path.setFillRule(a.getEmrRectangleDiago().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrRectangleDiago().getStroke());
		path.setFill(a.getEmrRectangleDiago().getFill());
		manageEvents(path,a);
		return path;
	}
	
	public static Path createFlecheNoire(double x, double y, AppController a) {
		Path path = new Path(a.getEmrFlecheNoire().getElements());
		path.setFillRule(a.getEmrFlecheNoire().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrFlecheNoire().getStroke());
		path.setFill(a.getEmrFlecheNoire().getFill());
		manageEvents(path,a);
		return path;
	}
	
	public static Path createTripleCarree(double x, double y, AppController a) {
		Path path = new Path(a.getEmrTripleCarree().getElements());
		path.setFillRule(a.getEmrTripleCarree().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrTripleCarree().getStroke());
		path.setFill(a.getEmrTripleCarree().getFill());
		manageEvents(path,a);
		return path;
	}
	
	public static Path createDoubleTrapeze(double x, double y, AppController a) {
		Path path = new Path(a.getEmrDoubleTrapeze().getElements());
		path.setFillRule(a.getEmrDoubleTrapeze().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrDoubleTrapeze().getStroke());
		path.setFill(a.getEmrDoubleTrapeze().getFill());
		manageEvents(path,a);
		return path;
	}
	
	public static Path createDoubleCercle(double x, double y, AppController a) {
		Path path = new Path(a.getEmrDoubleCercle().getElements());
		path.setFillRule(a.getEmrDoubleCercle().getFillRule());
		path.setTranslateX(x);
		path.setTranslateY(y);
		path.setStroke(a.getEmrDoubleCercle().getStroke());
		path.setFill(a.getEmrDoubleCercle().getFill());
		manageEvents(path,a);
		return path;
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
				a.getMode().handleDragWhile(t,a);
			}
		});
		n.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				a.getMode().handleDragOver(t,a);
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
