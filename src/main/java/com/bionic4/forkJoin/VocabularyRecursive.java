package com.bionic4.forkJoin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.RecursiveAction;


/**
 * Created by Sony on 06.12.2015.
 */
public class VocabularyRecursive extends VocabularyTemplate {



    public VocabularyRecursive(Map<String, Integer> result) {
        super(result);
    }

    public void calculate(File directoryFile) throws IOException {
        if (directoryFile.isFile() && directoryFile.getName().endsWith(".txt")) {
            calculateCurrentFile(directoryFile, result);
        } else if (directoryFile.isDirectory()) {
            File[] files = directoryFile.listFiles();
            for (File file : files) {
                calculate(file);
            }
        }
    }
}
