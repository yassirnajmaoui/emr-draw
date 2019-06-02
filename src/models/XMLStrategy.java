package models;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileOutputStream;
import models.iterator.ShapeContainer;
//----------------------------------------------------
//This class makes part of the Strategy Design Pattern
//----------------------------------------------------
public class XMLStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray) {
		XStream xstream = new XStream(new StaxDriver());
		String dataXml = xstream.toXML(shapeArray);
		
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(dataXml);
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...!");
		
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
