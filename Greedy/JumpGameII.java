public class JumpGameII {

    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII sol = new JumpGameII();

        // Test 1: Expected 2
        System.out.println(sol.jump(new int[]{2, 3, 1, 1, 4}));

        // Test 2: Expected 2
        System.out.println(sol.jump(new int[]{2, 3, 0, 1, 4}));

        // Test 3: Single element → Expected 0
        System.out.println(sol.jump(new int[]{0}));

        // Test 4: Expected 1
        System.out.println(sol.jump(new int[]{3, 0, 0, 0}));

        // Test 5: Expected 3
        System.out.println(sol.jump(new int[]{1, 1, 1, 1}));
    }
}
