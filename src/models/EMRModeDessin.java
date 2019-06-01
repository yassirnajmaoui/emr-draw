package models;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class EMRModeDessin implements EMRMode {

	@Override
	public void handle(MouseEvent t) {
		double offsetX = t.getSceneX() - EMRShapeFactory.getOrgSceneX();
		double offsetY = t.getSceneY() - EMRShapeFactory.getOrgSceneY();

		Node c = (Node) (t.getSource());

		c.setLayoutX(c.getLayoutX() + offsetX);
		c.setLayoutY(c.getLayoutY() + offsetY);

		EMRShapeFactory.setOrgSceneX(t.getSceneX());
		EMRShapeFactory.setOrgSceneY(t.getSceneY());
		
	}
}
