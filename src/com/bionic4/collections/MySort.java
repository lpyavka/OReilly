package com.bionic4.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Sony on 11.11.2015.
 */
public class MySort {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(5, "Lena"));
        students.add(new Student(2, "Rona"));
        students.add(new Student(9, "Kim"));
        students.add(new Student(7, "Zifrik"));
        students.add(new Student(7, "Ostap"));
        students.add(new Student(7, "Zifrik"));
        students.add(new Student(2, null));
        System.out.println(students);
        Collections.sort(students);
        System.out.println();
        System.out.println(students);
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.name == null) {
                    return -1;
                } else if (student2.name == null) {
                    return 1;
                }
                return (student1.name.compareTo(student2.name));
            }
        });
        System.out.println(students);
    }


    static class Student implements Comparable<Student> {
        private final int id;
        private final String name;

        Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public int compareTo(Student student) {
            if (this.id < student.id) {
                return -1;
            } else if (this.id > student.id) {
                return 1;
            } else if (this.name == null) {
                if (student.name == null) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                return this.name.compareTo(student.name);
            }
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}
