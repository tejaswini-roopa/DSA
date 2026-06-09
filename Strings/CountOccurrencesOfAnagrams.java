import java.util.HashMap;

public class CountOccurrencesOfAnagrams {

    int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        if (m > n) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : pat.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int count = map.size();
        int i = 0, j = 0, ans = 0;

        while (j < n) {
            char ch = txt.charAt(j);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);
                if (map.get(ch) == 0)
                    count--;
            }

            if (j - i + 1 < m) {
                j++;
            } else if (j - i + 1 == m) {
                if (count == 0)
                    ans++;

                char left = txt.charAt(i);
                if (map.containsKey(left)) {
                    if (map.get(left) == 0)
                        count++;
                    map.put(left, map.get(left) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        CountOccurrencesOfAnagrams sol = new CountOccurrencesOfAnagrams();

        // Test 1: Expected 3
        System.out.println(sol.search("for", "forxxorfxdofr"));

        // Test 2: Expected 4
        System.out.println(sol.search("aaba", "aabaabaa"));

        // Test 3: pat longer than txt → Expected 0
        System.out.println(sol.search("abcd", "ab"));

        // Test 4: All same chars → Expected 3
        System.out.println(sol.search("aa", "aaaa"));

        // Test 5: No anagram present → Expected 0
        System.out.println(sol.search("xyz", "hello"));
    }
}
