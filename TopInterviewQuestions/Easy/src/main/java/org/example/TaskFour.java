package org.example;

public class TaskFour {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int lengthOfBothArrays = nums1.length + nums2.length;
    int[] mergedArray = new int[lengthOfBothArrays];
    int k = 0, i = 0, j = 0;

    while (k < mergedArray.length) {
      if (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
          mergedArray[k] = nums1[i];
          i++;
        } else {
          mergedArray[k] = nums2[j];
          j++;
        }
      } else if (i < nums1.length) {
        mergedArray[k] = nums1[i];
        i++;
      } else if (j < nums2.length) {
        mergedArray[k] = nums2[j];
        j++;
      }
      k += 1;
    }
    if (mergedArray.length % 2 == 0) {
      return (double) (mergedArray[mergedArray.length / 2 - 1] + mergedArray[mergedArray.length / 2]) / 2;
    } else {
      return mergedArray[mergedArray.length / 2];
    }
  }


  public static void main(String[] args) {
    TaskFour taskFour = new TaskFour();
    int[] nums1 = {1, 4, 5};
    int[] nums2 = {2, 3};
    double median = taskFour.findMedianSortedArrays(nums1, nums2);
    System.out.println(median);
  }
}
