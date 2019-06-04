package models;

import controllers.AppController;

public class EMRShapeModel {

	private String type;
	private double xPos;
	private double yPos;
	private int hash;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
	}
	
	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
	}


	public EMRShapeModel() {
		// TODO Auto-generated constructor stub
	}
	public EMRShapeModel(String t, double x, double y) {
		setType(t);
		setxPos(x);
		setyPos(y);
	}

}
