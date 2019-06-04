package models;

import controllers.AppController;
import javafx.scene.input.MouseEvent;

//--------------------------------------------------------
//This interface makes part of the State Design Pattern
//--------------------------------------------------------
public interface EMRMode {
	public void handleDragOn(MouseEvent t, AppController a);
	public void handleDragWhile(MouseEvent t, AppController a);
	public void handleDragOver(MouseEvent t, AppController a);
}
