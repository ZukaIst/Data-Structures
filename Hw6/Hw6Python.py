class Solution:
    # Merge sort function
    @staticmethod
    def merge_sort(arr, left, right):
        if left < right:
            mid = left + (right - left) // 2
            # Sort first and second halves
            Solution.merge_sort(arr, left, mid)
            Solution.merge_sort(arr, mid + 1, right)
            # Merge sorted halves
            Solution.merge(arr, left, mid, right)

    @staticmethod
    def merge(arr, left, mid, right):
        n1 = mid - left + 1
        n2 = right - mid

        # Initialize temporary arrays
        L = arr[left:mid + 1]
        R = arr[mid + 1:right + 1]

        i = 0
        j = 0
        k = left

        while i < len(L) and j < len(R):
            if L[i] <= R[j]:
                arr[k] = L[i]
                i += 1
            else:
                arr[k] = R[j]
                j += 1
            k += 1

        while i < len(L):
            arr[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            arr[k] = R[j]
            j += 1
            k += 1

    # Solution for the threeSum problem using merge sort
    @staticmethod
    def three_sum(nums):
        result = []
        # Sort the array using merge sort
        Solution.merge_sort(nums, 0, len(nums) - 1)

        for i in range(len(nums) - 2):
            # Avoid duplicates for the current value of i
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left = i + 1
            right = len(nums) - 1

            while left < right:
                sum_value = nums[i] + nums[left] + nums[right]

                if sum_value == 0:
                    result.append([nums[i], nums[left], nums[right]])

                    # Skip duplicates for the left pointer
                    while left < right and nums[left] == nums[left + 1]:
                        left += 1
                    # Skip duplicates for the right pointer
                    while left < right and nums[right] == nums[right - 1]:
                        right -= 1

                    left += 1
                    right -= 1
                elif sum_value < 0:
                    left += 1  # Need to increase the sum
                else:
                    right -= 1  # Need to decrease the sum

        return result

# Test case example
if __name__ == '__main__':
    nums = [-1, 0, 1, 2, -1, -4]
    results = Solution.three_sum(nums)
    print(results)  # Expected output: [[-1, -1, 2], [-1, 0, 1]]
