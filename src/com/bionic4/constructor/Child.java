package com.bionic4.constructor;

/**
 * Created by Bohdan on 27.10.2015.
 */
public class Child extends Parent {

    public Child() {
        this("name");
        System.out.println("No-args child constructor");
    }

    public Child(int i) {
        System.out.println("Constructor with int arg");
    }

    public Child(String val) {
        super(2);
        System.out.println("Constructor with string");
    }
}
