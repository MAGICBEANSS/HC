package prc.hc;

import java.util.Arrays;

public class SortArrayWithZeros {

    public static void main(String[] args) {
        int fourDigitNumber = 3042;
        int[] sortedArrayWithZeros = sortArrayWithZeros(fourDigitNumber);
        
        System.out.println("Original four-digit number: " + fourDigitNumber);
        System.out.println("Sorted array with zeros at the end: " + java.util.Arrays.toString(sortedArrayWithZeros));
    }

    public static int[] sortArrayWithZeros(int number) {
        int[] digitArray = new int[4];

        // Convert the four-digit number to an array
        for (int i = 3; i >= 0; i--) {
            digitArray[i] = number % 10;
            number /= 10;
        }

        // Sort the array
        Arrays.sort(digitArray, 0, 3);

        // Move zeros to the end
        for (int i = 0; i < 3; i++) {
            if (digitArray[i] == 0) {
                int temp = digitArray[i];
                digitArray[i] = digitArray[3];
                digitArray[3] = temp;
            }
        }

        return digitArray;
    }
}