package prc.hc.sessiontests.thirdtest;

/**
 * All Alphabets
 * Write a program that takes lowercase string str as input and checks if it contains all 26 alphabets at least once. Given a string str, return true if str contains all 26 alphabets, or false otherwise.
 *
 * Input:
 * The first line contains a lowercase string str.
 *
 * Output:
 * Return a boolean value true or false.
 *
 * Constraints:
 * 1 <= str.length <= 10^4
 * str consists of lowercase English letters.
 * Example 1
 * Input:
 *
 * thequickbrownfoxjumpsoverthelazydog
 * Output
 *
 * true
 */
public class AllAlphabets {

  public static boolean containsAllAlphabets(String str) {
    // Create an array of size 26 to track encountered alphabets (frequency)
    int[] charCount = new int[26];

    // Iterate through the string
    for (char ch : str.toCharArray()) {
      // Check if lowercase alphabet (between 'a' and 'z')
      if (ch >= 'a' && ch <= 'z') {
        // Get the index corresponding to the character (a-z maps to 0-25)
        int index = ch - 'a';
        // Increment the count at that index
        charCount[index]++;
      }
    }

    // Check if all characters have a count of at least 1
    for (int count : charCount) {
      if (count == 0) {
        return false; // Missing alphabet found
      }
    }

    return true; // All alphabets found
  }

  public static void main(String[] args) {
    String str1 = "abcdefghijklmnopqrstuvwxyz";
    String str2 = "thequickbrownfoxjumpsoverthelazydog";
    String str3 = "hello world";

    System.out.println(containsAllAlphabets(str1));  // True
    System.out.println(containsAllAlphabets(str2));  // True
    System.out.println(containsAllAlphabets(str3));  // False
  }
}
