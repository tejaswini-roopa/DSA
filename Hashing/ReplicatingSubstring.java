import java.util.HashMap;

public class ReplicatingSubstring {

    public static int solve(int A, String B) {

        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count frequency of each character
        for (int i = 0; i < B.length(); i++) {

            char ch = B.charAt(i);

            frequencyMap.put(ch,
                    frequencyMap.getOrDefault(ch, 0) + 1);
        }

        // Check divisibility
        for (int frequency : frequencyMap.values()) {

            if (frequency % A != 0) {
                return -1;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        int A1 = 2;
        String B1 = "bbaabb";

        int A2 = 2;
        String B2 = "bc";

        System.out.println(solve(A1, B1)); // Output: 1
        System.out.println(solve(A2, B2)); // Output: -1
    }
}