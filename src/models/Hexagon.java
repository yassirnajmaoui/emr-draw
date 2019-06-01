package models;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Hexagon {
	
	//private Node shape;
	
	public Hexagon(){;}
	
	public Node createHexagon() {
	    Path path = new Path();
	           path.getElements().addAll(
	            new MoveTo(100, 300),
	            new HLineTo(45),
	            new ArcTo(20, 20, 0, 80, 25, true, true)
	            );
	    path.setStroke(Color.web("#b9c0c5"));
	    path.setStrokeWidth(5);
	    path.getStrokeDashArray().addAll(15d,15d);
	    path.setFill(null);
	    return path;
	}
}


