package models;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;

import controllers.AppController;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

//----------------------------------------------------
//This class makes part of the Strategy Design Pattern
//----------------------------------------------------
public class XMLStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray) {
		String dataXml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
		ShapeIterator it = (ShapeIterator) shapeArray.getIterator();
		while (it.hasNext()) {
			EMRShape currentShape = it.next();
			dataXml += "<" + currentShape.getIdentifier() + " x=" + String.valueOf(currentShape.getX()) + " y="
					+ String.valueOf(currentShape.getY()) + " />\n";
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

	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray, AppController a) {
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
		shapeArray.setShapeArray(tmpShapeContainer.getShapeArray());
	}
}
