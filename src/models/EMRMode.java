package models;

import controllers.AppController;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public interface EMRMode {
	public void handleDragOn(MouseEvent t, AppController a);
	public void handleDragWhile(MouseEvent t, AppController a);
	public void handleDragOver(MouseEvent t, AppController a);
}
