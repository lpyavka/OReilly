package com.bionic4.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by Sony on 12.12.2015.
 */
public class MyStudent {
    public static void main(String[] args) throws FileNotFoundException, JAXBException {

        Student student1 = new Student("John", 23, 1, "Math");
        Student student2 = new Student("Rage", 29, 2, "Physics");
        Student student3 = new Student("Elton", 15, 3, "Franch");
        Student student4 = new Student("Mart", 30, 5, "Java");

        File file = new File("D:\\workspace\\bionic\\student.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        jaxbMarshaller.marshal(student1, file);
        jaxbMarshaller.marshal(student1, System.out);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Student student = (Student) jaxbUnmarshaller.unmarshal(file);
        System.out.println(student);


       /* FileOutputStream out = new FileOutputStream("my_student.xml");
        XMLEncoder xmlEncoder = new XMLEncoder(out);
        xmlEncoder.writeObject(student1);
        xmlEncoder.flush();
        xmlEncoder.close();

        FileInputStream in = new FileInputStream("my_student.xml");
        XMLDecoder xmlDecoder = new XMLDecoder(in);
        Stude restoredStudent = (Student) xmlDecoder.readObject();
        xmlDecoder.close();*/


    }
}
