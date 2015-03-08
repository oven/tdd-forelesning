package no.bouvet.binarysearch;

import org.junit.Test;

import static no.bouvet.binarysearch.BinarySearch.find;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void can_find_middle_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(6, haystack);
        assertEquals(2, index);
    }

    @Test
    public void can_find_lower_quarter_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(4, haystack);
        assertEquals(1, index);
    }

    @Test
    public void can_find_upper_quarter_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(8, haystack);
        assertEquals(3, index);
    }

    @Test
    public void can_find_first_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(2, haystack);
        assertEquals(0, index);
    }

    @Test
    public void can_find_last_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(10, haystack);
        assertEquals(4, index);
    }

    @Test
    public void can_find_any_element() throws Exception {
        int[] haystack = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        for (int i = 0; i < 11; i++) {
            int index = find(i, haystack);
            assertEquals(i, index);
        }
    }

}
