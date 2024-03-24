package prc.hc.sorting;

import java.util.Arrays;


//https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/description/

public class MinMaxPairSumInArray {
    public static void main(String[] args) {
        int[] arr = {3,5,4,2,4,6};
        int max = minPairSum(arr);
        System.out.println("Max "+max);

    }

    public static int minPairSum(int[] nums) {
            mergesort(nums);
            int n = nums.length;
        System.out.println("Sorted array");
        Arrays.stream(nums).forEach(x->{
            System.out.print(x+" ");
        });
        System.out.println();
        int maxPair = nums[0]+nums[n-1];
        for (int i = 0; i < n && i<(n-1-i); i++) {
            int pairsum = nums[i]+nums[n-1-i];
            maxPair=Math.max(pairsum,maxPair);
        }
        return maxPair;
    }

    private static void mergesort(int[] nums) {
        if(nums.length<=1) return ;
        int n = nums.length;

        if(nums.length==2) {
            if(nums[0]>nums[1]) {
                int x = nums[0];
                nums[0] = nums[1];
                nums[1] = x;
            }
            return;
        }
        int firsthalfLength = n/2;
        int secondhalfLength = n-firsthalfLength;
        int[] firsthalf = new int[firsthalfLength];
        int[] secondhalf = new int[secondhalfLength];
        fillArray(nums,firsthalf,0,firsthalfLength-1);
        fillArray(nums,secondhalf,firsthalfLength,n-1);
        mergesort(firsthalf);
        mergesort(secondhalf);
        mergeBack(firsthalf,secondhalf,nums);



    }

    private static void mergeBack(int[] firsthalf, int[] secondhalf, int[] nums) {
        int i =0;
        int j = 0;
        int k =0;
        while (i<firsthalf.length && j < secondhalf.length) {
            if(firsthalf[i]<=secondhalf[j]) {
                nums[k]= firsthalf[i];
                i++;
            }
            else {
                nums[k]= secondhalf[j];
                j++;
            }
            k++;
        }

        while (i<firsthalf.length) {
            nums[k] = firsthalf[i];
            i++;
            k++;

        }
        while (j<secondhalf.length) {
            nums[k] = secondhalf[j];
            j++;
            k++;

        }
    }

    private static void fillArray(int[] nums, int[] toFill, int si, int li) {
        int k =0;
        for (int i = si; i <= li; i++) {
            toFill[k] = nums[i];
            k++;
        }
    }
}
