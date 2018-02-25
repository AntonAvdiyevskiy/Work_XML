package com.unmarshall;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;


public class XMLToJava {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(University.class);
            Unmarshaller u = jc.createUnmarshaller();
            File f = new File("src/main/myXML.xml");
            University university = (University) u.unmarshal(f);
            System.out.println(university.getName());
            System.out.println("departments:");
            List<Department>departments = university.getDepartments();
            for(Department dep:departments) {
                System.out.println(dep.getName());
                List<Student>students = dep.getStudents();
                System.out.println("students in "+dep.getName());
                for(Student student:students){
                    System.out.println(String.format("name: %s, surname: %s, age: %d, course: %d, rating: %.1f",student.getName()
                            ,student.getSurname(), student.getAge(),student.getCourse(),student.getRating()));
                }
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
