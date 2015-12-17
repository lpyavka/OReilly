package com.bionic4.inputOutput;

/**
 * Created by Sony on 09.11.2015.
 */
public class Kl implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Resource closed");
        }

        public void method() {
            System.out.println("Hello");
        }

        public static void main(String[] args) {
            try {
                Kl kl = new Kl();
                try {
                    kl.method();
                } finally {
                    kl.close();
                }
            } catch (Exception e) {
                System.out.println("Sorry");
            }

        }
    }

