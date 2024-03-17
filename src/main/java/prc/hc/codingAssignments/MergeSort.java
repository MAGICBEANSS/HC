/*
package prc.hc.codingAssignments;

import java.util.Vector;

public class MergeSort {

    public static void mergeSort(Vector<Integer> vc, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(vc, left, mid);
            mergeSort(vc, mid + 1, right);
            merge(vc, left, mid, right);
        }
    }

    public static void merge(Vector<Integer> vc, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        Vector<Integer> L = new Vector<>();
        Vector<Integer> R = new Vector<>();

        // Copy data to temporary arrays L[] and R[]
        for (int i = 0; i < n1; ++i)
            L.add(vc.get(left + i));
        for (int j = 0; j < n2; ++j)
            R.add(vc.get(mid + 1 + j));

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            if (L.get(i) <= R.get(j)) {
                vc.set(k, L.get(i));
                i++;
            } else {
*/
