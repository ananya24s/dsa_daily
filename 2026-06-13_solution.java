/*
Problem: Merge Two Sorted Lists
Link: https://leetcode.com/problems/merge-two-sorted-lists/

Idea:
- Both lists are already sorted
- Use two pointers to pick the smaller node each time

Approach:
- Step 1: Create a dummy node to build result list
- Step 2: Use a pointer "cur" to build new list
- Step 3: Compare list1 and list2 nodes
- Step 4: Attach smaller node to result and move pointer
- Step 5: Attach remaining nodes at end

Mistake / Learning:
- Learned how dummy node simplifies linked list problems
*/

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }

        cur.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
}