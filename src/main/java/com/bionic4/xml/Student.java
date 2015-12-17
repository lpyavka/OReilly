package com.bionic4.xml;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Sony on 12.12.2015.
 */
@XmlRootElement
public class Student {
    private String name;
    private int age;
   private  int id;
    private String faculty;

    public Student(String name, int age, int id, String faculty) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.faculty = faculty;
    }
    public Student(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Student{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", id=").append(id);
        sb.append(", faculty='").append(faculty).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
