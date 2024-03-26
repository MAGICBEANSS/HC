package prc.hc.sessiontests.secondtest;

public class Solution {

    public static void main(String[] args) {

        int[] arr1 = {7};
        int[] arr2 = {7};
        int n = arr2.length;
        solve(n,arr1,arr2);
    }
    static void solve(int n, int[] a, int[] b) {
        //Write your code here;
        String result = canSatisfyConditions(n,a,b);
        System.out.println(result);

    }

    public static String canSatisfyConditions(int n, int[] a, int[] b) {
        // Find the indices of the maximum elements in each array
        int maxIndexA = findMaxIndex(a);
        int maxIndexB = findMaxIndex(b);

        // If the maximum elements are at different indices, swap them
        if (maxIndexA != maxIndexB) {
            swap(a, maxIndexA, n - 1);
            swap(b, maxIndexB, n - 1);
            return "YES";
        }

        // If the maximum elements are at the same index and already at the last position
        if (maxIndexA == n - 1) {
            return "YES";
        }

        // If the maximum elements are at the same index but not at the last position
        return "NO";
    }

    private static int findMaxIndex(int[] arr) {
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}