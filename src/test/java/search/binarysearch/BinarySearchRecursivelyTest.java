package search.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchRecursivelyTest {
    private int[] arr = {2, 5, 8, 11, 15};
    private BinarySearchRecursively testInstance = new BinarySearchRecursively();

    @Test
    public void shouldReturnFirstPosition() {
        int result = testInstance.search(arr, 0, arr.length, 2);

        assertEquals(0, result);
    }

    @Test
    public void shouldReturnLastPosition() {
        int result = testInstance.search(arr, 0, arr.length, 15);

        assertEquals(4, result);
    }

    @Test
    public void shouldReturnSecondPosition() {
        int result = testInstance.search(arr, 0, arr.length, 8);

        assertEquals(2, result);
    }

    @Test
    public void shouldReturnNegativeValue() {
        int result = testInstance.search(arr, 0, arr.length, 7);

        assertTrue(result < 0);
    }
}