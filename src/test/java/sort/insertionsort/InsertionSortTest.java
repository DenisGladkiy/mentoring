package sort.insertionsort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InsertionSortTest {
    private int[] arr;
    private InsertionSort testInstance = new InsertionSort();

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