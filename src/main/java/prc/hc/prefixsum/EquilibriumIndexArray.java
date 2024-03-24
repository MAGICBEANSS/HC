package prc.hc.prefixsum;

public class EquilibriumIndexArray {

    //Equilibrium index of an array
    //https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=bottom_sticky_on_article
    public static void main(String[] args) {
       // int[] arr = {1,3,5,2,2};
        int[] arr = {4,5,7};
        int point = findEqilibirium(arr);
        System.out.println(point);

    }

    private static int  findEqilibirium(int[] arr) {
        if(arr.length==1) return 0;
        if(arr.length==2) return arr[1]==arr[0] ? 0:-1;
        int n = arr.length;
        int[] sum = new int[n];
        sum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            sum[i]=sum[i-1]+arr[i];
        }
        int totalsum = sum[n-1];
        for (int i = 1; i < n; i++) {
            if(sum[i-1]==totalsum-sum[i]) return i+1;
        }
        return -1;

    }
}
