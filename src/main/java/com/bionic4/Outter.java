package com.bionic4;

/**
 * Created by Bohdan on 27.10.2015.
 */
public class Outter {

    public static void main(String[] args) throws Exception {
        Outter main = new Outter();
        Class1 class1 = new Class1();
        doSmth(class1);
    }

    public static void doSmth(Anonymus anonymus) {
        anonymus.shouldImplement();
    }


}
