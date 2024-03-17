package prc.hc.codingAssignments;

import java.util.Vector;

public class MSS2 {

    public static void main(String[] args) {
        int[] arr = {2,6,11,9};
        Vector<Integer> vec = new Vector<Integer>();
        Vector<Integer> vec1 = new Vector<Integer>();
        vec.add(-2);
        vec.add(6);
        vec.add(11);
        vec.add(9);
        vec1.add(-1);
        vec1.add(-2);
        vec1.add(-3);
        vec1.add(-4);
        mergeSort(vec1,0,vec.size());

    }

    public static void mergeSort(Vector<Integer> vc, int left, int right) {
        //Write your code here
        int[] arr = new int[vc.size()];
        for (int i = 0; i < vc.size(); i++) {
            arr[i] = vc.get(i);
        }
         sort(arr,left,right-1);
        for (int i = 0; i < vc.size(); i++) {
            vc.set(i,arr[i]);
            System.out.print(arr[i]+" ");
        }

    }
    static void  merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    static void sort(int arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
