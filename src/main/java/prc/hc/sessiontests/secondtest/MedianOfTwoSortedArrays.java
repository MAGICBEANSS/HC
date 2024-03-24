package prc.hc.sessiontests.secondtest;

public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] arr1 = {5,6,14};
        int[] arr2 = {6,7,8,9,10,11,12};
        //{5,6,6,7,8,9,10,11,12,14}
        int z = getMedian(arr1,arr2,arr1.length,arr2.length);
        System.out.println(z);
    }

    public  static int getMedian(int[] ar1, int[] ar2, int m, int n) {
        //Write your code here; 
        int i =0;
        int j =0;
        int k =0;
        int[] arr = new int[m+n];
        while (i<m && j < n) {
            if(ar1[i]<=ar2[j]) {
                arr[k]= ar1[i];
                i++;
            }
            else {
                arr[k]= ar2[j];
                j++;
            }
            k++;
        }

        while (i<m) {
            arr[k] = ar1[i];
            i++;
            k++;

        }
        while (j<n) {
            arr[k] = ar2[j];
            j++;
            k++;

        }
        int findMedian = binarySearchMedian(arr);
        return findMedian;
    }

    private static int binarySearchMedian(int[] arr) {
        if(arr.length==0) return -1;
        if(arr.length==1) return arr[0];
        if(arr.length==2) return (arr[1]+arr[0])/2;
        int low =0;
        int n = arr.length;
        int high = n-1;
        int mid = (low+high)/2;
        if(n%2==0) return (arr[mid]+arr[mid+1])/2;
        else return arr[mid]/2;

    }
}