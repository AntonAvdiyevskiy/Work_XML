package com.marshall;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;


public class JavaToXML {
    public static void main(String[] args) throws Exception {
        JAXBContext context = JAXBContext.newInstance(University.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        Student student = new Student();

        University university = new University();
        university.setName("Nu Lp");
        student.setName("Anton");
        student.setSurname("Avdiyevskiy");
        student.setAge(20);
        student.setCourse(3);
        student.setRating(80);
        Department department1 = new Department();
        department1.setName("Computer Engineering");

        department1.getStudents().add(student);
        university.getDepartments().add(department1);


        m.marshal(university, new File("./univer.xml"));

    }

}
