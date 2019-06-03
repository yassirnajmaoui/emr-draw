package models.iterator;

import models.EMRConnexion;
import models.EMRShape;

public class ConnexionIterator implements Iterator{

	int index;
	ConnexionContainer container;

	public ConnexionIterator(ConnexionContainer c) {
		container=c;
	}
	
	@Override
	public boolean hasNext() {
		if (index < container.getSize()) {
			return true;
		}
		return false;
	}

	@Override
	public EMRConnexion next() {
		if (this.hasNext()) {
			return container.getElem(index++);
		}
		return null;
	}
}
