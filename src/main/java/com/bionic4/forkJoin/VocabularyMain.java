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
    public static void main(String[] args) throws IOException, InterruptedException {
        /*String directoryName = "D:\\workspace";*/
        String directoryName = "D:\\workspace\\bionic\\ForkJoin";
        Map<String, Integer> result = new HashMap();

        File file = new File(directoryName);
        VocabularyRecursive vocabulary = new VocabularyRecursive(result);
        long start = System.currentTimeMillis();
        vocabulary.calculate(file);
        System.out.println(result);
        long finish = System.currentTimeMillis();
        System.out.println("process time " + (finish - start));

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        Map<String, Integer> result1 = new ConcurrentHashMap();

        VocabularyForkJoin vocabularyForkJoin = new VocabularyForkJoin(file, result1);
        long start1 = System.currentTimeMillis();
        forkJoinPool.invoke(vocabularyForkJoin);
        long finish1 = System.currentTimeMillis();
       /* TimeUnit.SECONDS.sleep(10);*/
        System.out.println(result1);
        System.out.println("process time " + (finish1 - start1));

    }
}
