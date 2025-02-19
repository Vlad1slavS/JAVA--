package com.example.FirstNumber.Annotations.TimeChecker;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.InvocationHandlerAdapter;
import net.bytebuddy.matcher.ElementMatchers;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ByteBuddyProxyFactory {
    public static <T> T createProxy(T obj) throws Exception {
        return (T) new ByteBuddy()
                .subclass(obj.getClass())
                .method(ElementMatchers.any())
                .intercept(InvocationHandlerAdapter.of(new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        if (method.isAnnotationPresent(Timer.class)) {
                            long startTime = System.currentTimeMillis();
                            Object result = method.invoke(obj, args);
                            long elapsedTime = System.currentTimeMillis() - startTime;
                            System.out.println("Execution time of " + method.getName() + ": " + elapsedTime + " ms");
                            return result;
                        }
                        return method.invoke(obj, args);
                    }
                }))
                .make()
                .load(obj.getClass().getClassLoader())
                .getLoaded()
                .getDeclaredConstructor()
                .newInstance();
    }
}


