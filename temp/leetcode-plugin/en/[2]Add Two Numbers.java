//You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the number 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
//

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null, temp = result;
        int value;
        boolean addOne = false;
        while (l1 != null || l2 != null || addOne) {
            if (l1 != null && l2 != null) {
                if (addOne) {
                    value = 1;
                    addOne = false;
                } else {
                    value = 0;
                }
                value = value + l1.val + l2.val;
                if (value > 9) {
                    addOne = true;
                }
                if (result == null) {
                    result = new ListNode(value % 10);
                    temp = result;
                } else {
                    temp.next = new ListNode(value % 10);
                    temp = temp.next;
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                if (addOne) {
                    value = 1;
                    addOne = false;
                } else {
                    value = 0;
                }
                value = value + l1.val;
                if (value > 9) {
                    addOne = true;
                }
                temp.next = new ListNode(value % 10);
                temp = temp.next;
                l1 = l1.next;
            } else if (l2 != null) {
                if (addOne) {
                    value = 1;
                    addOne = false;
                } else {
                    value = 0;
                }
                value = value + l2.val;
                if (value > 9) {
                    addOne = true;
                }
                temp.next = new ListNode(value % 10);
                temp = temp.next;
                l2 = l2.next;
            } else if (addOne) {
                temp.next = new ListNode(1);
                return result;
            }
        }
        if (result == null) {
            result = new ListNode(0);
        }
        return result;
    }
}

