package models.iterator;

import models.EMRShape;

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


