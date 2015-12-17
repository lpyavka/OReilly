package com.bionic4.Annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Sony on 16.11.2015.
 */
public class TaskWithAnnotationProxy implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(TaskWithAnnotation.class)) {
            TaskWithAnnotation annotation = method.getAnnotation(TaskWithAnnotation.class);
            System.out.println(annotation.info());

        }
        return null;
    }
}
