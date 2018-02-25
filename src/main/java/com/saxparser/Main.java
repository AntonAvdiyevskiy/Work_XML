package com.saxparser;


import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class Main {
    public static  void main(String[]args){
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        Handler handler = new Handler();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new File("src/main/myXML.xml"),handler);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
