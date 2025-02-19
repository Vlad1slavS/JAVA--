package com.example.FirstNumber;

import java.lang.reflect.Array;
import java.util.function.Function;

public class ArrayUtils {

    public  <T> T[] FillArray(int size, long upper, long lower, Class<T> clazz) {
        // Создаем массив нужного типа
        T[] arr = (T[]) Array.newInstance(clazz, size);

        // Заполняем массив некоторыми значениями (пример)
        for (int i = 0; i < size; i++) {
            if (clazz == Integer.class) {
                arr[i] = clazz.cast((int) (Math.random() * (upper - lower) + lower)); // Пример заполнения случайными числами
            } else if (clazz == String.class) {
                arr[i] = clazz.cast("String " + i); // Пример заполнения строками
            }
            // Добавьте обработку других типов по мере необходимости
        }
        return arr; // Возвращаем заполненный массив
    }

    public static <T extends Comparable<T>> T[] fillArrayMonotone(
            int size,
            T initial,
            Function<T, T> generator,
            Class<T> clazz
    ) {
        if (size <= 0) throw new IllegalArgumentException("Size must be positive");

        T[] arr = (T[]) Array.newInstance(clazz, size);
        arr[0] = initial;

        for (int i = 1; i < size; i++) {
            arr[i] = generator.apply(arr[i-1]);
            if (arr[i].compareTo(arr[i-1]) <= 0) {
                throw new IllegalStateException("Array is not monotonic");
            }
        }
        return arr;
    }

    public static <T extends Comparable<T>> boolean isSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i-1]) <= 0) {
                return false;
            }
        }
        return true;
    }

}
