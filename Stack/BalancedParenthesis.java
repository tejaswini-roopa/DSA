import java.util.Stack;

public class BalancedParenthesis {

    public int solve(String A) {
        Stack<Character> st = new Stack<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (c == '{' || c == '[' || c == '(')
                st.push(c);
            else if (c == '}' && !st.isEmpty() && st.peek() == '{')
                st.pop();
            else if (c == ']' && !st.isEmpty() && st.peek() == '[')
                st.pop();
            else if (c == ')' && !st.isEmpty() && st.peek() == '(')
                st.pop();
            else
                return 0;
        }
        if (st.isEmpty())
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        BalancedParenthesis sol = new BalancedParenthesis();

        // Test 1: Expected 1
        System.out.println(sol.solve("{([])}"));

        // Test 2: Expected 0
        System.out.println(sol.solve("(){"));

        // Test 3: Expected 1
        System.out.println(sol.solve("()[]"));

        // Test 4: Empty string → Expected 1
        System.out.println(sol.solve(""));

        // Test 5: Only opening brackets → Expected 0
        System.out.println(sol.solve("((({{{"));

        // Test 6: Wrong order → Expected 0
        System.out.println(sol.solve("([)]"));
    }
}
