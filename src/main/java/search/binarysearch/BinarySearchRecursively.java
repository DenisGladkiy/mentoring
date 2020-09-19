package search.binarysearch;

public class BinarySearchRecursively {
    public int search(int[] arr, int first, int last, int key) {
        if (last >= first) {
            int middle = (first + last) / 2;
            if (arr[middle] == key) {
                return middle;
            }
            if (arr[middle] > key) {
                return search(arr, first, middle - 1, key);
            }
            return search(arr, middle + 1, last, key);
        }
        return -1;
    }
}
