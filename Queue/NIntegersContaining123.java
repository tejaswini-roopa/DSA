import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NIntegersContaining123 {

    public ArrayList<Integer> solve(int A) {
        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (answer.size() < A) {
            int currentNumber = queue.poll();
            answer.add(currentNumber);
            queue.offer(10 * currentNumber + 1);
            queue.offer(10 * currentNumber + 2);
            queue.offer(10 * currentNumber + 3);
        }

        return answer;
    }

    public static void main(String[] args) {
        NIntegersContaining123 sol = new NIntegersContaining123();

        // Test 1: Expected [1, 2, 3]
        System.out.println(sol.solve(3));

        // Test 2: Expected [1, 2, 3, 11, 12, 13, 21]
        System.out.println(sol.solve(7));

        // Test 3: Expected [1]
        System.out.println(sol.solve(1));

        // Test 4: First 10
        System.out.println(sol.solve(10));
    }
}
