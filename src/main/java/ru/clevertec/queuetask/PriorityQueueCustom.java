package ru.clevertec.queuetask;

import java.util.*;

public class PriorityQueueCustom<T> {
    private Comparator comparator = null;
    private int size = 0;
    private int arrSize = 9; // 0-element uses as exchanger
    private T[] arr = (T[]) new Object[arrSize];

    public PriorityQueueCustom(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public PriorityQueueCustom() {
        this.comparator = Comparator.naturalOrder();
    }

    public void push(T value) {
        if (size == arrSize - 1) {
            arrSize *= 1.5;
            arr = Arrays.copyOf(arr, arrSize);
        }
        arr[++size] = value;
        if (size > 1) {
            siftUp();
        }
    }

    private void siftUp() {
        int j = size;
        do {
            int p = j >>> 1;
            int compare = comparator.compare(arr[p], arr[j]);
            if (compare > 0) {
                swap(p, j);
            } else {
                return;
            }
            j = p;
        } while (j > 1);
    }

    public T peek() {
        T res = null;
        if (size > 0) {
            res = arr[1];
        }
        return res;
    }

    public T poll() {
        T res = null;
        if (size > 0) {
            res = arr[1];
            arr[1] = arr[size];
            arr[size--] = null;
            siftDown();
        }
        return res;
    }

    private void siftDown() {
        int i = 1;
        while (i * 2 < size) {
            int left = i << 1;
            int right = (i << 1) + 1;
            int j = left;
            if (right <= size && comparator.compare(arr[right], arr[left]) < 0) {
                j = right;
            }
            if (comparator.compare(arr[i], arr[j]) > 0) {
                swap(i, j);
            } else {
                return;
            }
            i = j;
        }
    }

    private void swap(int i, int j) {
        arr[0] = arr[i];
        arr[i] = arr[j];
        arr[j] = arr[0];
    }

    public void showElements() {
        for (int i = 1; i <= size; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }
}

