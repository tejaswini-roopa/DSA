import java.util.Stack;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        String result = "";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (!st.isEmpty())
                    result = result + ch;
                st.push(ch);
            } else {
                st.pop();
                if (!st.isEmpty())
                    result = result + ch;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RemoveOutermostParentheses sol = new RemoveOutermostParentheses();

        // Test 1: Expected "()()()"
        System.out.println(sol.removeOuterParentheses("(()())(())"));

        // Test 2: Expected "()()()()(())"
        System.out.println(sol.removeOuterParentheses("(()())(())(()(()))"));

        // Test 3: Expected ""
        System.out.println(sol.removeOuterParentheses("()()"));

        // Test 4: Expected "(())"
        System.out.println(sol.removeOuterParentheses("((()))"));

        // Test 5: Expected "()"
        System.out.println(sol.removeOuterParentheses("(())"));
    }
}
