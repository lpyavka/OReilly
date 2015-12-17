package com.bionic4.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Created by Sony on 12.12.2015.
 */
public class MyStudentDeconvert {
    public static void main(String[] args) throws JAXBException {
        File file = new File("D:\\workspace\\bionic\\student.xml");

        JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Student student = (Student) jaxbUnmarshaller.unmarshal(file);
        System.out.println(student);

    }
}
