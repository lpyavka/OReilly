package com.bionic4.set;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sony on 21.11.2015.
 */
public class readFileMain {

    public static final String SPACE = "\\s+";

    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\workspace\\bionic\\Shevchenko.txt"));
        String line;
        Map<String, Integer> map = new HashMap();
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(SPACE);
            for (String word : strings) {
                System.out.println(word);
                if (map.get(word) == null) {
                    map.put(word, 1);
                } else {
                    Integer count = map.get(word);
                    map.put(word, count + 1);
                }
            }
        }
        System.out.println(map);
    }
}
