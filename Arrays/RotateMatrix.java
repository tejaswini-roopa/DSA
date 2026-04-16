import java.util.*;

class MatrixRotator {
    public void solve(ArrayList<ArrayList<Integer>> matrix) {
        int n = matrix.size();

        // Step 1: Transpose the matrix (swap across diagonal)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(j).get(i));
                matrix.get(j).set(i, temp);
            }
        }

        // Step 2: Reverse each row (to complete 90 degree clockwise rotation)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix.get(i).get(j);
                matrix.get(i).set(j, matrix.get(i).get(n - j - 1));
                matrix.get(i).set(n - j - 1, temp);
            }
        }
    }
}

public class RotateMatrix {
    public static void main(String[] args) {
        MatrixRotator matrixRotator = new MatrixRotator();

        // Test Case 1: 2x2 matrix
        ArrayList<ArrayList<Integer>> testCase1 = new ArrayList<>();
        testCase1.add(new ArrayList<>(Arrays.asList(1, 2)));
        testCase1.add(new ArrayList<>(Arrays.asList(3, 4)));
        runTestCase(matrixRotator, testCase1, 1);

        // Test Case 2: 3x3 matrix
        ArrayList<ArrayList<Integer>> testCase2 = new ArrayList<>();
        testCase2.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        testCase2.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        testCase2.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        runTestCase(matrixRotator, testCase2, 2);

        // Test Case 3: 4x4 matrix
        ArrayList<ArrayList<Integer>> testCase3 = new ArrayList<>();
        testCase3.add(new ArrayList<>(Arrays.asList(1,  2,  3,  4)));
        testCase3.add(new ArrayList<>(Arrays.asList(5,  6,  7,  8)));
        testCase3.add(new ArrayList<>(Arrays.asList(9,  10, 11, 12)));
        testCase3.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16)));
        runTestCase(matrixRotator, testCase3, 3);
    }

    private static void runTestCase(MatrixRotator rotator, ArrayList<ArrayList<Integer>> matrix, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  :");
        printMatrix(matrix);
        rotator.solve(matrix);
        System.out.println("  Output :");
        printMatrix(matrix);
        System.out.println();
    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (ArrayList<Integer> row : matrix) {
            System.out.print("  ");
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
}