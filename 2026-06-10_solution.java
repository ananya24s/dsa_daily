import java.util.*;

class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        long[] contrib = new long[n];

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];

        Stack<Integer> st = new Stack<>();

        // previous greater
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) st.pop();
            leftMax[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next greater
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) st.pop();
            rightMax[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // previous smaller
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            leftMin[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            rightMin[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        ArrayList<Long> vals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long maxCount = (long)(i - leftMax[i]) * (rightMax[i] - i);
            long minCount = (long)(i - leftMin[i]) * (rightMin[i] - i);
            vals.add((long)nums[i] * (maxCount - minCount));
        }

        Collections.sort(vals, Collections.reverseOrder());

        long ans = 0;
        for (int i = 0; i < k; i++) {
            ans += vals.get(i);
        }

        return ans;
    }
}