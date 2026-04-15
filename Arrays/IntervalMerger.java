import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class IntervalMerger {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> mergedIntervals = new ArrayList<Interval>();

        // Sort intervals by start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        Interval currentInterval = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);

            if (currentInterval.end >= nextInterval.start) {
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }

        mergedIntervals.add(currentInterval);
        return mergedIntervals;
    }
}

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        IntervalMerger intervalMerger = new IntervalMerger();

        // Test Case 1: [1,3],[2,6],[8,10],[15,18]
        ArrayList<Interval> testCase1 = new ArrayList<>();
        testCase1.add(new Interval(1, 3));
        testCase1.add(new Interval(2, 6));
        testCase1.add(new Interval(8, 10));
        testCase1.add(new Interval(15, 18));
        runTestCase(intervalMerger, testCase1, 1);

        // Test Case 2: [1,4],[4,5]
        ArrayList<Interval> testCase2 = new ArrayList<>();
        testCase2.add(new Interval(1, 4));
        testCase2.add(new Interval(4, 5));
        runTestCase(intervalMerger, testCase2, 2);

        // Test Case 3: [1,10],[2,3],[4,8],[11,15]
        ArrayList<Interval> testCase3 = new ArrayList<>();
        testCase3.add(new Interval(1, 10));
        testCase3.add(new Interval(2, 3));
        testCase3.add(new Interval(4, 8));
        testCase3.add(new Interval(11, 15));
        runTestCase(intervalMerger, testCase3, 3);
    }

    private static void runTestCase(IntervalMerger merger, ArrayList<Interval> intervals, int testNumber) {
        System.out.println("Test Case " + testNumber + ":");
        System.out.println("  Input  : " + intervals);
        ArrayList<Interval> result = merger.merge(intervals);
        System.out.println("  Output : " + result);
        System.out.println();
    }
}