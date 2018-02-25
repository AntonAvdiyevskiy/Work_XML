package com.saxparser;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
    String element;
    @Override
    public  void startDocument()throws SAXException{
        System.out.println("start parsing...");
    }
    @Override
    public  void endDocument()throws SAXException{
        System.out.println("end parsing...");
    }
    @Override
    public  void startElement(String namespace, String localName, String qName, Attributes atr){


            System.out.println(qName+":");

    }
    @Override
    public  void endElement (String namespace, String localName, String qName)throws SAXException{

    }
    @Override
    public  void characters (char[] chars,int start,int end)throws SAXException{
        String str = new String(chars,start,end);
        System.out.println(str);
    }
}


