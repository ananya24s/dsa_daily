/*
Problem: LeetCode Daily Challenge
Link: https://leetcode.com/problems/maximum-total-subarray-value-i?envType=daily-question&envId=2026-06-09

Idea:
- We need to find the maximum possible total value of k subarrays.
- Each subarray value is (max - min).
- In this solution, we use global max and min of the array.

Approach:
- Step 1: Find maximum element in array
- Step 2: Find minimum element in array
- Step 3: Compute (max - min)
- Step 4: Multiply by k

Mistake / Learning:
- Learned how to structure GitHub problem logs properly.
*/

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        for (int x : nums) {
            maxi = Math.max(maxi, x);
            mini = Math.min(mini, x);
        }

        return 1L * k * (maxi - mini);
    }
}