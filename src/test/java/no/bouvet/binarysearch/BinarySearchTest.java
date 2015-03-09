package no.bouvet.binarysearch;


import org.junit.Test;

import static no.bouvet.binarysearch.BinarySearch.find;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {


    @Test
    public void not_found() throws Exception {
        int[] haystack = {};
        int index = find(3, haystack);
        assertEquals(-1, index);
    }

    @Test
    public void can_find_middle_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(6, haystack);
        assertEquals(2, index);
    }

    @Test
    public void can_find_element_below_middle() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(4, haystack);
        assertEquals(1, index);
    }

    @Test
    public void can_find_first_element() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(2, haystack);
        assertEquals(0, index);
    }

    @Test
    public void can_find_element_above_middle() throws Exception {
        int[] haystack = {2, 4, 6, 8, 10};
        int index = find(8, haystack);
        assertEquals(3, index);
    }
}
