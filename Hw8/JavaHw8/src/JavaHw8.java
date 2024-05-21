import java.util.HashMap;
public class JavaHw8 {
    public int longestPalindrome(String s) {
        // Count the frequency of each character
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean odd = false;

        // Calculate the length of the longest palindrome
        for (int freq : count.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                odd = true;
            }
        }
        // If there was any odd frequency, add one to the length for the center character
        if (odd) {
            length += 1;
        }

        return length;
    }
}
