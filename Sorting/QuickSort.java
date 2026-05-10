import java.util.*;

public class QuickSort {
    public void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int index = partition(arr, low, high);
        quickSort(arr, low, index - 1);
        quickSort(arr, index + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int start = low + 1;
        int end = high;
        while (start <= end) {
            if (arr[start] <= arr[low]) {
                start++;
            } else if (arr[end] > arr[low]) {
                end--;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        int temp = arr[low];
        arr[low] = arr[start - 1];
        arr[start - 1] = temp;
        return start - 1;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();

        // Test Case 1: [1,4,10,2,1,5] → Expected: [1,1,2,4,5,10]
        int[] testCase1 = {1, 4, 10, 2, 1, 5};
        runTestCase(solution, testCase1, 1);

        // Test Case 2: [3,7,1] → Expected: [1,3,7]
        int[] testCase2 = {3, 7, 1};
        runTestCase(solution, testCase2, 2);

        // Test Case 3: [5,4,3,2,1] → Expected: [1,2,3,4,5]
        int[] testCase3 = {5, 4, 3, 2, 1};
        runTestCase(solution, testCase3, 3);

        // Test Case 4: [1] → Expected: [1]
        int[] testCase4 = {1};
        runTestCase(solution, testCase4, 4);
    }

    private static void runTestCase(QuickSort solution, int[] arr, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.print("  Input  : " + Arrays.toString(arr));