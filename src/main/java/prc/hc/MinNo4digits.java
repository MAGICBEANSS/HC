package prc.hc;

import java.util.Arrays;

public class MinNo4digits {
    //https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits/

    public static void main(String[] args) {
        int num = 2293;
        int[] arr = new int[String.valueOf(num).length()];
      //  arr = sortArrayWithZeros(num);
        int z =minimumSum(num);
        System.out.println(z);
    //    return
    }

    public static int minimumSum(int num) {
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        arr = sortArrayWithZeros2(num);

        return (((arr[0]*10)+arr[2])+((arr[1]*10)+arr[3]));

    }

    public static int[] sortDigitsWithZeroEnd(int number) {
        int[] digits = new int[4];
        int nonZeroCount = 0; // Count non-zero digits

        // Extract digits and count non-zeros, handle leading zeros
        while (number > 0) {
            int digit = number % 10;
            digits[nonZeroCount] = digit; // Store all digits, even zeros
            if (digit != 0) {
                nonZeroCount++; // Increment only for non-zero digits
            }
            number /= 10;
        }

        // If no non-zero digits, fill with zeros
        if (nonZeroCount == 0) {
            Arrays.fill(digits, 0);
        } else {
            // Sort non-zero digits (already partially sorted due to separate handling)
            Arrays.sort(digits, 0, nonZeroCount);
        }

        return digits;
    }

    public static int[] sortArrayWithZeros2(int number) {
        int[] digitArray = new int[4];

        // Convert the four-digit number to an array
        for (int i = 3; i >= 0; i--) {
            digitArray[i] = number % 10;
            number /= 10;
        }

        // Sort the array
        Arrays.sort(digitArray);

        // Move zeros to the end
       return digitArray;
    }
}
