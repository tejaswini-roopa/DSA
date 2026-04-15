import java.util.*;

public class InsertInterval {

    static class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        int n = intervals.size();
        ArrayList<Interval> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Interval current = intervals.get(i);

            if (current.end < newInterval.start)
                result.add(current);

            else if (current.start > newInterval.end) {
                result.add(newInterval);
                for (int j = i; j < n; j++) {
                    result.add(intervals.get(j));
                }
                return result;
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
            }
        }

        result.add(newInterval);
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval newInterval = new Interval(2, 6);

        ArrayList<Interval> result = insert(intervals, newInterval);

        for (Interval in : result) {
            System.out.print("(" + in.start + ", " + in.end + ") ");
        }
    }
}