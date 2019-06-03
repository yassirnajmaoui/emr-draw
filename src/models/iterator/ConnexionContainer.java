package models.iterator;

import java.util.ArrayList;

import models.EMRConnexion;

public class ConnexionContainer implements Container {

	private ArrayList<EMRConnexion> connexionArray;

	public ArrayList<EMRConnexion> getShapeArray() {
		return connexionArray;
	}

	public void setConnexionArray(ArrayList<EMRConnexion> connexionArray) {
		this.connexionArray = connexionArray;
	}

	public ConnexionContainer() {
		connexionArray = new ArrayList<EMRConnexion>();
	}

	public void addConnexion(EMRConnexion s) {
		connexionArray.add(s);
	}

	public int getSize() {
		return connexionArray.size();
	}

	public void clearShapes() {
		this.connexionArray.clear();
	}

	public EMRConnexion getElem(int index) {
		return connexionArray.get(index);
	}

	@Override
	public Iterator getIterator() {
		return new ConnexionIterator(this);
	}

	@Override
	public String toString() {
		String toRet = "";
		ConnexionIterator it = (ConnexionIterator) this.getIterator();
		while (it.hasNext()) {
			toRet += it.next().toString() + "\n";
		}
		return toRet;
	}
}
