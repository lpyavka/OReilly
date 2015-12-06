package com.bionic4.set;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Sony on 06.12.2015.
 */
public class Test extends RecursiveTask<Long> {


    private long workLoad = 0;

    public Test(long workLoad) {
        this.workLoad = workLoad;
    }

    protected Long compute() {

        //if work is above threshold, break tasks up into smaller tasks
        if (this.workLoad > 16) {
            System.out.println("Splitting workLoad : " + this.workLoad);

            List<Test> subtasks =
                    new ArrayList<Test>();
            subtasks.addAll(createSubtasks());

            for (Test subtask : subtasks) {
                subtask.fork();
            }

            long result = 0;
            for (Test subtask : subtasks) {
                result += subtask.join();
            }
            return result;

        } else {
            System.out.println("Doing workLoad myself: " + this.workLoad);
            return workLoad * 3;
        }
    }

    private List<Test> createSubtasks() {
        List<Test> subtasks =
                new ArrayList<Test>();

        Test subtask1 = new Test(this.workLoad / 2);
        Test subtask2 = new Test(this.workLoad / 2);

        subtasks.add(subtask1);
        subtasks.add(subtask2);

        return subtasks;
    }
}

