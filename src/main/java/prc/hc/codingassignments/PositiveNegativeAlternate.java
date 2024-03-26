package prc.hc.codingassignments;

import java.util.ArrayList;
import java.util.Collections;

public class PositiveNegativeAlternate {
    public void alternatePandE(int[] ar) {
        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        // Separate positive and negative numbers
        for (int num : ar) {
            if (num > 0) {
                positive.add(num);
            } else if (num < 0) {
                negative.add(num);
            }
        }

        // Sort positive and negative numbers
        Collections.sort(positive);
        Collections.sort(negative, Collections.reverseOrder());

        // Merge positive and negative numbers alternately
        int i = 0, j = 0;
        while (i < positive.size() && j < negative.size()) {
            ar[i + j] = negative.get(j);
            ar[i + j + 1] = positive.get(i);
            i++;
            j++;
        }

        // Move remaining positive or negative numbers to the end
        while (i < positive.size()) {
            ar[i + j] = positive.get(i);
            i++;
        }
        while (j < negative.size()) {
            ar[i + j] = negative.get(j);
            j++;
        }
    }

    public static void main(String[] args) {
        PositiveNegativeAlternate solution = new PositiveNegativeAlternate();

        // Sample Input
        int[] ar = {-1, 3,4,-6,2,5,9,-2};
        solution.alternatePandE(ar);
        System.out.print("Output: ");
        for (int num : ar) {
            System.out.print(num + " ");
        }
        // Output: -1 3 -2 4 -5 9 -7 -10
    }
}
