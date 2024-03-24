package prc.hc.sessiontests.thirdtest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * First Unique Number
 * Given a non-empty list of elements, return the sequentially first element which occurred only once in the array.
 *
 * Input:
 * The first line contains N, N is the number of input elements. The second line contains N space-separated input integers.
 *
 * Output:
 * Return the first Non-Repeating Element in the array. If there is no element with a frequency 1 print -1.
 *
 * Constraints:
 * 1 <= N <= 100000
 * 0 <= A[i] <= 10^9
 * Example 1
 * Input:
 *
 * 4
 * 9 6 7 6
 * Output:
 *
 * 9
 * Explanation:
 * In the given input, 9 and 7 have a frequency of 1 but since 9 came first so output is 9.
 *
 * Example 2
 * Input:
 *
 * 5
 * 7 6 1 6 1
 * Output
 *
 * 7
 * Explanation:
 * In the given input, only 7 has a frequency of 1 .
 */
public class FirstuniqueNo {

    public static void main(String[] args) {
        int[] arr = {7,6,1,6,1};
        System.out.println(firstUniqueInteger(arr));
    }

    public static int firstUniqueInteger(int[] v) {
        //Write your code here
        Map<Integer,Integer> hmap = new HashMap<>();
        for (int i = 0; i < v.length; i++) {
            hmap.put(v[i],hmap.getOrDefault(v[i],0)+1);
        }
        for (int i = 0; i < v.length; i++) {
            if(hmap.get(v[i])==1) return v[i];
        }

            return  -1;
    }
}
