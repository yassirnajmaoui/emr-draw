package models;

import controllers.AppController;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

//--------------------------------------------------
//This class makes part of the State Design Pattern
//--------------------------------------------------
public class EMRModeDessin implements EMRMode {

	@Override
	public void handleDragOn(MouseEvent t, AppController a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleDragWhile(MouseEvent t, AppController a) {
		double offsetX = t.getSceneX() - EMRShapeFactory.getOrgSceneX();
		double offsetY = t.getSceneY() - EMRShapeFactory.getOrgSceneY();

		EMRShape c = new EMRShape((Shape) (t.getSource()));

		c.setX(c.getX()+offsetX);
		c.setY(c.getY()+offsetY);
		EMRShapeFactory.setOrgSceneX(t.getSceneX());
		EMRShapeFactory.setOrgSceneY(t.getSceneY());
	}
	  
	  @Override
	  public void handleDragOver(MouseEvent t, AppController a) { 
	  // TODO Auto-generated method stub
	  }
	  
}
	 
