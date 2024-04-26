def isBadVersion(version):
    return version % 2 == 1

def findGood(n):
    # left boundary of the range
    left = 0
    # right boundary of the range
    right = len(n) - 1

    # while loop to check while the left is less than the right
    while left < right:
        # find the current half
        half = left + (right - left) // 2
        # check if the half we found is bad
        if isBadVersion(n[half]):
            # if it is bad then we know it is on the left
            # then set the right range to the middle
            right = half
        else:
            # otherwise, set the left range to the middle
            left = half + 1

    # return once we found the first bad
    return n[left]

# once you find an odd number, everything after is considered bad
def main():
    v1 = [2, 4, 6, 8, 2, 11]
    print(findGood(v1))

    v2 = [2, 2, 6, 3, 9, 11]
    print(findGood(v2))

    v3 = [2, 2, 6, 8, 7, 11, 13]
    print(findGood(v3))

if __name__ == "__main__":
    main()
