package prc.hc;

import java.util.Arrays;

public class CountSmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int[] arr = {8,1,2,2,3};
        arr= smallerNumbersThanCurrent(arr);
        Arrays.stream(arr).forEach(x->{
            System.out.print(x+" ");
        });
        /**
         * There are three approaches to it
         * 1)Approach for : Brute force for every i->{0:n} i will lookup other elements
         * i.e. {i+1:n}, a nested loop , works but with complexity O(n*n) i.e O(n^2)
         *
         * 2)Approach 2 : Do sorting : It will change the order of elements , thus will impact order of results , so discarded
         * Else you can keep original copy , and find the last index of each element of original array in sorted array
         * thus will give me count
         * For .e.g .if arr= {8,1,2,2,3} sorted array is {1,2,2,3,8};
         * now we can iterate for original array {8,1,2,2,3} and pick elements one by one and find their last index in sorted array
         * As we will use binary searching it will take logN for each element , as there are n elemnts and we have to find for all ,
         * it will end up in O(nLogn) time sand On extra space for sorting
         *
         * 3)Approach 3: Use  count sort , It will take a huge amount of memory.
         * For every element we will count ints occurence in a counting sort array , now for each element
         * total no less than that is count of all such in counting sort array
         * It will take On time for finding and O(max) space
         */
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int maxsize = 1000000;
        int[] count = new int[maxsize];
        for (int i = 0; i < nums.length; i++) {
            int no = nums[i];
                count[no] = 1;

        }
        int[] preCalculate = new int[maxsize];
        preCalculate[0] = count[0];
        for (int i = 1; i < maxsize; i++) {
                preCalculate[i] = preCalculate[i - 1] + count[i];
        }
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i]=preCalculate[nums[i]]-1;
        }
        return result;

        }
}
