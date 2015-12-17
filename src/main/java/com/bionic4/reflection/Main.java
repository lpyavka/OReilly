package com.bionic4.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * Created by Sony on 14.11.2015.
 */
public class Main extends Child {
    public static void main(String[] args) throws Exception {
            Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your hello");
        String text = scanner.next();
        if ("Hello".equalsIgnoreCase(text)) {
            Class cl1 = Class.forName("com.bionic4.reflection.Main$HelloAction");
            Object world = cl1.newInstance();
            Method cl1Method = cl1.getMethod("hello");
            cl1Method.invoke(world);
        }
        System.out.println("Please enter your class");
        String nameClass = scanner.next();

        Class cl = Class.forName(nameClass);

        while (cl != null) {
            cl.newInstance();
            cl = cl.getSuperclass();
            System.out.println(cl);
        }
    }

    static class HelloAction {
        public void hello() {
            System.out.println("World");
        }
    }
}
