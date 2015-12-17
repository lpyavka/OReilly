package com.bionic4.inner;

/**
 * Created by Bohdan on 27.10.2015.
 */
public class Main extends Class1 {

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        Inner inner = main.new Inner();
        inner.innerMethod();
    }

    public class Inner extends Class2 {
        int innerField;

        public Inner() {
            innerField = 10;
        }
        public void innerMethod() {
            method1();
            method2();
        }
    }
}
