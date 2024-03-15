package prc.hc;

public class FindMissing {
    public static void main(String[] args) {
        int[] arr = {3,0,1};
        int missing = missingNumber(arr);
        System.out.println(missing);
    }

    public static int missingNumber(int[] nums) {
        int sum1=0, sum2=nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum1^=i;
            sum2^=nums[i];
        }
        return sum1^sum2;
    }
}
