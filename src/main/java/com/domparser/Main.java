package com.domparser;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        String name, surname = "";
        int age, course = 0;
        double rating = 0;


        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(new File("src/main/myXML.xml"));
            NodeList products = document.getElementsByTagName("student");
            Element element = document.getDocumentElement();
            String univer = element.getNodeName();
            System.out.println(univer);

            for (int i = 0; i < products.getLength(); i++) {
                Element el = (Element) products.item(i);
                name = el.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                surname = el.getElementsByTagName("surname").item(0).getChildNodes().item(0).getNodeValue();
                age = Integer.parseInt(el.getElementsByTagName("age").item(0).getChildNodes().item(0).getNodeValue());
                course = Integer.parseInt(el.getElementsByTagName("course").item(0).getChildNodes().item(0).getNodeValue());
                rating = Double.parseDouble(el.getElementsByTagName("rating").item(0).getChildNodes().item(0).getNodeValue());
                String department = el.getParentNode().getAttributes().getNamedItem("name").getNodeValue();
                System.out.println(String.format("department: %s, name: %s, surname: %s, age: %d, course: %d, rating: %.1f", department,
                        name, surname, age, course, rating));

            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
