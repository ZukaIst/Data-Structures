public class JavaHw2 {
    public static boolean isBadVersion(int version) {
        return version % 2 == 1;
    }

    public static int findGood(int[] n ) {
        //left boundary of the range
        int left = 1;
        // right boundary of the range
        int right = n.length - 1;
        // while loop to check while the left is less than the right
        while (left < right) {
            // find the current half
            int half = left + (right - left) / 2;
            // check if the half we found is bad
            if (isBadVersion(n[half])) {
                // if it is bad then we know it is on the left
                // then set the right range to the middle
                right = half;
            } else {
                // otherwise, set the left range to the middle
                left = half + 1;
            }
        }
        // return once we found the first bad
        return n[left];
    }
// once you find an odd number, everything after is considered bad
    public static void main(String[] args) {
        int[] v1 = {2, 4, 6, 8, 2, 11};
        System.out.println(findGood(v1));

        int[] v2 = {2, 2, 6, 3, 9, 11};
        System.out.println(findGood(v2));

        int[] v3 = {2, 2, 6, 8, 7, 11, 13};
        System.out.println(findGood(v3));
    }
}
