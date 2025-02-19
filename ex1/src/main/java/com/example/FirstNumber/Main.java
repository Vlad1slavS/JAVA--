package com.example.FirstNumber;

import com.example.FirstNumber.Annotations.TimeChecker.TimerUtil;

import java.util.Arrays;
import java.util.Random;

public class Main {

    private static Search search = new Search(); // Объект, в котором ищутся методы
    private static ArrayUtils arrayUtils = new ArrayUtils();
    private static final Random random = new Random();

    public static void main(String[] args) throws Exception {

        Integer[] integerArray = arrayUtils.FillArray(10000000, 500, 1, Integer.class);

        Integer[] monotoneArray = arrayUtils.fillArrayMonotone(10000000, 5, prev -> prev + random.nextInt(100) + 1, Integer.class);

        TimerUtil.checkAndRunTimedMethod(search, monotoneArray, 499);




    }

}
