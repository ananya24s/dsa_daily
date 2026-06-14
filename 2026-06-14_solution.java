/*
Problem: Maximum Twin Sum of Linked List
Link: https://leetcode.com/problems/maximum-twin-sum-of-linked-list/

Idea:
- Twin nodes are symmetric from start and end
- Use slow + fast pointers to reach middle
- Store first half in stack
- Compare with second half

Approach:
- Step 1: Use slow and fast pointers to traverse list
- Step 2: Push first half values into stack
- Step 3: Move second half and pop from stack
- Step 4: Compute max twin sum

Mistake / Learning:
- Learned how stack helps reverse half of linked list logic
*/

import java.util.Stack;

class Solution {
    public int pairSum(ListNode head) {
        Stack<Integer> half = new Stack<>();
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            half.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        int res = 0;

        while (slow != null) {
            res = Math.max(res, half.pop() + slow.val);
            slow = slow.next;
        }

        return res;
    }
}