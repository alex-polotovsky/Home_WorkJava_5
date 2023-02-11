/*Реализовать алгоритм пирамидальной сортировки (HeapSort).*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HeapSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите длину массива: ");
        int length = sc.nextInt();
        System.out.println("Введите максимальное число в массиве: ");
        int maxNumber = sc.nextInt();

        int[] unsortedNumbers = createArray(length, maxNumber);
        System.out.println("Unsorted: " + Arrays.toString(unsortedNumbers));

        heapSort(unsortedNumbers);
        System.out.println("Sorted: " + Arrays.toString(unsortedNumbers));
    }

    private static int[] createArray(int length, int maxNumber) {
        int[] array = new int[length];
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            array[i] = rand.nextInt(maxNumber + 1);
        }
        return array;
    }

    private static void heapSort(int[] arr) {
        int length = arr.length;
        //Строим кучу. Идём снизу.
        for (int i = (length / 2) - 1; i >= 0; i--) {
            heapify(arr, length, i);
        }
        //Меняем первый и последний элемент
        for (int i = length - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapify(arr, i, 0); //Восстанавливаем кучу без последнего элемента.
        }
    }

    private static void heapify(int[] arr, int length, int i) {
        //Сортировка выбором.
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;
        int maxIndex = i; // Корень малого треугольника.

        if (leftIndex < length && arr[leftIndex] > arr[maxIndex]) {
            maxIndex = leftIndex;
        }
        if (rightIndex < length && arr[rightIndex] > arr[maxIndex]) {
            maxIndex = rightIndex;
        }
        if (i != maxIndex) {
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;

            heapify(arr, length, maxIndex); //Проверяем, не сломалась ли куча внизу.
        }

    }
}
