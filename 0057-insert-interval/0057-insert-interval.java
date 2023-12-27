class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) return new int[][]{newInterval};

        int X = smallestGreater(intervals, newInterval[0]);
        int Y = greatestSmaller(intervals, newInterval[1]);

        // CHECK: if no X found. Means there is no interval that start after this start. So insert at end
        // Check if it can be merged with [last] interval
        if (X == -1) {
            // if last interval ends after this starts. Merge.
            int lastIdx = intervals.length - 1;
            if (intervals[lastIdx][1] >= newInterval[0]) {
                intervals[lastIdx] = new int[]{Math.min(newInterval[0], intervals[lastIdx][0]), Math.max(newInterval[1], intervals[lastIdx][1])};
                return intervals;
            }
            int[][] output = new int[intervals.length + 1][2];
            System.arraycopy(intervals, 0, output, 0, intervals.length);
            output[intervals.length] = newInterval;
            return output;
        }
        // CHECK: if no Y found. Means there is no interval that ends before this ends.
        // check if it can be merged with [0]th interval.
        if (Y == -1) {
            // if first interval starts before this ends. Merge.
            if (intervals[0][0] <= newInterval[1]) {
                intervals[0] = new int[]{Math.min(newInterval[0], intervals[0][0]), Math.max(newInterval[1], intervals[0][1])};
                return intervals;
            }
            int[][] output = new int[intervals.length + 1][2];
            output[0] = newInterval;
            System.arraycopy(intervals, 0, output, 1, intervals.length);
            return output;
        }

        // CHECK: some interval start after this start. But some other PRIOR ends before this ends.
        // Basically, this interval doesn't touch any other interval. So, insert it.
        if (X > Y) {
            if (X != Y + 1) {
                System.out.println("ERROR:: X = " + X + " :: Y = " + Y);
            }
            int[][] output = new int[intervals.length + 1][2];
            int k = 0;
            for (int i = 0; i <= Y; ++i)
                output[k++] = intervals[i];
            output[k++] = newInterval;
            for (int i = X; i < intervals.length; ++i)
                output[k++] = intervals[i];
            return output;
        }

        if (X == Y) {
            int[][] output = new int[intervals.length][2];
            for (int i = 0; i < X; ++i)
                output[i] = intervals[i];
            output[X] = new int[]{Math.min(newInterval[0], intervals[X][0]), Math.max(newInterval[1], intervals[X][1])};
            for (int i = X + 1; i < intervals.length; ++i)
                output[i] = intervals[i];
            return output;
        }

        // CHECK: X < Y => All intervals in range [X, ... , Y] will become one.
        int reducedBy = (Y - X + 1) - 1;
        int[][] output = new int[intervals.length - reducedBy][2];
        int k = 0;
        for (int i = 0; i < X; ++i) {
            output[k++] = intervals[i];
        }
        output[k++] = new int[]{Math.min(newInterval[0], intervals[X][0]), Math.max(newInterval[1], intervals[Y][1])};
        for (int i = Y + 1; i < intervals.length; ++i) {
            output[k++] = intervals[i];
        }
        return output;
    }

    // return the index, which either contains start OR is just right of start
    private int smallestGreater(int[][] intervals, int start) {
        int left = 0;
        int right = intervals.length - 1;
        int idx = -1;
        int mid;
        while (left <= right) {
            mid = left + (right - left + 1) / 2;
            // CHECK: if start is contained inside this interval
            if (start >= intervals[mid][0] && start <= intervals[mid][1])
                return mid;
            if (intervals[mid][0] > start) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return idx;
    }

    // return the index, which either contains end OR is just left of end
    private int greatestSmaller(int[][] intervals, int end) {
        int left = 0;
        int right = intervals.length - 1;
        int idx = -1;
        int mid;
        while (left <= right) {
            mid = left + (right - left + 1) / 2;
            // CHECK: if start is contained inside this interval
            if (end >= intervals[mid][0] && end <= intervals[mid][1])
                return mid;
            if (intervals[mid][1] < end) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return idx;
    }

}