public class JavaLab2 {
    public static void main(String[] args) {
        String s = "listen";
        String t = "silent";

        System.out.println("Is \"" + t + "\" an anagram of \"" + s + "\"? " + anagramic(s,t));
    }
    public static boolean anagramic (String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        // goes through each letter of string s
        for (int i=0; i< s.length(); i++) {
            // goes through the entire string t comparing s
            for (int j=0; j< s.length(); j++) {
                // if the current letter is not in t return false
                if (j == s.length() - 1 && s.charAt(i) != t.charAt(j)) {
                    return false;
                }
                // if you find the letter break the for loop and goes to the next letter n s
                if (s.charAt(i) == t.charAt(j)) {
                    break;
                }
            }
        }
        //return true if it goes through the whole string and matches the letters
        return true;
    }
}
