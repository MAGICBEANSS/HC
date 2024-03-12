package prc.hc;

public class MaxProductBetweenTwoArrays {


    //https://leetcode.com/problems/maximum-product-difference-between-two-pairs/description/

    public static void main(String[] args) {
        int[] arr = {1,6,7,5,2,4,10,6,4};
       // int[] arr = {4,2,5,9,7,4,8};
        maxProductDifference(arr);

    }

    public static int maxProductDifference(int[] nums) {
        if(nums.length<4) return -1;
        int max1 = nums[0];
        int max2 = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>=max1) {
                max2 = max1;
                max1 = nums[i];
            }
            else if(nums[i]>=max2) {
                max2 = nums[i];
            }
        }
        int min1 = nums[0];
        int min2 = nums[1];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<=min1) {
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i]<min2) {
                min2 = nums[i];
            }
        }
        System.out.println("max1 ="+max1+" max2 = "+max2+" min1="+min1+" min2="+min2);
        int maxDiff =  ((max1*max2)-(min1*min2));
        System.out.println(maxDiff);
        return maxDiff;
    }
}
