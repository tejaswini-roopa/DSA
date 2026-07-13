import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for (j = 0; j < n; j++) {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while ((j - i + 1) - maxFreq > k) {
                char leftChar = s.charAt(i);
                map.put(leftChar, map.get(leftChar) - 1);
                i++;
            }

            maxLen = Math.max((j - i + 1), maxLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();

        // Test 1: Expected 4
        System.out.println(sol.characterReplacement("ABAB", 2));

        // Test 2: Expected 4
        System.out.println(sol.characterReplacement("AABABBA", 1));

        // Test 3: k=0, all same → Expected 1
        System.out.println(sol.characterReplacement("ABCD", 0));

        // Test 4: k covers all → Expected 4
        System.out.println(sol.characterReplacement("ABCD", 4));

        // Test 5: Single char → Expected 1
        System.out.println(sol.characterReplacement("A", 0));
    }
}
