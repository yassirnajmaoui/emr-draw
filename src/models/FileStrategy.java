package models;

import controllers.AppController;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

//----------------------------------------------------------
// This Interface makes part of the Strategy Design Pattern
//----------------------------------------------------------
public interface FileStrategy {
	public void saveFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray);
	public void openFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray, AppController a);

}
