import search.binarysearch.BinarySearchIteratively;
import search.binarysearch.BinarySearchRecursively;
import sort.insertionsort.InsertionSort;
import sort.mergesort.MergeSort;

import java.util.Arrays;
import java.util.logging.Logger;

public class BenchmarkTest {
    private static Logger log = Logger.getLogger(BenchmarkTest.class.getName());

    public static void main(String[] args) {

        int[] sortedArr = {2, 4, 6, 9, 23, 34, 56, 67, 68, 222, 256};
        int[] shuffledArr = {89, 23, 3, 13, 44, 10, 1, 111, 76, 10, 0, -3};
        int key = 23;

        doBinarySearchRecursively(sortedArr, key);

        doBinarySearchIteratively(shuffledArr, key);

        doMergeSort(shuffledArr);

        doInsertionSort(shuffledArr);
    }

    private static void doInsertionSort(int[] arr) {
        InsertionSort insertionSort = new InsertionSort();
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        insertionSort.sort(tempArr);
        long end = System.nanoTime();
        log.info("insertionSort result = " + Arrays.toString(tempArr) + ", time = " + +(end - start));
    }

    private static void doMergeSort(int[] arr) {
        MergeSort mergeSort = new MergeSort();
        int[] tempArr = Arrays.copyOf(arr, arr.length);
        long start = System.nanoTime();
        mergeSort.sort(tempArr);
        long end = System.nanoTime();
        log.info("MergeSort result = " + Arrays.toString(tempArr) + ", time = " + +(end - start));
    }

    private static void doBinarySearchIteratively(int[] arr, int key) {
        BinarySearchIteratively binarySearchIteratively = new BinarySearchIteratively();
        binarySearchIteratively.search(arr, key);
    }

    private static void doBinarySearchRecursively(int[] arr, int key) {
        BinarySearchRecursively binarySearchRecursively = new BinarySearchRecursively();
        long start = System.nanoTime();
        int search = binarySearchRecursively.search(arr, 0, arr.length, key);
        long end = System.nanoTime();
        log.info("BinarySearchRecursively result = " + search + ", time = " + +(end - start));
    }
}
