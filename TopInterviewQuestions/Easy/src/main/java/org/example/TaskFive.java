package org.example;

public class TaskFive {

  public static void main(String[] args) {
    String s = "a";
    TaskFive taskFive = new TaskFive();
    String palindrome = taskFive.longestPalindrome(s);
    System.out.println("The longest palindrome: " + palindrome);
  }

  public String longestPalindrome(String s) {
    if (s == null || "".equals(s)) {
      return s;
    }
    String ans = "";
    int length = s.length();
    boolean[][] dp = new boolean[length][length];
    for (int j = 0; j < length; j++) {
      for (int i = 0; i <= j; i++) {
        boolean judge = s.charAt(i) == s.charAt(j);
        dp[i][j] = j - i > 2 ? dp[i + 1][j - 1] && judge : judge;
        if (dp[i][j] && j - i + 1 > ans.length()) {
          ans = s.substring(i, j + 1);
        }
      }
    }
    return ans;
  }

/*  public String longestPalindrome(String s) {
    if (s.length() == 1) {
      return s;
    }

    String longestPalindrome = s.substring(0, 1);
    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length(); j > i; j--) {
        // System.out.println("i= " + i + " j= " + j);
        String potentialPalindrome = s.substring(i, j);
        System.out.println(potentialPalindrome);
        if (isPalindrome(potentialPalindrome) && potentialPalindrome.length() > longestPalindrome.length()) {
          longestPalindrome = potentialPalindrome;
        }
      }
    }
    return longestPalindrome;
  }*/

/*  private boolean isPalindrome(String s) {
    int k = 0;
    while (k < s.length() / 2) {
      Character start = s.charAt(k);
      Character end = s.charAt(s.length() - k - 1);
      if (start == end) {
        k += 1;
        continue;
      } else {
        return false;
      }
      //System.out.println(start + " " + end);
    }
    return true;
  }*/
}