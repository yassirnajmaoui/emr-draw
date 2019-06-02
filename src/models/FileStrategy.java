package models;
import models.iterator.ShapeContainer;

public interface FileStrategy {
	public void saveFile(String filename, ShapeContainer shapeArray);
	public void openFile(String filename, ShapeContainer shapeArray);

}
