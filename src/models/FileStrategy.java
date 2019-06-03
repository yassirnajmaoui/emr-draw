package models;

import controllers.AppController;
import models.iterator.ShapeContainer;

//----------------------------------------------------------
// This Interface makes part of the Strategy Design Pattern
//----------------------------------------------------------
public interface FileStrategy {
	public void saveFile(String filename, ShapeContainer shapeArray);
	public void openFile(String filename, ShapeContainer shapeArray, AppController a);

}
