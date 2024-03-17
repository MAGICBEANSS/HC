package prc.hc.codingAssignments;

import java.util.Vector;

public class kjmlk {


    public static void main(String[] args) {
        int[] arr = {2,6,11,9};
        Vector<Integer> vec = new Vector<Integer>();
        Vector<Integer> vec1 = new Vector<Integer>();
        vec.add(-2);
        vec.add(6);
        vec.add(11);
        vec.add(9);
        vec1.add(1);
        vec1.add(2);
        vec1.add(3);
        vec1.add(4);
     //   mergeSort(vec1,0,vec.size());
        System.out.println("Vector before sorting: " + vec1);

        mergeSort(vec1, 0, vec1.size() );

        System.out.println("Vector after sorting: " + vec1);
    }


    public static void mergeSort(Vector<Integer> vc, int left, int right) {
        if (left < right) {
            // Find the middle point
            int middle = left + (right - left) / 2;

            // Sort first and second halves
            mergeSort(vc, left, middle);
            mergeSort(vc, middle + 1, right);

            // Merge the sorted halves
            merge(vc, left, middle, right);
        }
    }

    private static void merge(Vector<Integer> vc, int left, int middle, int right) {
        // Create temporary vectors
        int n1 = middle - left + 1;
        int n2 = right - middle;

        Vector<Integer> leftArray = new Vector<>(n1);
        Vector<Integer> rightArray = new Vector<>(n2);

        // Copy data to temporary vectors
        for (int i = 0; i < n1; ++i)
            leftArray.add(vc.get(left + i));
        for (int j = 0; j < n2; ++j)
            rightArray.add(vc.get(middle + 1 + j));

        /* Merge the temporary vectors back into vc */
        int i = 0, j = 0; // Initial index of leftArray and rightArray
        int k = left; // Initial index of merged vc

        while (i < n1 && j < n2) {
            if (leftArray.get(i) <= rightArray.get(j)) {
                vc.set(k, leftArray.get(i));
                i++;
            } else {
                vc.set(k, rightArray.get(j));
                j++;
            }
            k++;
        }

        // Copy the remaining elements of leftArray, if any
        while (i < n1) {
            vc.set(k, leftArray.get(i));
            i++;
            k++;
        }

        // Copy the remaining elements of rightArray, if any
        while (j < n2) {
            vc.set(k, rightArray.get(j));
            j++;
            k++;
        }
    }
}
