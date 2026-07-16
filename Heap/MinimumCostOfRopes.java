import java.util.PriorityQueue;

public class MinimumCostOfRopes {

    public static int  minCost(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr) {
            pq.add(num);
        }
        int ans = 0;
        while (pq.size() != 1) {
            int cost = pq.poll() + pq.poll();
            pq.add(cost);
            ans += cost;
        }
        return ans;
    }

    public static void main(String[] args) {

        // Test 1: Expected 29
        System.out.println(minCost(new int[]{4, 3, 2, 6}));

        // Test 2: Expected 62
        System.out.println(minCost(new int[]{4, 2, 7, 6, 9}));

        // Test 3: Single rope → Expected 0
        System.out.println(minCost(new int[]{10}));

        // Test 4: Two ropes → Expected 5
        System.out.println(minCost(new int[]{2, 3}));

        // Test 5: All same → Expected 12
        System.out.println(minCost(new int[]{1, 1, 1, 1}));
    }
}
