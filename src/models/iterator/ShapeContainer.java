package models.iterator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Shape;
import models.EMRShape;

//----------------------------------------------------
//This class makes part of the Iterator Design Pattern
//----------------------------------------------------
public class ShapeContainer implements Serializable, Container {

	private ArrayList<EMRShape> shapeArray = new ArrayList<EMRShape>();

	public ArrayList<EMRShape> getShapeArray() { return shapeArray; }

	public void setShapeArray(ArrayList<EMRShape> shapeArray) { this.shapeArray = shapeArray; }

	public ShapeContainer() {}

	public void addShape(EMRShape s) { shapeArray.add(s); }

	public int getSize() { return shapeArray.size(); }

	public EMRShape getElem(int index) { return shapeArray.get(index); }

	@Override
	public Iterator getIterator() {
		return new ShapeIterator(this);
	}

	public String toString() {
		String toRet = "";
		ShapeIterator it = (ShapeIterator) this.getIterator();
		while (it.hasNext()) {
			toRet += it.next().toString() + "\n";
		}
		return toRet;
	}

	/*
	public void saveToXML(String filename) {
		XMLEncoder encoder = null;
		try {
			encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)));
		} catch (FileNotFoundException fileNotFound) {
			System.out.println("Error while opening the file!");
		}
		encoder.writeObject(this);
		encoder.close();
	}*/
	
	public void saveToFile(String filename) {
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(this.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...!");
	}
	
/*	public void importXML(String filename) {
		
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File shape.xml not found");
		}
		ShapeContainer tmpShapeContainer;
		tmpShapeContainer=(ShapeContainer)decoder.readObject();
		decoder.close();
		setShapeArray(tmpShapeContainer.getShapeArray());
	}*/
	
	// TODO: importTextFile()
}
