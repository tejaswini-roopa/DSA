import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

    public String solve(int A) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer("2");
        int count = 2;
        int elementsRemoved = 0;

        while (count < A) {
            String s = queue.poll();
            elementsRemoved++;
            queue.offer(s + "1");
            queue.offer(s + "2");
            count += 2;
        }

        while (elementsRemoved < A - 1) {
            queue.poll();
            elementsRemoved++;
        }

        StringBuilder sb = new StringBuilder(queue.peek());
        return queue.peek() + sb.reverse().toString();
    }

    public static void main(String[] args) {
        PerfectNumbers sol = new PerfectNumbers();

        // Test 1: Expected "22"
        System.out.println(sol.solve(2));

        // Test 2: Expected "1111"
        System.out.println(sol.solve(3));

        // Test 3: Expected "11"
        System.out.println(sol.solve(1));

        // Test 4: Expected "1221"
        System.out.println(sol.solve(4));

        // Test 5: Expected "2112"
        System.out.println(sol.solve(5));
    }
}
