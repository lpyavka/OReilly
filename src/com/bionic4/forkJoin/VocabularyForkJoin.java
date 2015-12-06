package com.bionic4.forkJoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveAction;

/**
 * Created by Sony on 06.12.2015.
 */
public class VocabularyForkJoin extends RecursiveAction {
    private File directoryName;
    private Map<String, Integer> result;

    public VocabularyForkJoin(File directoryName, Map<String, Integer> result) {
        this.directoryName = directoryName;
        this.result = result;
    }

    @Override
    protected void compute() {
        if (directoryName.isFile() && directoryName.getName().endsWith(".txt")) {
            try {
                calculateCurrentFile(directoryName, result);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (directoryName.isDirectory()) {
            File[] files = directoryName.listFiles();
            List<VocabularyForkJoin> vocabularyForkJoins = new ArrayList<VocabularyForkJoin>();

            for (File file : files) {
                VocabularyForkJoin vocabularyForkJoin = new VocabularyForkJoin(file, result);
                vocabularyForkJoins.add(vocabularyForkJoin);
            }
            for (VocabularyForkJoin vocabularyForkJoin : vocabularyForkJoins) {
                vocabularyForkJoin.fork();
            }
        }
    }


    protected void calculateCurrentFile(File fileName, Map<String, Integer> result) throws IOException {
        String line;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split(VocabularyTemplate.SPACE);
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
