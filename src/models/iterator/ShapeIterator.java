package models.iterator;

import models.EMRShape;

//----------------------------------------------------
//This class makes part of the Iterator Design Pattern
//----------------------------------------------------
public class ShapeIterator implements Iterator {

	int index;
	ShapeContainer container;

	public ShapeIterator(ShapeContainer c) {
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
	public EMRShape next() {
		if (this.hasNext()) {
			return container.getElem(index++);
		}
		return null;
	}
}


