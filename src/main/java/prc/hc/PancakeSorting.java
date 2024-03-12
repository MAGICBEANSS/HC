package prc.hc;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {
    //https://leetcode.com/problems/pancake-sorting/description/

    public static void main(String[] args) {
        int[] arr = {3,2,4,1};
        pancakeSort(arr);

        int[] test = {1,3,2,4};
      //  System.out.println(getMaxNoNonSorted(test));

    }

    public static List<Integer> pancakeSort(int[] arr) {
        List<Integer> resultslist = new ArrayList<>();
        int k =0;
        while (!isSortedArray(arr)) {
            k++;
            int maxIndexNotSorted = getMaxNoNonSorted(arr);
            int maxNoNotSorted = maxIndexNotSorted+1;
            if(maxIndexNotSorted==0){
                return resultslist;
            }
            int toFlipIndex = findElementInArray(arr,maxNoNotSorted);
            if(toFlipIndex>0) {
                resultslist.add(toFlipIndex + 1);
                flipAroundK(arr, toFlipIndex);
            }
            resultslist.add(maxIndexNotSorted + 1);
            flipAroundK(arr, maxIndexNotSorted);
            System.out.println("Round "+k+" Done");
        }
        return resultslist;
    }

    private static int findElementInArray(int[] arr, int maxIndexNotSorted) {
        for(int i=0;i<=maxIndexNotSorted;i++) {
            if(arr[i]==maxIndexNotSorted) return i;
        }
        return -1;
    }

    private static void flipAroundK(int[] arr, int maxIndexNotSorted) {
        int n = arr.length;
        for (int i = 0; i <=maxIndexNotSorted/2; i++) {
                int no = arr[i];
                arr[i] = arr[maxIndexNotSorted-i];
                arr[maxIndexNotSorted-i] = no;
        }
    }

    private static int getMaxNoNonSorted(int[] arr) {
        int n = arr.length;
        int i = n-1;
        for ( i = n-1; i >=0 ; i--) {
            if(arr[i]!=i+1) return i;
        }
        return -1;
    }

    private static boolean isSortedArray(int[] arr) {
        boolean isSorted = true;
        for (int i = 1; i < arr.length && isSorted; i++) {
            if(arr[i]<arr[i-1]) isSorted=false;
        }
        return isSorted;
    }


}
