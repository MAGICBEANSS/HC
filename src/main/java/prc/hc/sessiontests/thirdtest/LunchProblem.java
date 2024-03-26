package prc.hc.sessiontests.thirdtest;
/**
 *Number of students unable to eat lunch
 * The school cafeteria offers circular and square sandwiches at lunch break, represented by numbers 0 and 1, respectively. All students stand in a queue, expressing their preference for either square or circular sandwiches.
 *
 * The number of sandwiches in the cafeteria is equal to the number of students, and these sandwiches are placed in a stack. The lunch process unfolds as follows:
 *
 * If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue. Otherwise, they will leave the sandwich on the top of the stack and go to the end of the queue. This process continues until none of the students in the queue want to take the top sandwich, rendering them unable to eat.
 *
 * You are given two integer arrays, students and sandwiches, where sandwiches[i] represents the type (0 or 1) of the i​​​​​​th sandwich in the stack, and students[j] represents the preference (0 or 1) of the j​​​​​​th student in the initial queue. Your task is to return the number of students who are unable to eat.
 *
 * Input:
 *
 * students: A list of integers representing the preferences of students (0 or 1).
 * sandwiches: A list of integers representing the types of sandwiches in the stack (0 or 1).
 * Output:
 *
 * An integer representing the number of students unable to eat.
 *
 * Examples:
 * Example:1
 *
 * students = [1, 1, 1, 0, 0, 1]
 * sandwiches = [1, 0, 0, 0, 1, 1]
 * Output:
 * 3
 *
 * Example2:
 *
 * students = [1, 1, 0, 0] sandwiches = [0, 1, 0, 1]
 *
 * Output:
 *
 * 0
 *
 * Constraints:
 *
 * 1 <= students.length, sandwiches.length <= 100
 * students.length == sandwiches.length
 * sandwiches[i] is 0 or 1.
 * students[i] is 0 or 1.
 */

import java.util.ArrayList;
import java.util.List;

public class LunchProblem {

    public int countStudents(List<Integer> students, List<Integer> sandwiches) {
        int unchangedCount = 0;
        boolean z = true;
        List<Integer> mutableStudents = new ArrayList<>(students);
        List<Integer> mutableSandwhichces = new ArrayList<>(sandwiches);

        if (students.isEmpty()) {
            return 0;
        }

        while (z) {
            unchangedCount++;

            int i =0;
                while (i < mutableStudents.size() && mutableStudents.get(i).equals(mutableSandwhichces.get(i))) {
                    // Remove element at index i from both lists
                    mutableStudents.remove(i);
                    mutableSandwhichces.remove(i);
                    //i++;
                    unchangedCount = 0;
                }
                if (mutableStudents.isEmpty()) {
                    return 0;
                }

            int lastIndex = mutableStudents.size() - 1;
            while (unchangedCount < mutableStudents.size() && !mutableStudents.get(0).equals(mutableSandwhichces.get(0))) {
                int temp = mutableStudents.get(0);
                mutableStudents.remove(0);
                mutableStudents.add(temp);
                unchangedCount++;
            }

            if (unchangedCount > mutableStudents.size()) {
                return mutableStudents.size();
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        LunchProblem lunchProblem = new LunchProblem();

        // Example usage
        List<Integer> students1 = List.of(1, 1, 1, 0, 0, 1);
        List<Integer> sandwiches1 = List.of(1, 0, 0, 0, 1, 1);
        System.out.println("Number of students unable to eat: " + lunchProblem.countStudents(students1, sandwiches1)); // Output: 3

        List<Integer> students2 = List.of(1, 1, 0, 0);
        List<Integer> sandwiches2 = List.of(0, 1, 0, 1);
        System.out.println("Number of students unable to eat: " + lunchProblem.countStudents(students2, sandwiches2)); // Output: 0
    }
}
