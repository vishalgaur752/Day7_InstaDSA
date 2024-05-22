import java.util.*;

public class MergeIntervals {
    public static int[][] maxIntervals(int intervals[][]) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, (arr1, arr2) -> arr1[0] - arr2[0]);
        List<int[]> output = new ArrayList<>();
        int[] curr = intervals[0];
        output.add(curr);

        for (int interval[] : intervals) {
            int currEnd = curr[1];
            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if (currEnd >= nextBegin) {
                curr[1] = Math.max(currEnd, nextEnd);
            } else {
                curr = interval;
                output.add(curr);
            }
        }
        return output.toArray(new int[output.size()][]);
    }

    public static void main(String[] args) {
        int intervals[][] = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int mergeIntervals[][] = maxIntervals(intervals);
        for (int interval[] : mergeIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}