package models.iterator;

import java.io.FileWriter;
import java.util.ArrayList;
import models.EMRShape;

public class ShapeContainer implements Container {


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

	@Override
	public String toString() {
		String toRet = "";
		ShapeIterator it = (ShapeIterator) this.getIterator();
		while (it.hasNext()) {
			toRet += it.next().toString() + "\n";
		}
		return toRet;
	}

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
}
