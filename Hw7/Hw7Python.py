import heapq

class Solution:
    def minMeetingRooms(self, intervals):
        # Base case: no meetings
        if not intervals:
            return 0

        # Sort the array by start time (Insertion Sort implementation)
        for i in range(1, len(intervals)):
            current = intervals[i]
            j = i - 1
            while j >= 0 and intervals[j][0] > current[0]:
                intervals[j + 1] = intervals[j]
                j -= 1
            intervals[j + 1] = current

        # Min-heap for tracking the end times of meetings
        heap = []

        # Add the first job to the heap
        heapq.heappush(heap, intervals[0][1])

        # Add the rest of the meetings or jobs
        for i in range(1, len(intervals)):
            # If the room is not overlapping, reuse the room
            if intervals[i][0] >= heap[0]:
                heapq.heappop(heap)
            # Add the current meeting end time to the heap
            heapq.heappush(heap, intervals[i][1])

        # Return the number of meeting rooms needed
        return len(heap)

# Test case example
if __name__ == '__main__':
    solution = Solution()
    intervals = [[0, 30], [5, 10], [15, 20]]
    print(solution.minMeetingRooms(intervals))  # Expected output: 2
