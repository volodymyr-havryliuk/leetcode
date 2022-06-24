package org.example;

import staff.ListNode;

public class TaskTwo {
  public static void main(String[] args) {
    ListNode number1 = new ListNode(9, new ListNode(9, new ListNode(9)));//new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode number2 = new ListNode(9, new ListNode(9));//new ListNode(5, new ListNode(6, new ListNode(4)));

    ListNode sum = addTwoNumbers(number1, number2);
    System.out.println(sum.toString());
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode currentNode = dummyHead;

    ListNode a = l1;
    ListNode b = l2;
    int carry = 0;
    while (a != null || b != null) {
      int x = a != null ? a.val : 0;
      int y = b != null ? b.val : 0;

      int sum = x + y;
      sum += carry;
      carry = 0;
      if (sum >= 10) {
        carry = 1;
        sum = sum - 10;
      }
      ListNode currentSum = new ListNode(sum);
      currentNode.next = currentSum;
      currentNode = currentNode.next;
      if (a != null) {
        a = a.next;
      }
      if (b != null) {
        b = b.next;
      }
    }
    if (carry > 0) {
      currentNode.next = new ListNode(carry);
    }

    return dummyHead.next;
  }
}