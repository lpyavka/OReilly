package com.bionic4.Annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by Sony on 16.11.2015.
 */
public class Task {

    public static void main(String[] args) throws Exception {

        Class cl = Task.class;
        cl.getDeclaredMethods();

        for (Method method : cl.getDeclaredMethods()) {

            if (method.isAnnotationPresent(TaskWithAnnotation.class)) {

                Annotation annotation = method.getAnnotation(TaskWithAnnotation.class);
                TaskWithAnnotation taskWithAnnotation = (TaskWithAnnotation) annotation;

                System.out.println(taskWithAnnotation.info());
                method.invoke(cl.newInstance());
            }
        }
    }

    @TaskWithAnnotation
    void doSmth() {
        System.out.println("Smth smth smth smth");
    }
}


