import java.lang.*;
import java.util.*;

public class PrintReverseString {
    public static void printing(String S, int n) {
        if (n < 0) return;

        System.out.print(S.charAt(n));
        printing(S, n - 1);
    }

    public static void main(String[] args) {
        // Test Case 1: "scaleracademy" → Expected: ymedacarelacs
        runTestCase("scaleracademy", 1);

        // Test Case 2: "cool" → Expected: looc
        runTestCase("cool", 2);

        // Test Case 3: "hello" → Expected: olleh
        runTestCase("hello", 3);

        // Test Case 4: "a" → Expected: a
        runTestCase("a", 4);
    }

    private static void runTestCase(String input, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + input);
        System.out.print("  Output : ");
        printing(input, input.length() - 1);
        System.out.println();
        System.out.println();
    }
}