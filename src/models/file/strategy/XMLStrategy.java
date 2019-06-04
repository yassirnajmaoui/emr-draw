package models.file.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import controllers.AppController;
import models.EMRConnexion;
import models.EMRShape;
import models.EMRShapeFactory;
import models.file.EMRShapeModel;
import models.file.EMRConnexionModel;
import models.file.FileModel;
import models.iterator.ConnexionContainer;
import models.iterator.ConnexionIterator;
import models.iterator.ShapeContainer;
import models.iterator.ShapeIterator;

//----------------------------------------------------
//This class makes part of the Strategy Design Pattern
//----------------------------------------------------
public class XMLStrategy implements FileStrategy {

	@Override
	public void saveFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray) {
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

	@Override
	public void openFile(String filename, ShapeContainer shapeArray, ConnexionContainer connexionArray,
			AppController a) {

		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(filename);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			FileModel fm = new FileModel();
			EMRShapeModel item = null;
			EMRConnexionModel conn = null;
			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
				System.out.println("ggg");
				if (event.isStartElement()) {
					System.out.println("hhh");
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart().equals(EMRShapeFactory.SHAPE_XML_ID)) {
						item = new EMRShapeModel();
					}
					if (startElement.getName().getLocalPart().equals(EMRShapeFactory.LINE_ID)) {
						conn = new EMRConnexionModel();
					}

					if (event.isStartElement()) {
						if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.TYPE_XML_ID)) {
							event = eventReader.nextEvent();
							item.setType(event.asCharacters().getData());
							continue;
						}
					}
					if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.X_XML_ID)) {
						event = eventReader.nextEvent();
						item.setxPos(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.Y_XML_ID)) {
						event = eventReader.nextEvent();
						item.setyPos(Double.parseDouble(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.SHAPEHASH_XML_ID)) {
						event = eventReader.nextEvent();
						item.setHash(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
					if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.STARTSHAPE_XML_ID)) {
						event = eventReader.nextEvent();
						conn.setStartHash(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}

					if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.ENDSHAPE_XML_ID)) {
						event = eventReader.nextEvent();
						conn.setEndHash(Integer.parseInt(event.asCharacters().getData()));
						continue;
					}
				}
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart().equals(EMRShapeFactory.SHAPE_XML_ID)) {
						fm.getShapeArrayModels().add(item);
						continue;
					}
					if (endElement.getName().getLocalPart().equals(EMRShapeFactory.LINE_ID)) {
						fm.getShapeConnexionModels().add(conn);
						continue;
					}
				}
			}
			System.out.println(shapeArray);
			fm.toAppController(shapeArray, connexionArray, a);
		} catch (FileNotFoundException | XMLStreamException e) {
			e.printStackTrace();
		}

		
	}

}
