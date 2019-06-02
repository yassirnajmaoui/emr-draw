package models;

import java.io.FileWriter;

import models.iterator.ShapeContainer;

public class TXTStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray) {
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(shapeArray.toString());
			fw.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Success...!");
	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray) {
		// TODO Auto-generated method stub

	}

}
