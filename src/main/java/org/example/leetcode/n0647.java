package org.example.leetcode;

public class n0647 {
    public int countSubstrings(String s) {
        var ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += extend(s, i, i);
            if (i > 0) ans += extend(s, i - 1, i);
        }
        return ans;
    }

    int extend(String s, int start, int end) {
        int count = 0;
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
        return count;
    }
}
