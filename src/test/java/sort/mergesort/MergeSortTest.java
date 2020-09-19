package sort.mergesort;

import org.junit.Before;
import org.junit.Test;
import sort.mergesort.MergeSort;

import static org.junit.Assert.assertEquals;

public class MergeSortTest {

    private int[] arr;
    private MergeSort testInstance = new MergeSort();

    @Before
    public void setUp() {
        arr = new int[]{15, 5, 3, 11, 10};
    }

    @Test
    public void shouldPutMinValueOnFirstIndex() {
        testInstance.sort(arr);

        assertEquals(3, arr[0]);
    }

    @Test
    public void shouldPutMaxValueOnLastIndex() {
        testInstance.sort(arr);

        assertEquals(15, arr[4]);
    }

    @Test
    public void shouldPutMidValueInTheMiddle() {
        testInstance.sort(arr);

        assertEquals(10, arr[2]);
    }
}