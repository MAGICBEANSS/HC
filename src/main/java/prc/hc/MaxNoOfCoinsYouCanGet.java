package prc.hc;

import java.util.Arrays;

public class MaxNoOfCoinsYouCanGet {

    //https://leetcode.com/problems/maximum-number-of-coins-you-can-get/description/

    public static void main(String[] args) {
        int[] arr ={2,4,5};
            maxCoins(arr);
    }

    public static int maxCoins(int[] arr) {
        int n = arr.length;
        int div = n/3;
        //Arrays.sort(arr);
        mergeSort(arr);
        int sum = 0;
        int j =n-2;
        while (j>0 && div>0) {
            div--;
            sum += arr[j];
            j=j-2;
        }
        System.out.println(sum);
        return sum;
    }

    private static void mergeSort(int[] arr) {
        if(arr.length==1) return;
        if(arr.length==2) {
            if(arr[1]<arr[0]) {
                int no = arr[0];
                arr[0] = arr[1];
                arr[1] = no;
            }
            return;
        }
        int n = arr.length;
        int fhl = n/2;
        int shl = n-fhl;
        int[] fha = new int[fhl];
        int[] sha = new int[shl];
        fillArrayNos(fha,arr,0,fhl);
        fillArrayNos(sha,arr,fhl,n);
        mergeSort(fha);
        mergeSort(sha);
        combineArrays(fha,sha,arr);

    }

    private static void combineArrays(int[] fha, int[] sha, int[] arr) {
        int fhl = fha.length;
        int shl = sha.length;
        int n = arr.length;
        int i =0;
        int j =0;
        while (i<fhl && j< shl) {
            if(fha[i]>sha[j]) {

            }
        }
    }

    private static void fillArrayNos(int[] tofill, int[] arr, int si, int li) {
        int k =0;
        for (int i = si; i < li; i++,k++) {
            tofill[k] = arr[i];
        }
    }


}
