package com.bionic4.generic;

import java.util.Objects;

/**
 * Created by Sony on 22.11.2015.
 */
public class Generic {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generic generic = new Generic();
        String string = doInstance(String.class);
        System.out.println(string);
        Customer customer = doInstance(Customer.class);
        System.out.println(customer);
        Customer o = (Customer)doInstance1(Customer.class);

    }


    public static <T> T doInstance(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    public static Object doInstance1(Class clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}

