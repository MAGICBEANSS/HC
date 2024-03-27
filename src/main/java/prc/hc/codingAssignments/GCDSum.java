package prc.hc.codingAssignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class GCDSum {

    public static void main(String[] args) {
        int[] arr = {5,4,2,3,1};
        ArrayList<Integer> ar = new ArrayList<>();
        Arrays.stream(arr).forEach(x->ar.add(x));
        int z = new GCDSum().solve(ar);
        System.out.println(z);
    }
          public int solve(ArrayList<Integer> ar) {
  int totalCost = 0;
        
        Collections.sort(ar);
        
        while (ar.size() > 1) {
            int num1 = ar.remove(0);
            int num2 = ar.remove(0);
            
            int gcd = calculateGCD(num1, num2);
            
            int sum = num1 + num2;
            int index = binarySearchWithIndexPosition(ar, sum);
            /*if (index < 0) {
                index = -index - 1;
            }*/
            ar.add(index, sum);
            
            totalCost += gcd;
        }
        
        return totalCost;
    }
    
    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

   
    int binarySearchWithIndexPosition(ArrayList<Integer> list, int target) {
          int[] arr = list.stream().mapToInt(x->x).toArray();
        int low =0;
        int n = arr.length-1;
        int high = n;
        int mid = -1;
        while (low<=high) {
             mid = (low+high)/2;
            if(arr[mid]==target) {
                return mid;
            }
            else if(arr[mid]>target) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;

    }
}