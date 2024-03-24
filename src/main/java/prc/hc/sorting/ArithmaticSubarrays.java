package prc.hc.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmaticSubarrays {
    //https://leetcode.com/problems/arithmetic-subarrays/description/

    /**
     * [-3,-6,-8,-4,-2,-8,-6,0,0,0,0]
     * 5,4,3,2,4,7,6,1,7
     * [6,5,6,3,7,10,7,4,10]
     *
     *    4,-2,-8,-6,0
     *   -8 -6 -2 4 0
     *
     *         int[] nums = {4,6,5,9,3,7};
     *         int[] l = {0,0,2};
     *         int[] r = {2,3,5};
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-3,-6,-8,-4,-2,-8,-6,0,0,0,0};
        int[] l = {4};
        int[] r = {7};
        List<Boolean> sols = checkArithmeticSubarrays(nums,l,r);
        System.out.println();
        sols.stream().map(x->x+" ").forEach(System.out::print);
    }

    public static List<Boolean> checkArithmeticSubarrays(int[] copy, int[] l, int[] r) {

        int q= l.length;
        int n = copy.length;
        List<Boolean> results = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            System.out.println();
            int[] nums = Arrays.copyOf(copy,copy.length);
            quickSort(nums,l[i],r[i]);
            for (int o = l[i];o<=r[i];o++){
                System.out.print(nums[o]+" ");
            }
            Boolean check = checkDifference(nums,l[i],r[i]);
            results.add(check);
        }
        return results;

    }

    private static Boolean checkDifference(int[] nums, int i, int j) {
        boolean result = true;
        int diff = nums[i+1]-nums[i];
        for (int k = i+2; k <= j && result; k++) {
            int currdiff = nums[k]-nums[k-1];
            if(currdiff!=diff) result=false;

        }
        return result;
    }


    private static void quickSort(int[] nums, int low, int high) {
        if(nums.length==1 || high-low<1) return;
        if(high-low==1) {
            if(nums[high]<nums[low]) {
                int no = nums[low];
                nums[low] = nums[high];
                nums[high] = no;
            }
            return;
        }
        int pivot = nums[high];
        int i =low-1;
        int j = low;
        while (j<high) {
            if(nums[j]<pivot){
                i++;
                int ino = nums[i];
                nums[i] = nums[j];
                nums[j] = ino;
            }
            j++;
        }
        if(i<high) {
            nums[high] = nums[i + 1];
            nums[i + 1] = pivot;
        }
        quickSort(nums,low,i);
        quickSort(nums,i+2,high);
        //swap at i+1 location with pivot i.e. i+1 and high should be swapped
    }
}
