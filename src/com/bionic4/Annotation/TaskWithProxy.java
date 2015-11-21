package com.bionic4.Annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by Sony on 16.11.2015.
 */
public class TaskWithProxy {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new TaskWithAnnotationProxy();
        TaskAction proxy = (TaskAction) Proxy.newProxyInstance(TaskWithProxy.class.getClassLoader(),
                new Class[]{TaskAction.class}, invocationHandler);
        proxy.action();
    }

}

