package com.marshall;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType(propOrder = {"name","departments"})
@XmlRootElement
public class University {
    private String name;
    private List<Department> departments = new ArrayList<Department>();

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public void setName(String name) {
        this.name = name;
    }
}
