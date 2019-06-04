package models.file;

import java.util.ArrayList;

import controllers.AppController;
import javafx.scene.shape.Shape;
import models.EMRConnexion;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

public class EMRConnexionModel {

	private int startHash;
	private int endHash;

	public int getStartHash() {
		return startHash;
	}

	public void setStartHash(int startHash) {
		this.startHash = startHash;
	}

	public int getEndHash() {
		return endHash;
	}

	public void setEndHash(int endHash) {
		this.endHash = endHash;
	}
	
	public EMRConnexion createEMRConnexion(ArrayList<EMRShapeModel> shapeModels, ShapeContainer shapeArray, AppController a) {
		return null;
	}

	public EMRConnexionModel() {
		// TODO Auto-generated constructor stub
	}

}
