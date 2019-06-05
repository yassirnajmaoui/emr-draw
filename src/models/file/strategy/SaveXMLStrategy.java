package models.file.strategy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import models.EMRConnexion;
import models.EMRShape;
import models.EMRShapeFactory;
import models.iterator.ConnexionContainer;
import models.iterator.ConnexionIterator;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

public class SaveXMLStrategy implements SaveStrategy {

	@Override
	public void save(ShapeContainer shapeArray, ConnexionContainer connexionArray) {
		// TODO Auto-generated method stub
		
	}
}
	/*@Override
	public void save(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray) {
		try {
			// create an XMLOutputFactory
			XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();
			// create XMLEventWriter
			XMLEventWriter eventWriter = outputFactory.createXMLEventWriter(new FileOutputStream(filename));
			// create an EventFactory
			XMLEventFactory eventFactory = XMLEventFactory.newInstance();
			XMLEvent end = eventFactory.createDTD("\n");
			// create and write Start Tag
			StartDocument startDocument = eventFactory.createStartDocument();
			eventWriter.add(startDocument);

			eventWriter.add(eventFactory.createStartElement("", "", "contenu"));
			eventWriter.add(end);
			
			// create config open tag
			ShapeIterator it1 = (ShapeIterator) shapeArray.getIterator();
			while (it1.hasNext()) {
				EMRShape currentShape = it1.next();
				StartElement configStartElement = eventFactory.createStartElement("", "", EMRShapeFactory.SHAPE_XML_ID);
				eventWriter.add(configStartElement);
				eventWriter.add(end);
				// Write the different nodes
				createNode(eventWriter, EMRShapeFactory.TYPE_XML_ID, currentShape.getIdentifier());
				createNode(eventWriter, EMRShapeFactory.X_XML_ID, String.valueOf(currentShape.getX()));
				createNode(eventWriter, EMRShapeFactory.Y_XML_ID, String.valueOf(currentShape.getY()));
				createNode(eventWriter, EMRShapeFactory.SHAPEHASH_XML_ID, String.valueOf(currentShape.getHash()));

				eventWriter.add(eventFactory.createEndElement("", "", EMRShapeFactory.SHAPE_XML_ID));
				eventWriter.add(end);
			}
			ConnexionIterator it2 = (ConnexionIterator) connexionArray.getIterator();
			while (it2.hasNext()) {
				EMRConnexion currentConnexion = it2.next();
				StartElement configStartElement = eventFactory.createStartElement("", "", EMRShapeFactory.LINE_ID);
				eventWriter.add(configStartElement);
				eventWriter.add(end);
				// Write the different nodes
				createNode(eventWriter, EMRShapeFactory.STARTSHAPE_XML_ID,
						String.valueOf(currentConnexion.getStartShape().hashCode()));
				createNode(eventWriter, EMRShapeFactory.ENDSHAPE_XML_ID,
						String.valueOf(currentConnexion.getEndShape().hashCode()));

				eventWriter.add(eventFactory.createEndElement("", "", EMRShapeFactory.SHAPE_XML_ID));
				eventWriter.add(end);
			}
			eventWriter.add(eventFactory.createEndDocument());
			eventWriter.close();
		} catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void createNode(XMLEventWriter eventWriter, String name, String value) throws XMLStreamException {

		XMLEventFactory eventFactory = XMLEventFactory.newInstance();
		XMLEvent end = eventFactory.createDTD("\n");
		XMLEvent tab = eventFactory.createDTD("\t");
		// create Start node
		StartElement sElement = eventFactory.createStartElement("", "", name);
		eventWriter.add(tab);
		eventWriter.add(sElement);
		// create Content
		Characters characters = eventFactory.createCharacters(value);
		eventWriter.add(characters);
		// create End node
		EndElement eElement = eventFactory.createEndElement("", "", name);
		eventWriter.add(eElement);
		eventWriter.add(end);
	}
}*/
