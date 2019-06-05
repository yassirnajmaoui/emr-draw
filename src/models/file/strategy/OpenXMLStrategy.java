package models.file.strategy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import controllers.AppController;
import models.EMRShapeFactory;
import models.file.EMRConnexionModel;
import models.file.EMRShapeModel;
import models.file.FileModel;
import models.iterator.ConnexionContainer;
import models.iterator.ShapeContainer;

public class OpenXMLStrategy implements OpenStrategy {

	@Override
	public void open(ShapeContainer shapeArray, ConnexionContainer connexionArray, AppController a) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * @Override public void open(String filename, ShapeContainer shapeArray,
	 * ConnexionContainer connexionArray, AppController a) {
	 * 
	 * try { // First, create a new XMLInputFactory XMLInputFactory inputFactory =
	 * XMLInputFactory.newInstance(); // Setup a new eventReader InputStream in =
	 * new FileInputStream(filename); XMLEventReader eventReader =
	 * inputFactory.createXMLEventReader(in); // read the XML document FileModel fm
	 * = new FileModel(); EMRShapeModel item = null; EMRConnexionModel conn = null;
	 * while (eventReader.hasNext()) { XMLEvent event = eventReader.nextEvent();
	 * System.out.println("ggg"); if (event.isStartElement()) {
	 * System.out.println("hhh"); StartElement startElement =
	 * event.asStartElement(); // If we have an item element, we create a new item
	 * if
	 * (startElement.getName().getLocalPart().equals(EMRShapeFactory.SHAPE_XML_ID))
	 * { item = new EMRShapeModel(); } if
	 * (startElement.getName().getLocalPart().equals(EMRShapeFactory.LINE_ID)) {
	 * conn = new EMRConnexionModel(); }
	 * 
	 * if (event.isStartElement()) { if
	 * (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * TYPE_XML_ID)) { event = eventReader.nextEvent();
	 * item.setType(event.asCharacters().getData()); continue; } } if
	 * (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * X_XML_ID)) { event = eventReader.nextEvent();
	 * item.setxPos(Double.parseDouble(event.asCharacters().getData())); continue; }
	 * 
	 * if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * Y_XML_ID)) { event = eventReader.nextEvent();
	 * item.setyPos(Double.parseDouble(event.asCharacters().getData())); continue; }
	 * 
	 * if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * SHAPEHASH_XML_ID)) { event = eventReader.nextEvent();
	 * item.setHash(Integer.parseInt(event.asCharacters().getData())); continue; }
	 * if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * STARTSHAPE_XML_ID)) { event = eventReader.nextEvent();
	 * conn.setStartHash(Integer.parseInt(event.asCharacters().getData()));
	 * continue; }
	 * 
	 * if (event.asStartElement().getName().getLocalPart().equals(EMRShapeFactory.
	 * ENDSHAPE_XML_ID)) { event = eventReader.nextEvent();
	 * conn.setEndHash(Integer.parseInt(event.asCharacters().getData())); continue;
	 * } } // If we reach the end of an item element, we add it to the list if
	 * (event.isEndElement()) { EndElement endElement = event.asEndElement(); if
	 * (endElement.getName().getLocalPart().equals(EMRShapeFactory.SHAPE_XML_ID)) {
	 * fm.getShapeArrayModels().add(item); continue; } if
	 * (endElement.getName().getLocalPart().equals(EMRShapeFactory.LINE_ID)) {
	 * fm.getShapeConnexionModels().add(conn); continue; } } }
	 * System.out.println(shapeArray); fm.toAppController(shapeArray,
	 * connexionArray, a); } catch (FileNotFoundException | XMLStreamException e) {
	 * e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */

}

