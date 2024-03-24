package prc.hc.prefixsum;

import java.util.HashSet;
import java.util.Set;

public class SubArrayWithZeroSum {

    public static void main(String[] args) {
        // int[] arr = {1,3,5,2,2};
        /*
        Idea here is that , suppose we have a sum say x till i index;
        Now we move to i+1 we will have the sum changed , it can be positive or negative change say it is i and  so x+i =a (a is the new sum)
        we keep on adding no like
        x+i+j = b // j is by new no, b is the new sum
        x+i+j+k= c // k is the new no , c new total sum
        .. if in future of this traversal we find
        x+i+j+k+l+...+o=x , it means that i+j+k+l+...+o = 0 , as we already had x as total sum and we encounted that again
        It simply means the rest of elements  i+j+k+l+...+o sums to 0.
         */
        int[] arr = {1,-1};
        String result = subarraywith0Sum(arr);
        System.out.println(result);

    }

    private static String subarraywith0Sum(int[] arr) {
        if(arr.length==1) {
            if(arr[0]==0) return "YES";
            else return "NO";
        }
        int n = arr.length;
        int[] sum = new int[n];
        Set<Integer> sumSet = new HashSet<>();
        sum[0] = arr[0];
        sumSet.add(sum[0]);


        for (int i = 1; i < n; i++) {
            sum[i]=sum[i-1]+arr[i];
            if(sum[i]==0||sumSet.contains(sum[i])) return "YES";
            sumSet.add(sum[i]);
        }
        return "NO";
    }
}
