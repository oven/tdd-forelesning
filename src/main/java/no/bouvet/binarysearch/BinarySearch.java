package no.bouvet.binarysearch;

public class BinarySearch {

    public static int find(int needle, int[] haystack) {

        int low = 0;
        int high = haystack.length;

        for (int i = 0; i < log2(haystack.length) + 1; i++) {
            int middle = (high + low) / 2;
            if (haystack[middle] == needle) return middle;
            if (haystack[middle] > needle) high = middle;
            if (haystack[middle] < needle) low = middle;
        }
        return -1;
    }

    private static int log2(int n) {
        return (int) (Math.log(n) / Math.log(2));
    }

}
