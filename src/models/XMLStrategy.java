package models;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import models.iterator.ShapeContainer;

public class XMLStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error while opening the file!");
		}
		encoder.writeObject(shapeArray);
		encoder.close();	
	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray) {
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File shape.xml not found");
		}
		ShapeContainer tmpShapeContainer;
		tmpShapeContainer=(ShapeContainer)decoder.readObject();
		decoder.close();
		shapeArray.setShapeArray(tmpShapeContainer.getShapeArray());
	}
}
