import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        generate(nums, 0, n, curr, ans);
        return ans;
    }

    private void generate(int[] num, int pos, int n, List<Integer> curr, List<List<Integer>> ans) {
        if (pos == n) {
            curr.clear();
            for (int x : num)
                curr.add(x);
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = pos; i < n; i++) {
            swap(num, pos, i);
            generate(num, pos + 1, n, curr, ans);
            swap(num, pos, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations sol = new Permutations();

        // Test 1: Expected [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        System.out.println(sol.permute(new int[]{1, 2, 3}));

        // Test 2: Expected [[0,1],[1,0]]
        System.out.println(sol.permute(new int[]{0, 1}));

        // Test 3: Single element → Expected [[1]]
        System.out.println(sol.permute(new int[]{1}));

        // Test 4: Negative numbers
        System.out.println(sol.permute(new int[]{-1, 0, 1}));
    }
}
