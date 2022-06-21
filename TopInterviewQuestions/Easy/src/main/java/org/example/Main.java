package org.example;

public class Main {


  public static void main(String[] args) {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // Input array
    int[] expectedNums = {0, 1, 2, 3, 4};
    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
      assert nums[i] == expectedNums[i];
    }
  }

  private static int removeDuplicates(int[] nums) {
    int k = 1;
    int indexOfUnique = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[indexOfUnique] != nums[i]) {
        nums[k] = nums[i];
        indexOfUnique = i;
        k++;
      }
    }
    return k;
  }

}