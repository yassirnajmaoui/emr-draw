package models;

import controllers.AppController;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class EMRModeDessin implements EMRMode {

	@Override
	public void handleDragOn(MouseEvent t, AppController a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleDragWhile(MouseEvent t, AppController a) {
		double offsetX = t.getSceneX() - EMRShapeFactory.getOrgSceneX();
		double offsetY = t.getSceneY() - EMRShapeFactory.getOrgSceneY();

		Shape c = (Shape) (t.getSource());
		// Do this shit for all shapes tabarnak
		if(c instanceof Rectangle)
		{
			((Rectangle)c).setX(((Rectangle)c).getX() + offsetX);
			((Rectangle)c).setY(((Rectangle)c).getY() + offsetY);
		}else if(c instanceof Ellipse)
		{
			((Ellipse)c).setCenterX(((Ellipse)c).getCenterX() + offsetX);
			((Ellipse)c).setCenterY(((Ellipse)c).getCenterY() + offsetY);
		}else if(c instanceof Circle)
		{
			((Circle)c).setCenterX(((Circle)c).getCenterX() + offsetX);
			((Circle)c).setCenterY(((Circle)c).getCenterY() + offsetY);
		}


		EMRShapeFactory.setOrgSceneX(t.getSceneX());
		EMRShapeFactory.setOrgSceneY(t.getSceneY());
	}

	@Override
	public void handleDragOver(MouseEvent t, AppController a) {
		// TODO Auto-generated method stub
		
	}
}
