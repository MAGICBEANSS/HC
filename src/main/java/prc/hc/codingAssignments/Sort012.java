package prc.hc.codingAssignments;

public class Sort012 {

    public static void main(String[] args) {
        int[] arr = {2,1,0,0,0,0,1,0};
        dutchFlagSort(arr,arr.length);
    }

    public static void dutchFlagSort(int[] nums, int n) {
        //Write your code here
        int i =0,j=0,k=n-1;
        while (j<k){
            int no = nums[j];
            if(no==0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j]=temp;
                i++;j++;
            }
            else if(no==1) {
                j++;
            }
            else {
                int temp = nums[k];
                nums[k] = nums[j];
                nums[j]=temp;
                j++;k--;
            }
        }
        for (int l = 0; l < nums.length; l++) {
            System.out.print(nums[l]+" ");
        }


    }
}
