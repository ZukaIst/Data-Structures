def longestPalindrome(self, s):
    from collections import Counter

    # Count the frequency of each character
    count = Counter(s)

    length = 0
    odd_found = False

    # Calculate the length of the longest palindrome
    for char, freq in count.items():
        if freq % 2 == 0:
            length += freq
        else:
            length += freq - 1
            odd_found = True

    # If there was any odd frequency, add one to the length for the center character
    if odd_found:
        length += 1

    return length