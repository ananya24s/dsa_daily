/*
Problem: Valid Parentheses
Link: https://leetcode.com/problems/valid-parentheses/

Idea:
- Use a stack to track opening brackets
- Whenever we see a closing bracket, check if it matches the top of stack

Approach:
- Step 1: Traverse each character in string
- Step 2: If opening bracket → push into stack
- Step 3: If closing bracket → check top of stack
- Step 4: If mismatch or stack empty → return false
- Step 5: At end, stack must be empty

Mistake / Learning:
- Learned how stack helps in matching nested structures
*/

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (ch == ')' && top != '(') return false;
                if (ch == ']' && top != '[') return false;
                if (ch == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}