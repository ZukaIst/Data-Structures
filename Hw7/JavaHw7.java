import java.util.PriorityQueue;

public class JavaHw7 {
    public int minMeetingRooms(int[][] intervals) {
        // have a base case for no meetings
        if (intervals == null || intervals.length == 0){
            return 0;
        }

        // sort the array by start time
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int j = i - 1;
            while (j >= 0 && intervals[j][0] > current[0]) {
                intervals[j + 1] = intervals[j];
                j--;
            }
            intervals[j + 1] = current;
        }

        // have a priority queue min-heap
        PriorityQueue<Integer> queueue = new PriorityQueue<>();

        // Add the first job to the heap
        queueue.add(intervals[0][1]);

        // a for loop to add the rest of the meetings or jobs
        for (int i = 1; i < intervals.length; i++){
            // when it's not overlapping we can re-use the room
            if ( intervals[i][0] >= queueue.peek()) {
                queueue.remove();
            }
            queueue.add(intervals[i][0]);
        }

        // return minimum meeting rooms needed
        return queueue.size();
    }
}
