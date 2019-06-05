package models.state;

import controllers.AppController;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;
import models.EMRShapeFactory;

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

		Shape c = (Shape) (t.getSource());

		c.setTranslateX(c.getTranslateX()+offsetX);
		c.setTranslateY(c.getTranslateY()+offsetY);
		EMRShapeFactory.setOrgSceneX(t.getSceneX());
		EMRShapeFactory.setOrgSceneY(t.getSceneY());
		//System.out.println(c.hashCode());
	}
	  
	  @Override
	  public void handleDragOver(MouseEvent t, AppController a) { 
	  // TODO Auto-generated method stub
	  }
	  
}
	 
