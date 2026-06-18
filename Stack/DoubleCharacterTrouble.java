import java.util.Stack;

public class DoubleCharacterTrouble {

    public String solve(String A) {
        Stack<Character> st = new Stack<>();
        int n = A.length();
        for (int i = 0; i < n; i++) {
            char c = A.charAt(i);
            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else
                st.push(c);
        }
        if (st.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        DoubleCharacterTrouble sol = new DoubleCharacterTrouble();

        // Test 1: Expected "ac"
        System.out.println(sol.solve("abccbc"));

        // Test 2: Expected "ab"
        System.out.println(sol.solve("ab"));

        // Test 3: All pairs cancel → Expected ""
        System.out.println(sol.solve("aabb"));

        // Test 4: Nested pairs → Expected ""
        System.out.println(sol.solve("abccba"));

        // Test 5: Single char → Expected "a"
        System.out.println(sol.solve("a"));
    }
}
