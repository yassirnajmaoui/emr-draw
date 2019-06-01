package models;

import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

public class EMRModeConnexion implements EMRMode {

	private Line currentLine;
	
	@Override
	public void handle(MouseEvent t) {
		if(EMRShapeFactory.isDragging())
		{
			//currentLine.
		}
	}
}
