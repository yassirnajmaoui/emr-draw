package models.state;

import controllers.AppController;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import models.EMRConnexion;

//--------------------------------------------------
//This class makes part of the State Design Pattern
//--------------------------------------------------
public class EMRModeConnexion implements EMRMode {

	private Shape currentShape;
	private EMRConnexion currentConnexion;

	@Override
	public void handleDragOn(MouseEvent t, AppController a) {
	}

	@Override
	public void handleDragWhile(MouseEvent t, AppController a) {

	}

	@Override
	public void handleDragOver(MouseEvent t, AppController a) {
		//System.out.println("Clicked! " + t.getSource() + "\nPrevious: " + currentShape);
		if (t.getSource() instanceof Shape && t.getSource() != null && currentShape == null) {
			currentShape = ((Shape) t.getSource());
			currentShape.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
		} else if ((Shape) t.getSource() != null) {
			if(currentShape != t.getSource())
			{
				currentConnexion = new EMRConnexion(currentShape, (Shape) t.getSource(),a);
				System.out.println(currentConnexion.getLine());
				a.addConnexion(currentConnexion);
			}
			currentShape.setStyle("");
			currentShape = null;
		}
	}



}
