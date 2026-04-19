import java.util.*;

class BitCounter {
    public int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            if (A % 2 != 0)
                count++;
            A = A / 2;
        }
        return count;
    }
}

public class NumberOf1Bits {
    public static void main(String[] args) {
        BitCounter bitCounter = new BitCounter();

        // Test Case 1: 11 → Binary: 1011 → Expected: 3
        runTestCase(bitCounter, 11, 1);

        // Test Case 2: 6 → Binary: 110 → Expected: 2
        runTestCase(bitCounter, 6, 2);

        // Test Case 3: 1 → Binary: 1 → Expected: 1
        runTestCase(bitCounter, 1, 3);

        // Test Case 4: 255 → Binary: 11111111 → Expected: 8
        runTestCase(bitCounter, 255, 4);
    }

    private static void runTestCase(BitCounter bitCounter, int input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input   : " + input);
        System.out.println("  Binary  : " + Integer.toBinaryString(input));
        int result = bitCounter.numSetBits(input);
        System.out.println("  Output  : " + result);
        System.out.println();
    }
}