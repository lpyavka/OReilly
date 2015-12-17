package com.bionic4.inputOutput;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Buffered {


    public static void main(String[] args) {
        final String FILENAME = "D:\\workspace\\bionic\\bufferedReader.txt";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String st;
        try {
            while ((st = br.readLine()) != null) {
                System.out.println(st);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
try(BufferedReader br = new BufferedReader(new FileReader("C:\SomeDir\notes3.txt")))*/
