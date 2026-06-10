import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int count = map.size();
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int start = 0;

        while (j < m) {
            char ch = s.charAt(j);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0) {
                    count--;
                }
            }
            while (count == 0) {
                char left = s.charAt(i);
                if (!map.containsKey(left)) {
                    i++;
                } else if (map.get(left) < 0) {
                    map.put(left, map.get(left) + 1);
                    i++;
                } else {
                    if (j - i + 1 < ans) {
                        ans = j - i + 1;
                        start = i;
                    }
                    map.put(left, map.get(left) + 1);
                    count++;
                    i++;
                    break;
                }
            }
            j++;
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }

    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();

        // Test 1: Expected "BANC"
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));

        // Test 2: Expected "a"
        System.out.println(sol.minWindow("a", "a"));

        // Test 3: Expected ""
        System.out.println(sol.minWindow("a", "aa"));

        // Test 4: Expected "ba"
        System.out.println(sol.minWindow("bba", "ab"));

        // Test 5: t longer than s → Expected ""
        System.out.println(sol.minWindow("ab", "abc"));
    }
}
