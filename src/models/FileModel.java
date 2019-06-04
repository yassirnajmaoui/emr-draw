package models;

import java.util.ArrayList;

import controllers.AppController;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

public class FileModel {

	ArrayList<EMRShapeModel> shapeArrayModels;
	ArrayList<EMRConnexionModel> shapeConnexionModels;

	public ArrayList<EMRShapeModel> getShapeArrayModels() {
		return shapeArrayModels;
	}

	public void setShapeArrayModels(ArrayList<EMRShapeModel> shapeArrayModels) {
		this.shapeArrayModels = shapeArrayModels;
	}

	public ArrayList<EMRConnexionModel> getShapeConnexionModels() {
		return shapeConnexionModels;
	}

	public void setShapeConnexionModels(ArrayList<EMRConnexionModel> shapeConnexionModels) {
		this.shapeConnexionModels = shapeConnexionModels;
	}

	public FileModel() {
		shapeArrayModels = new ArrayList<EMRShapeModel>();
		shapeConnexionModels = new ArrayList<EMRConnexionModel>();
	}

	public void toAppController(ShapeContainer shapeArray, ConnexionContainer connexionArray, AppController a) {
		// Shape array and Shape connexion must be empty !!

		// TODO: fill shapeArray
		for (int i = 0; i < shapeArrayModels.size(); i++) {
			shapeArray.addShape(new EMRShape(shapeArrayModels.get(i).getType(), shapeArrayModels.get(i).getxPos(),
					shapeArrayModels.get(i).getyPos(), a));
		}

		ArrayList<Integer> shapeHashes = new ArrayList<Integer>();
		for (int i = 0; i < shapeArrayModels.size(); i++) {
			shapeHashes.add(shapeArrayModels.get(i).getHash());
		}
		System.out.println(shapeArray.toString());
		for (int i = 0; i < shapeConnexionModels.size(); i++) {
			int indexOf1 = shapeHashes.indexOf(shapeConnexionModels.get(i).getStartHash());
			int indexOf2 = shapeHashes.indexOf(shapeConnexionModels.get(i).getEndHash());
			if (indexOf1 == -1 || indexOf2 == -1) {
				System.out.println("Invalid hash codes");
				return;
			}
			EMRShape s1 = shapeArray.getElem(indexOf1);
			EMRShape s2 = shapeArray.getElem(indexOf2);
			connexionArray.addConnexion(new EMRConnexion(s1.getShape(), s2.getShape(), a));
		}
	}

}
