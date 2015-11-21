package com.bionic4.inputOutput;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sony on 09.11.2015.
 */
public class ScanWr {
    public static void main(String[] args) {

        File file = new File("test32.doc");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();

        try {
            FileWriter wrt = null;
            try {
                wrt = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            wrt.write(str);
            wrt.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
