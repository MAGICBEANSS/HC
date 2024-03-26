package prc.hc.sessiontests.secondtest;

public class FindMaxIndex {

    public static void main(String[] args) {
        int[] arr1 = {};
        int[] arr2 = {};
        System.out.println(new FindMaxIndex().solve(arr1.length,arr1,arr2));
    }

    public String solve(int n, int[] a, int[] b) {
        int maxA = findMax(a);
        int maxB = findMax(b);
        int maxIndexA = findMaxIndex(a, maxA);
        int maxIndexB = findMaxIndex(b, maxB);

        // If the maximum elements are already at the last position, return "YES"
        if (maxIndexA == n - 1 && maxIndexB == n - 1) {
            return "YES";
        }

        // If the maximum elements are at different indices, swap them
        if (maxIndexA != maxIndexB) {
            swap(a, maxIndexA, n - 1);
            swap(b, maxIndexB, n - 1);
            return "YES";
        }

        // If the maximum elements are at the same index but not at the last position
        return "NO";
    }

    private int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private int findMaxIndex(int[] arr, int max) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == max) {
                return i;
            }
        }
        return -1; // This should never happen
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
