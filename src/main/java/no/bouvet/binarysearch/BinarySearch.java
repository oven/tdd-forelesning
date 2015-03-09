package no.bouvet.binarysearch;

public class BinarySearch {
    public static int find(int needle, int[] haystack) {
        if (haystack.length == 0) return -1;

        int high = haystack.length;
        int low = 0;

        for (int i = 0; i < log2(haystack.length) + 1; i++) {
            int middle = (high + low) / 2;
            int found = haystack[middle];
            if (found == needle) return middle;
            if (needle < found) high = middle;
            if (needle > found) low = middle;
        }

        return -1;
    }

    private static int log2(int length) {
        return (int) (Math.log(length) / Math.log(2));
    }
}
