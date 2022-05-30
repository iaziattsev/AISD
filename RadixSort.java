package Programming;

import java.io.*;
import java.util.*;

public class RadixSort {

    // Функция для получения максимального значения в массиве arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // Функция для сортировки массива arr[] согласно
    // предаставленной цифре
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // массив на выходе
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Хранение количества вхождений в массиве count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Изменяем count[i], так что  count[i] сейчас содержит
        // актуальную позицию в массиве output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Строим выходной массив
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Копируем выходящий массив в arr[], так что arr[] сейчас
        // содержит отсортированные числа в соответствии с текущей цифрой
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // Главная функция для сортировки массива arr[] размера n,
    // используя Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Находим максимальное число, чтобы знать номер цифры
        int m = getMax(arr, n);

        // Делаем сортировку для каждой цифры.
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    // Функция для печати массива
    static void print(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    // Тест код
    public static void main(String[] args)
    {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int n = arr.length;

        radixsort(arr, n);
        print(arr, n);
    }
}