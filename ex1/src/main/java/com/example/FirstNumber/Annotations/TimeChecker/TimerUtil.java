package com.example.FirstNumber.Annotations.TimeChecker;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimerUtil {

    /**
     * Ищет в объекте методы, помеченные аннотацией @Timer,
     * и запускает их, передавая необходимые аргументы.
     * Измеряет и выводит время выполнения каждого метода.
     *
     * @param obj   Объект, в котором ищутся методы
     * @param args  Аргументы, которые будут переданы в методы
     * @throws Exception при ошибке вызова метода
     */
    public static void checkAndRunTimedMethod(Object obj, Object... args) throws Exception {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Timer.class)) {
                method.setAccessible(true);
                long startTime = System.currentTimeMillis();
                try {
                    // Вызываем метод с аргументами
                    Object result = method.invoke(obj, args);
                    long endTime = System.currentTimeMillis();
                    long elapsedTime = endTime - startTime;
                    System.out.println("Execution time of " + method.getName() + ": " + elapsedTime + " ms");
                } catch (InvocationTargetException e) {
                    throw new IllegalArgumentException(e.getCause().getMessage());
                }
            }
        }
    }


}
