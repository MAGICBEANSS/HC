package prc.hc.codingassignments;

import java.util.Vector;

public class PeakElement {
    public static void main(String[] args) {

    }

        public int indexMaxElement(Vector<Integer> vector) {

            int[] array = new int[vector.size()];
            for (int i = 0; i < vector.size(); i++) {
                array[i] = vector.get(i);
            }
            int len = array.length;
            int n = len-1;
            int high = n;
            int low = 0;
            while (low<=high) {
                int mid = (low+high)/2;
                int prevIndex = (mid-1+n)%n;
                int nextIndex = (mid+1)%n;
                if(array[mid]>array[prevIndex] && array[mid]>array[nextIndex]) {
                    
                }
            }
        return -1;
        }

}
