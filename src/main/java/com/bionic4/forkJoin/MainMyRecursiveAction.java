package com.bionic4.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by Sony on 06.12.2015.
 */
public class MainMyRecursiveAction {
    public static void main(String[] args) {
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(24);

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.invoke(myRecursiveAction);


    }
}
