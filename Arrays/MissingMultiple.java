public class MissingMultiple {

    public int missingMultiple(int[] nums, int k) {
        int multiple = k;

        while (true) {
            boolean found = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == multiple) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                return multiple;
            }

            multiple += k;
        }
    }

    public static void main(String[] args) {
        MissingMultiple sol = new MissingMultiple();

        // Test 1: Expected 10
        System.out.println(sol.missingMultiple(new int[]{8, 2, 3, 4, 6}, 2));

        // Test 2: Expected 5
        System.out.println(sol.missingMultiple(new int[]{1, 4, 7, 10, 15}, 5));

        // Test 3: Expected 1
        System.out.println(sol.missingMultiple(new int[]{2, 3, 4}, 1));

        // Test 4: Expected 3
        System.out.println(sol.missingMultiple(new int[]{6, 9, 12}, 3));
    }
}
