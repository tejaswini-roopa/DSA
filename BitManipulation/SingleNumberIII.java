class BitChecker {
    boolean checkBit(int num, int i) {
        if (((num >> i) & 1) == 1)
            return true;
        else
            return false;
    }

    public int[] singleNumber(int[] nums) {
        int n = nums.length;

        // Step 1: XOR all numbers to get xor of two unique numbers
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }

        // Step 2: Find position of rightmost set bit
        int pos = -1;
        for (int i = 0; i <= 30; i++) {
            if (checkBit(xor, i)) {
                pos = i;
                break;
            }
        }

        // Step 3: Divide numbers into two groups and XOR separately
        int set = 0;
        int unset = 0;
        for (int i = 0; i < n; i++) {
            if (checkBit(nums[i], pos)) {
                set ^= nums[i];
            } else {
                unset ^= nums[i];
            }
        }

        return new int[]{set, unset};
    }
}

public class SingleNumberIII {
    public static void main(String[] args) {
        BitChecker bitChecker = new BitChecker();

        // Test Case 1: [1,2,1,3,2,5] → Expected: [3,5]
        runTestCase(bitChecker, new int[]{1, 2, 1, 3, 2, 5}, 1);

        // Test Case 2: [0,1] → Expected: [0,1]
        runTestCase(bitChecker, new int[]{0, 1}, 2);

        // Test Case 3: [4,1,2,1,2,3] → Expected: [4,3]
        runTestCase(bitChecker, new int[]{4, 1, 2, 1, 2, 3}, 3);
    }

    private static void runTestCase(BitChecker bitChecker, int[] nums, int testNumber) {
        System.out.print("Test Case " + testNumber + ":");
        System.out.print("  Input  : [");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
            if (i < nums.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        int[] result = bitChecker.singleNumber(nums);
        System.out.println("  Output : [" + result[0] + ", " + result[1] + "]");
        System.out.println();
    }
}