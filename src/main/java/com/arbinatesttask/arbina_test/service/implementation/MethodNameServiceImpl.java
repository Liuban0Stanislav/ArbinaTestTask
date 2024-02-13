package com.arbinatesttask.arbina_test.service.implementation;

public class MethodNameServiceImpl {

    public static String getCurrentMethodName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getMethodName();
    }

    public static String getCurrentClassName() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        return stackTraceElements[2].getClassName();
    }
}
