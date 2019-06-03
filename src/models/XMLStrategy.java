package models;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import controllers.AppController;
import javafx.scene.shape.Line;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

//----------------------------------------------------
//This class makes part of the Strategy Design Pattern
//----------------------------------------------------
public class XMLStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray) {/*
		String dataXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		ShapeIterator it = (ShapeIterator) shapeArray.getIterator();
		while (it.hasNext()) {
			EMRShape currentShape = it.next();
			if (currentShape.getIdentifier().equals(EMRShapeFactory.LINE_ID))
				dataXml += "<" + EMRShapeFactory.LINE_ID + " sx=" + String.valueOf(currentShape.getX()) + " sy="
						+ String.valueOf(currentShape.getY()) + " ex="
						+ String.valueOf(((Line) currentShape.getShape()).getEndX()) + " ey="
						+ String.valueOf(((Line) currentShape.getShape()).getEndY()) + "/>";
			else
				dataXml += "<" + currentShape.getIdentifier() + " x=" + String.valueOf(currentShape.getX()) + " y="
						+ String.valueOf(currentShape.getY()) + "/>";
			dataXml+="\n";
		}
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(dataXml);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		System.out.println("Success...!");
*/
	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray,ConnexionContainer connexionArray, AppController a) {/*
		XMLDecoder decoder = null;
		try {
			decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found");
			e.printStackTrace();
		}
		ShapeContainer tmpShapeContainer;
		tmpShapeContainer = (ShapeContainer) decoder.readObject();
		decoder.close();
		shapeArray.setShapeArray(tmpShapeContainer.getShapeArray());*/
	}
}
