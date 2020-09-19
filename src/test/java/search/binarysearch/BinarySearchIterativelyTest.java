package search.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BinarySearchIterativelyTest {
    private int[] arr = {2, 5, 8, 11, 15};
    private BinarySearchIteratively testInstance = new BinarySearchIteratively();

    @org.junit.Test
    public void shouldReturnFirstPosition() {
        int result = testInstance.search(arr,2);

        assertEquals(0, result);
    }

    @org.junit.Test
    public void shouldReturnLastPosition() {
        int result = testInstance.search(arr,15);

        assertEquals(4, result);
    }

    @org.junit.Test
    public void shouldReturnSecondPosition() {
        int result = testInstance.search(arr,8);

        assertEquals(2, result);
    }

    @Test
    public void shouldReturnNegativeValue() {
        int result = testInstance.search(arr,7);

        assertTrue(result < 0);
    }
}