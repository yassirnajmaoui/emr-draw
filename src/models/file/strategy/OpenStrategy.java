package models.file.strategy;

import controllers.AppController;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

public interface OpenStrategy {
	public void open(ShapeContainer shapeArray, ConnexionContainer connexionArray, AppController a);
}
