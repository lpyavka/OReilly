package com.bionic4.forkJoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Sony on 06.12.2015.
 */
public abstract class VocabularyTemplate {
    public static final String SPACE = "\\s+";
    protected Map<String, Integer> result;

    protected VocabularyTemplate(Map<String, Integer> result) {
        this.result = result;
    }



    protected void calculateCurrentFile(File fileName, Map<String, Integer> result) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(SPACE);
            for (String word : strings) {
                String key = word.toLowerCase();
                if (result.get(key) == null) {
                    result.put(key, 1);
                } else {
                    Integer count = result.get(key);
                    result.put(key, count + 1);
                }
            }
        }
    }
}
