package prc.hc.codingAssignments;

public class problem3 {


    public static void main(String[] args) {
        long[] arr ={8 ,4 ,2 ,1 ,5 ,3};
        long z = inversionCount(arr,arr.length);
        System.out.println(z);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]+" ");
        }

    }
    public static long inversionCount(long[] arr, int N) {
        long[] temp = new long[N];
        return mergeSortAndCount(arr, temp, 0, N - 1);
    }

    private static long mergeSortAndCount(long[] arr, long[] temp, int left, int right) {
        long inversionCount = 0;

        if (left < right) {
            int middle = left + (right - left) / 2;

            inversionCount += mergeSortAndCount(arr, temp, left, middle);

            inversionCount += mergeSortAndCount(arr, temp, middle + 1, right);

            inversionCount += mergeAndCount(arr, temp, left, middle, right);
        }

        return inversionCount;
    }

    private static long mergeAndCount(long[] arr, long[] temp, int left, int middle, int right) {
        long inversionCount = 0;
        int i = left, j = middle + 1;
        int k = left;

        while (i <= middle && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += middle - i + 1; // Count inversions
            }
        }

        while (i <= middle) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int m = left; m <= right; m++) {
            arr[m] = temp[m];
        }

        return inversionCount;
    }
}

