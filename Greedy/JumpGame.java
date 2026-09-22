public class JumpGame {

    public boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach)
                return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame sol = new JumpGame();

        // Test 1: Expected true
        System.out.println(sol.canJump(new int[]{2, 3, 1, 1, 4}));

        // Test 2: Expected false
        System.out.println(sol.canJump(new int[]{3, 2, 1, 0, 4}));

        // Test 3: Single element → Expected true
        System.out.println(sol.canJump(new int[]{0}));

        // Test 4: All zeros except first → Expected false
        System.out.println(sol.canJump(new int[]{1, 0, 0}));

        // Test 5: Expected true
        System.out.println(sol.canJump(new int[]{2, 0, 0}));
    }
}
