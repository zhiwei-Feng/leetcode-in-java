package org.example.leetcode;

public class n0680 {
    public boolean validPalindrome(String s) {
        var i = 0;
        var j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
                continue;
            }
            return isPalindrome(s.substring(i + 1, j + 1)) || isPalindrome(s.substring(i, j));
        }
        return true;
    }

    boolean isPalindrome(String s) {
        var i = 0;
        var j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
