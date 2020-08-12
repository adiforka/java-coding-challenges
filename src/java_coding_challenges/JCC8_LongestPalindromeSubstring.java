package java_coding_challenges;


public class JCC8_LongestPalindromeSubstring {

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.findLPS("adogeeseseegodsacrebleu"));
        System.out.println("kayakkayak");
    }
}

class Solution {

    private int resultStart;
    private int resultLength;

    public String findLPS(String s) {

        for (int start = 0; start < s.length(); start++) {
            expandRange(s, start, start);
            expandRange(s, start, start + 1);
        }

        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String s, int start, int end) {

        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        //need to roll back the start/end values that failed the loop condition (+1, -1, respectively)
        String sub = s.substring(start + 1, end);
        if (sub.length() > resultLength) {
            resultStart = start + 1;
            resultLength = sub.length();
        }
    }
}
