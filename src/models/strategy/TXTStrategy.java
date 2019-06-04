package models.strategy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import controllers.AppController;
import models.EMRConnexion;
import models.EMRShape;
import models.EMRShapeFactory;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

// ----------------------------------------------------
// This class makes part of the Strategy Design Pattern
// ----------------------------------------------------

public class TXTStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray) {
		try {
			FileWriter fw = new FileWriter(filename);
			fw.write(shapeArray.toString() + connexionArray.toString());
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Success...!");
	}

	@Override
	public void openFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray,
			AppController a) {
		BufferedReader reader;
		try {
			ArrayList<Integer> shapeHashes = new ArrayList<Integer>();
			reader = new BufferedReader(new FileReader(filename));
			String line = reader.readLine();
			while (line != null) {
				String[] lineDivided = line.split(",");
				if(!(lineDivided[0].equals(EMRShapeFactory.LINE_ID)))
				{
					String shId = (lineDivided[0]);
					Double shX = Double.parseDouble(lineDivided[1]);
					Double shY = Double.parseDouble(lineDivided[2]);
					Integer shHash = Integer.parseInt(lineDivided[3]);
					shapeHashes.add(shHash);
					shapeArray.addShape(new EMRShape(shId, shX, shY, a));
				}
				line = reader.readLine();
			}
			reader.close();
			reader = new BufferedReader(new FileReader(filename));
			line = reader.readLine();
			while (line != null) {
				String[] lineDivided = line.split(",");
				if((lineDivided[0].equals(EMRShapeFactory.LINE_ID)))
				{
					Integer coHash1 = Integer.parseInt(lineDivided[1]);
					Integer coHash2 = Integer.parseInt(lineDivided[2]);
					int indexOf1 = shapeHashes.indexOf(coHash1);
					int indexOf2 = shapeHashes.indexOf(coHash2);
					if(indexOf1 == -1 || indexOf2 == -1)
					{
						System.out.println("Invalid hash codes");
						continue;
					}
					EMRShape s1 = shapeArray.getElem(indexOf1);
					EMRShape s2 = shapeArray.getElem(indexOf2);
					connexionArray.addConnexion(new EMRConnexion(s1.getShape(), s2.getShape(), a));
				}
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
