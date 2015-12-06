package com.bionic4.forkJoin;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by Sony on 06.12.2015.
 */
public class VocabularyMain {
    public static void main(String[] args) throws IOException {
        String directoryName = "D:\\workspace\\bionic\\ForkJoin";
        Map<String, Integer> result = new HashMap();

        File file = new File(directoryName);
        VocabularyRecursive vocabulary = new VocabularyRecursive(result);
        vocabulary.calculate(file);
        System.out.println(result);

        ForkJoinPool forkJoinPool = new ForkJoinPool(10);
        Map<String, Integer> result1 = new ConcurrentHashMap<>();

        VocabularyForkJoin vocabularyForkJoin = new VocabularyForkJoin(file, result1);
        forkJoinPool.invoke(vocabularyForkJoin);
        System.out.println(result1);

    }
}
