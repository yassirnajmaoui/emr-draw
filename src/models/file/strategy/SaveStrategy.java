package models.file.strategy;

import javax.swing.JFileChooser;

import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

public interface SaveStrategy {
	public void save(ShapeContainer shapeArray, ConnexionContainer connexionArray);
}


