package search.binarysearch;

import sort.Sort;
import sort.insertionsort.InsertionSort;
import sort.mergesort.MergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class BinarySearchIteratively {
    private Logger log = Logger.getLogger(BinarySearchIteratively.class.getName());
    private List<Sort> sorts = Arrays.asList(new InsertionSort(), new MergeSort());

    public int search(int[] arr, int key) {
        int result = 0;
        for (Sort sort : sorts) {
            int[] tempArr = Arrays.copyOf(arr, arr.length);
            long start = System.nanoTime();
            sort.sort(tempArr);
            result = binarySearch(tempArr, key);
            long end = System.nanoTime();
            log.info("BinarySearchIteratively with " + sort.getClass().getName() + " result = " + result + " time = " +
                    (end - start));
        }
        return result;
    }

    private int binarySearch(int[] arr, int key) {
        int first = 0;
        int last = arr.length - 1;
        while (first <= last) {
            int middle = (first + last) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] > key) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }
        return -1;
    }
}
