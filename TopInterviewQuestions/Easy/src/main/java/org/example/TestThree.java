package org.example;

public class TestThree {

  public static void main(String[] args) {
    String s = "dvdf";//"abcabcbb";//
    TestThree testThree = new TestThree();
    int count = testThree.lengthOfLongestSubstring(s);
    System.out.println(count);
    int countOriginal = testThree.originalLengthOfLongestSubstring(s);
    System.out.println(countOriginal);
  }


  public int lengthOfLongestSubstring(String s) {
    if (s.length() == 1) {
      return 1;
    }
    int longestSubstringLength = 0;
    String substring = "";
    for (int i = 0; i < s.length(); i++) {
      char currentChar = s.charAt(i);
      if (substring.indexOf(currentChar) == -1) {
        substring += s.charAt(i);
      } else {
        i -= substring.length();
        substring = "";
      }
      System.out.println(substring);
      if (longestSubstringLength < substring.length()) {
        longestSubstringLength = substring.length();
      }
    }
    return longestSubstringLength;
  }

  public int originalLengthOfLongestSubstring(String s) {
    int n = s.length();

    int res = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        if (checkRepetition(s, i, j)) {
          res = Math.max(res, j - i + 1);
        }
      }
    }

    return res;
  }

  private boolean checkRepetition(String s, int start, int end) {
    int[] chars = new int[128];

    for (int i = start; i <= end; i++) {
      char c = s.charAt(i);
      chars[c]++;
      if (chars[c] > 1) {
        return false;
      }
    }

    return true;
  }

}
