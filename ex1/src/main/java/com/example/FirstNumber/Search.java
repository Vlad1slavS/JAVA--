package com.example.FirstNumber;

import com.example.FirstNumber.Annotations.TimeChecker.Timer;

public class Search {

    @Timer // Аннотируем метод для измерения времени
    public int sequentialSearch(Integer[] sortedArray, int valueToFind) {
        for (int i : sortedArray) {
            if (i == valueToFind) {
                return i;
            }
        }
        throw new IllegalArgumentException("Element not found");
    }
    @Timer
    public int binarySearch(Integer[] sortedArray, int valueToFind) {
        int left = 0;
        int right = sortedArray.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (sortedArray[middle] == valueToFind) {
                return middle;
            } else if (sortedArray[middle] < valueToFind) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
       throw new IllegalArgumentException("Element not found");
    }
}
