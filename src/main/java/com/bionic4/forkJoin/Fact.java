package com.bionic4.forkJoin;

/**
 * Created by Sony on 06.12.2015.
 */
public class Fact {
    public static void main(String[] args) {
        Fact fact = new Fact();
        System.out.println(fact.factorial(5));

    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * (factorial(n - 1));

        }
    }
}

