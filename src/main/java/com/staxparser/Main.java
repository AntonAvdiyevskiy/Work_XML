package com.staxparser;


import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        boolean bName = false;
        boolean bSName = false;
        boolean bAge = false;
        boolean bCourse = false;
        boolean bRaiting = false;
        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLEventReader eventReader =
                    factory.createXMLEventReader(
                            new FileReader("src/main/myXML.xml"));

            while(eventReader.hasNext()){
                XMLEvent event = eventReader.nextEvent();
                switch(event.getEventType()){
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("university")) {
                            System.out.println("Start Element : university");
                            Iterator<Attribute> attributes = startElement.getAttributes();

                        } else if (qName.equalsIgnoreCase("department")) {
                            System.out.println("Start Element : department");
                            Iterator<Attribute> attributes = startElement.getAttributes();
                            System.out.println(attributes.next().getValue());

                        }
                        else if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase("surname")) {
                            bSName = true;
                        } else if (qName.equalsIgnoreCase("age")) {
                            bAge = true;
                        }
                        else if (qName.equalsIgnoreCase("course")) {
                            bCourse = true;
                        }
                        else if (qName.equalsIgnoreCase("rating")) {
                            bRaiting = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if(bName){
                            System.out.println("name: "
                                    + characters.getData());
                            bName = false;
                        }
                        if(bSName){
                            System.out.println("surname: "
                                    + characters.getData());
                            bSName = false;
                        }
                        if(bAge){
                            System.out.println("age: "
                                    + characters.getData());
                            bAge = false;
                        }
                        if(bCourse){
                            System.out.println("course: "
                                    + characters.getData());
                            bCourse = false;
                        }
                        if(bRaiting){
                            System.out.println("rating: "
                                    + characters.getData());
                            bRaiting = false;
                        }
                        break;
                    case  XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if(endElement.getName().getLocalPart().equalsIgnoreCase("student")){
                            System.out.println("End Element : student");
                            System.out.println();
                        }
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
