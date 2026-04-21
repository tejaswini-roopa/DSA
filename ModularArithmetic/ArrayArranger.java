import java.util.*;

class ArrayArranger {
    public void arrange(ArrayList<Integer> a) {
        int n = a.size();

        // Step 1: Multiply all elements by n
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) * n);
        }

        // Step 2: Add the value at the index position
        for (int i = 0; i < n; i++) {
            int index = a.get(i) / n;
            int value = a.get(index) / n;
            a.set(i, a.get(i) + value);
        }

        // Step 3: Divide all elements by n to get final result
        for (int i = 0; i < n; i++) {
            a.set(i, a.get(i) % n);
        }
    }
}

public class ArrangeArray {
    public static void main(String[] args) {
        ArrayArranger arrayArranger = new ArrayArranger();

        // Test Case 1: [2,3,4,0,1] → Expected: [4,0,1,2,3]
        ArrayList<Integer> testCase1 = new ArrayList<>(Arrays.asList(2, 3, 4, 0, 1));
        runTestCase(arrayArranger, testCase1, 1);

        // Test Case 2: [0,1,2,3] → Expected: [0,1,2,3]
        ArrayList<Integer> testCase2 = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        runTestCase(arrayArranger, testCase2, 2);

        // Test Case 3: [3,0,2,1] → Expected: [1,3,2,0]
        ArrayList<Integer> testCase3 = new ArrayList<>(Arrays.asList(3, 0, 2, 1));
        runTestCase(arrayArranger, testCase3, 3);
    }

    private static void runTestCase(ArrayArranger arranger, ArrayList<Integer> input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        arranger.arrange(input);
        System.out.println("  Output : " + input);
        System.out.println();
    }
}