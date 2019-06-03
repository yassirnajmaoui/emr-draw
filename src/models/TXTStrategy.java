package models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import controllers.AppController;
import models.EMRShapeFactory.eShape;
import models.iterator.ShapeContainer;

// ----------------------------------------------------
// This class makes part of the Strategy Design Pattern
// ----------------------------------------------------
public class TXTStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray) {
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(shapeArray.toString());
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Success...!");
	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray, AppController a) {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				String[] lineDivided = line.split(",");
				if (lineDivided[0] != EMRShapeFactory.LINE_ID) {
					shapeArray.addShape(new EMRShape(lineDivided[0], Double.parseDouble(lineDivided[1]),
							Double.parseDouble(lineDivided[2]), a));
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
