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
    int[] charCount = new int[26];

    for (char ch : str.toCharArray()) {
      if (ch >= 'a' && ch <= 'z') {
        int index = ch - 'a';
        charCount[index]++;
      }
    }

    for (int count : charCount) {
      if (count == 0) {
        return false;
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
